import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { AuthGuard } from './AuthGuards/auth.guard';
import { UserAuthGuard } from './AuthGuards/user-auth.guard';
import { LoginComponent } from './login/login.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { QuestionAnswersComponent } from './question-answers/question-answers.component';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'questionanswer', component: QuestionAnswersComponent },
  { path: 'login', component: LoginComponent },
  { path: 'adminlogin', component: AdminloginComponent },
  { path: 'admindashboard', component: AdmindashboardComponent,canActivate:[AuthGuard] },
  { path: 'userdashboard', component: UserdashboardComponent,canActivate:[UserAuthGuard] },
  {path:'**', component:PagenotfoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
