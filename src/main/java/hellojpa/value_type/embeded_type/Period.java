package hellojpa.value_type.embeded_type;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

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
}
