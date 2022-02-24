package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent {
	@Id @GeneratedValue
	private Long id;

	private String name;

	// 양방향 연관관계의 주인: Child.parent
	// CasCadeType.ALL: Parent 의 영속성을 Child 에게 전이
	// orphanRemoval = true: 컬렉션 childList 에서 Child 가 삭제되면, Child 의 테이블에서도 삭제
	@OneToMany(mappedBy = "parent",
			cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Child> childList = new ArrayList<>();

	// 양방향 연관관계 편의 메소드
	public void addChild(Child child) {
		childList.add(child);
		child.setParent(this);
	}

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

	public List<Child> getChildList() {
		return childList;
	}

	public void setChildList(List<Child> childList) {
		this.childList = childList;
	}
}
