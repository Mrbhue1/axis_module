package com.iserveu.utility.pidUtil;

public class DataBean {
	private String type;
	private String value;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "DataBean [type=" + type + ", value=" + value + "]";
	}

	
}
