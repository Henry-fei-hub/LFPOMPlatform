package com.pomplatform.client.personnel.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadFlowEmployeeSalaryAdjustmentBuisnessData extends DataSource
{


	public static CDOnLoadFlowEmployeeSalaryAdjustmentBuisnessData instance = null;

	public static CDOnLoadFlowEmployeeSalaryAdjustmentBuisnessData getInstance() {
		if(instance == null) {
			instance = new CDOnLoadFlowEmployeeSalaryAdjustmentBuisnessData("CDOnLoadFlowEmployeeSalaryAdjustmentBuisnessData");
		}
		return instance;
	}

	private final DataSourceFloatField yearField;
	private final DataSourceFloatField monthField;
	private final DataSourceIntegerField targetProvinceField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField deferField;

	public CDOnLoadFlowEmployeeSalaryAdjustmentBuisnessData(String dataSourceID) {

		setID(dataSourceID);
		yearField = new DataSourceFloatField("year", "undefined");
		yearField.setRequired(true);
		yearField.setLength(0);
		yearField.setHidden(false);

		monthField = new DataSourceFloatField("month", "undefined");
		monthField.setRequired(true);
		monthField.setLength(0);
		monthField.setHidden(false);

		targetProvinceField = new DataSourceIntegerField("targetProvince", "目标省份");
		targetProvinceField.setRequired(false);
		targetProvinceField.setLength(11);
		targetProvinceField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "处理人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

		deferField = new DataSourceIntegerField("defer", "申请人");
		deferField.setRequired(false);
		deferField.setLength(11);
		deferField.setHidden(false);

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


		setFields(yearField, monthField, targetProvinceField, employeeIdField, departmentIdField, deferField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

