import { Injectable } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { User } from '../../auth/user';

@Injectable()
export class AuthService {

  private user: User;

  constructor(private cookieService: CookieService) {
  }

  public getUser(): User {
    if (this.cookieService.check("user")) {
      try{
        return JSON.parse(this.cookieService.get("user")) as User;
      }catch(e){
        console.error(e);
      }
    }
      return { email: "", password: "" } as User;
  }

  public getHeader() {
    let user = this.getUser()
    return {
      "Authorization": "Basic " + btoa(user.email + ":" + user.password),
      "Content-Type": "application/json"
    };
  }

  public saveUser(user: User) {
    this.cookieService.delete("user");
    this.cookieService.set("user", JSON.stringify(user));
  }

  public deleteUser(){
    this.cookieService.delete("user");
  }
}
