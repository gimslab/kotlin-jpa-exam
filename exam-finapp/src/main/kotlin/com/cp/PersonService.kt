package com.cp

import com.cp.finance.domain.querydslexam.Customer
import com.cp.finance.domain.querydslexam.CustomerRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class PersonService(
		val personRepository: PersonRepository,
		val customerRepository: CustomerRepository
) {

	@Transactional
	fun initDb() {
		for (i in 0..9) {
			val p = Person(0, "PPP" + i)
			val saved = personRepository.save(p)
			println("+++++++++++++++++++++++++" + saved)
			if (i == 999)
				throw RuntimeException("error for rollback test")
		}
		for (i in 0..9) {
			val c = Customer(0, "FF" + i, "LLL" + i)
			val saved = customerRepository.save(c);
			println("+++++++++++++++++++++++++" + saved)
			if (i == 999)
				throw RuntimeException("error for rollback test")
		}
	}

	fun findById(id: Int): Person? {
		return personRepository.findById(id)
	}

	fun findByQuerydslById(id: Int): Customer? {
		return customerRepository.findCustomerByJpaQuery(id);

	}
}
