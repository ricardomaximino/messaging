import { Component, OnInit, Input, OnChanges, SimpleChange, ViewChild } from '@angular/core';
import { ChartsService } from './charts.service';


@Component({
  selector: 'app-charts',
  templateUrl: './charts.component.html',
  styleUrls: ['./charts.component.css']
})
export class ChartsComponent implements OnChanges {

  @Input() config: any;
  @ViewChild('host') host;
  constructor(private chartsService: ChartsService) { }

  ngOnChanges(changes) {
    const {config} = changes;
   this.chartsService.renderChart(this.host.nativeElement, config.currentValue);
  }

}
