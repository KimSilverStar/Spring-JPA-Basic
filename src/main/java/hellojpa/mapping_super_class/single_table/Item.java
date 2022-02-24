package hellojpa.mapping_super_class.single_table;

import javax.persistence.*;

/* 단일 테이블 전략
 - 자식 엔티티(Album, Book, Movie)의 칼럼을 모두 갖는
   하나의 큰 테이블(Item) 이용
*/

//@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)		// 단일 테이블 전략
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
