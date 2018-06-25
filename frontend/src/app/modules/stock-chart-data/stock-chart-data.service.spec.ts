import { TestBed, inject } from '@angular/core/testing';

import { StockChartDataService } from './stock-chart-data.service';

describe('StockChartDataService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [StockChartDataService]
    });
  });

  it('should be created', inject([StockChartDataService], (service: StockChartDataService) => {
    expect(service).toBeTruthy();
  }));
});
