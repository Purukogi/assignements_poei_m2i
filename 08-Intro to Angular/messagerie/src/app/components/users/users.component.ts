import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { UserService } from '../../services/user.service';
import { UserWrapper } from '../../interfaces/user-wrapper';

@Component({
  selector: 'app-users',
  imports: [CommonModule],
  templateUrl: './users.component.html',
  styleUrl: './users.component.css'
})
export class UsersComponent {

  users : string[] = [];

  constructor(private service : UserService) {
    service.getUsers().subscribe(response => this.users = response);
  }

}
