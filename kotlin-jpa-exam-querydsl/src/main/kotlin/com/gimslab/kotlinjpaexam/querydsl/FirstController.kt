package com.gimslab.kotlinjpaexam.querydsl

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class FirstController(
		val personRepo: PersonRepository,
		val perservice: PersonService
) {

	@RequestMapping("/hello")
	@ResponseBody
	fun hello(id: Int): String {
		return "HELLO person=" + findPerson(id)
	}

	@RequestMapping("/hello2")
	@ResponseBody
	fun hello2(id: Int): String {
		return "HELLO2 customer=" + findPerson2(id)
	}

	private fun findPerson(id: Int): Person? {
//		return personRepo.findById(id)
		return perservice.findById(id)
	}

	private fun findPerson2(id: Int): Customer? {
		return perservice.findByQuerydslById(id)
	}
}