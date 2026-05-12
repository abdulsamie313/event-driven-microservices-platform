import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CreateUserRequest, UserResponse } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class User {
  private apiUrl = 'http://user-service.localtest.me:8088/users';

  constructor(private http: HttpClient) { }

  createUser(request: CreateUserRequest): Observable<UserResponse> {
    return this.http.post<UserResponse>(this.apiUrl, request);
  }

  getUsers(): Observable<UserResponse[]> {
    return this.http.get<UserResponse[]>(this.apiUrl);
  }
}