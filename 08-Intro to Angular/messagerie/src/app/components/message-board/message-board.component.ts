import { Component } from '@angular/core';
import { UsersComponent } from "../users/users.component";
import { MessagesComponent } from "../messages/messages.component";
import { FormComponent } from "../form/form.component";

@Component({
  selector: 'app-message-board',
  imports: [UsersComponent, MessagesComponent, FormComponent],
  templateUrl: './message-board.component.html',
  styleUrl: './message-board.component.css'
})
export class MessageBoardComponent {

}
