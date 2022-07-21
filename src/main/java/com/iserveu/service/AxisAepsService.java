package com.iserveu.service;

import com.iserveu.request.AxisAepsRequest;
import com.iserveu.response.ResponsePojo;
import com.iserveu.utility.pidUtil.PidDataBean;
import org.springframework.http.ResponseEntity;

import javax.xml.bind.JAXBException;

public interface AxisAepsService {

    ResponsePojo aepsCashDeposite(AxisAepsRequest request, PidDataBean pidDataBean,String Operation) throws JAXBException;
    ResponsePojo aepsCashWithdrawal(AxisAepsRequest request, PidDataBean pidDataBean,String Operation) throws JAXBException;
//    ResponseEntity<String> aepsCashDeposite(AxisAepsRequest request, PidDataBean pidDataBean, String Operation) throws JAXBException;

//    ResponsePojo aepsCashDeposite(AxisAepsRequest request);
}
