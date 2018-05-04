package com.org.oh_backend.Model;

import java.time.Instant;

public class OHClient {

	private int ohClientId;
	private String emailId;
	private String clientName;
	private String createdBy;
	private Instant createdDate;
	
	public int getOhClientId() {
		return ohClientId;
	}
	public void setOhClientId(int ohClientId) {
		this.ohClientId = ohClientId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Instant getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}
	
}
