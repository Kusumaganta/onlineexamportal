package com.exam.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entity.Question;
import com.exam.entity.Quiz;
import com.exam.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {
    
	@Autowired
	private QuestionRepository questionRepository;
	@Override
	public Question addQuestion(Question question) {
		return this.questionRepository.save(question);
		
	}

	@Override
	public Question updateQuestion(Question question) {
		return this.questionRepository.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		
		return new HashSet<>(this.questionRepository.findAll());
	}
	@Override
	public Question getQuestion(Long questionId) {
	return this.questionRepository.findById(questionId).get();
	}

	@Override
	public Set<Question> getQuestionOfQuiz(Quiz quiz) {
		return this.questionRepository.findByQuiz(quiz);
	}

	@Override
	public void deleteQuestion(long questionId) {
		Question question = new Question();
		question.setQuesId(questionId);
		this.questionRepository.deleteById(questionId);
		
	}

}
