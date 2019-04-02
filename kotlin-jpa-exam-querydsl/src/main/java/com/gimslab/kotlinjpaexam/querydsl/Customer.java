package com.gimslab.kotlinjpaexam.querydsl;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@AllArgsConstructor
//@NoArgsConstructor
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
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setFirstName(String fn) {
//		firstName = fn;
//	}
//
//	public void setLastName(String ln) {
//		lastName = ln;
//	}

}
