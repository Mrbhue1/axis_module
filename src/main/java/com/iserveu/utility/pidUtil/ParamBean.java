package com.iserveu.utility.pidUtil;

public class ParamBean {
	private String name;
	private String value;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "ParamBean [name=" + name + ", value=" + value + "]";
	}
}
