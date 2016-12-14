package ca.etsmtl.log720.lab3.dao.helper;

import java.util.List;

import ca.etsmtl.log720.lab3.model.Dossier;
import ca.etsmtl.log720.lab3.model.Infraction;

public interface DossierService {
	public void addDossier(Dossier dossier);
	public void addInfraction(Infraction infraction, Dossier dossier);
	public List<Dossier> listDossiers();
	public Dossier getDossier(int dossierId);
}
