package com.pomplatform.client.projectattachmentmanage.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSProjectAttachmentManage extends DBDataSource
{


	public static DSProjectAttachmentManage instance = null;

	public static DSProjectAttachmentManage getInstance() {
		if(instance == null) {
			instance = new DSProjectAttachmentManage("DSProjectAttachmentManage");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField sheetCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField projectAttachmentIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField stageIdField;
	private final DataSourceDateTimeField uploadTimeField;
	private final DataSourceLinkField attachmentFileField;
	private final DataSourceTextField remarkField;
	private final DataSourceBooleanField isHandleField;
	private final DataSourceBooleanField isSameContractField;
	private final DataSourceBooleanField isSameStageField;
	private final DataSourceBooleanField isHasSignField;
	private final DataSourceBooleanField isHasSealField;
	private final DataSourceBooleanField isSureField;
	private final DataSourceBooleanField isEmailSureField;
	private final DataSourceBooleanField isOtherSureField;
	private final DataSourceBooleanField isQualifiedField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;

	public DSProjectAttachmentManage(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ProjectAttachmentManage");

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		sheetCodeField = new DataSourceTextField("sheetCode", "订单编号");
		sheetCodeField.setLength(64);
		sheetCodeField.setRequired(true);
		sheetCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "订单名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		projectAttachmentIdField = new DataSourceIntegerField("projectAttachmentId", "主键编码");
		projectAttachmentIdField.setLength(11);
		projectAttachmentIdField.setPrimaryKey(true);
		projectAttachmentIdField.setRequired(true);
		projectAttachmentIdField.setHidden(true);


		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects", projectIdField);

		stageIdField = new DataSourceIntegerField("stageId", "项目阶段");
		stageIdField.setLength(11);
		stageIdField.setRequired(false);
		stageIdField.setHidden(false);
		stageIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));


		uploadTimeField = new DataSourceDateTimeField("uploadTime", "上传时间");
		uploadTimeField.setRequired(false);
		uploadTimeField.setHidden(false);


		attachmentFileField = new DataSourceLinkField("attachmentFile", "附件");
		attachmentFileField.setLength(128);
		attachmentFileField.setRequired(false);
		attachmentFileField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(true);


		isHandleField = new DataSourceBooleanField("isHandle", "附件是否处理");
		isHandleField.setRequired(false);
		isHandleField.setHidden(true);


		isSameContractField = new DataSourceBooleanField("isSameContract", "是否是同一个合同");
		isSameContractField.setRequired(false);
		isSameContractField.setHidden(false);


		isSameStageField = new DataSourceBooleanField("isSameStage", "是否是同一个阶段");
		isSameStageField.setRequired(false);
		isSameStageField.setHidden(false);


		isHasSignField = new DataSourceBooleanField("isHasSign", "是否有对方的签字");
		isHasSignField.setRequired(false);
		isHasSignField.setHidden(false);


		isHasSealField = new DataSourceBooleanField("isHasSeal", "是否有对方的盖章");
		isHasSealField.setRequired(false);
		isHasSealField.setHidden(false);


		isSureField = new DataSourceBooleanField("isSure", "对方是否明确确认");
		isSureField.setRequired(false);
		isSureField.setHidden(false);
		
		isEmailSureField = new DataSourceBooleanField("isEmailSure", "邮件确认");
		isEmailSureField.setRequired(false);
		isEmailSureField.setHidden(false);
		
		isOtherSureField = new DataSourceBooleanField("isOtherSure", "其它确认");
		isOtherSureField.setRequired(false);
		isOtherSureField.setHidden(false);


		isQualifiedField = new DataSourceBooleanField("isQualified", "是否合格");
		isQualifiedField.setRequired(false);
		isQualifiedField.setHidden(false);
		
		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setHidden(true);
		operateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		
		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		setFields(plateIdField,projectAttachmentIdField, contractCodeField, sheetCodeField, projectNameField, projectIdField, stageIdField, uploadTimeField, attachmentFileField, remarkField, isHandleField, isSameContractField, isSameStageField, isHasSignField, isHasSealField, isSureField,isEmailSureField,isOtherSureField ,isQualifiedField,operateEmployeeIdField,operateTimeField);
	}


}

