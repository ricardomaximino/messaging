import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  @Input() contacts: Contact[];
  constructor() { }

  ngOnInit() {
  }

}

export class Contact {
  constructor(public id: string, public name: string, public lastname: string) {}
}
