package com.fuze.coreuc.schiaparelli.models;

public class QueueCall {
	private long count;
	private String calleridname;
	private String calleridnum;
	private String linkedId;
	private long holdtime;
	private long originalPosition;
	private String queueName;
	private String uniqueId;
	private String action;
	private long position;
	private String hostname;
	private long timestamp;

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public String getCalleridname() {
		return calleridname;
	}

	public void setCalleridname(String calleridname) {
		this.calleridname = calleridname;
	}

	public String getCalleridnum() {
		return calleridnum;
	}

	public void setCalleridnum(String calleridnum) {
		this.calleridnum = calleridnum;
	}

	public String getLinkedId() {
		return linkedId;
	}

	public void setLinkedId(String linkedId) {
		this.linkedId = linkedId;
	}

	public long getHoldtime() {
		return holdtime;
	}

	public void setHoldtime(long holdtime) {
		this.holdtime = holdtime;
	}

	public long getOriginalPosition() {
		return originalPosition;
	}

	public void setOriginalPosition(long originalPosition) {
		this.originalPosition = originalPosition;
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public long getPosition() {
		return position;
	}

	public void setPosition(long position) {
		this.position = position;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}
