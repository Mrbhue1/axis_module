package com.iserveu.utility;

import com.iserveu.ReqPojo.*;
import com.iserveu.grpc_stub.AxisRequest;
import com.iserveu.request.AxisAepsRequest;
import com.iserveu.request.BankRequest;
import com.iserveu.utility.pidUtil.PidDataBean;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

@CommonsLog
@Service
public class AxisReqUtility {

    @Autowired
    Utility utility;



    private final static Integer FUNC_CODE_NORMAL=1200;
    private final static Integer FUNC_CODE_REVERSAL=1400;
    private final static Integer POS=6010;
    private final static Integer M_ATM=6012;
    private final static String TXN_MODE="UID";

    private final static String AUTH_INFO_PROV="NPCI";

    private final static String DATA_TYPE_BIO="01";
    private final static String DATA_TYPE_BIO_FIR="02";
    private final static String DATA_TYPE_UID="06";

    private final static String CURR_CODE="INR";

    private final static String PROC_CODE_DEPOSIT="PC0026";
    private final static String PROC_CODE_WITHDRAWAL="PC0027";

    private final static String UID="UID";






//    public HashMap<Boolean,Object> prepareReq(AxisRequest request){
//
//        AxisAepsRequest request1=new AxisAepsRequest();
//
//        HashMap<Boolean,Object> response = new HashMap<Boolean,Object>();
//
//        try{
//            request1.setAmount((long) request.getAmount());
//            request1.setTxnId(Long.toString(request.getTxnId()));
//            request1.setMobileNo(Long.parseLong(request.getMobileNo()));
//            request1.setAadhaar(Long.parseLong(request.getAadhaar()));
//            request1.setBankName(request.getBankName());
//            request1.setIin(request.getIin());
//            request1.setIpAddress(request.getIpAddress());
//            request1.setLatitude(request.getLatitude());
//            request1.setLongitude(request.getLongitude());
//            response.put(Boolean.TRUE,request1);
//            return response;
//
//        } catch (Exception e) {
//            response.put(Boolean.FALSE, "Failed to prepare request");
//            return response;
//        }

