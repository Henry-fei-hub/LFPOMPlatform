package com.pomplatform.client.mcecscreeor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMcecscreeor extends DataSource
{


	public static CDMcecscreeor instance = null;

	public static CDMcecscreeor getInstance() {
		if(instance == null) {
			instance = new CDMcecscreeor("CDMcecscreeor");
		}
		return instance;
	}

	private final DataSourceDateTimeField minCreateTimeField;
	private final DataSourceDateTimeField maxCreateTimeField;
	private final DataSourceIntegerField contractCodeIdField;
	private final DataSourceIntegerField signCompanyField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNameField;

	public CDMcecscreeor(String dataSourceID) {

		setID(dataSourceID);
		minCreateTimeField = new DataSourceDateTimeField("minCreateTime", "最早操作时间");
		minCreateTimeField.setRequired(false);
		minCreateTimeField.setHidden(false);

		maxCreateTimeField = new DataSourceDateTimeField("maxCreateTime", "最晚操作时间");
		maxCreateTimeField.setRequired(false);
		maxCreateTimeField.setHidden(false);

		contractCodeIdField = new DataSourceIntegerField("contractCodeId", "主键");
		contractCodeIdField.setRequired(true);
		contractCodeIdField.setLength(11);
		contractCodeIdField.setPrimaryKey(true);
		contractCodeIdField.setHidden(true);

		signCompanyField = new DataSourceIntegerField("signCompany", "签约公司");
		signCompanyField.setRequired(false);
		signCompanyField.setLength(11);
		signCompanyField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(255);
		contractCodeField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(255);
		remarkField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "操作人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

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


		setFields(minCreateTimeField, maxCreateTimeField, contractCodeIdField, signCompanyField, contractCodeField, remarkField, employeeIdField, employeeNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

