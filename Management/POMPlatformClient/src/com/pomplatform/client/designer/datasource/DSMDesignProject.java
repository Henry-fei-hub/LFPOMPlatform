package com.pomplatform.client.designer.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMDesignProject extends DBDataSource
{


	public static DSMDesignProject instance = null;

	public static DSMDesignProject getInstance() {
		if(instance == null) {
			instance = new DSMDesignProject("DSMDesignProject");
		}
		return instance;
	}

	private final DataSourceIntegerField projectEmployeeIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField projectManageIdField;
	private final DataSourceTextField sheetCodeField;
	private final DataSourceTextField sheetNameField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceFloatField planIntegralField;
	private final DataSourceFloatField realIntegralField;
	private final DataSourceFloatField sureIntegralField;
	private final DataSourceFloatField costField;
	private final DataSourceFloatField projectCostField;
	private final DataSourceFloatField realAmountField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField workContentField;
	private final DataSourceFloatField realAmountsField;
	private final DataSourceFloatField advancedIntegralField;
	private final DataSourceTextField alternateField2Field;
	private final DataSourceIntegerField countField;
	
	public DSMDesignProject(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("DesignerProjectDetail");


		projectEmployeeIdField = new DataSourceIntegerField("projectEmployeeId", "项目组建编码");
		projectEmployeeIdField.setLength(11);
		projectEmployeeIdField.setPrimaryKey(true);
		projectEmployeeIdField.setRequired(true);
		projectEmployeeIdField.setHidden(true);
		
		
		countField = new DataSourceIntegerField("count", "待审核的数量");
		countField.setLength(11);
		countField.setRequired(true);
		countField.setHidden(true);


		projectIdField = new DataSourceIntegerField("projectId", "项目代码");
		projectIdField.setLength(11);
		projectIdField.setRequired(true);
		projectIdField.setHidden(true);
		KeyValueManager.loadValueMap("projects",projectIdField);


		projectManageIdField = new DataSourceTextField("projectManageId", "专业负责人");
		projectManageIdField.setLength(11);
		projectManageIdField.setRequired(false);
		projectManageIdField.setHidden(false);
		projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		sheetCodeField = new DataSourceTextField("sheetCode", "订单编号");
		sheetCodeField.setLength(64);
		sheetCodeField.setRequired(true);
		sheetCodeField.setHidden(false);
//		sheetCodeField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",sheetCodeField);


		sheetNameField = new DataSourceTextField("sheetName", "订单名称");
		sheetNameField.setLength(512);
		sheetNameField.setRequired(true);
		sheetNameField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "成员ID");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(true);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(true);


		planIntegralField = new DataSourceFloatField("planIntegral", "预分配积分");
		planIntegralField.setLength(18);
		planIntegralField.setDecimalPad(2);
		planIntegralField.setFormat("#,###,###,###,###,##0.00");
		planIntegralField.setRequired(false);
		planIntegralField.setHidden(false);


		realIntegralField = new DataSourceFloatField("realIntegral", "本次确认积分");
		realIntegralField.setLength(18);
		realIntegralField.setDecimalPad(2);
		realIntegralField.setFormat("#,###,###,###,###,##0.00");
		realIntegralField.setRequired(false);
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
		costField.setRequired(false);
		costField.setHidden(false);


		projectCostField = new DataSourceFloatField("projectCost", "历史分摊成本");
		projectCostField.setLength(18);
		projectCostField.setDecimalPad(2);
		projectCostField.setFormat("#,###,###,###,###,##0.00");
		projectCostField.setRequired(false);
		projectCostField.setHidden(false);


		realAmountField = new DataSourceFloatField("realAmount", "最终结算积分(弃用)");
		realAmountField.setLength(18);
		realAmountField.setDecimalPad(2);
		realAmountField.setFormat("#,###,###,###,###,##0.00");
		realAmountField.setRequired(false);
		realAmountField.setHidden(true);


		statusField = new DataSourceIntegerField("status", "在职状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(true);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));


		workContentField = new DataSourceTextField("workContent", "工作内容");
		workContentField.setLength(1024);
		workContentField.setRequired(false);
		workContentField.setHidden(false);
		
		realAmountsField = new DataSourceFloatField("realAmounts", "最终结算积分");
		realAmountsField.setLength(18);
		realAmountsField.setDecimalPad(2);
		realAmountsField.setFormat("#,###,###,###,###,##0.00");
		realAmountsField.setRequired(true);
		realAmountsField.setHidden(false);


		advancedIntegralField = new DataSourceFloatField("advancedIntegral", "项目补贴积分");
		advancedIntegralField.setLength(10);
		advancedIntegralField.setDecimalPad(2);
		advancedIntegralField.setFormat("##,###,##0.00");
		advancedIntegralField.setRequired(false);
		advancedIntegralField.setHidden(false);

		alternateField2Field = new DataSourceTextField("alternateField2", "状态值");
		alternateField2Field.setLength(512);
		alternateField2Field.setRequired(false);
		alternateField2Field.setHidden(true);

		setFields(projectEmployeeIdField, projectIdField, projectManageIdField, sheetCodeField, sheetNameField, employeeIdField, employeeNoField, employeeNameField, planIntegralField, realIntegralField, sureIntegralField, costField, projectCostField, advancedIntegralField,realAmountsField, statusField, workContentField,alternateField2Field);
	}


}

