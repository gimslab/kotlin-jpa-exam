package com.gimslab.kotlinjpaexam.querydsl;

import javax.persistence.Entity;

@Entity
public class Customer {
	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String fn) {
		firstName = fn;
	}

	public void setLastName(String ln) {
		lastName = ln;
	}

}
