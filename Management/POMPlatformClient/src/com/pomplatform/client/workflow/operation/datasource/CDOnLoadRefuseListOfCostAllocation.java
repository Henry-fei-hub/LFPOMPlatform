package com.pomplatform.client.workflow.operation.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadRefuseListOfCostAllocation extends DataSource
{


	public static CDOnLoadRefuseListOfCostAllocation instance = null;

	public static CDOnLoadRefuseListOfCostAllocation getInstance() {
		if(instance == null) {
			instance = new CDOnLoadRefuseListOfCostAllocation("CDOnLoadRefuseListOfCostAllocation");
		}
		return instance;
	}

	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField costTypeField;
	private final DataSourceFloatField costField;
	private final DataSourceTextField codeField;
	private final DataSourceTextField nameField;

	public CDOnLoadRefuseListOfCostAllocation(String dataSourceID) {

		setID(dataSourceID);
		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);
		processTypeField.setValueMap(KeyValueManager.getValueMap("system_process_types"));

		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setRequired(false);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);
		processStatusField.setValueMap(new java.util.HashMap());

		employeeIdField = new DataSourceIntegerField("employeeId", "起草人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		costTypeField = new DataSourceIntegerField("costType", "原成本类型");
		costTypeField.setRequired(false);
		costTypeField.setLength(11);
		costTypeField.setHidden(false);
		costTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		costField = new DataSourceFloatField("cost", "成本");
		costField.setRequired(true);
		costField.setLength(18);
		costField.setHidden(false);

		codeField = new DataSourceTextField("code", "编号");
		codeField.setRequired(false);
		codeField.setLength(256);
		codeField.setHidden(false);

		nameField = new DataSourceTextField("name", "费用承担主体");
		nameField.setRequired(false);
		nameField.setLength(256);
		nameField.setHidden(false);

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


		setFields(processTypeField, processStatusField, employeeIdField, costTypeField, costField, codeField, nameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

