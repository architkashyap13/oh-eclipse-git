package com.org.oh_backend.DAO;

import java.util.List;

import com.org.oh_backend.Model.EmployeeMaster;

public interface EmployeeMasterDAO {
	
	boolean saveEmployee(EmployeeMaster employee);
	
	EmployeeMaster searchEmployeeById(int employeeId);
	
	EmployeeMaster searchEmployeeByEmailId(String emailId);
	
	List<EmployeeMaster> getAllEmployees();	
	
	boolean deleteEmployee(int employeeId);
	
	boolean updateEmployee(EmployeeMaster employee);
}
