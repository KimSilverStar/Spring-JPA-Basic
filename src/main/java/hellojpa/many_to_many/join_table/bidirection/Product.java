package hellojpa.many_to_many.join_table.bidirection;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
	@Id @GeneratedValue
	@Column(name = "PRODUCT_ID")
	private Long id;

	@ManyToMany(mappedBy = "products")
	private List<Member> members = new ArrayList<>();

	@Column(name = "NAME")
	private String name;

	public Product() {}

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
