package com.pomplatform.client.payment.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnLoadEmployeePaymentDetail extends DBDataSource
{


	public static DSOnLoadEmployeePaymentDetail instance = null;

	public static DSOnLoadEmployeePaymentDetail getInstance() {
		if(instance == null) {
			instance = new DSOnLoadEmployeePaymentDetail("DSOnLoadEmployeePaymentDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField employeePaymentDetailIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField companyIdField;
	private final DataSourceTextField departmentIdField;
	private final DataSourceDateField detailDateField;
	private final DataSourceTextField detailWeekField;
	private final DataSourceFloatField monthPayField;
	private final DataSourceTextField basicProportionStrField;
	private final DataSourceFloatField basicProportionField;
	private final DataSourceFloatField monthBasicPayField;
	private final DataSourceFloatField monthPerformancePayField;
	private final DataSourceFloatField foremanPayField;
	private final DataSourceFloatField allSalaryField;
	private final DataSourceFloatField monthWorkDayField;
	private final DataSourceFloatField monthTotalDayField;
	private final DataSourceFloatField dayWorkTimeField;
	private final DataSourceFloatField dayPayField;
	private final DataSourceFloatField dayForemanPayField;
	private final DataSourceFloatField dayAttendanceDeductionField;
	private final DataSourceFloatField dayCostField;
	private final DataSourceFloatField unitTotalFundField;
	private final DataSourceFloatField unitTotalInsuranceField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField lateLeave10mField;
	private final DataSourceIntegerField lateLeave30mField;
	private final DataSourceIntegerField lateLeaveField;
	private final DataSourceFloatField thingLeaveDaysField;
	private final DataSourceFloatField thingLeaveHoursField;
	private final DataSourceFloatField illLeaveDaysField;
	private final DataSourceFloatField illLeaveHoursField;
	private final DataSourceTextField illPercentStrField;
	private final DataSourceFloatField illPercentField;
	private final DataSourceFloatField lateLeaveTotalField;
	private final DataSourceFloatField thingTotalField;
	private final DataSourceFloatField illTotalField;
	private final DataSourceFloatField deductTotalField;
	private final DataSourceBooleanField isLockedField;

	public DSOnLoadEmployeePaymentDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadEmployeePaymentDetail");


		employeePaymentDetailIdField = new DataSourceIntegerField("employeePaymentDetailId", "主键编码");
		employeePaymentDetailIdField.setLength(11);
		employeePaymentDetailIdField.setPrimaryKey(true);
		employeePaymentDetailIdField.setRequired(true);
		employeePaymentDetailIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "职员编码");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		
		employeeNoField = new DataSourceTextField("employeeNo", "职员编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(false);
		
		employeeNameField = new DataSourceTextField("employeeName", "职员姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(false);
		
		companyIdField = new DataSourceTextField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));
		
		departmentIdField = new DataSourceTextField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		detailDateField = new DataSourceDateField("detailDate", "日期");
		detailDateField.setRequired(false);
		detailDateField.setHidden(false);


		detailWeekField = new DataSourceTextField("detailWeek", "星期");
		detailWeekField.setLength(11);
		detailWeekField.setRequired(false);
		detailWeekField.setHidden(false);
		detailWeekField.setValueMap(KeyValueManager.getValueMap("system_dictionary_23"));
		
		monthWorkDayField = new DataSourceFloatField("monthWorkDay", "工作日");
		monthWorkDayField.setLength(18);
		monthWorkDayField.setDecimalPad(2);
		monthWorkDayField.setFormat("#,###,###,###,###,##0.00");
		monthWorkDayField.setRequired(false);
		monthWorkDayField.setHidden(false);


		monthTotalDayField = new DataSourceFloatField("monthTotalDay", "月天数");
		monthTotalDayField.setLength(18);
		monthTotalDayField.setDecimalPad(2);
		monthTotalDayField.setFormat("#,###,###,###,###,##0.00");
		monthTotalDayField.setRequired(false);
		monthTotalDayField.setHidden(true);


		dayWorkTimeField = new DataSourceFloatField("dayWorkTime", "工作时间");
		dayWorkTimeField.setLength(18);
		dayWorkTimeField.setDecimalPad(2);
		dayWorkTimeField.setFormat("#,###,###,###,###,##0.00");
		dayWorkTimeField.setRequired(false);
		dayWorkTimeField.setHidden(false);


		monthPayField = new DataSourceFloatField("monthPay", "月薪");
		monthPayField.setLength(18);
		monthPayField.setDecimalPad(2);
		monthPayField.setFormat("#,###,###,###,###,##0.00");
		monthPayField.setRequired(false);
		monthPayField.setHidden(true);


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


		monthBasicPayField = new DataSourceFloatField("monthBasicPay", "日基本工资");
		monthBasicPayField.setLength(18);
		monthBasicPayField.setDecimalPad(2);
		monthBasicPayField.setFormat("#,###,###,###,###,##0.00");
		monthBasicPayField.setRequired(false);
		monthBasicPayField.setHidden(false);


		monthPerformancePayField = new DataSourceFloatField("monthPerformancePay", "日绩效工资");
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
		
		dayForemanPayField = new DataSourceFloatField("dayForemanPay", "日工龄工资");
		dayForemanPayField.setLength(18);
		dayForemanPayField.setDecimalPad(2);
		dayForemanPayField.setFormat("#,###,###,###,###,##0.00");
		dayForemanPayField.setRequired(false);
		dayForemanPayField.setHidden(false);
		
		allSalaryField = new DataSourceFloatField("allSalary", "日全薪");
		allSalaryField.setLength(18);
		allSalaryField.setDecimalPad(2);
		allSalaryField.setFormat("#,###,###,###,###,##0.00");
		allSalaryField.setRequired(false);
		allSalaryField.setHidden(false);


		dayPayField = new DataSourceFloatField("dayPay", "日工资");
		dayPayField.setLength(18);
		dayPayField.setDecimalPad(2);
		dayPayField.setFormat("#,###,###,###,###,##0.00");
		dayPayField.setRequired(false);
		dayPayField.setHidden(false);


		dayAttendanceDeductionField = new DataSourceFloatField("dayAttendanceDeduction", "日考勤扣款工资");
		dayAttendanceDeductionField.setLength(18);
		dayAttendanceDeductionField.setDecimalPad(2);
		dayAttendanceDeductionField.setFormat("#,###,###,###,###,##0.00");
		dayAttendanceDeductionField.setRequired(false);
		dayAttendanceDeductionField.setHidden(false);


		dayCostField = new DataSourceFloatField("dayCost", "日成本");
		dayCostField.setLength(18);
		dayCostField.setDecimalPad(2);
		dayCostField.setFormat("#,###,###,###,###,##0.00");
		dayCostField.setRequired(false);
		dayCostField.setHidden(true);


		unitTotalFundField = new DataSourceFloatField("unitTotalFund", "单位公积金");
		unitTotalFundField.setLength(18);
		unitTotalFundField.setDecimalPad(2);
		unitTotalFundField.setFormat("#,###,###,###,###,##0.00");
		unitTotalFundField.setRequired(false);
		unitTotalFundField.setHidden(false);


		unitTotalInsuranceField = new DataSourceFloatField("unitTotalInsurance", "单位社保");
		unitTotalInsuranceField.setLength(18);
		unitTotalInsuranceField.setDecimalPad(2);
		unitTotalInsuranceField.setFormat("#,###,###,###,###,##0.00");
		unitTotalInsuranceField.setRequired(false);
		unitTotalInsuranceField.setHidden(false);


		lateLeave10mField = new DataSourceIntegerField("lateLeave10m", "迟到/早退10分钟");
		lateLeave10mField.setLength(11);
		lateLeave10mField.setRequired(false);
		lateLeave10mField.setHidden(false);


		lateLeave30mField = new DataSourceIntegerField("lateLeave30m", "迟到/早退30分钟");
		lateLeave30mField.setLength(11);
		lateLeave30mField.setRequired(false);
		lateLeave30mField.setHidden(false);


		lateLeaveField = new DataSourceIntegerField("lateLeave", "扣款迟到/早退");
		lateLeaveField.setLength(11);
		lateLeaveField.setRequired(false);
		lateLeaveField.setHidden(false);


		thingLeaveDaysField = new DataSourceFloatField("thingLeaveDays", "事假天数");
		thingLeaveDaysField.setLength(18);
		thingLeaveDaysField.setDecimalPad(2);
		thingLeaveDaysField.setFormat("#,###,###,###,###,##0.00");
		thingLeaveDaysField.setRequired(false);
		thingLeaveDaysField.setHidden(false);


		thingLeaveHoursField = new DataSourceFloatField("thingLeaveHours", "事假小时数");
		thingLeaveHoursField.setLength(18);
		thingLeaveHoursField.setDecimalPad(2);
		thingLeaveHoursField.setFormat("#,###,###,###,###,##0.00");
		thingLeaveHoursField.setRequired(false);
		thingLeaveHoursField.setHidden(false);


		illLeaveDaysField = new DataSourceFloatField("illLeaveDays", "病假天数");
		illLeaveDaysField.setLength(18);
		illLeaveDaysField.setDecimalPad(2);
		illLeaveDaysField.setFormat("#,###,###,###,###,##0.00");
		illLeaveDaysField.setRequired(false);
		illLeaveDaysField.setHidden(false);
		
		illLeaveHoursField = new DataSourceFloatField("illLeaveHours", "病假小时数");
		illLeaveHoursField.setLength(18);
		illLeaveHoursField.setDecimalPad(2);
		illLeaveHoursField.setFormat("#,###,###,###,###,##0.00");
		illLeaveHoursField.setRequired(false);
		illLeaveHoursField.setHidden(false);


		illPercentStrField = new DataSourceTextField("illPercentStr", "病假扣款比例");
		illPercentStrField.setLength(64);
		illPercentStrField.setRequired(false);
		illPercentStrField.setHidden(false);


		illPercentField = new DataSourceFloatField("illPercent", "病假扣款比例(计算用)");
		illPercentField.setLength(18);
		illPercentField.setDecimalPad(2);
		illPercentField.setFormat("#,###,###,###,###,##0.00");
		illPercentField.setRequired(false);
		illPercentField.setHidden(true);


		lateLeaveTotalField = new DataSourceFloatField("lateLeaveTotal", "迟到小计");
		lateLeaveTotalField.setLength(18);
		lateLeaveTotalField.setDecimalPad(2);
		lateLeaveTotalField.setFormat("#,###,###,###,###,##0.00");
		lateLeaveTotalField.setRequired(false);
		lateLeaveTotalField.setHidden(false);


		thingTotalField = new DataSourceFloatField("thingTotal", "事假小计");
		thingTotalField.setLength(18);
		thingTotalField.setDecimalPad(2);
		thingTotalField.setFormat("#,###,###,###,###,##0.00");
		thingTotalField.setRequired(false);
		thingTotalField.setHidden(false);


		illTotalField = new DataSourceFloatField("illTotal", "病假小计");
		illTotalField.setLength(18);
		illTotalField.setDecimalPad(2);
		illTotalField.setFormat("#,###,###,###,###,##0.00");
		illTotalField.setRequired(false);
		illTotalField.setHidden(false);


		deductTotalField = new DataSourceFloatField("deductTotal", "扣款小计");
		deductTotalField.setLength(18);
		deductTotalField.setDecimalPad(2);
		deductTotalField.setFormat("#,###,###,###,###,##0.00");
		deductTotalField.setRequired(false);
		deductTotalField.setHidden(true);

		remarkField = new DataSourceTextField("remark", "考勤备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		isLockedField = new DataSourceBooleanField("isLocked", "是否加锁");
		isLockedField.setLength(64);
		isLockedField.setRequired(false);
		isLockedField.setHidden(true);
		

		setFields(employeePaymentDetailIdField, employeeIdField,employeeNoField,employeeNameField,companyIdField,departmentIdField,detailDateField, detailWeekField, monthWorkDayField, monthTotalDayField, dayWorkTimeField, monthPayField, basicProportionStrField, basicProportionField, monthBasicPayField, monthPerformancePayField, foremanPayField, dayForemanPayField,allSalaryField, unitTotalFundField, unitTotalInsuranceField, dayPayField,dayAttendanceDeductionField, dayCostField, lateLeave10mField, lateLeave30mField, lateLeaveField, thingLeaveDaysField, thingLeaveHoursField, illLeaveDaysField,illLeaveHoursField, illPercentStrField, illPercentField, lateLeaveTotalField, thingTotalField, illTotalField, deductTotalField, remarkField,isLockedField);
	}


}

