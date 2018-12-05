import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ContentComponent} from './article/content/content.component';
import {SingleArticleComponent} from './article/single-article/single-article.component';
import {AuthGuard} from './auth/auth.guard';

const routes: Routes = [
  {path: '', component: ContentComponent},
  {path: ':title', component: SingleArticleComponent, canActivate: [AuthGuard]},
  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
