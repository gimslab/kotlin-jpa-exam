package com.gimslab.kotlinjpaexam.mysql

import javax.persistence.*

@Entity
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