package com.pomplatform.client.payment.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSFiveInsuranceOneGoldsPaymentBase extends DBDataSource
{


	public static DSFiveInsuranceOneGoldsPaymentBase instance = null;

	public static DSFiveInsuranceOneGoldsPaymentBase getInstance() {
		if(instance == null) {
			instance = new DSFiveInsuranceOneGoldsPaymentBase("DSFiveInsuranceOneGoldsPaymentBase");
		}
		return instance;
	}

	private final DataSourceIntegerField fiveInsuranceOneGoldIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceIntegerField accumulationFundGolePaymentBaseField;
	private final DataSourceFloatField accumulationFundGoleCompanyPaymentRatioField;
	private final DataSourceFloatField accumulationFundGoleIndividualPaymentRatioField;

	private final DataSourceFloatField unitPensionPaymentBaseField;
	private final DataSourceFloatField unitPensionPaymentRatioField;
	private final DataSourceFloatField personalPensionPaymentRatioField;
	private final DataSourceIntegerField unitMedicalInsurancePaymentBaseField;
	private final DataSourceFloatField unitMedicalInsurancePaymentRatioField;
	private final DataSourceFloatField personalMedicalInsurancePaymentRatioField;
	private final DataSourceIntegerField unitUnemploymentInsurancePaymentBaseField;
	private final DataSourceFloatField unitUnemploymentInsurancePaymentRatioField;
	private final DataSourceFloatField personalUnemploymentInsurancePaymentRatioField;
	private final DataSourceIntegerField unitInjuryInsuranceBaseField;
	private final DataSourceFloatField unitInjuryInsuranceRatioField;
	private final DataSourceIntegerField unitGiveBirthInsurancePaymentBaseField;
	private final DataSourceFloatField unitGiveBirthInsurancePaymentRatioField;

	public DSFiveInsuranceOneGoldsPaymentBase(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("FiveInsuranceOneGoldsPaymentBase");


		fiveInsuranceOneGoldIdField = new DataSourceIntegerField("fiveInsuranceOneGoldId", "主键编码");
		fiveInsuranceOneGoldIdField.setLength(11);
		fiveInsuranceOneGoldIdField.setPrimaryKey(true);
		fiveInsuranceOneGoldIdField.setRequired(true);
		fiveInsuranceOneGoldIdField.setHidden(true);


		employeeNoField = new DataSourceTextField("employeeNo", "职员编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);
		employeeNoField.setValueMap(KeyValueManager.getValueMap(""));


		employeeNameField = new DataSourceTextField("employeeId", "职员姓名");
		employeeNameField.setLength(11);
		employeeNameField.setRequired(false);
		employeeNameField.setHidden(false);
		employeeNameField.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeNameField.setCanEdit(false);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		KeyValueManager.loadValueMap("company_records", companyIdField);


		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		KeyValueManager.loadValueMap("all_departments", departmentIdField);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		KeyValueManager.loadValueMap("plate_records", plateIdField);


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(false);

		//公积金缴费基数
		accumulationFundGolePaymentBaseField = new DataSourceIntegerField("accumulationFundGolePaymentBase", "缴费基数");
		accumulationFundGolePaymentBaseField.setLength(11);
		accumulationFundGolePaymentBaseField.setRequired(false);
		accumulationFundGolePaymentBaseField.setHidden(false);

		//公积金单位缴费比例
		accumulationFundGoleCompanyPaymentRatioField = new DataSourceFloatField("accumulationFundGoleCompanyPaymentRatio", "单位缴费比例");
		accumulationFundGoleCompanyPaymentRatioField.setLength(18);
		accumulationFundGoleCompanyPaymentRatioField.setDecimalPad(2);
		accumulationFundGoleCompanyPaymentRatioField.setFormat("#,###,###,###,###,##0.00");
		accumulationFundGoleCompanyPaymentRatioField.setRequired(false);
		accumulationFundGoleCompanyPaymentRatioField.setHidden(false);


		//公积金个人缴费比例
		accumulationFundGoleIndividualPaymentRatioField = new DataSourceFloatField("accumulationFundGoleIndividualPaymentRatio", "个人缴费比例");
		accumulationFundGoleIndividualPaymentRatioField.setLength(18);
		accumulationFundGoleIndividualPaymentRatioField.setDecimalPad(2);
		accumulationFundGoleIndividualPaymentRatioField.setFormat("#,###,###,###,###,##0.00");
		accumulationFundGoleIndividualPaymentRatioField.setRequired(false);
		accumulationFundGoleIndividualPaymentRatioField.setHidden(false);


		//养老保险缴费基数
		unitPensionPaymentBaseField = new DataSourceFloatField("unitPensionPaymentBase", "缴费基数");
		unitPensionPaymentBaseField.setLength(18);
		unitPensionPaymentBaseField.setDecimalPad(2);
		unitPensionPaymentBaseField.setFormat("#,###,###,###,###,##0.00");
		unitPensionPaymentBaseField.setRequired(false);
		unitPensionPaymentBaseField.setHidden(false);

		//养老保险缴费比例（单位）
		unitPensionPaymentRatioField = new DataSourceFloatField("unitPensionPaymentRatio", "单位缴费比例");
		unitPensionPaymentRatioField.setLength(18);
		unitPensionPaymentRatioField.setDecimalPad(2);
		unitPensionPaymentRatioField.setFormat("#,###,###,###,###,##0.00");
		unitPensionPaymentRatioField.setRequired(false);
		unitPensionPaymentRatioField.setHidden(false);

		//养老保险缴费比例（个人）
		personalPensionPaymentRatioField = new DataSourceFloatField("personalPensionPaymentRatio", "个人缴费比例");
		personalPensionPaymentRatioField.setLength(18);
		personalPensionPaymentRatioField.setDecimalPad(2);
		personalPensionPaymentRatioField.setFormat("#,###,###,###,###,##0.00");
		personalPensionPaymentRatioField.setRequired(false);
		personalPensionPaymentRatioField.setHidden(false);


		//医疗保险缴费基数
		unitMedicalInsurancePaymentBaseField = new DataSourceIntegerField("unitMedicalInsurancePaymentBase", "缴费基数");
		unitMedicalInsurancePaymentBaseField.setLength(11);
		unitMedicalInsurancePaymentBaseField.setRequired(false);
		unitMedicalInsurancePaymentBaseField.setHidden(false);

		//医疗保险缴费比例（单位）
		unitMedicalInsurancePaymentRatioField = new DataSourceFloatField("unitMedicalInsurancePaymentRatio", "单位缴费比例");
		unitMedicalInsurancePaymentRatioField.setLength(18);
		unitMedicalInsurancePaymentRatioField.setDecimalPad(2);
		unitMedicalInsurancePaymentRatioField.setFormat("#,###,###,###,###,##0.00");
		unitMedicalInsurancePaymentRatioField.setRequired(false);
		unitMedicalInsurancePaymentRatioField.setHidden(false);

		//医疗保险缴费比例（个人）
		personalMedicalInsurancePaymentRatioField = new DataSourceFloatField("personalMedicalInsurancePaymentRatio", "个人缴费比例");
		personalMedicalInsurancePaymentRatioField.setLength(18);
		personalMedicalInsurancePaymentRatioField.setDecimalPad(2);
		personalMedicalInsurancePaymentRatioField.setFormat("#,###,###,###,###,##0.00");
		personalMedicalInsurancePaymentRatioField.setRequired(false);
		personalMedicalInsurancePaymentRatioField.setHidden(false);

		//失业保险缴费基数（单位）
		unitUnemploymentInsurancePaymentBaseField = new DataSourceIntegerField("unitUnemploymentInsurancePaymentBase", "缴费基数");
		unitUnemploymentInsurancePaymentBaseField.setLength(11);
		unitUnemploymentInsurancePaymentBaseField.setRequired(false);
		unitUnemploymentInsurancePaymentBaseField.setHidden(false);

		//失业保险缴费比例（单位）
		unitUnemploymentInsurancePaymentRatioField = new DataSourceFloatField("unitUnemploymentInsurancePaymentRatio", "单位缴费比例");
		unitUnemploymentInsurancePaymentRatioField.setLength(18);
		unitUnemploymentInsurancePaymentRatioField.setDecimalPad(2);
		unitUnemploymentInsurancePaymentRatioField.setFormat("#,###,###,###,###,##0.00");
		unitUnemploymentInsurancePaymentRatioField.setRequired(false);
		unitUnemploymentInsurancePaymentRatioField.setHidden(false);

		//失业保险缴费比例（个人）
		personalUnemploymentInsurancePaymentRatioField = new DataSourceFloatField("personalUnemploymentInsurancePaymentRatio", "个人缴费比例");
		personalUnemploymentInsurancePaymentRatioField.setLength(18);
		personalUnemploymentInsurancePaymentRatioField.setDecimalPad(2);
		personalUnemploymentInsurancePaymentRatioField.setFormat("#,###,###,###,###,##0.00");
		personalUnemploymentInsurancePaymentRatioField.setRequired(false);
		personalUnemploymentInsurancePaymentRatioField.setHidden(false);

		//工伤保险缴费基数（单位）
		unitInjuryInsuranceBaseField = new DataSourceIntegerField("unitInjuryInsuranceBase", "缴费基数");
		unitInjuryInsuranceBaseField.setLength(11);
		unitInjuryInsuranceBaseField.setRequired(false);
		unitInjuryInsuranceBaseField.setHidden(false);

		//工伤保险缴费比例（单位）
		unitInjuryInsuranceRatioField = new DataSourceFloatField("unitInjuryInsuranceRatio", "单位缴费比例");
		unitInjuryInsuranceRatioField.setLength(18);
		unitInjuryInsuranceRatioField.setDecimalPad(2);
		unitInjuryInsuranceRatioField.setFormat("#,###,###,###,###,##0.00");
		unitInjuryInsuranceRatioField.setRequired(false);
		unitInjuryInsuranceRatioField.setHidden(false);

		//生育保险缴费基数
		unitGiveBirthInsurancePaymentBaseField = new DataSourceIntegerField("unitGiveBirthInsurancePaymentBase", "缴费基数");
		unitGiveBirthInsurancePaymentBaseField.setLength(11);
		unitGiveBirthInsurancePaymentBaseField.setRequired(false);
		unitGiveBirthInsurancePaymentBaseField.setHidden(false);

		//生育保险缴费比例（单位）
		unitGiveBirthInsurancePaymentRatioField = new DataSourceFloatField("unitGiveBirthInsurancePaymentRatio", "单位缴费比例");
		unitGiveBirthInsurancePaymentRatioField.setLength(18);
		unitGiveBirthInsurancePaymentRatioField.setDecimalPad(2);
		unitGiveBirthInsurancePaymentRatioField.setFormat("#,###,###,###,###,##0.00");
		unitGiveBirthInsurancePaymentRatioField.setRequired(false);
		unitGiveBirthInsurancePaymentRatioField.setHidden(false);


		setFields(
				fiveInsuranceOneGoldIdField,
				employeeNoField,
				employeeNameField,
				companyIdField, departmentIdField, plateIdField, yearField, monthField, accumulationFundGolePaymentBaseField, accumulationFundGoleCompanyPaymentRatioField, accumulationFundGoleIndividualPaymentRatioField, unitPensionPaymentBaseField, unitPensionPaymentRatioField, personalPensionPaymentRatioField, unitMedicalInsurancePaymentBaseField, unitMedicalInsurancePaymentRatioField, personalMedicalInsurancePaymentRatioField, unitUnemploymentInsurancePaymentBaseField, unitUnemploymentInsurancePaymentRatioField, personalUnemploymentInsurancePaymentRatioField, unitInjuryInsuranceBaseField, unitInjuryInsuranceRatioField, unitGiveBirthInsurancePaymentBaseField, unitGiveBirthInsurancePaymentRatioField);
	}

}

