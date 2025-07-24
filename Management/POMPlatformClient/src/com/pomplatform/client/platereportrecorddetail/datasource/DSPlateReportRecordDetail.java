package com.pomplatform.client.platereportrecorddetail.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSPlateReportRecordDetail extends DBDataSource {

	public static DSPlateReportRecordDetail instance = null;

	public static DSPlateReportRecordDetail getInstance() {
		if (instance == null) {
			instance = new DSPlateReportRecordDetail("DSPlateReportRecordDetail");
		}
		return instance;
	}

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
	private final DataSourceFloatField qualityFeeField;
	private final DataSourceFloatField companyFeeField;
	private final DataSourceFloatField violationChargesField;

	public DSPlateReportRecordDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("PlateReportRecordDetail");

		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		achieveIntegralField = new DataSourceFloatField("achieveIntegral", "积分余额");
		achieveIntegralField.setLength(18);
		achieveIntegralField.setDecimalPad(5);
		achieveIntegralField.setFormat("#,###,###,###,###,##0.00");
		achieveIntegralField.setRequired(false);
		achieveIntegralField.setHidden(false);

		projectSettlementField = new DataSourceFloatField("projectSettlement", "项目结算");
		projectSettlementField.setLength(18);
		projectSettlementField.setDecimalPad(5);
		projectSettlementField.setFormat("#,###,###,###,###,##0.00");
		projectSettlementField.setRequired(false);
		projectSettlementField.setHidden(false);

		companySubsidyField = new DataSourceFloatField("companySubsidy", "公司补贴");
		companySubsidyField.setLength(18);
		companySubsidyField.setDecimalPad(5);
		companySubsidyField.setFormat("#,###,###,###,###,##0.00");
		companySubsidyField.setRequired(false);
		companySubsidyField.setHidden(false);

		employeeAchieveIntegralReturnField = new DataSourceFloatField("employeeAchieveIntegralReturn", "积分回收");
		employeeAchieveIntegralReturnField.setLength(18);
		employeeAchieveIntegralReturnField.setDecimalPad(5);
		employeeAchieveIntegralReturnField.setFormat("#,###,###,###,###,##0.00");
		employeeAchieveIntegralReturnField.setRequired(false);
		employeeAchieveIntegralReturnField.setHidden(false);

		salaryReturnField = new DataSourceFloatField("salaryReturn", "积分还款");
		salaryReturnField.setLength(18);
		salaryReturnField.setDecimalPad(5);
		salaryReturnField.setFormat("#,###,###,###,###,##0.00");
		salaryReturnField.setRequired(false);
		salaryReturnField.setHidden(false);

		salaryAdvanceField = new DataSourceFloatField("salaryAdvance", "积分借款");
		salaryAdvanceField.setLength(18);
		salaryAdvanceField.setDecimalPad(5);
		salaryAdvanceField.setFormat("#,###,###,###,###,##0.00");
		salaryAdvanceField.setRequired(false);
		salaryAdvanceField.setHidden(false);

		managerProjectIntegralField = new DataSourceFloatField("managerProjectIntegral", "奖金补贴");
		managerProjectIntegralField.setLength(18);
		managerProjectIntegralField.setDecimalPad(5);
		managerProjectIntegralField.setFormat("#,###,###,###,###,##0.00");
		managerProjectIntegralField.setRequired(false);
		managerProjectIntegralField.setHidden(false);

		plateCostField = new DataSourceFloatField("plateCost", "运营成本");
		plateCostField.setLength(18);
		plateCostField.setDecimalPad(5);
		plateCostField.setFormat("#,###,###,###,###,##0.00");
		plateCostField.setRequired(false);
		plateCostField.setHidden(false);
		
		projectAdvanceField = new DataSourceFloatField("projectAdvance", "项目补贴");
		projectAdvanceField.setLength(18);
		projectAdvanceField.setDecimalPad(5);
		projectAdvanceField.setFormat("#,###,###,###,###,##0.00");
		projectAdvanceField.setRequired(false);
		projectAdvanceField.setHidden(false);
		
		qualityFeeField = new DataSourceFloatField("qualityFee", "品质管理费");
		qualityFeeField.setLength(18);
		qualityFeeField.setDecimalPad(5);
		qualityFeeField.setFormat("#,###,###,###,###,##0.00");
		qualityFeeField.setRequired(false);
		qualityFeeField.setHidden(false);
		
		companyFeeField = new DataSourceFloatField("companyFee", "公司费用");
		companyFeeField.setLength(18);
		companyFeeField.setDecimalPad(5);
		companyFeeField.setFormat("#,###,###,###,###,##0.00");
		companyFeeField.setRequired(false);
		companyFeeField.setHidden(false);
		
		violationChargesField = new DataSourceFloatField("violationCharges", "项目违规金");
		violationChargesField.setLength(18);
		violationChargesField.setDecimalPad(5);
		violationChargesField.setFormat("#,###,###,###,###,##0.00");
		violationChargesField.setRequired(false);
		violationChargesField.setHidden(false);

		setFields(plateIdField, achieveIntegralField, projectSettlementField, companySubsidyField,
				employeeAchieveIntegralReturnField, salaryReturnField, salaryAdvanceField, managerProjectIntegralField,
				plateCostField, projectAdvanceField, qualityFeeField, companyFeeField, violationChargesField);
	}

}
