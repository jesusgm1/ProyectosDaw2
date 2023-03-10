import { Component, OnInit } from '@angular/core';
import { FormGroup }  from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { Cancion } from 'src/app/interfaces/cancion';
import { TodasCancionesService } from 'src/app/servicios/cancion.service';
import { TodasCantantesService } from 'src/app/servicios/cantante.service';
import { Cantante } from 'src/app/interfaces/cantante';

@Component({
  selector: 'app-insertar-usuarios',
  templateUrl: './insertar-usuarios.component.html',
  styleUrls: ['./insertar-usuarios.component.css']
})

export class InsertarUsuariosComponent implements OnInit {
  SongForm!: FormGroup;
  Cancion: any;
  cancionBuscada: any;
  Cantante: any;
  router: any;
  constructor(private actualizarCancion: TodasCancionesService,private TodasCanciones: TodasCancionesService ,
    private TodasCantantes: TodasCantantesService,private readonly fb:FormBuilder) {

  }


  initForm(): FormGroup{
    return this.fb.group({
      id: [''],
      artista: [''],
      precio: [''],
      anno: [''],
      cancion: ['']
    })
 }

  ngOnInit(): void{
    this.TodasCanciones.TodasCanciones().subscribe((cancion)=> {
      this.Cancion=cancion;
    });
    this.TodasCantantes.TodasCantantes().subscribe((cantante)=> {
      this.Cantante=cantante;
    });
    this.SongForm = this.initForm();
  }

  UpdateSong(){
    this.actualizarCancion.actualizarCancion(this.SongForm.value).subscribe();
  }
  BuscarCancion(nombre:string) {
     this.TodasCanciones.BuscarCancion(nombre).subscribe(()=>{this.cancionBuscada!=this.cancionBuscada});
  }

}
