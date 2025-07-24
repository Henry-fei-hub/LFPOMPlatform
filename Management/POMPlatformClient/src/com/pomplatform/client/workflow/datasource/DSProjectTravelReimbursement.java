package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSProjectTravelReimbursement extends DBDataSource
{


	public static DSProjectTravelReimbursement instance = null;

	public static DSProjectTravelReimbursement getInstance() {
		if(instance == null) {
			instance = new DSProjectTravelReimbursement("DSProjectTravelReimbursement");
		}
		return instance;
	}

	private final DataSourceIntegerField travelReimbursementIdField;
	private final DataSourceTextField travelReimbursementNoField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceTextField titleField;
	private final DataSourceIntegerField applicantField;
	private final DataSourceIntegerField drafterField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceDateTimeField reimbursementTimeField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceFloatField amountField;
	private final DataSourceBooleanField strikeABalanceField;
	private final DataSourceTextField remarkField;
	private final DataSourceDateTimeField applyTimeField;
	private final DataSourceDateTimeField completeTimeField;
	private final DataSourceLinkField attachmentField;
	private final DataSourceIntegerField attachmentNumberField;
	private final DataSourceIntegerField statusField;
	private final DataSourceField detailTravelReimbursementDetail;
	private final DataSourceTextField codeField;
	private final DataSourceIntegerField companyIdField;

	public DSProjectTravelReimbursement(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ProjectTravelReimbursement");


		travelReimbursementIdField = new DataSourceIntegerField("travelReimbursementId", "差旅报销编码");
		travelReimbursementIdField.setLength(11);
		travelReimbursementIdField.setPrimaryKey(true);
		travelReimbursementIdField.setRequired(true);
		travelReimbursementIdField.setHidden(true);


		travelReimbursementNoField = new DataSourceTextField("travelReimbursementNo", "报销编号");
		travelReimbursementNoField.setLength(64);
		travelReimbursementNoField.setRequired(false);
		travelReimbursementNoField.setHidden(true);


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(true);


		titleField = new DataSourceTextField("title", "主题");
		titleField.setLength(256);
		titleField.setRequired(false);
		titleField.setHidden(false);


		applicantField = new DataSourceIntegerField("applicant", "申请人");
		applicantField.setLength(11);
		applicantField.setRequired(false);
		applicantField.setHidden(false);
		applicantField.setValueMap(KeyValueManager.getValueMap("employees"));


		drafterField = new DataSourceIntegerField("drafter", "起草人");
		drafterField.setLength(11);
		drafterField.setRequired(false);
		drafterField.setHidden(false);
		drafterField.setValueMap(KeyValueManager.getValueMap("employees"));


		departmentIdField = new DataSourceIntegerField("departmentId", "报销部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments_true"));


		projectIdField = new DataSourceIntegerField("projectId", "所属项目");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);
		KeyValueManager.loadValueMap("projects",projectIdField);


		reimbursementTimeField = new DataSourceDateTimeField("reimbursementTime", "报销时间");
		reimbursementTimeField.setRequired(false);
		reimbursementTimeField.setHidden(true);


		startDateField = new DataSourceDateField("startDate", "出差开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);


		endDateField = new DataSourceDateField("endDate", "出差结束日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);


		amountField = new DataSourceFloatField("amount", "报销金额");
		amountField.setLength(18);
		amountField.setDecimalPad(2);
		amountField.setFormat("#,###,###,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);


		strikeABalanceField = new DataSourceBooleanField("strikeABalance", "冲账");
		strikeABalanceField.setRequired(false);
		strikeABalanceField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "报销事由");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		applyTimeField = new DataSourceDateTimeField("applyTime", "申请时间");
		applyTimeField.setRequired(false);
		applyTimeField.setHidden(false);


		completeTimeField = new DataSourceDateTimeField("completeTime", "完成时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(false);


		attachmentField = new DataSourceLinkField("attachment", "附件");
		attachmentField.setLength(512);
		attachmentField.setRequired(false);
		attachmentField.setHidden(false);


		attachmentNumberField = new DataSourceIntegerField("attachmentNumber", "附件数量");
		attachmentNumberField.setLength(11);
		attachmentNumberField.setRequired(false);
		attachmentNumberField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);

		detailTravelReimbursementDetail = new DataSourceField("detailTravelReimbursementDetail", FieldType.ANY);
		detailTravelReimbursementDetail.setChildrenProperty(true);
		detailTravelReimbursementDetail.setChildTagName("TravelReimbursementDetail");
		detailTravelReimbursementDetail.setRequired(false);
		detailTravelReimbursementDetail.setHidden(true);
		
		codeField = new DataSourceTextField("code", "编号");
		codeField.setHidden(false);
		
		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));

		setFields(travelReimbursementIdField, travelReimbursementNoField, processInstanceIdField, codeField, titleField, applicantField, drafterField, departmentIdField, projectIdField, companyIdField, reimbursementTimeField, startDateField, endDateField, amountField, strikeABalanceField, remarkField, applyTimeField, completeTimeField, attachmentField, attachmentNumberField, statusField, detailTravelReimbursementDetail);
	}


}

