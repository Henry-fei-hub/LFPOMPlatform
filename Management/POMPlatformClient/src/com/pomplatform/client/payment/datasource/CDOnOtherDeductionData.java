package com.pomplatform.client.payment.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnOtherDeductionData extends DataSource
{


	public static CDOnOtherDeductionData instance = null;

	public static CDOnOtherDeductionData getInstance() {
		if(instance == null) {
			instance = new CDOnOtherDeductionData("CDOnOtherDeductionData");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceBooleanField isSendedField;

	public CDOnOtherDeductionData(String dataSourceID) {

		setID(dataSourceID);
		employeeIdField = new DataSourceIntegerField("employeeId", "员工");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setRequired(true);
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

		startDateField = new DataSourceDateField("startDate", "日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateField("endDate", "日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setRequired(false);
		monthField.setLength(11);
		monthField.setHidden(false);

		isSendedField = new DataSourceBooleanField("isSended", "是否发放");
		isSendedField.setRequired(false);
		isSendedField.setHidden(false);

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


		setFields(employeeIdField, employeeNoField, employeeNameField, companyIdField, departmentIdField, startDateField, endDateField, yearField, monthField, isSendedField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

