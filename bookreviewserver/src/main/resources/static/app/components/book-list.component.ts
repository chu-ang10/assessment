import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookReviewService } from '../service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
input: number=0

ngOnInit(): void {
    
}


}
// @Input()
// limit = 10

// @Input()
// skip = 0

// @Input()
// filter = ""

// constructor(
//   private activatedRoute: ActivatedRoute,
//   private Svc: BookReviewService,
//   private router:Router,
//   private http: HttpClient
// ) {}

// selectBook(){
//   @Input()
//   limit = 5

//   @Input()
//   skip = 0

//   @Input()
//   filter = ""

//   constructor(private gameSvc: GamesService) { }

//   games$!: Promise<GameSummary[]>

//   ngOnInit(): void {
//     this.games$ = this.gameSvc.getGames(this.filter, this.limit, this.skip)
//   }

//   fetchChanges(limit: string) {
//     this.limit = +limit
//     this.games$ = this.gameSvc.getGames(this.filter, this.limit, this.skip)
//   }

//   filtering(text: string) {
//     this.filter = text
//     this.games$ = this.gameSvc.getGames(this.filter, this.limit, this.skip)
//   }

//   page(d: number) {
//     if (d >= 0)
//       this.skip += this.limit
//     else
//       this.skip = Math.max(0, this.skip - this.limit)

//     this.games$ = this.gameSvc.getGames(this.filter, this.limit, this.skip)
//   }


