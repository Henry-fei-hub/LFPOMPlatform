package com.pomplatform.client.onloadrefuselistofcostallocationpanelnewtwo.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadRefuseListOfCostAllocationPanelNewFive extends DataSource
{


	public static CDOnLoadRefuseListOfCostAllocationPanelNewFive instance = null;

	public static CDOnLoadRefuseListOfCostAllocationPanelNewFive getInstance() {
		if(instance == null) {
			instance = new CDOnLoadRefuseListOfCostAllocationPanelNewFive("CDOnLoadRefuseListOfCostAllocationPanelNewFive");
		}
		return instance;
	}

	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField employeeIdField;

	public CDOnLoadRefuseListOfCostAllocationPanelNewFive(String dataSourceID) {

		setID(dataSourceID);
		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "创建人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

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


		setFields(statusField, processTypeField, employeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

