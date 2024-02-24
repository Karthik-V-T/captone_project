import { Component, OnInit } from '@angular/core';
import { Question } from '../model/Question';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-pendingquestions',
  templateUrl: './pendingquestions.component.html',
  styleUrls: ['./pendingquestions.component.css']
})
export class PendingquestionsComponent implements OnInit {




  pendingQuestions: any;
  constructor(private as: AdminService) {
    this.pendingQuestions = [];
  }

  ngOnInit(): void {

    this.as.getPendingQuestions()
      .subscribe(res => {
        console.log(res)
        this.pendingQuestions = res;
      })
  }
  approveQuestion(question: any) {
    question.qstatus = 0;
    console.log(question)
    this.as.aproveQuestion(question).subscribe(
      respone => {
        this.as.getPendingQuestions()
          .subscribe(res => {
            console.log(res)
            this.pendingQuestions = res;
          })
        alert(`${question.questionname} approved`);

      },
      error => {
        alert('something went wrong')
      }

    )
  }

  deleteQuestion(question: Question) {
    console.log('delete', question)
    this.as.rejectQuestion(question.id).subscribe(
      response => {
        this.as.getPendingQuestions()
          .subscribe(res => {
            console.log(res)
            this.pendingQuestions = res;
            alert(question.questionname + " deleted");
          })
      }, err => {
        alert('something went woring');
      }
    )
  }

}
