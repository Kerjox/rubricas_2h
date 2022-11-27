import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CharacterComponent } from './character-alita/character.component';
import { ButtonsComponent } from './buttons/buttons.component';
import { EventsComponent } from './events/events.component';
import { ListAlumnosComponent } from './list-alumnos/list-alumnos.component';
import { AlumnoTituloPipe } from '../pipes/alumno-titulo.pipe';
import { CalcPersonsListAlumnosComponent } from './list-alumnos/calc-persons-list-alumnos/calc-persons-list-alumnos.component';
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { ListAlumnosCursoComponent } from './list-alumnos-curso/list-alumnos-curso.component';
import { FilterCursoComponent } from './list-alumnos-curso/filter-curso/filter-curso.component';
import { RouterModule, Routes } from "@angular/router";
import { ProfesoresComponent } from './profesores/profesores.component';
import { TodosModulosComponent } from './todos-modulos/todos-modulos.component';
import { AlumnoComponent } from './alumno/alumno.component';

const routes: Routes = [
  { path: 'Alumno', component: ListAlumnosComponent },
  { path: 'Alumno/:name', component: AlumnoComponent },
  { path: 'Profes', component: ProfesoresComponent },
  { path: 'Todos', component: TodosModulosComponent },
  { path: 'AlumnosCurso', component: ListAlumnosCursoComponent },

  { path: '**',  redirectTo: '' }



]

@NgModule({
  declarations: [
    AppComponent,
    CharacterComponent,
    ButtonsComponent,
    EventsComponent,
    ListAlumnosComponent,
    AlumnoTituloPipe,
    CalcPersonsListAlumnosComponent,
    ListAlumnosCursoComponent,
    FilterCursoComponent,
    ProfesoresComponent,
    TodosModulosComponent,
    AlumnoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
