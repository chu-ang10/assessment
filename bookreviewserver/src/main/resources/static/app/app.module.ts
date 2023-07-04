import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ReactiveFormsModule } from '@angular/forms';
import { Router, RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { IndexViewComponent } from './components/index-view/index-view.component';
import { BookListComponent } from './components/book-list.component';
import { BookDetailsComponent } from './components/book-details.component';
import { NYTreviewComponent } from './components/nytreview.component';

const appRoutes: Routes = [
  {path:'', component:IndexViewComponent},
  {path:'book/:alphanumeral',component:BookListComponent },
  {path:'bookDetails', component:BookDetailsComponent},
  {path:'book/:alphanumeral',component:NYTreviewComponent },
  {path:'**', redirectTo: '/', pathMatch: 'full'}
]

@NgModule({
  declarations: [
    AppComponent,
    IndexViewComponent,
    BookListComponent,
    BookDetailsComponent,
    NYTreviewComponent,
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes, { useHash: true }),
    HttpClientModule

  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule { }
