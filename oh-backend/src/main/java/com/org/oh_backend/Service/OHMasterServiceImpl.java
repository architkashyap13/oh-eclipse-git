package com.org.oh_backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.oh_backend.DAO.OHMasterDAO;
import com.org.oh_backend.Model.OHMaster;

@Service("oHMasterService")
@Transactional
public class OHMasterServiceImpl implements OHMasterService {

	@Autowired
	private OHMasterDAO ohMasterDAO;

	@Override
	public synchronized boolean saveOH(OHMaster oh) {

		if (ohMasterDAO.searchOHByNameLocation(oh.getHolidayName(), oh.getHolidayLocation()) == null) {
			return false;
		} else {
			ohMasterDAO.saveOH(oh);
			return true;
		}
	}
}
