import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ArticleService} from '../article.service';
import {MatDialogRef} from '@angular/material';
import {AuthenticationService} from '../../auth/authentication.service';

@Component({
  selector: 'app-article-form',
  templateUrl: './article-form.component.html',
  styleUrls: ['./article-form.component.css']
})
export class ArticleFormComponent implements OnInit {

  articleForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private articleService: ArticleService,
              private dialogRef: MatDialogRef<ArticleFormComponent>,
              private authService: AuthenticationService) {
  }

  ngOnInit() {
    this.articleForm = this.buildArticleForm();
    this.articleForm.get('creator').setValue(this.authService.getCurrentUserName());
  }

  buildArticleForm() {
    return this.formBuilder.group({
      title: ['', Validators.required],
      content: ['', Validators.required],
      imgUrl: [null, Validators.pattern('^https:\\/\\/\\S+|^http:\\/\\/\\S+')],
      creator: ['', Validators.required]
    });
  }

  createArticle() {
    this.articleService.addArticle(this.articleForm.value).subscribe(() => this.dialogRef.close());
  }
}
