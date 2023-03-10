//importación de la interface
import { Cantante } from './../interfaces/cantante';
//importación del injectable para poder inyectar el servicio a los componentes
import { Injectable } from '@angular/core';
//importación de HttpClient para peticiones asíncronas y Headers para las cabeceras
import { HttpClient, HttpHeaders } from '@angular/common/http';
//importación de observable para poder suscribirse los observadores
import {Observable} from 'rxjs';

//cabeceras indicando el tipo de información a enviar
const httpOptions={
 headers:new HttpHeaders({'Content-Type':'application/json',}),
};


@Injectable({
  providedIn: 'root'
})
export class TodasCantantesService {
  //url de la API de la que se va a consumir
  private apiUrl="http://localhost:3000/cantantes";

  // variable http para poder reallizar peticiones asíncronas a la API
  constructor(private http:HttpClient) { }

  //Petición de tipo get que devuelve un observable de array de objetos del tipo Modulo de la interface
  TodasCantantes(): Observable<Cantante[]>{
    return this.http.get<Cantante[]>(this.apiUrl);
  }
}
