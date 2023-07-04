import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { firstValueFrom } from 'rxjs';
import { bookDetails, bookReview } from './model';

const uploadAPIURL: string = 'api/';
const API_URL = 'http://localhost:8080'


@Injectable()
export class BookReviewService {

    http = inject(HttpClient);

    sendLetter(letter: String) {
        console.info('>>selected letter:', letter);
        return this.http.post<any>(uploadAPIURL + 'letter', letter);
    }

    getBookList(filter = "", limit = 10, skip = 0): Promise<bookDetails[]> {
        let params = new HttpParams()
            .set("filter", filter)
            .set("limit", limit)
            .set("skip", skip)
        return firstValueFrom(
            this.http.get < bookDetails[]>(`${API_URL}/api/booklist`, { params })
        )
    }

    getBookTitle(filter = "", limit = 10, skip = 0): Promise <bookReview[]> {
        let params = new HttpParams()
            .set("filter", filter)
            .set("limit", limit)
            .set("skip", skip)
        return firstValueFrom(
            this.http.get<bookReview[]>(`${API_URL}/api/bookdetails`, { params })
                )
        }


    }

