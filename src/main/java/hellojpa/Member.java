package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity			// 객체와 테이블 매핑
//@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")
@TableGenerator(
		name = "MEMBER_SEQ_GENERATOR",
		table = "MY_SEQUENCES",					// 생성되는 Table 이름
		pkColumnValue = "MEMBER_SEQ",
		allocationSize = 1
)
public class Member {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
	@GeneratedValue(strategy = GenerationType.TABLE,
			generator = "MEMBER_SEQ_GENERATOR")
	private Long id;

	// DB Column name 을 "name"으로 지정, null 제약조건 추가
	@Column(name = "name", nullable = false)
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
