import { IEmployee, NewEmployee } from './employee.model';

export const sampleWithRequiredData: IEmployee = {
  id: 13364,
};

export const sampleWithPartialData: IEmployee = {
  id: 15480,
  lastName: 'Leffler',
  email: 'Deanna71@gmail.com',
  phoneNumber: 'rearm',
};

export const sampleWithFullData: IEmployee = {
  id: 21648,
  firstName: 'Chase',
  lastName: 'Lakin',
  email: 'Raoul_Effertz@yahoo.com',
  phoneNumber: 'feather',
};

export const sampleWithNewData: NewEmployee = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
