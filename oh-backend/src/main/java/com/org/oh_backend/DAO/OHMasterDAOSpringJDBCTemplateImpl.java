package com.org.oh_backend.DAO;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.org.oh_backend.Model.OHMaster;

@Repository("oHMasterDAO")
@Transactional
public class OHMasterDAOSpringJDBCTemplateImpl implements OHMasterDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveOH(OHMaster oh) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(oh);
		tx.commit();
		session.flush();
		session.close();
		if (searchOHByName(oh.getHolidayName()) != null) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OHMaster> searchOHByName(String holidayName) {
		return (List<OHMaster>) sessionFactory.openSession().createCriteria(OHMaster.class)
				.add(Restrictions.eq("holidayName", holidayName)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OHMaster> searchOHByLocation(String holidayLocation) {
		return (List<OHMaster>) sessionFactory.openSession().createCriteria(OHMaster.class)
				.add(Restrictions.eq("holidayLocation", holidayLocation)).list();
	}
		
	@Override
	public OHMaster searchOHByNameLocation(String holidayName, String holidayLocation) {
		return (OHMaster) sessionFactory.openSession().createQuery(
				"FROM OHMaster WHERE holidayName=" + holidayName + " and holidayLocation=" + holidayLocation + "")
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OHMaster> getAllActiveOHs() {
		return (List<OHMaster>) sessionFactory.openSession().createCriteria(OHMaster.class)
				.add(Restrictions.eq("isActive", "Yes")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OHMaster> getAllOHs() {
		return (List<OHMaster>) sessionFactory.openSession().createCriteria(OHMaster.class).list();
	}
	
	@Override
	public boolean deleteOHByNameLocation(String holidayName, String holidayLocation) {		
		OHMaster oh = searchOHByNameLocation(holidayName, holidayLocation);
		if (oh == null)
			return false;
		else {
			sessionFactory.getCurrentSession().delete(oh);
			sessionFactory.getCurrentSession().flush();
			return true;
		}
	}

	@Override
	public boolean deleteOHByName(String holidayName) {		
		List<OHMaster> ohs = searchOHByName(holidayName);
		if (ohs.isEmpty())
			return false;
		else {
			int count = 0;
			for (OHMaster oh : ohs) {
				sessionFactory.getCurrentSession().delete(oh);

				if (count % 50 == 0) {
					sessionFactory.getCurrentSession().flush();
					sessionFactory.getCurrentSession().clear();
				}

				count++;
			}
			sessionFactory.getCurrentSession().flush();
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteOHByYear(String year) {
		Session session = sessionFactory.openSession();
		List<OHMaster> ohs = (List<OHMaster>) session.createCriteria(OHMaster.class).add(Restrictions.eq("year", year))
				.list();
		if (ohs.isEmpty())
			return false;
		else {
			int count = 0;
			for (OHMaster oh : ohs) {
				session.delete(oh);
				if (count % 50 == 0) {
					session.flush();
					session.clear();
				}
				count++;
			}
			session.flush();
			return true;
		}
	}

	@Override
	public boolean updateOHStatusByNameLocation(String holidayName, String holidayLocation, String status) {
		
		OHMaster oh = searchOHByNameLocation(holidayName, holidayLocation);		
		oh.setIsActive(status);
		sessionFactory.getCurrentSession().saveOrUpdate(oh);
		sessionFactory.getCurrentSession().flush();
		
		if (searchOHByNameLocation(holidayName, holidayLocation).getIsActive() == status) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean updateOHStatusByName(String holidayName, String status) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		ScrollableResults ohCursor = session.createQuery("from ohmaster where HOLIDAY_NAME="+holidayName+"").scroll();
		int count = 0;

		while ( ohCursor.next() ) {
		   OHMaster oh = (OHMaster) ohCursor.get(0);
		   oh.setIsActive(status);
		   session.update(oh);
		   if ( ++count % 50 == 0 ) {
		      session.flush();
		      session.clear();
		   }
		}
		tx.commit();
		session.close();
		
		boolean flag = false;
		for (OHMaster oh : searchOHByName(holidayName)) {
			if(oh.getIsActive() == status){
				flag = true;
			}
		}
		
		return flag;
	}
	
	@Override
	public boolean updateOHDateByName(String holidayName, LocalDate holidayDate) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		ScrollableResults ohCursor = session.createQuery("from ohmaster where HOLIDAY_NAME="+holidayName+"").scroll();
		int count = 0;

		while ( ohCursor.next() ) {
		   OHMaster oh = (OHMaster) ohCursor.get(0);
		   oh.setHolidayDate(holidayDate);
		   session.update(oh);
		   if ( ++count % 50 == 0 ) {
		      session.flush();
		      session.clear();
		   }
		}
		tx.commit();
		session.close();
		
		boolean flag = false;
		for (OHMaster oh : searchOHByName(holidayName)) {
			if(oh.getHolidayDate() == holidayDate){
				flag = true;
			}
		}
		
		return flag;		
	}
}
