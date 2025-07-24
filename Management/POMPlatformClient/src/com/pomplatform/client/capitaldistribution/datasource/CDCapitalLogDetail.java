package com.pomplatform.client.capitaldistribution.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDCapitalLogDetail extends DataSource
{


	public static CDCapitalLogDetail instance = null;

	public static CDCapitalLogDetail getInstance() {
		if(instance == null) {
			instance = new CDCapitalLogDetail("CDCapitalLogDetail");
		}
		return instance;
	}

	private final DataSourceTextField contractNameField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceDateTimeField startTimeField;
	private final DataSourceDateTimeField endTimeField;

	public CDCapitalLogDetail(String dataSourceID) {

		setID(dataSourceID);
		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);
//		contractCodeField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractCodeField);

		operatorField = new DataSourceIntegerField("operator", "操作者");
		operatorField.setRequired(false);
		operatorField.setLength(11);
		operatorField.setHidden(false);
		operatorField.setValueMap(KeyValueManager.getValueMap("employees"));

		startTimeField = new DataSourceDateTimeField("startTime", "开始日期");
		startTimeField.setRequired(false);
		startTimeField.setHidden(false);

		endTimeField = new DataSourceDateTimeField("endTime", "结束日期");
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


		setFields(contractNameField, contractCodeField, operatorField, startTimeField, endTimeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

