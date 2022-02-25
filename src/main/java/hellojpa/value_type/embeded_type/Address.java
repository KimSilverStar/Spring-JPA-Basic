package hellojpa.value_type.embeded_type;

import javax.persistence.Embeddable;

@Embeddable			// 임베디드 타입 정의
public class Address {
	private String city;
	private String street;
	private String zipcode;

	public Address() {}

	public Address(String city, String street, String zipcode) {
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public String getZipcode() {
		return zipcode;
	}
}
