package com.cp.finance.domain.support.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public abstract class TimeMarkedDeletable extends TimeMarkedObject {

    @Column(columnDefinition = "TINYINT", nullable = false)
	private Boolean deleted = false;

	/**
	 * soft delete
	 */
	public void delete() {
		setDeleted(true);
	}
}
