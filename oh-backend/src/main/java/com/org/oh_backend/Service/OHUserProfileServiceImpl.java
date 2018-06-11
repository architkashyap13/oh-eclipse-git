package com.org.oh_backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.oh_backend.DAO.OHUserProfileDAO;
import com.org.oh_backend.Model.OHUserProfile;



@Service("oHUserProfileService")
@Transactional
public class OHUserProfileServiceImpl implements OHUserProfileService{
    
   @Autowired
   OHUserProfileDAO oHUserProfileDAO;
    
   public List<OHUserProfile> findAll() {
       return oHUserProfileDAO.findAll();
   }

   public OHUserProfile findByType(String type){
       return oHUserProfileDAO.findByType(type);
   }

   public OHUserProfile findById(int id) {
       return oHUserProfileDAO.findById(id);
   }
   
   public synchronized boolean save(OHUserProfile profile) {

		if (oHUserProfileDAO.findByType(profile.getType()) == null) {
			oHUserProfileDAO.save(profile);
			return true;
		} else {			
			return false;
		}
	}
}
