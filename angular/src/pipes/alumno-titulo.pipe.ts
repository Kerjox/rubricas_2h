import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'alumnoTitulo'
})
export class AlumnoTituloPipe implements PipeTransform {

  transform(value: string, gender: string): string {

    switch (gender) {

      case 'H':
        value = 'Sir. '.concat(value)
        break

      case 'M':
        value = 'Madam '.concat(value)
    }
    return value;
  }

}
