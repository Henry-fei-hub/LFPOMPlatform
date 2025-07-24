package com.pomplatform.client.projectemployee.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDProjectEmployeeAudit extends DataSource
{


	public static CDProjectEmployeeAudit instance = null;

	public static CDProjectEmployeeAudit getInstance() {
		if(instance == null) {
			instance = new CDProjectEmployeeAudit("CDProjectEmployeeAudit");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField flagField;
	private final DataSourceIntegerField projectPlateIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;

	public CDProjectEmployeeAudit(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		flagField = new DataSourceIntegerField("flag", "成员状态");
		flagField.setRequired(false);
		flagField.setLength(11);
		flagField.setHidden(false);

		projectPlateIdField = new DataSourceIntegerField("projectPlateId", "订单业务部门");
		projectPlateIdField.setRequired(false);
		projectPlateIdField.setLength(11);
		projectPlateIdField.setHidden(false);
		projectPlateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		contractCodeField = new DataSourceTextField("contractCode", "订单编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "订单名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setRequired(true);
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);

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


		setFields(plateIdField, flagField, projectPlateIdField, contractCodeField, projectNameField, employeeNoField, employeeNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

