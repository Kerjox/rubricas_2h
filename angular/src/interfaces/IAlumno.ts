import { Curso } from "../classes/curso";


export interface IAlumno {

  name: string;
  street: string;
  date: string;
  gender: string;
  curso: Curso;

  edad(): number;
}
