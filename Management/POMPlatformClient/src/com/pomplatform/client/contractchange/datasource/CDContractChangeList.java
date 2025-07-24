package com.pomplatform.client.contractchange.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDContractChangeList extends DataSource
{


	public static CDContractChangeList instance = null;

	public static CDContractChangeList getInstance() {
		if(instance == null) {
			instance = new CDContractChangeList("CDContractChangeList");
		}
		return instance;
	}

	private final DataSourceIntegerField flagField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceDateTimeField startTimeField;
	private final DataSourceDateTimeField endTimeField;

	public CDContractChangeList(String dataSourceID) {

		setID(dataSourceID);
		flagField = new DataSourceIntegerField("flag", "状态");
		flagField.setRequired(false);
		flagField.setLength(11);
		flagField.setHidden(false);

		java.util.Map<String,String> flagValues = new java.util.HashMap<String,String>();
		flagValues.put("2", "驳回");
		flagValues.put("3", "待审核");
		flagValues.put("1", "草稿");
		flagValues.put("4", "已审核");
		flagField.setValueMap(flagValues);

		contractIdField = new DataSourceIntegerField("contractId", "合同名称");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractIdField);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);
//		contractCodeField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractIdField);

		startTimeField = new DataSourceDateTimeField("startTime", "开始时间");
		startTimeField.setRequired(false);
		startTimeField.setHidden(false);

		endTimeField = new DataSourceDateTimeField("endTime", "结束时间");
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


		setFields(flagField, contractIdField, contractCodeField, startTimeField, endTimeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

