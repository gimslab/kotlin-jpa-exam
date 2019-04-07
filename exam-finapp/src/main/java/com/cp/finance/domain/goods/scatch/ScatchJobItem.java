package com.cp.finance.domain.goods.scatch;

import com.cp.finance.domain.support.entity.TimeMarkedDeletable;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;

import static com.cp.finance.domain.goods.scatch.ScatchJobItemStatus.*;
import static javax.persistence.GenerationType.AUTO;

@Builder
@Entity
@Table(catalog = "finance3p", name = "scatch_job_item")
@Where(clause = "deleted=0")
@EqualsAndHashCode(of = { "id" }, callSuper = false)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, exclude = "scatchJob")
public class ScatchJobItem extends TimeMarkedDeletable {

	@Id
	@Column(name = "scatchJobItemId", nullable = false)
	@GeneratedValue(strategy = AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "scatchJobId")
	private ScatchJob scatchJob;

	private Long numberUnitId;
	private String stringUnitId;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private ScatchJobItemStatus status;
}
