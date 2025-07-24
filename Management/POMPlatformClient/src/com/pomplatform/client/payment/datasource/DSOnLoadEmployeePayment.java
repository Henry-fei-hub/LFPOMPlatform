package com.pomplatform.client.payment.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnLoadEmployeePayment extends DBDataSource
{


	public static DSOnLoadEmployeePayment instance = null;

	public static DSOnLoadEmployeePayment getInstance() {
		if(instance == null) {
			instance = new DSOnLoadEmployeePayment("DSOnLoadEmployeePayment");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField plateIdField;
	private final DataSourceTextField departmentIdField;
	private final DataSourceTextField paymentChangeTypeField;
	private final DataSourceDateField changeDateField;
	private final DataSourceFloatField monthPayField;
	private final DataSourceTextField basicProportionStrField;
	private final DataSourceFloatField basicProportionField;
	private final DataSourceFloatField monthBasicPayField;
	private final DataSourceFloatField monthPerformancePayField;
	private final DataSourceFloatField foremanPayField;
	private final DataSourceFloatField totalPayField;
	private final DataSourceFloatField annualPerformanceField;
	private final DataSourceFloatField otherSubsidyField;

	public DSOnLoadEmployeePayment(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadEmployeePayment");


		employeeIdField = new DataSourceIntegerField("employeeId", "职员编码");
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


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		departmentIdField = new DataSourceTextField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		paymentChangeTypeField = new DataSourceTextField("paymentChangeType", "调薪类型");
		paymentChangeTypeField.setLength(11);
		paymentChangeTypeField.setRequired(false);
		paymentChangeTypeField.setHidden(false);
		paymentChangeTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_95"));


		changeDateField = new DataSourceDateField("changeDate", "调薪日期");
		changeDateField.setRequired(false);
		changeDateField.setHidden(false);


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


		basicProportionField = new DataSourceFloatField("basicProportion", "基本比例");
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
		foremanPayField.setHidden(true);


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


		otherSubsidyField = new DataSourceFloatField("otherSubsidy", "其他补贴");
		otherSubsidyField.setLength(18);
		otherSubsidyField.setDecimalPad(2);
		otherSubsidyField.setFormat("#,###,###,###,###,##0.00");
		otherSubsidyField.setRequired(false);
		otherSubsidyField.setHidden(true);


		setFields(employeeIdField, employeeNoField, employeeNameField, plateIdField, departmentIdField, paymentChangeTypeField, changeDateField, monthPayField, basicProportionStrField, basicProportionField, monthBasicPayField, monthPerformancePayField, foremanPayField, totalPayField, annualPerformanceField, otherSubsidyField);
	}


}

