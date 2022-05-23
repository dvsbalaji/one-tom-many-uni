import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetAccount {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		UserAccount account = entityManager.find(UserAccount.class, 1);
		if (account != null) {
			System.out.println("account email : " + account.getEmail());
			System.out.println("account mobile : " + account.getMobile());
			System.out.println("account name : " + account.getName());

			List<Page> pages = account.getPages();
			for (Page page : pages) {
				System.out.println("------------------------------------------------------------");
				System.out.println("page name : "+page.getName());
				System.out.println("page title : "+page.getTitle());
				System.out.println("page desc : "+page.getDescription());
			}

		} else {
			System.out.println("no account found");
		}

	}
}
