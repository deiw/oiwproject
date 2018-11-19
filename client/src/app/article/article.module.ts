import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ContentComponent} from './content/content.component';
import {MatCardModule, MatPaginatorModule} from '@angular/material';

@NgModule({
  declarations: [
    ContentComponent
  ],
  imports: [
    CommonModule,
    MatCardModule,
    MatPaginatorModule
  ]
})
export class ArticleModule { }
