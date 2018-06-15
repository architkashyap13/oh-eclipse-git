package com.org.oh_backend.Service;

import java.util.List;

import com.org.oh_backend.Model.EmployeeMaster;

public interface EmployeeMasterService {

	boolean saveEmployee(EmployeeMaster employee);
	
	EmployeeMaster searchEmployeeById(int employeeId);
	
	List<EmployeeMaster> getAllEmployees();	
	
	boolean deleteEmployee(int employeeId);
	
	boolean updateEmployee(EmployeeMaster employee);	
}
