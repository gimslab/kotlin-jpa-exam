package com.gimslab.jpaexammysql

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class FirstController(
		val personRepo: PersonRepository
) {

	@RequestMapping("/hello")
	@ResponseBody
	fun hello(id: Int): String {
		return "HELLO person=" + findPerson(id)
	}

	private fun findPerson(id: Int): Person? {
		return personRepo.findById(id)
	}
}