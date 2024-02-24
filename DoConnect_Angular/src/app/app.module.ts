import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthGuard } from './AuthGuards/auth.guard';
import { UserAuthGuard } from './AuthGuards/user-auth.guard';
import { ChatComponent } from './chat/chat.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { MaterialModule } from './material/material.module';
import { MyanswersComponent } from './myanswers/myanswers.component';
import { MyquestionsComponent } from './myquestions/myquestions.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { PendinganswersComponent } from './pendinganswers/pendinganswers.component';
import { PendingquestionsComponent } from './pendingquestions/pendingquestions.component';
import { SearchFilterPipe } from './Pipe/search-filter.pipe';
import { QuestionAnswersComponent } from './question-answers/question-answers.component';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    QuestionAnswersComponent,
    LoginComponent,
    PagenotfoundComponent,
    UserdashboardComponent,
    MyquestionsComponent,
    MyanswersComponent,
    AdminloginComponent,
    AdmindashboardComponent,
    PendingquestionsComponent,
    PendinganswersComponent,
    SearchFilterPipe,
    ChatComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    ReactiveFormsModule,
    Ng2SearchPipeModule


  ],
  providers: [AuthGuard,UserAuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
