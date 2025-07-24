package com.pomplatform.client.projectcostlist.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDProjectCostList extends DataSource
{


	public static CDProjectCostList instance = null;

	public static CDProjectCostList getInstance() {
		if(instance == null) {
			instance = new CDProjectCostList("CDProjectCostList");
		}
		return instance;
	}

	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField costTypeField;

	public CDProjectCostList(String dataSourceID) {

		setID(dataSourceID);
		statusField = new DataSourceIntegerField("status", "结算状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		costTypeField = new DataSourceIntegerField("costType", "费用类型");
		costTypeField.setRequired(false);
		costTypeField.setLength(11);
		costTypeField.setHidden(false);
		costTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

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


		setFields(statusField, costTypeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

