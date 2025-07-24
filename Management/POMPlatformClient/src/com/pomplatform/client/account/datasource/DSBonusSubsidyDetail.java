package com.pomplatform.client.account.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSBonusSubsidyDetail extends DBDataSource
{


	public static DSBonusSubsidyDetail instance = null;

	public static DSBonusSubsidyDetail getInstance() {
		if(instance == null) {
			instance = new DSBonusSubsidyDetail("DSBonusSubsidyDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField manageProjectIdField;
	private final DataSourceFloatField integralField;
	private final DataSourceTextField remarkField;

	public DSBonusSubsidyDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("BonusSubsidyDetail");


		employeeIdField = new DataSourceIntegerField("employeeId", "职员编码");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
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


		manageProjectIdField = new DataSourceIntegerField("manageProjectId", "管理项目");
		manageProjectIdField.setLength(11);
		manageProjectIdField.setRequired(false);
		manageProjectIdField.setHidden(false);
//		manageProjectIdField.setValueMap(KeyValueManager.getValueMap("manage_projects"));
		KeyValueManager.loadValueMap("manage_projects", manageProjectIdField);

		integralField = new DataSourceFloatField("integral", "积分");
		integralField.setLength(18);
		integralField.setDecimalPad(2);
		integralField.setFormat("#,###,###,###,###,##0.00");
		integralField.setRequired(false);
		integralField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(employeeIdField, employeeNoField, employeeNameField, manageProjectIdField, integralField, remarkField);
	}


}

