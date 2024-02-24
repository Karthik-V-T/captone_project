import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AdminService } from '../service/admin.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private as: AdminService,
    private router: Router) { }

  canActivate(): boolean {
    if (this.as.isLoggedIn()) {
      return true;
    }
    else {
      this.router.navigate(['/adminlogin'])
      return false;
    }
  }

}
