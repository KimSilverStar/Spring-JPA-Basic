package hellojpa.mapping_super_class.table_per_class;

import javax.persistence.*;

/* 구현 클래스마다 테이블 전략
 - 상위 테이블(Item)을 두지 않고,
   각 구현 클래스마다 테이블을 구성
   => Item 이 추상 클래스로 테이블이 되지 않음 !!
 - 사용하지 말아야 하는 전략
*/

//@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)	// 구현 클래스마다 테이블 전략
@DiscriminatorColumn		// Item 테이블의 Column 에 DTYPE (엔티티 이름) 추가
public abstract class Item {
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
