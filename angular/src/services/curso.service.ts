import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Curso } from "../classes/curso";

@Injectable({
  providedIn: 'root'
})
export class CursoService {

  constructor(private _http: HttpClient) { }

  getCursos():Observable<Curso[]> {

    return this._http.get<Curso[]>('http://localhost:5001/api/Cursos');
  }
}
