import { TestBed, inject } from '@angular/core/testing';

import { InsiderService } from './insider.service';

describe('InsiderService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [InsiderService]
    });
  });

  it('should be created', inject([InsiderService], (service: InsiderService) => {
    expect(service).toBeTruthy();
  }));
});
