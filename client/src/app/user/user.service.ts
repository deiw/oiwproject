import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UserData} from './user-data';
import {Observable} from 'rxjs';
import {User} from './user';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  public registerUser(data: UserData): Observable<User> {
    return this.http.post<User>(environment.userUrl, data);
  }
}
