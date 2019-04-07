package com.cp

import org.springframework.boot.runApplication
import javax.annotation.PostConstruct

//@SpringBootApplication(scanBasePackages = ["com.gimslab", "com.cp"])
class FinAppKotlinApplication(
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
	runApplication<FinAppKotlinApplication>(*args)
}
