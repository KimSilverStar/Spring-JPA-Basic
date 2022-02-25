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
			Member member = new Member();
			member.setUsername("hello");
			member.setWorkPeriod(new Period());
			member.setHomeAddress(
					new Address("city", "street", "zipcode")
			);

			em.persist(member);

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
