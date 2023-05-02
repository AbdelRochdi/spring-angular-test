import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { CartDetailsComponent } from './components/cart-details/cart-details.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { HttpClientModule } from '@angular/common/http';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { RegisterComponent } from './components/register/register.component';
import { CreateArticleComponent } from './components/create-article/create-article.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomePageComponent,
    CartDetailsComponent,
    ProductListComponent,
    SignInComponent,
    RegisterComponent,
    CreateArticleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
