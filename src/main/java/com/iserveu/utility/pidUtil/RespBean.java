package com.iserveu.utility.pidUtil;

public class RespBean {
	private String qScore;
	private String errInfo;
	private String fType;
	private String errCode;
	private String iCount;
	private String pgCount;
	private String pTimeout;
	private String fCount;
	private String nmPoints;
	private String pCount;

	public void setQScore(String qScore) {
		this.qScore = qScore;
	}

	public String getQScore() {
		return qScore;
	}

	public void setErrInfo(String errInfo) {
		this.errInfo = errInfo;
	}

	public String getErrInfo() {
		return errInfo;
	}

	public void setFType(String fType) {
		this.fType = fType;
	}

	public String getFType() {
		return fType;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setICount(String iCount) {
		this.iCount = iCount;
	}

	public String getICount() {
		return iCount;
	}

	public void setPgCount(String pgCount) {
		this.pgCount = pgCount;
	}

	public String getPgCount() {
		return pgCount;
	}

	public void setPTimeout(String pTimeout) {
		this.pTimeout = pTimeout;
	}

	public String getPTimeout() {
		return pTimeout;
	}

	public void setFCount(String fCount) {
		this.fCount = fCount;
	}

	public String getFCount() {
		return fCount;
	}

	public void setNmPoints(String nmPoints) {
		this.nmPoints = nmPoints;
	}

	public String getNmPoints() {
		return nmPoints;
	}

	public void setPCount(String pCount) {
		this.pCount = pCount;
	}

	public String getPCount() {
		return pCount;
	}

	@Override
	public String toString() {
		return "RespBean [qScore=" + qScore + ", errInfo=" + errInfo + ", fType=" + fType + ", errCode=" + errCode
				+ ", iCount=" + iCount + ", pgCount=" + pgCount + ", pTimeout=" + pTimeout + ", fCount=" + fCount
				+ ", nmPoints=" + nmPoints + ", pCount=" + pCount + "]";
	}
}
