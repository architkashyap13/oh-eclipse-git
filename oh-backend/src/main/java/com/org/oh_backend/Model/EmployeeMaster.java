package com.org.oh_backend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="masterdata")
public class EmployeeMaster {

	@Id
	@NotNull
	@Column(name = "EMPLOYEE_ID", unique = true, nullable = false)
	private int employeeId;
	
	@NotEmpty
	@Column(name = "EMPLOYEE_NAME", nullable = false)
	private String employeeName;
	
	@NotEmpty
	@Column(name = "EMAIL", unique = true, nullable = false)
	private String emailId;
	
	@NotEmpty
	@Column(name = "BASE_LOCATION", nullable = false)
	private String baseLocation;
	
	@NotEmpty
	@Column(name = "CURRENT_LOCATION", nullable = false)
	private String currentLocation;
	
	@NotEmpty
	@Column(name = "IRM_EMAIL", nullable = false)
	private String irmEmail;
	
	@NotEmpty
	@Column(name = "SRM_EMAIL", nullable = false)
	private String srmEmail;
	
	@NotEmpty
	@Column(name = "HRBP_EMAIL", nullable = false)
	private String hrbpEmail;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getBaseLocation() {
		return baseLocation;
	}
	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	public String getIrmEmail() {
		return irmEmail;
	}
	public void setIrmEmail(String irmEmail) {
		this.irmEmail = irmEmail;
	}
	public String getSrmEmail() {
		return srmEmail;
	}
	public void setSrmEmail(String srmEmail) {
		this.srmEmail = srmEmail;
	}
	public String getHrbpEmail() {
		return hrbpEmail;
	}
	public void setHrbpEmail(String hrbpEmail) {
		this.hrbpEmail = hrbpEmail;
	}			
}
