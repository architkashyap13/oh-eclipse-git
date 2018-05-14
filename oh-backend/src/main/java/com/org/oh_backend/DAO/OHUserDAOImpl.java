package com.org.oh_backend.DAO;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.org.oh_backend.Model.OHUser;

@Repository
public class OHUserDAOImpl extends AbstractDao<Integer, OHUser> implements OHUserDAO {

	public void save(OHUser user) {
		persist(user);
	}

	public OHUser findById(int id) {
		return getByKey(id);
	}

	@Override
	public OHUser findByUserName(String userName) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("userName", userName));
		return (OHUser) crit.uniqueResult();
	}

}
