import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PendinganswersComponent } from './pendinganswers.component';

describe('PendinganswersComponent', () => {
  let component: PendinganswersComponent;
  let fixture: ComponentFixture<PendinganswersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PendinganswersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PendinganswersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
