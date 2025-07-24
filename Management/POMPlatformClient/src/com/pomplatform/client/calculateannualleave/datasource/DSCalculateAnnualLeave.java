package com.pomplatform.client.calculateannualleave.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSCalculateAnnualLeave extends DBDataSource
{


	public static DSCalculateAnnualLeave instance = null;

	public static DSCalculateAnnualLeave getInstance() {
		if(instance == null) {
			instance = new DSCalculateAnnualLeave("DSCalculateAnnualLeave");
		}
		return instance;
	}

	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField departmentNameField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceFloatField currentYearTotalAnnualLeaveField;
	private final DataSourceFloatField currentYearUsageAmountAnnualField;
	private final DataSourceFloatField currentRemainingAmountAnnualField;
	private final DataSourceFloatField currentYearTotalWealfareLeaveField;
	private final DataSourceFloatField currentYearUsageAmountWealfareField;
	private final DataSourceFloatField currentRemainingAmountWealfareField;
	private final DataSourceFloatField lastYearTotalAnnualLeaveField;
	private final DataSourceFloatField lastYearUsageAmountAnnualField;
	private final DataSourceFloatField lastRemainingAmountAnnualField;
	private final DataSourceFloatField lastYearTotalWealfareLeaveField;
	private final DataSourceFloatField lastYearUsageAmountWealfareField;
	private final DataSourceFloatField lastRemainingAmountWealfareField;
	private final DataSourceFloatField lastRemainingLeaveField;
	private final DataSourceFloatField currentYearLeaveField;
	private final DataSourceFloatField currentYearUsedtimeField;
	private final DataSourceFloatField remainingOvertimeField;

	public DSCalculateAnnualLeave(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("OnHrManageProcess");


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(32);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);
		employeeNameField.setValueMap(KeyValueManager.getValueMap("departments"));


		departmentNameField = new DataSourceTextField("departmentName", "部门名称");
		departmentNameField.setLength(64);
		departmentNameField.setRequired(true);
		departmentNameField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);


		departmentIdField = new DataSourceIntegerField("departmentId", "员工部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		currentYearTotalAnnualLeaveField = new DataSourceFloatField("currentYearTotalAnnualLeave", "当年度年假(天)");
		currentYearTotalAnnualLeaveField.setLength(18);
		currentYearTotalAnnualLeaveField.setDecimalPad(2);
		currentYearTotalAnnualLeaveField.setFormat("#,###,###,###,###,##0.00");
		currentYearTotalAnnualLeaveField.setRequired(true);
		currentYearTotalAnnualLeaveField.setHidden(false);


		currentYearUsageAmountAnnualField = new DataSourceFloatField("currentYearUsageAmountAnnual", "当年度已使用(天)");
		currentYearUsageAmountAnnualField.setLength(18);
		currentYearUsageAmountAnnualField.setDecimalPad(2);
		currentYearUsageAmountAnnualField.setFormat("#,###,###,###,###,##0.00");
		currentYearUsageAmountAnnualField.setRequired(true);
		currentYearUsageAmountAnnualField.setHidden(false);


		currentRemainingAmountAnnualField = new DataSourceFloatField("currentRemainingAmountAnnual", "当年度剩余年假(天)");
		currentRemainingAmountAnnualField.setLength(8);
		currentRemainingAmountAnnualField.setDecimalPad(2);
		currentRemainingAmountAnnualField.setFormat("##,###,##0.00");
		currentRemainingAmountAnnualField.setRequired(true);
		currentRemainingAmountAnnualField.setHidden(false);


		currentYearTotalWealfareLeaveField = new DataSourceFloatField("currentYearTotalWealfareLeave", "当年度带薪病假(天)");
		currentYearTotalWealfareLeaveField.setLength(18);
		currentYearTotalWealfareLeaveField.setDecimalPad(2);
		currentYearTotalWealfareLeaveField.setFormat("#,###,###,###,###,##0.00");
		currentYearTotalWealfareLeaveField.setRequired(true);
		currentYearTotalWealfareLeaveField.setHidden(false);


		currentYearUsageAmountWealfareField = new DataSourceFloatField("currentYearUsageAmountWealfare", "当年度使用带薪病假(天)");
		currentYearUsageAmountWealfareField.setLength(18);
		currentYearUsageAmountWealfareField.setDecimalPad(2);
		currentYearUsageAmountWealfareField.setFormat("#,###,###,###,###,##0.00");
		currentYearUsageAmountWealfareField.setRequired(true);
		currentYearUsageAmountWealfareField.setHidden(false);


		currentRemainingAmountWealfareField = new DataSourceFloatField("currentRemainingAmountWealfare", "当年度剩余带薪病假(天)");
		currentRemainingAmountWealfareField.setLength(8);
		currentRemainingAmountWealfareField.setDecimalPad(2);
		currentRemainingAmountWealfareField.setFormat("##,###,##0.00");
		currentRemainingAmountWealfareField.setRequired(true);
		currentRemainingAmountWealfareField.setHidden(false);


		lastYearTotalAnnualLeaveField = new DataSourceFloatField("lastYearTotalAnnualLeave", "上年度年假(天)");
		lastYearTotalAnnualLeaveField.setLength(18);
		lastYearTotalAnnualLeaveField.setDecimalPad(2);
		lastYearTotalAnnualLeaveField.setFormat("#,###,###,###,###,##0.00");
		lastYearTotalAnnualLeaveField.setRequired(true);
		lastYearTotalAnnualLeaveField.setHidden(false);


		lastYearUsageAmountAnnualField = new DataSourceFloatField("lastYearUsageAmountAnnual", "上年度使用年假(天)");
		lastYearUsageAmountAnnualField.setLength(18);
		lastYearUsageAmountAnnualField.setDecimalPad(2);
		lastYearUsageAmountAnnualField.setFormat("#,###,###,###,###,##0.00");
		lastYearUsageAmountAnnualField.setRequired(true);
		lastYearUsageAmountAnnualField.setHidden(false);


		lastRemainingAmountAnnualField = new DataSourceFloatField("lastRemainingAmountAnnual", "上年度剩余年假(天)");
		lastRemainingAmountAnnualField.setLength(8);
		lastRemainingAmountAnnualField.setDecimalPad(0);
		lastRemainingAmountAnnualField.setFormat("##,###,##0.00");
		lastRemainingAmountAnnualField.setRequired(true);
		lastRemainingAmountAnnualField.setHidden(false);


		lastYearTotalWealfareLeaveField = new DataSourceFloatField("lastYearTotalWealfareLeave", "上年度企业福利假(天)");
		lastYearTotalWealfareLeaveField.setLength(18);
		lastYearTotalWealfareLeaveField.setDecimalPad(2);
		lastYearTotalWealfareLeaveField.setFormat("#,###,###,###,###,##0.00");
		lastYearTotalWealfareLeaveField.setRequired(true);
		lastYearTotalWealfareLeaveField.setHidden(false);


		lastYearUsageAmountWealfareField = new DataSourceFloatField("lastYearUsageAmountWealfare", "上年度使用企业福利假()");
		lastYearUsageAmountWealfareField.setLength(18);
		lastYearUsageAmountWealfareField.setDecimalPad(2);
		lastYearUsageAmountWealfareField.setFormat("#,###,###,###,###,##0.00");
		lastYearUsageAmountWealfareField.setRequired(true);
		lastYearUsageAmountWealfareField.setHidden(false);


		lastRemainingAmountWealfareField = new DataSourceFloatField("lastRemainingAmountWealfare", "上年度剩余企业福利假(天)");
		lastRemainingAmountWealfareField.setLength(8);
		lastRemainingAmountWealfareField.setDecimalPad(2);
		lastRemainingAmountWealfareField.setFormat("##,###,##0.00");
		lastRemainingAmountWealfareField.setRequired(true);
		lastRemainingAmountWealfareField.setHidden(false);

		lastRemainingLeaveField = new DataSourceFloatField("lastRemainingLeave", "上年度剩余加班(小时)");
		lastRemainingLeaveField.setLength(8);
		lastRemainingLeaveField.setDecimalPad(2);
		lastRemainingLeaveField.setFormat("##,###,##0.00");
		lastRemainingLeaveField.setRequired(true);
		lastRemainingLeaveField.setHidden(false);

		currentYearLeaveField = new DataSourceFloatField("currentYearLeave", "本年度加班(小时)");
		currentYearLeaveField.setLength(8);
		currentYearLeaveField.setDecimalPad(2);
		currentYearLeaveField.setFormat("##,###,##0.00");
		currentYearLeaveField.setRequired(true);
		currentYearLeaveField.setHidden(false);

		currentYearUsedtimeField = new DataSourceFloatField("currentYearUsedtime", "本年度使用调休假(小时)");
		currentYearUsedtimeField.setLength(8);
		currentYearUsedtimeField.setDecimalPad(2);
		currentYearUsedtimeField.setFormat("##,###,##0.00");
		currentYearUsedtimeField.setRequired(true);
		currentYearUsedtimeField.setHidden(false);

		remainingOvertimeField = new DataSourceFloatField("remainingOvertime", "剩余加班(小时)");
		remainingOvertimeField.setLength(8);
		remainingOvertimeField.setDecimalPad(2);
		remainingOvertimeField.setFormat("##,###,##0.00");
		remainingOvertimeField.setRequired(true);
		remainingOvertimeField.setHidden(false);


		setFields(employeeNoField, employeeNameField, departmentNameField, employeeIdField, departmentIdField, currentYearTotalAnnualLeaveField, currentYearUsageAmountAnnualField, currentRemainingAmountAnnualField,lastYearTotalAnnualLeaveField, lastYearUsageAmountAnnualField, lastRemainingAmountAnnualField, currentYearTotalWealfareLeaveField, currentYearUsageAmountWealfareField, currentRemainingAmountWealfareField,
				lastRemainingLeaveField,
				currentYearLeaveField,
				currentYearUsedtimeField,
				remainingOvertimeField);
	}


}

