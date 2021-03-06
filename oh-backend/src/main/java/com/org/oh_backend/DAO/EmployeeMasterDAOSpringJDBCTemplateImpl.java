package com.org.oh_backend.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		 return (EmployeeMaster) sessionFactory.openSession()
												 .createCriteria(EmployeeMaster.class)
												 .add(Restrictions.eq("employeeId", employeeId))
												 .uniqueResult();
	}
	
	public EmployeeMaster searchEmployeeByEmailId(String emailId) {
		 //return (EmployeeMaster) sessionFactory.getCurrentSession().createQuery("from masterdata where employeeId ="+employeeId+"").uniqueResult();
		 return (EmployeeMaster) sessionFactory.openSession()
												 .createCriteria(EmployeeMaster.class)
												 .add(Restrictions.eq("emailId", emailId))
												 .uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<EmployeeMaster> getAllEmployees() {
		return sessionFactory.openSession()
		 .createCriteria(EmployeeMaster.class).list();
	}

	public boolean saveEmployee(EmployeeMaster employee) {		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(employee);
		tx.commit();
		session.flush();
		
		if(searchEmployeeById(employee.getEmployeeId()) != null){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean deleteEmployee(int employeeId) {
		Session session = sessionFactory.openSession();		
		EmployeeMaster employee = (EmployeeMaster) session.createCriteria(EmployeeMaster.class)
				 								.add(Restrictions.eq("employeeId", employeeId))
				 								.uniqueResult();
		
		
		if(employee == null)
			return false;
		else{
			session.delete(employee);
			session.flush();
			return true;
		}
			
	}

	public boolean updateEmployee(EmployeeMaster employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(employee);
		tx.commit();
		session.flush();
		
		if(searchEmployeeById(employee.getEmployeeId()) != null){
			return true;
		}
		else{
			return false;
		}
	}

}
