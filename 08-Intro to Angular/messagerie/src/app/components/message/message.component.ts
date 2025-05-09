import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { Message } from '../../interfaces/message';
import { MessageService } from '../../services/message.service';

@Component({
  selector: 'app-message',
  imports: [CommonModule],
  templateUrl: './message.component.html',
  styleUrl: './message.component.css'
})
export class MessageComponent {
  
  @Input()
  message ?: Message;

  constructor (private service : MessageService) {}
  
  isYourMessage(): boolean {
    return this.service.isYourMessage(this.message);
  }

}
