import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SettingsRoutingModule } from './settings-routing.module';
import { ProfileComponent } from './profile/profile.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgbDatepickerModule} from '@ng-bootstrap/ng-bootstrap';
import {SharedComponentsModule} from '../../shared/components/shared-components.module';
import { AccountComponent } from './account/account.component';
import { TagInputModule } from 'ngx-chips';


@NgModule({
  declarations: [
    ProfileComponent,
    AccountComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    SettingsRoutingModule,
    NgbDatepickerModule,
    TagInputModule,
    SharedComponentsModule
  ]
})
export class SettingsModule { }
