import { Component, OnInit, ViewChild, group } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { HttpModule, Http } from '@angular/http';
import { CookieService } from 'ngx-cookie-service';
import { AuthService } from '../modules/auth/auth.service';
import { CompanyService } from '../modules/company/company.service';
import { error } from 'util';
import { Transaction } from '../modules/transaction/model/transaction';
import { NgAutocompleteComponent, CreateNewAutocompleteGroup, SelectedAutocompleteItem } from 'ng-auto-complete';
import { Company } from '../modules/company/model/company';
import { ChartModule } from 'angular2-highcharts';
import * as Highcharts from 'highcharts';
import 'highcharts/highcharts-more';
import { TransactionService } from '../modules/transaction/transaction.service';
import { StockChartDataService } from '../modules/stock-chart-data/stock-chart-data.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
  // template: '<chart [options]="options"></chart>'
})
export class HomePageComponent implements OnInit {

  @ViewChild(NgAutocompleteComponent) public completer: NgAutocompleteComponent;
  readonly ROOT_URL = 'http://rest.metraf.eu/permissions';
  //readonly ROOT_URL = 'http://localhost:8080/permissions';

  public transactions: Transaction[];
  public ready = false;
  public readyNoData = false;
  public group: any = [];
  public options: Object;
  public chart: any;
  public noDataChart: any;

  p: number = 1;
  //chart = new Highcharts.Chart(this.options);

  constructor(private httpClient: HttpClient,
    private http: Http,
    private router: Router,
    private authService: AuthService,
    private companyService: CompanyService,
    private transactionService: TransactionService,
    private stockChartDataService: StockChartDataService) {
    companyService.getCompanies().subscribe(res => {
      this.group = [
        CreateNewAutocompleteGroup(
          'Search / choose in / from list',
          'completer',
          res,
          { titleKey: 'name', childrenKey: 'symbol' }
        ),
      ]
    })
  }

  Selected(item: SelectedAutocompleteItem) {
    let company: Company = item.item.original;
    this.createChart(company.id);
    //this.chartDataService.getChartDataById(company.id).subscribe(res => {
    //this.chart.series[0].setData(res,true);
    // })

  }

  saveInstance(chartInstance) {
    this.chart = chartInstance;
  }

  ngOnInit() {
    return this.httpClient
      .get(this.ROOT_URL, { headers: this.authService.getHeader() })

      .subscribe(data => {
        this.router.navigate(['/home']);
        this.createChart(320193);
        console.log("Status is ok")
      }, (err) => {
        this.router.navigate(['/login']);
      })
  }

