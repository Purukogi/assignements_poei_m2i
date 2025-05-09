import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-header',
  imports: [RouterModule, CommonModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

  constructor(private service : UserService){}
  
  isUserConnected() : boolean {
    return this.service.isUserConnected();
  }

  getUsername(){
    return localStorage.getItem("connected_user");
  }

  disconnect() {
    this.service.disconnect()
  }

}
