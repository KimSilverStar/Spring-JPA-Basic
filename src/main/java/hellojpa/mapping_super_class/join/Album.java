package hellojpa.mapping_super_class.join;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")		// 상위 테이블 Item 의 DTYPE 값 지정 (디폴트: 엔티티 이름)
public class Album extends Item {
	private String artist;

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
}
