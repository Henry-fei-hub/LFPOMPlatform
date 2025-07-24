package com.pomplatform.client.outquotations.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadAttentionListOfOutQuotations extends DataSource
{


	public static CDOnLoadAttentionListOfOutQuotations instance = null;

	public static CDOnLoadAttentionListOfOutQuotations getInstance() {
		if(instance == null) {
			instance = new CDOnLoadAttentionListOfOutQuotations("CDOnLoadAttentionListOfOutQuotations");
		}
		return instance;
	}

	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField outQuotationIdField;
	private final DataSourceTextField quotationNumberField;
	private final DataSourceTextField quotationNameField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceIntegerField quotationStatusField;

	public CDOnLoadAttentionListOfOutQuotations(String dataSourceID) {

		setID(dataSourceID);
		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "创建人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setRequired(true);
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);

		outQuotationIdField = new DataSourceIntegerField("outQuotationId", "报价单编码");
		outQuotationIdField.setRequired(true);
		outQuotationIdField.setLength(11);
		outQuotationIdField.setPrimaryKey(true);
		outQuotationIdField.setHidden(true);

		quotationNumberField = new DataSourceTextField("quotationNumber", "报价单编号(年月日-1)");
		quotationNumberField.setRequired(false);
		quotationNumberField.setLength(32);
		quotationNumberField.setHidden(false);

		quotationNameField = new DataSourceTextField("quotationName", "报价单名称");
		quotationNameField.setRequired(false);
		quotationNameField.setLength(512);
		quotationNameField.setHidden(false);

		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setRequired(false);
		infoCodeField.setLength(32);
		infoCodeField.setHidden(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);

		quotationStatusField = new DataSourceIntegerField("quotationStatus", "报价单的状态 1成功 2不成功 3报价中...");
		quotationStatusField.setRequired(false);
		quotationStatusField.setLength(11);
		quotationStatusField.setHidden(false);

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


		setFields(statusField, employeeIdField, employeeNameField, employeeNoField, outQuotationIdField, quotationNumberField, quotationNameField, infoCodeField, projectCodeField, quotationStatusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

