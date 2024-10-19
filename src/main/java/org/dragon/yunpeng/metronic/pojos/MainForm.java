package org.dragon.yunpeng.metronic.pojos;

import java.util.ArrayList;
import java.util.List;

public class MainForm {
	private String mainInput;
    private List<SubForm> subFormList = new ArrayList<SubForm>();

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
