package com.org.oh_backend.Model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

@Entity
@Table(name="ohmaster")
public class OHMaster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@Column(name = "HOLIDAY_NAME", nullable = false)
	private String holidayName;
	
	@NotEmpty
	@Column(name = "HOLIDAY_DATE", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	@JsonFormat(pattern = "YYYY-MM-dd")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate holidayDate;
	
	@Id
	@NotNull
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
	public LocalDate getHolidayDate() {
		return holidayDate;
	}
	public void setHolidayDate(LocalDate holidayDate) {
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
