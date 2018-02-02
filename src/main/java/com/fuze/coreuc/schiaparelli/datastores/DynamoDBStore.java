package com.fuze.coreuc.schiaparelli.datastores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.dynamodbv2.model.UpdateItemRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateItemResult;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.util.StringUtils;
import com.fuze.coreuc.schiaparelli.models.QueueAbandon;
import com.fuze.coreuc.schiaparelli.models.QueueCall;
import com.fuze.coreuc.schiaparelli.models.QueueJoin;
import com.fuze.coreuc.schiaparelli.models.QueueLeave;
import com.fuze.coreuc.schiaparelli.models.QueueMembers;
import com.fuze.coreuc.schiaparelli.models.QueueStatus;
import com.fuze.coreuc.schiaparelli.models.QueueSummary;
import com.fuze.coreuc.schiaparelli.models.StateChange;

public class DynamoDBStore {

	private static final String COL_UNIQUEID= "uniqueId";
	private static final String COL_COUNT = "count";
	private static final String COL_CALLERIDNAME = "calleridname";
	private static final String COL_CALLERIDNUM = "calleridnum";
	private static final String COL_LINKEDID = "linkedId";
	private static final String COL_HOLDTIME = "holdtime";
	private static final String COL_ORIGINALPOSITION = "originalPosition";
	private static final String COL_QUEUENAME = "queueName";
	private static final String COL_UNIQUE = "uniqueId";
	private static final String COL_ACTION = "action";
	private static final String COL_POSITION = "position";
	private static final String COL_HOSTNAME = "hostname";
	private static final String COL_TIMESTAMP = "timestamp";

	private AmazonDynamoDB client;

	public DynamoDBStore() {
		client = AmazonDynamoDBClientBuilder
					.standard()
					.withRegion(Regions.US_EAST_1)
					.withCredentials(new DefaultAWSCredentialsProviderChain())
					.build();
	}

	private AttributeValue setString(String value) {
		AttributeValue attributeValue = new AttributeValue();
		attributeValue.setS(value);
		return attributeValue;
	}

	private AttributeValue setLong(long value) {
		AttributeValue attributeValue = new AttributeValue();
		attributeValue.setN(Long.toString(value));
		return attributeValue;
	}

	private AttributeValueUpdate setUpdateValue(String value) {
		AttributeValueUpdate attributeValueUpdate = new AttributeValueUpdate();
		attributeValueUpdate.setValue(setString(value));
		return attributeValueUpdate;
	}

	private AttributeValueUpdate setUpdateValue(long value) {
		AttributeValueUpdate attributeValueUpdate = new AttributeValueUpdate();
		attributeValueUpdate.setValue(setLong(value));
		return attributeValueUpdate;
	}

	private AttributeValue setValue(String value) {
		AttributeValue attributeValue = new AttributeValue();
		attributeValue.setS(value);
		return attributeValue;
	}

	private AttributeValue setValue(long value) {
		AttributeValue attributeValue = new AttributeValue();
		attributeValue.setN(Long.toString(value));
		return attributeValue;
	}

	public void storeQueueSummary(QueueSummary queueSummary) {
		PutItemRequest putItemRequest = new PutItemRequest();

		putItemRequest.setTableName("synapse_queue_summary");

		Map<String, AttributeValue> updates = new HashMap<>();
		updates.putIfAbsent("id", setString(UUID.randomUUID().toString()));
		updates.putIfAbsent("queue", setValue(queueSummary.getQueue()));
		updates.putIfAbsent("callers", setValue(queueSummary.getCallers()));
		updates.putIfAbsent("queuePbx", setValue(queueSummary.getQueuePbx()));
		updates.putIfAbsent("lastCall", setValue(queueSummary.getLastCall()));
		updates.putIfAbsent("actionId", setValue(queueSummary.getActionid()));
		updates.putIfAbsent("queue", setValue(queueSummary.getQueue()));
		updates.putIfAbsent("holdTime", setValue(queueSummary.getHoldtime()));
		updates.putIfAbsent("loggedIn", setValue(queueSummary.getLoggedin()));
		updates.putIfAbsent("event", setValue(queueSummary.getEvent()));
		updates.putIfAbsent("callers", setValue(queueSummary.getCallers()));
		updates.putIfAbsent("dataReceived", setValue(queueSummary.getDateReceived()));
		updates.putIfAbsent("longestHoldTime", setValue(queueSummary.getLongestholdtime()));
		updates.putIfAbsent("available", setValue(queueSummary.getAvailable()));
		updates.putIfAbsent("talkTime", setValue(queueSummary.getTalktime()));
		putItemRequest.withItem(updates);

		PutItemResult putItemResult = client.putItem(putItemRequest);
	}

