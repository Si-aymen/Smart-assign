import { Injectable } from '@angular/core';
import {DomSanitizer} from '@angular/platform-browser';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TasksService {
  private baseUrl = 'http://localhost:8089/api/Tasks';


  constructor(private http: HttpClient, private sanitizer: DomSanitizer) { }

  
  getProjects(): Observable<Task[]> {
    return this.http.get<Task[]>(`${this.baseUrl}/GetAll/Projects`);
  }


  register(task: Task) {
    const bodyData = task;

    this.http.post(`${this.baseUrl}/add-Task`, bodyData, { responseType: 'text' })
      .subscribe((resultData: any) => {
        console.log(resultData);
        alert("Task Registered Successfully");
      });
  }

  assignTaskToProject(projectID: string, taskID: string): Observable<string> {
    const url = `${this.baseUrl}/${projectID}/tasks/${taskID}/assign`;
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    return this.http.post<string>(url, {}, { headers })
      .pipe(
        catchError(this.handleError)
      );
  }

  // Error handling
  private handleError(error: any): Observable<never> {
    console.error('An error occurred:', error);
    return throwError('Something went wrong; please try again later.');
  }

  assignNewTaskToProject(projectID: string, task: Task): Observable<string> {
    const url = `${this.baseUrl}/${projectID}/tasks/assign`;
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    return this.http.post<string>(url, task, { headers })
      .pipe(
        catchError(this.handleError)
      );
  }




}
