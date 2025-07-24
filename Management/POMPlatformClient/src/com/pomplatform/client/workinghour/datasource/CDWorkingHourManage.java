package com.pomplatform.client.workinghour.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDWorkingHourManage extends DataSource
{


	public static CDWorkingHourManage instance = null;

	public static CDWorkingHourManage getInstance() {
		if(instance == null) {
			instance = new CDWorkingHourManage("CDWorkingHourManage");
		}
		return instance;
	}

	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceDateField startWorkDateField;
	private final DataSourceDateField endWorkDateField;

	public CDWorkingHourManage(String dataSourceID) {

		setID(dataSourceID);
		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "职员编码");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setRequired(false);
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(false);
		employeeNameField.setLength(128);
		employeeNameField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));

		startWorkDateField = new DataSourceDateField("startWorkDate", "开始日期");
		startWorkDateField.setRequired(false);
		startWorkDateField.setHidden(false);

		endWorkDateField = new DataSourceDateField("endWorkDate", "结束日期");
		endWorkDateField.setRequired(false);
		endWorkDateField.setHidden(false);

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


		setFields(projectCodeField, projectNameField, employeeIdField, employeeNoField, employeeNameField, departmentIdField, plateIdField, companyIdField, startWorkDateField, endWorkDateField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

