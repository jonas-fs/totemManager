import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { SignUpComponent } from './pages/signup/signup.component';
import { UserComponent } from './pages/user/user.component';
import { AuthGuard } from './services/auth-guard.service';
import { DashboardComponent } from './pages/dashboard/dashboard.component';

export const routes: Routes = [
    {
        path: "login",
        component:LoginComponent
    },
    {
        path: "signup",
        component:SignUpComponent
    },
    {
        path: "dashboard",
        component:DashboardComponent,
        canActivate:[AuthGuard]
    },
    {
        path: "user",
        component:UserComponent,
        canActivate:[AuthGuard]
    }
];
