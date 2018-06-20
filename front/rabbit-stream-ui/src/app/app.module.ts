import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { ChartsModule } from './components/charts/charts.module';

import { HttpClientModule } from '@angular/common/http';
import { SimpleCrudService } from './components/charts/charts.data.service';
import { ContactComponent } from './components/table/contact/contact.component';
import { ContactEventComponent } from './components/table/contact-event/contact-event.component';


@NgModule({
  declarations: [
    AppComponent,
    ContactComponent,
    ContactEventComponent
  ],
  imports: [
    BrowserModule,
    ChartsModule,
    HttpClientModule
  ],
  providers: [SimpleCrudService],
  bootstrap: [AppComponent]
})
export class AppModule { }
