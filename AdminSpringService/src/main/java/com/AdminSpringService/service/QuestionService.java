package com.AdminSpringService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AdminSpringService.model.Question;
import com.AdminSpringService.model.Topic;
import com.AdminSpringService.repositry.QuestionRepository;
import com.AdminSpringService.repositry.TopicRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepo;

	@Autowired
	private TopicRepository topicRepository;

	public List<Question> getPendingQuestions() {
		return this.questionRepo.findByQstatus(1);
	}

	public Question addQuestion(Question question) {
		return this.questionRepo.save(question);
	}

	public Question aproveQuestion(Question question) {
		System.out.println("question update " + question.getQstatus());
		return this.questionRepo.save(question);
	}

	public Boolean removeQuestion(int id) {
		this.questionRepo.deleteById(id);
		return true;
	}

	public List<Topic> getAllTopics() {
		return this.topicRepository.findAll();
	}

	public Topic addTopic(Topic topic) {
		return this.topicRepository.save(topic);
	}

	public List<Question> getQuestionsByUserId(int userid) {

		return this.questionRepo.findAllByUserUserid(userid);
	}

	public List<Question> getAllQuestion() {
		return this.questionRepo.findByQstatus(0);
	}

	public List<Question> getQuestionByTopic(int tid) {
		// TODO Auto-generated method stub
		return this.questionRepo.findAllByTopicTopicidAndQstatus(tid, 0);
	}

}
