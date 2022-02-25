package hellojpa.value_type.collection_value_type_upgrade_entity;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable			// 임베디드 타입 정의
public class Period {
	private LocalDateTime startDate;
	private LocalDateTime endDate;

	public Period() {}

	public Period(LocalDateTime startDate, LocalDateTime endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Period period = (Period) o;
		return Objects.equals(startDate, period.startDate) &&
				Objects.equals(endDate, period.endDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(startDate, endDate);
	}
}
