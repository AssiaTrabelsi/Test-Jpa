import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bon")
public class Bon {

	@Id
	private int id;
	@Column
	private int numero;
	@Column(name = "date_cmd")
	private Date dateCmd;
	@Column
	private int delai;

	@ManyToOne
	@JoinColumn(name = "ID_FOU")
	private Fournisseur fournisseur;

	@ManyToMany
	@JoinTable(name = "compo", joinColumns = @JoinColumn(name = "ID_BON", referencedColumnName = "ID"),

			inverseJoinColumns = @JoinColumn(name = "Id_Article", referencedColumnName = "ID"))

	private Set<Article> articles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getDateCmd() {
		return dateCmd;
	}

	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}

	public int getDelai() {
		return delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

}
