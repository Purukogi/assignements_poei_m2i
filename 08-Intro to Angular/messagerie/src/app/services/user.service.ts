import { Injectable } from '@angular/core';
import { User } from '../interfaces/user';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  private BASE_URL = "http://localhost:8000/"; 

  constructor(private router : Router, private http : HttpClient) { }
  
  getUsers(){
    return this.http.get<string[]>(this.BASE_URL + "users")
  }
  
  hasUser(user : User){
   return this.http.post<User>(this.BASE_URL + "check-user", user);
  }
  
  addUser(user : User){
    return this.http.post(this.BASE_URL + "users", user);
  }
  
  isUserConnected(): boolean {
    return localStorage.getItem("connected_user") != null;
  }
  
  disconnect() {
    localStorage.removeItem("connected_user");
    this.router.navigate(['/login']);
  }

}
