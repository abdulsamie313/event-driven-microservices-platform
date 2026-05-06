import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { User } from '../../services/user';
import { CreateUserRequest } from '../../models/user.model';

@Component({
  selector: 'app-user-create',
  imports: [FormsModule],
  templateUrl: './user-create.html',
  styleUrl: './user-create.css',
})
export class UserCreate {
  user: CreateUserRequest = {
    name: '',
    email: '',
    password: ''
  };

  successMessage = '';
  errorMessage = '';

  constructor(private userService: User) {}

  createUser(): void {
    this.successMessage = '';
    this.errorMessage = '';

    this.userService.createUser(this.user).subscribe({
      next: () => {
        this.successMessage = 'User created successfully. Kafka event published.';
        this.user = {
          name: '',
          email: '',
          password: ''
        };
      },
      error: () => {
        this.errorMessage = 'Failed to create user. Please check backend service.';
      }
    });
  }
}