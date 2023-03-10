import { TestBed } from '@angular/core/testing';

import { InteRaptorInterceptor } from './inte-raptor.interceptor';

describe('InteRaptorInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      InteRaptorInterceptor
      ]
  }));

  it('should be created', () => {
    const interceptor: InteRaptorInterceptor = TestBed.inject(InteRaptorInterceptor);
    expect(interceptor).toBeTruthy();
  });
});
