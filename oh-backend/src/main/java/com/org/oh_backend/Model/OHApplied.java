package com.org.oh_backend.Model;

import java.time.Instant;

public class OHApplied {

	private int ohId;
	private String emailId;
	private String createdBy;
	private Instant createdDate;
	private String irmStatus;
	private String ohName;
	private Instant ohDate;
	private Instant approvalDate;
	private Instant hrDate;
	private Instant irmDate;
	private Instant ohAppliedDate;
	private String hrStatus;
	private String irmRemarks;
	private String hrRemarks;
	
	public int getOhId() {
		return ohId;
	}
	public void setOhId(int ohId) {
		this.ohId = ohId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
	public String getIrmStatus() {
		return irmStatus;
	}
	public void setIrmStatus(String irmStatus) {
		this.irmStatus = irmStatus;
	}
	public String getOhName() {
		return ohName;
	}
	public void setOhName(String ohName) {
		this.ohName = ohName;
	}
	public Instant getOhDate() {
		return ohDate;
	}
	public void setOhDate(Instant ohDate) {
		this.ohDate = ohDate;
	}
	public Instant getApprovalDate() {
		return approvalDate;
	}
	public void setApprovalDate(Instant approvalDate) {
		this.approvalDate = approvalDate;
	}
	public Instant getHrDate() {
		return hrDate;
	}
	public void setHrDate(Instant hrDate) {
		this.hrDate = hrDate;
	}
	public Instant getIrmDate() {
		return irmDate;
	}
	public void setIrmDate(Instant irmDate) {
		this.irmDate = irmDate;
	}
	public Instant getOhAppliedDate() {
		return ohAppliedDate;
	}
	public void setOhAppliedDate(Instant ohAppliedDate) {
		this.ohAppliedDate = ohAppliedDate;
	}
	public String getHrStatus() {
		return hrStatus;
	}
	public void setHrStatus(String hrStatus) {
		this.hrStatus = hrStatus;
	}
	public String getIrmRemarks() {
		return irmRemarks;
	}
	public void setIrmRemarks(String irmRemarks) {
		this.irmRemarks = irmRemarks;
	}
	public String getHrRemarks() {
		return hrRemarks;
	}
	public void setHrRemarks(String hrRemarks) {
		this.hrRemarks = hrRemarks;
	}	
}
