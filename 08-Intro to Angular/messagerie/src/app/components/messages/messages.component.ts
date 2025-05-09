import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { MessageComponent } from '../message/message.component';
import { Message } from '../../interfaces/message';
import { MessageService } from '../../services/message.service';

@Component({
  selector: 'app-messages',
  imports: [CommonModule, MessageComponent],
  templateUrl: './messages.component.html',
  styleUrl: './messages.component.css'
})
export class MessagesComponent {
  messages : Message[] = [];

  constructor(private service : MessageService){
    setInterval(() => {
      service.getMessages().subscribe(response => this.messages = response.reverse());
    }, 500);    
  }
}
