import { Component, OnInit } from '@angular/core';
import {HomePageService} from '../service/home-page.service';
import {Router} from '@angular/router';


@Component({
  selector: 'app-home-shop',
  templateUrl: './home-shop.component.html',
  styleUrls: ['./home-shop.component.css']
})
export class HomeShopComponent implements OnInit {
ListProduct : any;
  constructor( private homeService : HomePageService,private router : Router) {}

  ngOnInit(): void {
    this.getAllProduct();

  }

  getAllProduct(){
    this.homeService.getAllProduct().subscribe(value => {
      this.ListProduct = value;
    })
  }

  buyProduct() {

  }

  getIdProduct(id: any) {
    // console.log(id);
    this.router.navigateByUrl('detailProduct/'+id);
  }

  checkboxSearch(id : number) {
    console.log(id);
    this.homeService.searchProduct(id).subscribe(value => {
     this.ListProduct = value;
    })
  }
}
