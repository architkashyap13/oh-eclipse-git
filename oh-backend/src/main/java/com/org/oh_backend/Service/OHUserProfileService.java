package com.org.oh_backend.Service;

import java.util.List;

import com.org.oh_backend.Model.OHUserProfile;

public interface OHUserProfileService {
	List<OHUserProfile> findAll();
    
    OHUserProfile findByType(String type);
     
    OHUserProfile findById(int id);
    
    boolean save(OHUserProfile profileo);
}
