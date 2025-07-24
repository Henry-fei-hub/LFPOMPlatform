package com.pomplatform.client.salary.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSalaryOfWorkYears extends DBDataSource
{


	public static DSSalaryOfWorkYears instance = null;

	public static DSSalaryOfWorkYears getInstance() {
		if(instance == null) {
			instance = new DSSalaryOfWorkYears("DSSalaryOfWorkYears");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField plateIdField;
	private final DataSourceTextField departmentIdField;
	private final DataSourceTextField onboardStatusField;
	private final DataSourceDateField onboardDateField;
	private final DataSourceDateField positiveDateField;
	private final DataSourceTextField yearField;
	private final DataSourceIntegerField januaryField;
	private final DataSourceIntegerField februaryField;
	private final DataSourceIntegerField marchField;
	private final DataSourceIntegerField aprilField;
	private final DataSourceIntegerField mayField;
	private final DataSourceIntegerField juneField;
	private final DataSourceIntegerField julyField;
	private final DataSourceIntegerField augustField;
	private final DataSourceIntegerField septemberField;
	private final DataSourceIntegerField octoberField;
	private final DataSourceIntegerField novemberField;
	private final DataSourceIntegerField decemberField;

	public DSSalaryOfWorkYears(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SalaryOfWorkYears");


		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setLength(11);
		employeeIdField.setPrimaryKey(true);
		employeeIdField.setRequired(true);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		departmentIdField = new DataSourceTextField("departmentId", "所属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		onboardStatusField = new DataSourceTextField("onboardStatus", "职员状态");
		onboardStatusField.setLength(11);
		onboardStatusField.setRequired(false);
		onboardStatusField.setHidden(false);
		onboardStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_96"));


		onboardDateField = new DataSourceDateField("onboardDate", "入职日期");
		onboardDateField.setRequired(false);
		onboardDateField.setHidden(false);


		positiveDateField = new DataSourceDateField("positiveDate", "转正日期");
		positiveDateField.setRequired(false);
		positiveDateField.setHidden(false);


		yearField = new DataSourceTextField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		januaryField = new DataSourceIntegerField("january", "1月");
		januaryField.setLength(8);
		januaryField.setRequired(true);
		januaryField.setHidden(false);


		februaryField = new DataSourceIntegerField("february", "2月");
		februaryField.setLength(8);
		februaryField.setRequired(true);
		februaryField.setHidden(false);


		marchField = new DataSourceIntegerField("march", "3月");
		marchField.setLength(8);
		marchField.setRequired(true);
		marchField.setHidden(false);


		aprilField = new DataSourceIntegerField("april", "4月");
		aprilField.setLength(8);
		aprilField.setRequired(true);
		aprilField.setHidden(false);


		mayField = new DataSourceIntegerField("may", "5月");
		mayField.setLength(8);
		mayField.setRequired(true);
		mayField.setHidden(false);


		juneField = new DataSourceIntegerField("june", "6月");
		juneField.setLength(8);
		juneField.setRequired(true);
		juneField.setHidden(false);


		julyField = new DataSourceIntegerField("july", "7月");
		julyField.setLength(8);
		julyField.setRequired(true);
		julyField.setHidden(false);


		augustField = new DataSourceIntegerField("august", "8月");
		augustField.setLength(8);
		augustField.setRequired(true);
		augustField.setHidden(false);


		septemberField = new DataSourceIntegerField("september", "9月");
		septemberField.setLength(8);
		septemberField.setRequired(true);
		septemberField.setHidden(false);


		octoberField = new DataSourceIntegerField("october", "10月");
		octoberField.setLength(8);
		octoberField.setRequired(true);
		octoberField.setHidden(false);


		novemberField = new DataSourceIntegerField("november", "11月");
		novemberField.setLength(8);
		novemberField.setRequired(true);
		novemberField.setHidden(false);


		decemberField = new DataSourceIntegerField("december", "12月");
		decemberField.setLength(8);
		decemberField.setRequired(true);
		decemberField.setHidden(false);


		setFields(employeeIdField, employeeIdField, employeeNoField, employeeNameField, plateIdField, departmentIdField, onboardStatusField, onboardDateField, positiveDateField, yearField, januaryField, februaryField, marchField, aprilField, mayField, juneField, julyField, augustField, septemberField, octoberField, novemberField, decemberField);
	}


}

