package com.org.oh_backend.Model;

import java.time.Instant;

public class OHMaster {

	private String holidayName;
	private Instant holidayDate;
	private String holidayLocation;
	private String year;
	private String isActive;
	
	public String getHolidayName() {
		return holidayName;
	}
	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}
	public Instant getHolidayDate() {
		return holidayDate;
	}
	public void setHolidayDate(Instant holidayDate) {
		this.holidayDate = holidayDate;
	}
	public String getHolidayLocation() {
		return holidayLocation;
	}
	public void setHolidayLocation(String holidayLocation) {
		this.holidayLocation = holidayLocation;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
}
