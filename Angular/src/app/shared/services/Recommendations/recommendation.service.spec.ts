import { TestBed } from '@angular/core/testing';

import { RecommendationService } from '../../../shared/services/Recommendations/recommendation.service';

describe('RecommendationService', () => {
  let service: RecommendationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RecommendationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
