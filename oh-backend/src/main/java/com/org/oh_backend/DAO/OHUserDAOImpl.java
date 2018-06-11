package com.org.oh_backend.DAO;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.org.oh_backend.Model.OHUser;

@Repository("oHUserDAO")
@Transactional
public class OHUserDAOImpl extends AbstractDao<Integer, OHUser> implements OHUserDAO {

	// @PersistenceContext
	// private EntityManager entityManager;

	public void save(OHUser user) {
		persist(user);
	}

	public OHUser findById(int id) {
		return getByKey(id);
	}

	@Override
	public OHUser findByUserName(String userName) {
		// CriteriaQuery<OHUser> crit = createEntityCriteria();
		// crit.add(Restrictions.eq("userName", userName));
		Criteria crit = getEntityManager().unwrap(Session.class).createCriteria(OHUser.class);
		crit.add(Restrictions.eq("userName", userName));
		if (crit.uniqueResult() != null) {
			return (OHUser) crit.uniqueResult();
		}else
			return new OHUser();

//		List<?> list = getEntityManager().createQuery("SELECT u FROM OHUser u WHERE userName=?")
//				.setParameter(1, userName).getResultList();
//
//		if ((!list.isEmpty())) {
//			return (OHUser) list.get(0);
//		} else
//			return new OHUser();

	}

//	public boolean findUserName(String userName) {
//		// CriteriaQuery<OHUser> crit = createEntityCriteria();
//		// crit.add(Restrictions.eq("userName", userName));
//
//		List<?> list = getEntityManager().createQuery("SELECT u FROM OHUser u WHERE userName=?")
//				.setParameter(1, userName).getResultList();
//
//		return (!list.isEmpty()) ? true : false;
//
//	}

}
