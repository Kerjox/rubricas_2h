import { Curso } from './curso';

describe('Curso', () => {
  it('should create an instance', () => {
    expect(new Curso(1, 'Curso Test', 'BT0')).toBeTruthy();
  });
});
