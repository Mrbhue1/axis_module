package com.iserveu.utility.pidUtil;

public class PidDataBean {
	private RespBean respBean;
	private String hmac;
	private DeviceInfoBean deviceInfoBean;
	private SkeyBean skeyBean;
	private DataBean dataBean;
	
	
	
	
	
	public RespBean getRespBean() {
		return respBean;
	}


	public void setRespBean(RespBean respBean) {
		this.respBean = respBean;
	}





	public String getHmac() {
		return hmac;
	}





	public void setHmac(String hmac) {
		this.hmac = hmac;
	}





	public DeviceInfoBean getDeviceInfoBean() {
		return deviceInfoBean;
	}





	public void setDeviceInfoBean(DeviceInfoBean deviceInfoBean) {
		this.deviceInfoBean = deviceInfoBean;
	}





	public SkeyBean getSkeyBean() {
		return skeyBean;
	}





	public void setSkeyBean(SkeyBean skeyBean) {
		this.skeyBean = skeyBean;
	}





	public DataBean getDataBean() {
		return dataBean;
	}





	public void setDataBean(DataBean dataBean) {
		this.dataBean = dataBean;
	}


	@Override
	public String toString() {
		return "PidDataBean [respBean=" + respBean + ", hmac=" + hmac + ", deviceInfoBean=" + deviceInfoBean
				+ ",\n skeyBean=" + skeyBean + ", dataBean=" + dataBean + "]";
	}






	
}
