import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { User } from '../../services/user';
import { CreateUserRequest, UserResponse } from '../../models/user.model';

@Component({
  selector: 'app-user-create',
  imports: [FormsModule, CommonModule],
  templateUrl: './user-create.html',
  styleUrl: './user-create.css',
})
export class UserCreate implements OnInit {
  user: CreateUserRequest = {
    name: '',
    email: '',
    password: ''
  };

  successMessage = '';
  errorMessage = '';
  users: UserResponse[] = [];

  constructor(private userService: User) {}

  ngOnInit(): void {
    this.loadUsers();
  }

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

        this.loadUsers();
      },
      error: () => {
        this.errorMessage = 'Failed to create user. Please check backend service.';
      }
    });
  }

  loadUsers(): void {
    this.userService.getUsers().subscribe({
      next: (data) => {
        this.users = data;
      },
      error: () => {
        this.errorMessage = 'Failed to load users';
      }
    });
  }
}