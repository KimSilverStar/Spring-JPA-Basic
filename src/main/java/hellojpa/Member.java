package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity			// 객체와 테이블 매핑
public class Member {
	@Id
	private Long id;

	@Column(name = "name")			// DB Column name 을 "name"으로 지정
	private String username;

	private Integer age;

	@Enumerated(EnumType.STRING)			// Enum 타입 매핑 (반드시 EnumType.STRING 사용할 것)
	private RoleType roleType;

	@Temporal(TemporalType.TIMESTAMP)		// TIMESTAMP: 날짜 + 시간
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;

	@Lob									// Lob: 큰 컨텐츠
	private String description;				// => 문자는 CLOB 으로 매핑

	public Member() {}

//	public Member(Long id, String name) {
//		this.id = id;
//		this.name = name;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
}
