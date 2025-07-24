package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.fields.*;

public class DSEmployeeContractAuditOfWorkflow extends DBDataSource
{


	public static DSEmployeeContractAuditOfWorkflow instance = null;

	public static DSEmployeeContractAuditOfWorkflow getInstance() {
		if(instance == null) {
			instance = new DSEmployeeContractAuditOfWorkflow("DSEmployeeContractAuditOfWorkflow");
		}
		return instance;
	}

	private final DataSourceTextField processTypeNameField;
	private final DataSourceIntegerField processPooledTaskIdField;
	private final DataSourceIntegerField typeFlagField;
	private final DataSourceIntegerField processInstanceActivityIdField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField businessNameField;
	private final DataSourceIntegerField processActivityIdField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField nodeTypeField;
	private final DataSourceIntegerField activityIdField;
	private final DataSourceIntegerField nextActivityIdField;
	private final DataSourceIntegerField mainActivityIdField;
	private final DataSourceDateTimeField instanceActivityCreateTimeField;
	private final DataSourceDateTimeField instanceActivityStartTimeField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField processCommentField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField activityTypeField;
	private final DataSourceTextField backViewNameField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField employeeContractAttachmentIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceTextField attachmentUrlField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceIntegerField contractTypeField;
	private final DataSourceIntegerField signTypeField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceIntegerField willEndField;
	private final DataSourceIntegerField attachmentIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceDateTimeField onboardDateField;
	private final DataSourceIntegerField employeeStatusField;


	public DSEmployeeContractAuditOfWorkflow(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("EmployeeContractAuditOfWorkflow");


		processTypeNameField = new DataSourceTextField("processTypeName", "流程类型名称");
		processTypeNameField.setLength(64);
		processTypeNameField.setRequired(false);
		processTypeNameField.setHidden(true);


		processPooledTaskIdField = new DataSourceIntegerField("processPooledTaskId", "主键编码");
		processPooledTaskIdField.setLength(11);
		processPooledTaskIdField.setPrimaryKey(true);
		processPooledTaskIdField.setRequired(true);
		processPooledTaskIdField.setHidden(true);


		typeFlagField = new DataSourceIntegerField("typeFlag", "typeFlag");
		typeFlagField.setLength(11);
		typeFlagField.setRequired(true);
		typeFlagField.setHidden(true);


		processInstanceActivityIdField = new DataSourceIntegerField("processInstanceActivityId", "主键编码");
		processInstanceActivityIdField.setLength(11);
		processInstanceActivityIdField.setPrimaryKey(true);
		processInstanceActivityIdField.setRequired(true);
		processInstanceActivityIdField.setHidden(true);


		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);


		businessNameField = new DataSourceTextField("businessName", "业务名称");
		businessNameField.setLength(256);
		businessNameField.setRequired(false);
		businessNameField.setHidden(true);


		processActivityIdField = new DataSourceIntegerField("processActivityId", "活动编码");
		processActivityIdField.setLength(11);
		processActivityIdField.setRequired(false);
		processActivityIdField.setHidden(true);


		processIdField = new DataSourceIntegerField("processId", "流程编码");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程实列编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(true);


		nodeTypeField = new DataSourceIntegerField("nodeType", "附加节点，说明节点是预定义的节点还是动态加的节点， 0 - 正常定义的节点， 1 - 申请人或者审批人加的处理人或者审批人");
		nodeTypeField.setLength(11);
		nodeTypeField.setRequired(false);
		nodeTypeField.setHidden(true);


		activityIdField = new DataSourceIntegerField("activityId", "当前流程实例节点的内部编码");
		activityIdField.setLength(11);
		activityIdField.setRequired(false);
		activityIdField.setHidden(true);


		nextActivityIdField = new DataSourceIntegerField("nextActivityId", "下一个流程节点的编码");
		nextActivityIdField.setLength(11);
		nextActivityIdField.setRequired(false);
		nextActivityIdField.setHidden(true);


		mainActivityIdField = new DataSourceIntegerField("mainActivityId", "如果是知会节点，所依附的主节点");
		mainActivityIdField.setLength(11);
		mainActivityIdField.setRequired(false);
		mainActivityIdField.setHidden(true);


		instanceActivityCreateTimeField = new DataSourceDateTimeField("instanceActivityCreateTime", "流程实例节点创建时间");
		instanceActivityCreateTimeField.setRequired(false);
		instanceActivityCreateTimeField.setHidden(true);


