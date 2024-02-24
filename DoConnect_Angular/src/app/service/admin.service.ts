import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Answer } from '../model/Answer';
import { LoginUser } from '../model/LoginUser';
import { Question } from '../model/Question';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class AdminService {



  adminURL: any = environment.adminURL;
  constructor(private http: HttpClient) { }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('a_email');
  }

  // ******************Admin Control********************************

  public loginAdmin(admin: LoginUser): Observable<object> {
    console.log(admin);
    return this.http.post(`${this.adminURL}/adminLogin`,admin);
  }

  public registerAdmin(admin: object): Observable<object> {
    console.log(admin, 'as');
    // console.log(this.http.post(`${this.adminURL}/addAdmin`, admin))
    return this.http.post(`${this.adminURL}/`, admin)
      ;
  }





  /*******************Question Controll************************* */

  public getPendingQuestions(): Observable<object> {
    return this.http.get(`${this.adminURL}/question/getPendingQuestions`);
  }

  public getAllQuestion(): Observable<object> {
    return this.http.get(`${this.adminURL}/question/getAllQuestion`);
  }

  public getQuestionByTopic(tid: any) {
    return this.http.get(`${this.adminURL}/question/getQuestionByTopic/` + tid);
  }

  public aproveQuestion(question: any) {
    console.log('in as', question)
    return this.http.put(`${this.adminURL}/question`, question);
  }

  public rejectQuestion(id: any) {
    console.log('in as', id)
    return this.http.delete(`${this.adminURL}/question/` + id);
  }

  public postQuestion(formData:FormData) {
    return this.http.post(`${this.adminURL}/question/`,formData);
  }

  public getTopics(): Observable<object> {
    return this.http.get(`${this.adminURL}/question/topic`);
  }

  public addTopic(topic: any) {
    console.log(topic, 'in as')
    return this.http.post(`${this.adminURL}/question/topic`, topic);
  }

  public getQuestionsByUserId(user: User) {

    console.log(user, "as")

    return this.http.get(`${this.adminURL}/question/getQuestionsByUserId/` + user.userid);
  }

  /******************Answer Control************************* */


  public addingAnswer(answer: Answer) {
    return this.http.post(`${this.adminURL}/answer`, answer)
  }

  public getPendingAnswers(): Observable<object> {
    return this.http.get(`${this.adminURL}/answer/getpendingAnswers`);
  }

  public getAnswersByQuestion(qid: any) {
    return this.http.get(`${this.adminURL}/answer/getAnswersByQuestion/` + qid);
  }

  public aproveAnswer(answer: any) {
    console.log('in as', answer)
    return this.http.put(`${this.adminURL}/answer`, answer);
  }

  public rejectAnswer(id: any) {
    console.log(id);
    return this.http.delete(`${this.adminURL}/answer/` + id);
  }

  public getAnswersByUserId(user: User) {
    return this.http.get(`${this.adminURL}/answer/getAnswersByUserId/` + user.userid);
  }

  /************************User Control****************** */

  public getUserByEmail(email: any) {
    console.log(email);
    return this.http.get(`${this.adminURL}/user/getUserByEmail/` + email);
  }

  public updateUser(user: object): Observable<object> {
    console.log(user, 'as');
    return this.http.put(`${this.adminURL}/user`, user);
  }

  public deleteUser(user: object): Observable<object> {
    console.log(user, 'as');
    return this.http.delete(`${this.adminURL}/user`, user);
  }

}
