export class Test {

charModel: ChartModel;
constructor() {}

  public  create(): ChartModel {

    this.charModel = new ChartModel();
    this.charModel.chart = new Chart('spline');
    this.charModel.title = new Title('My Chart');
    this.charModel.subtitle = new SubTitle('Very nice diagram');
    this.charModel.yAxis = new YAxis(new Title('Column Y'));
    this.charModel.legend = new Legend();

    const plotOptions = new PlotOptions();
    plotOptions.pie = new PieOptions(new DataLabels());
    plotOptions.series = new SeriesOptions(new Label(), 2010);

    this.charModel.plotOptions = plotOptions;

    const series1 = new Series('Installation',  [43934, 52503, 57177, 69658, 97031, 119931, 137133, 154175]);
    const series2 = new Series('Manufacturing',  [24916, 24064, 29742, 29851, 32490, 30282, 38121, 40434]);
    const series3 = new Series('Sales & Distribution',  [11744, 17722, 16005, 19771, 20185, 24377, 32147, 39387]);
    const series4 = new Series('Project Development',  [null, null, 7988, 12169, 15112, 22452, 34400, 34227]);
    const series5 = new Series('Other',  [12908, 5948, 8105, 11248, 8989, 11816, 18274, 18111]);
    const series = [series1, series2, series3, series4, series5];
    this.charModel.series = series;

    const chartOptions = new ChartOptions(new Legend());
    const rules = new Rules(new Condition(), chartOptions);
    const responsive = new Responsive(rules);
    this.charModel.responsive = responsive;
    return this.charModel;
  }
}

export class ChartModel {
  public chart: Chart;
  public title: Title;
  public subtitle: SubTitle;
  public yAxis: YAxis;
  public legend: Legend;
  public plotOptions: PlotOptions;
  public series: Series[];
  public responsive: Responsive;
}

export class Chart {
  public plotBackgroundColor: any;
  public plotBorderWidth: any;
  public plotShadow: true;
  constructor(public type: string) {}
}

export class Title {
  constructor(public text: string) {}
}

export class SubTitle {
  constructor(public text: string) {}
}

export class YAxis {
  constructor(public title: Title) {}
}

export class Legend {
  public layout = 'vertical';
  public align = 'right';
  public verticalAlign = 'middle';
}
export class PlotOptions {
  public pie: PieOptions;
  public series: SeriesOptions;
}
export class PieOptions {
  public allowPointSelect = true;
  public cursor = 'pointer';
  constructor(public dataLabels: DataLabels) {}
}
export class SeriesOptions {
  constructor(public label: Label, public pointStart: any) {}
}

export class Label {
  public connectorAllowed = false;
}

export class DataLabels {
  enabled = true;
  format = '<b>{point.name}</b>: {point.percentage:.1f} %';

}

export class Series {
  constructor(public name: string, public data: any[]) {}
}

export class Responsive {
  constructor(public rules: Rules) {}
}

export class Rules {
  constructor(public condition: Condition, public chartOptions: ChartOptions) {}
}

export class Condition {
  public maxWidth = 500;
}

export class ChartOptions {
  constructor(public legend: Legend) {}
}
