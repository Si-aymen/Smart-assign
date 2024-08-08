import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Projects } from 'src/app/shared/models/Projects/projects';
import { ProjectsService } from 'src/app/shared/services/Projects/projects.service';
import { TasksService } from 'src/app/shared/services/Tasks/tasks.service';

@Component({
  selector: 'app-task-form',
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.scss']
})
export class TaskFormComponent {
  TaskForm: FormGroup;
  CurrentProjectID: string;
  CurrentProject: any;


  constructor(
    private taskService: TasksService,
    private router: Router,
    private route: ActivatedRoute,
		private projectsService: ProjectsService,
  ) { }


  ngOnInit() {

    this.FormInit();
    this.getProject();

  }

  FormInit() {

    this.TaskForm = new FormGroup({
      name: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
      status: new FormControl('', Validators.required),
      finishDate: new FormControl('', Validators.required),

    });
  }

  onSubmit(): void {
    if (this.TaskForm.valid) {
      const newTask: Task = this.TaskForm.value;
      this.taskService.register(newTask);
    } else {
      alert('Please fill in all required fields.');
    }
  }

  getProject() {
    
    this.route.params.subscribe(params => {
      this.CurrentProjectID = params['id'];
      this.projectsService.getProjectByID(this.CurrentProjectID).subscribe(
        (project: Projects) => {
          this.CurrentProject = project;
        },
        (error) => {
          console.error('Error fetching project:', error);
        }
      );
    });
  }


  assignNewTask() {
    const newTask: Task = this.TaskForm.value;
    this.taskService.assignNewTaskToProject(this.CurrentProjectID, newTask).subscribe(
      response => {
        console.log(response); // Handle the success response
      },
      error => {
        console.error('Error:', error); // Handle the error response
      }
    );
  }




}
