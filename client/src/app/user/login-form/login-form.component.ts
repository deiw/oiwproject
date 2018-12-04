import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from '../../auth/authentication.service';
import {Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MatDialogRef} from '@angular/material';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  loginForm: FormGroup;
  error = '';

  constructor(private authenticationService: AuthenticationService,
              private router: Router,
              private formBuilder: FormBuilder,
              private dialogRef: MatDialogRef<LoginFormComponent>) {
  }

  ngOnInit() {
    this.authenticationService.logout();
    this.loginForm = this.buildUserForm();
  }

  buildUserForm() {
    return this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  login(): void {
    this.authenticationService.login(
      this.loginForm.value,
      () => {
        this.dialogRef.close();
      },
      () => this.error = 'Oops! Bad username or password.');
  }
}
