package com.fuze.coreuc.schiaparelli.models;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QueueSummary {
  	private String actionid;
  	private String queuePbx;
	private long lastCall;
	private String queue;
	private String holdtime;
	private String loggedin;
	private String event;
	private String callers;
	private long dateReceived;
	private String longestholdtime;
	private String available;
	private String talktime;

	public String getQueuePbx() {
		return queuePbx;
	}

	public void setQueuePbx(String queuePbx) {
		this.queuePbx = queuePbx;
	}

	public long getLastCall() {
		return lastCall;
	}

	public void setLastCall(long lastCall) {
		this.lastCall = lastCall;
	}

	public String getActionid() {
		return actionid;
	}

	public void setActionid(String actionid) {
		this.actionid = actionid;
	}

	public String getQueue() {
		return queue;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}

	public String getHoldtime() {
		return holdtime;
	}

	public void setHoldtime(String holdtime) {
		this.holdtime = holdtime;
	}

	public String getLoggedin() {
		return loggedin;
	}

	public void setLoggedin(String loggedin) {
		this.loggedin = loggedin;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getCallers() {
		return callers;
	}

	public void setCallers(String callers) {
		this.callers = callers;
	}

	public long getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(long dateReceived) {
		this.dateReceived = dateReceived;
	}

	public String getLongestholdtime() {
		return longestholdtime;
	}

	public void setLongestholdtime(String longestholdtime) {
		this.longestholdtime = longestholdtime;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public String getTalktime() {
		return talktime;
	}

	public void setTalktime(String talktime) {
		this.talktime = talktime;
	}
}