		instanceActivityStartTimeField = new DataSourceDateTimeField("instanceActivityStartTime", "流程实例节点开始处于活动时间");
		instanceActivityStartTimeField.setRequired(false);
		instanceActivityStartTimeField.setHidden(true);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);


		processCommentField = new DataSourceTextField("processComment", "提交意见");
		processCommentField.setLength(512);
		processCommentField.setRequired(false);
		processCommentField.setHidden(true);


		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(true);


		activityTypeField = new DataSourceIntegerField("activityType", "节点类型 0 - 开始 1 - 结束 2 - 审批 3 - 处理 4 - 知会");
		activityTypeField.setLength(11);
		activityTypeField.setRequired(false);
		activityTypeField.setHidden(true);


		backViewNameField = new DataSourceTextField("backViewName", "返回数据集");
		backViewNameField.setLength(64);
		backViewNameField.setRequired(false);
		backViewNameField.setHidden(true);


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);


		employeeContractAttachmentIdField = new DataSourceIntegerField("employeeContractAttachmentId", "主键编码");
		employeeContractAttachmentIdField.setLength(11);
		employeeContractAttachmentIdField.setPrimaryKey(true);
		employeeContractAttachmentIdField.setRequired(true);
		employeeContractAttachmentIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "员工姓名");
		KeyValueManager.loadValueMap("employees",employeeIdField);
		employeeIdField.setRequired(true);
		employeeIdField.setHidden(false);

		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setCanEdit(false);

		plateIdField= new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));
		plateIdField.setCanEdit(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "所属部门");
		departmentIdField.setCanEdit(true);
		departmentIdField.setHidden(true);

		onboardDateField = new DataSourceDateTimeField("onboardDate", "入职日期");
		onboardDateField.setCanEdit(false);

		employeeStatusField = new DataSourceIntegerField("employeeStatus", "职员状态");
		employeeStatusField.setCanEdit(false);
		employeeStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));


		attachmentNameField = new DataSourceTextField("attachmentName", "合同名称");
		attachmentNameField.setLength(32);
		attachmentNameField.setRequired(false);
		attachmentNameField.setHidden(true);


		attachmentUrlField = new DataSourceTextField("attachmentUrl", "附件路径");
		attachmentUrlField.setLength(128);
		attachmentUrlField.setRequired(false);
		attachmentUrlField.setHidden(false);
		attachmentUrlField.setType(FieldType.LINK);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(true);


		contractTypeField = new DataSourceIntegerField("contractType", "合同类型");
		contractTypeField.setLength(11);
		contractTypeField.setRequired(false);
		contractTypeField.setHidden(true);
		contractTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_111"));


		signTypeField = new DataSourceIntegerField("signType", "签订类型");
		signTypeField.setLength(11);
		signTypeField.setRequired(false);
		signTypeField.setHidden(true);
		signTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_112"));


		startDateField = new DataSourceDateField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(true);


		endDateField = new DataSourceDateField("endDate", "结束日期");
		endDateField.setRequired(false);
		endDateField.setHidden(true);


		willEndField = new DataSourceIntegerField("willEnd", "一个月到期(0未到期；1即将到期；2已过期)");
		willEndField.setLength(11);
		willEndField.setRequired(false);
		willEndField.setHidden(true);


		attachmentIdField = new DataSourceIntegerField("attachmentId", "附件编码");
		attachmentIdField.setLength(11);
		attachmentIdField.setRequired(false);
		attachmentIdField.setHidden(true);


//		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
//		employeeNoField.setLength(32);
//		employeeNoField.setRequired(false);
//		employeeNoField.setHidden(true);
//
//
//		departmentIdField = new DataSourceIntegerField("departmentId", "部门编码");
//		departmentIdField.setLength(11);
//		departmentIdField.setRequired(false);
//		departmentIdField.setHidden(true);
//		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));
//
//
//		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
//		plateIdField.setLength(11);
//		plateIdField.setRequired(false);
//		plateIdField.setHidden(true);
//
//
//		onboardDateField = new DataSourceDateTimeField("onboardDate", "入职日期");
//		onboardDateField.setRequired(false);
//		onboardDateField.setHidden(true);
//
//
//		employeeStatusField = new DataSourceIntegerField("employeeStatus", "职员状态");
//		employeeStatusField.setLength(11);
//		employeeStatusField.setRequired(false);
//		employeeStatusField.setHidden(true);


		setFields(processPooledTaskIdField, processInstanceActivityIdField, employeeContractAttachmentIdField, processTypeNameField, typeFlagField, businessIdField, businessNameField, processActivityIdField, processIdField, processInstanceIdField, nodeTypeField, activityIdField, nextActivityIdField, mainActivityIdField, instanceActivityCreateTimeField, instanceActivityStartTimeField, operateTimeField, processCommentField, statusField, activityTypeField, backViewNameField, processTypeField, employeeIdField, attachmentNameField, operateEmployeeIdField, contractTypeField, signTypeField, startDateField, endDateField, willEndField, attachmentIdField, employeeNoField, departmentIdField, plateIdField, onboardDateField, employeeStatusField , attachmentUrlField);
	}


}

