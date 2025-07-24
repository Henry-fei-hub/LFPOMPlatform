package com.pomplatform.client.plateprojectaccountrecordbyproject.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSPlateProjectAccountRecordByProject extends DBDataSource
{


	public static DSPlateProjectAccountRecordByProject instance = null;

	public static DSPlateProjectAccountRecordByProject getInstance() {
		if(instance == null) {
			instance = new DSPlateProjectAccountRecordByProject("DSPlateProjectAccountRecordByProject");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceFloatField accountIntegralField;

	public DSPlateProjectAccountRecordByProject(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("PlateProjectAccountRecordByProject");


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		projectIdField = new DataSourceIntegerField("projectId", "项目名称");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects",projectIdField);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);
//		contractCodeField.setValueMap(KeyValueManager.getValueMap("contracts"));

		KeyValueManager.loadValueMap("contracts",contractCodeField);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(true);


		accountIntegralField = new DataSourceFloatField("accountIntegral", "结算积分");
		accountIntegralField.setLength(15);
		accountIntegralField.setDecimalPad(2);
		accountIntegralField.setFormat("#,###,###,##0.00");
		accountIntegralField.setRequired(false);
		accountIntegralField.setHidden(false);


		setFields(plateIdField, projectIdField, contractCodeField, projectCodeField, projectNameField, accountIntegralField);
	}


}

