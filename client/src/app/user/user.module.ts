import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RegistrationFormComponent} from './registration-form/registration-form.component';
import {RegistrationDialogComponent} from './registration-form/registration-dialog/registration-dialog.component';
import {MatButtonModule, MatDialogModule, MatFormFieldModule, MatInputModule} from '@angular/material';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {LoginFormComponent} from './login-form/login-form.component';
import {LoginDialogComponent} from './login-form/login-dialog/login-dialog.component';

@NgModule({
  declarations: [RegistrationFormComponent, RegistrationDialogComponent, LoginFormComponent, LoginDialogComponent],
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
    RegistrationDialogComponent,
    LoginFormComponent,
    LoginDialogComponent,
  ],
  entryComponents: [
    RegistrationFormComponent,
    LoginFormComponent
  ]
})
export class UserModule {
}
