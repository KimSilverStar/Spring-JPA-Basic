package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Team extends BaseEntity {
	@Id @GeneratedValue
	@Column(name = "TEAM_ID")
	private Long id;

	private String name;

	// 팀, 회원 - 일대다 연관관계
	@OneToMany(mappedBy = "team")		// 양방향 연관관계에서, 주인 Member.team 에 의해 매핑됨
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

	// 양방향 연관관계 편의 메소드
	public void addMember(Member member) {
		members.add(member);
		member.setTeam(this);		// 연관관계의 주인: Member.team
	}
}
