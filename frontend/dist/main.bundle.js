webpackJsonp(["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/about-page/about-page.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/about-page/about-page.component.html":
/***/ (function(module, exports) {

module.exports = "<div style=\"height:100vh; text-align:center; margin-top:25px; color: #fff\">  \n<h2 style=\"text-align:center;\">\n {{title}}\n</h2>\n<p style=\"text-align:justify;\">{{text}}</p>\n<h2 style=\"text-align:center;\">\n  {{title2}}\n </h2>\n <p style=\"text-align:justify;\">{{text2}}</p>\n</div>"

/***/ }),

/***/ "./src/app/about-page/about-page.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AboutPageComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__config__ = __webpack_require__("./src/app/config.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var AboutPageComponent = /** @class */ (function () {
    function AboutPageComponent() {
        var config = new __WEBPACK_IMPORTED_MODULE_1__config__["a" /* Config */]();
        this.text = config.getText();
        this.title = config.getTitle();
        this.text2 = config.getText2();
        this.title2 = config.getTitle2();
    }
    AboutPageComponent.prototype.ngOnInit = function () {
    };
    AboutPageComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-about-page',
            template: __webpack_require__("./src/app/about-page/about-page.component.html"),
            styles: [__webpack_require__("./src/app/about-page/about-page.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], AboutPageComponent);
    return AboutPageComponent;
}());



/***/ }),

/***/ "./src/app/app.component.css":
/***/ (function(module, exports) {

module.exports = ".jumbotron {\n    background-color: #999999;\n    color: #fff;\n    padding: 55px 25px 25px 100px;\n    font-family: Montserrat, sans-serif;\n    height:auto;\n    max-height:150%;\n    overflow:auto; \n}\n\n.jumbotron[_ngcontent-c0]{\n    color: black;\n}\n\n.bg-light {\n    background-color: #212529!important;\n}\n\n.navbar-light .navbar-text {\n    color: #ffffff;\n}\n"

/***/ }),

/***/ "./src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<nav class=\"navbar navbar-expand navbar-dark bg-dark fixed-top\">\n    <a class=\"navbar-brand\" style=\"color: white;\">SIM\n        <!-- <img alt=\"Brand\" src=\"...\"> -->\n    </a>\n    <div class=\"collapse navbar-collapse\">\n      <ul class=\"navbar-nav mr-auto\">\n        <li class=\"nav-item active\">\n          <a class=\"nav-link\" href=\"/home\">Home <span class=\"sr-only\">(current)</span></a>\n        </li>\n        <li class=\"nav-item\">\n          <a class=\"nav-link\" href='/login'>Login</a>\n        </li>\n        <li class=\"nav-item\">\n          <a class=\"nav-link\" href='/about'>About</a>\n        </li>\n      </ul>\n      <ul class=\"navbar-nav\">\n        <li class=\"nav-item\">\n          <a class=\"nav-link\" (click)=\"logout()\">Logout</a>\n        </li>\n      </ul>\n    </div>\n  </nav>\n  <div class=\"jumbotron\">\n      <div class=\"container\">\n         <!-- <button [hidden] = \"isOk\" mat-raised-button (click) = \"getPosts()\">Get Json</button>\n  <div *ngFor = \"let post of posts | async\">\n    {{post | json}}\n  </div> -->\n <router-outlet></router-outlet>\n      </div>\n      \n    </div>\n\n\n  <nav class=\"navbar fixed-bottom navbar-expand navbar-light bg-light\">\n      <div class=\"navbar-text m-auto\">Made by Firsov</div>\n    </nav>"

/***/ }),

