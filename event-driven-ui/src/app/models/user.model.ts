export interface CreateUserRequest {
  name: string;
  email: string;
  password: string;
}

export interface UserResponse {
  userId?: number;
  id?: number;
  name: string;
  email: string;
}