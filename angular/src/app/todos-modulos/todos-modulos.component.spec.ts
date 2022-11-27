import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TodosModulosComponent } from './todos-modulos.component';

describe('TodosModulosComponent', () => {
  let component: TodosModulosComponent;
  let fixture: ComponentFixture<TodosModulosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TodosModulosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TodosModulosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
