import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Login} from '../model/login';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) {
  }

  login(accout: Login): Observable<any> {
   return  this.http.post<Login>('http://localhost:8080/sign', accout);
  }


}
