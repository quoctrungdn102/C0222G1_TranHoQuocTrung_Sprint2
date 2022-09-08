import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {LoginService} from './login.service';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {AuthService} from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  formLogin = new FormGroup({
    userName: new FormControl(''),
    passWord: new FormControl('')
  });

  constructor(private loginService: LoginService, private router: Router,
 private toast : ToastrService,private authService : AuthService) {
  }

  ngOnInit(): void {
  }

  loginSubmit() {
    this.loginService.login(this.formLogin.value).subscribe((value: any) => {
      console.log(value.name);
      localStorage.setItem(value.name, value.token);
      localStorage.setItem('status', 'login');
      const role = localStorage.getItem(value.name);
      // for (let i = 0; i < role.length; i++) {
      //     if (value.roles[i].authority =='ROLE_ADMIN') {
      //       this.router.navigateByUrl('/home-shop');
      //     }
      //     alert("bạn không đẳng cấp để vào trang wed này")
      //   }
      this.router.navigateByUrl('/home-shop')

      //reload component
      window.location.href = 'http://localhost:4200/home-shop'

        this.router.navigateByUrl('/home-shop');

      }, error => {
      this.toast.error("mật khẩu sai rồi mi ")

      });
    }

}
