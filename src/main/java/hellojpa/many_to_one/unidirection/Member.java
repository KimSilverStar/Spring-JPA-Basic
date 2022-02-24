package hellojpa.many_to_one.unidirection;

import javax.persistence.*;

/* 다대일, 단방향
- 주 테이블의 대상 참조 객체에 @ManyToOne 연관관계 명시
- @JoinColumn 으로 외래 키 지정
*/

@Entity
public class Member {
	@Id @GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;

	@Column(name = "USERNAME")
	private String username;

	@ManyToOne		// 다대일
	@JoinColumn(name = "TEAM_ID")		// 외래 키
	private Team team;

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

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
}
