package com.iserveu.controller;

import com.iserveu.grpc_stub.AepsGrpc.AepsImplBase;
import com.iserveu.grpc_stub.AxisRequest;
import com.iserveu.grpc_stub.AxisResponse;
import com.iserveu.grpc_stub.AxisResponse.Builder;
import com.iserveu.request.AxisAepsRequest;
import com.iserveu.response.ResponsePojo;
import com.iserveu.service.AxisAepsService;
import com.iserveu.utility.AxisReqUtility;
import com.iserveu.utility.pidUtil.PidDataBean;
import com.iserveu.utility.pidUtil.PidDataObjUtil;
import io.grpc.stub.StreamObserver;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;
import java.util.Base64;
import java.util.HashMap;

@RestController
@CommonsLog
public class AepsAxisController extends AepsImplBase {

    @Autowired
    private AxisAepsService axisAepsService;

    public final static String CASH_DEPOSIT="CASH_DEPOSIT";
    public final static String CASH_WITHDRAWAL="CASH_WITHDRAWAL";

    public AepsAxisController() {

    }

    @Override
    public void aepsCD(AxisRequest request, StreamObserver<AxisResponse> responseObserver) {
        super.aepsCD(request, responseObserver);

        log.info(request.getTxnId() + "\tBalance Inquiry request ==  merchant id:-" + request.getMerchantId()
                + "\ttxn-id:-" + request.getTxnId() + "\tmobile no:-" + request.getMobileNo() + "\tBank name:-"
                + request.getBankName() + "\tPid data" + request.getPidData() + "\tIp address:-"
                + request.getIpAddress() + "\tlatitude:-" + request.getLatitude() + "\tlongitude:-"
                + request.getLongitude());

        Builder response =AxisResponse.newBuilder();

//        AxisResponse resp=null;
        // default status code
        response.setStatusCode(-1);
        response.setSubStatusCode(6);
        response.setDispalyMessage("Some error after banks response " + Long.toString(request.getTxnId()));

        HashMap<Boolean, Object> buildRequest = AxisReqUtility.prepareRequest(request);
        if(buildRequest.containsKey(Boolean.FALSE)) {
            response.setDispalyMessage(buildRequest.get(Boolean.FALSE).toString());
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
            return;
        }



        String pidData=request.getPidData();
        byte[] decodedBytes = Base64.getDecoder().decode(pidData);
        PidDataBean pidDataBean = null;
        try {
            pidDataBean = PidDataObjUtil.getPidDataBean(new String(decodedBytes));
        } catch (Exception e) {
            response.setStatusCode(-1);
            response.setSubStatusCode(0);
            response.setMessageString("Unable to parse Pid Data");
            response.setDispalyMessage("Unable to parse Pid Data");
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
        }
        AxisAepsRequest request1= (AxisAepsRequest) AxisReqUtility.prepareRequest(request).get(Boolean.TRUE);;

        try{
            ResponsePojo resp=axisAepsService.aepsCashDeposite(request1,pidDataBean,CASH_DEPOSIT);

            response.setAmount(resp.getAmount());
            response.setDispalyMessage(resp.getDispalyMessage());
            response.setAvailableBalance(resp.getAvailableBalance());
            response.setStatus(resp.getStatus());
            response.setStatusCode(resp.getStatusCode());
            response.setBankName(resp.getBankName());
        } catch (JAXBException e) {
            log.info("Exception while generating Cash Deposit response" + e.getMessage() );
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();




    }

    @Override
    public void aepsCW(AxisRequest request, StreamObserver<AxisResponse> responseObserver) {
        super.aepsCW(request, responseObserver);

        log.info(request.getTxnId() + "\tBalance Inquiry request ==  merchant id:-" + request.getMerchantId()
                + "\ttxn-id:-" + request.getTxnId() + "\tmobile no:-" + request.getMobileNo() + "\tBank name:-"
                + request.getBankName() + "\tPid data" + request.getPidData() + "\tIp address:-"
                + request.getIpAddress() + "\tlatitude:-" + request.getLatitude() + "\tlongitude:-"
                + request.getLongitude());

        Builder response =AxisResponse.newBuilder();

//        AxisResponse resp=null;
        // default status code
        response.setStatusCode(-1);
        response.setSubStatusCode(6);
        response.setDispalyMessage("Some error after banks response " + Long.toString(request.getTxnId()));

        HashMap<Boolean, Object> buildRequest = AxisReqUtility.prepareRequest(request);
        if(buildRequest.containsKey(Boolean.FALSE)) {
            response.setDispalyMessage(buildRequest.get(Boolean.FALSE).toString());
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
            return;
        }



        String pidData=request.getPidData();
        byte[] decodedBytes = Base64.getDecoder().decode(pidData);
        PidDataBean pidDataBean = null;
        try {
            pidDataBean = PidDataObjUtil.getPidDataBean(new String(decodedBytes));
        } catch (Exception e) {
            response.setStatusCode(-1);
            response.setSubStatusCode(0);
            response.setMessageString("Unable to parse Pid Data");
            response.setDispalyMessage("Unable to parse Pid Data");
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
        }
        AxisAepsRequest request1= (AxisAepsRequest) AxisReqUtility.prepareRequest(request).get(Boolean.TRUE);;

        try{
            ResponsePojo resp=axisAepsService.aepsCashWithdrawal(request1,pidDataBean,CASH_WITHDRAWAL);

            response.setAmount(resp.getAmount());
            response.setDispalyMessage(resp.getDispalyMessage());
//            response.setAvailableBalance(resp.getAvailableBalance());
            response.setStatus(resp.getStatus());
            response.setStatusCode(resp.getStatusCode());
            response.setBankName(resp.getBankName());
        } catch (JAXBException e) {
            log.info("Exception while generating Cash Deposit response" + e.getMessage() );
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();




    }
}
