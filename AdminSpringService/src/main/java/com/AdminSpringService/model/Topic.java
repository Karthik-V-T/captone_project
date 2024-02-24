package com.AdminSpringService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int topicid;
	private String cetegory;

	public Topic() {
		// TODO Auto-generated constructor stub
	}

	public Topic(int topicid, String cetegory) {
		super();
		this.topicid = topicid;
		this.cetegory = cetegory;
	}

	public int getTopicid() {
		return topicid;
	}

	public void setTopicid(int topicid) {
		this.topicid = topicid;
	}

	public String getCetegory() {
		return cetegory;
	}

	public void setCetegory(String cetegory) {
		this.cetegory = cetegory;
	}

	@Override
	public String toString() {
		return "Topic [topicid=" + topicid + ", cetegory=" + cetegory + "]";
	}

}
