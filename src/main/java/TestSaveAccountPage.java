import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveAccountPage {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		Page page1 =  new Page() ;
		page1.setName("facebook");
		page1.setTitle("congress");
		page1.setDescription("waste party") ;
		
		Page page2 =  new Page() ;
		page2.setName("facebook");
		page2.setTitle("BJP");
		page2.setDescription("super party") ;
		
		List<Page> pages = new ArrayList<Page>() ;
		pages.add(page1) ;
		pages.add(page2) ;
		
		UserAccount account = new UserAccount() ;
		account.setEmail("bunny@mail.com");
		account.setPassword("bunny");
		account.setMobile("7001444676");
		account.setName("bunny");
		account.setPages(pages);
		
		entityTransaction.begin();
		entityManager.persist(page1);
		entityManager.persist(page2);
		entityManager.persist(account);
		entityTransaction.commit();
	
		
	}
}
