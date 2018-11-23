import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ArticleModule} from './article/article.module';
import {HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {UserModule} from './user/user.module';
import {HeaderComponent} from './header/header.component';
import {ContentComponent} from './article/content/content.component';

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
    UserModule
  ],
  providers: [ContentComponent],
  bootstrap: [AppComponent]
})
export class AppModule {
}