  private createChart(companyId: Number) {
    this.ready = false
    this.stockChartDataService.getChartDataById(companyId).subscribe(res => {
      this.ready = true
      this.options = {
        colors: ['#DDDF0D', '#55BF3B', '#DF5353', '#7798BF', '#aaeeee',
          '#ff0066', '#eeaaee', '#55BF3B', '#DF5353', '#7798BF', '#aaeeee'],
        chart: {
          renderTo: 'chart',
          backgroundColor: {
            linearGradient: [0, 0, 250, 500],
            stops: [
              [0, 'rgb(48, 96, 48)'],
              [1, 'rgb(0, 0, 0)']
            ]
          },
          borderColor: '#000000',
          borderWidth: 2,
          className: 'dark-container',
          //plotBackgroundColor: 'rgba(255, 255, 255, .1)',
          plotBorderColor: '#CCCCCC',
          plotBorderWidth: 1
        },
        tooltip: {
          backgroundColor: 'rgba(0, 0, 0, 0.75)',
          style: {
            color: '#F0F0F0'
          },
          borderColor: '#00ff00',
        },
        toolbar: {
          itemStyle: {
            color: 'silver'
          }
        },

        plotOptions: {
          line: {
            lineColor: '#00ff00',  //color of our line
          }
        },

        title: {
          text: res.company.name,

          style: {
            color: '#C0C0C0',
            font: 'bold 16px "Trebuchet MS", Verdana, sans-serif'
          }

        },

        rangeSelector: {
          buttonTheme: {  //range selector buttons with monthes, years, all
            fill: {
              linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
              stops: [
                [0.4, '#888'],
                [0.6, '#555']
              ]
            },
            stroke: '#000000',
            style: {
              color: '#CCC',
              fontWeight: 'bold'
            },
            states: {
              hover: {
                fill: {
                  linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
                  stops: [
                    [0.4, '#BBB'],
                    [0.6, '#888']
                  ]
                },
                stroke: '#000000',
                style: {
                  color: 'white'
                }
              },
              select: {
                fill: {
                  linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
                  stops: [
                    [0.1, '#000'],
                    [0.3, '#333']
                  ]
                },
                stroke: '#000000',
                style: {
                  color: '#00ff00'
                }
              }
            }
          },
          inputStyle: {
            backgroundColor: '#333',
            color: 'silver'
          },
          labelStyle: {
            color: 'silver'
          }
        },
        navigator: {
          handles: {
            backgroundColor: '#666',
            borderColor: '#AAA'
          },
          outlineColor: '#CCC',
          maskFill: 'rgba(16, 16, 16, 0.5)',
          series: {
            color: '#7798BF',
            lineColor: '#A6C7ED'
          }
        },


        // series : [{
        //     name : 'AAPL', 
        //     data : res.json(), 
        //     tooltip: {
        //         valueDecimals: 2 
        //     },
        // }]
        series: [{
          name: res.company.symbol,
          data: res.chartData,
          id: 'dataseries',
          tooltip: {
            valueDecimals: 2
          }
        }, {
          type: 'flags',
          name: 'Flags on series',
          data: [{
            // x: (res.chartData[res.chartData.length - 100][0]) - 60,
            fillColor: 'green',
            title: ''
          }],
          onSeries: 'dataseries',
          shape: 'triangle'
        }, {
          type: 'flags',
          name: 'Flags on series',
          data: [{
            // x: (res.chartData[res.chartData.length - 500][0]) - 150,
            fillColor: 'red'
          }],
          onSeries: 'dataseries',
          shape: 'triangle-down'
        }]
      };
      //if(this.ready=false){
      //this.chart.showLoading();
      //}
      //else{
      //this.chart.hideLoading();
      //}
      //this.chart = new Highcharts.Chart(this.options);
      //console.log(this.chart);
    },
      err => {
        this.noDataChart = Highcharts.chart('chart', {
          colors: ['#DDDF0D', '#55BF3B', '#DF5353', '#7798BF', '#aaeeee',
            '#ff0066', '#eeaaee', '#55BF3B', '#DF5353', '#7798BF', '#aaeeee'],
          chart: {
            backgroundColor: {
              linearGradient: [0, 0, 250, 500],
              stops: [
                [0, 'rgb(48, 96, 48)'],
                [1, 'rgb(0, 0, 0)']
              ]
            },
            borderColor: '#000000',
            borderWidth: 2,
            className: 'dark-container',
            //plotBackgroundColor: 'rgba(255, 255, 255, .1)',
            plotBorderColor: '#CCCCCC',
            plotBorderWidth: 1
          },

          title: {
            text: 'No data available',
            style: {
              color: '#C0C0C0',
              font: 'bold 16px "Trebuchet MS", Verdana, sans-serif'
            }
          },
          series: [{
            type: 'line',
            data: []
          }],
          lang: {
            noData: "Nichts anzuzeigen",
          },
          noData: {
            style: {
              fontWeight: 'bold',
              fontSize: '15px',
              color: '#303030'
            }
          }
        });
      });
    this.transactionService.getTransactionsById(companyId).subscribe(data => {
      console.info(data)
      this.readyNoData = true
      this.transactions = data;
    });

  }
}
