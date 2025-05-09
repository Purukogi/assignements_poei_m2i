import { Routes } from '@angular/router';
import { MessageBoardComponent } from './components/message-board/message-board.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { authenticationGuard } from './guards/authentication.guard';

export const routes: Routes = [
    {path : "messageboard", component : MessageBoardComponent, canActivate : [authenticationGuard]},
    {path : "login", component : LoginComponent},
    {path : "register", component : RegisterComponent},
    {path : "**", redirectTo : "/login"}
];
