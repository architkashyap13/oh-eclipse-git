package com.org.oh_backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.org.oh_backend.DAO.OHUserDAO;
import com.org.oh_backend.Model.OHUser;

public class OHUserServiceImpl implements OHUserService {
	
	@Autowired
    private OHUserDAO dao;
     
    @Autowired
    private PasswordEncoder passwordEncoder;
 
     
    public void save(OHUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(user);
    }
     
    public OHUser findById(int id) {
        return dao.findById(id);
    }
 
    public OHUser findByUserName(String sso) {
        return dao.findByUserName(sso);
    }
}
