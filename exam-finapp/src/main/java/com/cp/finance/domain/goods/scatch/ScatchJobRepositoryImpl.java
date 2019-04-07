package com.cp.finance.domain.goods.scatch;

import com.cp.finance.domain.support.querydsl.FinanceQueryDslRepositorySupport;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.joda.time.LocalDate;
import com.cp.finance.domain.goods.scatch.QScatchJob;
import com.cp.finance.domain.goods.scatch.QScatchJobItem;

import java.util.List;

import static com.cp.finance.domain.goods.scatch.QScatchJob.scatchJob;
import static com.cp.finance.domain.goods.scatch.QScatchJobItem.scatchJobItem;

public class ScatchJobRepositoryImpl extends FinanceQueryDslRepositorySupport implements ScatchJobRepositoryCustom {

	public ScatchJobRepositoryImpl() {
		super(ScatchJob.class);
	}

	QScatchJob qScatchJob = scatchJob;
	QScatchJobItem qScatchJobItem = QScatchJobItem.scatchJobItem;

	@Override
	public ScatchJob findScatchJobById(Long id) {
		return from(scatchJob).where(scatchJob.id.eq(id)).fetchOne();
	}

	@Override
	public ScatchJobItem findScatchJobItemById(Long id) {
		return from(scatchJobItem).where(scatchJobItem.id.eq(4L)).fetchOne();
	}

	@Override
	public List<ScatchJob> findScatchJob(ScatchJobType type, LocalDate from, LocalDate to) {
		BooleanBuilder predicate = new BooleanBuilder();
		predicate.and(qScatchJob.type.eq(type));
		predicate.and(qScatchJob.targetStartDate.goe(from));
		predicate.and(qScatchJob.targetEndDate.loe(to));
		return from(qScatchJob).where(predicate).fetch();
	}

	@Override
	public ScatchJob existProcessJob(ScatchJob job) {
		BooleanBuilder predicate = new BooleanBuilder();
		predicate.and(qScatchJob.eq(job));
//		predicate.and(qScatchJobItem.status.in(ScatchJobItemStatus.WAIT, ScatchJobItemStatus.SEND_ERROR, ScatchJobItemStatus.SENT));
		return from(qScatchJob).innerJoin(qScatchJob.items, qScatchJobItem).where(predicate).limit(1).fetchOne();
	}
}
