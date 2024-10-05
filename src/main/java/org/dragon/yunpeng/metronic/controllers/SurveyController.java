package org.dragon.yunpeng.metronic.controllers;

import org.dragon.yunpeng.metronic.pojos.Answer;
import org.dragon.yunpeng.metronic.pojos.Question;
import org.dragon.yunpeng.metronic.pojos.Survey;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SurveyController {

	@GetMapping("/forms/surveyForm")
	public String showForm(Model model) {
		// Create a survey with two empty questions, each with two empty answers
		Survey survey = new Survey();
		Question question1 = new Question();
		question1.setAnswers(List.of(new Answer(), new Answer()));

		Question question2 = new Question();
		question2.setAnswers(List.of(new Answer(), new Answer()));

		survey.setQuestions(List.of(question1, question2));

		model.addAttribute("survey", survey);
		return "pages/nestedListForm"; // Return the form page
	}

	@PostMapping("/forms/submitSurvey")
	public String submitSurvey(@ModelAttribute Survey survey, Model model) {
		// Print out the submitted data for testing
		System.out.println("Title: " + survey.getTitle());

		for (Question question : survey.getQuestions()) {
			System.out.println("Question: " + question.getQuestionText());
			for (Answer answer : question.getAnswers()) {
				System.out.println("Answer: " + answer.getAnswerText());
			}
		}

		// Add the submitted data to the model for display on the result page
		model.addAttribute("submittedSurvey", survey);
		return "pages/nestedListFormResult"; // Display result page (create this page as needed)
	}
}
