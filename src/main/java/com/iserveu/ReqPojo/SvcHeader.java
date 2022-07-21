package com.iserveu.ReqPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
@AllArgsConstructor
@NoArgsConstructor
public class SvcHeader implements Serializable {

    private Integer txnId;

    private String tspVdrId;

    private String tspAuth;

    private String txnOrigin;

    private String msgFmtVer;
}
