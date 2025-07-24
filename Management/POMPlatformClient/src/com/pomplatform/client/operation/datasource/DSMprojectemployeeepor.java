package com.pomplatform.client.operation.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMprojectemployeeepor extends DBDataSource {

	public static DSMprojectemployeeepor instance = null;

	public static DSMprojectemployeeepor getInstance() {
		if (instance == null) {
			instance = new DSMprojectemployeeepor("DSMprojectemployeeepor");
		}
		return instance;
	}

	private final DataSourceImageField photoField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField workContentField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceFloatField integralField;
	private final DataSourceFloatField integralPercentField;
    private final DataSourceFloatField realIntegralField;
    private final DataSourceFloatField costField;
    private final DataSourceFloatField settlementField;
	private final DataSourceIntegerField statusField;
	private final DataSourceFloatField realIntegralPercentField;
	private final DataSourceFloatField costPercentField;

	public DSMprojectemployeeepor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mprojectemployeeepor");

		photoField = new DataSourceImageField("photo", "头像");
		photoField.setLength(512);
		photoField.setRequired(false);
		photoField.setHidden(false);
		photoField.setImageWidth(100);
		photoField.setImageHeight(100);

		employeeIdField = new DataSourceIntegerField("employeeId", "设计师");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		workContentField = new DataSourceTextField("workContent", "工作内容");
		workContentField.setLength(1024);
		workContentField.setRequired(false);
		workContentField.setHidden(false);

		startDateField = new DataSourceDateField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateField("endDate", "结束日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		integralField = new DataSourceFloatField("integral", "预分配积分");
		integralField.setLength(18);
        integralField.setFormat("#,###,###,###,###,##0.00");
		integralField.setRequired(true);
		integralField.setHidden(false);
                
		integralPercentField = new DataSourceFloatField("integralPercent", "预分配积分占比(%)");
		integralPercentField.setLength(18);
		integralPercentField.setFormat("#,###,###,###,###,##0.00");
		integralPercentField.setRequired(true);
		integralPercentField.setHidden(false);
		
        realIntegralField = new DataSourceFloatField("realIntegral", "分配积分");
		realIntegralField.setLength(18);
		realIntegralField.setDecimalPad(2);
		realIntegralField.setFormat("#,###,###,###,###,##0.00");
		realIntegralField.setRequired(true);
		realIntegralField.setHidden(false);


		costField = new DataSourceFloatField("cost", "分摊费用");
		costField.setLength(18);
		costField.setDecimalPad(2);
		costField.setFormat("#,###,###,###,###,##0.00");
		costField.setRequired(true);
		costField.setHidden(false);


		settlementField = new DataSourceFloatField("settlement", "最终获得");
		settlementField.setLength(18);
		settlementField.setDecimalPad(2);
		settlementField.setFormat("#,###,###,###,###,##0.00");
		settlementField.setRequired(true);
		settlementField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_5"));

		realIntegralPercentField = new DataSourceFloatField("realIntegralPercent", "确认积分占比(%)");
		realIntegralPercentField.setLength(18);
		realIntegralPercentField.setFormat("#,###,###,###,###,##0.00");
		realIntegralPercentField.setRequired(true);
		realIntegralPercentField.setHidden(false);
		
		costPercentField = new DataSourceFloatField("costPercent","项目成本占比(%)");
		costPercentField.setLength(18);
		costPercentField.setFormat("#,###,###,###,###,##0.00");
		costPercentField.setRequired(true);
		costPercentField.setHidden(false);
		
		setFields(photoField, employeeIdField, workContentField, startDateField, endDateField, integralField,integralPercentField,realIntegralField, costField, settlementField, statusField,realIntegralPercentField,costPercentField);
	}

}
