package hellojpa.many_to_one.bidirection;

import javax.persistence.*;

/* 다대일, 양방향
- 다대일, 단방향에서 반대편(대상 테이블)에 참조 추가
  => 단방향에서 반대편에 참조 추가해도, 테이블에는 변화 X
- @JoinColumn 으로 외래 키 지정
- 외래 키가 있는 쪽이 양방향 연관관계의 주인
  => 반대편(Team)에 mappedBy 로 양방향 연관관계의 주인 명시
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
