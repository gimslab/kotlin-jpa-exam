package com.cp.finance.domain.goods.scatch;

import lombok.Getter;

import static com.cp.finance.domain.goods.scatch.ScatchJobTransactionUnit.VENDOR_ID;

@Getter
public enum ScatchJobType {
	PAYMENTS_GENERATION("지급 생성", VENDOR_ID),
	SERVER_FEE_GENERATION("판매자서비스이용료 생성", VENDOR_ID),
	PROPORTION_RECOGNITION_GENERATION("결제수단 인식 생성", VENDOR_ID);


	private String title;
	private ScatchJobTransactionUnit transactionUnit;

	ScatchJobType(String title, ScatchJobTransactionUnit transactionUnit) {
		this.title = title;
		this.transactionUnit = transactionUnit;
	}
}