	public void storeQueueStatus(long timeStamp, QueueStatus queueStatus) {
		PutItemRequest putItemRequest = new PutItemRequest();

		putItemRequest.setTableName("synapse_queue_status");

		Map<String, AttributeValue> updates = new HashMap<>();
		updates.putIfAbsent("id", setString(UUID.randomUUID().toString()));
		updates.putIfAbsent("timestamp", setValue(timeStamp));
		updates.putIfAbsent("avgHoldTime", setValue(queueStatus.getAvgHoldTime()));
		updates.putIfAbsent("callsWaiting", setValue(queueStatus.getCallsWaiting()));
		updates.putIfAbsent("maxWaiting", setValue(queueStatus.getMaxWaiting()));
		updates.putIfAbsent("name", setValue(queueStatus.getName()));
		updates.putIfAbsent("numAbandoned", setValue(queueStatus.getNumAbandoned()));
		updates.putIfAbsent("numCompleted", setValue(queueStatus.getNumCompleted()));
		updates.putIfAbsent("queuePbx", setValue(queueStatus.getQueuePbx()));
		updates.putIfAbsent("serviceLevel", setValue(queueStatus.getServiceLevel()));
		updates.putIfAbsent("serviceLevelPerf", setValue(queueStatus.getServiceLevelPerf()));
		updates.putIfAbsent("tenantId", setValue(queueStatus.getTenantId()));
		updates.putIfAbsent("weight", setValue(queueStatus.getWeight()));

		putItemRequest.withItem(updates);

		PutItemResult putItemResult = client.putItem(putItemRequest);
	}

	public void storeMembersStatus(long timeStamp, List<QueueMembers> queueMemberList) {
		PutItemRequest putItemRequest = new PutItemRequest();

		putItemRequest.setTableName("synapse_queue_member_status");

		for (QueueMembers queueMember : queueMemberList) {
			Map<String, AttributeValue> updates = new HashMap<>();
			updates.putIfAbsent("timestamp", setValue(timeStamp));
			updates.putIfAbsent("callsTaken", setValue(queueMember.getCallsTaken()));
			updates.putIfAbsent("lastCall", setValue(queueMember.getLastCall()));
			updates.putIfAbsent("location", setValue(queueMember.getLocation()));
			updates.putIfAbsent("locationType", setValue(queueMember.getLocationType()));
			updates.putIfAbsent("membership", setValue(queueMember.getMembership()));
			updates.putIfAbsent("name", setValue(queueMember.getName()));
			updates.putIfAbsent("penalty", setValue(queueMember.getPenalty()));
			updates.putIfAbsent("queue", setValue(queueMember.getQueue()));
			updates.putIfAbsent("status", setValue(queueMember.getStatus()));

			putItemRequest.withItem(updates);

			PutItemResult putItemResult = client.putItem(putItemRequest);
		}
	}

