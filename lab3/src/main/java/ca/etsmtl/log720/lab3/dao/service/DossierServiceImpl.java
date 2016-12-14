package ca.etsmtl.log720.lab3.dao.service;

import java.util.List;

import ca.etsmtl.log720.lab3.dao.helper.DossierDAO;
import ca.etsmtl.log720.lab3.dao.helper.DossierService;
import ca.etsmtl.log720.lab3.model.Dossier;
import ca.etsmtl.log720.lab3.model.Infraction;
import org.springframework.transaction.annotation.Transactional;

public class DossierServiceImpl implements DossierService{
	
	private DossierDAO dossierDao;
	
	public void setDossierDAO(DossierDAO dossierDao) {
		this.dossierDao = dossierDao;
	}
	
	@Transactional
	public void addDossier(Dossier dossier) {
		this.dossierDao.addDossier(dossier);
	}

	@Transactional
	public void addInfraction(Infraction infraction, Dossier dossier) {
		this.dossierDao.addInfraction(infraction, dossier);
	}

	@Transactional
	public List<Dossier> listDossiers() {
		return this.dossierDao.listDossiers();
	}

	@Transactional
	public Dossier getDossier(int dossierId) {
		return this.dossierDao.showDossier(dossierId);
	}
}
