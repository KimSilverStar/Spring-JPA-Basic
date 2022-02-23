package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		// persistence.xml 의 <persistence-unit name="hello">
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();		// DB 커넥션 얻기
		tx.begin();

		try {
			// 1) 회원 등록
//			Member member = new Member();
//			member.setId(2L);
//			member.setName("HelloB");
//
//			em.persist(member);				// 엔티티를 영속화 (영속 상태)
//
//			tx.commit();

			// 2) 회원 수정 -
//			Member findMember = em.find(Member.class, 1L);
//			findMember.setName("HelloJPA");
//			// setter 로 수정 후, em.persist(엔티티); 로 저장하지 않아도 됨
//			// => JPA 가 엔티티의 변경 및 수정 여부를 트랜잭션 커밋 전에 체크
//			// => 변경된 경우, 업데이트 쿼리를 자동으로 호출
//
//			tx.commit();

			// 3) 회원 삭제
//			Member findMember = em.find(Member.class, 1L);
//			em.remove(findMember);
//
//			tx.commit();

//			List<Member> result = em.createQuery("select m from Member as m", Member.class)
//					.setFirstResult(5)
//					.setMaxResults(8)
//					.getResultList();
//
//			for (Member member : result)
//				System.out.println("member = " + member.getName());

			/* 테스트 1 - [영속성 이점: 1차 캐시]  */
//			// 비영속 상태 (엔티티 객체 생성)
//			Member member = new Member();
//			member.setId(101L);
//			member.setName("HelloJPA");
//
//			// 영속 상태 (엔티티 객체를 저장하여, 영속 컨텍스트에서 관리) => 1차 캐시에 저장
//			System.out.println("--- BEFORE ---");
//			em.persist(member);
//			System.out.println("--- AFTER ---");
//
//			// SQL SELECT 쿼리문 호출 X
//			// => em.persist(member); 를 수행하면서, 1차 캐시에 엔티티 객체 저장함
//			// => DB 에 접근하지 않고, 1차 캐시에 있는 member 를 가져옴
//			Member findMember = em.find(Member.class, 101L);
//			System.out.println("findMember.id = " + findMember.getId());
//			System.out.println("findMember.name = " + findMember.getName());
//
//			tx.commit();

			/* 테스트 2 - [영속성 이점: 1차 캐시, 영속 엔티티의 동일성 보장] */
//			Member findMember1 = em.find(Member.class, 101L);	// 처음: DB 접근 (SELECT 쿼리)
//			Member findMember2 = em.find(Member.class, 101L);	// 이후: 1차 캐시 Hit
//			System.out.println("result = " + (findMember1 == findMember2));		// true
//			// 영속 상태인 엔티티의 경우, 동일성 보장
//
//			tx.commit();

			/* 테스트 3 - [영속성 이점: 트랜잭션을 지원하는 쓰기 지연] */
//			Member member1 = new Member(150L, "A");
//			Member member2 = new Member(160L, "B");
//
//			// em.persist(엔티티);
//			// => 1차 캐시에 엔티티 저장, 쓰기 지연 SQL 저장소에 쿼리문 쌓아둠
//			em.persist(member1);
//			em.persist(member2);
//			System.out.println("--------------------");
//
//			tx.commit();		// 쓰기 지연 SQL 저장소에 쌓인 쿼리문을 한번에 DB에 보냄

			/* 테스트 4 - [영속성 이점: 변경 감지] */
//			Member member = em.find(Member.class, 150L);	// 영속 엔티티 조회
//			member.setName("ZZZ");		// 영속 엔티티 수정
//
////			em.persist(member);			// 영속 엔티티 수정 후, em.persist() 불필요
//			System.out.println("--------------------");
//
//			// 커밋 시점에 변경 감지(Dirty Checking)하여, 수정된 영속 엔티티 반영
//			tx.commit();

			/* 테스트 5 - [영속 컨텍스트 플러시] */
//			Member member = new Member(200L, "member200");
//			em.persist(member); // 영속성 컨텍스트에 엔티티 저장
//			// => 1차 캐시에 엔티티 저장, 쓰기 지연 SQL 저장소에 쿼리문 쌓아둠
//
//			em.flush();		// 플러시(직접 호출) => DB 에 SQL 쿼리문 바로 호출
//			System.out.println("--------------------");
//
//			tx.commit();

			/* 테스트 6 - [영속 컨텍스트를 준영속으로 분리] */
//			Member member = em.find(Member.class, 150L);		// 영속 상태
//			member.setName("AAA");
//
//			em.detach(member);		// 1) 영속성 컨텍스트에서 관리되는 member 엔티티를 분리 => 준영속 상태
////			em.clear();				// 2) 영속석 컨텍스트에서 관리되는 모든 엔티티를 초기화 => 준영속 상태
//			System.out.println("--------------------");
//
//			// 준영속 상태로 더 이상 영속성 컨텍스트에서 member 관리 X
//			// => 변경 감지(Dirty Checking)으로 인한 member.setName() Update 쿼리문 호출 X
//			tx.commit();

			/* 기본 키 매핑 - IDENTITY, SEQUENCE, TABLE 전략 테스트 */
//			Member member = new Member();
//			member.setUsername("UserA");		// id 값은 DB 가 자동으로 채움
//
//			em.persist(member);
//
//			tx.commit();

			Team team = new Team();
			team.setName("TeamA");
			em.persist(team);			// team 을 영속화 => team 에 id 값 채워짐

			Member member = new Member();
			member.setUsername("member1");
//			member.setTeamId(team.getId());		// 외래 키를 직접 다룸 (바람직 X)
			member.setTeam(team);
			em.persist(member);

			em.flush();
			em.clear();

			Member findMember = em.find(Member.class, member.getId());
			Team findTeam = findMember.getTeam();
			System.out.println("findTeam = " + findTeam.getName());

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}

		emf.close();
	}
}
