import { Component } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthRequest } from 'src/app/common/auth-request';
import { AuthResponse } from 'src/app/common/auth-response';
import { AuthService } from 'src/app/services/auth.service';
import { CustomValidators } from 'src/app/validators/custom-validators';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent {

  loginFormGroup?: FormGroup;

  constructor(private formBuilder: FormBuilder,
    private authService: AuthService,
    private router: Router) { }

    ngOnInit(): void {

      this.loginFormGroup = this.formBuilder.group({
        password: new FormControl('', [Validators.required, Validators.minLength(6),
        CustomValidators.notOnlyWhiteSpace]),
        email: new FormControl('',
          [Validators.required,
          Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')])
      })
  
    }
  
    onLogin() {
  
      if (this.loginFormGroup?.invalid) {
        this.loginFormGroup.markAllAsTouched();
        return;
      }
  
      let authRequest = new AuthRequest();
  
      authRequest.email = this.loginFormGroup?.controls["email"].value;
      authRequest.password = this.loginFormGroup?.controls["password"].value;
  
      this.authService.login(authRequest).subscribe(
        () => {
          this.router.navigate(['/home']);
        }
      );
    }

}
