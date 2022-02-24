package hellojpa.various_mapping.many_to_one.bidirection;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Team {
	@Id @GeneratedValue
	@Column(name = "TEAM_ID")
	private Long id;

	@OneToMany(mappedBy = "team")		// 양방향 연관관계의 주인: Member.team
	private List<Member> members = new ArrayList<>();

	@Column(name = "NAME")
	private String name;

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
}
