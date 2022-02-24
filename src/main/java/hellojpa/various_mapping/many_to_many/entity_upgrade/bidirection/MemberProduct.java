package hellojpa.various_mapping.many_to_many.entity_upgrade.bidirection;

import javax.persistence.*;
import java.time.LocalDateTime;

/* 다대다, 양방향
* MemberProduct: 연결 테이블을 엔티티로 승격
 => 다대다 연관관계를 일대다 + 다대일 연관관계로 풀어냄

1) Member 와 MemberProduct (연결 테이블 엔티티)
  - 일대다
  - 다(N) 쪽인 MemberProduct 에 외래 키 존재, 연관관계의 주인

2) Product 와 MemberProduct (연결 테이블 엔티티)
  - 다대일
  - 다(N) 쪽인 MemberProduct 에 외래 키 존재, 연관관계의 주인

=> 연관관계의 주인인 MemberProduct 에
   Member, Product 를 참조하는 외래 키 지정
=> 연결 테이블을 엔티티로 승격했으므로, 데이터 추가 가능
   ex) 수량, 가격, 주문 시간 등
*/

public class MemberProduct {
	@Id @GeneratedValue
	@Column(name = "MEMBER_PRODUCT_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member member;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;

	private int count;
	private int price;

	private LocalDateTime orderDateTime;

	public MemberProduct() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}
}
