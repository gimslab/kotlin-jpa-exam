package com.cp.infrastructure.persistence.jpa.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface CpJpaRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, QuerydslPredicateExecutor<T>,
	JpaSpecificationExecutor<T> {

}
