import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ArticleService} from '../article.service';
import {MatDialogRef} from '@angular/material';

@Component({
  selector: 'app-article-form',
  templateUrl: './article-form.component.html',
  styleUrls: ['./article-form.component.css']
})
export class ArticleFormComponent implements OnInit {

  articleForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private articleService: ArticleService,
              private dialogRef: MatDialogRef<ArticleFormComponent>) {
  }

  ngOnInit() {
    this.articleForm = this.buildArticleForm();
  }

  buildArticleForm() {
    return this.formBuilder.group({
      title: ['', Validators.required],
      content: ['', Validators.required],
      imgUrl: ['', Validators.pattern('^https:\\/\\/\\S+|^http:\\/\\/\\S+')]
    });
  }

  createArticle() {
    this.articleService.addArticle(this.articleForm.value).subscribe(() => this.dialogRef.close());
  }
}
