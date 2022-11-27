import { Injectable } from '@angular/core';
import { Alumno } from "../classes/alumno";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";


@Injectable({
  providedIn: 'root'
})

export class AlumnoService {

  constructor(private _http: HttpClient) { }

  getAlumnos(): Observable<Alumno[]> {

    return this._http.get<Alumno[]>("http://localhost:5001/api/Alumnos");
  }

  getAlumnoByName(name: string): Observable<Alumno> {

    return this._http.get<Alumno>("http://localhost:5001/api/Alumnos/Name/" + name);
  }

  getAlumnoByID(id: number): Observable<Alumno> {

    return this._http.get<Alumno>("http://localhost:5001/api/Alumnos/Name/" + id);
  }

}
