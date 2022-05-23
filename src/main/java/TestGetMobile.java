import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetMobile {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Mobile mobile = entityManager.find(Mobile.class, 2);
		if (mobile != null) {
			System.out.println("Mobile brand : " + mobile.getName());
			System.out.println("mobile cost  : " + mobile.getCost());
			List<Sim> sims = mobile.getSims();
			for (Sim sim : sims) {
				System.out.println("sim id       : " + sim.getId());
				System.out.println("sim provider : " + sim.getProvider());
				System.out.println("sim type     : " + sim.getType());
			}
		} else {
			System.out.println("no mobile found with given id");
		}

	}
}
