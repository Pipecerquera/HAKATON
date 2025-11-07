import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { header } from "../header/header";

@Component({
  selector: 'app-inicio',
  imports: [RouterModule, header],
  templateUrl: './inicio.html',
  styleUrl: './inicio.css',
})
export class Inicio {

}
