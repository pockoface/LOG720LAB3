package ca.etsmtl.log720.lab3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "infraction",
        uniqueConstraints = {@UniqueConstraint(columnNames = "idInfraction")}
)
public class Infraction implements Serializable {

    public void setIdInfraction(int idInfraction) {
        this.idInfraction = idInfraction;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void setDossiers(List<Dossier> dossiers) {
        this.dossiers = dossiers;
    }

    private int idInfraction;
    private String description;
    private int niveau;
    private List<Dossier> dossiers;

	@Column(name = "niveau", unique = false, nullable = true)
	public int getNiveau() {
		return niveau;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "infractions")
	public List<Dossier> getDossiers() {
		return dossiers;
	}
}
