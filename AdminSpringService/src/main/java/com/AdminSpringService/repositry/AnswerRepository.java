package com.AdminSpringService.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AdminSpringService.model.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

	public List<Answer> findByAstatus(int ststus);

	public List<Answer> findByQuestionId(int qid);

	public List<Answer> findByQuestionIdAndAstatus(int qid,int astatus);

	public List<Answer> findAllByUserUserid(int userid);

}
