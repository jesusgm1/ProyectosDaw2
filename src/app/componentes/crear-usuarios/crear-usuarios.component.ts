import { Component, OnInit} from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { Cancion } from 'src/app/interfaces/cancion';
import { TodasCancionesService } from 'src/app/servicios/cancion.service';
import { TodasCantantesService } from 'src/app/servicios/cantante.service';
import { Cantante } from 'src/app/interfaces/cantante';


@Component({
  selector: 'app-crear-usuarios',
  templateUrl: './crear-usuarios.component.html',
  styleUrls: ['./crear-usuarios.component.css']
})
export class CrearUsuariosComponent implements OnInit{
  SongForm!: FormGroup;
  Cancion: any;
  router: any;
  file:any;
  imageShow: any= '';
  constructor(private anadirCancion: TodasCancionesService,private cantantes: TodasCantantesService,private readonly fb:FormBuilder) {

  }
  ngOnInit(): void {
    this.cantantes.TodasCantantes().subscribe((cancion)=> {
      this.Cancion=cancion;
    });
    this.SongForm = this.initForm();
  }

  //metodo que crear al arrancar la pagina un grupo de formulario
  //para controlar y rescatar los datos
  initForm(): FormGroup{
     return this.fb.group({
       id: [''],
       artista: [''],
       precio: [''],
       anno: [''],
       cancion: [''],
     })
  }

   //metodo para almacenar nueva cancion
   NewSong() {
    this.anadirCancion.anadirCancion(this.SongForm.value).subscribe((song => {
      this.Cancion.push(this.SongForm.value)
    }));
  }

  CambiarRuta() {
    this.router.navigate(['/MostrarCanciones']);
  }

}
