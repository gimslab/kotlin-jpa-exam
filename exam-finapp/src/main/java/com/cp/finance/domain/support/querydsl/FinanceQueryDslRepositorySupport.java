package com.cp.finance.domain.support.querydsl;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 다중 JPA EntityManagerFactory를 사용 시 QueryDslRepositorySupport#setEntityManager에서 어떤 EntityManager를 사용하지 몰라서 에러나는 것을 추상화 시켜서 사용.
 */
public class FinanceQueryDslRepositorySupport extends QuerydslRepositorySupport {

    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     */
    public FinanceQueryDslRepositorySupport(Class<?> domainClass) {
        super(domainClass);
    }

//    @PersistenceContext(unitName = TransactionalCode.FINANCE_UNIT)
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }
}
