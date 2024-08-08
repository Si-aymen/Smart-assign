import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EChartOption } from 'echarts';
import { echartStyles } from 'src/app/shared/echart-styles';
import { Projects } from 'src/app/shared/models/Projects/projects';
import { ProjectsService } from 'src/app/shared/services/Projects/projects.service';



@Component({
	selector: 'app-project-details',
	templateUrl: './project-details.component.html',
	styleUrls: ['./project-details.component.scss']
})
export class ProjectDetailsComponent implements OnInit {
	CurrentProjectID: string;
	CurrentProject: any;
	chartPie1: EChartOption;

	constructor(
		private http: HttpClient,
		private route: ActivatedRoute,
		private projectsService: ProjectsService,
		private router: Router

	)
		 { }

	ngOnInit() {
		this.getProject();
		this.initChart();

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


	initChart() {
		this.chartPie1 = {
			...echartStyles.defaultOptions, ...{
				legend: {
					show: true,
					bottom: 0,
				},
				series: [{
					type: 'pie',
					...echartStyles.pieRing,

					label: echartStyles.pieLabelCenterHover,
					data: [{
						name: 'Completed',
						value: 50,
						itemStyle: {
							color: '#4CAF50',
						}
					}, {
						name: 'Pending',
						value: 50,
						itemStyle: {
							color: '#df0029',
						}
					}]
				}]
			}
		};
	}




	AddTask() {
		this.router.navigate(['/tasks/Add/', this.CurrentProjectID])
	}


}
