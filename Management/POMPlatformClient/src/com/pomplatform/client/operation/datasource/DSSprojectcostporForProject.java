package com.pomplatform.client.operation.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSprojectcostporForProject extends DBDataSource {

	public static DSSprojectcostporForProject instance = null;

	public static DSSprojectcostporForProject getInstance() {
		if (instance == null) {
			instance = new DSSprojectcostporForProject("DSSprojectcostporForProject");
		}
		return instance;
	}

	private final DataSourceIntegerField projectCostIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceFloatField costMoneyField;
	private final DataSourceIntegerField costTypeField;
	private final DataSourceDateField costDateField;
	private final DataSourceIntegerField settlementIdField;
	private final DataSourceIntegerField statusField;

	public DSSprojectcostporForProject(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SprojectcostporForProject");

		projectCostIdField = new DataSourceIntegerField("projectCostId", "项目费用编码");
		projectCostIdField.setLength(11);
		projectCostIdField.setPrimaryKey(true);
		projectCostIdField.setRequired(true);
		projectCostIdField.setHidden(true);

		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects",projectIdField);
		employeeIdField = new DataSourceIntegerField("employeeId", "经办人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		costMoneyField = new DataSourceFloatField("amount", "金额");
        costMoneyField.setLength(18);
		costMoneyField.setDecimalPad(2);
		costMoneyField.setFormat("#,###,###,###,###,##0.00");
        costMoneyField.setRequired(false);
        costMoneyField.setHidden(false);

		costTypeField = new DataSourceIntegerField("costType", "费用类型");
		costTypeField.setLength(11);
		costTypeField.setRequired(false);
		costTypeField.setHidden(false);
		costTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_9"));

		costDateField = new DataSourceDateField("costDate", "日期");
		costDateField.setRequired(false);
		costDateField.setHidden(false);

		settlementIdField = new DataSourceIntegerField("settlementId", "结算代码");
		settlementIdField.setLength(11);
		settlementIdField.setRequired(false);
		settlementIdField.setHidden(true);

		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_16"));

		setFields(projectCostIdField, projectIdField, employeeIdField, costMoneyField, costTypeField, costDateField, settlementIdField, statusField);
	}

}
