package hellojpa.mapping_super_class.table_per_class;

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
			Movie movie = new Movie();
			movie.setDirector("DirectorA");
			movie.setActor("ActorA");
			movie.setName("바람과 함께 사라지다");
			movie.setPrice(10000);

			em.persist(movie);

			em.flush();
			em.clear();
			// 영속성 컨텍스트를 모두 비움 => 1차 캐시를 모두 비움

			// Item 테이블이 존재 X
			// 각각의 구현 클래스가 테이블이 되어 모든 값을 각각 가짐
			Movie findMovie = em.find(Movie.class, movie.getId());
			System.out.println("findMovie = " + findMovie);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}

		emf.close();
	}
}
