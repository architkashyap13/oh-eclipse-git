package com.org.oh_backend.DAO;

import java.util.List;

import com.org.oh_backend.Model.OHUserProfile;

public interface OHUserProfileDAO {
	
	List<OHUserProfile> findAll();
    
    OHUserProfile findByType(String type);
     
    OHUserProfile findById(int id);
    
    void save(OHUserProfile profile);
}
