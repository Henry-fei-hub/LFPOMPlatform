package com.pomplatform.client.employeereportrecorddetail.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSEmployeeReportRecordDetail extends DBDataSource {

	public static DSEmployeeReportRecordDetail instance = null;

	public static DSEmployeeReportRecordDetail getInstance() {
		if (instance == null) {
			instance = new DSEmployeeReportRecordDetail("DSEmployeeReportRecordDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceFloatField achieveIntegralField;
	private final DataSourceFloatField sureIntegralField;
	private final DataSourceFloatField managerProjectIntegralField;
	private final DataSourceFloatField salaryAdvanceField;
	private final DataSourceFloatField salaryReturnField;
	private final DataSourceFloatField salaryField;
	private final DataSourceFloatField projectCostField;
	private final DataSourceFloatField projectAdvanceField;
	private final DataSourceIntegerField statusField;
	private final DataSourceFloatField bonusPaymentField;
	private final DataSourceFloatField integralReturnField;
	private final DataSourceFloatField violationChargesField;

	public DSEmployeeReportRecordDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("EmployeeReportRecordDetail");

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		employeeIdField = new DataSourceIntegerField("employeeId", "员工");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		employeeNameField = new DataSourceTextField("employeeName", "姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(false);
		employeeNameField.setHidden(false);

		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);

		achieveIntegralField = new DataSourceFloatField("achieveIntegral", "积分余额");
		achieveIntegralField.setLength(18);
		achieveIntegralField.setDecimalPad(2);
		achieveIntegralField.setFormat("#,###,###,###,###,##0.00");
		achieveIntegralField.setRequired(false);
		achieveIntegralField.setHidden(false);

		sureIntegralField = new DataSourceFloatField("sureIntegral", "确认积分");
		sureIntegralField.setLength(18);
		sureIntegralField.setDecimalPad(2);
		sureIntegralField.setFormat("#,###,###,###,###,##0.00");
		sureIntegralField.setRequired(false);
		sureIntegralField.setHidden(false);

		managerProjectIntegralField = new DataSourceFloatField("managerProjectIntegral", "奖金补贴");
		managerProjectIntegralField.setLength(18);
		managerProjectIntegralField.setDecimalPad(2);
		managerProjectIntegralField.setFormat("#,###,###,###,###,##0.00");
		managerProjectIntegralField.setRequired(false);
		managerProjectIntegralField.setHidden(false);

		salaryAdvanceField = new DataSourceFloatField("salaryAdvance", "积分借款");
		salaryAdvanceField.setLength(18);
		salaryAdvanceField.setDecimalPad(2);
		salaryAdvanceField.setFormat("#,###,###,###,###,##0.00");
		salaryAdvanceField.setRequired(false);
		salaryAdvanceField.setHidden(false);

		salaryReturnField = new DataSourceFloatField("salaryReturn", "积分还款");
		salaryReturnField.setLength(18);
		salaryReturnField.setDecimalPad(2);
		salaryReturnField.setFormat("#,###,###,###,###,##0.00");
		salaryReturnField.setRequired(false);
		salaryReturnField.setHidden(false);

		salaryField = new DataSourceFloatField("salary", "人工成本");
		salaryField.setLength(18);
		salaryField.setDecimalPad(2);
		salaryField.setFormat("#,###,###,###,###,##0.00");
		salaryField.setRequired(false);
		salaryField.setHidden(false);

		projectCostField = new DataSourceFloatField("projectCost", "项目成本");
		projectCostField.setLength(18);
		projectCostField.setDecimalPad(2);
		projectCostField.setFormat("#,###,###,###,###,##0.00");
		projectCostField.setRequired(false);
		projectCostField.setHidden(false);

		projectAdvanceField = new DataSourceFloatField("projectAdvance", "项目补贴");
		projectAdvanceField.setLength(18);
		projectAdvanceField.setDecimalPad(2);
		projectAdvanceField.setFormat("#,###,###,###,###,##0.00");
		projectAdvanceField.setRequired(false);
		projectAdvanceField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "在职状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));

		bonusPaymentField = new DataSourceFloatField("bonusPayment", "奖金发放");
		bonusPaymentField.setLength(18);
		bonusPaymentField.setDecimalPad(2);
		bonusPaymentField.setFormat("#,###,###,###,###,##0.00");
		bonusPaymentField.setRequired(false);
		bonusPaymentField.setHidden(false);
		
		integralReturnField = new DataSourceFloatField("integralReturn", "积分回收");
		integralReturnField.setLength(18);
		integralReturnField.setDecimalPad(2);
		integralReturnField.setFormat("#,###,###,###,###,##0.00");
		integralReturnField.setRequired(false);
		integralReturnField.setHidden(false);
		
		violationChargesField = new DataSourceFloatField("violationCharges", "项目违规金");
		violationChargesField.setLength(18);
		violationChargesField.setDecimalPad(2);
		violationChargesField.setFormat("#,###,###,###,###,##0.00");
		violationChargesField.setRequired(false);
		violationChargesField.setHidden(false);

		setFields(employeeIdField, employeeNameField, achieveIntegralField, employeeNoField, statusField, plateIdField,
				sureIntegralField, managerProjectIntegralField, salaryAdvanceField, projectAdvanceField,
				salaryReturnField, salaryField, projectCostField, bonusPaymentField, integralReturnField, violationChargesField);
	}

}
