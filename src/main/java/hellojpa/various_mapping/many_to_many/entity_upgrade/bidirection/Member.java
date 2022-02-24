package hellojpa.various_mapping.many_to_many.entity_upgrade.bidirection;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/* 다대다, 양방향
- Member 와 MemberProduct (연결 테이블 엔티티)
  => 일대다
  => 다(N) 쪽인 MemberProduct 에 외래 키 존재, 연관관계의 주인
- 연관관계의 주인이 아닌 Member 에는 mappedBy 로 주인 명시
*/

//@Entity
public class Member {
	@Id @GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;

	@Column(name = "USERNAME")
	private String username;

	@OneToMany(mappedBy = "member")		// 양방향 연관관계의 주인: MemberProduct.member
	private List<MemberProduct> memberProducts = new ArrayList<>();

	public Member() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<MemberProduct> getMemberProducts() {
		return memberProducts;
	}

	public void setMemberProducts(List<MemberProduct> memberProducts) {
		this.memberProducts = memberProducts;
	}
}
