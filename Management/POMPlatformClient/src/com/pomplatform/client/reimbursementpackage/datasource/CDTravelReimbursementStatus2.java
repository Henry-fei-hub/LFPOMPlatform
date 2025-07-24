package com.pomplatform.client.reimbursementpackage.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDTravelReimbursementStatus2 extends DataSource
{


	public static CDTravelReimbursementStatus2 instance = null;

	public static CDTravelReimbursementStatus2 getInstance() {
		if(instance == null) {
			instance = new CDTravelReimbursementStatus2("CDTravelReimbursementStatus2");
		}
		return instance;
	}

	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField departmentField;
	private final DataSourceTextField codeField;

	public CDTravelReimbursementStatus2(String dataSourceID) {

		setID(dataSourceID);
		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "处理人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		departmentField = new DataSourceIntegerField("department", "归属部门");
		departmentField.setRequired(false);
		departmentField.setLength(11);
		departmentField.setHidden(false);
		departmentField.setValueMap(KeyValueManager.getValueMap("departments"));

		codeField = new DataSourceTextField("code", "编号");
		codeField.setRequired(false);
		codeField.setLength(64);
		codeField.setHidden(false);

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


		setFields(processTypeField, employeeIdField, companyIdField, departmentField, codeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

