package org.dragon.yunpeng.metronic.pojos;

import java.io.Serializable;

public class SubForm implements Serializable {
	private String field1;
	private String field2;

	public SubForm() {

	}

	// Constructor
	public SubForm(String field1, String field2) {
		this.field1 = field1;
		this.field2 = field2;
	}

	// Getters and setters
	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}
}
