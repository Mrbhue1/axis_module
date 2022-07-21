package com.iserveu.ReqPojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name="SecKey")
@XmlAccessorType(XmlAccessType.FIELD)
public class SecKey {
    @XmlAttribute
    String ci;
    @XmlAttribute
    String ki;
    @XmlValue
    private String value;
}
