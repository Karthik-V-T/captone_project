import { Component, OnInit } from '@angular/core';
import { Answer } from '../model/Answer';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-pendinganswers',
  templateUrl: './pendinganswers.component.html',
  styleUrls: ['./pendinganswers.component.css']
})
export class PendinganswersComponent implements OnInit {

  pendinganswers: any;
  constructor(private as: AdminService) {
    this.pendinganswers = [];
  }
  

  ngOnInit(): void {
    this.as.getPendingAnswers()
      .subscribe(res => {
        console.log(res)
        this.pendinganswers = res;
      })
      
  }

  approveAnswer(answer: any) {
    answer.astatus = 0;
    console.log(answer)
    this.as.aproveAnswer(answer).subscribe(
      respone => {
        this.as.getPendingAnswers()
          .subscribe(res => {
            console.log(res)
            this.pendinganswers = res;
          })
        alert(`answer ${answer.id} approved`);

      },
      error => {
        alert('something went wrong')
      }

    )
  }

  deleteAnswer(answer: any) {
    console.log('delete', answer)
    this.as.rejectAnswer(answer.id).subscribe(
      response => {
        this.as.getPendingAnswers()
          .subscribe(res => {
            console.log(res)
            this.pendinganswers = res;
            alert(answer.id + " deleted");
          })
      }, err => {
        alert('something went woring');
      }
    )
  }

}
