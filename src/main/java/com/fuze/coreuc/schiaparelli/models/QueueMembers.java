package com.fuze.coreuc.schiaparelli.models;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QueueMembers {
	private String name;
	private long lastCall;
	private String location;
	private String membership;
	private long penalty;
	private long callsTaken;
	private boolean paused;
	private long status;
	private String queue;
	private String locationType;

	public long getLastCall() {
		return lastCall;
	}

	public void setLastCall(long lastCall) {
		this.lastCall = lastCall;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMembership() {
		return membership;
	}

	public void setMembership(String membership) {
		this.membership = membership;
	}

	public long getPenalty() {
		return penalty;
	}

	public void setPenalty(long penalty) {
		this.penalty = penalty;
	}

	public long getCallsTaken() {
		return callsTaken;
	}

	public void setCallsTaken(long callsTaken) {
		this.callsTaken = callsTaken;
	}

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public String getQueue() {
		return queue;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
}
