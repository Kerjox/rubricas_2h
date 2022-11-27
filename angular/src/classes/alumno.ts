import { IAlumno } from "../interfaces/IAlumno";
import { Curso } from "./curso";


export class Alumno implements IAlumno {

  id: number
  name: string;
  street: string;
  date: string;
  gender: string;
  curso: Curso;

  constructor(id: number, name: string, street: string, date: string, gender: string, curso: Curso) {

    this.id = id;
    this.name = name;
    this.street = street;
    this.date = date;
    this.gender = gender;
    this.curso = curso
  }

  edad(): number {
    return 0;
  }
}
