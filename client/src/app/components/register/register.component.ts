import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthResponse } from 'src/app/common/auth-response';
import { RegisterRequest } from 'src/app/common/register-request';
import { AuthService } from 'src/app/services/auth.service';
import { CustomValidators } from 'src/app/validators/custom-validators';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  registerFormGroup?: FormGroup;

  constructor(private formBuilder: FormBuilder,
    private authService: AuthService,
    private router: Router) { }

    ngOnInit(): void {

      this.registerFormGroup = this.formBuilder.group({
        firstName: new FormControl('', [Validators.required, Validators.minLength(2),
        CustomValidators.notOnlyWhiteSpace]),
        lastName: new FormControl('', [Validators.required, Validators.minLength(2),
        CustomValidators.notOnlyWhiteSpace]),
        phone: new FormControl('', [Validators.required, Validators.minLength(10),
          CustomValidators.notOnlyWhiteSpace]),
        address: new FormControl('', [Validators.required, Validators.minLength(1),
            CustomValidators.notOnlyWhiteSpace]),
        password: new FormControl('', [Validators.required, Validators.minLength(6),
        CustomValidators.notOnlyWhiteSpace]),
        email: new FormControl('',
          [Validators.required,
          Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')])
      })
  
    }

    onRegister(){
      if (this.registerFormGroup?.invalid) {
        this.registerFormGroup.markAllAsTouched();
        return;
      }
  
      let registerRequest = new RegisterRequest();
  
      registerRequest.firstName = this.registerFormGroup?.controls["firstName"].value;
      registerRequest.lastName = this.registerFormGroup?.controls["lastName"].value;
      registerRequest.phone = this.registerFormGroup?.controls["phone"].value;
      registerRequest.address = this.registerFormGroup?.controls["address"].value;
      registerRequest.email = this.registerFormGroup?.controls["email"].value;
      registerRequest.password = this.registerFormGroup?.controls["password"].value;
  
      this.authService.register(registerRequest).subscribe(
        () => {
          this.router.navigate(['/home']);
        }
      );
    }

}
