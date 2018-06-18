package com.org.oh_backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.oh_backend.Model.EmployeeMaster;
import com.org.oh_backend.Service.EmployeeMasterService;

@RestController
@RequestMapping("EmployeeMasterOperations")
public class EmployeeMasterController {

	@Autowired
	private EmployeeMasterService employeeMasterService;
	
	@PostMapping("/employee")
	public ResponseEntity<Void> saveEmployee(@RequestBody EmployeeMaster employee){
		boolean flag = employeeMasterService.saveEmployee(employee);
		if (flag == false) {
		     return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		System.out.println("User Id : "+employee.getEmailId());                 
        return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
