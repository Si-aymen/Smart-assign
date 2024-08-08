import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProjectsComponent } from './projects/projects.component';
import { ProjectDetailsComponent } from './project-details/project-details.component';
import { TaskFormComponent } from '../task/task-form/task-form.component';

const routes: Routes = [
  {
    path: 'AllProjects',
    component: ProjectsComponent
  },
  {
    path: 'details/:id',
    component: ProjectDetailsComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProjectsRoutingModule { }
