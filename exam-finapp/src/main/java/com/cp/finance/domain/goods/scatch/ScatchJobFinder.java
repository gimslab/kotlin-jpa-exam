package com.cp.finance.domain.goods.scatch;

import lombok.val;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.cp.finance.domain.goods.scatch.ScatchJobType.PAYMENTS_GENERATION;

@Service
@Transactional(readOnly = true)
public class ScatchJobFinder {

	private final ScatchJobRepository scatchJobRepository;

	public ScatchJobFinder(ScatchJobRepository scatchJobRepository) {
		this.scatchJobRepository = scatchJobRepository;
	}

	public List<ScatchJob> findBy(ScatchJobType type, ScatchJobStatus status, DateTime dttm) {
		List<ScatchJob> list = scatchJobRepository.findByTypeAndStatusAndCreatedAtAfter(type, status, dttm);
		list.forEach(Object::toString);
		return list;
	}

	public String findByTypeAndFromTo() {
		val list = scatchJobRepository.findScatchJob(
												PAYMENTS_GENERATION, LocalDate.now().minusYears(1), LocalDate.now());
		StringBuilder sb = new StringBuilder();
		list.stream()
				.map(Object::toString)
				.forEach(sb::append);
		return sb.toString();
	}
}

