package com.tcs.springassesment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.springassesment.entity.Question;
import com.tcs.springassesment.entity.User;
import com.tcs.springassesment.exception.UserNotFoundException;
import com.tcs.springassesment.repository.IQuestionRepository;

@Service
public class QuestionService implements IQuestionService {

	@Autowired
	IQuestionRepository questionRepository;
	
	@Override
	public Question saveQuestion(Question question) {	
		return questionRepository.save(question);
	}

	@Override
	public Iterable<Question> getAll() {
		return questionRepository.findAll();
	}

	@Override
	public void deleteQuestion(Integer id) {
		Optional<Question> question = questionRepository.findById(id);
		if(!question.isPresent()) {
			throw new UserNotFoundException("appointment does not exist");
		}
		 questionRepository.deleteById(id);
	}

	@Override
	public String updateAnswers(Question question, Integer id) {
		Optional<Question> question1 = questionRepository.findById(id);
		if(!question1.isPresent()) {
			throw new UserNotFoundException("appointment does not exist");
		}
		List<String> ans=question.getAnswers();
		question1.get().setAnswers(ans);
		return "added new answer";
	}

	@Override
	public String upvote(Question question, Integer id) {
		Optional<Question> question1 = questionRepository.findById(id);
		if(!question1.isPresent()) {
			throw new UserNotFoundException("appointment does not exist");
		}
		int vote=  question1.get().getVote();
		question1.get().setVote(vote+1);
		return null;
	}
	
	public String downvote(Question question, Integer id) {
		Optional<Question> question1 = questionRepository.findById(id);
		if(!question1.isPresent()) {
			throw new UserNotFoundException("appointment does not exist");
		}
		int vote=  question1.get().getVote();
		question1.get().setVote(vote-1);
		return null;
	}
		
	
}
