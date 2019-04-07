package com.cp.finance.domain.goods.scatch;

import org.joda.time.LocalDate;

import java.util.List;

public interface ScatchJobRepositoryCustom {

	ScatchJob findScatchJobById(Long id);

	ScatchJobItem findScatchJobItemById(Long id);

	List<ScatchJob> findScatchJob(ScatchJobType type, LocalDate from, LocalDate to);

	ScatchJob existProcessJob(ScatchJob job);
}
