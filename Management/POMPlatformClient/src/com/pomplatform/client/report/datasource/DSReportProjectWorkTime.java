package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.DBDataSource;

public class DSReportProjectWorkTime extends DBDataSource
{


	public static DSReportProjectWorkTime instance = null;

	public static DSReportProjectWorkTime getInstance() {
		if(instance == null) {
			instance = new DSReportProjectWorkTime("DSReportProjectWorkTime");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceFloatField workHourField;
	private final DataSourceFloatField projectStatisticalWorkHourField;
	private final DataSourceIntegerField participantNumberField;

	public DSReportProjectWorkTime(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ReportProjectWorkTime");


		projectIdField = new DataSourceIntegerField("projectId", "项目id");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);
		projectIdField.setHidden(true);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		workHourField = new DataSourceFloatField("workHour", "填报工时");
		workHourField.setLength(10);
		workHourField.setDecimalPad(1);
		workHourField.setFormat("###,###,##0.0");
		workHourField.setRequired(false);
		workHourField.setHidden(false);


		projectStatisticalWorkHourField = new DataSourceFloatField("projectStatisticalWorkHour", "统计工时");
		projectStatisticalWorkHourField.setLength(18);
		projectStatisticalWorkHourField.setDecimalPad(2);
		projectStatisticalWorkHourField.setFormat("#,###,###,###,###,##0.00");
		projectStatisticalWorkHourField.setRequired(true);
		projectStatisticalWorkHourField.setHidden(false);


		participantNumberField = new DataSourceIntegerField("participantNumber", "参与人数");
		participantNumberField.setLength(-1);
		participantNumberField.setRequired(true);
		participantNumberField.setHidden(false);


		setFields(projectIdField, projectCodeField, projectNameField, workHourField, projectStatisticalWorkHourField, participantNumberField);
	}


}

