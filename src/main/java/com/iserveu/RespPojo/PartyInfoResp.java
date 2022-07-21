package com.iserveu.RespPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class PartyInfoResp {
    @XmlAttribute
    private final static String type="PERSON";
    @XmlAttribute
    private  String categ;  //BENEFICIARY for deposite|| "CUSTOMER" for withdrawal

    private String partyOrg;
    private String partyIdType;
    private String partyIdValue;

}
