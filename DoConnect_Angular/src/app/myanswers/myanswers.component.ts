import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-myanswers',
  templateUrl: './myanswers.component.html',
  styleUrls: ['./myanswers.component.css']
})
export class MyanswersComponent implements OnInit {

  user: any;
  userAnswers: any;
  email: any = localStorage.getItem('email')

  constructor(private formbuilder: FormBuilder, public as: AdminService) {
    // this.user={email:'',password:'',username:'',userid:0}


  }

  ngOnInit(): void {

    this.as.getUserByEmail(this.email).subscribe(
      res => {
        this.user = res;
        console.log(this.user, "oninit");
        this.as.getAnswersByUserId(this.user).subscribe(
          res => {
            console.log(this.user)
            this.userAnswers = res;
          },
          err => {
            console.log("2")
          }
        )



      }
    )
  }

}
