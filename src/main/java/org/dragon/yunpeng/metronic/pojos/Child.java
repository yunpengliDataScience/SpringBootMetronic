package org.dragon.yunpeng.metronic.pojos;

import java.io.Serializable;

public class Child implements Serializable {
	private String selection;
	private String text;

	public String getSelection() {
		return selection;
	}

	public void setSelection(String selection) {
		this.selection = selection;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}