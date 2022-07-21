package com.iserveu.ReqPojo;


import javax.xml.bind.annotation.*;


//@XmlRootElement
@lombok.Data
//@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "AuthInfo")
public class AuthInfo {

    @XmlAttribute
    private String prov;
    @XmlAttribute
    private String enc;
    @XmlAttribute
    private String rc;
    @XmlElement(name = "Data")
    private Data data;
    @XmlElement(name = "Fmt")
    private Fmt fmt;
    @XmlElement(name = "Meta")
    private Meta meta;
    @XmlElement(name = "EncInfo")
    private EncInfo encInfo;

    @XmlElement(name = "Uses")
    private Uses uses;


}






