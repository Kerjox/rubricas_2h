import { Alumno } from './alumno';
import { Curso } from "./curso";

describe('Alumno', () => {
  it('should create an instance', () => {
    expect(new Alumno(1, "Test", "Street Test", "01/01/2000", "H", new Curso(1, "Curso Test"))).toBeTruthy();
  });
});
