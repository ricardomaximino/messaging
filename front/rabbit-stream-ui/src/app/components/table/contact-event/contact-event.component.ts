import { Component, OnInit, Input } from '@angular/core';
import { Contact } from '../contact/contact.component';

@Component({
  selector: 'app-contact-event',
  templateUrl: './contact-event.component.html',
  styleUrls: ['./contact-event.component.css']
})
export class ContactEventComponent implements OnInit {
  @Input() contactEvents: ContactEvent[];
  constructor() { }

  ngOnInit() {
  }

  getColor(cod) {
    if (cod === '01') {return  '#999966'; }
    if (cod === '02') {return  '#ccffe6'; }
    if (cod === '03') {return  '#ff9966'; }
    if (cod === '04') {return  '#80bfff'; }
    if (cod === '05') {return  '#ffcccc'; }
  }
}

export class ContactEvent {
  constructor(
    public id?: string,
    public type?: string,
    public contactId?: string,
    public contact?: Contact,
    public sendDate?: string,
    public receiveDate?: string,
    public sendTime?: string,
    public receiveTime?: string) {}
}
