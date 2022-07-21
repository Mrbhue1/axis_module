package com.iserveu.RespPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
public class SvcHeaderResp {
    private String txnId;

    private String tspVdrId;

    private String respCode;

    private String respDesc;

    private String msgFmtVer;
}
