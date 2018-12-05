import {Component, OnInit, ViewChild} from '@angular/core';
import {ArticleService} from '../article.service';
import {Pageable} from '../../pageable';
import {Article} from '../article';
import {MatPaginator} from '@angular/material';
import {ArticleDialogComponent} from '../article-form/article-dialog/article-dialog.component';
import {AuthenticationService} from '../../auth/authentication.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(ArticleDialogComponent) articleDialog: ArticleDialogComponent;

  pageable: Pageable = {page: 0, size: 10, sort: 'creationTime', direction: 'DESC'};
  articles: Article[];
  totalElements: number;
  pageSizeOptions = [10, 25, 50];

  constructor(private articleService: ArticleService,
              private authService: AuthenticationService,
              private router: Router) {
  }

  ngOnInit() {
    this.reload();
    this.paginator.page.subscribe(() => {
      this.pageable.page = this.paginator.pageIndex;
      this.pageable.size = this.paginator.pageSize;
      this.reload();
    });
  }

  reload() {
    this.getArticles();
  }

  getArticles() {
    this.articleService.getArticles(this.pageable)
      .subscribe(data => {
        this.articles = data.content;
        this.totalElements = data.totalElements;
      });
  }

  openArticleCreatorDialog(): void {
    this.articleDialog.openDialog();
    this.articleDialog.dialogRef.afterClosed().subscribe(() => this.reload());
  }

  isLogged(): boolean {
    return this.authService.isAuthenticated();
  }

  navigateToArticle(title: string) {
    this.router.navigateByUrl('/' + title);
  }
}
