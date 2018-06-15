package com.org.oh_backend.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.org.oh_backend.Model.EmployeeMaster;

@Repository("employeeMasterDAO")
@Transactional
public class EmployeeMasterDAOSpringJDBCTemplateImpl implements EmployeeMasterDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public EmployeeMaster searchEmployeeById(int employeeId) {
		 //return (EmployeeMaster) sessionFactory.getCurrentSession().createQuery("from masterdata where employeeId ="+employeeId+"").uniqueResult();
		 return (EmployeeMaster) sessionFactory.getCurrentSession()
												 .createCriteria(EmployeeMaster.class)
												 .add(Restrictions.eq("employeeId", employeeId))
												 .uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<EmployeeMaster> getAllEmployees() {
		return sessionFactory.getCurrentSession()
		 .createCriteria(EmployeeMaster.class).list();
	}

	public boolean saveEmployee(EmployeeMaster employee) {
		if(sessionFactory.getCurrentSession().save(employee) != null){
			return true;
		}else{
			return false;
		}		
	}

	public boolean deleteEmployee(int employeeId) {
		EmployeeMaster employee = sessionFactory.getCurrentSession().load(EmployeeMaster.class, employeeId);
		sessionFactory.getCurrentSession().delete(employee);
		
		if(employee.getEmailId().equalsIgnoreCase(""))
			return true;
		else
			return false;
	}

	public boolean updateEmployee(EmployeeMaster employee) {
		if(sessionFactory.getCurrentSession().save(employee) != null){
			return true;
		}else{
			return false;
		}
	}

}
