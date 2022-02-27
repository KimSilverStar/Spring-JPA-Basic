package hellojpa.object_oriented_query;

import hellojpa.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		// persistence.xml 의 <persistence-unit name="hello">
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();		// DB 커넥션 얻기
		tx.begin();

		try {
			/* 1) JPQL : 엔티티 객체를 대상으로 쿼리
			  - 쿼리가 문자열 형태 (문자열 처리 등으로 동적 쿼리 작성 어려움) */
			List<Member> resultList1 = em.createQuery(
					"select m from Member m where m.username like '%kim%'",
					Member.class
			).getResultList();

			for (Member member : resultList1)
				System.out.println("member = " + member);

			/* 2) Criteria
			  - 쿼리가 문자열이 아님 (메소드 등 제공) */
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Member> query = cb.createQuery(Member.class);

			Root<Member> m = query.from(Member.class);		// 루트 클래스: 조회 시작 클래스
			CriteriaQuery<Member> cq = query.
					select(m).where(cb.equal(m.get("username"), "kim"));
			List<Member> resultList2 = em.createQuery(cq).getResultList();

			for (Member member : resultList2)
				System.out.println("member = " + member);

			/* 3) QueryDSL
			  - 별도의 라이브러리, Criteria 처럼 쿼리를 자바 코드로 작성 */

			/* 4) 네이티브 SQL
			  - 문자열로 SQL 을 직접 사용, 특정 DB 에 의존적인 기능 */
			Member mm = new Member();
			mm.setUsername("mm");
			em.persist(mm);		// 영속성 컨텍스트에만 mm 존재. 아직 DB 에는 mm 없음

			// 영속성 컨텍스트 em.flush() 하는 경우 - em.commit(), SQL query
			List<Member> resultList3 = em.createNativeQuery(
					"select MEMBER_ID, USERNAME from MEMBER",
					Member.class
			).getResultList();
			// SQL 쿼리하였으므로 자동으로 영속성 컨텍스트 flush 되어, DB 에 mm 저장됨

			for (Member member : resultList3)
				System.out.println("member = " + member.getUsername());

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
