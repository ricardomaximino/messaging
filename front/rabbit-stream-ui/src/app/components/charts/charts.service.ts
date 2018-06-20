import { Injectable } from '@angular/core';
import * as highcharts from 'highcharts';
import { chartDark } from '../data/charts.dark.themes';

@Injectable()
export class ChartsService {

  renderChart(element: HTMLElement, config: any) {
    highcharts.setOptions(chartDark);
    highcharts.chart(element, config);
  }

}
