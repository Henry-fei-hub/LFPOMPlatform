package com.pomplatform.client.employeeaward.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMemployeeAward extends DataSource
{


	public static CDMemployeeAward instance = null;

	public static CDMemployeeAward getInstance() {
		if(instance == null) {
			instance = new CDMemployeeAward("CDMemployeeAward");
		}
		return instance;
	}

	private final DataSourceIntegerField yearsField;
	private final DataSourceIntegerField startMonthField;
	private final DataSourceIntegerField endMonthField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField employeeNameField;

	public CDMemployeeAward(String dataSourceID) {

		setID(dataSourceID);
		yearsField = new DataSourceIntegerField("years", "年份");
		yearsField.setRequired(true);
		yearsField.setLength(11);
		yearsField.setHidden(false);

		startMonthField = new DataSourceIntegerField("startMonth", "开始月份");
		startMonthField.setRequired(true);
		startMonthField.setLength(11);
		startMonthField.setHidden(false);

		endMonthField = new DataSourceIntegerField("endMonth", "截止月份");
		endMonthField.setRequired(true);
		endMonthField.setLength(11);
		endMonthField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "职员编码");
		employeeIdField.setRequired(true);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		plateIdField = new DataSourceIntegerField("plateId", "板块");
		plateIdField.setRequired(true);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setRequired(true);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		employeeNameField = new DataSourceTextField("employeeName", "名称");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(0);
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


		setFields(yearsField, startMonthField, endMonthField, employeeIdField, plateIdField, departmentIdField, employeeNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

