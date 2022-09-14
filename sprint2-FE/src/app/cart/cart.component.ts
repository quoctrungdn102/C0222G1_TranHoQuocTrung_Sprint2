import {Component, OnInit} from '@angular/core';
import {Product} from '../model/product';
import {Cart} from '../model/cart';
import {DetailProductService} from '../service/detail-product.service';
import {CartService} from '../service/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  listProduct: Product[] = [];
  myMap2 = new Map<number, number>();
  listCart: Cart[] = [];
  myMap = new Map<Product, number>();
  total : number

  constructor(private cartService: CartService) {
  }

  cart: Cart = {
    id: null,

    quality: null,
    product: null,
    userCustomer: '',
    statusDelete: null,
  };

  ngOnInit(): void {
    this.getListCart();



  }


  getListCart() {
    this.cartService.listCart().subscribe(value => {
      this.total = 0;
      this.listCart = value;
      this.listCart.forEach(value1 => {
        this.total += Number(value1.product.price) *Number(value1.quality);
      })
      console.log(this.total);
    });


  }


  plus(product: Product) {
    console.log(product);

    this. cart= {
      id: null,
      quality: 1,
      product: product,
      userCustomer: localStorage.getItem('getCustomer')
    };
  this.cartService.createCart(this.cart).subscribe(value => {
    console.log('cộng thành công');
    this.ngOnInit()
  })
  }

  subtraction(product: Product) {

    this. cart= {
      id: null,
      quality: 1,
      product: product,
      userCustomer: localStorage.getItem('getCustomer')
    };
    this.cartService.subtractionCart(this.cart).subscribe(value => {
      console.log('trừ thành công');
      this.ngOnInit()
    })

  }

  deleteCart(tem: Cart) {
    this.cartService.deleteCart(tem).subscribe(
      value => {
        alert("xóa thành công")
        this.ngOnInit();
      }
    )
  }
}
