package com.cp.finance.domain.querydslexam;

import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(catalog = "finance3p", name = "customer")
@ToString
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String firstName;

	private String lastName;

	public Customer() {
	}

	public Customer(Integer id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
