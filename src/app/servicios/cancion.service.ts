//importación de la interface
import { Cancion } from './../interfaces/cancion';
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
export class TodasCancionesService {
  //url de la API de la que se va a consumir
  private apiUrl="http://localhost:3000/canciones";

  // variable http para poder reallizar peticiones asíncronas a la API
  constructor(private http:HttpClient) { }

  //Petición de tipo get que devuelve un observable de array de objetos del tipo Modulo de la interface
  TodasCanciones(): Observable<Cancion[]>{
    return this.http.get<Cancion[]>(this.apiUrl);
  }

  anadirCancion(cancion:Cancion): Observable<Cancion>{
    return this.http.post<Cancion>(this.apiUrl,cancion,httpOptions);
    }

    actualizarCancion(cancion: Cancion): Observable<Cancion> {
      const url = `${this.apiUrl}/${cancion.id}`;
      return this.http.put<Cancion>(url, cancion, httpOptions);
    }

    borrarCancion(nombre: string): Observable<Cancion> {
      const url = `${this.apiUrl}/${nombre}`;
      return this.http.delete<Cancion>(url);
    }

    BuscarCancion(nombre: string): Observable<Cancion> {
      const url = `${this.apiUrl}/${nombre}`;
      return this.http.get<Cancion>(url);
    }
}