/***/ "./src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_ngx_cookie_service__ = __webpack_require__("./node_modules/ngx-cookie-service/index.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var AppComponent = /** @class */ (function () {
    function AppComponent(router, cookieService) {
        this.router = router;
        this.cookieService = cookieService;
        this.title = 'app';
    }
    AppComponent.prototype.logout = function () {
        var _this = this;
        var cookies = this.cookieService.getAll();
        Object.keys(cookies).forEach(function (key) {
            _this.cookieService.delete(key);
        });
        // console.log("Logout");
        this.router.navigate(['/login']);
    };
    AppComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-root',
            template: __webpack_require__("./src/app/app.component.html"),
            styles: [__webpack_require__("./src/app/app.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_router__["a" /* Router */],
            __WEBPACK_IMPORTED_MODULE_2_ngx_cookie_service__["a" /* CookieService */]])
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__("./node_modules/@angular/platform-browser/esm5/platform-browser.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_forms__ = __webpack_require__("./node_modules/@angular/forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_http__ = __webpack_require__("./node_modules/@angular/http/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__app_component__ = __webpack_require__("./src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__home_page_home_page_component__ = __webpack_require__("./src/app/home-page/home-page.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__login_page_login_page_component__ = __webpack_require__("./src/app/login-page/login-page.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_angular2_highcharts__ = __webpack_require__("./node_modules/angular2-highcharts/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_angular2_highcharts___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_9_angular2_highcharts__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10_ngx_cookie_service__ = __webpack_require__("./node_modules/ngx-cookie-service/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__modules_auth_auth_service__ = __webpack_require__("./src/app/modules/auth/auth.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__modules_company_company_service__ = __webpack_require__("./src/app/modules/company/company.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__modules_transaction_transaction_service__ = __webpack_require__("./src/app/modules/transaction/transaction.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__modules_insider_insider_service__ = __webpack_require__("./src/app/modules/insider/insider.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15_ng_auto_complete__ = __webpack_require__("./node_modules/ng-auto-complete/ng-autocomplete.esm.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_16__about_page_about_page_component__ = __webpack_require__("./src/app/about-page/about-page.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_17_ngx_pagination__ = __webpack_require__("./node_modules/ngx-pagination/dist/ngx-pagination.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_18__modules_stock_chart_data_stock_chart_data_service__ = __webpack_require__("./src/app/modules/stock-chart-data/stock-chart-data.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



















var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["NgModule"])({
            declarations: [
                __WEBPACK_IMPORTED_MODULE_6__app_component__["a" /* AppComponent */],
                __WEBPACK_IMPORTED_MODULE_7__home_page_home_page_component__["a" /* HomePageComponent */],
                __WEBPACK_IMPORTED_MODULE_8__login_page_login_page_component__["a" /* LoginPageComponent */],
                __WEBPACK_IMPORTED_MODULE_16__about_page_about_page_component__["a" /* AboutPageComponent */]
            ],
            imports: [
                __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_forms__["a" /* FormsModule */],
                __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["b" /* HttpClientModule */],
                __WEBPACK_IMPORTED_MODULE_5__angular_http__["b" /* HttpModule */],
                __WEBPACK_IMPORTED_MODULE_9_angular2_highcharts__["ChartModule"].forRoot(__webpack_require__("./node_modules/highcharts/highstock.js"), __webpack_require__("./node_modules/highcharts/modules/exporting.js"), __webpack_require__("./node_modules/highcharts/modules/no-data-to-display.js")
                //require('highcharts/highcharts-more')
                ),
                __WEBPACK_IMPORTED_MODULE_15_ng_auto_complete__["b" /* NgAutoCompleteModule */],
                __WEBPACK_IMPORTED_MODULE_3__angular_router__["b" /* RouterModule */].forRoot([
                    { path: "about", component: __WEBPACK_IMPORTED_MODULE_16__about_page_about_page_component__["a" /* AboutPageComponent */] },
                    { path: "login", component: __WEBPACK_IMPORTED_MODULE_8__login_page_login_page_component__["a" /* LoginPageComponent */] },
                    { path: "home", component: __WEBPACK_IMPORTED_MODULE_7__home_page_home_page_component__["a" /* HomePageComponent */] },
                    { path: "", component: __WEBPACK_IMPORTED_MODULE_7__home_page_home_page_component__["a" /* HomePageComponent */] }
                ]),
                __WEBPACK_IMPORTED_MODULE_17_ngx_pagination__["a" /* NgxPaginationModule */],
            ],
            providers: [
                __WEBPACK_IMPORTED_MODULE_10_ngx_cookie_service__["a" /* CookieService */],
                __WEBPACK_IMPORTED_MODULE_11__modules_auth_auth_service__["a" /* AuthService */],
                __WEBPACK_IMPORTED_MODULE_12__modules_company_company_service__["a" /* CompanyService */],
                __WEBPACK_IMPORTED_MODULE_13__modules_transaction_transaction_service__["a" /* TransactionService */],
                __WEBPACK_IMPORTED_MODULE_14__modules_insider_insider_service__["a" /* InsiderService */],
                __WEBPACK_IMPORTED_MODULE_18__modules_stock_chart_data_stock_chart_data_service__["a" /* StockChartDataService */]
            ],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_6__app_component__["a" /* AppComponent */]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/config.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Config; });
var Config = /** @class */ (function () {
    function Config() {
    }
    Config.prototype.getRest = function () {
        // return "http://rest.metraf.eu"
        return "http://10.5.0.5:8080";
    };
    Config.prototype.getTitle = function () {
        return "What is SIM?";
    };
    Config.prototype.getText = function () {
        return "SIM (short for Simple Insiders Monitoring)is a convenient, inexpensive and trusth-worthy information platform for stock market movement. This web-based app provides users with the most up-to-date stock transactions made by insiders of the biggest companies worldwide, which undeniably impact the status of world economy. For each company the sale table describes in details each stock trade in term of insider, date, type of transaction, the number of stocks, value etc. Hence, this tool would be helpful for users in accumulating information, analysing and making investment decisions.  ";
    };
    Config.prototype.getTitle2 = function () {
        return "How to use?";
    };
    Config.prototype.getText2 = function () {
        return "With just a few simple steps: create an account, confirm email, sign it in and you are good to go.";
    };
    return Config;
}());



/***/ }),

/***/ "./src/app/home-page/home-page.component.css":
/***/ (function(module, exports) {

module.exports = "ng-autocomplete {\n    margin: 10px;\n}\n\nchart {\n    width: 100% !important;\n    margin: 0 auto;\n    display: block;\n}\n\ntable {\n    margin-top: 10px;\n    text-align: left;\n}\n\ntd, th {\n    border: 1px solid #2c5836;\n    padding: 8px;\n}\n\n.table thead th{\n    border: 1px solid #2c5836;\n}\n\n.pagination-next{\n    display: inline !important;\n}\n\npagination-controls .my-pagination{\n    width: 500px !important;\n  }\n\n/*.ngx-pagination .current{\n    padding: 5px;\n    background: #2c5836 !important;\n}*/\n\n\n\n\n"

/***/ }),

/***/ "./src/app/home-page/home-page.component.html":
/***/ (function(module, exports) {

module.exports = "<div style=\"text-align:center\">\n    <ng-autocomplete style=\"margin-top: 0px;height: 0px 1important;\" (selected)=\"Selected($event)\" class=\"ng-autocomplete-dropdown ng-auto-complete\" [group]=\"group\"></ng-autocomplete>\n    <div id=\"chart\">\n        <chart *ngIf=\"ready\" type=\"StockChart\" [options]=\"options\"></chart>\n    </div>\n    \n    <table *ngIf=\"ready || readyNoData\" class=\"table table-hover\">\n        <thead>\n            <tr>\n                <th>Insider</th>\n                <th>Relation</th>\n                <th>Trade Date</th>\n                <th>Transaction</th>\n                <th>Security</th>\n                <th>Shares</th>\n                <th>Price</th>\n                <th>Value USD</th>\n            </tr>\n        </thead>\n        <tbody>\n            <tr *ngFor=\"let transaction of transactions | paginate: { itemsPerPage: 5, currentPage: p }; let i = index\">\n                <td>{{transaction.insider.name}}</td>\n                <td>{{transaction.insider.relation.officerTitle}}</td>\n                <td>{{transaction.transactionInfo.date | date: 'dd/MM/yyyy'}}</td>\n                <td title=\"{{transaction.transactionInfo.transactionType.description}}\">{{transaction.transactionInfo.transactionType.label}}</td>\n                <td>{{transaction.transactionInfo.security}}</td>\n                <td>{{transaction.transactionInfo.shares}}</td>\n                <td>{{transaction.transactionInfo.price}}</td>\n                <td>{{transaction.transactionInfo.valueUSD.toFixed(2)}}</td>\n                <!-- <td>{{transaction.transactionInfo.price * transaction.transactionInfo.shares}}</td> -->\n            </tr>\n        </tbody>\n        <pagination-controls class=\"my-pagination\" (pageChange)=\"p = $event\" directionLinks=\"false\"></pagination-controls>\n    </table>\n</div>\n\n<!-- | filter : searchText\" -->\n"

/***/ }),

/***/ "./src/app/home-page/home-page.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return HomePageComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_http__ = __webpack_require__("./node_modules/@angular/http/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__modules_auth_auth_service__ = __webpack_require__("./src/app/modules/auth/auth.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__modules_company_company_service__ = __webpack_require__("./src/app/modules/company/company.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_ng_auto_complete__ = __webpack_require__("./node_modules/ng-auto-complete/ng-autocomplete.esm.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_highcharts__ = __webpack_require__("./node_modules/highcharts/highcharts.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_highcharts___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_7_highcharts__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_highcharts_highcharts_more__ = __webpack_require__("./node_modules/highcharts/highcharts-more.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_highcharts_highcharts_more___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_8_highcharts_highcharts_more__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__modules_transaction_transaction_service__ = __webpack_require__("./src/app/modules/transaction/transaction.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__modules_stock_chart_data_stock_chart_data_service__ = __webpack_require__("./src/app/modules/stock-chart-data/stock-chart-data.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};











var HomePageComponent = /** @class */ (function () {
    //chart = new Highcharts.Chart(this.options);
    function HomePageComponent(httpClient, http, router, authService, companyService, transactionService, stockChartDataService) {
        var _this = this;
        this.httpClient = httpClient;
        this.http = http;
        this.router = router;
        this.authService = authService;
        this.companyService = companyService;
        this.transactionService = transactionService;
        this.stockChartDataService = stockChartDataService;
        this.ROOT_URL = 'http://rest.metraf.eu/permissions';
        this.ready = false;
        this.readyNoData = false;
        this.group = [];
        this.p = 1;
        companyService.getCompanies().subscribe(function (res) {
            _this.group = [
                Object(__WEBPACK_IMPORTED_MODULE_6_ng_auto_complete__["a" /* CreateNewAutocompleteGroup */])('Search / choose in / from list', 'completer', res, { titleKey: 'name', childrenKey: 'symbol' }),
            ];
        });
    }
    HomePageComponent.prototype.Selected = function (item) {
        var company = item.item.original;
        this.createChart(company.id);
        //this.chartDataService.getChartDataById(company.id).subscribe(res => {
        //this.chart.series[0].setData(res,true);
        // })
    };
    HomePageComponent.prototype.saveInstance = function (chartInstance) {
        this.chart = chartInstance;
    };
    HomePageComponent.prototype.ngOnInit = function () {
        var _this = this;
        return this.httpClient
            .get(this.ROOT_URL, { headers: this.authService.getHeader() })
            .subscribe(function (data) {
            _this.router.navigate(['/home']);
            _this.createChart(320193);
            console.log("Status is ok");
        }, function (err) {
            _this.router.navigate(['/login']);
        });
    };
    HomePageComponent.prototype.createChart = function (companyId) {
        var _this = this;
        this.ready = false;
        this.stockChartDataService.getChartDataById(companyId).subscribe(function (res) {
            _this.ready = true;
            _this.options = {
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
                        lineColor: '#00ff00',
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
                    buttonTheme: {
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
        }, function (err) {
            _this.noDataChart = __WEBPACK_IMPORTED_MODULE_7_highcharts__["chart"]('chart', {
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
        this.transactionService.getTransactionsById(companyId).subscribe(function (data) {
            console.info(data);
            _this.readyNoData = true;
            _this.transactions = data;
        });
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_6_ng_auto_complete__["c" /* NgAutocompleteComponent */]),
        __metadata("design:type", __WEBPACK_IMPORTED_MODULE_6_ng_auto_complete__["c" /* NgAutocompleteComponent */])
    ], HomePageComponent.prototype, "completer", void 0);
    HomePageComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-home-page',
            template: __webpack_require__("./src/app/home-page/home-page.component.html"),
            styles: [__webpack_require__("./src/app/home-page/home-page.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["a" /* HttpClient */],
            __WEBPACK_IMPORTED_MODULE_3__angular_http__["a" /* Http */],
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["a" /* Router */],
            __WEBPACK_IMPORTED_MODULE_4__modules_auth_auth_service__["a" /* AuthService */],
            __WEBPACK_IMPORTED_MODULE_5__modules_company_company_service__["a" /* CompanyService */],
            __WEBPACK_IMPORTED_MODULE_9__modules_transaction_transaction_service__["a" /* TransactionService */],
            __WEBPACK_IMPORTED_MODULE_10__modules_stock_chart_data_stock_chart_data_service__["a" /* StockChartDataService */]])
    ], HomePageComponent);
    return HomePageComponent;
}());



/***/ }),

/***/ "./src/app/login-page/login-page.component.css":
/***/ (function(module, exports) {

module.exports = ".jumbotron {\n    background-color: #999999;\n    color: #fff;\n    padding: 100px 25px;\n    font-family: Montserrat, sans-serif;\n}\n.form-signin\n{\n    max-width: 330px;\n    padding: 15px;\n    margin: 0 auto;\n}\n.form-signin .form-control\n{\n    position: relative;\n    font-size: 16px;\n    height: auto;\n    padding: 10px;\n    -webkit-box-sizing: border-box;\n    box-sizing: border-box;\n}\n.btn-primary{\n    color: #fff;\n    background-color: #2c5836;\n    border-color: #2c5836\n}\ninput.ng-invalid.ng-dirty{\n    border: 3px solid red;\n}\n.help-block {\n    font-size: 12px;\n    color: red;\n}"

/***/ }),

/***/ "./src/app/login-page/login-page.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"jumbotron\" style=\"height:100vh;\">\n  <!-- *ngIf=\"isOk\" -->\n  <form (ngSubmit)=\"onSubmit()\" class=\"form-signin\" name=\"regForm\" #f=\"ngForm\" novalidate>\n\n    <div class=\"form-group\">\n      <label>Email</label>\n      <input type=\"email\" name=\"email\" class=\"form-control\" [(ngModel)]=\"user.email\" required #uname=\"ngModel\">\n      <div *ngIf=\"f.submitted && uname.invalid\" class=\"help-block\">\n        Email is required.\n      </div>\n    </div>\n    <div class=\"form-group\">\n      <label>Password</label>\n      <input type=\"password\" name=\"password\" class=\"form-control\" [(ngModel)]=\"user.password\" required #password=\"ngModel\">\n      <div *ngIf=\"f.submitted && password.invalid\" class=\"help-block\">\n        Password is required.\n      </div>\n    </div>\n    <div *ngIf=\"!isValidFormSubmitted\" class=\"help-block\">\n      Email or password is not valid.\n    </div>\n    <button type=\"submit\" class=\"btn btn-lg btn-primary btn-block\">Submit</button>\n  </form>\n</div>"

/***/ }),

/***/ "./src/app/login-page/login-page.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LoginPageComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__modules_auth_auth_service__ = __webpack_require__("./src/app/modules/auth/auth.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var LoginPageComponent = /** @class */ (function () {
    function LoginPageComponent(http, router, authService) {
        this.http = http;
        this.router = router;
        this.authService = authService;
        this.user = {};
        this.isValidFormSubmitted = true;
    }
    LoginPageComponent.prototype.onSubmit = function (user) {
        var _this = this;
        this.http.get('http://rest.metraf.eu/permissions', { headers: { "Authorization": "Basic " + btoa(this.user.email + ":" + this.user.password), "Content-Type": "application/json" } }).subscribe(function (response) {
            //this.http.get('http://localhost:8080/permissions', { headers: { "Authorization": "Basic " + btoa(this.user.email + ":" + this.user.password), "Content-Type": "application/json" } }).subscribe(response => {
            _this.authService.saveUser(_this.user);
            _this.router.navigate(['/home']);
        }, function (err) {
            console.log("User authentication failed!");
            _this.isValidFormSubmitted = false;
        });
    };
    LoginPageComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-login-page',
            template: __webpack_require__("./src/app/login-page/login-page.component.html"),
            styles: [__webpack_require__("./src/app/login-page/login-page.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["a" /* HttpClient */],
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["a" /* Router */],
            __WEBPACK_IMPORTED_MODULE_3__modules_auth_auth_service__["a" /* AuthService */]])
    ], LoginPageComponent);
    return LoginPageComponent;
}());



/***/ }),

/***/ "./src/app/modules/auth/auth.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AuthService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ngx_cookie_service__ = __webpack_require__("./node_modules/ngx-cookie-service/index.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var AuthService = /** @class */ (function () {
    function AuthService(cookieService) {
        this.cookieService = cookieService;
    }
    AuthService.prototype.getUser = function () {
        if (this.cookieService.check("user")) {
            try {
                return JSON.parse(this.cookieService.get("user"));
            }
            catch (e) {
                console.error(e);
            }
        }
        return { email: "", password: "" };
    };
    AuthService.prototype.getHeader = function () {
        var user = this.getUser();
        return {
            "Authorization": "Basic " + btoa(user.email + ":" + user.password),
            "Content-Type": "application/json"
        };
    };
    AuthService.prototype.saveUser = function (user) {
        this.cookieService.delete("user");
        this.cookieService.set("user", JSON.stringify(user));
    };
    AuthService.prototype.deleteUser = function () {
        this.cookieService.delete("user");
    };
    AuthService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ngx_cookie_service__["a" /* CookieService */]])
    ], AuthService);
    return AuthService;
}());



/***/ }),

