package com.AdminSpringService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AdminSpringService.model.Answer;
import com.AdminSpringService.repositry.AnswerRepository;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository answerRepository;

	public List<Answer> getPendingAnswers() {
		return this.answerRepository.findByAstatus(1);
	}

	public Answer addAnswer(Answer answer) {

		return this.answerRepository.save(answer);
	}

	public Boolean removeAnswer(int id) {
		this.answerRepository.deleteById(id);
		return true;
	}

	public Answer aproveAnswer(Answer answer) {

		return this.answerRepository.save(answer);
	}

	public List<Answer> getAnswersByQuestion(int qid) {
		return this.answerRepository.findByQuestionIdAndAstatus(qid, 0);
	}

	public List<Answer> getAnswersByUserId(int userid) {
		// TODO Auto-generated method stub
		return this.answerRepository.findAllByUserUserid(userid);
	}
}
