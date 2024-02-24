import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from '../model/Admin';
import { LoginUser } from '../model/LoginUser';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {

  admin: LoginUser
  newAdmin: Admin

  constructor(private as: AdminService, private route: Router) {
    this.admin = { 'email': '', 'password': '' };
    this.newAdmin = { 'adminname': '', 'password': '', 'email': '' }
  }



  ngOnInit(): void {
  }

  login() {

    let email: string = this.admin.email;
    let password: string = this.admin.password;
    console.log(email, password)

    this.as.loginAdmin(this.admin)
      .subscribe((res: any) => {

        if (res != null) {
          console.log(res)
          localStorage.setItem('adminname', res.adminname)
          localStorage.setItem('a_email', email)
          this.route.navigate(['admindashboard'])
        } else {
          alert("Invalid Credentials")
        }
      },
        (err: any) => {
          alert("Invalid credentials")
        }
      )
  }
  register() {

    console.log(this.newAdmin, 'admin login');
    this.as.registerAdmin(this.newAdmin)
      .subscribe((res: any) => {
        console.log(res);

        alert('admin added successfully Sign in');

        this.route.navigate(['adminlogin']);
      },
        (err: any) => {
          alert("Something went wrong")
        }

      )

    console.log(this.newAdmin)


  }
  back() {
    this.route.navigate(['questionanswer'])
  }

}
