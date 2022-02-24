package hellojpa.mapping_super_class.single_table;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//@Entity
@DiscriminatorValue("B")		// 상위 테이블 Item 의 DTYPE 값 지정 (디폴트: 엔티티 이름)
public class Book extends Item {
	private String author;
	private String isbn;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
