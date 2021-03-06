import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Article} from './article';
import {environment} from '../../environments/environment';
import {Pageable} from '../pageable';
import {Page} from '../page';
import {ArticleData} from './article-data';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  constructor(private http: HttpClient) {
  }

  public getArticles(pageable: Pageable): Observable<Page<Article>> {
    const params = new HttpParams()
      .append('page', pageable.page.toString())
      .append('size', pageable.size.toString())
      .append('sort', pageable.sort + ',' + pageable.direction);

    return this.http.get<Page<Article>>(environment.articleUrl, {params: params});
  }

  public addArticle(article: ArticleData): Observable<Article> {
    return this.http.post<Article>(environment.articleUrl, article);
  }

  public getArticleByTitle(title: string): Observable<Article> {
    return this.http.get<Article>(environment.articleUrl + '/' + title);
  }
}
