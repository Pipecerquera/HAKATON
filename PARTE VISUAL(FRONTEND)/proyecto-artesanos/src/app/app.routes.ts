import { Routes } from '@angular/router';
import { Inicio } from './inicio/inicio';
import { header } from './header/header';

export const routes: Routes = [
    {path: '', redirectTo: 'inicio', pathMatch: 'full' },
    {path: 'inicio', component: Inicio},
    {path: 'header', component: header},
];
