import { TestBed } from '@angular/core/testing';

import { CantanteService } from './cantante.service';

describe('CantanteService', () => {
  let service: CantanteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CantanteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
