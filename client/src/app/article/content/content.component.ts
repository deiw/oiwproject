import {Component, OnInit} from '@angular/core';
import {ArticleService} from '../article.service';
import {Pageable} from '../../pageable';
import {Article} from '../article';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {

  pageable: Pageable = {page: 0, size: 10, sort: 'creationTime', direction: 'DESC'};
  articles: Article[];
  totalElements: number;

  constructor(private articleService: ArticleService) {
  }

  ngOnInit() {
    this.reload();
  }

  reload() {
    this.getArticles();
  }

  public getArticles() {
    this.articleService.getArticles(this.pageable)
      .subscribe(data => {
        this.articles = data.content;
        this.totalElements = data.totalElements;
      });
  }

}