/***/ "./src/app/modules/company/company.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CompanyService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__auth_auth_service__ = __webpack_require__("./src/app/modules/auth/auth.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__config__ = __webpack_require__("./src/app/config.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_rxjs_Subject__ = __webpack_require__("./node_modules/rxjs/_esm5/Subject.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var CompanyService = /** @class */ (function () {
    function CompanyService(httpClient, authService) {
        this.httpClient = httpClient;
        this.authService = authService;
        var config = new __WEBPACK_IMPORTED_MODULE_3__config__["a" /* Config */]();
        this.url = config.getRest();
    }
    CompanyService.prototype.getCompanies = function () {
        var subject = new __WEBPACK_IMPORTED_MODULE_4_rxjs_Subject__["a" /* Subject */]();
        this.httpClient.get(this.url + "/company", { headers: this.authService.getHeader() }).subscribe(function (response) {
            subject.next(response);
        }, function (error) {
            subject.error(error);
        });
        return subject.asObservable();
    };
    CompanyService.prototype.getCompanyById = function (id) {
        var subject = new __WEBPACK_IMPORTED_MODULE_4_rxjs_Subject__["a" /* Subject */]();
        this.httpClient.get(this.url + "/company/" + id, { observe: 'response', headers: this.authService.getHeader() }).subscribe(function (response) {
            subject.next(response.body);
        }, function (error) {
            subject.error(error);
        });
        return subject.asObservable();
    };
    CompanyService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["a" /* HttpClient */],
            __WEBPACK_IMPORTED_MODULE_2__auth_auth_service__["a" /* AuthService */]])
    ], CompanyService);
    return CompanyService;
}());



