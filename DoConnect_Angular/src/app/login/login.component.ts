import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginUser } from '../model/LoginUser';
import { User } from '../model/User';
import { AdminService } from '../service/admin.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginUser: LoginUser
  user:any;
  newUser: User
  constructor(private us: UserService, private route: Router, public as: AdminService) {
    this.loginUser = {'password': '', 'email': '' };
    this.newUser = { 'username': '', 'password': '', 'email': '' };
    this.user = { 'username': '', 'password': '', 'email': '' };
  }



  ngOnInit(): void {
  }

  login() {

    let redirectTo = localStorage.getItem('redirectTo');
    console.log(this.loginUser)

    this.us.loginUser(this.loginUser)
      .subscribe(res => {
        console.log(res)
        this.user=res;
        localStorage.setItem('name',this.user.username);
        localStorage.setItem('email',this.user.email);

        if (redirectTo) {
          localStorage.removeItem('redirectTo');
          this.route.navigate([redirectTo]);
        }
        else {
          this.route.navigate(['userdashboard']);
        }
      },
        err => {
          alert("Invalid credentials")
        }
      )


  }
  register() {

    let redirectTo = localStorage.getItem('redirectTo');
    

    console.log(this.newUser, 'login');
    this.us.registerUser(this.newUser)
      .subscribe(res => {
        console.log(res);
        alert("user added Sucecssfully");
        this.user=res;
        localStorage.setItem('name',this.user.username);
        localStorage.setItem('email',this.user.email);
        if (redirectTo) {
          localStorage.removeItem('redirectTo');
          this.route.navigate([redirectTo]);
        }else{
        this.route.navigate(['userdashboard']);
        }
      },
        err => {
          alert("Something went wrong")
        }
      )

    console.log(this.newUser)


  }
  viewQA() {
    this.route.navigate(['questionanswer'])
  }
}
