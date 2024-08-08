import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {DomSanitizer} from '@angular/platform-browser';
import {Observable} from 'rxjs';
import { Projects } from '../../models/Projects/projects';

@Injectable({
  providedIn: 'root'
})
export class ProjectsService {
  private baseUrl = 'http://localhost:8089/api/Projects';

  constructor(private http: HttpClient, private sanitizer: DomSanitizer) { }

  getProjects(): Observable<Projects[]> {
    return this.http.get<Projects[]>(`${this.baseUrl}/GetAll/Projects`);
  }


  register(project: Projects) {
    const bodyData = project;

    this.http.post(`${this.baseUrl}/add-project`, bodyData, { responseType: 'text' })
      .subscribe((resultData: any) => {
        console.log(resultData);
        alert("Project Registered Successfully");
      });
  }

  getProjectByID(id:string) : Observable<Projects> {
    return this.http.get<Projects>(`${this.baseUrl}/GetByID/${id}`);
  }


}
