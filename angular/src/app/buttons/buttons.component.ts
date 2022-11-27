import {Component, OnInit} from '@angular/core';


@Component({
  selector: 'app-buttons',
  templateUrl: './buttons.component.html',
  styleUrls: ['./buttons.component.css']
})
export class ButtonsComponent implements OnInit {

  // Style
  boldItalica: string = 'bold italica';

  applyColor:boolean = false;
  applyBold:boolean = true;

  disableButton:boolean = true;

  constructor() { }

  ngOnInit(): void {
  }

  applyStyleClasses() {

    return {

      bold: this.applyBold,
      color: this.applyColor
    }
  }

}
