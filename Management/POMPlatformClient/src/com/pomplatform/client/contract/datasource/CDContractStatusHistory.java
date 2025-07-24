package com.pomplatform.client.contract.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDContractStatusHistory extends DataSource
{


	public static CDContractStatusHistory instance = null;

	public static CDContractStatusHistory getInstance() {
		if(instance == null) {
			instance = new CDContractStatusHistory("CDContractStatusHistory");
		}
		return instance;
	}

	private final DataSourceDateTimeField startTimeField;
	private final DataSourceDateTimeField endTimeField;
	private final DataSourceIntegerField contractStatusField;

	public CDContractStatusHistory(String dataSourceID) {

		setID(dataSourceID);
		startTimeField = new DataSourceDateTimeField("startTime", "开始时间");
		startTimeField.setRequired(false);
		startTimeField.setHidden(false);

		endTimeField = new DataSourceDateTimeField("endTime", "截止时间");
		endTimeField.setRequired(false);
		endTimeField.setHidden(false);

		contractStatusField = new DataSourceIntegerField("contractStatus", "合同状态");
		contractStatusField.setRequired(false);
		contractStatusField.setLength(11);
		contractStatusField.setHidden(false);
		contractStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

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


		setFields(startTimeField, endTimeField, contractStatusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

