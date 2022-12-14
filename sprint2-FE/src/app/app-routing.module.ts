import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {HomeShopComponent} from './home-shop/home-shop.component';
import {DetailProductComponent} from './detail-product/detail-product.component';
import {CartComponent} from './cart/cart.component';
import {AuthGuard} from './auth-guard';
import {Err403Component} from './err403/err403.component';


const routes: Routes = [
  {
    path: '', component: HomeShopComponent
  },
  {
    path: 'login', component: LoginComponent
  },
  {
    path: 'home-shop', component: HomeShopComponent
  },
  {
    path: 'detail', component: DetailProductComponent,
  },
  {
    path: '403', component: Err403Component,
  },
  {
    path: 'detailProduct/:id', component: DetailProductComponent,
  },
  {
    path: 'cart', component: CartComponent,canActivate : [AuthGuard]
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
