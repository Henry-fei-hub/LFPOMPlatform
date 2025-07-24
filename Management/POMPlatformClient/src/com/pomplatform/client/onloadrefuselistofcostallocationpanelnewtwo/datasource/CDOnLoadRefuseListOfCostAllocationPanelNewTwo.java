package com.pomplatform.client.onloadrefuselistofcostallocationpanelnewtwo.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadRefuseListOfCostAllocationPanelNewTwo extends DataSource
{


	public static CDOnLoadRefuseListOfCostAllocationPanelNewTwo instance = null;

	public static CDOnLoadRefuseListOfCostAllocationPanelNewTwo getInstance() {
		if(instance == null) {
			instance = new CDOnLoadRefuseListOfCostAllocationPanelNewTwo("CDOnLoadRefuseListOfCostAllocationPanelNewTwo");
		}
		return instance;
	}

	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField processStatusField;

	public CDOnLoadRefuseListOfCostAllocationPanelNewTwo(String dataSourceID) {

		setID(dataSourceID);
		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "创建人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setRequired(false);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);

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


		setFields(processTypeField, employeeIdField, processStatusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

