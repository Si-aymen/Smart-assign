import { Component } from '@angular/core';
import { SuperAdminService } from 'src/app/shared/services/user/super-admin.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.scss']
})
export class UserDashboardComponent {
  count$ :number ; 
  countDev$ :number ; 
  countManager$ :number ; 
  countSuperAdmin$ :number ; 

  constructor(
    private superAdminService: SuperAdminService,

) { }

ngOnInit() {
  this.loadCount();
}
loadCount(): void {
  this.superAdminService.getCount().subscribe({
    next: (data: number) => {
      this.count$ = data;
    },
    error: (error) => {
      console.error('There was an error!', error);
    }
  });
  this.superAdminService.getCountDev().subscribe({
    next: (data: number) => {
      this.countDev$ = data;
    },
    error: (error) => {
      console.error('There was an error!', error);
    }
  });
  this.superAdminService.getCountManager().subscribe({
    next: (data: number) => {
      this.countManager$ = data;
    },
    error: (error) => {
      console.error('There was an error!', error);
    }
  });  
  this.superAdminService.getCountSuperAdmis().subscribe({
    next: (data: number) => {
      this.countSuperAdmin$ = data;
    },
    error: (error) => {
      console.error('There was an error!', error);
    }
  });
}



}
