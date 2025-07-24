package com.pomplatform.client.auditsupplierinfo.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDAuditSupplierInfo extends DataSource
{


	public static CDAuditSupplierInfo instance = null;

	public static CDAuditSupplierInfo getInstance() {
		if(instance == null) {
			instance = new CDAuditSupplierInfo("CDAuditSupplierInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField processStatusField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceTextField supplierNameField;
	private final DataSourceDateTimeField createTimeStartField;
	private final DataSourceDateTimeField createTimeEndField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceIntegerField areasExpertiseField;

	public CDAuditSupplierInfo(String dataSourceID) {

		setID(dataSourceID);
		processStatusField = new DataSourceIntegerField("processStatus", "流程状态 0 发起中  1");
		processStatusField.setRequired(false);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "处理人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		supplierNameField = new DataSourceTextField("supplierName", "供应商名称");
		supplierNameField.setRequired(false);
		supplierNameField.setLength(128);
		supplierNameField.setHidden(false);

		createTimeStartField = new DataSourceDateTimeField("createTimeStart", "流程实例节点创建时间");
		createTimeStartField.setRequired(false);
		createTimeStartField.setHidden(false);

		createTimeEndField = new DataSourceDateTimeField("createTimeEnd", "流程实例节点创建时间");
		createTimeEndField.setRequired(false);
		createTimeEndField.setHidden(false);

		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setHidden(false);

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


		setFields(processStatusField, employeeIdField, statusField, processTypeField, supplierNameField, createTimeStartField, createTimeEndField, operateEmployeeIdField, areasExpertiseField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

