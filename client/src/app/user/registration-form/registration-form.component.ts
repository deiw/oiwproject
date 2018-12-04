import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {UserService} from '../user.service';
import {MatDialogRef, MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent implements OnInit {

  userForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private userService: UserService,
              private dialogRef: MatDialogRef<RegistrationFormComponent>,
              private snackBar: MatSnackBar) {
  }

  ngOnInit() {
    this.userForm = this.buildUserForm();
  }

  buildUserForm() {
    return this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  registerUser() {
    this.userService.registerUser(this.userForm.value).subscribe(() => {
      this.dialogRef.close();
      this.snackBar.open('Successful registration! You can sign in now.', '', {duration: 1000});
    });
  }
}
