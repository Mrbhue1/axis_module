package com.iserveu.utility.pidUtil;

public class DeviceInfoBean {
	private String mc = "";
	private String dpId = "";
	private String rdsId = "";
	private String mi = "";
	private String rdsVer = "";
	private String dc = "";

	private AdditionalInfoBean additional_info = null;

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getMc() {
		return mc;
	}

	public void setDpId(String dpId) {
		this.dpId = dpId;
	}

	public String getDpId() {
		return dpId;
	}

	public void setRdsId(String rdsId) {
		this.rdsId = rdsId;
	}

	public String getRdsId() {
		return rdsId;
	}

	public void setMi(String mi) {
		this.mi = mi;
	}

	public String getMi() {
		return mi;
	}

	public void setRdsVer(String rdsVer) {
		this.rdsVer = rdsVer;
	}

	public String getRdsVer() {
		return rdsVer;
	}

	public void setDc(String dc) {
		this.dc = dc;
	}

	public String getDc() {
		return dc;
	}

	public void setAdditional_info(AdditionalInfoBean additional_infoBean) {
		this.additional_info = additional_infoBean;
	}

	public AdditionalInfoBean getAdditional_info() {
		if (additional_info == null)
			additional_info = new AdditionalInfoBean();
		return additional_info;
	}

	@Override
	public String toString() {
		return "DeviceInfoBean [mc=" + mc + ", dpId=" + dpId + ", rdsId=" + rdsId + ", mi=" + mi + ", rdsVer=" + rdsVer
				+ ", dc=" + dc + ", additional_info=" + additional_info + "]";
	}
}
