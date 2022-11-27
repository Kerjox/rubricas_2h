import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListAlumnosCursoComponent } from './list-alumnos-curso.component';

describe('ListAlumnosCursoComponent', () => {
  let component: ListAlumnosCursoComponent;
  let fixture: ComponentFixture<ListAlumnosCursoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListAlumnosCursoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListAlumnosCursoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
