import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJpa {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();

		Query query = em.createQuery("select a from Article a where a.ref='F01'");

		Article a = (Article) query.getSingleResult();

		
		 //Article article = new Article() ; 
		 
		//int id= article.getId() ; 
		
		if(a!=null)
		{
		 
		 System.out.println(a.toString());
		}
		
		

		em.close();

		entityManagerFactory.close();

	}
}