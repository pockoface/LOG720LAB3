package ca.etsmtl.log720.lab3.dao.helper;

import java.util.List;

import ca.etsmtl.log720.lab3.model.Infraction;

public interface InfractionDAO {
	public void addInfraction(Infraction infraction);
	public List<Infraction> listInfractions();
	public Infraction getInfraction(int id);
}
