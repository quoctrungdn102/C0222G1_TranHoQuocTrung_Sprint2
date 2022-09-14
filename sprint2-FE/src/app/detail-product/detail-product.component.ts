import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {DetailProductService} from '../service/detail-product.service';
import {Product} from '../model/product';
import {Category} from '../model/category';
import {Promotion} from '../model/promotion';
import {Cart} from '../model/cart';
import {ToastrService} from 'ngx-toastr';
import {applySourceSpanToExpressionIfNeeded} from '@angular/compiler/src/output/output_ast';
import {CartService} from '../service/cart.service';

@Component({
  selector: 'app-detail-product',
  templateUrl: './detail-product.component.html',
  styleUrls: ['./detail-product.component.css']
})
export class DetailProductComponent implements OnInit {
  myMap = new Map<Product, number>();
  myMap2 = new Map<number, number>();
  listCart: Cart[] = [];
  listCart1: Cart[] = [];
  listProduct: Product[] = [];
  product: Product = {
    id: null,

    isDelete: null,
    name: '',
    cpu: '',
    ram: '',
    screenResolution: '',
    releaseTime: '',
    graphicCard: '',
    price: null,
    description: '',
    image: '',

    category: null,

    promotion: null,

  };
  cart: Cart = {
    id: null,

    quality: null,
    product: null,
    userCustomer: '',
    statusDelete: null,
  };

  constructor(private activatedRoute: ActivatedRoute, private detailService: DetailProductService, private toast: ToastrService,private router:Router,
  private cartService : CartService) {
  }

  ngOnInit(): void {
    this.detailService.getProduct(this.activatedRoute.snapshot.params.id).subscribe(
      value => {
        this.product = value;

      }
    );

  }

  getProduct() {
    this.detailService.getProduct(this.activatedRoute.snapshot.params.id).subscribe(
      value => {
        this.product = value;

      }
    );
  }


  addCart(product: Product) {
    this.cart = {
      id : null,
      userCustomer : localStorage.getItem('getCustomer'),
      quality : 1,
      product : product,
      statusDelete : 0

    }
    console.log(this.cart);
    this.cartService.createCart(this.cart).subscribe(value => {
      console.log(value);
      console.log("thành công");
      this.toast.success("thêm vào giỏ hàng thành công")
    })






  //   if (localStorage.getItem(localStorage.getItem('getCustomer'))!= null){
  //     this.listProduct = JSON.parse(localStorage.getItem(localStorage.getItem('getCustomer')));
  //     localStorage.removeItem(localStorage.getItem('getCustomer'));
  //   }
  //
  //
  //   this.toast.success('thêm thành công');
  //
  //
  //   this.listProduct.push(product)
  //   localStorage.setItem(localStorage.getItem('getCustomer'), JSON.stringify(this.listProduct));
  //
  //
  //   console.log(localStorage.getItem(localStorage.getItem('getCustomer'))
  //   )
  //
  //   ;
  // }
  //
  // public checkProduct(product: Product): boolean {
  //   for (let i = 0; i < this.listCart.length; i++) {
  //     if (this.listProduct[i] != product) {
  //       return true;
  //     } else {
  //       return false;
  //     }
  //   }
  //   return true;
  }

  checkCart() {
    this.router.navigateByUrl('/cart')
    // this.listProduct = JSON.parse(localStorage.getItem(localStorage.getItem('getCustomer')));
    // for (let i = 0; i <this.listProduct.length ; i++) {
    //   if (this.myMap2.has(this.listProduct[i].id)){
    //     this.myMap2.set(this.listProduct[i].id,this.myMap2.get(this.listProduct[i].id)+1)
    //   }else {
    //     this.myMap2.set(this.listProduct[i].id,1)
    //   }
    // }
    // console.log(this.myMap2);


  }


}
