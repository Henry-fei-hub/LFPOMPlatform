package com.pomplatform.client.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSettlementApplicationProject extends DBDataSource
{


	public static DSSettlementApplicationProject instance = null;

	public static DSSettlementApplicationProject getInstance() {
		if(instance == null) {
			instance = new DSSettlementApplicationProject("DSSettlementApplicationProject");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField subTypeField;
	private final DataSourceIntegerField settlementIntegralField;

	public DSSettlementApplicationProject(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SettlementApplicationProject");


		projectIdField = new DataSourceIntegerField("projectId", "项目主键");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(255);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(255);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("type", "申请配合部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		subTypeField = new DataSourceTextField("subType", "已申请配合产值");
		subTypeField.setLength(255);
		subTypeField.setRequired(false);
		subTypeField.setHidden(false);


		settlementIntegralField = new DataSourceIntegerField("settlementIntegral", "已结算配合产值");
		settlementIntegralField.setLength(-1);
		settlementIntegralField.setRequired(true);
		settlementIntegralField.setHidden(false);


		setFields(projectIdField, projectCodeField, projectNameField, departmentIdField, subTypeField, settlementIntegralField);
	}


}

