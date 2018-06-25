import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthService } from '../auth/auth.service';
import { Config } from '../../config';
import { Observable } from 'rxjs/Observable';
import { Transaction } from './model/transaction';
import { Subject } from 'rxjs/Subject';

@Injectable()
export class TransactionService {

  private url: string;
  constructor(private httpClient: HttpClient,
    private authService: AuthService) {
    let config = new Config()
    this.url = config.getRest()
  }

  public getTransactionsById(id: Number): Observable<Transaction[]> {
    let subject = new Subject<Transaction[]>()
    this.httpClient.get(this.url + "/transactions/" + id, { headers: this.authService.getHeader() }).subscribe(response => {
      subject.next(response as Transaction[])
    }, error => {
      subject.error(error)
    });
    return subject.asObservable();
  }
}
