package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSReportOfEmployeeCostAnalysis extends DBDataSource
{


	public static DSReportOfEmployeeCostAnalysis instance = null;

	public static DSReportOfEmployeeCostAnalysis getInstance() {
		if(instance == null) {
			instance = new DSReportOfEmployeeCostAnalysis("DSReportOfEmployeeCostAnalysis");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeCostAnalysisIdField;
	private final DataSourceTextField plateIdField;
	private final DataSourceTextField yearField;
	private final DataSourceTextField monthField;
	private final DataSourceFloatField thisMonthPayField;
	private final DataSourceFloatField lastMonthPayField;
	private final DataSourceTextField payRaiseField;
	private final DataSourceFloatField thisMonthInsuranceField;
	private final DataSourceFloatField lastMonthInsuranceField;
	private final DataSourceTextField insuranceRaiseField;
	private final DataSourceTextField payRemarkField;
	private final DataSourceTextField insuranceRemarkField;
	private final DataSourceBooleanField isLockedField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField remarkField;

	public DSReportOfEmployeeCostAnalysis(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ReportOfEmployeeCostAnalysis");


		employeeCostAnalysisIdField = new DataSourceIntegerField("employeeCostAnalysisId", "主键编码");
		employeeCostAnalysisIdField.setLength(11);
		employeeCostAnalysisIdField.setPrimaryKey(true);
		employeeCostAnalysisIdField.setRequired(true);
		employeeCostAnalysisIdField.setHidden(true);


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		plateIdField.setCanEdit(false);


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


		thisMonthPayField = new DataSourceFloatField("thisMonthPay", "本月应付工资");
		thisMonthPayField.setLength(18);
		thisMonthPayField.setDecimalPad(2);
		thisMonthPayField.setFormat("#,###,###,###,###,##0.00");
		thisMonthPayField.setRequired(false);
		thisMonthPayField.setHidden(false);
		thisMonthPayField.setCanEdit(false);


		lastMonthPayField = new DataSourceFloatField("lastMonthPay", "上月应付工资");
		lastMonthPayField.setLength(18);
		lastMonthPayField.setDecimalPad(2);
		lastMonthPayField.setFormat("#,###,###,###,###,##0.00");
		lastMonthPayField.setRequired(false);
		lastMonthPayField.setHidden(false);
		lastMonthPayField.setCanEdit(false);


		payRaiseField = new DataSourceTextField("payRaise", "工资涨幅");
		payRaiseField.setLength(18);
		payRaiseField.setDecimalPad(2);
		payRaiseField.setFormat("#,###,###,###,###,##0.00");
		payRaiseField.setRequired(false);
		payRaiseField.setHidden(false);
		payRaiseField.setCanEdit(false);


		thisMonthInsuranceField = new DataSourceFloatField("thisMonthInsurance", "本月社保公积金");
		thisMonthInsuranceField.setLength(18);
		thisMonthInsuranceField.setDecimalPad(2);
		thisMonthInsuranceField.setFormat("#,###,###,###,###,##0.00");
		thisMonthInsuranceField.setRequired(false);
		thisMonthInsuranceField.setHidden(false);
		thisMonthInsuranceField.setCanEdit(false);


		lastMonthInsuranceField = new DataSourceFloatField("lastMonthInsurance", "上月社保公积金");
		lastMonthInsuranceField.setLength(18);
		lastMonthInsuranceField.setDecimalPad(2);
		lastMonthInsuranceField.setFormat("#,###,###,###,###,##0.00");
		lastMonthInsuranceField.setRequired(false);
		lastMonthInsuranceField.setHidden(false);
		lastMonthInsuranceField.setCanEdit(false);


		insuranceRaiseField = new DataSourceTextField("insuranceRaise", "社保公积金涨幅");
		insuranceRaiseField.setLength(18);
		insuranceRaiseField.setDecimalPad(2);
		insuranceRaiseField.setFormat("#,###,###,###,###,##0.00");
		insuranceRaiseField.setRequired(false);
		insuranceRaiseField.setHidden(false);
		insuranceRaiseField.setCanEdit(false);


		payRemarkField = new DataSourceTextField("payRemark", "工资说明");
		payRemarkField.setLength(512);
		payRemarkField.setRequired(false);
		payRemarkField.setHidden(false);

		insuranceRemarkField = new DataSourceTextField("insuranceRemark", "社保公积金说明");
		insuranceRemarkField.setLength(512);
		insuranceRemarkField.setRequired(false);
		insuranceRemarkField.setHidden(false);


		isLockedField = new DataSourceBooleanField("isLocked", "是否加锁");
		isLockedField.setRequired(false);
		isLockedField.setHidden(true);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(true);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(true);


		setFields(employeeCostAnalysisIdField, plateIdField, yearField, monthField, thisMonthPayField, lastMonthPayField, payRaiseField, thisMonthInsuranceField, lastMonthInsuranceField, insuranceRaiseField, payRemarkField, insuranceRemarkField, isLockedField, operateEmployeeIdField, operateTimeField, remarkField);
	}


}

