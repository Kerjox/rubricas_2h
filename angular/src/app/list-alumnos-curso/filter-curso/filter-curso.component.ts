import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Curso } from "../../../classes/curso";
import { CursoService } from "../../../services/curso.service";

@Component({
  selector: 'app-filter-curso',
  templateUrl: './filter-curso.component.html',
  styleUrls: ['./filter-curso.component.css']
})
export class FilterCursoComponent implements OnInit {

  @Input() cursoSelected: number;
  @Output() idSelectedCourso: EventEmitter<number>;
  cursos: Curso[];

  constructor(private cursoService: CursoService) {
    this.cursoSelected = 0;
    this.cursos = [];
    this.idSelectedCourso = new EventEmitter<number>();
  }

  ngOnInit(): void {

    this.cursoService.getCursos().subscribe(data => {
      this.cursos = data;
    });
  }

  filterCurse() {

    this.idSelectedCourso.emit(this.cursoSelected);

    console.log(
      {
        "Curso Seleccionado": this.cursoSelected
      });
  }
}
