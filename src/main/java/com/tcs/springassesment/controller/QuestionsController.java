package com.tcs.springassesment.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.springassesment.entity.Question;
import com.tcs.springassesment.entity.User;
import com.tcs.springassesment.service.IQuestionService;

@RestController
@RequestMapping("/question")
public class QuestionsController {

	@Autowired
	IQuestionService questionService;
	
	@PostMapping
	public Question createQuestion(@RequestBody Question ques) {
		return questionService.saveQuestion(ques);
	}
	
	@GetMapping
	public Iterable<Question> getAllQuestion() {
		return questionService.getAll();
	}
	@DeleteMapping("/question/{id}")
	public void deleteQuestion(@PathVariable Integer id) {
		 questionService.deleteQuestion(id);
	}
	
	@PutMapping("/answer/{id}")
	public String addAnswer(@RequestBody Question question ,@PathVariable Integer id) {
		return questionService.updateAnswers(question,id);
	}
	@PutMapping("/increment/{id}")
	public String upvote(@RequestBody Question question ,@PathVariable Integer id) {
		return questionService.upvote(question,id);
	}
	
}
