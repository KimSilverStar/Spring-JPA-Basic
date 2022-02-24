package hellojpa.many_to_many.entity_upgrade.bidirection;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/* 다대다, 양방향
- MemberProduct (연결 테이블 엔티티) 와 Product
  => 다대일
  => 다(N) 쪽인 MemberProduct 에 외래 키 존재, 연관관계의 주인
- 연관관계의 주인이 아닌 Product 에는 mappedBy 로 주인 명시
*/

@Entity
public class Product {
	@Id @GeneratedValue
	@Column(name = "PRODUCT_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@OneToMany(mappedBy = "product")	// 양방향 연관관계의 주인: MemberProduct.product
	private List<MemberProduct> memberProducts = new ArrayList<>();

	public Product() {}

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

	public List<MemberProduct> getMemberProducts() {
		return memberProducts;
	}

	public void setMemberProducts(List<MemberProduct> memberProducts) {
		this.memberProducts = memberProducts;
	}
}
