package com.cp.finance.domain.support.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode
@EntityListeners({ TimeMarkedObjectEventListener.class })
@ToString
public abstract class TimeMarkedObject {

	@Column(nullable = false, length = 6)
	private DateTime createdAt;

	@Column(nullable = false, length = 6)
	private DateTime modifiedAt;
}
