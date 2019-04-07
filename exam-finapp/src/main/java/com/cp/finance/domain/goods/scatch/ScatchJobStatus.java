package com.cp.finance.domain.goods.scatch;

import lombok.Getter;

public enum ScatchJobStatus {
	WAIT("batch 쪽에서 ScatchJob을 최초로 만들때 상태"),
	STARTED("WAIT 상태까지 만들어진 상태에서 최초 mq로 쏘기 직전 상태"),
	SENT_ALL("MQ로 모두 보낸 상태"),
	ERROR("오류 종료된 상태");

	@Getter
	private String description;

	ScatchJobStatus(String description) {
		this.description = description;
	}
}
