//componentes para las vistas
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule,Routes } from '@angular/router';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import { ReactiveFormsModule } from '@angular/forms';
import { MatTableModule } from '@angular/material/table';
import {MatRadioModule} from '@angular/material/radio';
import {MatSortModule} from '@angular/material/sort';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatGridListModule} from '@angular/material/grid-list';
import { FormsModule } from '@angular/forms';
import { YouTubePlayerModule } from "@angular/youtube-player";


//componentes de rutas
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CabeceraComponent } from './componentes/cabecera/cabecera.component';
import { ListarUsuariosComponent } from './componentes/listar-usuarios/listar-usuarios.component';
import { CrearUsuariosComponent } from './componentes/crear-usuarios/crear-usuarios.component';
import { PrincipalComponent } from './componentes/principal/principal.component';
import { PieComponent } from './componentes/pie/pie.component';
import { InsertarUsuariosComponent } from './componentes/insertar-usuarios/insertar-usuarios.component';
import { BorrarUsuariosComponent } from './componentes/borrar-usuarios/borrar-usuarios.component';
import { LoginComponent } from './componentes/login/login.component';
import{LoginService} from './servicios/usuario.service';
import { GardnaGuard } from './guards/gardna.guard';
import { HttpconfigInterceptor } from './interceptor/inte-raptor.interceptor';
import { LogOutComponent } from './componentes/log-out/log-out.component';

const appRoutes:Routes=[
  {path:'MostrarCanciones',component:ListarUsuariosComponent},
  {path:'IntroducirCancion',component:CrearUsuariosComponent,canActivate:[GardnaGuard]},
  {path:'ActualizarCancion',component:InsertarUsuariosComponent,canActivate:[GardnaGuard]},
  {path:'Login',component:LoginComponent},
  {path:'Logout',component:LogOutComponent,canActivate:[GardnaGuard]},
  {path:'',redirectTo:'/MostrarCanciones', pathMatch:'full'},
  {path:'**',component: PrincipalComponent},
  {path: "**", redirectTo: '/MostrarCanciones'}
 ]


@NgModule({
  declarations: [
    AppComponent,
    CabeceraComponent,
    ListarUsuariosComponent,
    CrearUsuariosComponent,
    PrincipalComponent,
    PieComponent,
    InsertarUsuariosComponent,
    BorrarUsuariosComponent,
    LoginComponent,
    LogOutComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatTableModule,
    MatRadioModule,
    MatGridListModule,
    RouterModule,
    MatButtonModule,
    MatSortModule,
    ReactiveFormsModule,
    MatCheckboxModule,
    FormsModule,
    YouTubePlayerModule,
RouterModule.forRoot(appRoutes)
  ],
  providers: [
   [{provide: HTTP_INTERCEPTORS, useClass: HttpconfigInterceptor, multi: true },LoginService],
   MatDatepickerModule,
    MatNativeDateModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
