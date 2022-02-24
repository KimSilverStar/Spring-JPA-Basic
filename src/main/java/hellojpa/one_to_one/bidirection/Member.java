package hellojpa.one_to_one.bidirection;

import javax.persistence.*;

/* 일대일, 양방향
- 주 테이블(Member)에 외래 키 지정하는 방식
  <=> 대상 테이블(Locker)에 외래 키 지정하는 방식도 가능
  => 주 테이블 or 대상 테이블 둘 중에 외래 키 선택
- 외래 키에 데이터베이스 유니크(UNI) 제약조건 추가
- 외래 키를 갖는 쪽이 연관관계의 주인
  => 주인 반대쪽에는 mappedBy 명시
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
