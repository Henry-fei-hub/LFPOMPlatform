package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSReportMapTotals extends DBDataSource
{


	public static DSReportMapTotals instance = null;

	public static DSReportMapTotals getInstance() {
		if(instance == null) {
			instance = new DSReportMapTotals("DSReportMapTotals");
		}
		return instance;
	}

	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField departmentNameField;
	private final DataSourceTextField mapTypeField;
	private final DataSourceTextField specialNameField;
	private final DataSourceTextField mapVersionField;
	private final DataSourceDateTimeField startDateField;
	private final DataSourceTextField remarkField;

	public DSReportMapTotals(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ReportMapTotals");


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(255);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(255);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "申请人");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);


		departmentNameField = new DataSourceTextField("departmentName", "部门");
		departmentNameField.setLength(64);
		departmentNameField.setRequired(true);
		departmentNameField.setHidden(false);


		mapTypeField = new DataSourceTextField("mapType", "出图类型");
		mapTypeField.setLength(64);
		mapTypeField.setRequired(true);
		mapTypeField.setHidden(false);


		specialNameField = new DataSourceTextField("specialName", "专业");
		specialNameField.setLength(64);
		specialNameField.setRequired(false);
		specialNameField.setHidden(false);


		mapVersionField = new DataSourceTextField("mapVersion", "版本");
		mapVersionField.setLength(64);
		mapVersionField.setRequired(true);
		mapVersionField.setHidden(false);


		startDateField = new DataSourceDateTimeField("startDate", "出图日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "出图备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(projectCodeField, projectNameField, employeeNameField, departmentNameField, mapTypeField, specialNameField, mapVersionField, startDateField, remarkField);
	}


}

