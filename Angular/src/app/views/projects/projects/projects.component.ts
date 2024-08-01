import { Component } from '@angular/core';
import { ProjectsService } from 'src/app/shared/services/Projects/projects.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Projects } from 'src/app/shared/models/Projects/projects';
import { of } from 'rxjs';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.scss']
})
export class ProjectsComponent {
  projectForm: FormGroup;
  projects$:any ;

  constructor(
    private projectService: ProjectsService
  ) { }

  ngOnInit() {
    this.projectForm = new FormGroup({
      name: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
      status: new FormControl('', Validators.required),
      domain: new FormControl('', Validators.required),
      startDate: new FormControl('', Validators.required),
      endDate: new FormControl('', Validators.required),

    });
    this.loadProjects();
  }

  loadProjects(): void {
    this.projectService.getProjects().subscribe({
      next: (projects: Projects[]) => {
        this.projects$ = of(projects);

      },
      error: (error) => {
        console.error('There was an error loading internships:', error);
      }
    });
  }

  onSubmit(): void {
    if (this.projectForm.valid) {
      const newTransport: Projects = this.projectForm.value;
      this.projectService.register(newTransport);
      this.loadProjects();
    } else {
      alert('Please fill in all required fields.');
    }
  }



}
