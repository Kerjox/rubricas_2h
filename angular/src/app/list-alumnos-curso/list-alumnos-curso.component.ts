import { Component, OnInit } from '@angular/core';
import { Alumno } from "../../classes/alumno";
import { AlumnoService } from "../../services/alumno.service";

@Component({
  selector: 'app-list-alumnos-curso',
  templateUrl: './list-alumnos-curso.component.html',
  styleUrls: ['./list-alumnos-curso.component.css']
})
export class ListAlumnosCursoComponent implements OnInit {

  alumnos: Alumno[];
  alumnosToShow: Alumno[];

  constructor(public alumnoService: AlumnoService) {

    this.alumnos = [];
    this.alumnosToShow = [];
  }

  ngOnInit(): void {

    this.alumnoService.getAlumnos().subscribe(data => {
      this.alumnos = this.alumnosToShow = data;
    })
  }

  filterCurse($event: number) {

    if ($event != -1) {

      this.alumnosToShow = this.alumnos.filter(a => a.curso.id == $event);
      return;
    }

    this.alumnosToShow = this.alumnos;
    console.log(this.alumnosToShow);
  }
}
