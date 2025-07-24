package com.pomplatform.client.attentionsupplierinfo.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDAttentionSupplierInfo extends DataSource
{


	public static CDAttentionSupplierInfo instance = null;

	public static CDAttentionSupplierInfo getInstance() {
		if(instance == null) {
			instance = new CDAttentionSupplierInfo("CDAttentionSupplierInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField supplierNameField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeStartField;
	private final DataSourceDateTimeField operateTimeEndField;
	private final DataSourceIntegerField areasExpertiseField;

	public CDAttentionSupplierInfo(String dataSourceID) {

		setID(dataSourceID);
		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "处理人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		supplierNameField = new DataSourceTextField("supplierName", "供应商名称");
		supplierNameField.setRequired(false);
		supplierNameField.setLength(128);
		supplierNameField.setHidden(false);

		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setHidden(false);

		operateTimeStartField = new DataSourceDateTimeField("operateTimeStart", "操作时间");
		operateTimeStartField.setRequired(false);
		operateTimeStartField.setHidden(false);

		operateTimeEndField = new DataSourceDateTimeField("operateTimeEnd", "操作时间");
		operateTimeEndField.setRequired(false);
		operateTimeEndField.setHidden(false);

		areasExpertiseField = new DataSourceIntegerField("areasExpertise", "擅长领域");
		areasExpertiseField.setRequired(false);
		areasExpertiseField.setLength(11);
		areasExpertiseField.setHidden(false);

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


		setFields(statusField, processTypeField, employeeIdField, supplierNameField, operateEmployeeIdField, operateTimeStartField, operateTimeEndField, areasExpertiseField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

