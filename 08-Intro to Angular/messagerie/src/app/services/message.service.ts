import { Injectable } from '@angular/core';
import { Message } from '../interfaces/message';
import { HttpClient } from '@angular/common/http';
import { MessageWrapper } from '../interfaces/message-wrapper';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  
  private BASE_URL = "http://localhost:8000/messages";

  constructor(private http : HttpClient) {}
  
  getMessages() {
    return this.http.get<Message[]>(this.BASE_URL);
  }
  
  addMessage(message : MessageWrapper){
    return this.http.post(this.BASE_URL, message);
  }

  isYourMessage(message: Message | undefined): boolean {
    return message?.author == localStorage.getItem("connected_user");
  }
  
}
