package hellojpa.value_type.collection_value_type_upgrade_entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		// persistence.xml 의 <persistence-unit name="hello">
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();		// DB 커넥션 얻기
		tx.begin();

		try {
			Member member = new Member();
			member.setUsername("member1");
			member.setHomeAddress(
					new Address("homeCity", "street", "100")
			);

			member.getFavoriteFoods().add("치킨");		// 컬렉션 값 타입에 원소 추가
			member.getFavoriteFoods().add("피자");
			member.getFavoriteFoods().add("족발");

			member.getAddressHistory().add(
					new AddressEntity("old1", "street1", "1")
			);
			member.getAddressHistory().add(
					new AddressEntity("old2", "street2", "2")
			);

			em.persist(member);
			// 1) MEMBER 테이블에 member 값 추가
			// 2) FAVORITE_FOOD 테이블에 원소 3개 추가
			// 3) ADDRESS 테이블에 원소 2개 추가
			// 값 타입(기본 값, 임베디드, 컬렉션)의 라이프 사이클
			// => 해당 값을 소유한 엔티티에 의존

			em.flush();
			em.clear();

			System.out.println("--------------- START ---------------");
			Member findMember = em.find(Member.class, member.getId());

			List<AddressEntity> addressHistory = findMember.getAddressHistory();
			for (AddressEntity addressEntity : addressHistory)
				System.out.println("addressEntity = " + addressEntity.getAddress().getCity());

			Set<String> favoriteFoods = findMember.getFavoriteFoods();
			for (String favoriteFood : favoriteFoods)
				System.out.println("favoriteFood = " + favoriteFood);

			// 값 타입의 수정 - setter 수정자로 수정하지 말고, 새로운 값을 채운 객체를 새로 생성
			// => setter 를 통한 수정을 막기 위해, setter 를 정의 X 한 불변 객체 이용할 것
			Address oldAddress = findMember.getHomeAddress();
			findMember.setHomeAddress(
					new Address("newCity", oldAddress.getStreet(), oldAddress.getZipcode())
			);

			// 치킨 -> 한식 으로 교체
			findMember.getFavoriteFoods().remove("치킨");
			findMember.getFavoriteFoods().add("한식");

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
