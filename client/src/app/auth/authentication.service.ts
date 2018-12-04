import {Injectable} from '@angular/core';
import {tokenNotExpired} from 'angular2-jwt';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs/Observable';
import {SessionUser} from './session-user';

@Injectable()
export class AuthenticationService {

  public token: string;

  constructor(private http: HttpClient) {
  }

  getToken(): string {
    const currentUser = this.getCurrentUser();
    return currentUser && currentUser.token;
  }

  getCurrentUser(): SessionUser {
    return JSON.parse(localStorage.getItem('currentUser'));
  }

  getCurrentUserName(): string {
    return this.getCurrentUser().username;
  }

  isAuthenticated(): boolean {
    const token = this.getToken();
    return token && tokenNotExpired(null, token);
  }

  login(credentials, callback, errorCallback): void {
    this.getLoginResponse(credentials).subscribe(
      res => {
        let authHeader = res.headers.get('Authorization');
        console.log(res.headers);
        if (authHeader) {
          this.token = authHeader;
          localStorage.setItem('currentUser',
            JSON.stringify(<SessionUser>{username: credentials.username, token: this.token}));
        }
        return callback && callback();
      }, error => {
        return errorCallback && errorCallback(error);
      });
  }

  getLoginResponse(credentials): Observable<HttpResponse<any>> {
    var data = {username: credentials.username, password: credentials.password};
    return this.http.post(environment.loginUrl, data, {observe: 'response'});
  }

  logout(): void {
    this.token = null;
    localStorage.removeItem('currentUser');
  }
}
