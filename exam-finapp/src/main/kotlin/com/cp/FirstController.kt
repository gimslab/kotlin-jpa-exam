package com.cp

import com.cp.finance.domain.goods.scatch.ScatchJob
import com.cp.finance.domain.goods.scatch.ScatchJobRepository
import com.cp.finance.domain.querydslexam.Customer
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class FirstController(
		val perservice: PersonService,
		val scatchJobRepository: ScatchJobRepository
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

	@RequestMapping("/hello3")
	@ResponseBody
	fun hello3(id: Long): String {
		val job = findScatchJobById(id)
//		return "HELLO3 scatchJob = " + job.getCreatedAt() + " ::: " + job.toString()
		return "HELLO3 scatchJob = " + " ::: " + job.toString()
	}

	private fun findScatchJobById(id: Long): ScatchJob {
		return scatchJobRepository.findScatchJobById(id)
	}

	private fun findPerson(id: Int): Person? {
		return perservice.findById(id)
	}

	private fun findPerson2(id: Int): Customer? {
		return perservice.findByQuerydslById(id)
	}
}