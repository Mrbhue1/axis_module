package com.iserveu.ReqPojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "EncInfo")
public class EncInfo{
    @XmlAttribute
    private String alg;
    @XmlElement(name = "SecKey")
    private SecKey secKey;
    private String Hmac;
}