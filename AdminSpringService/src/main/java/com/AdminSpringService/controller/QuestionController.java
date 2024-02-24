package com.AdminSpringService.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.AdminSpringService.model.Question;
import com.AdminSpringService.model.Topic;
import com.AdminSpringService.service.EmailSenderService;
import com.AdminSpringService.service.QuestionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:62566" })
@RequestMapping(value = "/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private EmailSenderService emailSenderService;
	
	@Autowired
	ServletContext servletContext;

	@GetMapping("/getAllQuestion")
	public ResponseEntity<?> getAllQuestion() {
		return new ResponseEntity<List<Question>>(this.questionService.getAllQuestion(), HttpStatus.CREATED);
	}

	@PostMapping("")
	public ResponseEntity<?> addingQuestion(@RequestParam(value="questonFile",required = false) MultipartFile questonFile,@RequestParam("question") String question) throws JsonMappingException, JsonProcessingException {
		
		Question question2 = new ObjectMapper().readValue(question, Question.class);
		
		System.out.println(questonFile);
		System.out.println(question2);
		if(questonFile!=null) {
		boolean isExists =new File(servletContext.getRealPath("/images")).exists();
		if(!isExists) {
			new File(servletContext.getRealPath("/images")).mkdir();
		}
		String questionimage = questonFile.getOriginalFilename();
		String modifiedQuestionimage = FilenameUtils.getBaseName(questionimage)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(questionimage);
		question2.setQuestionimage(modifiedQuestionimage);
		
		File image = new File(servletContext.getRealPath("/images/"+File.separator+modifiedQuestionimage));
		
		
		try {
			FileUtils.writeByteArrayToFile(image,questonFile.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		String mailBody = "Hi Admin" + "\nThere is a new Question from user " + question2.getUser().getUsername()
				+ "\nQuestion : " + question2.getQuestionname() + "\nClick below link to approve or reject the question"
				+ "\nhttp://localhost:4200/admindashboard";
		this.emailSenderService.sendSimpleEmail("tkarthik642@gmail.com", mailBody, "Requesting for posting question");

		return new ResponseEntity<Question>(this.questionService.addQuestion(question2), HttpStatus.CREATED);
	}

	@GetMapping("/getPendingQuestions")
	public ResponseEntity<?> getPendingQuestions() {
		return new ResponseEntity<List<Question>>(this.questionService.getPendingQuestions(), HttpStatus.CREATED);
	}

	@GetMapping("/getQuestionByTopic/{tid}")
	public ResponseEntity<?> getQuestionByTopic(@PathVariable int tid) {
		return new ResponseEntity<List<Question>>(this.questionService.getQuestionByTopic(tid), HttpStatus.CREATED);
	}

	@PutMapping("")
	public ResponseEntity<?> aproveQuestion(@RequestBody Question question) {
		System.out.println(question.getQstatus());
		return new ResponseEntity<Question>(this.questionService.aproveQuestion(question), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> rejectQuestion(@PathVariable int id) {
		System.out.println(id);
		return new ResponseEntity<Boolean>(this.questionService.removeQuestion(id), HttpStatus.CREATED);
	}

	@GetMapping("/topic")
	public ResponseEntity<?> getTopics() {
		return new ResponseEntity<List<Topic>>(this.questionService.getAllTopics(), HttpStatus.CREATED);
	}

	@PostMapping("/topic")
	public ResponseEntity<?> addTopic(@RequestBody Topic topic) {
		return new ResponseEntity<Topic>(this.questionService.addTopic(topic), HttpStatus.CREATED);
	}

	@GetMapping("/getQuestionsByUserId/{userid}")
	public ResponseEntity<?> getQuestionsByUserId(@PathVariable int userid) {
		return new ResponseEntity<List<Question>>(this.questionService.getQuestionsByUserId(userid),
				HttpStatus.CREATED);
	}

}
