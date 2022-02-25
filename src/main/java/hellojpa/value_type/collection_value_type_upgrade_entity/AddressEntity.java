package hellojpa.value_type.collection_value_type_upgrade_entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/* Member 의 컬렉션 값 타입인 List<Address>
 - 값 타입인 Address 를 wrapping 한 AddressEntity 를 정의 (엔티티로 승격)
 - Member vs AddressEntity: 일대다 단방향 연관관계
*/

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {
	@Id @GeneratedValue
	private Long id;

	private Address address;

	public AddressEntity() {}

	public AddressEntity(String city, String street, String zipcode) {
		this.address = new Address(city, street, zipcode);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
