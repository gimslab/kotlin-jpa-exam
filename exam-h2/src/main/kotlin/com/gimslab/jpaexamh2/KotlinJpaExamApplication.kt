package com.gimslab.jpaexamh2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import javax.annotation.PostConstruct

@SpringBootApplication
class KotlinJpaExamApplication(
		val personService: PersonService) {

	@PostConstruct
	fun postConstruct() {
		try {
			personService.initDb()
		} catch (e: Exception) {
			e.printStackTrace()
		}
	}
}

fun main(args: Array<String>) {
	runApplication<KotlinJpaExamApplication>(*args)
}
