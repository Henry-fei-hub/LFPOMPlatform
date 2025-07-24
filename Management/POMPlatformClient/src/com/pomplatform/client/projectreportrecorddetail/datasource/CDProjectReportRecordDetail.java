package com.pomplatform.client.projectreportrecorddetail.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDProjectReportRecordDetail extends DataSource
{


	public static CDProjectReportRecordDetail instance = null;

	public static CDProjectReportRecordDetail getInstance() {
		if(instance == null) {
			instance = new CDProjectReportRecordDetail("CDProjectReportRecordDetail");
		}
		return instance;
	}
	private final DataSourceDateTimeField startDateField;
	private final DataSourceDateTimeField endDateField;
	private final DataSourceIntegerField plateIdField;
//	private final DataSourceDateField startDateField;
//	private final DataSourceDateField endDateField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField departmentManagerIdField;

	public CDProjectReportRecordDetail(String dataSourceID) {

		setID(dataSourceID);
		
		startDateField = new DataSourceDateTimeField("startDate", "开始时间");
		startDateField.setRequired(true);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateTimeField("endDate", "结束时间");
		endDateField.setRequired(true);
		endDateField.setHidden(false);
		
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

/*		startDateField = new DataSourceDateField("startDate", "开始时间");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateField("endDate", "截止时间");
		endDateField.setRequired(false);
		endDateField.setHidden(false);*/

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		departmentManagerIdField = new DataSourceTextField("departmentManagerId", "部门经理");
		departmentManagerIdField.setRequired(false);
		departmentManagerIdField.setLength(512);
		departmentManagerIdField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(plateIdField, startDateField, endDateField, contractCodeField, projectCodeField, projectNameField,departmentManagerIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

