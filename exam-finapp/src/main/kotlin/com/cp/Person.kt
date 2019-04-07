package com.cp

import javax.persistence.*

@Entity
@Table(catalog = "finance3p", name = "person")
data class Person(

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		val id: Int,

		@Column(nullable = false)
		val name: String
) {
	constructor() : this(0, "") {
	}
}