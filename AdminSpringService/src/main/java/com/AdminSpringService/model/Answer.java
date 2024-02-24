package com.AdminSpringService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String answername;
	private String answerimage;
	@ManyToOne
	private UserDetails user;
	@ManyToOne
	private Question question;
	private int astatus;

	public Answer() {
		// TODO Auto-generated constructor stub
	}

	public Answer(int id, String answername, String answerimage, UserDetails user, Question question, int astatus) {
		super();
		this.id = id;
		this.answername = answername;
		this.answerimage = answerimage;
		this.user = user;
		this.question = question;
		this.astatus = astatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswername() {
		return answername;
	}

	public void setAnswername(String answername) {
		this.answername = answername;
	}

	public String getAnswerimage() {
		return answerimage;
	}

	public void setAnswerimage(String answerimage) {
		this.answerimage = answerimage;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public int getAstatus() {
		return astatus;
	}

	public void setAstatus(int astatus) {
		this.astatus = astatus;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", answername=" + answername + ", answerimage=" + answerimage + ", user=" + user
				+ ", question=" + question + ", astatus=" + astatus + "]";
	}
}
