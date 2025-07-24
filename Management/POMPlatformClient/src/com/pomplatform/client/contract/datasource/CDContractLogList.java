package com.pomplatform.client.contract.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class CDContractLogList extends DataSource
{


	public static CDContractLogList instance = null;

	public static CDContractLogList getInstance() {
		if(instance == null) {
			instance = new CDContractLogList("CDContractLogList");
		}
		return instance;
	}

	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceIntegerField originalStatusField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField newStatusField;

	public CDContractLogList(String dataSourceID) {

		setID(dataSourceID);
		startDateField = new DataSourceDateField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateField("endDate", "截止日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		originalStatusField = new DataSourceIntegerField("originalStatus", "原始合同状态");
		originalStatusField.setRequired(false);
		originalStatusField.setLength(11);
		originalStatusField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		newStatusField = new DataSourceIntegerField("newStatus", "新合同状态");
		newStatusField.setRequired(false);
		newStatusField.setLength(11);
		newStatusField.setHidden(false);

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


		setFields(startDateField, endDateField, originalStatusField, contractCodeField, contractNameField, newStatusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

