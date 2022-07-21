package com.iserveu.RespPojo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TxnInfoResp {
    private Integer funcCode;
    private String pan;
    private String procCode;
    private Date txnDateTime;
    private String track2Data;
    private String rrn;
    private Integer terminalId;
    private Integer agentId;
    private String serviceChrg;
    private String txnMode;
    private Integer orgTxnRefId;
    private String narration;
    private String gatewayRRN;
    private String txnHmac;

}
