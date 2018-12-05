import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ArticleModule} from './article/article.module';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {UserModule} from './user/user.module';
import {HeaderComponent} from './header/header.component';
import {ContentComponent} from './article/content/content.component';
import {AuthenticationService} from './auth/authentication.service';
import {TokenInterceptor} from './auth/token.interceptor';
import {MatSnackBarModule} from '@angular/material';
import {AuthGuard} from './auth/auth.guard';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    ArticleModule,
    HttpClientModule,
    UserModule,
    MatSnackBarModule
  ],
  providers: [
    ContentComponent,
    AuthenticationService, {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    },
  AuthGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
