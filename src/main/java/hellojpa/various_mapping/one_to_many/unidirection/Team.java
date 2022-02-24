package hellojpa.various_mapping.one_to_many.unidirection;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/* 일대다, 단방향
- 일(1)이 연관관계의 주인
- 다(N) 쪽에 외래 키 존재
  => 객체와 테이블의 차이로 인해, 반대편 테이블의 외래 키를 관리
- @JoinColumn ㄷ로 외래 키 지정 필수
  => 외래 키 명시 안하면, Join Table 방식으로 동작

* 일대다 단방향 보다는 다대일 양방향을 사용할 것
 - 일대다 단방향은 외래 키가 반대편 테이블에 있고,
   연관관계 관리를 위해 UPDATE 쿼리가 추가로 발생
*/

//@Entity
public class Team {
	@Id @GeneratedValue
	@Column(name = "TEAM_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@OneToMany
	@JoinColumn(name = "TEAM_ID")	// 외래 키: Member 테이블의 TEAM_ID
	private List<Member> members = new ArrayList<>();

	public Team() {}

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

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}
}
