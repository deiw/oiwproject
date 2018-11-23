import {Component, OnInit, ViewChild} from '@angular/core';
import {RegistrationDialogComponent} from '../user/registration-form/registration-dialog/registration-dialog.component';
import {ArticleDialogComponent} from '../article/article-form/article-dialog/article-dialog.component';
import {ContentComponent} from '../article/content/content.component';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  @ViewChild(RegistrationDialogComponent) registrationDialog: RegistrationDialogComponent;
  @ViewChild(ArticleDialogComponent) articleDialog: ArticleDialogComponent;

  constructor(private content: ContentComponent) {
  }

  ngOnInit() {
  }

  openUserRegistrationDialog(): void {
    this.registrationDialog.openDialog();
  }

  openArticleCreatorDialog(): void {
    this.articleDialog.openDialog();
  }
}
