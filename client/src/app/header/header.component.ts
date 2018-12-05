import {Component, OnInit, ViewChild} from '@angular/core';
import {RegistrationDialogComponent} from '../user/registration-form/registration-dialog/registration-dialog.component';
import {LoginDialogComponent} from '../user/login-form/login-dialog/login-dialog.component';
import {AuthenticationService} from '../auth/authentication.service';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  @ViewChild(RegistrationDialogComponent) registrationDialog: RegistrationDialogComponent;
  @ViewChild(LoginDialogComponent) loginDialog: LoginDialogComponent;

  constructor(private auth: AuthenticationService,
              private snackBar: MatSnackBar) {
  }

  ngOnInit() {
  }

  openUserRegistrationDialog(): void {
    this.registrationDialog.openDialog();
  }

  openLoginDialog(): void {
    this.loginDialog.openDialog();
  }

  isLogged(): boolean {
    return this.auth.isAuthenticated();
  }

  getUsername(): string {
    return this.auth.getCurrentUserName();
  }

  logout(): void {
    this.auth.logout();
    this.snackBar.open('Logged out', '', {duration: 1000});
  }
}