/***/ }),

/***/ "./src/app/modules/insider/insider.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return InsiderService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__auth_auth_service__ = __webpack_require__("./src/app/modules/auth/auth.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__config__ = __webpack_require__("./src/app/config.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_rxjs_Subject__ = __webpack_require__("./node_modules/rxjs/_esm5/Subject.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var InsiderService = /** @class */ (function () {
    function InsiderService(httpClient, authService) {
        this.httpClient = httpClient;
        this.authService = authService;
        var config = new __WEBPACK_IMPORTED_MODULE_3__config__["a" /* Config */]();
        this.url = config.getRest();
    }
    InsiderService.prototype.getInsidersById = function (id) {
        var subject = new __WEBPACK_IMPORTED_MODULE_4_rxjs_Subject__["a" /* Subject */]();
        this.httpClient.get(this.url + "/insider/" + id, { headers: this.authService.getHeader() }).subscribe(function (response) {
            subject.next(response);
        }, function (error) {
            subject.error(error);
        });
        return subject.asObservable();
    };
    InsiderService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["a" /* HttpClient */],
            __WEBPACK_IMPORTED_MODULE_2__auth_auth_service__["a" /* AuthService */]])
    ], InsiderService);
    return InsiderService;
}());



/***/ }),

/***/ "./src/app/modules/stock-chart-data/stock-chart-data.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return StockChartDataService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__auth_auth_service__ = __webpack_require__("./src/app/modules/auth/auth.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__config__ = __webpack_require__("./src/app/config.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_rxjs_Subject__ = __webpack_require__("./node_modules/rxjs/_esm5/Subject.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var StockChartDataService = /** @class */ (function () {
    function StockChartDataService(httpClient, authService) {
        this.httpClient = httpClient;
        this.authService = authService;
        var config = new __WEBPACK_IMPORTED_MODULE_3__config__["a" /* Config */]();
        this.url = config.getRest();
    }
    StockChartDataService.prototype.getChartDataById = function (companyId) {
        var subject = new __WEBPACK_IMPORTED_MODULE_4_rxjs_Subject__["a" /* Subject */]();
        this.httpClient.get(this.url + "/stock/chartData/" + companyId, { headers: this.authService.getHeader() }).subscribe(function (response) {
            subject.next(response);
        }, function (error) {
            subject.error(error);
        });
        return subject.asObservable();
    };
    StockChartDataService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["a" /* HttpClient */],
            __WEBPACK_IMPORTED_MODULE_2__auth_auth_service__["a" /* AuthService */]])
    ], StockChartDataService);
    return StockChartDataService;
}());



