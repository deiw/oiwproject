import {Component} from '@angular/core';
import {MatDialog, MatDialogRef} from '@angular/material';
import {ArticleFormComponent} from '../article-form.component';

@Component({
  selector: 'app-article-dialog',
  template: ''
})
export class ArticleDialogComponent {
  dialogRef: MatDialogRef<ArticleFormComponent>;

  constructor(private dialog: MatDialog) {
  }

  openDialog(): void {
    this.dialogRef = this.dialog.open(ArticleFormComponent,
      {
        width: '40%',
        height: 'fit-content'
      });
  }
}
