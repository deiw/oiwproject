import {Component, HostListener, OnInit, ViewChild} from '@angular/core';
import {ArticleService} from '../article.service';
import {Pageable} from '../../pageable';
import {Article} from '../article';
import {ArticleDialogComponent} from '../article-form/article-dialog/article-dialog.component';
import {AuthenticationService} from '../../auth/authentication.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {

  @ViewChild(ArticleDialogComponent) articleDialog: ArticleDialogComponent;

  pageable: Pageable = {page: 0, size: 10, sort: 'creationTime', direction: 'DESC'};
  articles: Article[] = [];
  totalElements: number;

  constructor(private articleService: ArticleService,
              private authService: AuthenticationService,
              private router: Router) {
  }

  ngOnInit() {
    this.reload();
    this.pageable.page = 0;
  }

  reload() {
    this.getArticles();
  }

  getArticles() {
    this.articleService.getArticles(this.pageable)
      .subscribe(data => {
        this.articles = this.articles.concat(data.content);
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

  @HostListener('window:scroll', ['$event'])
  onScroll() {
    if (window.innerHeight + window.scrollY === document.body.scrollHeight
      && this.totalElements > this.articles.length) {
      this.pageable.page++;
      this.reload();
    }
  }
}
