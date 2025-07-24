package com.pomplatform.client.settlement.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnLoadProjectEmployeePerformance extends DBDataSource
{


	public static DSOnLoadProjectEmployeePerformance instance = null;

	public static DSOnLoadProjectEmployeePerformance getInstance() {
		if(instance == null) {
			instance = new DSOnLoadProjectEmployeePerformance("DSOnLoadProjectEmployeePerformance");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceFloatField planIntegralField;
	private final DataSourceFloatField integralField;
	private final DataSourceFloatField totalPerformanceIntegralField;
	private final DataSourceFloatField totalSureIntegralField;
	private final DataSourceFloatField totalCostField;
	private final DataSourceFloatField totalSettlementIntegralField;
	private final DataSourceIntegerField statusField;
	private final DataSourceBooleanField enabledField;

	public DSOnLoadProjectEmployeePerformance(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadProjectEmployeePerformance");


		projectIdField = new DataSourceIntegerField("projectId", "项目id");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects", projectIdField);

		employeeIdField = new DataSourceIntegerField("employeeId", "项目成员");
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


		planIntegralField = new DataSourceFloatField("planIntegral", "预分配积分");
		planIntegralField.setLength(0);
		planIntegralField.setDecimalPad(0);
		planIntegralField.setFormat("");
		planIntegralField.setRequired(false);
		planIntegralField.setHidden(false);


		integralField = new DataSourceFloatField("integral", "绩效积分");
		integralField.setLength(18);
		integralField.setDecimalPad(2);
		integralField.setFormat("#,###,###,###,###,##0.00");
		integralField.setRequired(true);
		integralField.setHidden(false);


		totalPerformanceIntegralField = new DataSourceFloatField("totalPerformanceIntegral", "历史结算绩效积分");
		totalPerformanceIntegralField.setLength(18);
		totalPerformanceIntegralField.setDecimalPad(2);
		totalPerformanceIntegralField.setFormat("#,###,###,###,###,##0.00");
		totalPerformanceIntegralField.setRequired(true);
		totalPerformanceIntegralField.setHidden(false);


		totalSureIntegralField = new DataSourceFloatField("totalSureIntegral", "历史确认积分");
		totalSureIntegralField.setLength(18);
		totalSureIntegralField.setDecimalPad(2);
		totalSureIntegralField.setFormat("#,###,###,###,###,##0.00");
		totalSureIntegralField.setRequired(true);
		totalSureIntegralField.setHidden(false);


		totalCostField = new DataSourceFloatField("totalCost", "历史分摊成本");
		totalCostField.setLength(18);
		totalCostField.setDecimalPad(2);
		totalCostField.setFormat("#,###,###,###,###,##0.00");
		totalCostField.setRequired(true);
		totalCostField.setHidden(false);


		totalSettlementIntegralField = new DataSourceFloatField("totalSettlementIntegral", "历史结算积分");
		totalSettlementIntegralField.setLength(18);
		totalSettlementIntegralField.setDecimalPad(2);
		totalSettlementIntegralField.setFormat("#,###,###,###,###,##0.00");
		totalSettlementIntegralField.setRequired(true);
		totalSettlementIntegralField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));


		enabledField = new DataSourceBooleanField("enabled", "是否可用");
		enabledField.setRequired(true);
		enabledField.setHidden(true);


		setFields(projectIdField, employeeIdField, employeeNoField, employeeNameField, planIntegralField, integralField, totalPerformanceIntegralField, totalSureIntegralField, totalCostField, totalSettlementIntegralField, statusField, enabledField);
	}


}

