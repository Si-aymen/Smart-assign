import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProjectsRoutingModule } from './projects-routing.module';

import { NgxEchartsModule } from 'ngx-echarts';
import { SharedComponentsModule } from 'src/app/shared/components/shared-components.module';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ProjectsComponent } from './projects/projects.component';
import { AppFormsModule } from '../forms/forms.module';
import { ReactiveFormsModule } from '@angular/forms';
import { ProjectDetailsComponent } from './project-details/project-details.component';


@NgModule({
  declarations: [ProjectsComponent,ProjectDetailsComponent],
  imports: [
    CommonModule,
    SharedComponentsModule,
    ProjectsRoutingModule,
    NgxEchartsModule,
    NgxDatatableModule,
    NgbModule,
    AppFormsModule,
    ReactiveFormsModule
  ]
})
export class ProjectsModule { }
