package hellojpa.one_to_one.unidirection;

import javax.persistence.*;

/* 일대일, 단방향
- 주 테이블(Member)에 외래 키 지정
  <=> 일대일, 단방향은 대상 테이블(Locker)에 외래 키 지정 X (JPA 지원 X)
- 외래 키에 데이터베이스 유니크(UNI) 제약조건 추가
*/

//@Entity
public class Member {
	@Id @GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;

	@Column(name = "USERNAME")
	private String username;

	@OneToOne
	@JoinColumn(name = "LOCKER_ID")
	private Locker locker;

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

	public Locker getLocker() {
		return locker;
	}

	public void setLocker(Locker locker) {
		this.locker = locker;
	}
}
