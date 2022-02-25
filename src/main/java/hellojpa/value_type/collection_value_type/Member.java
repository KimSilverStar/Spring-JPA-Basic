package hellojpa.value_type.collection_value_type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Entity
public class Member {
	@Id @GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;

	@Column(name = "USERNAME")
	private String username;

	@Embedded		// 임베디드 타입 명시
	private Period workPeriod;

	@Embedded		// 임베디드 타입 명시
	private Address homeAddress;

	@ElementCollection		// 컬렉션 값 타입 명시
	@CollectionTable(name = "FAVORITE_FOOD",
			joinColumns = @JoinColumn(name = "MEMBER_ID"))		// 컬렉션이 저장될 테이블 명시
	@Column(name = "FOOD_NAME")
	private Set<String> favoriteFoods = new HashSet<>();

	@ElementCollection		// 컬렉션 값 타입 명시
	@CollectionTable(name = "ADDRESS",
			joinColumns = @JoinColumn(name = "MEMBER_ID"))		// 컬렉션이 저장될 테이블 명시
	private List<Address> addressHistory = new ArrayList<>();

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

	public Period getWorkPeriod() {
		return workPeriod;
	}

	public void setWorkPeriod(Period workPeriod) {
		this.workPeriod = workPeriod;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Set<String> getFavoriteFoods() {
		return favoriteFoods;
	}

	public void setFavoriteFoods(Set<String> favoriteFoods) {
		this.favoriteFoods = favoriteFoods;
	}

	public List<Address> getAddressHistory() {
		return addressHistory;
	}

	public void setAddressHistory(List<Address> addressHistory) {
		this.addressHistory = addressHistory;
	}
}
