package com.fuze.coreuc.schiaparelli.models;

public class QueueLeave extends Queue{
	private long count;
	private String linkedId;

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public String getLinkedId() {
		return linkedId;
	}

	public void setLinkedId(String linkedId) {
		this.linkedId = linkedId;
	}
}
