package com.gimslab.kotlinjpaexam

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class PersonService(val personRepository: PersonRepository) {

	@Transactional
	fun initDb() {
		for (i in 0..9) {
			val p = Person(0, "PPP" + i)
			val saved = personRepository.save(p)
			println("+++++++++++++++++++++++++" + saved)
			if (i == 999)
				throw RuntimeException("error for rollback test")
		}
	}

	fun findById(id: Int): Person? {
		return personRepository.findById(id)
	}
}
