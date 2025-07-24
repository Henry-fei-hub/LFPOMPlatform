package com.pomplatform.client.account.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnLoadBonusAdvanceDetailOfPlateAccount extends DBDataSource
{


	public static DSOnLoadBonusAdvanceDetailOfPlateAccount instance = null;

	public static DSOnLoadBonusAdvanceDetailOfPlateAccount getInstance() {
		if(instance == null) {
			instance = new DSOnLoadBonusAdvanceDetailOfPlateAccount("DSOnLoadBonusAdvanceDetailOfPlateAccount");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField manageProjectIdField;
	private final DataSourceTextField manageProjectNameField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField gradeIdField;
	private final DataSourceFloatField integralField;
	private final DataSourceDateField recordDateField;
	private final DataSourceTextField remarkField;

	public DSOnLoadBonusAdvanceDetailOfPlateAccount(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadBonusAdvanceDetailOfPlateAccount");


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		manageProjectIdField = new DataSourceIntegerField("manageProjectId", "管理项目");
		manageProjectIdField.setLength(11);
		manageProjectIdField.setRequired(false);
		manageProjectIdField.setHidden(true);
//		manageProjectIdField.setValueMap(KeyValueManager.getValueMap("manage_projects"));
		KeyValueManager.loadValueMap("manage_projects", manageProjectIdField);

		manageProjectNameField = new DataSourceTextField("manageProjectName", "项目名称");
		manageProjectNameField.setLength(512);
		manageProjectNameField.setRequired(false);
		manageProjectNameField.setHidden(false);


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "在职状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));


		gradeIdField = new DataSourceIntegerField("gradeId", "职级");
		gradeIdField.setLength(11);
		gradeIdField.setRequired(false);
		gradeIdField.setHidden(false);
		gradeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_3"));


		integralField = new DataSourceFloatField("integral", "积分");
		integralField.setLength(18);
		integralField.setDecimalPad(2);
		integralField.setFormat("#,###,###,###,###,##0.00");
		integralField.setRequired(false);
		integralField.setHidden(false);


		recordDateField = new DataSourceDateField("recordDate", "日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(plateIdField, manageProjectIdField, manageProjectNameField, employeeNoField, employeeNameField, statusField, gradeIdField, integralField, recordDateField, remarkField);
	}


}

