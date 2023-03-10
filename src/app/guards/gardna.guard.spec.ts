import { TestBed } from '@angular/core/testing';

import { GardnaGuard } from './gardna.guard';

describe('GardnaGuard', () => {
  let guard: GardnaGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(GardnaGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
