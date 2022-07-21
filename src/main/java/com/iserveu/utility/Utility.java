package com.iserveu.utility;


import com.iserveu.request.AxisAepsRequest;
import com.iserveu.request.BankRequest;
import com.iserveu.response.BankResponse;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.net.ssl.SSLContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.Duration;

@CommonsLog
@Service
public class Utility {

    private final static String ALGORITHM="PBKDF2WithHmacSHA256";
    private final static Integer ITERATION=1000;




    //Generation of Hmac for AuthInfo
    public static String SHA256hash(String s1) {
        try {
            return org.apache.commons.codec.digest.DigestUtils.sha256Hex(s1);
        }catch(Exception e) {
            log.info("Exception while encryption of Hmac "+e.getMessage());
            return null;
        }
    }


    //Generation of Udc

    public static String generateUdc(String terminalId) {

        try {
            return "AXB"+"1010"+terminalId;
        } catch (Exception e) {
            log.info("Failed to generate Udc "+e.getMessage());
            return null;
        }

    }


//    public static RestTemplate getRestTemplate(int Connectiontimeout, int readTimeout) {
//        try {
//            return new RestTemplate(getClientHttpRequestFactory(Connectiontimeout,readTimeout));
//        }catch(Exception e) {
//            return null;
//        }
//    }
//
//    private static ClientHttpRequestFactory getClientHttpRequestFactory(int Connectiontimeout, int readTimeout) throws NoSuchAlgorithmException, KeyManagementException {
//        SSLContext context = SSLContext.getInstance("TLSv1.2");
//        context.init(null, null, null);
//        CloseableHttpClient httpClient = HttpClientBuilder.create().setSSLContext(context)
//                .build();
//        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
//        clientHttpRequestFactory.setConnectTimeout(Connectiontimeout*1000);
//        clientHttpRequestFactory.setReadTimeout(readTimeout*1000);
//        return clientHttpRequestFactory;
//    }
//

    //Generation of XML from Java Object
    public static String Obj2Xml(BankRequest bankRequest) {

            try{
                JAXBContext jaxbContext=JAXBContext.newInstance(BankRequest.class);
                Marshaller marshaller=jaxbContext.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
                StringWriter sw = new StringWriter();
                marshaller.marshal(bankRequest, sw);
                return sw.toString();
            } catch (JAXBException e) {
                log.info(bankRequest.getSvcHeader().getTxnId()+" : Failed to generate XML"+e.getMessage());
                return "Failed to generate XML";
            }
    }

    //Unmarshaller of Xml file to Java Object

    public static BankResponse xml2Obj(String xml)  {
        try {
            JAXBContext jaxbContext=JAXBContext.newInstance(BankResponse.class);
            Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
            StringReader reader=new StringReader(xml);

            return (BankResponse) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            log.info("Exception while unmarshalling of the response in utility:"+e.getMessage());
            return null;
        }

    }

    //Generation Of Pan

    public static String generatePan(AxisAepsRequest Request) {
        try {
            return Request.getIin() + "0" + Request.getAadhaar();
        }
        catch (Exception e) {
            log.info(Request.getTxnId() + "Exception while generating PAN" + e.getMessage());
            return "Failed to generate PAN";
        }


    }


    public static String generateCaId(AxisAepsRequest request){
        try{
            return "AXB" + request.getTspVendorId()+ "00" +request.getTerminalId();
        }
        catch (Exception e){
            log.info( "Exception while generating CaId " + e.getMessage());
            return "Failed to generate CaId";
        }


    }


    //Generation of TxnHmac

    public static String generateTxnHmac(AxisAepsRequest data) {

        int iterations = ITERATION;
        char[] chars = Utility.generateData(data).toCharArray();
        byte[] salt = Utility.generateSalt(data);
        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGORITHM);
            byte[] hash = skf.generateSecret(spec).getEncoded();
            return toHex(hash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            log.info(data.getTxnId()+ " Failed to generate TxnHmac " + e.getMessage());
            return "Failed to generate TxnHmac";
        }


    }
    public static String generateData(AxisAepsRequest data){
        return data.getAadhaar().trim() + data.getAmount() + data.getBcRrn();
    }

    public static byte[] generateSalt(AxisAepsRequest txnTime){
        return  txnTime.getTxnDateTime().getBytes(StandardCharsets.UTF_8);
    }

    private static String toHex(byte[] array) {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            System.out.println(hex);
            return hex;
        }
    }

    public static RestTemplate getRestTemplate(int Connectiontimeout,int readTimeout) {
        try {
            return new RestTemplate(getClientHttpRequestFactory(Connectiontimeout,readTimeout));
        }catch(Exception e) {
            return null;
        }
    }

    private static ClientHttpRequestFactory getClientHttpRequestFactory(int Connectiontimeout, int readTimeout) throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext context = SSLContext.getInstance("TLSv1.2");
        context.init(null, null, null);
        CloseableHttpClient httpClient = HttpClientBuilder.create().setSSLContext(context)
                .build();
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        clientHttpRequestFactory.setConnectTimeout(Connectiontimeout*1000);
        clientHttpRequestFactory.setReadTimeout(readTimeout*1000);
        return clientHttpRequestFactory;
    }

}
