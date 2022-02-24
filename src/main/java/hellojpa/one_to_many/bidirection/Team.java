package hellojpa.one_to_many.bidirection;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/* 일대다, 양방향
- 일대다 양방향은 공식적으로는 존재 X
  => 다대일 양방향을 사용할 것
- @JoinColumn(insertable = false, updatable = false)
  => 읽기 전용 필드로 만들어서, 양방향 처럼 흉내
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
