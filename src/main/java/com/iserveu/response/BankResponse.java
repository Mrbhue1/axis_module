package com.iserveu.response;


import com.iserveu.RespPojo.ServiceInfoResp;
import com.iserveu.RespPojo.SvcHeaderResp;
import com.iserveu.RespPojo.TxnInfoResp;
import com.iserveu.RespPojo.TxnResInfoResp;
import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlRootElement(name = "FIGWebResSvc")
@XmlAccessorType(XmlAccessType.FIELD)
public class BankResponse {
    @XmlAttribute
    private String spv="1.0";
    @XmlElement(name = "SvcHeader")
    private SvcHeaderResp svcHeaderResp;
    @XmlElement(name = "TxnInfo")
    private TxnInfoResp txnInfoResp;
    @XmlElement(name = "ServiceInfo")
    private ServiceInfoResp serviceInfoResp;




}
