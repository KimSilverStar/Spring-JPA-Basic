package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class JpaMain_Proxy {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		// persistence.xml 의 <persistence-unit name="hello">
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();		// DB 커넥션 얻기
		tx.begin();

		try {
			Member member = new Member();
			member.setUsername("hello");

			em.persist(member);

			// 영속성 컨텍스트를 모두 비움 => 1차 캐시 비움
			em.flush();
			em.clear();

			/* 프록시 엔티티 조회(초기화) */
			Member refMember = em.getReference(Member.class, member.getId());	// 프록시 엔티티
			// 프록시 객체 초기화 여부 = false
			System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));
			// 실제 엔티티 객체가 필요할 때까지, DB 조회를 미룸
			System.out.println("refMember.id = " + refMember.getId());
//			System.out.println("refMember.username = " + refMember.getUsername());	// 프록시 초기화
			Hibernate.initialize(refMember);			// 프록시 강제 초기화
			// 프록시 객체 초기화 여부 = true
			System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));

			/* 프록시 엔티티 초기화 예외 오류 - 준영속 상태 or 영속성 컨텍스트 사용 불가능한 경우 */
//			// 준영속 상태에서 프록시를 초기화하면 문제 발생
//			Member refMember = em.getReference(Member.class, member.getId());	// 프록시 엔티티
//			em.detach(refMember);		// 준영속 상태로 만듦
//			em.close();					// 또는 영속성 컨텍스트 종료
//			System.out.println(refMember.getUsername());

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
