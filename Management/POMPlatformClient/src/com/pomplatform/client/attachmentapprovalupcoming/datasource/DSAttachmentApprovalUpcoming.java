package com.pomplatform.client.attachmentapprovalupcoming.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSAttachmentApprovalUpcoming extends DBDataSource
{


	public static DSAttachmentApprovalUpcoming instance = null;

	public static DSAttachmentApprovalUpcoming getInstance() {
		if(instance == null) {
			instance = new DSAttachmentApprovalUpcoming("DSAttachmentApprovalUpcoming");
		}
		return instance;
	}

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
	private final DataSourceLinkField fileUrlField;
	private final DataSourceIntegerField budgetAttachmentIdField;
	private final DataSourceIntegerField budgetManagementIdField;
	private final DataSourceIntegerField fileIdField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceIntegerField uploadEmployeeIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceDateTimeField uploadTimeField;
	private final DataSourceTextField uploadRemarkField;
	private final DataSourceFloatField budgetContractAmountField;
	private final DataSourceFloatField budgetContractAmountUseField;
	private final DataSourceFloatField budgetContractAmountRestField;
	private final DataSourceIntegerField receiveUnitManageIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField inputTaxInvoiceIdField;
	private final DataSourceTextField bddTypeField;
	private final DataSourceIntegerField isApprovalField;
	public DSAttachmentApprovalUpcoming(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("AttachmentApprovalUpcoming");


		processInstanceActivityIdField = new DataSourceIntegerField("processInstanceActivityId", "主键编码");
		processInstanceActivityIdField.setLength(11);
		processInstanceActivityIdField.setPrimaryKey(true);
		processInstanceActivityIdField.setRequired(true);
		processInstanceActivityIdField.setHidden(false);


		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(false);


		businessNameField = new DataSourceTextField("businessName", "业务名称");
		businessNameField.setLength(256);
		businessNameField.setRequired(false);
		businessNameField.setHidden(false);


		processActivityIdField = new DataSourceIntegerField("processActivityId", "活动编码");
		processActivityIdField.setLength(11);
		processActivityIdField.setRequired(false);
		processActivityIdField.setHidden(false);


		processIdField = new DataSourceIntegerField("processId", "流程编码");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(false);


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程实列编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(false);


		nodeTypeField = new DataSourceIntegerField("nodeType", "附加节点，说明节点是预定义的节点还是动态加的节点， 0 - 正常定义的节点， 1 - 申请人或者审批人加的处理人或者审批人");
		nodeTypeField.setLength(11);
		nodeTypeField.setRequired(false);
		nodeTypeField.setHidden(false);


		activityIdField = new DataSourceIntegerField("activityId", "当前流程实例节点的内部编码");
		activityIdField.setLength(11);
		activityIdField.setRequired(false);
		activityIdField.setHidden(false);


		nextActivityIdField = new DataSourceIntegerField("nextActivityId", "下一个流程节点的编码");
		nextActivityIdField.setLength(11);
		nextActivityIdField.setRequired(false);
		nextActivityIdField.setHidden(false);


		mainActivityIdField = new DataSourceIntegerField("mainActivityId", "如果是知会节点，所依附的主节点");
		mainActivityIdField.setLength(11);
		mainActivityIdField.setRequired(false);
		mainActivityIdField.setHidden(false);


		instanceActivityCreateTimeField = new DataSourceDateTimeField("instanceActivityCreateTime", "流程实例节点创建时间");
		instanceActivityCreateTimeField.setRequired(false);
		instanceActivityCreateTimeField.setHidden(false);


		instanceActivityStartTimeField = new DataSourceDateTimeField("instanceActivityStartTime", "流程实例节点开始处于活动时间");
		instanceActivityStartTimeField.setRequired(false);
		instanceActivityStartTimeField.setHidden(false);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		processCommentField = new DataSourceTextField("processComment", "提交意见");
		processCommentField.setLength(512);
		processCommentField.setRequired(false);
		processCommentField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);


		activityTypeField = new DataSourceIntegerField("activityType", "节点类型 0 - 开始 1 - 结束 2 - 审批 3 - 处理 4 - 知会");
		activityTypeField.setLength(11);
		activityTypeField.setRequired(false);
		activityTypeField.setHidden(true);


		backViewNameField = new DataSourceTextField("backViewName", "返回数据集");
		backViewNameField.setLength(64);
		backViewNameField.setRequired(false);
		backViewNameField.setHidden(true);



		budgetAttachmentIdField = new DataSourceIntegerField("budgetAttachmentId", "主键id");
		budgetAttachmentIdField.setLength(11);
		budgetAttachmentIdField.setPrimaryKey(true);
		budgetAttachmentIdField.setRequired(true);
		budgetAttachmentIdField.setHidden(false);


		budgetManagementIdField = new DataSourceIntegerField("budgetManagementId", "预算管理id");
		budgetManagementIdField.setLength(11);
		budgetManagementIdField.setRequired(false);
		budgetManagementIdField.setHidden(true);


		fileIdField = new DataSourceIntegerField("fileId", "附件编码");
		fileIdField.setLength(11);
		fileIdField.setRequired(false);
		fileIdField.setHidden(true);


		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setLength(1024);
		attachmentNameField.setRequired(false);
		attachmentNameField.setHidden(true);


		uploadEmployeeIdField = new DataSourceIntegerField("uploadEmployeeId", "上传人员");
		uploadEmployeeIdField.setLength(11);
		uploadEmployeeIdField.setRequired(false);
		uploadEmployeeIdField.setHidden(true);


		departmentIdField = new DataSourceIntegerField("departmentId", "上传人员归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(true);


		uploadTimeField = new DataSourceDateTimeField("uploadTime", "上传时间");
		uploadTimeField.setRequired(false);
		uploadTimeField.setHidden(true);


		uploadRemarkField = new DataSourceTextField("uploadRemark", "附件备注");
		uploadRemarkField.setLength(2048);
		uploadRemarkField.setRequired(false);
		uploadRemarkField.setHidden(true);


		budgetContractAmountField = new DataSourceFloatField("budgetContractAmount", "合同金额");
		budgetContractAmountField.setLength(18);
		budgetContractAmountField.setDecimalPad(2);
		budgetContractAmountField.setFormat("#,###,###,###,###,##0.00");
		budgetContractAmountField.setRequired(false);
		budgetContractAmountField.setHidden(true);


		budgetContractAmountUseField = new DataSourceFloatField("budgetContractAmountUse", "合同已付款金额");
		budgetContractAmountUseField.setLength(18);
		budgetContractAmountUseField.setDecimalPad(2);
		budgetContractAmountUseField.setFormat("#,###,###,###,###,##0.00");
		budgetContractAmountUseField.setRequired(false);
		budgetContractAmountUseField.setHidden(true);


		budgetContractAmountRestField = new DataSourceFloatField("budgetContractAmountRest", "剩余合同金额");
		budgetContractAmountRestField.setLength(18);
		budgetContractAmountRestField.setDecimalPad(2);
		budgetContractAmountRestField.setFormat("#,###,###,###,###,##0.00");
		budgetContractAmountRestField.setRequired(false);
		budgetContractAmountRestField.setHidden(true);


		receiveUnitManageIdField = new DataSourceIntegerField("receiveUnitManageId", "供应商");
		receiveUnitManageIdField.setLength(11);
		receiveUnitManageIdField.setRequired(false);
		receiveUnitManageIdField.setHidden(true);


		projectIdField = new DataSourceIntegerField("projectId", "项目id");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);


		inputTaxInvoiceIdField = new DataSourceIntegerField("inputTaxInvoiceId", "发票编码");
		inputTaxInvoiceIdField.setLength(11);
		inputTaxInvoiceIdField.setRequired(false);
		inputTaxInvoiceIdField.setHidden(true);


		bddTypeField = new DataSourceTextField("bddType", "预算类别  budget_detail_type");
		bddTypeField.setLength(255);
		bddTypeField.setRequired(false);
		bddTypeField.setHidden(true);


		isApprovalField = new DataSourceIntegerField("isApproval", "是否审批 0.未审批 1.审批进行中,2.已审批");
		isApprovalField.setLength(11);
		isApprovalField.setRequired(false);
		isApprovalField.setHidden(true);

		fileUrlField = new DataSourceLinkField("fileUrl", "文件路径");
		fileUrlField.setLength(1024);
		fileUrlField.setRequired(false);
		fileUrlField.setHidden(false);

		setFields(processInstanceActivityIdField, budgetAttachmentIdField, businessIdField, businessNameField, processActivityIdField, processIdField, processInstanceIdField, nodeTypeField, activityIdField, nextActivityIdField, mainActivityIdField, instanceActivityCreateTimeField, instanceActivityStartTimeField, operateTimeField, processCommentField, statusField, activityTypeField, backViewNameField, fileUrlField, budgetManagementIdField, fileIdField, attachmentNameField, uploadEmployeeIdField, departmentIdField, uploadTimeField, uploadRemarkField, budgetContractAmountField, budgetContractAmountUseField, budgetContractAmountRestField, receiveUnitManageIdField, projectIdField, inputTaxInvoiceIdField, bddTypeField, isApprovalField);
	}


}

