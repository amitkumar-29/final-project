package com.tcs.springassesment.service;


import com.tcs.springassesment.entity.Question;


public interface IQuestionService {

	Question saveQuestion(Question question);

	Iterable<Question> getAll();

	void deleteQuestion(Integer id);

	String updateAnswers(Question question, Integer id);

	String upvote(Question question, Integer id);

	

}
