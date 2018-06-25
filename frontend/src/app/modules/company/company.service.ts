import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthService } from '../auth/auth.service';
import { Company } from './model/company';
import { Config } from '../../config';
import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs/Subject';
import { error } from 'protractor';

@Injectable()
export class CompanyService {

  private url: string;
  constructor(private httpClient: HttpClient,
    private authService: AuthService) {
    let config = new Config()
    this.url = config.getRest()
  }

  public getCompanies(): Observable<Company[]> {
    let subject = new Subject<Company[]>()
    this.httpClient.get(this.url + "/company", { headers: this.authService.getHeader() }).subscribe(response => {
      subject.next(response as Company[])
    }, error => {
      subject.error(error)
    });
    return subject.asObservable()
  }

  public getCompanyById(id: number): Observable<Company> {
    let subject = new Subject<Company>()
    this.httpClient.get(this.url + "/company/" + id, {observe: 'response', headers: this.authService.getHeader()}).subscribe(response => {
      subject.next(response.body as Company);
    }, error => {
      subject.error(error)
    })
    return subject.asObservable();
  }
}
