package com.pomplatform.client.applysupplierinfo.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDApplySupplierInfo extends DataSource
{


	public static CDApplySupplierInfo instance = null;

	public static CDApplySupplierInfo getInstance() {
		if(instance == null) {
			instance = new CDApplySupplierInfo("CDApplySupplierInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField processTypeField;
	private final DataSourceTextField supplierNameField;
	private final DataSourceDateTimeField createTimeStartField;
	private final DataSourceDateTimeField createTimeEndField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceIntegerField areasExpertiseField;

	public CDApplySupplierInfo(String dataSourceID) {

		setID(dataSourceID);
		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		supplierNameField = new DataSourceTextField("supplierName", "供应商名称");
		supplierNameField.setRequired(false);
		supplierNameField.setLength(128);
		supplierNameField.setHidden(false);

		createTimeStartField = new DataSourceDateTimeField("createTimeStart", "创建时间");
		createTimeStartField.setRequired(false);
		createTimeStartField.setHidden(false);

		createTimeEndField = new DataSourceDateTimeField("createTimeEnd", "创建时间");
		createTimeEndField.setRequired(false);
		createTimeEndField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "创建人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

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


		setFields(processTypeField, supplierNameField, createTimeStartField, createTimeEndField, employeeIdField, operateEmployeeIdField, areasExpertiseField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

