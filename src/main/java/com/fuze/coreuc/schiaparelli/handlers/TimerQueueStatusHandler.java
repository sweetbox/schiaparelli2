package com.fuze.coreuc.schiaparelli.handlers;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import com.amazonaws.services.lambda.runtime.Context;
import com.fuze.coreuc.schiaparelli.datastores.DataServiceStore;
import com.fuze.coreuc.schiaparelli.datastores.DynamoDBStore;
import com.fuze.coreuc.schiaparelli.datastores.SynapseStore;
import com.fuze.coreuc.schiaparelli.exceptions.InternalErrorException;
import com.fuze.coreuc.schiaparelli.exceptions.InvalidRequestException;
import com.fuze.coreuc.schiaparelli.models.QueueMembers;
import com.fuze.coreuc.schiaparelli.models.QueueStatus;
import com.fuze.coreuc.schiaparelli.models.User;

import okhttp3.OkHttpClient;

public class TimerQueueStatusHandler {
	public static void lambdaHandler(InputStream request, OutputStream response, Context context) throws InvalidRequestException, InternalErrorException {
		OkHttpClient okHttpClient = new OkHttpClient();
		SynapseStore synapseStore = new SynapseStore(okHttpClient);
		QueueStatus queueStatus = synapseStore.getStatus("ucapps1-queue1");
		if (queueStatus != null) {
			DynamoDBStore dynamoDBStore = new DynamoDBStore();
			DataServiceStore dataServiceStore = new DataServiceStore(okHttpClient);
			Date date = new Date();
			dynamoDBStore.storeQueueStatus(date.getTime(), queueStatus);

			for (QueueMembers queueMembers : queueStatus.getMembers()) {
				User user = dataServiceStore.getUser(queueMembers.getName());
				queueMembers.setName(user.getLdapId());
			}
			dynamoDBStore.storeMembersStatus(date.getTime(), queueStatus.getMembers());
		}
		return;
	}
}
