package com.pomplatform.client.salaryexceptions.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSalaryException extends DBDataSource
{


	public static DSSalaryException instance = null;

	public static DSSalaryException getInstance() {
		if(instance == null) {
			instance = new DSSalaryException("DSSalaryException");
		}
		return instance;
	}

	private final DataSourceIntegerField salaryExceptionIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceTextField employeeIdField;
	private final DataSourceTextField reasonField;
	private final DataSourceFloatField attendanceDeductionField;
	private final DataSourceDateField recordDateField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField remarkField;
	private final DataSourceBooleanField isApplyField; 
	private final DataSourceFloatField actuallyDeductionField;

	public DSSalaryException(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("SalaryException");


		salaryExceptionIdField = new DataSourceIntegerField("salaryExceptionId", "主键编码");
		salaryExceptionIdField.setLength(11);
		salaryExceptionIdField.setPrimaryKey(true);
		salaryExceptionIdField.setRequired(true);
		salaryExceptionIdField.setHidden(true);


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(true);


		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(true);


		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "人事业务编码");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setRequired(false);
		personnelBusinessIdField.setHidden(true);


		employeeIdField = new DataSourceTextField("employeeId", "员工姓名");
		employeeIdField.setLength(64);
		employeeIdField.setCanEdit(false);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		
		
		recordDateField = new DataSourceDateField("recordDate", "考勤异常日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);
		recordDateField.setCanEdit(false);


		attendanceDeductionField = new DataSourceFloatField("attendanceDeduction", "考勤扣除金额");
		attendanceDeductionField.setLength(18);
		attendanceDeductionField.setCanEdit(false);
		attendanceDeductionField.setDecimalPad(2);
		attendanceDeductionField.setFormat("#,###,###,###,###,##0.00");
		attendanceDeductionField.setRequired(false);
		attendanceDeductionField.setHidden(false);

		reasonField = new DataSourceTextField("reason", "扣款原因");
		reasonField.setLength(256);
		reasonField.setCanEdit(false);
		reasonField.setRequired(false);
		reasonField.setHidden(false);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);
//		remarkField.setRequired(true);


		isApplyField = new DataSourceBooleanField("isApply", "是否已申请");
		isApplyField.setRequired(false);
		isApplyField.setHidden(true);
		isApplyField.setCanEdit(false);

		
		actuallyDeductionField = new DataSourceFloatField("actuallyDeduction", "申请补回金额");
		actuallyDeductionField.setLength(18);
		actuallyDeductionField.setDecimalPad(2);
		actuallyDeductionField.setFormat("#,###,###,###,###,##0.00");
		actuallyDeductionField.setRequired(false);
		actuallyDeductionField.setHidden(false);

		setFields(salaryExceptionIdField, yearField, monthField, personnelBusinessIdField, employeeIdField, reasonField, attendanceDeductionField, recordDateField, operateTimeField, remarkField, isApplyField, actuallyDeductionField);
	}


}

