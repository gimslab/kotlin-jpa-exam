package com.cp.finance.domain.goods.scatch;

import com.cp.infrastructure.persistence.jpa.springdatajpa.CpJpaRepository;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScatchJobRepository extends CpJpaRepository<ScatchJob, Long>, ScatchJobRepositoryCustom {

	List<ScatchJob> findByTypeAndStatusAndCreatedAtAfter(ScatchJobType type, ScatchJobStatus status, DateTime createdAt);
}
