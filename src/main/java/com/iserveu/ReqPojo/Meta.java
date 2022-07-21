package com.iserveu.ReqPojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@lombok.Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Name")
@AllArgsConstructor
public
class Meta  {
    @XmlAttribute
    private String udc;
    @XmlAttribute
    private String rdsId;
    @XmlAttribute
    private String rdsVer;
    @XmlAttribute
    private String dpId;
    @XmlAttribute
    private String dc;
    @XmlAttribute
    private String mi;
    @XmlAttribute
    private String mc;
    @XmlAttribute
    private String bav;
    @XmlAttribute
    private String lot;
    @XmlAttribute
    private String lov;


}