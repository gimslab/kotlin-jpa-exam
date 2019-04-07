package com.cp.finance.domain.goods.scatch;

import com.cp.finance.domain.support.entity.MarkedObject;
import lombok.*;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Entity
@Table(catalog = "finance3p", name = "scatch_job")
@Getter
@EqualsAndHashCode(of = "id", callSuper = false)
@ToString(callSuper = true)
public class ScatchJob extends MarkedObject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(AccessLevel.NONE)
	@Column(name = "scatchJobId")
	private Long id;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private ScatchJobType type;

	private LocalDate targetStartDate;
	private LocalDate targetEndDate;
	private String options;
	private long totalCount = 0;
	private long successCount = 0;
	private long failCount = 0;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private ScatchJobStatus status;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "scatchJob")
	private List<ScatchJobItem> items = newArrayList();
}
