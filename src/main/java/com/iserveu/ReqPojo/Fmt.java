package com.iserveu.ReqPojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Fmt")
public
class Fmt{
    @XmlAttribute
    private String type;
    @XmlValue
    private String value;
}