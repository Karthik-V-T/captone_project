import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Answer } from '../model/Answer';
import { Question } from '../model/Question';
import { Topic } from '../model/Topic';
import { User } from '../model/User';
import { AdminService } from '../service/admin.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-question-answers',
  templateUrl: './question-answers.component.html',
  styleUrls: ['./question-answers.component.css']
})
export class QuestionAnswersComponent implements OnInit {
  public filterTerm: any;
  baseUrl:string='http://localhost:8082//images/';


  constructor(private formbuilder: FormBuilder, public us: UserService, public route: Router, public as: AdminService) {
    this.topic = { cetegory: "" }
    // this.filterQuestions='';
    this.answer = {
      answername: "",
      astatus: 1,
      question: { qstatus: 1, questionname: '', topic: { cetegory: '' }, user: { email: '', password: '', username: '' } },

      user: { email: '', password: '', username: "" }
    };

  }
  email: string | null = localStorage.getItem("email");
  user: any
  answer: Answer;
  viewAnswers: any = 0;
  topic: Topic;
  filterData: any;
  questions: any;
  answers: any;



  // localStorage.setItem('redirectTo', this.route.url);


  formvalue !: FormGroup;
  ngOnInit(): void {

    this.as.getAllQuestion().subscribe(
      res => {
        this.questions = res;
      }
    )

    this.as.getTopics().subscribe(
      res => {
        console.log(res)
        this.filterData = res;
      }
    )
    this.formvalue = this.formbuilder.group({

      question: [""],
      answer: [""]


    })

    this.as.getUserByEmail(this.email).subscribe(
      res => {
        this.user = res;
      }
    )
  }
  showAnswerList(qid: any) {
    this.as.getAnswersByQuestion(qid).subscribe(
      res => {
        console.log(res, this.answers)
        this.answers = res;
        this.viewAnswers = qid;
      }
    )

  }

  askQuestion() {

    if (this.us.isLoggedIn()) {
      console.log("ask question")
      this.route.navigate(['userdashboard']);

    } else {
      localStorage.setItem('redirectTo', this.route.url);
      this.route.navigate(['login']);
    }

  }

  userLogin() {
    this.route.navigate(['login'])
  }

  postAnswer(question: Question) {

    console.log(this.user);
    this.answer.user = this.user;
    this.answer.question = question;

    if (this.us.isLoggedIn()) {
      this.as.addingAnswer(this.answer).subscribe(
        res => {
          alert("Your answer sent for approval")
        }
      )
      console.log(this.answer)
    }
    else {
      alert("Sign in to answer");
      localStorage.setItem('redirectTo', this.route.url);
      this.route.navigate(['login']);

    }

  }

  selectTopic(tid: any) {
    this.as.getQuestionByTopic(tid).subscribe(
      res => {
        this.questions = res;
      }
    )
    console.log(tid);
  }


  addTopic() {
    this.as.addTopic(this.topic).subscribe(
      res => {
        this.as.getTopics().subscribe(
          res => {
            console.log(res)
            this.filterData = res;
          }
        )
        console.log(res)
      });
    console.log(this.topic);
  }


}
