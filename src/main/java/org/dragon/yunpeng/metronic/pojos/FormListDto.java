package org.dragon.yunpeng.metronic.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.dragon.yunpeng.metronic.entities.Form;

public class FormListDto implements Serializable {

	private List<Form> forms;

	public FormListDto() {
		forms = new ArrayList<Form>();
	}

	public List<Form> getForms() {
		return forms;
	}

	public void setForms(List<Form> forms) {
		this.forms = forms;
	}

	public void addForm(Form form) {
		this.forms.add(form);
	}
}
