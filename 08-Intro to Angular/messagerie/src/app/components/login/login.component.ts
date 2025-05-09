import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { User } from '../../interfaces/user';
import { UserService } from '../../services/user.service';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [FormsModule, RouterModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  
  username = "";
  password = "";
  message: string = "";

  constructor (private service : UserService,
               private router : Router) {}
  
  login() { 
    
    let toLog : User = {
      "username" : this.username,
      "password" : this.password
    }

    this.service.hasUser(toLog).subscribe({
      next : _ => {
        localStorage.setItem("connected_user", toLog.username); 
        this.username = "";
        this.password = ""; 
        this.router.navigate(['/messageboard']); 
      },
      error : err => {
        this.message = err.error;
      }
    });     
  }
  
}
