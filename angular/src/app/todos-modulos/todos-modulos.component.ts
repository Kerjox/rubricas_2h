import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-todos-modulos',
  templateUrl: './todos-modulos.component.html',
  styleUrls: ['./todos-modulos.component.css']
})
export class TodosModulosComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  title = 'Angular Ubalde';
  header = null;
  imagen: string = 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages5.alphacoders.com%2F531%2F531494.jpg&f=1&nofb=1';

  name: string = 'Alita'
  surname: string = 'Battle Angel'

  getCompleteName(): string {

    return this.name + ' ' + this.surname;
  }

}
