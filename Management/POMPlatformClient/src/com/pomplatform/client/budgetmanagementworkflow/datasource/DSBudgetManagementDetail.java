package com.pomplatform.client.budgetmanagementworkflow.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSBudgetManagementDetail extends DBDataSource
{


	public static DSBudgetManagementDetail instance = null;

	public static DSBudgetManagementDetail getInstance() {
		if(instance == null) {
			instance = new DSBudgetManagementDetail("DSBudgetManagementDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField budgetManagementDetailIdField;
	private final DataSourceIntegerField budgetManagementIdField;
	private final DataSourceTextField bdCodeField;
	private final DataSourceIntegerField bddTypeField;
	private final DataSourceFloatField bddAmountField;
	private final DataSourceIntegerField projectIdField;

	public DSBudgetManagementDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("BudgetManagementDetail");


		budgetManagementDetailIdField = new DataSourceIntegerField("budgetManagementDetailId", "主键id");
		budgetManagementDetailIdField.setLength(11);
		budgetManagementDetailIdField.setPrimaryKey(true);
		budgetManagementDetailIdField.setRequired(true);
		budgetManagementDetailIdField.setHidden(true);


		budgetManagementIdField = new DataSourceIntegerField("budgetManagementId", "预算管理id");
		budgetManagementIdField.setLength(11);
		budgetManagementIdField.setRequired(false);
		budgetManagementIdField.setHidden(true);


		bdCodeField = new DataSourceTextField("bdCode", "预算编号");
		bdCodeField.setLength(1024);
		bdCodeField.setRequired(false);
		bdCodeField.setHidden(true);


		bddTypeField = new DataSourceIntegerField("bddType", "预算详细类别");
		bddTypeField.setLength(11);
		bddTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_188"));
		bddTypeField.setRequired(false);
		bddTypeField.setHidden(false);


		bddAmountField = new DataSourceFloatField("bddAmount", "预算详细金额");
		bddAmountField.setLength(18);
		bddAmountField.setDecimalPad(2);
		bddAmountField.setFormat("#,###,###,###,###,##0.00");
		bddAmountField.setRequired(false);
		bddAmountField.setHidden(false);


		projectIdField = new DataSourceIntegerField("projectId", "项目名称");
		projectIdField.setLength(11);
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects",projectIdField);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);


		setFields(budgetManagementDetailIdField, budgetManagementIdField, bdCodeField, bddTypeField, bddAmountField, projectIdField);
	}


}

