export class Curso {

  id: number;
  nombreCurso: string;
  localizacion: string;

  constructor(id: number, nombreCurso: string, localizacion: string) {
    this.id = id;
    this.nombreCurso = nombreCurso;
    this.localizacion = localizacion;
  }
}
