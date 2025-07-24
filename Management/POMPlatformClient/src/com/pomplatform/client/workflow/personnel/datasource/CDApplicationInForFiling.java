package com.pomplatform.client.workflow.personnel.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDApplicationInForFiling extends DataSource
{


	public static CDApplicationInForFiling instance = null;

	public static CDApplicationInForFiling getInstance() {
		if(instance == null) {
			instance = new CDApplicationInForFiling("CDApplicationInForFiling");
		}
		return instance;
	}

	private final DataSourceIntegerField drafterField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField departmentIdField;

	public CDApplicationInForFiling(String dataSourceID) {

		setID(dataSourceID);
		drafterField = new DataSourceIntegerField("drafter", "申请人");
		drafterField.setRequired(false);
		drafterField.setLength(11);
		drafterField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

		employeeNoField = new DataSourceTextField("employeeNo", "员工工号");
		employeeNoField.setRequired(false);
		employeeNoField.setLength(32);
		employeeNoField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

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


		setFields(drafterField, companyIdField, employeeNameField, employeeNoField, departmentIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

