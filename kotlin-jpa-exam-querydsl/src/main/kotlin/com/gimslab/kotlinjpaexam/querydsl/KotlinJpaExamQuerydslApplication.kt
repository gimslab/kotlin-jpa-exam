package com.gimslab.kotlinjpaexam.querydsl

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import javax.annotation.PostConstruct

@SpringBootApplication
class KotlinJpaExamQuerydslApplication(
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
	runApplication<KotlinJpaExamQuerydslApplication>(*args)
}
