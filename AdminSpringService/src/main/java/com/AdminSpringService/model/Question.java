package com.AdminSpringService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String questionname;
	private String questionimage;
	@ManyToOne
	private Topic topic;
	@ManyToOne
	private UserDetails user;
	private int qstatus;

	public Question() {
	}

	public Question(int id, String questionname, String questionimage, Topic topic, UserDetails user, int qstatus) {
		super();
		this.id = id;
		this.questionname = questionname;
		this.questionimage = questionimage;
		this.topic = topic;
		this.user = user;
		this.qstatus = qstatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionname() {
		return questionname;
	}

	public void setQuestionname(String questionname) {
		this.questionname = questionname;
	}

	public String getQuestionimage() {
		return questionimage;
	}

	public void setQuestionimage(String questionimage) {
		this.questionimage = questionimage;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic qtype) {
		this.topic = qtype;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public int getQstatus() {
		return qstatus;
	}

	public void setQstatus(int qstatus) {
		this.qstatus = qstatus;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", questionname=" + questionname + ", questionimage=" + questionimage + ", Topic="
				+ topic + ", user=" + user + ", qstatus=" + qstatus + "]";
	}

}
