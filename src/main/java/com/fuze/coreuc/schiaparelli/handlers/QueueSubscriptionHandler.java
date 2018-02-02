package com.fuze.coreuc.schiaparelli.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.dynamodbv2.model.UpdateItemResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuze.coreuc.schiaparelli.datastores.DynamoDBStore;
import com.fuze.coreuc.schiaparelli.exceptions.InternalErrorException;
import com.fuze.coreuc.schiaparelli.exceptions.InvalidRequestException;
import com.fuze.coreuc.schiaparelli.mappers.MapperQueueAbandon;
import com.fuze.coreuc.schiaparelli.mappers.MapperQueueJoin;
import com.fuze.coreuc.schiaparelli.mappers.MapperQueueLeave;
import com.fuze.coreuc.schiaparelli.mappers.MapperQueueStageChange;
import com.fuze.coreuc.schiaparelli.models.QueueAbandon;
import com.fuze.coreuc.schiaparelli.models.QueueJoin;
import com.fuze.coreuc.schiaparelli.models.QueueLeave;
import com.fuze.coreuc.schiaparelli.models.StateChange;

public class QueueSubscriptionHandler {

	private static ObjectMapper mapper = new ObjectMapper();

	public static void lambdaHandler(InputStream request, OutputStream response, Context context)
			throws InvalidRequestException, InternalErrorException {
		LambdaLogger logger = context.getLogger();

		String input;
		try {
			input = IOUtils.toString(request, Charset.defaultCharset());
		} catch (IOException e) {
			throw new InternalErrorException(e.getMessage());
		}

		StateChange stateChange = MapperQueueStageChange.read(mapper, input);
		if (stateChange != null) {
			logger.log("State Change Event");
			DynamoDBStore dynamoDBStore = new DynamoDBStore();
			UpdateItemResult updateItemResult = dynamoDBStore.storeUserState(stateChange);
			if (updateItemResult == null) {
				logger.log("failed to store user state");
			}
			return;
		}

		try {
			QueueJoin queueJoin = MapperQueueJoin.read(mapper, input);
			logger.log("Queue Join Event");
			DynamoDBStore dynamoDBStore = new DynamoDBStore();
			UpdateItemResult updateItemResult = dynamoDBStore.storeJoinState(queueJoin);
			if (updateItemResult == null) {
				logger.log("failed to store queue join");
			}
			return;
		} catch (IOException e) {
		}

		try {
			QueueLeave queueLeave = MapperQueueLeave.read(mapper, input);
			logger.log("Queue Leave Event");
			DynamoDBStore dynamoDBStore = new DynamoDBStore();
			UpdateItemResult updateItemResult = dynamoDBStore.storeLeaveState(queueLeave);
			if (updateItemResult == null) {
				logger.log("failed to store queue leave");
			}
			return;
		} catch (IOException e) {
		}

		try {
			QueueAbandon queueAbandon = MapperQueueAbandon.read(mapper, input);
			logger.log("Queue Abandon Event");
			DynamoDBStore dynamoDBStore = new DynamoDBStore();
			UpdateItemResult updateItemResult = dynamoDBStore.storeAbandonState(queueAbandon);
			if (updateItemResult == null) {
				logger.log("failed to store queue abandon");
			}
			return;
		} catch (IOException e) {
		}

		logger.log("Failed to parse event");
	}

	public static void restGetUsersHandler(InputStream request, OutputStream response, Context context)
			throws InvalidRequestException, InternalErrorException {
		LambdaLogger logger = context.getLogger();
		try {
			DynamoDBStore dynamoDBStore = new DynamoDBStore();
			IOUtils.write(mapper.writeValueAsString(dynamoDBStore.getUsers()), response, "UTF-8");
			response.flush();
			response.close();
		} catch (IOException e) {
			logger.log("failed to write response " + e.getMessage());
			throw new InternalErrorException(e.getMessage());
		}
	}

	public static void restGetCallsHandler(InputStream request, OutputStream response, Context context)
			throws InvalidRequestException, InternalErrorException {
		LambdaLogger logger = context.getLogger();
		try {
			DynamoDBStore dynamoDBStore = new DynamoDBStore();
			IOUtils.write(mapper.writeValueAsString(dynamoDBStore.getCalls()), response, "UTF-8");
			response.flush();
			response.close();
		} catch (IOException e) {
			logger.log("failed to write response " + e.getMessage());
			throw new InternalErrorException(e.getMessage());
		}
	}
}