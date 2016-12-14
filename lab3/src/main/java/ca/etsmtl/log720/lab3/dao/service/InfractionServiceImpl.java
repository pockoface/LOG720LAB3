package ca.etsmtl.log720.lab3.dao.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ca.etsmtl.log720.lab3.dao.helper.InfractionDAO;
import ca.etsmtl.log720.lab3.dao.helper.InfractionService;
import ca.etsmtl.log720.lab3.model.Infraction;

public class InfractionServiceImpl implements InfractionService{
	
	private InfractionDAO infractionDAO;

	public void setInfractionDAO(InfractionDAO infractionDAO) {
		this.infractionDAO = infractionDAO;
	}

	@Transactional
	public void addInfraction(Infraction infraction) {
		this.infractionDAO.addInfraction(infraction);
	}

	@Transactional
	public List<Infraction> listInfractions() {
		return this.infractionDAO.listInfractions();
	}
	
	@Transactional
	public Infraction getInfraction(int id) {
		return this.infractionDAO.getInfraction(id);
	}

}
