import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { firstValueFrom } from 'rxjs';
import { Router } from '@angular/router';
import { BookReviewService } from 'src/app/service';



@Component({
  selector: 'app-index-view',
  templateUrl: './index-view.component.html',
  styleUrls: ['./index-view.component.css']
})
export class IndexViewComponent {


  alphabet: string[] = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789'.split('');

  router = inject(Router);
  reviewSvc = inject(BookReviewService);

  onLetterClick(letter: string) {
    firstValueFrom(this.reviewSvc.sendLetter(letter))
      .then((resp) => {
        this.router.navigate(['/orders', this.alphabet]);
      })
      .catch((err) => {
        console.log(err);
        alert('Request Failed:' + err);
      });
  }



}

