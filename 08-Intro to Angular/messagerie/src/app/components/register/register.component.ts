import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  imports: [FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  username = "";
  password ="";
  message : string = "";

  constructor (private service : UserService,
               private router : Router) {}

  register(){ 
    this.service.addUser({"username" : this.username, "password" : this.password}).subscribe({
      next : _ => {
        this.router.navigate(['/login'])
      },
      error : err => {
        this.message = err.error;
      }      
    });
  }

}
