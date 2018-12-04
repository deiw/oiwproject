import { Component} from '@angular/core';
import {LoginFormComponent} from '../login-form.component';
import {MatDialog, MatDialogRef} from '@angular/material';

@Component({
  selector: 'app-login-dialog',
  template: '',
})
export class LoginDialogComponent {

  dialogRef: MatDialogRef<LoginFormComponent>;

  constructor(private dialog: MatDialog) {
  }

  openDialog(): void {
    this.dialogRef = this.dialog.open(LoginFormComponent,
      {
        width: '40%',
        height: 'fit-content'
      });
  }
}


