package com.pomplatform.client.k3voucher.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDIncomeVoucher extends DataSource
{


	public static CDIncomeVoucher instance = null;

	public static CDIncomeVoucher getInstance() {
		if(instance == null) {
			instance = new CDIncomeVoucher("CDIncomeVoucher");
		}
		return instance;
	}

	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField invoiceNumberField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceTextField codeField;
	private final DataSourceTextField nameField;
	private final DataSourceFloatField debitSideField;
	private final DataSourceFloatField creditSideField;
	private final DataSourceIntegerField customerIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;

	public CDIncomeVoucher(String dataSourceID) {

		setID(dataSourceID);
		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		invoiceNumberField = new DataSourceTextField("invoiceNumber", "发票号码");
		invoiceNumberField.setRequired(false);
		invoiceNumberField.setLength(64);
		invoiceNumberField.setHidden(false);

		startDateField = new DataSourceDateField("startDate", "开始归属日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateField("endDate", "结束归属日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		codeField = new DataSourceTextField("code", "科目代码");
		codeField.setRequired(false);
		codeField.setLength(64);
		codeField.setHidden(false);

		nameField = new DataSourceTextField("name", "科目名称");
		nameField.setRequired(false);
		nameField.setLength(128);
		nameField.setHidden(false);

		debitSideField = new DataSourceFloatField("debitSide", "借方");
		debitSideField.setRequired(true);
		debitSideField.setLength(18);
		debitSideField.setHidden(false);

		creditSideField = new DataSourceFloatField("creditSide", "贷方");
		creditSideField.setRequired(true);
		creditSideField.setLength(18);
		creditSideField.setHidden(false);

		customerIdField = new DataSourceIntegerField("customerId", "客户名称");
		customerIdField.setRequired(false);
		customerIdField.setLength(11);
		customerIdField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);
//		contractCodeField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts", contractCodeField);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

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


		setFields(companyIdField, invoiceNumberField, startDateField, endDateField, codeField, nameField, debitSideField, creditSideField, customerIdField, contractCodeField, contractNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

