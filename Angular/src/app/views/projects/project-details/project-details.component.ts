import { Component, OnInit } from '@angular/core';
import { EChartOption } from 'echarts';
import { echartStyles } from 'src/app/shared/echart-styles';



@Component({
  selector: 'app-project-details',
  templateUrl: './project-details.component.html',
  styleUrls: ['./project-details.component.scss']
})
export class ProjectDetailsComponent implements OnInit {

  chartPie1: EChartOption;
  
  constructor() { }

  ngOnInit() {
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


}
