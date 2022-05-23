import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestDeletAccount {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		UserAccount account = entityManager.find(UserAccount.class, 1) ;
		if(account != null)
		{
			entityTransaction.begin();
			
			
			List<Page> pages = account.getPages() ;
			for(Page page : pages) {
				entityManager.remove(page);
			}
			entityManager.remove(account);
			
			entityTransaction.commit();
		}else {
			System.out.println("no account with given id");
		}
	}
}
