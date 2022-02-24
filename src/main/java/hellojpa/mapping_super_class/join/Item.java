package hellojpa.mapping_super_class.join;

import javax.persistence.*;

/* 조인 전략
 - Item, Album, Movie, Book 을 각각 테이블로 변환
 - 상위 테이블(Item)과 각각의 하위 테이블(Album, Movie, Book) 을 각각 join
   => 각 하위 테이블에서 ITEM_ID 를 기본 키, 외래 키로 동시에 가짐
*/

@Entity
@Inheritance(strategy = InheritanceType.JOINED)		// 조인 전략
@DiscriminatorColumn		// Item 테이블의 Column 에 DTYPE (엔티티 이름) 추가
public class Item {
	@Id @GeneratedValue
	private Long id;

	private String name;
	private int price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
