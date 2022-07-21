package com.iserveu.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePojo
 {

	private String respCode;

	private String txnId;

	private String respDesc;

	private String tspVdrId;
	private int statusCode;


	private Integer subStatus;
	private String messageString;
	private String dispalyMessage;

	private String statusDesc;

	private String clientRefId;

	private String requestID;

	private String amount;

	private String adhaarNo;

	private String bankName;

	private String rrn;

	private String gatewayRrn;

	private String status;

	private String customerMobile;

	private String availableBalance;

	private String transactionStatus;

	private String transactionDateTime;

	private String transactionList;

	private String npciTranData;

	private String isFormated;

	private String systemTraceAudit;

	private String localTime;
	private String localDate;


	private String authIndentyResp;

	private String txnCurCode;

	private String uidAuthCode;

	private String terminalIdenty;

	private String cardAccceptorCode;

	private String nameLocation;

	private String ledgerBalance;



}
