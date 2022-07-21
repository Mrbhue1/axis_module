package com.iserveu.utility.pidUtil;

public class AdditionalInfoBean {

	private ParamBean param = null;

	public void setParam(ParamBean paramBean) {
		this.param = paramBean;
	}

	public ParamBean getParam() {
		return param;
	}

	@Override
	public String toString() {
		return "\nAdditionalInfoBean [param=" + param + "]";
	}
}
