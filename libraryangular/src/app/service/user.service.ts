import { Injectable, Inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user';
import { Observable } from 'rxjs';

@Injectable()
export class UserService {

  private usersUrl: string;

  constructor(@Inject(String) private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/users';
  }

  /*
  The findAll() method performs a GET HTTP request to the 
  http://localhost:8080/users endpoint via Angular’s HttpClient.
  The method returns an Observable instance that holds an array of User objects.
  */
  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }

  //save() method performs a POST HTTP request to the http://localhost:8080/users endpoint.
  public save(user: User) {
    return this.http.post<User>(this.usersUrl, user);
  }
}
