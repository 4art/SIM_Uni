import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service'


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  constructor(
    private router: Router,
    private cookieService: CookieService
  ) { }

  logout(){ 
    let cookies = this.cookieService.getAll();
    Object.keys(cookies).forEach(key => {
      this.cookieService.delete(key);
    });
    // console.log("Logout");
    this.router.navigate(['/login']);
  }
}
