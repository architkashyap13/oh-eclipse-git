package com.org.oh_backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.org.oh_backend.Model.OHUser;
import com.org.oh_backend.Service.OHUserProfileService;
import com.org.oh_backend.Service.OHUserService;

//@RestController
//@RequestMapping("OHUserOperations")
public class UserCommonController {

	@Autowired
    OHUserProfileService oHUserProfileService;
     
    @Autowired
    OHUserService oHUserService;
	
    @PostMapping("OHUser")
    public ResponseEntity<Void> saveOHUser(@RequestBody OHUser ohUser){
    	boolean flag = oHUserService.save(ohUser);
		if (flag == false) {
		     return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		//HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(builder.path("/OHUser?id={id}").buildAndExpand(ohUser.getUserId()).toUri());
		return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
