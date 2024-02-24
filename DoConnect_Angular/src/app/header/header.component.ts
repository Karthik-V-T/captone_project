import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../service/admin.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {


  user: any;
  email: any = localStorage.getItem('email');

  constructor(public us: UserService, public route: Router, public as: AdminService) {
    this.as.getUserByEmail(this.email).subscribe(
      res => {
        this.user = res;
      }
    )
  }


  ngOnInit(): void {

    // this.email=localStorage.getItem('email')
    // console.log(this.email, "header")
    // this.as.getUserByEmail(this.email).subscribe(
    //   res=>{
    //     this.user=res;
    //   }
    // )
  }

  // isloggedin:boolean = this.us.isLoggedIn();
  userLogin() {
    this.route.navigate(['login']);
  }
  logout() {
    localStorage.clear();
    this.route.navigate(['']);
  }


  adminlogin() {
    this.route.navigate(['adminlogin']);
  }
}
