import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RegistrationFormComponent} from './registration-form/registration-form.component';
import {RegistrationDialogComponent} from './registration-form/registration-dialog/registration-dialog.component';
import {MatButtonModule, MatDialogModule, MatFormFieldModule, MatInputModule} from '@angular/material';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [RegistrationFormComponent, RegistrationDialogComponent],
  imports: [
    CommonModule,
    MatDialogModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatButtonModule,
    MatInputModule
  ],
  exports: [
    RegistrationFormComponent,
    RegistrationDialogComponent
  ],
  entryComponents: [
    RegistrationFormComponent
  ]
})
export class UserModule {
}
