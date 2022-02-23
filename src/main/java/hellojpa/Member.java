package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity			// 객체와 테이블 매핑
//@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")
//@TableGenerator(
//		name = "MEMBER_SEQ_GENERATOR",
//		table = "MY_SEQUENCES",					// 생성되는 Table 이름
//		pkColumnValue = "MEMBER_SEQ",
//		allocationSize = 1
//)
public class Member {
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
//	@GeneratedValue(strategy = GenerationType.TABLE,
//			generator = "MEMBER_SEQ_GENERATOR")
	@Id @GeneratedValue			// strategy 속성 디폴트: AUTO
	@Column(name = "MEMBER_ID")
	private Long id;

	// DB Column name 을 "name"으로 지정, null 제약조건 추가
//	@Column(name = "name", nullable = false)
	@Column(name = "USERNAME")
	private String username;

	// 객체를 테이블에 맞추어 데이터 중심 설계한 잘못된 경우
//	@Column(name = "TEAM_ID")
//	private Long teamId;

	// 객체지향 모델링: 객체 참조 이용 => 연관관계 명시, 외래 키 매핑
	@ManyToOne						// 회원, 팀 - 다대일 연관관계
	@JoinColumn(name = "TEAM_ID")	// 외래 키 매핑
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
