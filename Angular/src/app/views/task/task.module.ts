import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';


import { NgxEchartsModule } from 'ngx-echarts';
import { SharedComponentsModule } from 'src/app/shared/components/shared-components.module';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppFormsModule } from '../forms/forms.module';
import { ReactiveFormsModule } from '@angular/forms';
import { TaskFormComponent } from './task-form/task-form.component';
import { TaskRoutingModule } from './task-routing.module';


@NgModule({
  declarations: [TaskFormComponent],
  imports: [
    CommonModule,
    SharedComponentsModule,
    NgxEchartsModule,
    NgxDatatableModule,
    NgbModule,
    TaskRoutingModule,
    AppFormsModule,
    ReactiveFormsModule
  ]
})
export class TaskModule { }
