package org.dragon.yunpeng.metronic.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Child implements Serializable {
	private String selection;
	private String text;
	private String title;

	private List<String> options;

	public Child(String optionMark) {
		options = new ArrayList<String>();

		for (int i = 0; i < 4; i++) {
			String option = optionMark + i;

			options.add(option);
		}
	}

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

}
