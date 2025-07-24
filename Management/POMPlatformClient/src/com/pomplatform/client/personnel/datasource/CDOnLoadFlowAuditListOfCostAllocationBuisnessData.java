package com.pomplatform.client.personnel.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadFlowAuditListOfCostAllocationBuisnessData extends DataSource
{


	public static CDOnLoadFlowAuditListOfCostAllocationBuisnessData instance = null;

	public static CDOnLoadFlowAuditListOfCostAllocationBuisnessData getInstance() {
		if(instance == null) {
			instance = new CDOnLoadFlowAuditListOfCostAllocationBuisnessData("CDOnLoadFlowAuditListOfCostAllocationBuisnessData");
		}
		return instance;
	}

	private final DataSourceIntegerField processStatusField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField codeField;
	private final DataSourceTextField nameField;
	private final DataSourceFloatField costField;
	private final DataSourceIntegerField costTypeField;

	public CDOnLoadFlowAuditListOfCostAllocationBuisnessData(String dataSourceID) {

		setID(dataSourceID);
		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setRequired(false);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "处理人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

		codeField = new DataSourceTextField("code", "编号");
		codeField.setRequired(false);
		codeField.setLength(256);
		codeField.setHidden(false);

		nameField = new DataSourceTextField("name", "名称");
		nameField.setRequired(false);
		nameField.setLength(256);
		nameField.setHidden(false);

		costField = new DataSourceFloatField("cost", "成本");
		costField.setRequired(true);
		costField.setLength(18);
		costField.setHidden(false);

		costTypeField = new DataSourceIntegerField("costType", "原成本类型");
		costTypeField.setRequired(false);
		costTypeField.setLength(11);
		costTypeField.setHidden(false);

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


		setFields(processStatusField, employeeIdField, processTypeField, companyIdField, departmentIdField, statusField, codeField, nameField, costField, costTypeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

