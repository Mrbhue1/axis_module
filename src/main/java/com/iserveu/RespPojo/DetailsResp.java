package com.iserveu.RespPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
public class DetailsResp {
    @XmlAttribute
    private final static String name="ACTBAL";
    @XmlAttribute
    private String value="093279827";
}
