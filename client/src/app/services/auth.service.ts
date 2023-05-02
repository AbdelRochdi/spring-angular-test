import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, tap } from 'rxjs';
import { AuthRequest } from '../common/auth-request';
import { AuthResponse } from '../common/auth-response';
import { RegisterRequest } from '../common/register-request';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private _isLoggedIn$ = new BehaviorSubject<boolean>(false);
  isLoggedIn$ = this._isLoggedIn$.asObservable();

  private loginUrl = "http://localhost:8080/api/v1/accounts/authenticate";

  private registerUrl = "http://localhost:8080/api/v1/accounts/register";

  constructor(private http: HttpClient) {
    const token = localStorage.getItem('id_token');
    this._isLoggedIn$.next(!!token);
  }

  register(registerRequest : RegisterRequest){
    return this.http.post<AuthResponse>(this.registerUrl, registerRequest);
  }

  login(authRequest: AuthRequest) {
    return this.http.post<AuthResponse>(this.loginUrl, authRequest)
    .pipe(
      tap(response => {
        localStorage.setItem('id_token', response.token!);
        this._isLoggedIn$.next(true);
      })
    );
  }

  logout() {
    localStorage.removeItem("id_token");
    this._isLoggedIn$.next(false);
  }
}
