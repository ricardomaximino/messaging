import { ChartsComponent } from './charts.component';
import { ChartsService } from './charts.service';
import { NgModule } from '@angular/core';

@NgModule({
  declarations: [ChartsComponent],
  providers: [ChartsService],
  exports: [ChartsComponent]
})
export class ChartsModule { }
