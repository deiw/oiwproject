import {Injectable} from '@angular/core';
import {CanActivate, Router} from '@angular/router';
import {AuthenticationService} from './authentication.service';
import {MatSnackBar} from '@angular/material';

@Injectable()
export class AuthGuard implements CanActivate {

  constructor(private router: Router,
              private authenticationService: AuthenticationService,
              private snackBar: MatSnackBar) {
  }

  canActivate() {
    if (this.authenticationService.isAuthenticated()) {
      return true;
    }
    this.router.navigate(['/']);
    this.snackBar.open('Content for logged users!', '', {duration: 1000});
    return false;
  }
}
