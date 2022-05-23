import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveMobileSim {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
	
		
		Sim sim3 = new Sim() ;
		sim3.setProvider("airtel");
		sim3.setType("4g");
		
		Sim sim4 = new Sim() ;
		sim4.setProvider("bsnl");
		sim4.setType("4g");
		
		Sim sim5 = new Sim() ;
		sim5.setProvider("vi");
		sim5.setType("4g");
		
		List<Sim> sims1 = new ArrayList<Sim>() ;
		
		sims1.add(sim3) ;
		
		List<Sim> sims2 = new ArrayList<Sim>() ;
		sims2.add(sim4) ;
		sims2.add(sim5) ;
		
		
		
		
		Mobile mobile2 = new Mobile() ;
		mobile2.setName("sony");
		mobile2.setCost(14500);
		mobile2.setSims(sims1);
		
		Mobile mobile3 = new Mobile() ;
		mobile3.setName("mi");
		mobile3.setCost(14500);
		mobile3.setSims(sims2);
		
		entityTransaction.begin();
		entityManager.persist(sim3);
		entityManager.persist(sim4);
		entityManager.persist(sim5);
		entityManager.persist(mobile2);
		entityManager.persist(mobile3);
		entityTransaction.commit();
		
	}
}
