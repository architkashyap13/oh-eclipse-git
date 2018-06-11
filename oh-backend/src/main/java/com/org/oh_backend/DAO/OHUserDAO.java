package com.org.oh_backend.DAO;

import com.org.oh_backend.Model.OHUser;

public interface OHUserDAO {
	
	void save(OHUser user);
    
	OHUser findById(int id);
     
	OHUser findByUserName(String userName);
}
