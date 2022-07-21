package com.iserveu.request;

import com.iserveu.ReqPojo.AuthInfo;
import com.iserveu.ReqPojo.ServiceInfo;
import com.iserveu.ReqPojo.SvcHeader;
import com.iserveu.ReqPojo.TxnInfo;
import lombok.Data;

import javax.xml.bind.annotation.*;


@XmlRootElement(name = "FIGWebReqSvc")
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class BankRequest{
    @XmlAttribute
    private String spv;
    @XmlElement(name = "SvcHeader")
    private SvcHeader svcHeader;
    @XmlElement(name = "TxnInfo")
    private TxnInfo txnInfo;
    @XmlElement(name = "AuthInfo")
    private AuthInfo authInfo;
    @XmlElement(name = "ServiceInfo")
    private ServiceInfo serviceInfo;
}
