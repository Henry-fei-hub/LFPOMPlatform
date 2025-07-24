package com.pomplatform.client.calculateannualleave.datasource;

import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class CDCalculateAnnualLeave extends DataSource
{


	public static CDCalculateAnnualLeave instance = null;

	public static CDCalculateAnnualLeave getInstance() {
		if(instance == null) {
			instance = new CDCalculateAnnualLeave("CDCalculateAnnualLeave");
		}
		return instance;
	}

	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceFloatField currentRemainingAmountAnnualField;
	private final DataSourceFloatField currentRemainingAmountWealfareField;
	private final DataSourceFloatField lastRemainingAmountAnnualField;
	private final DataSourceFloatField lastRemainingAmountWealfareField;

	public CDCalculateAnnualLeave(String dataSourceID) {

		setID(dataSourceID);
		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);
		employeeNameField.setValueMap(KeyValueManager.getValueMap("departments"));

		departmentIdField = new DataSourceIntegerField("departmentId", "部门编码");
		departmentIdField.setRequired(true);
		departmentIdField.setLength(11);
		departmentIdField.setPrimaryKey(true);
		departmentIdField.setHidden(true);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		currentRemainingAmountAnnualField = new DataSourceFloatField("currentRemainingAmountAnnual", "当前的年假");
		currentRemainingAmountAnnualField.setRequired(true);
		currentRemainingAmountAnnualField.setLength(11);
		currentRemainingAmountAnnualField.setHidden(false);

		currentRemainingAmountWealfareField = new DataSourceFloatField("currentRemainingAmountWealfare", "当前的企业福利假");
		currentRemainingAmountWealfareField.setRequired(true);
		currentRemainingAmountWealfareField.setLength(11);
		currentRemainingAmountWealfareField.setHidden(false);

		lastRemainingAmountAnnualField = new DataSourceFloatField("lastRemainingAmountAnnual", "上一年的年假");
		lastRemainingAmountAnnualField.setRequired(true);
		lastRemainingAmountAnnualField.setLength(11);
		lastRemainingAmountAnnualField.setHidden(false);

		lastRemainingAmountWealfareField = new DataSourceFloatField("lastRemainingAmountWealfare", "上一年的企业福利假");
		lastRemainingAmountWealfareField.setRequired(true);
		lastRemainingAmountWealfareField.setLength(11);
		lastRemainingAmountWealfareField.setHidden(false);

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


		setFields(employeeNameField, departmentIdField, currentRemainingAmountAnnualField, currentRemainingAmountWealfareField, lastRemainingAmountAnnualField, lastRemainingAmountWealfareField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

