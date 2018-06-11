package com.org.oh_backend.Service;

import com.org.oh_backend.Model.OHUser;

public interface OHUserService {
	
	boolean save(OHUser user);
    
    OHUser findById(int id);
     
    OHUser findByUserName(String sso);
}
