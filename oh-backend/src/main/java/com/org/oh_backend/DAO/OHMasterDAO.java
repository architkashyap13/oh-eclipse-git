package com.org.oh_backend.DAO;

import java.util.List;

import com.org.oh_backend.Model.OHMaster;

public interface OHMasterDAO {

	boolean saveOH(OHMaster oh);
	
	OHMaster searchOHByName(String holidayName);
	
	List<OHMaster> getAllOHs();	
	
	boolean deleteOH();
	
	boolean updateOH(); 	
}
