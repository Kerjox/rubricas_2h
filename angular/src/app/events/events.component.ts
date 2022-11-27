import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent implements OnInit {

  visible:boolean = false;
  image: string = 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages5.alphacoders.com%2F531%2F531494.jpg&f=1&nofb=1';

  constructor() { }

  ngOnInit(): void {
  }

  buttonClick() {

    this.visible = !this.visible;
  }

}
