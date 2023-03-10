import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Usuario } from "../interfaces/usuario";


@Injectable({
  providedIn: "root"
})

export class LoginService {

  private apiUrl="http://localhost:3000/usuarios";

  constructor(private http: HttpClient) {

  }

  login(id: string, password:string): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.apiUrl}/${id}`);
  }
}
