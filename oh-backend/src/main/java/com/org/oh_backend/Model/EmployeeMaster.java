package com.org.oh_backend.Model;

public class EmployeeMaster {

	private int employeeId;
	private String employeeName;
	private String emailId;
	private String baseLocation;
	private String currentLocation;
	private String irmEmail;
	private String srmEmail;
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
