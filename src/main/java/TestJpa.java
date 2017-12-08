import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJpa {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();

		Query query = em.createQuery("select a from Article a");

		Article a = (Article) query.getResultList().get(0);
		
		
		
		/*Article article = new Article() ;
		 int id= article.getId() ;
		
		em.persist(article);*/
		
		System.out.println(a.toString());
		
		
		em.close();

		entityManagerFactory.close();

	}
}