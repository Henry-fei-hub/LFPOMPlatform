package com.pomplatform.client.payment.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSalaryCommon extends DataSource
{


	public static CDSalaryCommon instance = null;

	public static CDSalaryCommon getInstance() {
		if(instance == null) {
			instance = new CDSalaryCommon("CDSalaryCommon");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField salaryTypeField;
	private final DataSourceIntegerField fundraisingProjectTypeField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;

	public CDSalaryCommon(String dataSourceID) {

		setID(dataSourceID);
		employeeIdField = new DataSourceIntegerField("employeeId", "员工id");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

		salaryTypeField = new DataSourceIntegerField("salaryType", "类型（1.募投项目 2.研发项目,0正常薪资发放）");
		salaryTypeField.setRequired(false);
		salaryTypeField.setLength(11);
		salaryTypeField.setHidden(false);

		fundraisingProjectTypeField = new DataSourceIntegerField("fundraisingProjectType", "募投项目类型");
		fundraisingProjectTypeField.setRequired(false);
		fundraisingProjectTypeField.setLength(11);
		fundraisingProjectTypeField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setRequired(false);
		monthField.setLength(11);
		monthField.setHidden(false);

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


		setFields(employeeIdField, plateIdField, companyIdField, salaryTypeField, fundraisingProjectTypeField, yearField, monthField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

