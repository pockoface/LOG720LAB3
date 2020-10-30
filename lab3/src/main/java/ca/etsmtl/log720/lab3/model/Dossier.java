package ca.etsmtl.log720.lab3.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "dossier",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "iddossier"),
                @UniqueConstraint(columnNames = "permis")}
)
public class Dossier implements Serializable {

    public void setId(int id) {
        this.id = id;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPronom(String pronom) {
        this.pronom = pronom;
    }

    public void setNoPermis(String noPermis) {
        this.noPermis = noPermis;
    }

    public void setNoPlaque(String noPlaque) {
        this.noPlaque = noPlaque;
    }

    public void setInfractions(List<Infraction> infractions) {
        this.infractions = infractions;
    }

    private int id;
    private int niveau;
    private String nom;
    private String pronom;
    private String noPermis;
    private String noPlaque;
    private List<Infraction> infractions;

    public Dossier(String nom, String pronom,
                   String noPermis, String noPlaque) {
        this.nom = nom;
        this.pronom = pronom;
        this.noPermis = noPermis;
        this.noPlaque = noPlaque;
        this.infractions = new ArrayList<Infraction>();
    }

    public Dossier() {
    }

    public void addInfraction(Infraction infraction) {
        infractions.add(infraction);
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "dossier_infraction", joinColumns = {
            @JoinColumn(name = "iddossier", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "idInfraction",
                    nullable = false, updatable = false)})
    public List<Infraction> getInfractions() {
        return this.infractions;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddossier", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public int getNiveau() {
        return niveau;
    }

    @Column(name = "nom", unique = false, nullable = false, length = 255)
    public String getNom() {
        return nom;
    }

    @Column(name = "prenom", unique = false, nullable = false, length = 255)
    public String getPronom() {
        return pronom;
    }

    @Column(name = "permis", unique = true, nullable = false, length = 255)
    public String getNoPermis() {
        return noPermis;
    }

    @Column(name = "plaque", unique = false, nullable = false, length = 255)
    public String getNoPlaque() {
        return noPlaque;
    }

}