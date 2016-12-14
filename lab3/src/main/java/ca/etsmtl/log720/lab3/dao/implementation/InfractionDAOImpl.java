package ca.etsmtl.log720.lab3.dao.implementation;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.etsmtl.log720.lab3.dao.helper.InfractionDAO;
import ca.etsmtl.log720.lab3.model.Dossier;
import ca.etsmtl.log720.lab3.model.Infraction;

public class InfractionDAOImpl implements InfractionDAO{

	private static final Logger logger = LoggerFactory.getLogger(InfractionDAOImpl.class);
	private SessionFactory sf;
	
	public void setSessionFactory(SessionFactory sf){
		this.sf = sf;
	}
	
	public void addInfraction(Infraction infraction) {
		Session session = this.sf.getCurrentSession();
		session.persist(infraction);
		logger.info("Infraction saved successfully, Infraction Details="+infraction);
		
	}

	public List<Infraction> listInfractions() {
		Session session = this.sf.getCurrentSession();
		CriteriaBuilder builder = this.sf.getCriteriaBuilder();
		
		CriteriaQuery<Infraction> criteria = builder.createQuery(Infraction.class);
        Root<Infraction> contactRoot = criteria.from(Infraction.class);
        criteria.select(contactRoot);
		
		List<Infraction> infractions = session.createQuery(criteria).getResultList();

		for(Infraction i : infractions){
			logger.info("Infraction List:"+i);
		}
		return infractions;
	}

	public Infraction getInfraction(int id) {
		Session session = this.sf.getCurrentSession();		
		System.out.println(id);
		Infraction infraction = (Infraction) session.load(Infraction.class, new Integer(id));
		logger.info("Infraction loaded successfully, Infraction details="+infraction);
		
		return infraction;
	}

}
