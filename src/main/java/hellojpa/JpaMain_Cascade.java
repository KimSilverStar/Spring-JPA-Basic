package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain_Cascade {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		// persistence.xml 의 <persistence-unit name="hello">
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();		// DB 커넥션 얻기
		tx.begin();

		try {
			Child child1 = new Child();
			Child child2 = new Child();

			Parent parent = new Parent();
			parent.addChild(child1);
			parent.addChild(child2);

			// Parent 에서 CascadeType.ALL 명시 (영속성 전이)
			em.persist(parent);		// => em.persist(child1, 2) 자동으로 수행됨
//			em.persist(child1);
//			em.persist(child2);

			em.flush();
			em.clear();

			Parent findParent = em.find(Parent.class, parent.getId());
			findParent.getChildList().remove(0);
			// orphanRemoval = true; 로 인해, 컬렉션에서 제거된 자식을 테이블에서도 자동으로 제거

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
