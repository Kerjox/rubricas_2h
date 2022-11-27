import { Component, OnInit } from '@angular/core';
import { Alumno } from "../../classes/alumno";
import { AlumnoService } from "../../services/alumno.service";
import { ActivatedRoute } from "@angular/router";
import { Curso } from "../../classes/curso";

@Component({
  selector: 'app-alumno',
  templateUrl: './alumno.component.html',
  styleUrls: ['./alumno.component.css']
})
export class AlumnoComponent implements OnInit {

  alumno: Alumno;

  constructor(private alumnoService: AlumnoService, private activatedRoture: ActivatedRoute) {

    this.alumno = new Alumno(0, "", "", "", "", new Curso(0, "", ""))
  }

  ngOnInit(): void {

    var name: string = this.activatedRoture.snapshot.params['name'];
    this.alumnoService.getAlumnoByName(name).subscribe(response => {

      this.alumno = response;
    });
  }


}
