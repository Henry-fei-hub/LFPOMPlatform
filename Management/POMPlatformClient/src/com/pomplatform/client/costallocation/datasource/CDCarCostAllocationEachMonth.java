package com.pomplatform.client.costallocation.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDCarCostAllocationEachMonth extends DataSource
{


	public static CDCarCostAllocationEachMonth instance = null;

	public static CDCarCostAllocationEachMonth getInstance() {
		if(instance == null) {
			instance = new CDCarCostAllocationEachMonth("CDCarCostAllocationEachMonth");
		}
		return instance;
	}

	private final DataSourceIntegerField costTypeField;
	private final DataSourceDateTimeField startTimeField;
	private final DataSourceDateTimeField endTimeField;

	public CDCarCostAllocationEachMonth(String dataSourceID) {

		setID(dataSourceID);
		costTypeField = new DataSourceIntegerField("costType", "成本类型");
		costTypeField.setRequired(false);
		costTypeField.setLength(11);
		costTypeField.setHidden(false);
		costTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		startTimeField = new DataSourceDateTimeField("startTime", "开始日期");
		startTimeField.setRequired(false);
		startTimeField.setHidden(false);

		endTimeField = new DataSourceDateTimeField("endTime", "截止日期");
		endTimeField.setRequired(false);
		endTimeField.setHidden(false);

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


		setFields(costTypeField, startTimeField, endTimeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

