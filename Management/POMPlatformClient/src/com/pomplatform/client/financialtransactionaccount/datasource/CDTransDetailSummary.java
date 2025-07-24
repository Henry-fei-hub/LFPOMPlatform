package com.pomplatform.client.financialtransactionaccount.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDTransDetailSummary extends DataSource
{


	public static CDTransDetailSummary instance = null;

	public static CDTransDetailSummary getInstance() {
		if(instance == null) {
			instance = new CDTransDetailSummary("CDTransDetailSummary");
		}
		return instance;
	}

	private final DataSourceDateField startDateField;
	private final DataSourceIntegerField deleteFlagField;
	private final DataSourceDateField endDateField;
	private final DataSourceIntegerField accountTypeField;
	private final DataSourceTextField financeNoField;
	private final DataSourceTextField accountNameField;
	private final DataSourceIntegerField accountStatusField;
	private final DataSourceIntegerField companyIdField;

	public CDTransDetailSummary(String dataSourceID) {

		setID(dataSourceID);
		startDateField = new DataSourceDateField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		deleteFlagField = new DataSourceIntegerField("deleteFlag", "往来明细删除状态");
		deleteFlagField.setRequired(false);
		deleteFlagField.setLength(11);
		deleteFlagField.setHidden(false);

		endDateField = new DataSourceDateField("endDate", "截止日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		accountTypeField = new DataSourceIntegerField("accountType", "账户类型");
		accountTypeField.setRequired(false);
		accountTypeField.setLength(11);
		accountTypeField.setHidden(false);
		accountTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		financeNoField = new DataSourceTextField("financeNo", "财务编号");
		financeNoField.setRequired(false);
		financeNoField.setLength(64);
		financeNoField.setHidden(false);

		accountNameField = new DataSourceTextField("accountName", "名称");
		accountNameField.setRequired(false);
		accountNameField.setLength(256);
		accountNameField.setHidden(false);

		accountStatusField = new DataSourceIntegerField("accountStatus", "账户状态");
		accountStatusField.setRequired(false);
		accountStatusField.setLength(11);
		accountStatusField.setHidden(false);
		accountStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));
		
		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));

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


		setFields(startDateField, deleteFlagField, endDateField, accountTypeField, financeNoField, accountNameField, accountStatusField, companyIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

