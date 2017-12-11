package banque.entitie;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Tp04Jpa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Compte compte = new Compte();
		compte.setNumero("1");
		compte.setSolde(12.40);
		em.persist(compte);

		Compte compte1 = new Compte();
		compte1.setNumero("2");
		compte1.setSolde(13.40);
		em.persist(compte1);

		Compte compte2 = new Compte();
		compte2.setNumero("3");
		compte2.setSolde(15.50);
		em.persist(compte2);
		
		Compte compte3 = new Compte();
		compte3.setNumero("6");
		compte3.setSolde(20.50);
		em.persist(compte3);
		
		LivretA l = new LivretA();
		l.setNumero("3");
		l.setSolde(12.56);
		l.setTaux(2.8);

		em.persist(l);

		AssurenceVie av = new AssurenceVie();
		av.setNumero("4");
		av.setSolde(15.00);
		av.setDateFin(LocalDate.now());
		av.setTaux(4.5);
		em.persist(av);

		et.commit();

		Compte l1 = em.find(Compte.class, 2);

		AssurenceVie av1 =em.find(AssurenceVie.class, 1);
		
		
		System.out.println("Compte:" + l1);
	   System.out.println("Compte:" + av1);
	}

}
