package com.fuze.coreuc.schiaparelli.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Event {

	private String queueName;
	private String tenantId;
	private String userId;
	private String queueInterface;
	private Integer count;
	private String uniqueId;
	private String linkedId;
	private Action action;
	private Integer position;
	private Integer holdtime;
	private Integer originalPosition;
	private String calleridname;
	private String calleridnum;
	private String connectedlinename;
	private String connectedlinenum;
	private String hostname;
	private Long id;
	private Long timestamp;
	private String state;

	public enum Action {
		JOIN, LEAVE, ABANDON
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getQueueInterface() {
		return queueInterface;
	}

	public void setQueueInterface(String queueInterface) {
		this.queueInterface = queueInterface;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getLinkedId() {
		return linkedId;
	}

	public void setLinkedId(String linkedId) {
		this.linkedId = linkedId;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Integer getHoldtime() {
		return holdtime;
	}

	public void setHoldtime(Integer holdtime) {
		this.holdtime = holdtime;
	}

	public Integer getOriginalPosition() {
		return originalPosition;
	}

	public void setOriginalPosition(Integer originalPosition) {
		this.originalPosition = originalPosition;
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

	public String getConnectedlinename() {
		return connectedlinename;
	}

	public void setConnectedlinename(String connectedlinename) {
		this.connectedlinename = connectedlinename;
	}

	public String getConnectedlinenum() {
		return connectedlinenum;
	}

	public void setConnectedlinenum(String connectedlinenum) {
		this.connectedlinenum = connectedlinenum;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}