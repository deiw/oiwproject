import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ContentComponent} from './content/content.component';
import {MatCardModule} from '@angular/material';

@NgModule({
  declarations: [
    ContentComponent
  ],
  imports: [
    CommonModule,
    MatCardModule
  ]
})
export class ArticleModule { }
