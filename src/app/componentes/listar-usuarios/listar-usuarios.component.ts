import { Component } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import { ViewChild } from '@angular/core';
import {MatSort} from '@angular/material/sort';
import { Cancion } from 'src/app/interfaces/cancion';
import { TodasCancionesService } from 'src/app/servicios/cancion.service';


const ELEMENT_DATA: Cancion[] = [

];



@Component({
  selector: 'app-listar-usuarios',
  templateUrl: './listar-usuarios.component.html',
  styleUrls: ['./listar-usuarios.component.css']
})
export class ListarUsuariosComponent {
  Cancion2: any;
  @ViewChild(MatSort, {static: true}) sort!: MatSort;
  displayedColumns: string[] = ['id', 'artista','precio','año','cancion','borrado'];
  datasource = new MatTableDataSource<Cancion>([]);
  constructor(private TodasCanciones:TodasCancionesService){

  }

  //nos suscribimos al servicio
  ngOnInit(): void{
    this.TodasCanciones.TodasCanciones().subscribe((cancion)=> {;
     this.datasource = new MatTableDataSource<Cancion>(cancion);
     this.datasource.sort = this.sort;
  })
  const tag = document.createElement('script');

  tag.src = "https://www.youtube.com/iframe_api";
  document.body.appendChild(tag);
};

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.datasource.filter = filterValue.trim().toLowerCase();
  }

FinishSong(nombre:string) {
    this.TodasCanciones.borrarCancion(nombre).subscribe(()=>{this.Cancion2=this.Cancion2.filter((c: { nombre: string; })=>c.nombre!==nombre)});
    window.location.reload();
    }
}


