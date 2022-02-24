package hellojpa;

import javax.persistence.*;

@Entity
public class Child {
	@Id @GeneratedValue
	private Long id;

	private String name;

	@ManyToOne
	@JoinColumn(name = "parent_id")		// 외래 키
	private Parent parent;				// 양방향 연관관계의 주인

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

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}
}
