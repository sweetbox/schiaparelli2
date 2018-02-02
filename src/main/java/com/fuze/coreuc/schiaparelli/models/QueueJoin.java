package com.fuze.coreuc.schiaparelli.models;

public class QueueJoin extends Queue {
	private long count;
	private String calleridname;
	private String calleridnum;
	private String linkedId;

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
}