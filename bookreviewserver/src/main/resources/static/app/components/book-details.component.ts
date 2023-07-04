import { Component } from '@angular/core';
import { bookDetails } from '../model';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent {
book!: bookDetails[];
}
