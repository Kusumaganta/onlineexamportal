package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.Quiz;
import com.exam.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	private QuizService quizService;
	
	// add quiz service 
	@PostMapping("/")
	public ResponseEntity<Quiz> add(@RequestBody Quiz quiz)
	{
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	}
	//update quiz 
	@PutMapping("/")
	public ResponseEntity<Quiz> update(@RequestBody Quiz quiz)
	{
		return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
		
	}
	//getting  all quiz 
	@GetMapping("/")
	public ResponseEntity<?> quizzes()
	{return ResponseEntity.ok(this.quizService.getQuizzes());
		
	}
	
	// get single quiz 
	@GetMapping("/{qid}")
	public  Quiz quiz(@PathVariable("qid") long qid){
		{
			return  this.quizService.getQuiz(qid);
		}
	}

	// delete the quiz 
	@DeleteMapping("/{qid}")
	public void delete(@PathVariable("qid") long qid)
	{
		this.quizService.deleteQuiz(qid);
	}
	
	
}
