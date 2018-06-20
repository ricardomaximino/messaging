
    import { Injectable } from '@angular/core';
    import { HttpClient } from '@angular/common/http';
    import { Observable } from 'rxjs/Observable';
    import 'rxjs/add/observable/throw';
    import 'rxjs/add/operator/catch';
import { Contact } from '../table/contact/contact.component';
import { ContactEvent } from '../table/contact-event/contact-event.component';

    @Injectable()
    export class SimpleCrudService  {
      url = 'http://localhost:8091/event';
      urlReactiveMono = 'http://localhost:8090/contact/count';
      url_reactive_contact = 'http://localhost:8090/contact';
      url_receiver_one_event = 'http://localhost:8091/event';

        constructor(private http: HttpClient) { }

         getContacts(): Observable<Contact[]> {
           return this.http.get<Contact[]>(this.url_reactive_contact);
         }
         getEvents(): Observable<ContactEvent[]> {
          return this.http.get<ContactEvent[]>(this.url_receiver_one_event);
        }
    }
