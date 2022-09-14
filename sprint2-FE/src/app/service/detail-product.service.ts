import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class DetailProductService {

  constructor(private httpClient: HttpClient) { }
  getProduct(id : number):Observable<Product>{
    return this.httpClient.get<Product>("http://localhost:8080/findProductById?id="+ id)
  }
}
