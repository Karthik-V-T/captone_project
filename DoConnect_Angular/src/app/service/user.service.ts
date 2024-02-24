import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { map } from 'rxjs/operators';
import { User } from '../model/User';
import { Observable } from 'rxjs';
import { LoginUser } from '../model/LoginUser';


@Injectable({

  providedIn: 'root'
})
export class UserService {

  userURL: any = environment.userURL;

  constructor(private http: HttpClient) { }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('email');
  }

  isAdminLoggedIn(): boolean {
    return !!localStorage.getItem('a_email');
  }
  username():string|null{
    return localStorage.getItem("name");
  }

  adminname():string|null{
    return localStorage.getItem("adminname");
  }

  public registerUser(user: object): Observable<object> {
    console.log(user, 'us');
    return this.http.post(`${this.userURL}/addUser`, user);
  }

  public loginUser(loginUser:LoginUser): Observable<object> {
    console.log(loginUser);
    return this.http.post(`${this.userURL}/userLogin`,loginUser);
  }

}
