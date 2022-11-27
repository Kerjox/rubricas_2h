import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CalcPersonsListAlumnosComponent } from './calc-persons-list-alumnos.component';

describe('CalcPersonsListAlumnosComponent', () => {
  let component: CalcPersonsListAlumnosComponent;
  let fixture: ComponentFixture<CalcPersonsListAlumnosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CalcPersonsListAlumnosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CalcPersonsListAlumnosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
