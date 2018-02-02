package com.fuze.coreuc.schiaparelli.handlers;

import java.io.InputStream;
import java.io.OutputStream;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.fuze.coreuc.schiaparelli.datastores.DynamoDBStore;
import com.fuze.coreuc.schiaparelli.datastores.SynapseStore;
import com.fuze.coreuc.schiaparelli.exceptions.InternalErrorException;
import com.fuze.coreuc.schiaparelli.exceptions.InvalidRequestException;
import com.fuze.coreuc.schiaparelli.models.QueueSummary;

import okhttp3.OkHttpClient;

public class TimerQueueSummaryHandler {
	public static void lambdaHandler(InputStream request, OutputStream response, Context context) throws InvalidRequestException, InternalErrorException {
		LambdaLogger logger = context.getLogger();
		logger.log("works!");
		OkHttpClient okHttpClient = new OkHttpClient();
		SynapseStore synapseStore = new SynapseStore(okHttpClient);
		QueueSummary queueSummary = synapseStore.getSummary("ucapps1-queue1");
		if (queueSummary != null) {
			DynamoDBStore dynamoDBStore = new DynamoDBStore();
			dynamoDBStore.storeQueueSummary(queueSummary);
		}
		return;
	}
}
