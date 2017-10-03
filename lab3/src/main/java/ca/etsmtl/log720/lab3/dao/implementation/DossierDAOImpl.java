package ca.etsmtl.log720.lab3.dao.implementation;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ca.etsmtl.log720.lab3.dao.helper.DossierDAO;
import ca.etsmtl.log720.lab3.model.Dossier;
import ca.etsmtl.log720.lab3.model.Infraction;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DossierDAOImpl implements DossierDAO{
	
	private SessionFactory sf;
	
	public void setSessionFactory(SessionFactory sf){
		this.sf = sf;
	}

	public void addDossier(Dossier dossier) {
		Session session = this.sf.getCurrentSession();
		session.persist(dossier);
		log.info("Dossier saved successfully, Dossier Details="+dossier);
	}

	public void addInfraction(Infraction infraction, Dossier dossier) {
		Session session = this.sf.getCurrentSession();
		dossier.addInfraction(infraction);
		session.update(dossier);
		log.info("Dossier updated successfully, Dossier Details="+dossier);
		
	}

	public List<Dossier> listDossiers() {
		Session session = this.sf.getCurrentSession();
		CriteriaBuilder builder = this.sf.getCriteriaBuilder();
		
		CriteriaQuery<Dossier> criteria = builder.createQuery(Dossier.class);
        Root<Dossier> contactRoot = criteria.from(Dossier.class);
        criteria.select(contactRoot);
		
		List<Dossier> dossiers = session.createQuery(criteria).getResultList();

		for(Dossier d : dossiers){
			log.info("Dossier List:"+d);
		}
		return dossiers;
	}

	public Dossier showDossier(int dossierId) {
		Session session = this.sf.getCurrentSession();		
		Dossier dossier = (Dossier) session.load(Dossier.class, new Integer(dossierId));
		log.info("Dossier loaded successfully, Dossier details="+dossier);
		return dossier;
	}

}
