package com.pomplatform.client.operating.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOperatingReportIntegralSource extends DBDataSource {

	public static DSOperatingReportIntegralSource instance = null;

	public static DSOperatingReportIntegralSource getInstance() {
		if (instance == null) {
			instance = new DSOperatingReportIntegralSource("DSOperatingReportIntegralSource");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceFloatField sureIntegralField;
	private final DataSourceFloatField companySubsidyField;
	private final DataSourceFloatField achieveOtherPlateIntegralField;
	private final DataSourceFloatField developProjectField;
	private final DataSourceFloatField manageProjectField;
	private final DataSourceFloatField companyAdvanceField;
	private final DataSourceFloatField collaborativeAchieveField;
	
	private final DataSourceFloatField salaryCostField;
	private final DataSourceFloatField plateCostField;
	private final DataSourceFloatField projectCostField;
	private final DataSourceFloatField payCommonPlateIntegralField;
	private final DataSourceFloatField payOtherPlateIntegralField;
	private final DataSourceFloatField collaborativePayField;
	private final DataSourceFloatField companyFeeField;
	private final DataSourceFloatField companyRefundField;
	
	
	private final DataSourceFloatField achieveIntegralField;
	private final DataSourceFloatField awardSendField;
	private final DataSourceFloatField leftAchieveIntegralField;

	public DSOperatingReportIntegralSource(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("OnAboutOperatingIntegral");

		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		
		achieveIntegralField = new DataSourceFloatField("achieveIntegral", "价值积分");
		achieveIntegralField.setLength(18);
		achieveIntegralField.setDecimalPad(2);
		achieveIntegralField.setFormat("#,###,###,###,###,##0.00");
		achieveIntegralField.setRequired(false);
		achieveIntegralField.setHidden(false);
		
		awardSendField = new DataSourceFloatField("awardSend", "奖金发放");
		awardSendField.setLength(18);
		awardSendField.setDecimalPad(2);
		awardSendField.setFormat("#,###,###,###,###,##0.00");
		awardSendField.setRequired(false);
		awardSendField.setHidden(false);

		leftAchieveIntegralField = new DataSourceFloatField("leftAchieveIntegral", "剩余价值积分");
		leftAchieveIntegralField.setLength(18);
		leftAchieveIntegralField.setDecimalPad(2);
		leftAchieveIntegralField.setFormat("#,###,###,###,###,##0.00");
		leftAchieveIntegralField.setRequired(false);
		leftAchieveIntegralField.setHidden(false);
		
		sureIntegralField = new DataSourceFloatField("sureIntegral", "确认积分");
		sureIntegralField.setLength(18);
		sureIntegralField.setDecimalPad(2);
		sureIntegralField.setFormat("#,###,###,###,###,##0.00");
		sureIntegralField.setRequired(false);
		sureIntegralField.setHidden(false);
		
		companySubsidyField = new DataSourceFloatField("companySubsidy", "公司补贴");
		companySubsidyField.setLength(18);
		companySubsidyField.setDecimalPad(2);
		companySubsidyField.setFormat("#,###,###,###,###,##0.00");
		companySubsidyField.setRequired(false);
		companySubsidyField.setHidden(false);
		
		achieveOtherPlateIntegralField = new DataSourceFloatField("achieveOtherPlateIntegral", "来自其它部门积分");
		achieveOtherPlateIntegralField.setLength(18);
		achieveOtherPlateIntegralField.setDecimalPad(2);
		achieveOtherPlateIntegralField.setFormat("#,###,###,###,###,##0.00");
		achieveOtherPlateIntegralField.setRequired(false);
		achieveOtherPlateIntegralField.setHidden(false);
		
		developProjectField = new DataSourceFloatField("developProject", "研发项目");
		developProjectField.setLength(18);
		developProjectField.setDecimalPad(2);
		developProjectField.setFormat("#,###,###,###,###,##0.00");
		developProjectField.setRequired(false);
		developProjectField.setHidden(false);
		
		manageProjectField = new DataSourceFloatField("manageProject", "管理项目");
		manageProjectField.setLength(18);
		manageProjectField.setDecimalPad(2);
		manageProjectField.setFormat("#,###,###,###,###,##0.00");
		manageProjectField.setRequired(false);
		manageProjectField.setHidden(false);
		
		companyAdvanceField = new DataSourceFloatField("companyAdvance", "公司借款");
		companyAdvanceField.setLength(18);
		companyAdvanceField.setDecimalPad(2);
		companyAdvanceField.setFormat("#,###,###,###,###,##0.00");
		companyAdvanceField.setRequired(false);
		companyAdvanceField.setHidden(false);
		
		collaborativeAchieveField = new DataSourceFloatField("collaborativeAchieve", "协作收入");
		collaborativeAchieveField.setLength(18);
		collaborativeAchieveField.setDecimalPad(2);
		collaborativeAchieveField.setFormat("#,###,###,###,###,##0.00");
		collaborativeAchieveField.setRequired(false);
		collaborativeAchieveField.setHidden(false);
		
		
		
		
		salaryCostField = new DataSourceFloatField("salaryCost", "人工成本");
		salaryCostField.setLength(18);
		salaryCostField.setDecimalPad(2);
		salaryCostField.setFormat("#,###,###,###,###,##0.00");
		salaryCostField.setRequired(false);
		salaryCostField.setHidden(false);
		
		plateCostField = new DataSourceFloatField("plateCost", "运营成本");
		plateCostField.setLength(18);
		plateCostField.setDecimalPad(2);
		plateCostField.setFormat("#,###,###,###,###,##0.00");
		plateCostField.setRequired(false);
		plateCostField.setHidden(false);
		
		projectCostField = new DataSourceFloatField("projectCost", "项目成本");
		projectCostField.setLength(18);
		projectCostField.setDecimalPad(2);
		projectCostField.setFormat("#,###,###,###,###,##0.00");
		projectCostField.setRequired(false);
		projectCostField.setHidden(false);
		
		payCommonPlateIntegralField = new DataSourceFloatField("payCommonPlateIntegral", "综合部门分摊");
		payCommonPlateIntegralField.setLength(18);
		payCommonPlateIntegralField.setDecimalPad(2);
		payCommonPlateIntegralField.setFormat("#,###,###,###,###,##0.00");
		payCommonPlateIntegralField.setRequired(false);
		payCommonPlateIntegralField.setHidden(false);
		
		payOtherPlateIntegralField = new DataSourceFloatField("payOtherPlateIntegral", "给其它部门积分");
		payOtherPlateIntegralField.setLength(18);
		payOtherPlateIntegralField.setDecimalPad(2);
		payOtherPlateIntegralField.setFormat("#,###,###,###,###,##0.00");
		payOtherPlateIntegralField.setRequired(false);
		payOtherPlateIntegralField.setHidden(false);
		
		collaborativePayField = new DataSourceFloatField("collaborativePay", "协作支出");
		collaborativePayField.setLength(18);
		collaborativePayField.setDecimalPad(2);
		collaborativePayField.setFormat("#,###,###,###,###,##0.00");
		collaborativePayField.setRequired(false);
		collaborativePayField.setHidden(false);
		
		companyFeeField = new DataSourceFloatField("companyFee", "公司费用");
		companyFeeField.setLength(18);
		companyFeeField.setDecimalPad(2);
		companyFeeField.setFormat("#,###,###,###,###,##0.00");
		companyFeeField.setRequired(false);
		companyFeeField.setHidden(false);
		
		companyRefundField = new DataSourceFloatField("companyRefund", "公司还款");
		companyRefundField.setLength(18);
		companyRefundField.setDecimalPad(2);
		companyRefundField.setFormat("#,###,###,###,###,##0.00");
		companyRefundField.setRequired(false);
		companyRefundField.setHidden(false);
		
		
		setFields(plateIdField, achieveIntegralField,awardSendField,leftAchieveIntegralField, sureIntegralField, companySubsidyField, 
				achieveOtherPlateIntegralField,developProjectField,manageProjectField, companyAdvanceField,collaborativeAchieveField,
				salaryCostField, plateCostField, projectCostField,payCommonPlateIntegralField,
				payOtherPlateIntegralField, collaborativePayField, companyFeeField,companyRefundField);
	}

}
