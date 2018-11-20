import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ContentComponent} from './content/content.component';
import {MatButtonModule, MatCardModule, MatDialogModule, MatFormFieldModule, MatInputModule, MatPaginatorModule} from '@angular/material';
import {ArticleFormComponent} from './article-form/article-form.component';
import {ArticleDialogComponent} from './article-form/article-dialog/article-dialog.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    ContentComponent,
    ArticleFormComponent,
    ArticleDialogComponent
  ],
  imports: [
    CommonModule,
    MatCardModule,
    MatPaginatorModule,
    MatDialogModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatButtonModule,
    MatInputModule
  ],
  entryComponents: [
    ArticleFormComponent
  ]
})
export class ArticleModule {
}
