import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FilterCursoComponent } from './filter-curso.component';

describe('FilterCursoComponent', () => {
  let component: FilterCursoComponent;
  let fixture: ComponentFixture<FilterCursoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FilterCursoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FilterCursoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