	public List<StateChange> getUsers() {
		List<StateChange> userStates = new ArrayList<>();
		Map<String, AttributeValue> lastKeyEvaluated = null;
		do {
			ScanRequest scanRequest = new ScanRequest()
					.withTableName("synapse_queue_users")
					.withLimit(10)
					.withExclusiveStartKey(lastKeyEvaluated);

			ScanResult result = client.scan(scanRequest);
			for (Map<String, AttributeValue> item : result.getItems()){
				StateChange stateChange = new StateChange();
				if (item.containsKey("userId")) {
					stateChange.setUserId(item.get("userId").getS());
				}
				if (item.containsKey("queueName")) {
					stateChange.setQueueName(item.get("queueName").getS());
				}
				if (item.containsKey("state")) {
					stateChange.setState(item.get("state").getS());
				}
				if (item.containsKey("tenantId")) {
					stateChange.setTenantId(item.get("tenantId").getS());
				}
				if (item.containsKey("timestamp")) {
					AttributeValue value = item.get("timestamp");
					if (value != null && !StringUtils.isNullOrEmpty(value.getN()) && 0 != value.getN().compareTo("NULL")) {
						stateChange.setTimestamp(Long.parseLong(value.getN()));
					} else {
						stateChange.setTimestamp(0);
					}
				}
				if (item.containsKey("queueInterface")) {
					stateChange.setQueueInterface(item.get("queueInterface").getS());
				}
				userStates.add(stateChange);
			}
			lastKeyEvaluated = result.getLastEvaluatedKey();
		} while (lastKeyEvaluated != null);
		return userStates;
	}

	private QueueCall mapToQueueCall(Map<String, AttributeValue> item) {
		QueueCall queueCall = new QueueCall();
		if (item.containsKey(COL_COUNT)) {
			AttributeValue value = item.get(COL_COUNT);
			if (value != null && !StringUtils.isNullOrEmpty(value.getN()) && 0 != value.getN().compareTo("NULL")) {
				queueCall.setCount(Long.parseLong(value.getN()));
			} else {
				queueCall.setCount(0);
			}
		}
		if (item.containsKey(COL_CALLERIDNAME)) {
			queueCall.setCalleridname(item.get(COL_CALLERIDNAME).getS());
		}
		if (item.containsKey(COL_CALLERIDNUM)) {
			queueCall.setCalleridnum(item.get(COL_CALLERIDNUM).getS());
		}
		if (item.containsKey(COL_LINKEDID)) {
			queueCall.setLinkedId(item.get(COL_LINKEDID).getS());
		}
		if (item.containsKey(COL_HOLDTIME)) {
			AttributeValue value = item.get(COL_HOLDTIME);
			if (value != null && !StringUtils.isNullOrEmpty(value.getN()) && 0 != value.getN().compareTo("NULL")) {
				queueCall.setHoldtime(Long.parseLong(value.getN()));
			} else {
				queueCall.setHoldtime(0);
			}
		}
		if (item.containsKey(COL_ORIGINALPOSITION)) {
			AttributeValue value = item.get(COL_ORIGINALPOSITION);
			if (value != null && !StringUtils.isNullOrEmpty(value.getN())) {
				queueCall.setOriginalPosition(Long.parseLong(value.getN()));
			} else {
				queueCall.setOriginalPosition(0);
			}
		}
		if (item.containsKey(COL_QUEUENAME)) {
			queueCall.setQueueName(item.get(COL_QUEUENAME).getS());
		}
		if (item.containsKey(COL_UNIQUE)) {
			queueCall.setUniqueId(item.get(COL_UNIQUE).getS());
		}
		if (item.containsKey(COL_ACTION)) {
			queueCall.setAction(item.get(COL_ACTION).getS());
		}
		if (item.containsKey(COL_POSITION)) {
			AttributeValue value = item.get(COL_POSITION);
			if (value != null && !StringUtils.isNullOrEmpty(value.getN()) && 0 != value.getN().compareTo("NULL")) {
				queueCall.setPosition(Long.parseLong(value.getN()));
			} else {
				queueCall.setPosition(0);
			}
		}
		if (item.containsKey(COL_HOSTNAME)) {
			queueCall.setHostname(item.get(COL_HOSTNAME).getS());
		}
		if (item.containsKey(COL_TIMESTAMP)) {
			AttributeValue value = item.get(COL_TIMESTAMP);
			if (value != null && !StringUtils.isNullOrEmpty(value.getN()) && 0 != value.getN().compareTo("NULL")) {
				queueCall.setTimestamp(Long.parseLong(value.getN()));
			} else {
				queueCall.setTimestamp(0);
			}
		}
		return queueCall;
	}

