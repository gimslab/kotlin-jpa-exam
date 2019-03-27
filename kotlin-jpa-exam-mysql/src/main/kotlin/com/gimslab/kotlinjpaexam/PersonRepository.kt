package com.gimslab.kotlinjpaexam

import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Repository
@Transactional
class PersonRepository(
		val entityManager: EntityManager
) {

	fun save(person: Person): Person? {
		return entityManager.merge(person)
	}

	fun findById(id: Int): Person? {
		return entityManager.find(Person::class.java, id)
	}
}
