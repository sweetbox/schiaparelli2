package com.fuze.coreuc.schiaparelli.models;

public class QueueAbandon extends Queue {
	private long holdtime;
	private long originalPosition;

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
}