	private List<String> getCallColumns() {
		return Arrays.asList(
				COL_COUNT,
				COL_CALLERIDNAME,
				COL_CALLERIDNUM,
				COL_LINKEDID,
				COL_HOLDTIME,
				COL_ORIGINALPOSITION,
				COL_QUEUENAME,
				COL_UNIQUE,
				COL_ACTION,
				COL_POSITION,
				COL_HOSTNAME,
				COL_TIMESTAMP);
	}

	public List<QueueCall> getCalls() {

		List<QueueCall> queueCalls = new ArrayList<>();
		Map<String, AttributeValue> lastKeyEvaluated = null;
		do {
			ScanRequest scanRequest = new ScanRequest()
					.withTableName("synapse_queue_calls")
					.withLimit(10)
					.withExclusiveStartKey(lastKeyEvaluated);

			ScanResult result = client.scan(scanRequest);
			for (Map<String, AttributeValue> item : result.getItems()){
				queueCalls.add(mapToQueueCall(item));
			}
			lastKeyEvaluated = result.getLastEvaluatedKey();
		} while (lastKeyEvaluated != null);
		return queueCalls;
	}

	public UpdateItemResult storeUserState(StateChange stateChangeEvent) {

		Map<String, AttributeValueUpdate> updates = new HashMap<>();
		updates.putIfAbsent("id", setUpdateValue(UUID.randomUUID().toString()));

		updates.putIfAbsent("queueName", setUpdateValue(stateChangeEvent.getQueueName()));
		updates.putIfAbsent("state", setUpdateValue(stateChangeEvent.getState()));
		updates.putIfAbsent("tenantId", setUpdateValue(stateChangeEvent.getTenantId()));
		updates.putIfAbsent("timestamp", setUpdateValue(stateChangeEvent.getTimestamp()));
		updates.putIfAbsent("queueInterface", setUpdateValue(stateChangeEvent.getQueueInterface()));

		UpdateItemRequest updateItemRequest = new UpdateItemRequest();

		updateItemRequest.withTableName("synapse_queue_users");
		updateItemRequest.withAttributeUpdates(updates);
		Map<String, AttributeValue> keys = new HashMap<>();
		keys.putIfAbsent("userId", setValue(stateChangeEvent.getUserId()));

		updateItemRequest.withKey(keys);

		return client.updateItem(updateItemRequest);
	}

	public QueueCall getCall(String uniqueId) {

		GetItemRequest getItemRequest = new GetItemRequest();
		getItemRequest.setTableName("synapse_queue_calls");

		getItemRequest.addKeyEntry(COL_UNIQUEID, setValue(uniqueId));

		getItemRequest.setAttributesToGet(getCallColumns());
		GetItemResult getItemResult = client.getItem(getItemRequest);

		if (getItemResult.getItem() == null || getItemResult.getItem().size() == 0) {
			return null;        // not existed.
		}

		return mapToQueueCall(getItemResult.getItem());
	}

	public UpdateItemResult storeJoinState(QueueJoin queueJoin) {

		QueueCall queueCall = getCall(queueJoin.getUniqueId());

		if (queueCall != null && queueCall.getTimestamp() >= queueJoin.getTimestamp()) {
			return null;
		}

		Map<String, AttributeValueUpdate> updates = new HashMap<>();

		updates.putIfAbsent(COL_CALLERIDNAME, setUpdateValue(queueJoin.getCalleridname()));
		updates.putIfAbsent(COL_CALLERIDNUM, setUpdateValue(queueJoin.getCalleridnum()));
		updates.putIfAbsent(COL_COUNT, setUpdateValue(queueJoin.getCount()));
		updates.putIfAbsent(COL_LINKEDID, setUpdateValue(queueJoin.getLinkedId()));
		updates.putIfAbsent(COL_ACTION, setUpdateValue(queueJoin.getAction()));
		updates.putIfAbsent(COL_HOSTNAME, setUpdateValue(queueJoin.getHostname()));
		updates.putIfAbsent(COL_POSITION, setUpdateValue(queueJoin.getPosition()));
		updates.putIfAbsent(COL_QUEUENAME, setUpdateValue(queueJoin.getQueueName()));
		updates.putIfAbsent(COL_TIMESTAMP, setUpdateValue(queueJoin.getTimestamp()));
		updates.putIfAbsent(COL_LINKEDID, setUpdateValue(queueJoin.getLinkedId()));

		UpdateItemRequest updateItemRequest = new UpdateItemRequest();
		updateItemRequest.setTableName("synapse_queue_calls");
		updateItemRequest.setAttributeUpdates(updates);
		updateItemRequest.addKeyEntry(COL_UNIQUEID, setValue(queueJoin.getUniqueId()));

		return client.updateItem(updateItemRequest);
	}

