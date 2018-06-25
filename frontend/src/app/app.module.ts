import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http'
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { ChartModule } from 'angular2-highcharts';
import { CookieService } from 'ngx-cookie-service';
import { AuthService } from './modules/auth/auth.service';
import { CompanyService } from './modules/company/company.service';
import { TransactionService } from './modules/transaction/transaction.service';
import { InsiderService } from './modules/insider/insider.service';
import {NgAutoCompleteModule} from "ng-auto-complete";
import { AboutPageComponent } from './about-page/about-page.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { StockChartDataService } from './modules/stock-chart-data/stock-chart-data.service';

declare var require: any;

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    LoginPageComponent,
    AboutPageComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    HttpModule,
    ChartModule.forRoot(require('highcharts/highstock'), 
    require('highcharts/modules/exporting'),
    require('highcharts/modules/no-data-to-display.js')
    //require('highcharts/highcharts-more')
  ),
    NgAutoCompleteModule,
    RouterModule.forRoot([
      { path: "about", component: AboutPageComponent },
      { path: "login", component: LoginPageComponent },
      { path: "home", component: HomePageComponent },
      { path: "", component: HomePageComponent }
    ]),
    NgxPaginationModule,
  ],
  providers: [
    CookieService,
    AuthService,
    CompanyService,
    TransactionService,
    InsiderService,
    StockChartDataService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
