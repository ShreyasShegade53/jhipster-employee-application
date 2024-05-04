import { Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'address',
    data: { pageTitle: 'Addresses' },
    loadChildren: () => import('./address/address.routes'),
  },
  {
    path: 'employee',
    data: { pageTitle: 'Employees' },
    loadChildren: () => import('./employee/employee.routes'),
  },
  /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
];

export default routes;
