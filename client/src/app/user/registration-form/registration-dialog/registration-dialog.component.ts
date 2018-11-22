import {Component, OnInit} from '@angular/core';
import {MatDialog, MatDialogRef} from '@angular/material';
import {RegistrationFormComponent} from '../registration-form.component';

@Component({
  selector: 'app-registration-dialog',
  template: ''
})
export class RegistrationDialogComponent {

  dialogRef: MatDialogRef<RegistrationFormComponent>;

  constructor(private dialog: MatDialog) {
  }

  openDialog(): void {
    this.dialogRef = this.dialog.open(RegistrationFormComponent,
      {
        width: '40%',
        height: '70%'
      });
  }
}


