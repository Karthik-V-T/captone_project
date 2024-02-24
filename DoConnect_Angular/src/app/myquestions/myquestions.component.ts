import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { InitialNavigation } from '@angular/router';
import { User } from '../model/User';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-myquestions',
  templateUrl: './myquestions.component.html',
  styleUrls: ['./myquestions.component.css']
})
export class MyquestionsComponent implements OnInit {
  user: any;
  userQuestions: any;
  email: any = localStorage.getItem('email')

  constructor(private formbuilder: FormBuilder, public as: AdminService) {
    // this.user={email:'',password:'',username:'',userid:0}


  }

  ngOnInit(): void {



    this.as.getUserByEmail(this.email).subscribe(
      res => {
        this.user = res;
        console.log(this.user, "oninit");
        this.as.getQuestionsByUserId(this.user).subscribe(
          res => {
            console.log(this.user);
            this.userQuestions = res;
          },
          err => {
            console.log("2")
          }
        )



      }
    )






  }

}
