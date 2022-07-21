package com.iserveu.RespPojo;

import com.iserveu.ReqPojo.PartyList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
public class TxnResInfoResp {
    private Long journalNo;
    private String authCode;
    private String uidToken;
    private String amount;
    @XmlElement(name = "PartyList")
    private PartyListResp partyListResp;
    @XmlElement(name = "AddDataList")
    private AddDataListResp addDataListResp;
    @XmlElement(name = "Custom")
    private CustomResp customResp;
}
