import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-admindashboard',
  templateUrl: './admindashboard.component.html',
  styleUrls: ['./admindashboard.component.css']
})
export class AdmindashboardComponent implements OnInit {

  navSelected: string = "pendingquestions";

  constructor(private formbuilder: FormBuilder) { }

  ngOnInit(): void {

  }

  formvalue !: FormGroup;

  navSelection(navSelected: string) {
    this.navSelected = navSelected;
  }

}
