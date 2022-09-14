import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from '@angular/router';
import {Observable} from 'rxjs';
import {AuthService} from './auth.service';
import {Inject, Injectable} from '@angular/core';
import {ToastrService} from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate{
  constructor(private athService: AuthService, private router: Router,private toast: ToastrService) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (this.athService.isAuthenticated()) {
      return true;
    } else {
      this.router.navigate(['403']);
      this.toast.error("vui lòng đăng nhập")
      return false;
    }

  }


  // canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
  //   return this.athService.isAuthenticated().then((authenticated: boolean) => {
  //     if (authenticated){
  //       console.log('trung');
  //       return true;
  //     }
  //     this.router.navigateByUrl("/cart")
  //     return false;
  //   });
  // }

}
