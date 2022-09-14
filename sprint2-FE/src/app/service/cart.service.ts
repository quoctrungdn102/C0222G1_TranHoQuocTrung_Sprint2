import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Cart} from '../model/cart';
import {Product} from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private httpClient : HttpClient) { }
  createCart(cart : Cart):Observable<any>{
   return  this.httpClient.post<any>("http://localhost:8080/addCart",cart)
  }
  listCart():Observable<any>{
    return  this.httpClient.get<any>("http://localhost:8080/ListCart")
  }
  subtractionCart(cart : Cart):Observable<any>{
    return  this.httpClient.post<any>("http://localhost:8080/subtractionCart",cart)
  }
  deleteCart(cart : Cart):Observable<any>{
    return  this.httpClient.post<any>("http://localhost:8080/deleteCart",cart)

  }


}
