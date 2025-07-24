package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadRefuseListOfApproveProjectStageStroage extends DataSource
{


	public static CDOnLoadRefuseListOfApproveProjectStageStroage instance = null;

	public static CDOnLoadRefuseListOfApproveProjectStageStroage getInstance() {
		if(instance == null) {
			instance = new CDOnLoadRefuseListOfApproveProjectStageStroage("CDOnLoadRefuseListOfApproveProjectStageStroage");
		}
		return instance;
	}

	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField employeeNoField;

	public CDOnLoadRefuseListOfApproveProjectStageStroage(String dataSourceID) {

		setID(dataSourceID);
		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setRequired(false);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

		employeeNoField = new DataSourceTextField("employeeNo", "undefined");
		employeeNoField.setRequired(true);
		employeeNoField.setLength(0);
		employeeNoField.setHidden(false);

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


		setFields(processTypeField, processStatusField, employeeNameField, employeeNoField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