	public UpdateItemResult storeLeaveState(QueueLeave queueLeave) {

		QueueCall queueCall = getCall(queueLeave.getUniqueId());

		if (queueCall != null && queueLeave.getTimestamp() >= queueLeave.getTimestamp()) {
			return null;
		}

		Map<String, AttributeValueUpdate> updates = new HashMap<>();

		updates.putIfAbsent(COL_COUNT, setUpdateValue(queueLeave.getCount()));
		updates.putIfAbsent(COL_LINKEDID, setUpdateValue(queueLeave.getLinkedId()));
		updates.putIfAbsent(COL_ACTION, setUpdateValue(queueLeave.getAction()));
		updates.putIfAbsent(COL_HOSTNAME, setUpdateValue(queueLeave.getHostname()));
		updates.putIfAbsent(COL_POSITION, setUpdateValue(queueLeave.getPosition()));
		updates.putIfAbsent(COL_QUEUENAME, setUpdateValue(queueLeave.getQueueName()));
		updates.putIfAbsent(COL_TIMESTAMP, setUpdateValue(queueLeave.getTimestamp()));
		updates.putIfAbsent(COL_LINKEDID, setUpdateValue(queueLeave.getLinkedId()));

		UpdateItemRequest updateItemRequest = new UpdateItemRequest();
		updateItemRequest.setTableName("synapse_queue_calls");
		updateItemRequest.setAttributeUpdates(updates);
		updateItemRequest.addKeyEntry(COL_UNIQUEID, setValue(queueLeave.getUniqueId()));

		return client.updateItem(updateItemRequest);
	}

	public UpdateItemResult storeAbandonState(QueueAbandon queueAbandon) {

		QueueCall queueCall = getCall(queueAbandon.getUniqueId());

		if (queueCall != null && queueAbandon.getTimestamp() >= queueAbandon.getTimestamp()) {
			return null;
		}

		Map<String, AttributeValueUpdate> updates = new HashMap<>();

		updates.putIfAbsent(COL_HOLDTIME, setUpdateValue(queueAbandon.getHoldtime()));
		updates.putIfAbsent(COL_ORIGINALPOSITION, setUpdateValue(queueAbandon.getOriginalPosition()));
		updates.putIfAbsent(COL_ACTION, setUpdateValue(queueAbandon.getAction()));
		updates.putIfAbsent(COL_HOSTNAME, setUpdateValue(queueAbandon.getHostname()));
		updates.putIfAbsent(COL_POSITION, setUpdateValue(queueAbandon.getPosition()));
		updates.putIfAbsent(COL_QUEUENAME, setUpdateValue(queueAbandon.getQueueName()));
		updates.putIfAbsent(COL_TIMESTAMP, setUpdateValue(queueAbandon.getTimestamp()));

		UpdateItemRequest updateItemRequest = new UpdateItemRequest();
		updateItemRequest.setTableName("synapse_queue_calls");
		updateItemRequest.setAttributeUpdates(updates);
		updateItemRequest.addKeyEntry(COL_UNIQUEID, setValue(queueAbandon.getUniqueId()));

		return client.updateItem(updateItemRequest);
	}


}
