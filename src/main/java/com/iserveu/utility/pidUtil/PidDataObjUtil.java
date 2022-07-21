package com.iserveu.utility.pidUtil;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;



public class PidDataObjUtil {

	public static PidDataBean getPidDataBean(String xml) throws Exception {
		Document doc = XMLUtil.convertStringToDocument(xml);
		return parseXmlDocument(doc);
	}

	public static PidDataBean parseXmlDocument(Document outputDoc) throws Exception {  
		PidDataBean pidDataBean = new PidDataBean();
		
		Element pidDataElm = outputDoc.getDocumentElement();
		pidDataElm.getTextContent();

		RespBean respBean= new RespBean();
		Element respElm =XMLUtil.getChildElement(pidDataElm,"Resp");
		String textContentOfrespElm = respElm.getTextContent();
		respBean.setErrCode(respElm.getAttribute("errCode"));
		respBean.setErrInfo(respElm.getAttribute("errInfo"));
		respBean.setFCount(respElm.getAttribute("fCount"));
		respBean.setFType(respElm.getAttribute("fType"));
		respBean.setICount(respElm.getAttribute("iCount"));
		respBean.setNmPoints(respElm.getAttribute("nmPoints"));
		respBean.setPCount(respElm.getAttribute("pCount"));
		respBean.setPTimeout(respElm.getAttribute("pTimeout"));
		respBean.setPgCount(respElm.getAttribute("pgCount"));
		respBean.setQScore(respElm.getAttribute("qScore"));
		DeviceInfoBean deviceInfoBean= new DeviceInfoBean   ();
		Element deviceInfoElm =XMLUtil.getChildElement(pidDataElm,"DeviceInfo");
		
		
		
		String textContentOfdeviceInfoElm = deviceInfoElm.getTextContent();
		deviceInfoBean.setDc(deviceInfoElm.getAttribute("dc"));
		deviceInfoBean.setDpId(deviceInfoElm.getAttribute("dpId"));
		deviceInfoBean.setMc(deviceInfoElm.getAttribute("mc"));
		deviceInfoBean.setMi(deviceInfoElm.getAttribute("mi"));
		deviceInfoBean.setRdsId(deviceInfoElm.getAttribute("rdsId"));
		deviceInfoBean.setRdsVer(deviceInfoElm.getAttribute("rdsVer"));
		
		AdditionalInfoBean additional_infoBean= new AdditionalInfoBean();
		deviceInfoBean.setAdditional_info(additional_infoBean);
		
		Element additional_infoElm =XMLUtil.getChildElement(deviceInfoElm,"additional_info");
		String textContentOfadditional_infoElm = additional_infoElm.getTextContent();
		ParamBean paramBean= new ParamBean   ();
		additional_infoBean.setParam(paramBean);
		
		
		Element paramElm =XMLUtil.getChildElement(additional_infoElm,"Param");
		String textContentOfparamElm = paramElm.getTextContent();
		paramBean.setName(paramElm.getAttribute("name"));
		paramBean.setValue(paramElm.getAttribute("value"));
		
		
		SkeyBean skeyBean= new SkeyBean();
		Element skeyElm =XMLUtil.getChildElement(pidDataElm,"Skey");
		String textContentOfskeyElm = skeyElm.getTextContent();
		skeyBean.setCi(skeyElm.getAttribute("ci"));
		
		skeyBean.setSkeyValue(textContentOfskeyElm);
		
		List<DataBean> dataBeanList =  new ArrayList<DataBean> ()  ;//890
//		documentBean.setDataList(dataBeanList);//891
		List<Element> dataNdList = XMLUtil.getChildElements(pidDataElm,"Data");//tbd
		for(int i=0; i<dataNdList.size(); i++ ) { //forloop
			DataBean dataBean= new DataBean();
			dataBeanList.add(dataBean );
			Element dataElm = (Element)dataNdList.get(i);
			String textContentOfdataElm = dataElm.getTextContent();
			dataBean.setType(dataElm.getAttribute("type"));
		}//  Data
		
		
		
		Element hmacElement = XMLUtil.getChildElement(pidDataElm, "Hmac");
		
		String hmac = hmacElement.getTextContent();
		
		pidDataBean.setDeviceInfoBean(deviceInfoBean);
		pidDataBean.setHmac(hmac);
		pidDataBean.setRespBean(respBean);
		pidDataBean.setSkeyBean(skeyBean);
		
		
		DataBean dataBean = new DataBean();
		Element dataElement = XMLUtil.getChildElement(pidDataElm, "Data");
		
		String type = dataElement.getAttribute("type");
		String textContent = dataElement.getTextContent();
		
		dataBean.setType(type);
		dataBean.setValue(textContent);
		pidDataBean.setDataBean(dataBean);
		
		return pidDataBean;
	}
}