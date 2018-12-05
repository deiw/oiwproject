import {Component, OnInit} from '@angular/core';
import {Article} from '../article';
import {ActivatedRoute} from '@angular/router';
import {ArticleService} from '../article.service';

@Component({
  selector: 'app-single-article',
  templateUrl: './single-article.component.html',
  styleUrls: ['./single-article.component.css']
})
export class SingleArticleComponent implements OnInit {

  article: Article;

  constructor(private activatedRoute: ActivatedRoute,
              private articleService: ArticleService) {
  }

  ngOnInit() {
    this.activatedRoute.params.subscribe(params => {
      const title = params['title'];
      this.articleService.getArticleByTitle(title).subscribe(data => this.article = data);
    });
  }

}
