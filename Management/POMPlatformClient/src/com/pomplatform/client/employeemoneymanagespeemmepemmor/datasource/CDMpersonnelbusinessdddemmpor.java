package com.pomplatform.client.employeemoneymanagespeemmepemmor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMpersonnelbusinessdddemmpor extends DataSource
{


	public static CDMpersonnelbusinessdddemmpor instance = null;

	public static CDMpersonnelbusinessdddemmpor getInstance() {
		if(instance == null) {
			instance = new CDMpersonnelbusinessdddemmpor("CDMpersonnelbusinessdddemmpor");
		}
		return instance;
	}

	private final DataSourceIntegerField deleteFlagField;
	private final DataSourceIntegerField drafterField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceDateTimeField minCreateTimeField;
	private final DataSourceDateTimeField maxCreateTimeField;
	private final DataSourceIntegerField processStatusField;

	public CDMpersonnelbusinessdddemmpor(String dataSourceID) {

		setID(dataSourceID);
		deleteFlagField = new DataSourceIntegerField("deleteFlag", "删除状态  0未删除    1已删除");
		deleteFlagField.setRequired(false);
		deleteFlagField.setLength(11);
		deleteFlagField.setHidden(false);

		drafterField = new DataSourceIntegerField("drafter", "申请人");
		drafterField.setRequired(false);
		drafterField.setLength(11);
		drafterField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setRequired(false);
		employeeNoField.setLength(32);
		employeeNoField.setHidden(false);

		minCreateTimeField = new DataSourceDateTimeField("minCreateTime", "最早创建时间");
		minCreateTimeField.setRequired(false);
		minCreateTimeField.setHidden(false);

		maxCreateTimeField = new DataSourceDateTimeField("maxCreateTime", "最晚创建时间");
		maxCreateTimeField.setRequired(false);
		maxCreateTimeField.setHidden(false);

		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setRequired(false);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);

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


		setFields(deleteFlagField, drafterField, departmentIdField, employeeNoField, minCreateTimeField, maxCreateTimeField, processStatusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

