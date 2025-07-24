package com.pomplatform.client.projectsettlement.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadProjectSettlementEmployees extends DBDataSource
{


	public static DSOnLoadProjectSettlementEmployees instance = null;

	public static DSOnLoadProjectSettlementEmployees getInstance() {
		if(instance == null) {
			instance = new DSOnLoadProjectSettlementEmployees("DSOnLoadProjectSettlementEmployees");
		}
		return instance;
	}

	private final DataSourceIntegerField projectEmployeeIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceTextField sheetCodeField;
	private final DataSourceTextField sheetNameField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceFloatField realIntegralField;
	private final DataSourceFloatField realAmountPercentField;
	private final DataSourceFloatField sureIntegralField;
	private final DataSourceFloatField costField;
	private final DataSourceFloatField projectCostField;
	private final DataSourceFloatField realAmountField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField workContentField;
	private final DataSourceIntegerField flagField;
	private final DataSourceIntegerField settlementDetailIdField;

	public DSOnLoadProjectSettlementEmployees(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadProjectSettlementEmployees");


		projectEmployeeIdField = new DataSourceIntegerField("projectEmployeeId", "项目组建编码");
		projectEmployeeIdField.setLength(11);
		projectEmployeeIdField.setPrimaryKey(true);
		projectEmployeeIdField.setRequired(true);
		projectEmployeeIdField.setHidden(false);


		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects", projectIdField);


		projectManageIdField = new DataSourceIntegerField("projectManageId", "专业负责人");
		projectManageIdField.setLength(11);
		projectManageIdField.setRequired(false);
		projectManageIdField.setHidden(true);


		sheetCodeField = new DataSourceTextField("sheetCode", "");
		sheetCodeField.setLength(64);
		sheetCodeField.setRequired(true);
		sheetCodeField.setHidden(true);


		sheetNameField = new DataSourceTextField("sheetName", "");
		sheetNameField.setLength(512);
		sheetNameField.setRequired(true);
		sheetNameField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
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

		
		realAmountPercentField = new DataSourceFloatField("finishPercent", "本次确认积分比例");
		realAmountPercentField.setLength(18);
		realAmountPercentField.setDecimalPad(2);
		realAmountPercentField.setFormat("#,###,###,###,###,##0.00");
		realAmountPercentField.setRequired(true);
		realAmountPercentField.setHidden(false);

		realIntegralField = new DataSourceFloatField("realAmount", "本次确认积分");
		realIntegralField.setLength(18);
		realIntegralField.setDecimalPad(2);
		realIntegralField.setFormat("#,###,###,###,###,##0.00");
		realIntegralField.setRequired(true);
		realIntegralField.setHidden(false);


		sureIntegralField = new DataSourceFloatField("sureIntegral", "历史确认积分");
		sureIntegralField.setLength(18);
		sureIntegralField.setDecimalPad(2);
		sureIntegralField.setFormat("#,###,###,###,###,##0.00");
		sureIntegralField.setRequired(true);
		sureIntegralField.setHidden(false);


		costField = new DataSourceFloatField("cost", "本次分摊成本");
		costField.setLength(18);
		costField.setDecimalPad(2);
		costField.setFormat("#,###,###,###,###,##0.00");
		costField.setRequired(true);
		costField.setHidden(false);


		projectCostField = new DataSourceFloatField("projectCost", "历史分摊成本");
		projectCostField.setLength(18);
		projectCostField.setDecimalPad(5);
		projectCostField.setFormat("#,###,###,###,##0.00");
		projectCostField.setRequired(false);
		projectCostField.setHidden(false);


		realAmountField = new DataSourceFloatField("finalAmount", "最终结算积分");
		realAmountField.setLength(18);
		realAmountField.setDecimalPad(5);
		realAmountField.setFormat("#,###,###,###,##0.00");
		realAmountField.setRequired(false);
		realAmountField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "在职状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));


		workContentField = new DataSourceTextField("workContent", "工作内容");
		workContentField.setLength(1024);
		workContentField.setRequired(false);
		workContentField.setHidden(false);

		flagField = new DataSourceIntegerField("flag", "状态（1：草稿保存，2：确认保存）");
		flagField.setLength(11);
		flagField.setRequired(false);
		flagField.setHidden(true);


		settlementDetailIdField = new DataSourceIntegerField("settlementDetailId", "结算详细id");
		settlementDetailIdField.setLength(11);
		settlementDetailIdField.setPrimaryKey(true);
		settlementDetailIdField.setRequired(true);
		settlementDetailIdField.setHidden(true);


		setFields(projectEmployeeIdField, settlementDetailIdField, projectIdField, projectManageIdField, sheetCodeField, sheetNameField, employeeIdField, employeeNoField, employeeNameField, realIntegralField, sureIntegralField, costField, projectCostField,realAmountPercentField, realAmountField, statusField, workContentField, flagField);
	}


}

