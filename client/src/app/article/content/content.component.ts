import {Component, OnInit, ViewChild} from '@angular/core';
import {ArticleService} from '../article.service';
import {Pageable} from '../../pageable';
import {Article} from '../article';
import {MatPaginator} from '@angular/material';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {

  @ViewChild(MatPaginator) paginator: MatPaginator;
  pageable: Pageable = {page: 0, size: 10, sort: 'creationTime', direction: 'DESC'};
  articles: Article[];
  totalElements: number;
  pageSizeOptions = [10, 25, 50];

  constructor(private articleService: ArticleService) {
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
}
