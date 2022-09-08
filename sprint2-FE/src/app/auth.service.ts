import {Injectable} from '@angular/core';
import {rejects} from 'assert';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  isLogin = false;

  constructor() {
  }

  isAuthenticated() {
    // const promise = new Promise<boolean>((resovle,reject)=>
    //   {
    //   setTimeout(()=>resovle(this.isLogin),200)
    //   });
    if (localStorage.getItem('status') !== null) {
      return true;
    } else {
      return false;
    }
  }

  logout() {
    this.isLogin = false;
  }

  login() {
    this.isLogin = true;
  }

}
