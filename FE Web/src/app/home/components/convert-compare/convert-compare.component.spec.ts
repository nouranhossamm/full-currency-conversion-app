import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConvertCompareComponent } from './convert-compare.component';

describe('ConvertCompareComponent', () => {
  let component: ConvertCompareComponent;
  let fixture: ComponentFixture<ConvertCompareComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ConvertCompareComponent]
    });
    fixture = TestBed.createComponent(ConvertCompareComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
