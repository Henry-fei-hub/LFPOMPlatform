package com.pomplatform.client.inputtaxinvoiceabpor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMinputtaxinvoicelinkfinancesippciiymssor extends DataSource
{


	public static CDMinputtaxinvoicelinkfinancesippciiymssor instance = null;

	public static CDMinputtaxinvoicelinkfinancesippciiymssor getInstance() {
		if(instance == null) {
			instance = new CDMinputtaxinvoicelinkfinancesippciiymssor("CDMinputtaxinvoicelinkfinancesippciiymssor");
		}
		return instance;
	}

	private final DataSourceIntegerField processStatusField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField invoiceCodeField;
	private final DataSourceTextField invoiceNumberField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceTextField salesCodeField;
	private final DataSourceTextField salesNameField;
	private final DataSourceTextField codeField;

	public CDMinputtaxinvoicelinkfinancesippciiymssor(String dataSourceID) {

		setID(dataSourceID);
		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setRequired(false);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "公司");
		companyIdField.setRequired(true);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		invoiceCodeField = new DataSourceTextField("invoiceCode", "发票代码(10位 每次批量录入是一样)");
		invoiceCodeField.setRequired(false);
		invoiceCodeField.setLength(64);
		invoiceCodeField.setHidden(false);

		invoiceNumberField = new DataSourceTextField("invoiceNumber", "发票号码(8位)");
		invoiceNumberField.setRequired(false);
		invoiceNumberField.setLength(64);
		invoiceNumberField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "月");
		monthField.setRequired(false);
		monthField.setLength(11);
		monthField.setHidden(false);

		salesCodeField = new DataSourceTextField("salesCode", "销方税号");
		salesCodeField.setRequired(false);
		salesCodeField.setLength(255);
		salesCodeField.setHidden(false);

		salesNameField = new DataSourceTextField("salesName", "销方名称");
		salesNameField.setRequired(false);
		salesNameField.setLength(255);
		salesNameField.setHidden(false);

		codeField = new DataSourceTextField("code", "报销编号");
		codeField.setRequired(false);
		codeField.setLength(255);
		codeField.setHidden(false);

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


		setFields(processStatusField, companyIdField, invoiceCodeField, invoiceNumberField, yearField, monthField, salesCodeField, salesNameField, codeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

