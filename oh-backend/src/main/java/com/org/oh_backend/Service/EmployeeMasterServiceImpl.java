package com.org.oh_backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.oh_backend.DAO.EmployeeMasterDAO;
import com.org.oh_backend.Model.EmployeeMaster;

@Service("employeeMasterService")
@Transactional
public class EmployeeMasterServiceImpl implements EmployeeMasterService {

	@Autowired
	private EmployeeMasterDAO employeeMasterDAO;
	
	@Override
	public boolean saveEmployee(EmployeeMaster employee) {
		return employeeMasterDAO.saveEmployee(employee);
	}

	@Override
	public EmployeeMaster searchEmployeeById(int employeeId) {
		return employeeMasterDAO.searchEmployeeById(employeeId);
	}
	
	@Override
	public EmployeeMaster searchEmployeeByEmailId(String emailId) {
		return employeeMasterDAO.searchEmployeeByEmailId(emailId);
	}

	@Override
	public List<EmployeeMaster> getAllEmployees() {
		return employeeMasterDAO.getAllEmployees();
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		return employeeMasterDAO.deleteEmployee(employeeId);
	}

	@Override
	public boolean updateEmployee(EmployeeMaster employee) {		
		return employeeMasterDAO.updateEmployee(employee);
	}

}