/***/ }),

/***/ "./src/app/modules/transaction/transaction.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TransactionService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__auth_auth_service__ = __webpack_require__("./src/app/modules/auth/auth.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__config__ = __webpack_require__("./src/app/config.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_rxjs_Subject__ = __webpack_require__("./node_modules/rxjs/_esm5/Subject.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var TransactionService = /** @class */ (function () {
    function TransactionService(httpClient, authService) {
        this.httpClient = httpClient;
        this.authService = authService;
        var config = new __WEBPACK_IMPORTED_MODULE_3__config__["a" /* Config */]();
        this.url = config.getRest();
    }
    TransactionService.prototype.getTransactionsById = function (id) {
        var subject = new __WEBPACK_IMPORTED_MODULE_4_rxjs_Subject__["a" /* Subject */]();
        this.httpClient.get(this.url + "/transactions/" + id, { headers: this.authService.getHeader() }).subscribe(function (response) {
            subject.next(response);
        }, function (error) {
            subject.error(error);
        });
        return subject.asObservable();
    };
    TransactionService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["a" /* HttpClient */],
            __WEBPACK_IMPORTED_MODULE_2__auth_auth_service__["a" /* AuthService */]])
    ], TransactionService);
    return TransactionService;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
var environment = {
    production: false
};


/***/ }),

/***/ "./src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("./node_modules/@angular/platform-browser-dynamic/esm5/platform-browser-dynamic.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_app_module__ = __webpack_require__("./src/app/app.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("./src/environments/environment.ts");




if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["enableProdMode"])();
}
Object(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_app_module__["a" /* AppModule */])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("./src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map