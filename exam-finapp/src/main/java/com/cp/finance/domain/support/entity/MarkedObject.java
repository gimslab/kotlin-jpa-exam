package com.cp.finance.domain.support.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@Data
@MappedSuperclass
@JsonIgnoreProperties({ "handler", "hibernateLazyInitializer" })
@EntityListeners({ MarkedObjectEventListener.class })
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public abstract class MarkedObject extends TimeMarkedDeletable {
	@Column(nullable = false)
	private String createdBy;

	@Column(nullable = false)
	private String modifiedBy;

	@Transient
	private boolean ignoreModified;
}
