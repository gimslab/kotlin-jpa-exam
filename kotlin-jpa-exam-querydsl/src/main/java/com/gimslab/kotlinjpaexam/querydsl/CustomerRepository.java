package com.gimslab.kotlinjpaexam.querydsl;

import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static com.gimslab.kotlinjpaexam.querydsl.QCustomer.customer;

@Repository
@Transactional
public class CustomerRepository {

	@Autowired
	private EntityManager entityManager;

	public Customer findCustomerByJpaQuery(int id){
		JPAQuery<Customer> query = new JPAQuery<>(entityManager);
		return query.from(customer)
				.where(customer.id.eq(id))
				.fetchOne();
	}

	public Customer save(Customer c){
		return entityManager.merge(c);
	}
}
