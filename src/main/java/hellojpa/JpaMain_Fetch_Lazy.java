package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain_Fetch_Lazy {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		// persistence.xml 의 <persistence-unit name="hello">
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();		// DB 커넥션 얻기
		tx.begin();

		try {
			Team team = new Team();
			team.setName("teamA");
			em.persist(team);

			Member member1 = new Member();
			member1.setUsername("member1");
			member1.setTeam(team);
			em.persist(member1);

			// 영속성 컨텍스트를 모두 비움 => 1차 캐시 비움
			em.flush();
			em.clear();

			Member findMember = em.find(Member.class, member1.getId());
			System.out.println("findMember.team = " + findMember.getTeam().getClass());
			// 프록시 객체 출력됨

			System.out.println("--------------------");
			// Team 에 접근하는 시점에 프록시 초기화 (DB 접근)
			System.out.println(member1.getTeam().getName());
			System.out.println("--------------------");

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
