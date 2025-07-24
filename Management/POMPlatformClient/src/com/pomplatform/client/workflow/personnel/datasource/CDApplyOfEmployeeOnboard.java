package com.pomplatform.client.workflow.personnel.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDApplyOfEmployeeOnboard extends DataSource
{


	public static CDApplyOfEmployeeOnboard instance = null;

	public static CDApplyOfEmployeeOnboard getInstance() {
		if(instance == null) {
			instance = new CDApplyOfEmployeeOnboard("CDApplyOfEmployeeOnboard");
		}
		return instance;
	}

	private final DataSourceIntegerField processTypeField;
	private final DataSourceDateField onboardDateField;
	private final DataSourceTextField ownedCompanyField;
	private final DataSourceIntegerField dutyIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField employeeNameField;

	public CDApplyOfEmployeeOnboard(String dataSourceID) {

		setID(dataSourceID);
		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		onboardDateField = new DataSourceDateField("onboardDate", "入职日期");
		onboardDateField.setRequired(false);
		onboardDateField.setHidden(false);

		ownedCompanyField = new DataSourceTextField("ownedCompany", "所属公司");
		ownedCompanyField.setRequired(false);
		ownedCompanyField.setLength(64);
		ownedCompanyField.setHidden(false);

		dutyIdField = new DataSourceIntegerField("dutyId", "职位名称");
		dutyIdField.setRequired(false);
		dutyIdField.setLength(11);
		dutyIdField.setHidden(false);

		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setRequired(true);
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "所属部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(new java.util.HashMap());

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


		setFields(processTypeField, onboardDateField, ownedCompanyField, dutyIdField, employeeNoField, departmentIdField, employeeNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

