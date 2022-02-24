package hellojpa.mapping_super_class.single_table;

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

			// Movie 를 조회하기 위해서, Item 과 Movie 를 join 할 필요 X
			// => 하나의 큰 단일 테이블 Item 을 바로 조회
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
