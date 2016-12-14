package ca.etsmtl.log720.lab3.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.etsmtl.log720.lab3.dao.helper.UserDAO;
import ca.etsmtl.log720.lab3.model.User;

public class UserDAOImpl implements UserDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	private SessionFactory sf;
	
	public void setSessionFactory(SessionFactory sf){
		this.sf = sf;
	}
	
	public User findUserByUsername(String username) {
		EntityManager entity = this.sf.createEntityManager();
		Metamodel meta = entity.getMetamodel();
		EntityType<User> USER = meta.entity(User.class);
		
		CriteriaBuilder builder = this.sf.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> userRoot = criteria.from(User.class);
        
        criteria.where(builder.equal(userRoot.get(USER.getName()), username));
       
		User user = entity.createQuery(criteria).getSingleResult();
		
		return user;
	}

}
