package com.org.oh_backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.oh_backend.Service.EmployeeMasterService;

@RestController
@RequestMapping("EmployeeMasterOperations")
public class EmployeeMasterController {

	@Autowired
	private EmployeeMasterService service;
	
}
