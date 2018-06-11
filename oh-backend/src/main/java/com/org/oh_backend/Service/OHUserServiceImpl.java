package com.org.oh_backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.oh_backend.DAO.OHUserDAO;
import com.org.oh_backend.Model.OHUser;



@Service("oHUserService")
@Transactional
public class OHUserServiceImpl implements OHUserService {

	@Autowired
	private OHUserDAO oHUserDAO;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public synchronized boolean save(OHUser user) {

		if (oHUserDAO.findByUserName(user.getUserName()) == null) {
			return false;
		} else {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			oHUserDAO.save(user);
			return true;
		}
	}

	public OHUser findById(int id) {
		return oHUserDAO.findById(id);
	}

	public OHUser findByUserName(String sso) {
		return oHUserDAO.findByUserName(sso);
	}
}
