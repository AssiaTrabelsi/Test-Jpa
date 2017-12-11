package banque.entitie;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "client")

public class Client {

	@Id
	private int id;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private LocalDate dateNaisance;

	@ManyToMany

	@JoinTable(name = "Compte_Client", joinColumns = @JoinColumn(name = "ID_Client", referencedColumnName = "ID"), 
	inverseJoinColumns = @JoinColumn(name = "id_Compte", referencedColumnName = "ID"))
	private Set<Compte> comptes;

	@ManyToOne
	@JoinColumn(name = "ID_banque")
	private Banque banque;

	@Embedded
	Adresse adresse;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	

	public LocalDate getDateNaisance() {
		return dateNaisance;
	}

	public void setDateNaisance(LocalDate dateNaisance) {
		this.dateNaisance = dateNaisance;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaisance=" + dateNaisance
				+ ", comptes=" + comptes + "]";
	}

}
