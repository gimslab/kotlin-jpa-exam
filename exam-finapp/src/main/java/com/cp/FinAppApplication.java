package com.cp;

import com.cp.finance.domain.goods.scatch.ScatchJobFinder;
import lombok.val;
import org.joda.time.DateTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

import static com.cp.finance.domain.goods.scatch.ScatchJobStatus.SENT_ALL;
import static com.cp.finance.domain.goods.scatch.ScatchJobType.PAYMENTS_GENERATION;

@SpringBootApplication
public class FinAppApplication {

	private final PersonService personService;
	private final ScatchJobFinder scatchJobFinder;

	public FinAppApplication(PersonService personService, ScatchJobFinder scatchJobFinder) {
		this.personService = personService;
		this.scatchJobFinder = scatchJobFinder;
	}

	@PostConstruct
	private void postConstruct() {
		try {
			personService.initDb();
		} catch (Exception e) {
			e.printStackTrace();
		}

		val r = scatchJobFinder.findBy(
									PAYMENTS_GENERATION,
									SENT_ALL,
									DateTime.now().minusYears(1));
		r.stream()
				.map(it -> "+++ " + it)
				.forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(FinAppApplication.class, args);
	}
}
