import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartDetailsComponent } from './components/cart-details/cart-details.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { RegisterComponent } from './components/register/register.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { AuthGuard } from './services/auth.guard';

const routes: Routes = [  
{ path: 'home', component: HomePageComponent},
{ path: 'cart-details', component: CartDetailsComponent, canActivate : [AuthGuard] },
{ path: 'sign-in', component: SignInComponent },
{ path: 'register', component: RegisterComponent },
{ path: '', redirectTo: '/home', pathMatch: 'full' },
{ path: '**', redirectTo: '/home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
