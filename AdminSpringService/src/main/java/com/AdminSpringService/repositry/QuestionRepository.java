package com.AdminSpringService.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AdminSpringService.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{

	public List<Question> findByQstatus(int status);
	public List<Question> findAllByUserUserid(int userid);
	public List<Question> findAllByTopicTopicid(int tid);
	public List<Question> findAllByTopicTopicidAndQstatus(int tid, int i);
}
