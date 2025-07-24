package com.pomplatform.client.personnel.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadFlowRefuseListOfCostAllocationBuisnessData extends DataSource
{


	public static CDOnLoadFlowRefuseListOfCostAllocationBuisnessData instance = null;

	public static CDOnLoadFlowRefuseListOfCostAllocationBuisnessData getInstance() {
		if(instance == null) {
			instance = new CDOnLoadFlowRefuseListOfCostAllocationBuisnessData("CDOnLoadFlowRefuseListOfCostAllocationBuisnessData");
		}
		return instance;
	}

	private final DataSourceIntegerField processStatusField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField statusField;

	public CDOnLoadFlowRefuseListOfCostAllocationBuisnessData(String dataSourceID) {

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


		setFields(processStatusField, employeeIdField, processTypeField, companyIdField, departmentIdField, statusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

