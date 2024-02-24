package com.AdminSpringService.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AdminSpringService.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer>{

}
