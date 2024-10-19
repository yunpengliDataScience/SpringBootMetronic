package org.dragon.yunpeng.metronic.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainForm implements Serializable {
	private String mainInput;
	private List<SubForm> subFormList = new ArrayList<SubForm>();

	public MainForm() {

	}

	// Getters and setters
	public String getMainInput() {
		return mainInput;
	}

	public void setMainInput(String mainInput) {
		this.mainInput = mainInput;
	}

	public List<SubForm> getSubFormList() {
		return subFormList;
	}

	public void setSubFormList(List<SubForm> subFormList) {
		this.subFormList = subFormList;
	}
}
