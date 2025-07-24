package com.pomplatform.client.payment.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSFiveInsuranceOneGolds extends DBDataSource
{


	public static DSFiveInsuranceOneGolds instance = null;

	public static DSFiveInsuranceOneGolds getInstance() {
		if(instance == null) {
			instance = new DSFiveInsuranceOneGolds("DSFiveInsuranceOneGolds");
		}
		return instance;
	}

	private final DataSourceIntegerField fiveInsuranceOneGoldIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeIdField;
	private final DataSourceTextField companyIdField;
	private final DataSourceTextField departmentIdField;
	private final DataSourceTextField plateIdField;
	private final DataSourceTextField yearField;
	private final DataSourceTextField monthField;
	private final DataSourceFloatField totalFundField;
	private final DataSourceFloatField unitTotalFundField;
	private final DataSourceFloatField personalTotalFundField;
	private final DataSourceFloatField totalInsuranceField;
	private final DataSourceFloatField unitTotalInsuranceField;
	private final DataSourceFloatField personalTotalInsuranceField;
	private final DataSourceFloatField unitPensionField;
	private final DataSourceFloatField unitMedicalInsuranceField;
	private final DataSourceFloatField unitLargeMedicalInsuranceField;
	private final DataSourceFloatField unitInjuryInsuranceField;
	private final DataSourceFloatField unitUnemploymentInsuranceField;
	private final DataSourceFloatField unitGiveBirthInsuranceField;
	private final DataSourceFloatField personalPensionField;
	private final DataSourceFloatField personalMedicalInsuranceField;
	private final DataSourceFloatField personalLargeMedicalInsuranceField;
	private final DataSourceFloatField personalSeriousIllInsuranceField;
	private final DataSourceFloatField personalUnemploymentInsuranceField;
	private final DataSourceFloatField personalHeatingField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField remarkField;
	private final DataSourceFloatField unitDisabilityInsuranceField;

	public DSFiveInsuranceOneGolds(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("FiveInsuranceOneGolds");


		fiveInsuranceOneGoldIdField = new DataSourceIntegerField("fiveInsuranceOneGoldId", "主键编码");
		fiveInsuranceOneGoldIdField.setLength(11);
		fiveInsuranceOneGoldIdField.setPrimaryKey(true);
		fiveInsuranceOneGoldIdField.setRequired(true);
		fiveInsuranceOneGoldIdField.setHidden(true);


		employeeNoField = new DataSourceTextField("employeeNo", "职员编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);
		employeeNoField.setCanEdit(false);

		employeeIdField = new DataSourceTextField("employeeId", "职员姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdField.setCanEdit(false);

		companyIdField = new DataSourceTextField("companyId", "所属公司");
		companyIdField.setLength(64);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));
		companyIdField.setCanEdit(true);

		departmentIdField = new DataSourceTextField("departmentId", "所属部门");
		departmentIdField.setLength(64);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdField.setCanEdit(true);
		
		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(64);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));
		plateIdField.setCanEdit(true);
		
		yearField = new DataSourceTextField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);
		yearField.setCanEdit(false);

		monthField = new DataSourceTextField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(false);
		monthField.setCanEdit(false);

		totalFundField = new DataSourceFloatField("totalFund", "应缴公积金合计");
		totalFundField.setLength(18);
		totalFundField.setDecimalPad(2);
		totalFundField.setFormat("#,###,###,###,###,##0.00");
		totalFundField.setRequired(false);
		totalFundField.setHidden(false);
		totalFundField.setCanEdit(false);

		unitTotalFundField = new DataSourceFloatField("unitTotalFund", "单位公积金合计");
		unitTotalFundField.setLength(18);
		unitTotalFundField.setDecimalPad(2);
		unitTotalFundField.setFormat("#,###,###,###,###,##0.00");
		unitTotalFundField.setRequired(false);
		unitTotalFundField.setHidden(false);


		personalTotalFundField = new DataSourceFloatField("personalTotalFund", "个人公积金合计");
		personalTotalFundField.setLength(18);
		personalTotalFundField.setDecimalPad(2);
		personalTotalFundField.setFormat("#,###,###,###,###,##0.00");
		personalTotalFundField.setRequired(false);
		personalTotalFundField.setHidden(false);


		totalInsuranceField = new DataSourceFloatField("totalInsurance", "应缴社保合计");
		totalInsuranceField.setLength(18);
		totalInsuranceField.setDecimalPad(2);
		totalInsuranceField.setFormat("#,###,###,###,###,##0.00");
		totalInsuranceField.setRequired(false);
		totalInsuranceField.setHidden(false);
		totalInsuranceField.setCanEdit(false);

		unitTotalInsuranceField = new DataSourceFloatField("unitTotalInsurance", "单位社保合计");
		unitTotalInsuranceField.setLength(18);
		unitTotalInsuranceField.setDecimalPad(2);
		unitTotalInsuranceField.setFormat("#,###,###,###,###,##0.00");
		unitTotalInsuranceField.setRequired(false);
		unitTotalInsuranceField.setHidden(false);
		unitTotalInsuranceField.setCanEdit(false);

		personalTotalInsuranceField = new DataSourceFloatField("personalTotalInsurance", "个人社保合计");
		personalTotalInsuranceField.setLength(18);
		personalTotalInsuranceField.setDecimalPad(2);
		personalTotalInsuranceField.setFormat("#,###,###,###,###,##0.00");
		personalTotalInsuranceField.setRequired(false);
		personalTotalInsuranceField.setHidden(false);
		personalTotalInsuranceField.setCanEdit(false);

		unitPensionField = new DataSourceFloatField("unitPension", "养老保险");
		unitPensionField.setLength(18);
		unitPensionField.setDecimalPad(2);
		unitPensionField.setFormat("#,###,###,###,###,##0.00");
		unitPensionField.setRequired(false);
		unitPensionField.setHidden(false);


		unitMedicalInsuranceField = new DataSourceFloatField("unitMedicalInsurance", "医疗保险");
		unitMedicalInsuranceField.setLength(18);
		unitMedicalInsuranceField.setDecimalPad(2);
		unitMedicalInsuranceField.setFormat("#,###,###,###,###,##0.00");
		unitMedicalInsuranceField.setRequired(false);
		unitMedicalInsuranceField.setHidden(false);


		unitLargeMedicalInsuranceField = new DataSourceFloatField("unitLargeMedicalInsurance", "大额医疗保险");
		unitLargeMedicalInsuranceField.setLength(18);
		unitLargeMedicalInsuranceField.setDecimalPad(2);
		unitLargeMedicalInsuranceField.setFormat("#,###,###,###,###,##0.00");
		unitLargeMedicalInsuranceField.setRequired(false);
		unitLargeMedicalInsuranceField.setHidden(false);


		unitInjuryInsuranceField = new DataSourceFloatField("unitInjuryInsurance", "工伤保险");
		unitInjuryInsuranceField.setLength(18);
		unitInjuryInsuranceField.setDecimalPad(2);
		unitInjuryInsuranceField.setFormat("#,###,###,###,###,##0.00");
		unitInjuryInsuranceField.setRequired(false);
		unitInjuryInsuranceField.setHidden(false);


		unitUnemploymentInsuranceField = new DataSourceFloatField("unitUnemploymentInsurance", "失业保险");
		unitUnemploymentInsuranceField.setLength(18);
		unitUnemploymentInsuranceField.setDecimalPad(2);
		unitUnemploymentInsuranceField.setFormat("#,###,###,###,###,##0.00");
		unitUnemploymentInsuranceField.setRequired(false);
		unitUnemploymentInsuranceField.setHidden(false);


		unitGiveBirthInsuranceField = new DataSourceFloatField("unitGiveBirthInsurance", "生育保险");
		unitGiveBirthInsuranceField.setLength(18);
		unitGiveBirthInsuranceField.setDecimalPad(2);
		unitGiveBirthInsuranceField.setFormat("#,###,###,###,###,##0.00");
		unitGiveBirthInsuranceField.setRequired(false);
		unitGiveBirthInsuranceField.setHidden(false);


		personalPensionField = new DataSourceFloatField("personalPension", "养老保险");
		personalPensionField.setLength(18);
		personalPensionField.setDecimalPad(2);
		personalPensionField.setFormat("#,###,###,###,###,##0.00");
		personalPensionField.setRequired(false);
		personalPensionField.setHidden(false);


		personalMedicalInsuranceField = new DataSourceFloatField("personalMedicalInsurance", "医疗保险");
		personalMedicalInsuranceField.setLength(18);
		personalMedicalInsuranceField.setDecimalPad(2);
		personalMedicalInsuranceField.setFormat("#,###,###,###,###,##0.00");
		personalMedicalInsuranceField.setRequired(false);
		personalMedicalInsuranceField.setHidden(false);


		personalLargeMedicalInsuranceField = new DataSourceFloatField("personalLargeMedicalInsurance", "大额医疗保险");
		personalLargeMedicalInsuranceField.setLength(18);
		personalLargeMedicalInsuranceField.setDecimalPad(2);
		personalLargeMedicalInsuranceField.setFormat("#,###,###,###,###,##0.00");
		personalLargeMedicalInsuranceField.setRequired(false);
		personalLargeMedicalInsuranceField.setHidden(false);


		personalSeriousIllInsuranceField = new DataSourceFloatField("personalSeriousIllInsurance", "大病医疗保险");
		personalSeriousIllInsuranceField.setLength(18);
		personalSeriousIllInsuranceField.setDecimalPad(2);
		personalSeriousIllInsuranceField.setFormat("#,###,###,###,###,##0.00");
		personalSeriousIllInsuranceField.setRequired(false);
		personalSeriousIllInsuranceField.setHidden(false);


		personalUnemploymentInsuranceField = new DataSourceFloatField("personalUnemploymentInsurance", "失业保险");
		personalUnemploymentInsuranceField.setLength(18);
		personalUnemploymentInsuranceField.setDecimalPad(2);
		personalUnemploymentInsuranceField.setFormat("#,###,###,###,###,##0.00");
		personalUnemploymentInsuranceField.setRequired(false);
		personalUnemploymentInsuranceField.setHidden(false);


		personalHeatingField = new DataSourceFloatField("personalHeating", "采暖");
		personalHeatingField.setLength(18);
		personalHeatingField.setDecimalPad(2);
		personalHeatingField.setFormat("#,###,###,###,###,##0.00");
		personalHeatingField.setRequired(false);
		personalHeatingField.setHidden(false);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(true);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(true);
		
		unitDisabilityInsuranceField = new DataSourceFloatField("unitDisabilityInsurance", "残障金");
		unitDisabilityInsuranceField.setLength(18);
		unitDisabilityInsuranceField.setDecimalPad(2);
		unitDisabilityInsuranceField.setFormat("#,###,###,###,###,##0.00");
		unitDisabilityInsuranceField.setRequired(false);
		unitDisabilityInsuranceField.setHidden(false);


		setFields(fiveInsuranceOneGoldIdField, employeeNoField, employeeIdField, companyIdField,departmentIdField,plateIdField, yearField, monthField, totalFundField, unitTotalFundField, personalTotalFundField, totalInsuranceField, unitTotalInsuranceField, personalTotalInsuranceField, unitPensionField, unitMedicalInsuranceField, unitLargeMedicalInsuranceField, unitInjuryInsuranceField, unitUnemploymentInsuranceField, unitGiveBirthInsuranceField,unitDisabilityInsuranceField, personalPensionField, personalMedicalInsuranceField, personalLargeMedicalInsuranceField, personalSeriousIllInsuranceField, personalUnemploymentInsuranceField, personalHeatingField, operateEmployeeIdField, operateTimeField, remarkField);
	}


}

