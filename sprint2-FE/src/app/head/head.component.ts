import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-head',
  templateUrl: './head.component.html',
  styleUrls: ['./head.component.css']
})
export class HeadComponent implements OnInit {
 status = localStorage.getItem("status");
  constructor(private router : Router,private toast : ToastrService) {
  }

  ngOnInit(): void {
    console.log(this.status);
  }

  Cart() {
      if (this.status=="login"){
        this.router.navigateByUrl("/cart")
      }
      else {
        this.toast.show("vui lòng đăng nhập để xem giỏ hàng")

      }

    }

  statusLogin() {
    localStorage.removeItem("status");
    localStorage.removeItem("getCustomer");
    window.location.href = 'http://localhost:4200/home-shop'
  }
}
