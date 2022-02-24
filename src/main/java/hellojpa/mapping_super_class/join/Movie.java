package hellojpa.mapping_super_class.join;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")		// 상위 테이블 Item 의 DTYPE 값 지정 (디폴트: 엔티티 이름)
public class Movie extends Item {
	private String director;
	private String actor;

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}
}
