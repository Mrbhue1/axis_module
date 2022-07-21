package com.iserveu.utility.pidUtil;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class BeanToXMLUtil {
	private static Document convertBeanToXmlInput(PidDataBean pidDataBean) throws Exception { // kptml

		Document inputDoc = XMLUtil.createDocument("PidData");

		Element pidDataElm = inputDoc.getDocumentElement();
		pidDataElm.setTextContent("");

		pidDataElm.setAttribute("Hmac", pidDataBean.getHmac());

		RespBean respBean = pidDataBean.getRespBean();// kjkplouY1
		Element respElm = XMLUtil.createChildElement(pidDataElm, "Resp");
		respElm.setTextContent("");

		respElm.setAttribute("errCode", respBean.getErrCode());

		respElm.setAttribute("errInfo", respBean.getErrInfo());

		respElm.setAttribute("fCount", respBean.getFCount());

		respElm.setAttribute("fType", respBean.getFType());

		respElm.setAttribute("iCount", respBean.getICount());

		respElm.setAttribute("nmPoints", respBean.getNmPoints());

		respElm.setAttribute("pCount", respBean.getPCount());

		respElm.setAttribute("pTimeout", respBean.getPTimeout());

		respElm.setAttribute("pgCount", respBean.getPgCount());

		respElm.setAttribute("qScore", respBean.getQScore());

		DeviceInfoBean deviceInfoBean = pidDataBean.getDeviceInfoBean();// kjkplouY2
		
		Element deviceInfoElm = XMLUtil.createChildElement(pidDataElm, "DeviceInfo");
		deviceInfoElm.setTextContent("");

		deviceInfoElm.setAttribute("dc", deviceInfoBean.getDc());

		deviceInfoElm.setAttribute("dpId", deviceInfoBean.getDpId());

		deviceInfoElm.setAttribute("mc", deviceInfoBean.getMc());

		deviceInfoElm.setAttribute("mi", deviceInfoBean.getMi());

		deviceInfoElm.setAttribute("rdsId", deviceInfoBean.getRdsId());

		deviceInfoElm.setAttribute("rdsVer", deviceInfoBean.getRdsVer());

		AdditionalInfoBean additional_infoBean = deviceInfoBean.getAdditional_info();// kjkplouY3
		Element additional_infoElm = XMLUtil.createChildElement(deviceInfoElm, "additional_info");
		additional_infoElm.setTextContent("");

		ParamBean paramBean = additional_infoBean.getParam();// kjkplouY4
		Element paramElm = XMLUtil.createChildElement(additional_infoElm, "Param");
		paramElm.setTextContent("");

		paramElm.setAttribute("name", paramBean.getName());

		paramElm.setAttribute("value", paramBean.getValue());

		SkeyBean skeyBean = pidDataBean.getSkeyBean();// kjkplouY5
		Element skeyElm = XMLUtil.createChildElement(pidDataElm, "Skey");
		skeyElm.setTextContent("");

		skeyElm.setAttribute("ci", skeyBean.getCi());

//		for (int i = 0; i < dataBeanList.size(); i++) {
//
//			DataBean dataBean = dataBeanList.get(i);
//			Element dataElm = XMLUtil.createChildElement(pidDataElm, "Data");
//			dataElm.setTextContent("");
//
//			dataElm.setAttribute("type", dataBean.getType());
//
//		} // Data

		return inputDoc;

	}

}