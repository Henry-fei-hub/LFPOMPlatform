package com.pomplatform.client.costallocation.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDCarCostAllocationEachMonthDetail extends DataSource
{


	public static CDCarCostAllocationEachMonthDetail instance = null;

	public static CDCarCostAllocationEachMonthDetail getInstance() {
		if(instance == null) {
			instance = new CDCarCostAllocationEachMonthDetail("CDCarCostAllocationEachMonthDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField costTypeField;
	private final DataSourceDateTimeField startTimeField;
	private final DataSourceDateTimeField endTimeField;

	public CDCarCostAllocationEachMonthDetail(String dataSourceID) {

		setID(dataSourceID);
		costTypeField = new DataSourceIntegerField("costType", "用车类型");
		costTypeField.setRequired(false);
		costTypeField.setLength(11);
		costTypeField.setHidden(false);
		costTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		startTimeField = new DataSourceDateTimeField("startTime", "开始时间");
		startTimeField.setRequired(false);
		startTimeField.setHidden(false);

		endTimeField = new DataSourceDateTimeField("endTime", "截止时间");
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

