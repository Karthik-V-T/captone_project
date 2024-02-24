import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingquestionsComponent } from './pendingquestions.component';

describe('PendingquestionsComponent', () => {
  let component: PendingquestionsComponent;
  let fixture: ComponentFixture<PendingquestionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PendingquestionsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PendingquestionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
