package com.pomplatform.client.payment.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnloadEmployeePaymentMonthDetail extends DBDataSource
{


	public static DSOnloadEmployeePaymentMonthDetail instance = null;

	public static DSOnloadEmployeePaymentMonthDetail getInstance() {
		if(instance == null) {
			instance = new DSOnloadEmployeePaymentMonthDetail("DSOnloadEmployeePaymentMonthDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField employeePaymentMonthDetailIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField departmentIdField;
	private final DataSourceTextField plateIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceFloatField monthPayField;
	private final DataSourceTextField basicProportionStrField;
	private final DataSourceFloatField basicProportionField;
	private final DataSourceFloatField monthBasicPayField;
	private final DataSourceFloatField monthPerformancePayField;
	private final DataSourceFloatField foremanPayField;
	private final DataSourceFloatField otherSubsidyField;
	private final DataSourceFloatField totalPayField;
	private final DataSourceFloatField annualPerformanceField;
	private final DataSourceTextField costAttributionField;
	private final DataSourceBooleanField enabledField;

	public DSOnloadEmployeePaymentMonthDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnloadEmployeePaymentMonthDetail");


		employeePaymentMonthDetailIdField = new DataSourceIntegerField("employeePaymentMonthDetailId", "主键编码");
		employeePaymentMonthDetailIdField.setLength(11);
		employeePaymentMonthDetailIdField.setPrimaryKey(true);
		employeePaymentMonthDetailIdField.setRequired(true);
		employeePaymentMonthDetailIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "职员编码");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(true);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(false);
		employeeNameField.setHidden(false);


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);


		departmentIdField = new DataSourceTextField("departmentId", "所属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(true);
		yearField.setHidden(false);


		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(true);
		monthField.setHidden(false);


		monthPayField = new DataSourceFloatField("monthPay", "月薪");
		monthPayField.setLength(18);
		monthPayField.setDecimalPad(2);
		monthPayField.setFormat("#,###,###,###,###,##0.00");
		monthPayField.setRequired(false);
		monthPayField.setHidden(false);


		basicProportionStrField = new DataSourceTextField("basicProportionStr", "基本比例");
		basicProportionStrField.setLength(64);
		basicProportionStrField.setRequired(false);
		basicProportionStrField.setHidden(false);


		basicProportionField = new DataSourceFloatField("basicProportion", "基本比例（计算用）");
		basicProportionField.setLength(18);
		basicProportionField.setDecimalPad(2);
		basicProportionField.setFormat("#,###,###,###,###,##0.00");
		basicProportionField.setRequired(false);
		basicProportionField.setHidden(true);


		monthBasicPayField = new DataSourceFloatField("monthBasicPay", "月基本工资");
		monthBasicPayField.setLength(18);
		monthBasicPayField.setDecimalPad(2);
		monthBasicPayField.setFormat("#,###,###,###,###,##0.00");
		monthBasicPayField.setRequired(false);
		monthBasicPayField.setHidden(false);


		monthPerformancePayField = new DataSourceFloatField("monthPerformancePay", "月绩效工资");
		monthPerformancePayField.setLength(18);
		monthPerformancePayField.setDecimalPad(2);
		monthPerformancePayField.setFormat("#,###,###,###,###,##0.00");
		monthPerformancePayField.setRequired(false);
		monthPerformancePayField.setHidden(false);


		foremanPayField = new DataSourceFloatField("foremanPay", "工龄工资");
		foremanPayField.setLength(18);
		foremanPayField.setDecimalPad(2);
		foremanPayField.setFormat("#,###,###,###,###,##0.00");
		foremanPayField.setRequired(false);
		foremanPayField.setHidden(false);


		otherSubsidyField = new DataSourceFloatField("otherSubsidy", "其他补贴");
		otherSubsidyField.setLength(18);
		otherSubsidyField.setDecimalPad(2);
		otherSubsidyField.setFormat("#,###,###,###,###,##0.00");
		otherSubsidyField.setRequired(false);
		otherSubsidyField.setHidden(false);


		totalPayField = new DataSourceFloatField("totalPay", "全薪");
		totalPayField.setLength(18);
		totalPayField.setDecimalPad(2);
		totalPayField.setFormat("#,###,###,###,###,##0.00");
		totalPayField.setRequired(false);
		totalPayField.setHidden(false);


		annualPerformanceField = new DataSourceFloatField("annualPerformance", "年度绩效");
		annualPerformanceField.setLength(18);
		annualPerformanceField.setDecimalPad(2);
		annualPerformanceField.setFormat("#,###,###,###,###,##0.00");
		annualPerformanceField.setRequired(false);
		annualPerformanceField.setHidden(false);


		costAttributionField = new DataSourceTextField("costAttribution", "费用归属");
		costAttributionField.setLength(11);
		costAttributionField.setRequired(false);
		costAttributionField.setHidden(false);
		costAttributionField.setValueMap(KeyValueManager.getValueMap("system_dictionary_114"));


		enabledField = new DataSourceBooleanField("enabled", "是否可用");
		enabledField.setRequired(false);
		enabledField.setHidden(true);


		setFields(employeePaymentMonthDetailIdField, employeeIdField, employeeNameField, employeeNoField, departmentIdField, plateIdField, yearField, monthField, monthPayField, basicProportionStrField, basicProportionField, monthBasicPayField, monthPerformancePayField, foremanPayField, otherSubsidyField, totalPayField, annualPerformanceField, costAttributionField, enabledField);
	}


}

