import { Component } from '@angular/core';
import { MessageService } from '../../services/message.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-form',
  imports: [FormsModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent {
  sender = localStorage.getItem("connected_user");
  body = "";

  constructor(private messageService : MessageService){}

  send(){
    
    this.messageService.addMessage({
      "author" : this.sender ? this.sender : "",
      "content" : this.body
    }).subscribe(response => {
      console.log("message sent");      
    });

    this.body = "";
  }
}
