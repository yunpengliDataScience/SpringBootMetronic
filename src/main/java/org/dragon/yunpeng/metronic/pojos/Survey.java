package org.dragon.yunpeng.metronic.pojos;

import java.util.List;

public class Survey {
	private String title;
	private List<Question> questions;

	// Getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}
