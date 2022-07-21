package com.iserveu.ReqPojo;

import lombok.Data;
import org.springframework.scheduling.support.SimpleTriggerContext;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


@Data
@XmlRootElement
public class TxnInfo {

    private Integer funcCode;
    private String pan;
    private String procCode;
    private String  txnDateTime;
    private Integer mcc;
    private String posEntryMode;
    private String posCode;
    private String acqId;
    private String track2Data;
    private String rrn;
    private String terminalId;
    private Long agentId;
    private String caId;
    private String caLocn;
    private String teminalData;
    private String serviceChrg;
    private String txnMode;
    private String orgTxnRefId;
    private String narration;
    private String txnHmac;
    private Integer uniqueNo;
    private String expDate;
    private String setlDate;
    private String posCaptCode;


}
