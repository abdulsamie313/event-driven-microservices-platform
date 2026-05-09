import { Routes } from '@angular/router';
import { UserCreate } from './pages/user-create/user-create';
import { Notifications } from './pages/notifications/notifications';
import { Analytics } from './pages/analytics/analytics';

export const routes: Routes = [
  {
    path: '',
    component: UserCreate
  },
  {
    path: 'notifications',
    component: Notifications
  },
  {
    path: 'analytics',
    component: Analytics
  }
];