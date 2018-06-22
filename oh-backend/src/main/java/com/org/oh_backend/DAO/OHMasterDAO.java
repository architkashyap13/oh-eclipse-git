package com.org.oh_backend.DAO;

import java.time.LocalDate;
import java.util.List;

import com.org.oh_backend.Model.OHMaster;

public interface OHMasterDAO {

	boolean saveOH(OHMaster oh);
	
	List<OHMaster> searchOHByName(String holidayName);
	
	List<OHMaster> searchOHByLocation(String holidayLocation);
	
	OHMaster searchOHByNameLocation(String holidayName, String holidayLocation);
	
	List<OHMaster> getAllActiveOHs();
	
	List<OHMaster> getAllOHs();	
	
	boolean deleteOHByNameLocation(String holidayName, String holidayLocation);
	
	boolean deleteOHByName(String holidayName);
	
	boolean deleteOHByYear(String year);
	
	boolean updateOHStatusByNameLocation(String holidayName, String holidayLocation, String status);
	
	boolean updateOHStatusByName(String holidayName, String status);
	
	boolean updateOHDateByName(String holidayName, LocalDate holidayDate);
}
