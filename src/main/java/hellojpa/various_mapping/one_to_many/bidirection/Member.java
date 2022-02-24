package hellojpa.various_mapping.one_to_many.bidirection;

import javax.persistence.*;

//@Entity
public class Member {
	@Id @GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)		// 읽기 전용
	private Team team;

	@Column(name = "USERNAME")
	private String username;

	public Member() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
