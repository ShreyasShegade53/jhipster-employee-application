import { IAddress, NewAddress } from './address.model';

export const sampleWithRequiredData: IAddress = {
  id: 9537,
};

export const sampleWithPartialData: IAddress = {
  id: 6549,
  line1: 'monthly fight',
  country: 'Niger',
  state: 'faithfully beyond mission',
  pincode: 1396,
};

export const sampleWithFullData: IAddress = {
  id: 21204,
  line1: 'who',
  line2: 'magnetize',
  country: 'Namibia',
  state: 'low reproachfully aside',
  city: 'Bowie',
  pincode: 18017,
};

export const sampleWithNewData: NewAddress = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
