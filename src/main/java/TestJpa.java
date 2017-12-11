import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJpa {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		/*
		 * Query query = em.createQuery("select a from Article a where a.ref='F01'");
		 * 
		 * Article a = (Article) query.getSingleResult();
		 * 
		 * if (a != null) {
		 * 
		 * System.out.println(a.toString()); }
		 */
		// jointure JPQL avec les articles

		TypedQuery<Bon> query = em.createQuery("select b from Bon b  INNER JOIN b.articles a where a.ref='A01'",
				Bon.class);

		Bon bon = query.getResultList().get(0);

		Set<Article> articles = bon.getArticles();

		for (Article article : articles) {

			System.out.println(article.getDesignation());
			System.out.println(bon.getFournisseur().getNom());

		}

		em.close();

		entityManagerFactory.close();

	}
}