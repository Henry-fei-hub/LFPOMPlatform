package com.pomplatform.client.workflow.personnelbusiness.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSEmployeeSalaryAdjustmentDetail extends DBDataSource
{


	public static DSEmployeeSalaryAdjustmentDetail instance = null;

	public static DSEmployeeSalaryAdjustmentDetail getInstance() {
		if(instance == null) {
			instance = new DSEmployeeSalaryAdjustmentDetail("DSEmployeeSalaryAdjustmentDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField targetProvinceField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
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
	private final DataSourceIntegerField processInstanceActivityIdField;
	private final DataSourceIntegerField processActivityIdField;
	private final DataSourceIntegerField activityTypeField;
	private final DataSourceIntegerField nodeTypeField;
	private final DataSourceIntegerField activityIdField;
	private final DataSourceIntegerField nextActivityIdField;
	private final DataSourceIntegerField mainActivityIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField deleteFlagField;
	private final DataSourceIntegerField messageStatusField;
	private final DataSourceTextField businessNameField;
	private final DataSourceTextField backViewNameField;
	private final DataSourceDateTimeField instanceActivityCreateTimeField;
	private final DataSourceDateTimeField instanceActivityStartTimeField;
	private final DataSourceTextField remarkField;

	public DSEmployeeSalaryAdjustmentDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("EmployeeSalaryAdjustmentDetail");


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


		startDateField = new DataSourceDateField("startDate", "入职日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);


		endDateField = new DataSourceDateField("endDate", "调薪日期");
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
		originalPayField.setFormat("#,###,###,###,###,##0.00");
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
		monthPayField.setFormat("#,###,###,###,###,##0.00");
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


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程实列编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(true);

		businessIdField = new DataSourceIntegerField("businessId", "业务id");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);
		
		processInstanceActivityIdField = new DataSourceIntegerField("processInstanceActivityId", "流程实列节点ID");
		processInstanceActivityIdField.setLength(11);
		processInstanceActivityIdField.setRequired(false);
		processInstanceActivityIdField.setHidden(true);

		processActivityIdField = new DataSourceIntegerField("processActivityId", "流程节点ID");
		processActivityIdField.setLength(11);
		processActivityIdField.setRequired(false);
		processActivityIdField.setHidden(true);

		activityTypeField = new DataSourceIntegerField("activityType", "节点类型");
		activityTypeField.setLength(11);
		activityTypeField.setRequired(false);
		activityTypeField.setHidden(true);

		nodeTypeField = new DataSourceIntegerField("nodeType", "是否自定义添加的节点");
		nodeTypeField.setLength(11);
		nodeTypeField.setRequired(false);
		nodeTypeField.setHidden(true);
		 
		activityIdField = new DataSourceIntegerField("activityId", "节点序号");
		activityIdField.setLength(11);
		activityIdField.setRequired(false);
		activityIdField.setHidden(true);

		nextActivityIdField = new DataSourceIntegerField("nextActivityIdField", "下个节点序号");
		nextActivityIdField.setLength(11);
		nextActivityIdField.setRequired(false);
		nextActivityIdField.setHidden(true);

		mainActivityIdField = new DataSourceIntegerField("mainActivityId", "如果是知会节点，所依附的主节点");
		mainActivityIdField.setLength(11);
		mainActivityIdField.setRequired(false);
		mainActivityIdField.setHidden(true);
		
		statusField = new DataSourceIntegerField("status", "审批状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(true);

		deleteFlagField = new DataSourceIntegerField("deleteFlag", "删除状态");
		deleteFlagField.setLength(11);
		deleteFlagField.setRequired(false);
		deleteFlagField.setHidden(true);

		messageStatusField = new DataSourceIntegerField("messageStatus", "企业微信消息通知状态");
		messageStatusField.setLength(11);
		messageStatusField.setRequired(false);
		messageStatusField.setHidden(true);

		businessNameField = new DataSourceTextField("businessName", "实例业务名称");
		businessNameField.setLength(255);
		businessNameField.setRequired(false);
		businessNameField.setHidden(true);
		
		backViewNameField = new DataSourceTextField("backViewName", "节点名称");
		backViewNameField.setLength(255);
		backViewNameField.setRequired(false);
		backViewNameField.setHidden(true);
		
		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(true);

		instanceActivityCreateTimeField = new DataSourceDateTimeField("instanceActivityCreateTime", "节点创建时间");
		instanceActivityCreateTimeField.setRequired(false);
		instanceActivityCreateTimeField.setHidden(true);
		
		instanceActivityStartTimeField = new DataSourceDateTimeField("instanceActivityStartTime", "节点开始审批时间");
		instanceActivityStartTimeField.setRequired(false);
		instanceActivityStartTimeField.setHidden(true);
		
		setFields(personnelBusinessIdField, employeeIdField, employeeNoField, targetProvinceField, departmentIdField, startDateField, endDateField, feeField, originalPayField, severanceField, monthPayField, subTypeField, processTypeField, processIdField, processInstanceIdField, businessIdField, processInstanceActivityIdField, processActivityIdField, activityTypeField, nodeTypeField, activityIdField, nextActivityIdField,mainActivityIdField,	statusField, deleteFlagField, messageStatusField, businessNameField, backViewNameField, instanceActivityCreateTimeField, instanceActivityStartTimeField, remarkField);
	}


}

