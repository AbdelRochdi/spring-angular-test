import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http'
import { Article } from '../common/article';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  private host = environment.host;

  private baseUrl = this.host + '/api/v1/articles';

  constructor(private httpClient: HttpClient) { }

  getArticles(): Observable<Article[]>{

    return this.httpClient.get<Article[]>(this.baseUrl).pipe(
      map(response => response)
    )

  }
}