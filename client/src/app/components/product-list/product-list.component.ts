import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Article } from 'src/app/common/article';
import { ArticleService } from 'src/app/services/article.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  articles: Article[] = [];

  constructor(
    private articleService: ArticleService,
  ) { }

  ngOnInit(): void {
    this.listArticles();
  }

  listArticles() {
    this.articleService.getArticles().subscribe((data) => {
      data.forEach(element => element.image = this.readImages(element.image))
      this.articles = data
    });
  }

  readImages(base64Image : string | undefined ): string {

    // create a new image object
    const img = new Image();

    // set the source of the image object
    img.src = `data:image/jpeg;base64,${base64Image}`;

    return img.src
  }

}
