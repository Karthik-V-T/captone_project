import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Injectable({
  providedIn: 'root'
})
export class UserAuthGuard implements CanActivate {
  constructor(private us: UserService,
    private router: Router) { }

  canActivate(): boolean {
    if (this.us.isLoggedIn()) {
      return true;
    }
    else {
      this.router.navigate(['/login'])
      return false;
    }
  }

}
