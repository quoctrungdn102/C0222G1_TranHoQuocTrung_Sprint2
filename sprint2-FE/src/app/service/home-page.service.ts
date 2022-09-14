import {Injectable} from '@angular/core';
import {Login} from '../model/login';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Product} from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class HomePageService {

  constructor(private httpClient: HttpClient) {
  }

  getAllProduct(): Observable<any> {
    return this.httpClient.get<Product>('http://localhost:8080/getProduct');
  }
  searchProduct(id : number): Observable<any> {
    return this.httpClient.get<Product>(' http://localhost:8080/searchProductCheckbox?id='+ id);
  }

}
