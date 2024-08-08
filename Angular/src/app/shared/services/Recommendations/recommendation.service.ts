import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {DomSanitizer} from '@angular/platform-browser';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RecommendationService {


  private baseUrl = 'http://127.0.0.1:5000';


  constructor(private http: HttpClient, private sanitizer: DomSanitizer) { }

  recommend(desiredSkills: string[]): Observable<any> {
    const url = `${this.baseUrl}/recommend`;
    return this.http.post<any>(url, { skills: desiredSkills });
  }


}
