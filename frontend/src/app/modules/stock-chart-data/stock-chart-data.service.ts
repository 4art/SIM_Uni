import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthService } from '../auth/auth.service';
import { Config } from '../../config';
import { Subject } from 'rxjs/Subject';
import { Observable } from 'rxjs/Observable';
import { IfObservable } from 'rxjs/observable/IfObservable';
import { ChartData } from './model/chart-data';

@Injectable()
export class StockChartDataService {

  private url: string;
  constructor(private httpClient: HttpClient,
    private authService: AuthService) {
    let config = new Config()
    this.url = config.getRest()
  }

  public getChartDataById(companyId: Number): Observable<ChartData>{
    let subject = new Subject<ChartData>()
    this.httpClient.get(`${this.url}/stock/chartData/${companyId}`, { headers: this.authService.getHeader() }).subscribe(response => {
      subject.next(response as ChartData)
    }, error => {
      subject.error(error)
    });
    return subject.asObservable();
  }

}
