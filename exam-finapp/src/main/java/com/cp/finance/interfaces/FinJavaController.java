package com.cp.finance.interfaces;

import com.cp.Person;
import com.cp.PersonService;
import com.cp.finance.domain.goods.scatch.ScatchJob;
import com.cp.finance.domain.goods.scatch.ScatchJobFinder;
import com.cp.finance.domain.goods.scatch.ScatchJobRepository;
import com.cp.finance.domain.querydslexam.Customer;
import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FinJavaController {

	private final PersonService personService;
	private final ScatchJobRepository scatchJobRepository;
	private final ScatchJobFinder scatchJobFinder;

	public FinJavaController(PersonService personService, ScatchJobRepository scatchJobRepository, ScatchJobFinder scatchJobFinder) {
		this.personService = personService;
		this.scatchJobRepository = scatchJobRepository;
		this.scatchJobFinder = scatchJobFinder;
	}

	@RequestMapping("/hi")
	@ResponseBody
	public String hello(Integer id) {
		return "HELLO person=" + findPerson(id);
	}

	@RequestMapping("/hi2")
	@ResponseBody
	public String hi2(Integer id) {
		return "HELLO2 customer=" + findPerson2(id);
	}

	@RequestMapping("/hi3")
	@ResponseBody
	public String hi3(Long id) {
		val job = findScatchJobById(id);
		return "HELLO3 scatchJob = " + job;
	}

	@RequestMapping("/hi4")
	@ResponseBody
	public String hi4() {
		return "HELLO4 = " + scatchJobFinder.findByTypeAndFromTo();
	}

	private ScatchJob findScatchJobById(Long id) {
		return scatchJobRepository.findScatchJobById(id);
	}

	private Person findPerson(Integer id) {
		return personService.findById(id);
	}

	private Customer findPerson2(Integer id) {
		return personService.findByQuerydslById(id);
	}
}
