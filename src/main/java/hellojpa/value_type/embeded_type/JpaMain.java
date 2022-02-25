package hellojpa.value_type.embeded_type;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		// persistence.xml 의 <persistence-unit name="hello">
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();		// DB 커넥션 얻기
		tx.begin();

		try {
			Address address1 = new Address("city", "street", "10000");
			Address address2 = new Address("city", "street", "10000");

			System.out.println("address1 == address2: " + (address1 == address2));			// false
			System.out.println("address1 equals address2: " + address1.equals(address2));	// true

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

		emf.close();
	}
}
