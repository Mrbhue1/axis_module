package com.iserveu.ReqPojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@lombok.Data
@XmlRootElement(name = "Uses")
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
public
class Uses{
    @XmlAttribute
    private String pi;
    @XmlAttribute
    private String pa;
    @XmlAttribute
    private String pfa;
    @XmlAttribute
    private String bio;
    @XmlAttribute
    private String bt;
    @XmlAttribute
    private String pin;
    @XmlAttribute
    private String otp;


}