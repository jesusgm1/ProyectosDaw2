import { NgForm } from '@angular/forms';

import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { LoginService } from 'src/app/servicios/usuario.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  private router: Router;
  private auth: LoginService;

  constructor(protected routerp:Router, authp:LoginService) {
    this.router=routerp;
    this.auth=authp;
   }

  login (form:NgForm){
    const usuario=form.value.usuario;
    const password=form.value.password;
    this.auth.login(usuario,password).pipe(first()).subscribe((respuesta: any) =>{
      if (respuesta){
        localStorage.setItem('token',respuesta);
        this.router.navigate(['MostrarCanciones']);
      }
      if(!respuesta) {
        this.router.navigate(['MostrarCanciones']);
      }
    })
  }

  ngOnInit(): void {

  }

  }




