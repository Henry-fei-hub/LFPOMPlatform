package com.pomplatform.client.account.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSAccountSource extends DBDataSource {

	public static DSAccountSource instance = null;

	public static DSAccountSource getInstance() {
		if (instance == null) {
			instance = new DSAccountSource("DSAccountSource");
		}
		return instance;
	}

	private final DataSourceFloatField comeIntegralField;
	private final DataSourceFloatField toIntegralField;
	
	private final DataSourceTextField plateIdField;
	private final DataSourceFloatField achieveIntegralField;
	private final DataSourceFloatField projectSettlementField;
	private final DataSourceFloatField companySubsidyField;
	private final DataSourceFloatField employeeAchieveIntegralReturnField;
	private final DataSourceFloatField salaryReturnField;
	private final DataSourceFloatField salaryAdvanceField;
	private final DataSourceFloatField managerProjectIntegralField;
	private final DataSourceFloatField plateCostField;
	private final DataSourceFloatField projectAdvanceField;

	public DSAccountSource(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("AccountManageProcess");
		
		comeIntegralField = new DataSourceFloatField("comeIntegral", "收入");
		comeIntegralField.setLength(18);
		comeIntegralField.setDecimalPad(2);
		comeIntegralField.setFormat("#,###,###,###,###,##0.00");
		comeIntegralField.setRequired(false);
		comeIntegralField.setHidden(false);
		
		toIntegralField = new DataSourceFloatField("toIntegral", "支出");
		toIntegralField.setLength(18);
		toIntegralField.setDecimalPad(2);
		toIntegralField.setFormat("#,###,###,###,###,##0.00");
		toIntegralField.setRequired(false);
		toIntegralField.setHidden(false);
		
		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		achieveIntegralField = new DataSourceFloatField("achieveIntegral", "结余");
		achieveIntegralField.setLength(18);
		achieveIntegralField.setDecimalPad(2);
		achieveIntegralField.setFormat("#,###,###,###,###,##0.00");
		achieveIntegralField.setRequired(false);
		achieveIntegralField.setHidden(false);

		projectSettlementField = new DataSourceFloatField("projectSettlement", "项目结算");
		projectSettlementField.setLength(18);
		projectSettlementField.setDecimalPad(2);
		projectSettlementField.setFormat("#,###,###,###,###,##0.00");
		projectSettlementField.setRequired(false);
		projectSettlementField.setHidden(false);

		companySubsidyField = new DataSourceFloatField("companySubsidy", "公司补贴");
		companySubsidyField.setLength(18);
		companySubsidyField.setDecimalPad(2);
		companySubsidyField.setFormat("#,###,###,###,###,##0.00");
		companySubsidyField.setRequired(false);
		companySubsidyField.setHidden(false);

		employeeAchieveIntegralReturnField = new DataSourceFloatField("employeeAchieveIntegralReturn", "积分回收");
		employeeAchieveIntegralReturnField.setLength(18);
		employeeAchieveIntegralReturnField.setDecimalPad(2);
		employeeAchieveIntegralReturnField.setFormat("#,###,###,###,###,##0.00");
		employeeAchieveIntegralReturnField.setRequired(false);
		employeeAchieveIntegralReturnField.setHidden(false);

		salaryReturnField = new DataSourceFloatField("salaryReturn", "积分还款");
		salaryReturnField.setLength(18);
		salaryReturnField.setDecimalPad(2);
		salaryReturnField.setFormat("#,###,###,###,###,##0.00");
		salaryReturnField.setRequired(false);
		salaryReturnField.setHidden(false);

		salaryAdvanceField = new DataSourceFloatField("salaryAdvance", "积分借款");
		salaryAdvanceField.setLength(18);
		salaryAdvanceField.setDecimalPad(2);
		salaryAdvanceField.setFormat("#,###,###,###,###,##0.00");
		salaryAdvanceField.setRequired(false);
		salaryAdvanceField.setHidden(false);

		managerProjectIntegralField = new DataSourceFloatField("managerProjectIntegral", "奖金补贴");
		managerProjectIntegralField.setLength(18);
		managerProjectIntegralField.setDecimalPad(2);
		managerProjectIntegralField.setFormat("#,###,###,###,###,##0.00");
		managerProjectIntegralField.setRequired(false);
		managerProjectIntegralField.setHidden(false);

		plateCostField = new DataSourceFloatField("plateCost", "运营成本");
		plateCostField.setLength(18);
		plateCostField.setDecimalPad(2);
		plateCostField.setFormat("#,###,###,###,###,##0.00");
		plateCostField.setRequired(false);
		plateCostField.setHidden(false);
		
		projectAdvanceField = new DataSourceFloatField("projectAdvance", "项目补贴");
		projectAdvanceField.setLength(18);
		projectAdvanceField.setDecimalPad(2);
		projectAdvanceField.setFormat("#,###,###,###,###,##0.00");
		projectAdvanceField.setRequired(false);
		projectAdvanceField.setHidden(false);

		setFields(comeIntegralField,toIntegralField,plateIdField, achieveIntegralField, projectSettlementField, companySubsidyField,
				employeeAchieveIntegralReturnField, salaryReturnField, salaryAdvanceField, managerProjectIntegralField,
				plateCostField, projectAdvanceField);
		
	}

}
