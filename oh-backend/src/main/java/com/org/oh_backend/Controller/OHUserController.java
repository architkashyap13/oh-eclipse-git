package com.org.oh_backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.oh_backend.Model.OHUser;
import com.org.oh_backend.Model.OHUserProfile;
import com.org.oh_backend.Service.OHUserProfileService;
import com.org.oh_backend.Service.OHUserService;

@RestController
@RequestMapping("OHUserOperations")
public class OHUserController {

	@Autowired
    OHUserProfileService ohUserProfileService;
     
    @Autowired
    OHUserService ohUserService;
    
    @RequestMapping(value = "/newUser", method = RequestMethod.GET)
    public void newRegistration() {
    	System.out.println("User controller hit");
    }
 
    @PostMapping("/saveOHUser")
    public ResponseEntity<Void> saveOHUser(@RequestBody OHUser ohUser) {
 
    	boolean flag = ohUserService.save(ohUser);
		if (flag == false) {
		     return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		System.out.println("User Id : "+ohUser.getUserId()); 
        System.out.println("First Name : "+ohUser.getFirstName());
        System.out.println("Last Name : "+ohUser.getLastName());
        System.out.println("UserName : "+ohUser.getUserName());
        System.out.println("Password : "+ohUser.getPassword());        
        System.out.println("Checking UsrProfiles....");
        if(ohUser.getUserProfiles()!=null){
            for(OHUserProfile profile : ohUser.getUserProfiles()){
                System.out.println("Profile : "+ profile.getType());
            }
        }         
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    @PostMapping("/saveOHUserProfile")
    public ResponseEntity<Void> saveOHUserProfile(@RequestBody OHUserProfile ohUserProfile) {
 
    	boolean flag = ohUserProfileService.save(ohUserProfile);
		if (flag == false) {
		     return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		System.out.println("Id : "+ohUserProfile.getId()); 
        System.out.println("Profile Type : "+ohUserProfile.getType());
                
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
 
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
     
    @ModelAttribute("roles")
    public List<OHUserProfile> initializeProfiles() {
        return ohUserProfileService.findAll();
    }
	
}
