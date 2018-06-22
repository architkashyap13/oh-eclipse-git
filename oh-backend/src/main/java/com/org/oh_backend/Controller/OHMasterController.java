package com.org.oh_backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.oh_backend.Model.OHMaster;
import com.org.oh_backend.Service.OHMasterService;

@RestController
@RequestMapping("OHMasterOperations")
public class OHMasterController {

	@Autowired
	private OHMasterService ohMasterService;

	@PostMapping("/oh")
	public ResponseEntity<Void> saveEmployee(@RequestBody OHMaster oh) {
		boolean flag = ohMasterService.saveOH(oh);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		System.out.println("OH Name" + oh.getHolidayName());
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

//	@GetMapping(path = "/employee/{employeeId}")
//	public ResponseEntity<EmployeeMaster> getEmployeeById(@PathVariable int employeeId) {
//		EmployeeMaster employee = employeeMasterService.searchEmployeeById(employeeId);
//		if (employee == null) {
//			return new ResponseEntity<EmployeeMaster>(HttpStatus.NO_CONTENT);
//		}
//		System.out.println("User Id : " + employee.getEmployeeId());
//		return new ResponseEntity<EmployeeMaster>(employee, HttpStatus.OK);
//	}
//
//	@GetMapping(path = "/employee")
//	public ResponseEntity<EmployeeMaster> getEmployeeByEmailId(@RequestParam("emailId") String emailId) {
//		EmployeeMaster employee = employeeMasterService.searchEmployeeByEmailId(emailId);
//		if (employee == null) {
//			return new ResponseEntity<EmployeeMaster>(HttpStatus.NO_CONTENT);
//		}
//		System.out.println("User Id : " + employee.getEmailId());
//		return new ResponseEntity<EmployeeMaster>(employee, HttpStatus.OK);
//	}
//
//	@PutMapping(path = "/employee/{employeeId}")
//	public ResponseEntity<?> updateEmployeeById(@PathVariable int employeeId,
//			@RequestBody EmployeeMaster employee) {
//
//		EmployeeMaster existingEmployee = employeeMasterService.searchEmployeeById(employeeId);
//		if (existingEmployee == null) {
//			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
//		} else {
//			System.out.println("User Id : " + employee.getEmailId());
//			boolean flag = employeeMasterService.updateEmployee(employee);
//			if (flag == false) {
//				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//			}
//			return new ResponseEntity<Void>(HttpStatus.OK);
//		}
//	}
//
//	@DeleteMapping(path = "/employee/{employeeId}")
//	public ResponseEntity<?> deleteEmployeeById(@PathVariable int employeeId) {
//
//		System.out.println("User Id : " + employeeId);
//		boolean flag = employeeMasterService.deleteEmployee(employeeId);
//		if (flag == false) {
//			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//	}
}
