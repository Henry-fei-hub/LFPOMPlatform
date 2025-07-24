package com.pomplatform.client.onloadrefuselistofcostallocationpanelnewtwo.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadRefuseListOfCostAllocationPanelNewThree extends DataSource
{


	public static CDOnLoadRefuseListOfCostAllocationPanelNewThree instance = null;

	public static CDOnLoadRefuseListOfCostAllocationPanelNewThree getInstance() {
		if(instance == null) {
			instance = new CDOnLoadRefuseListOfCostAllocationPanelNewThree("CDOnLoadRefuseListOfCostAllocationPanelNewThree");
		}
		return instance;
	}

	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField employeeIdField;

	public CDOnLoadRefuseListOfCostAllocationPanelNewThree(String dataSourceID) {

		setID(dataSourceID);
		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

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


		setFields(processTypeField, statusField, employeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