    public static BankRequest prepareBankRequest(AxisAepsRequest request, PidDataBean pidDataBean, String operationPerformed) {
        try{
            // SvcHeader
            SvcHeader svcHeader = new SvcHeader();
            svcHeader.setTxnId(2);
            svcHeader.setTspVdrId("");
            svcHeader.setTspAuth("");
            svcHeader.setTxnOrigin("");
            svcHeader.setMsgFmtVer("1.3");

            //TxnInfo

            TxnInfo txnInfo = new TxnInfo();
            txnInfo.setFuncCode(FUNC_CODE_NORMAL);
            txnInfo.setPan(Utility.generatePan(request));
            txnInfo.setTxnDateTime(request.getTxnDateTime());
            txnInfo.setMcc(POS);
            txnInfo.setPosEntryMode("");
            if (operationPerformed.equalsIgnoreCase("CASH_DEPOSIT"))
                txnInfo.setProcCode(PROC_CODE_DEPOSIT);
            else
                txnInfo.setProcCode(PROC_CODE_WITHDRAWAL);

            txnInfo.setAcqId("");
            txnInfo.setTrack2Data("");
            txnInfo.setRrn(request.getBcRrn());
            txnInfo.setTerminalId(request.getTerminalId());
            txnInfo.setCaId(Utility.generateCaId(request));
            txnInfo.setCaLocn("");
            txnInfo.setTeminalData("");
            txnInfo.setAgentId(request.getMerchnatId());
            txnInfo.setServiceChrg("");
            txnInfo.setTxnMode(TXN_MODE);
            txnInfo.setOrgTxnRefId("");
            txnInfo.setNarration("");
            txnInfo.setTxnHmac(Utility.generateTxnHmac(request));//Need to build and pass here
            txnInfo.setUniqueNo(request.getStan());
            txnInfo.setExpDate("");
            txnInfo.setSetlDate("");
            txnInfo.setPosCaptCode("");
            txnInfo.setPosCode("00");


            //DATA
            Data data=new Data();
            data.setType(pidDataBean.getDataBean().getType());
            data.setValue(pidDataBean.getDataBean().getValue());

            //FMT
            Fmt fmt=new Fmt();
            fmt.setType("P");
            fmt.setValue("");

            //Meta
            Meta meta=new Meta();
            meta.setUdc(Utility.generateUdc(request.getTerminalId()));
            meta.setDc(pidDataBean.getDeviceInfoBean().getDc());
            meta.setBav("FPD");
            meta.setDpId(pidDataBean.getDeviceInfoBean().getDpId());
            meta.setMc(pidDataBean.getDeviceInfoBean().getMc());
            meta.setMi(pidDataBean.getDeviceInfoBean().getMi());
            meta.setRdsId(pidDataBean.getDeviceInfoBean().getRdsId());
            meta.setLot("");
            meta.setLov("");

            //Use
            Uses uses=new Uses();
            uses.setPi("n");
            uses.setPa("n");
            uses.setPfa("n");
            uses.setBio("y");
            uses.setBt("FIR,FMR");
            uses.setPin("n");
            uses.setOtp("n");

        /*EncInfo{
                secKey;
                } */

            //SecKey
            SecKey secKey=new SecKey();
            secKey.setCi(pidDataBean.getSkeyBean().getCi());
            secKey.setKi("");
            secKey.setValue(pidDataBean.getSkeyBean().getSkeyValue());

            EncInfo encInfo=new EncInfo();
            encInfo.setAlg("SHA256");
            encInfo.setSecKey(secKey);
            encInfo.setHmac(Utility.SHA256hash(pidDataBean.getHmac()));

            //AuthInfo
            AuthInfo authInfo=new AuthInfo();
            authInfo.setProv(AUTH_INFO_PROV);
            authInfo.setRc("Y");
            authInfo.setEnc("00");
            authInfo.setData(data);
            authInfo.setFmt(fmt);
            authInfo.setMeta(meta);
            authInfo.setUses(uses);
            authInfo.setEncInfo(encInfo);

            //PartyInfo

            PartyInfo partyInfo=new PartyInfo();
            partyInfo.setPartyIdType(UID);
            partyInfo.setPartyOrg(request.getIin());
            partyInfo.setPartyIdValue(request.getAadhaar());

            //PartyList
            PartyList partyList=new PartyList();
            partyList.setPartyInfo(partyInfo);

            //AddDataItems
            AddDataItem addDataItem=new AddDataItem();
            addDataItem.setName("");
            addDataItem.setValue("");

            //TxnReqInfo
            TxnReqInfo txnReqInfo=new TxnReqInfo();
            txnReqInfo.setAmount(request.getAmount());
            txnReqInfo.setCurrCode(CURR_CODE);
            txnReqInfo.setPartyList(partyList);
            txnReqInfo.setAddDataItem(addDataItem);

            //ServiceInfo
            ServiceInfo serviceInfo=new ServiceInfo();
            serviceInfo.setTxnReqInfo(txnReqInfo);

            //BankRequest

            BankRequest bankRequest = new BankRequest();
            bankRequest.setSvcHeader(svcHeader);
            bankRequest.setTxnInfo(txnInfo);
            bankRequest.setAuthInfo(authInfo);
            bankRequest.setServiceInfo(serviceInfo);



            return bankRequest;
        } catch (Exception e) {
            log.info("Exception while creating bank request in axsReqUtil :"+e.getMessage());
            return null;        }

    }

    public static HashMap<Boolean,Object> prepareRequest(AxisRequest request){

        HashMap<Boolean,Object> response = new HashMap<Boolean,Object>();

        AxisAepsRequest req=new AxisAepsRequest();
        try{
            req.setAadhaar(request.getAadhaar());
            req.setAmount((long) request.getAmount());
            req.setBankName(request.getBankName());
            req.setIin(request.getIin());
            req.setTxnId(request.getTxnId());
            req.setLatitude(request.getLatitude());
            req.setLatitude(request.getLatitude());
            req.setMerchnatId(request.getMerchantId());
            req.setMobileNo(request.getMobileNo());
            req.setPidData(request.getPidData());
            req.setIpAddress(request.getIpAddress());
            req.setImeiMac(request.getImeiMac());
            req.setDeviceNo(request.getDeviceNo());
            req.setUserName(request.getUserName());
            req.setUserId(request.getUserId());
            //By kamal
            req.setCity(request.getCity());
            req.setState(request.getState());
            req.setCountry(request.getCountry());
            req.setBcRrn(request.getBcRrn());
            req.setStan(request.getStan());
            req.setUserName(request.getUserName());
            req.setUserId(request.getUserId());
            req.setTxnDateTime(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime()));
            response.put(Boolean.TRUE,req);
            return response;
        }
        catch (Exception e) {
            response.put(Boolean.FALSE, "Failed to prepare request");
            log.info(request.getTxnId()+" :Exception while creating AxisAepsRequest: "+e.getMessage());
            return response;
        }



    }
}
