import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "fournisseur")
public class Fournisseur {

	@Id
	private int id;

	@Column(name = "Nom")
	private String nom;

	@OneToMany(mappedBy = "fournisseur")
	private Set<Bon> bons;

	@OneToMany(mappedBy = "fournisseur")
	private Set<Article> articles;

	public Fournisseur() {
		bons = new HashSet<Bon>();
		articles = new HashSet<Article>();
	}

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

	public Set<Bon> getBons() {
		return bons;
	}

	public void setBons(Set<Bon> bons) {
		this.bons = bons;
	}

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

}
