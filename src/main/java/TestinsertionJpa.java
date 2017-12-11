import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestinsertionJpa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		// inserer un article
		Article article = new Article();
		article.setId(2000202021);
		article.setRef("A0005");
		article.setPrix(12.50);
		article.setFournisseur(em.find(Fournisseur.class, 3));

		em.persist(article);

		// inserer un bon de commande
		Bon bon = new Bon();
		bon.setId(258741);
		bon.setNumero(9);
		bon.getArticles().add(article);
		bon.getArticles().add(em.find(Article.class, 2));

		et.commit();

		em.close();
		entityManagerFactory.close();

	}
}
