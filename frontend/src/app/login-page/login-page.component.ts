import { Component, OnInit, Inject, Injectable } from '@angular/core';
import { Headers, Response, RequestOptions } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { User } from '../auth/user';
import { AuthService } from '../modules/auth/auth.service';


@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent {
  private user: any = {};
  constructor(
    private http: HttpClient,
    private router: Router,
    private authService: AuthService
  ) { }

  onSubmit(user: User) {
    
    this.http.get('http://rest.metraf.eu/permissions', { headers: { "Authorization": "Basic " + btoa(this.user.email + ":" + this.user.password), "Content-Type": "application/json" } }).subscribe(response => {
      //this.http.get('http://localhost:8080/permissions', { headers: { "Authorization": "Basic " + btoa(this.user.email + ":" + this.user.password), "Content-Type": "application/json" } }).subscribe(response => {
      this.authService.saveUser(this.user);
      this.router.navigate(['/home']);
    }, err => {
      console.log("User authentication failed!");
    });
  }
}
