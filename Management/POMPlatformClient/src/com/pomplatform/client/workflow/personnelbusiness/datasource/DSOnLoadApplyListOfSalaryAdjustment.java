package com.pomplatform.client.workflow.personnelbusiness.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnLoadApplyListOfSalaryAdjustment extends DBDataSource
{


	public static DSOnLoadApplyListOfSalaryAdjustment instance = null;

	public static DSOnLoadApplyListOfSalaryAdjustment getInstance() {
		if(instance == null) {
			instance = new DSOnLoadApplyListOfSalaryAdjustment("DSOnLoadApplyListOfSalaryAdjustment");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField targetProvinceField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceDateTimeField startDateField;
	private final DataSourceDateTimeField endDateField;
	private final DataSourceFloatField feeField;
	private final DataSourceTextField originalPayField;
	private final DataSourceFloatField severanceField;
	private final DataSourceTextField monthPayField;
	private final DataSourceTextField subTypeField;
	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceTextField remarkField;

	public DSOnLoadApplyListOfSalaryAdjustment(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadApplyListOfSalaryAdjustment");


		employeeIdField = new DataSourceIntegerField("employeeId", "姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setLength(32);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);


		targetProvinceField = new DataSourceIntegerField("targetProvince", "业务部门");
		targetProvinceField.setLength(11);
		targetProvinceField.setRequired(false);
		targetProvinceField.setHidden(false);
		targetProvinceField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		startDateField = new DataSourceDateTimeField("startDate", "入职日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);


		endDateField = new DataSourceDateTimeField("endDate", "调薪日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);


		feeField = new DataSourceFloatField("fee", "个人效益指数");
		feeField.setLength(18);
		feeField.setDecimalPad(2);
		feeField.setFormat("#,###,###,###,###,##0.00");
		feeField.setRequired(false);
		feeField.setHidden(false);


		originalPayField = new DataSourceTextField("originalPay", "现薪资");
		originalPayField.setLength(64);
		originalPayField.setRequired(false);
		originalPayField.setHidden(false);


		severanceField = new DataSourceFloatField("severance", "调薪金额");
		severanceField.setLength(18);
		severanceField.setDecimalPad(2);
		severanceField.setFormat("#,###,###,###,###,##0.00");
		severanceField.setRequired(false);
		severanceField.setHidden(false);


		monthPayField = new DataSourceTextField("monthPay", "调整后薪资总额");
		monthPayField.setLength(64);
		monthPayField.setRequired(false);
		monthPayField.setHidden(false);


		subTypeField = new DataSourceTextField("subType", "调薪比例（%）");
		subTypeField.setLength(255);
		subTypeField.setRequired(false);
		subTypeField.setHidden(false);


		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "人事业务编码");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setPrimaryKey(true);
		personnelBusinessIdField.setRequired(true);
		personnelBusinessIdField.setHidden(true);


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);
		processTypeField.setValueMap(KeyValueManager.getValueMap("system_process_types"));


		processIdField = new DataSourceIntegerField("processId", "流程编码");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "主键编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setPrimaryKey(true);
		processInstanceIdField.setRequired(true);
		processInstanceIdField.setHidden(true);


		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);
		businessIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setLength(11);
		processStatusField.setRequired(false);
		processStatusField.setHidden(true);
		processStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_120"));


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(false);
		
		
		setFields(personnelBusinessIdField, processInstanceIdField, employeeIdField, employeeNoField, targetProvinceField, departmentIdField, startDateField, endDateField, feeField, originalPayField, severanceField, monthPayField, subTypeField, processTypeField, processIdField, businessIdField, processStatusField,remarkField);
	}


}

