import { Component, SystemJsNgModuleLoader, OnInit } from '@angular/core';
import { getFakeDataContact } from './components/data/charts-fake-data';
import { getFakeDataContactEvent } from './components/data/charts-fake-data';
import { SimpleCrudService } from './components/charts/charts.data.service';
import { Contact } from './components/table/contact/contact.component';
import { ContactEvent } from './components/table/contact-event/contact-event.component';
import { ChartModel, Test } from './components/data/charts.objects';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  chartDataContact: any;
  chartDataContactEvent: any;
  contacts: Contact[];
  events: ContactEvent[];
  chartObject: ChartModel;
  objectCreator: any;

  text: 'My Object Title';

  constructor(private service: SimpleCrudService) {}

  ngOnInit() {
  this.chartDataContact = getFakeDataContact;
  this.chartDataContactEvent = getFakeDataContactEvent;
  this.service.getEvents().subscribe(e => this.events = e);
  this.service.getContacts().subscribe(c => this.contacts = c);
  console.log(this.chartDataContactEvent);
  console.log('Contacts => ', this.contacts);
 }

}
