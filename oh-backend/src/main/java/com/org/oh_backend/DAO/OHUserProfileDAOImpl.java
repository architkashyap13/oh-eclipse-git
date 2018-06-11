package com.org.oh_backend.DAO;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import com.org.oh_backend.Model.OHUserProfile;

@Repository("oHUserProfileDAO")
public class OHUserProfileDAOImpl extends AbstractDao<Integer, OHUserProfile>implements OHUserProfileDAO{
     
    public List<OHUserProfile> findAll(){
//        Criteria crit = createEntityCriteria();
//        crit.addOrder(Order.asc("type"));
//        return (List<OHUserProfile>)crit.list();O
    	
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<OHUserProfile> criteriaQuery = criteriaBuilder.createQuery(OHUserProfile.class);     
        criteriaQuery.orderBy(criteriaBuilder.asc(criteriaQuery.from(OHUserProfile.class).get("type")));
        final TypedQuery<OHUserProfile> query = getEntityManager().createQuery(criteriaQuery);
        return query.getResultList();
        
    }
     
    public OHUserProfile findById(int id) {
        return getByKey(id);
    }
     
    public OHUserProfile findByType(String type) {
//        Criteria crit = createEntityCriteria();
//        crit.add(Restrictions.eq("type", type));
//        return (OHUserProfile) crit.uniqueResult();
        
        List<?> list = getEntityManager().createQuery("SELECT up FROM OHUserProfile up WHERE type=?")
				.setParameter(1, type).getResultList();
		
        if(!list.isEmpty()){
        	return (OHUserProfile)list.get(0);
        }
        else{
        	return null;
        }
			
    }
    
    public void save(OHUserProfile profile) {
		persist(profile);
	}
}
