package com.iserveu.utility.pidUtil;

public class SkeyBean {
	private String ci;
	private String skeyValue;

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getSkeyValue() {
		return skeyValue;
	}

	public void setSkeyValue(String skeyValue) {
		this.skeyValue = skeyValue;
	}

	@Override
	public String toString() {
		return "SkeyBean [ci=" + ci + ", skeyValue=" + skeyValue + "]";
	}
}
