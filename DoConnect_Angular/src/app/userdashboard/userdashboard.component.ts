import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Alert } from 'selenium-webdriver';
import { Answer } from '../model/Answer';
import { Question } from '../model/Question';
import { Topic } from '../model/Topic';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-userdashboard',
  templateUrl: './userdashboard.component.html',
  styleUrls: ['./userdashboard.component.css']
})
export class UserdashboardComponent implements OnInit {

  public questionFile:any=File;
  navSelected: string = '';
  topic: Topic
  filterData: any;
  email: any = localStorage.getItem('email');
  user: any;
  question: any;

  constructor(private formbuilder: FormBuilder, public as: AdminService) {
    this.topic = { cetegory: '', topicid: 0 }
    this.question = {
      qstatus: 1,
      questionname: '',
      topic: {
        topicid: 0
      },
      user: {
        userid: 0,
        email: '',
        password: '',
        username: ''
      },
      questionimage: ''

    }

  }

  ngOnInit(): void {
    this.as.getTopics().subscribe(
      res => {
        console.log(res)
        this.filterData = res;
      }
    )
    this.as.getUserByEmail(this.email).subscribe(
      res => {
        this.user = res;
      }
    )
  }

  formvalue !: FormGroup;

  navSelection(navSelected: string) {
    this.navSelected = navSelected;
  }

  postQuestion() {
    const formData= new FormData();
    this.question.topic = this.topic;
    this.question.user = this.user;
    console.log(this.user);
    console.log(this.question);
    formData.append('question',JSON.stringify(this.question));
    formData.append('questonFile',this.questionFile)
    this.as.postQuestion(formData).subscribe(
      res => {
        console.log(res);
        alert("Question Sent for Approval")
      }, err => {
        alert("Something Went wrong " + err);
      }
    )

  }

  onSelect(event: any) {
    const file = event.target.files[0];
    console.log(file);
    this.questionFile=file;
  }

}
