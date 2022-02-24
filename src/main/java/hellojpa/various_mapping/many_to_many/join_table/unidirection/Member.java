package hellojpa.various_mapping.many_to_many.join_table.unidirection;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/* 다대다, 단방향
- @JoinTable 로 연결 테이블 지정
*/

//@Entity
public class Member {
	@Id @GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;

	@Column(name = "USERNAME")
	private String username;

	@ManyToMany
	@JoinTable(name = "MEMBER_PRODUCT")			// 연결 테이블
	private List<Product> products = new ArrayList<>();

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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
