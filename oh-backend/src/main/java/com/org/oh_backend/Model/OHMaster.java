package com.org.oh_backend.Model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="ohmaster")
public class OHMaster {

	@NotEmpty
	@Column(name = "HOLIDAY_NAME", nullable = false)
	private String holidayName;
	
	@NotEmpty
	@Column(name = "HOLIDAY_DATE", nullable = false)
	private Instant holidayDate;
	
	@NotEmpty
	@Column(name = "HOLIDAY_LOCATION", nullable = false)
	private String holidayLocation;
	
	@NotEmpty
	@Column(name = "YEAR", nullable = false)
	private String year;
	
	@NotEmpty
	@Column(name = "IS_ACTIVE", nullable = false)
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
