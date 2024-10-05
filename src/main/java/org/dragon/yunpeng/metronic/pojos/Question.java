package org.dragon.yunpeng.metronic.pojos;

import java.util.List;

public class Question {
	private String questionText;
	private List<Answer> answers;

	// Getters and setters
	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
}
