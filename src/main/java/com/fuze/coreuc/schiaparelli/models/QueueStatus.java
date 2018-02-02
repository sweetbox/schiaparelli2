package com.fuze.coreuc.schiaparelli.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QueueStatus {
	private String name;
	private String queuePbx;
	private long maxWaiting;
	private long callsWaiting;
	private long avgHoldTime;
	private long numCompleted;
	private long numAbandoned;
	private long serviceLevel;
	private long serviceLevelPerf;
	private long weight;
	private List<QueueMembers> members;
	private String tenantId;

	public String getQueuePbx() {
		return queuePbx;
	}

	public void setQueuePbx(String queuePbx) {
		this.queuePbx = queuePbx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMaxWaiting() {
		return maxWaiting;
	}

	public void setMaxWaiting(long maxWaiting) {
		this.maxWaiting = maxWaiting;
	}

	public long getCallsWaiting() {
		return callsWaiting;
	}

	public void setCallsWaiting(long callsWaiting) {
		this.callsWaiting = callsWaiting;
	}

	public long getAvgHoldTime() {
		return avgHoldTime;
	}

	public void setAvgHoldTime(long avgHoldTime) {
		this.avgHoldTime = avgHoldTime;
	}

	public long getNumCompleted() {
		return numCompleted;
	}

	public void setNumCompleted(long numCompleted) {
		this.numCompleted = numCompleted;
	}

	public long getNumAbandoned() {
		return numAbandoned;
	}

	public void setNumAbandoned(long numAbandoned) {
		this.numAbandoned = numAbandoned;
	}

	public long getServiceLevel() {
		return serviceLevel;
	}

	public void setServiceLevel(long serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	public long getServiceLevelPerf() {
		return serviceLevelPerf;
	}

	public void setServiceLevelPerf(long serviceLevelPerf) {
		this.serviceLevelPerf = serviceLevelPerf;
	}

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

	public List<QueueMembers> getMembers() {
		return members;
	}

	public void setMembers(List<QueueMembers> members) {
		this.members = members;
	}
	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

}
