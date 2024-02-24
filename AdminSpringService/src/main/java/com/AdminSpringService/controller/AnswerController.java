package com.AdminSpringService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AdminSpringService.model.Answer;
import com.AdminSpringService.service.AnswerService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:62566" })
@RequestMapping(value = "/answer")
public class AnswerController {

	@Autowired
	private AnswerService answerService;

	@GetMapping("/getAnswersByQuestion/{qid}")
	public ResponseEntity<?> getAnswersByQuestion(@PathVariable int qid) {
		return new ResponseEntity<List<Answer>>(this.answerService.getAnswersByQuestion(qid), HttpStatus.CREATED);
	}

	@PostMapping("")
	public ResponseEntity<?> addingAnswer(@RequestBody Answer answer) {
		return new ResponseEntity<Answer>(this.answerService.addAnswer(answer), HttpStatus.CREATED);
	}

	@GetMapping("/getpendingAnswers")
	public ResponseEntity<?> getPendingAnswer() {
		return new ResponseEntity<List<Answer>>(this.answerService.getPendingAnswers(), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> rejectAnswer(@PathVariable int id) {
		System.out.println(id);
		return new ResponseEntity<Boolean>(this.answerService.removeAnswer(id), HttpStatus.CREATED);
	}

	@PutMapping("")
	public ResponseEntity<?> aproveAnswer(@RequestBody Answer answer) {
		return new ResponseEntity<Answer>(this.answerService.aproveAnswer(answer), HttpStatus.CREATED);
	}

	@GetMapping("/getAnswersByUserId/{userid}")
	public ResponseEntity<?> getAnswersByUserId(@PathVariable int userid) {
		return new ResponseEntity<List<Answer>>(this.answerService.getAnswersByUserId(userid), HttpStatus.CREATED);
	}
}
