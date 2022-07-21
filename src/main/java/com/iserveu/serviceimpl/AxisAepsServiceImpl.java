package com.iserveu.serviceimpl;

//import com.iserveu.request.AxisAppsRequest;

import com.iserveu.request.AxisAepsRequest;
import com.iserveu.request.BankRequest;
import com.iserveu.response.BankResponse;
import com.iserveu.response.ResponsePojo;
import com.iserveu.service.AxisAepsService;
import com.iserveu.utility.AxisReqUtility;
import com.iserveu.utility.Utility;
import com.iserveu.utility.pidUtil.PidDataBean;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
@CommonsLog
public class AxisAepsServiceImpl implements AxisAepsService {

    @Value("${baseurl.axis}")
    private String BASE_URL;

    @Autowired
    AxisReqUtility axisReqUtility;

    @Autowired
    Utility utility;


//    @Override
//    public ResponsePojo aepsCashDeposite(AxisAepsRequest request, PidDataBean pidDataBean, String Operation) throws JAXBException {
//
//        BankRequest bankRequest=null;
//        try{
//            bankRequest= AxisReqUtility.prepareBankRequest(request,pidDataBean,Operation);
//        } catch (Exception e) {
//            log.info(request.getTxnId()+": Exception while preparing the bank request :"+e.getMessage());
//        }
//
//
//        log.info(request.getTxnId()+"Bank request formed.");
//
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_XML);
//
//
//
//        HttpEntity<String> httpentity=new HttpEntity<>(Utility.Obj2Xml(bankRequest),httpHeaders);
//
//        RestTemplate template = Utility.getRestTemplate(10,45);
//
//        ResponseEntity<String> response=null;
//        assert template != null;
//        response=template.postForEntity(BASE_URL,httpentity,String.class);
//
//
//
//
//        return response;
//    }

    @Override
    public ResponsePojo aepsCashDeposite(AxisAepsRequest request, PidDataBean pidDataBean, String Operation) {

        BankRequest bankRequest=null;
        try{
            bankRequest= AxisReqUtility.prepareBankRequest(request,pidDataBean,Operation);
        } catch (Exception e) {
            log.info(request.getTxnId()+": Exception while preparing the bank request :"+e.getMessage());
        }
        log.info(request.getTxnId()+"Bank request formed.");


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_XML);



        HttpEntity<String> httpentity=new HttpEntity<>(Utility.Obj2Xml(bankRequest),httpHeaders);

        RestTemplate template = Utility.getRestTemplate(10,45);

        ResponseEntity<String> response=null;
        if (template==null){
            log.info("Failed to build request client");
            return null;
        }
        try{
//            response=template.postForEntity(BASE_URL,httpentity,String.class);
            String XmlString=response.toString();
            BankResponse bankResponse=null;
            bankResponse=Utility.xml2Obj(new FileReader(new File("src/main/java/com/iserveu/Data/resp.xml")).toString());
//            bankResponse=Utility.xml2Obj(XmlString);

            log.info("Hard coded response :"+bankResponse);
            if (bankResponse==null){
                log.info("Failed to connect to the bank");
                return null;
            }

            ResponsePojo responsePojo=new ResponsePojo();
            responsePojo.setAmount(bankResponse.getServiceInfoResp().getTxnResInfoResp().getAmount());
//            responsePojo.




        } catch (RestClientException e) {
            log.info("Exception for cash deposit request "+e.getMessage());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    @Override
    public ResponsePojo aepsCashWithdrawal(AxisAepsRequest request, PidDataBean pidDataBean, String Operation) throws JAXBException {

        BankRequest bankRequest=null;
        try{
            bankRequest= AxisReqUtility.prepareBankRequest(request,pidDataBean,Operation);
        } catch (Exception e) {
            log.info(request.getTxnId()+": Exception while preparing the bank request :"+e.getMessage());
        }
        log.info(request.getTxnId()+"Bank request formed.");


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_XML);



//        HttpEntity<String> httpentity=new HttpEntity<>(Utility.Obj2Xml(bankRequest),httpHeaders);
        log.info(Utility.Obj2Xml(bankRequest));

//        RestTemplate template = Utility.getRestTemplate(10,45);

//        ResponseEntity<String> response=null;
//        if (template==null){
//            log.info("Failed to build request client");
//            return null;
//        }
        try {
//            response = template.postForEntity(BASE_URL, httpentity, String.class);
//            String XmlString = response.toString();
//
//            String xml= String.valueOf(new FileReader(new File("").toString()));

            String xmlToString= FileUtils.readFileToString(new File("src/main/java/com/iserveu/Data/resp.xml"));
            BankResponse bankResponse = null;


            bankResponse = Utility.xml2Obj(xmlToString);
            if (bankResponse == null) {
                log.info("Failed to connect to the bank");
                return null;
            }

            ResponsePojo responsePojo = new ResponsePojo();

            responsePojo.setBankName("AXB");
            if (bankResponse.getSvcHeaderResp().getRespCode() != null) {
                log.info("Axis CW After cast Response Code :" + bankResponse.getSvcHeaderResp().getRespCode());
                responsePojo.setRespCode(bankResponse.getSvcHeaderResp().getRespCode());
            }
            if (bankResponse.getTxnInfoResp().getRrn() != null) {
                responsePojo.setRrn(bankResponse.getTxnInfoResp().getRrn());
            }

            if (bankResponse.getServiceInfoResp().getTxnResInfoResp().getAmount() != null) {
                log.info(bankResponse.getSvcHeaderResp().getTxnId() + ":Axis CW response : Withdrawal amount :" + bankResponse.getServiceInfoResp().getTxnResInfoResp().getAmount());
                responsePojo.setAmount(bankResponse.getServiceInfoResp().getTxnResInfoResp().getAmount());
            }

            if (responsePojo.getRespCode() != null && responsePojo.getRespCode().equals("ER0000")) {
                responsePojo.setRespCode(bankResponse.getSvcHeaderResp().getRespCode());

                if (bankResponse.getSvcHeaderResp().getTxnId() != null) {
                    responsePojo.setTxnId(bankResponse.getSvcHeaderResp().getTxnId());

                }
//                if (bankResponse.getServiceInfoResp().getTxnResInfoResp().getCustomResp().getDetailsResp().getValue() != null) {
//                    String availableBalance = bankResponse.getServiceInfoResp().getTxnResInfoResp()
//                            .getCustomResp().getDetailsResp().getValue();
//                    responsePojo.setAvailableBalance(availableBalance);
//                    log.info("After cast Response Balance:" + availableBalance);
//
//                }
//                try {
//                    String availableBalance = bankResponse.getServiceInfoResp().getTxnResInfoResp()
//                            .getCustomResp().getDetailsResp().getValue();
//                    responsePojo.setAvailableBalance(availableBalance);
//                    log.info("Avilable balance :"+availableBalance);
//                } catch (NullPointerException e) {
//                    log.info(e.getMessage());
//                }


                responsePojo.setStatus("SUCCESS");
                responsePojo.setStatusCode(1);
                responsePojo.setDispalyMessage("Transaction Successful");
                return responsePojo;
            }
            else {
                responsePojo.setStatus("FAILED");
                responsePojo.setStatusCode(-1);
                responsePojo.setDispalyMessage("Transaction Failed");
                return responsePojo;
            }

        }
        catch (RestClientException e) {

            log.info("Exception for cash deposit request "+e.getMessage());
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
