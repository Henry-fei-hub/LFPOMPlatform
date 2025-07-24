package com.pomplatform.client.projectcost.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDProjectCostRecord extends DataSource
{


	public static CDProjectCostRecord instance = null;

	public static CDProjectCostRecord getInstance() {
		if(instance == null) {
			instance = new CDProjectCostRecord("CDProjectCostRecord");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField costTypeField;

	public CDProjectCostRecord(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

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


		setFields(plateIdField, statusField, costTypeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

