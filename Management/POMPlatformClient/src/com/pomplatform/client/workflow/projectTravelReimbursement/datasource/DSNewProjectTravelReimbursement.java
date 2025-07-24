package com.pomplatform.client.workflow.projectTravelReimbursement.datasource;

import java.util.LinkedHashMap;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.FieldType;

public class DSNewProjectTravelReimbursement extends DBDataSource
{


	public static DSNewProjectTravelReimbursement instance = null;

	public static DSNewProjectTravelReimbursement getInstance() {
		if(instance == null) {
			instance = new DSNewProjectTravelReimbursement("DSNewProjectTravelReimbursement");
		}
		return instance;
	}

	private final DataSourceIntegerField travelReimbursementIdField;
	private final DataSourceTextField codeField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceTextField titleField;
	private final DataSourceIntegerField applicantField;
	private final DataSourceIntegerField drafterField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceDateTimeField reimbursementTimeField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceFloatField amountField;
	private final DataSourceBooleanField strikeABalanceField;
	private final DataSourceTextField remarkField;
	private final DataSourceDateTimeField applyTimeField;
	private final DataSourceDateTimeField completeTimeField;
	private final DataSourceLinkField attachmentField;
	private final DataSourceIntegerField attachmentIdField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceIntegerField attachmentNumberField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField currencyField;
	private final DataSourceFloatField exchangeRateField;
	private final DataSourceField detailTravelReimbursementDetail;
	private final DataSourceField detailTravelReimbursementLinkProject;
	private final DataSourceFloatField whiteStripField;
	private final DataSourceBooleanField relatedToContractField;
	private final DataSourceFloatField contractAmountField;
	private final DataSourceIntegerField receiveUnitIdField;
	private final DataSourceIntegerField purchaserDepartmentField;
	private final DataSourceIntegerField purchaserField;
	private final DataSourceTextField purchasingCategoryField;
	

	public DSNewProjectTravelReimbursement(String dataSourceID) {
		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("NewProjectTravelReimbursement");

		
		LinkedHashMap strikeABalanceMap = new LinkedHashMap<>();
		strikeABalanceMap.put("true", "是");
		strikeABalanceMap.put("false", "否");

		
		travelReimbursementIdField = new DataSourceIntegerField("travelReimbursementId", "差旅报销编码");
		travelReimbursementIdField.setLength(11);
		travelReimbursementIdField.setPrimaryKey(true);
		travelReimbursementIdField.setRequired(true);
		travelReimbursementIdField.setHidden(true);


		codeField = new DataSourceTextField("code", "报销编号");
		codeField.setLength(64);
		codeField.setRequired(false);
		codeField.setHidden(false);


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(true);


		titleField = new DataSourceTextField("title", "主题");
		titleField.setLength(128);
		titleField.setRequired(false);
		titleField.setHidden(false);


		applicantField = new DataSourceIntegerField("applicant", "报销人");
		applicantField.setLength(11);
		applicantField.setRequired(false);
		applicantField.setHidden(false);
		applicantField.setValueMap(KeyValueManager.getValueMap("employees"));


		drafterField = new DataSourceIntegerField("drafter", "起草人");
		drafterField.setLength(11);
		drafterField.setRequired(false);
		drafterField.setHidden(false);
		drafterField.setValueMap(KeyValueManager.getValueMap("employees"));


		departmentIdField = new DataSourceIntegerField("departmentId", "报销人所在部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


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
		amountField.setDecimalPad(5);
		amountField.setFormat("#,###,###,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);

		whiteStripField = new DataSourceFloatField("whiteStrip", "白条金额");
		whiteStripField.setLength(18);
		whiteStripField.setDecimalPad(5);
		whiteStripField.setFormat("#,###,###,###,##0.00");
		whiteStripField.setRequired(false);
		whiteStripField.setHidden(false);

		strikeABalanceField = new DataSourceBooleanField("strikeABalance", "冲账");
		strikeABalanceField.setRequired(false);
		strikeABalanceField.setHidden(false);
		strikeABalanceField.setValueMap(strikeABalanceMap);


		remarkField = new DataSourceTextField("remark", "报销事由");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		applyTimeField = new DataSourceDateTimeField("applyTime", "申请时间");
		applyTimeField.setRequired(false);
		applyTimeField.setHidden(false);


		completeTimeField = new DataSourceDateTimeField("completeTime", "完成时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(true);


		attachmentField = new DataSourceLinkField("attachment", "附件");
		attachmentField.setLength(512);
		attachmentField.setRequired(false);
		attachmentField.setHidden(false);


		attachmentNumberField = new DataSourceIntegerField("attachmentNumber", "附件数量");
		attachmentNumberField.setLength(11);
		attachmentNumberField.setRequired(false);
		attachmentNumberField.setHidden(false);
		
		
		attachmentIdField = new DataSourceIntegerField("attachmentId", "附件ID");
		attachmentIdField.setLength(11);
		attachmentIdField.setRequired(false);
		attachmentIdField.setHidden(true);


		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setLength(512);
		attachmentNameField.setRequired(false);
		attachmentNameField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(true);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		
		
		currencyField = new DataSourceIntegerField("currency", "货币种类");
		currencyField.setLength(11);
		currencyField.setRequired(false);
		currencyField.setHidden(false);
		currencyField.setValueMap(KeyValueManager.getValueMap("system_dictionary_40"));
		
		exchangeRateField = new DataSourceFloatField("exchangeRate", "汇率");
		exchangeRateField.setLength(18);
		exchangeRateField.setDecimalPad(4);
		exchangeRateField.setFormat("#,###,###,###,##0.0000");
		exchangeRateField.setRequired(false);
		exchangeRateField.setHidden(false);


		relatedToContractField = new DataSourceBooleanField("relatedToContract", "与合同或协议有关");
		relatedToContractField.setRequired(false);
		relatedToContractField.setHidden(false);
		

		contractAmountField = new DataSourceFloatField("contractAmount", "合同金额");
		contractAmountField.setLength(18);
		contractAmountField.setDecimalPad(2);
		contractAmountField.setFormat("#,###,###,###,###,##0.00");
		contractAmountField.setRequired(false);
		contractAmountField.setHidden(false);

		
		receiveUnitIdField = new DataSourceIntegerField("receiveUnitId", "供应商");
		receiveUnitIdField.setLength(11);
		receiveUnitIdField.setRequired(false);
		receiveUnitIdField.setHidden(false);
		KeyValueManager.loadValueMap("receive_unit_manages_company", receiveUnitIdField);
		
		
		purchaserDepartmentField = new DataSourceIntegerField("purchaserDepartment", "采购人归属部门");
		purchaserDepartmentField.setLength(11);
		purchaserDepartmentField.setRequired(false);
		purchaserDepartmentField.setHidden(false);
		KeyValueManager.loadValueMap("departments", purchaserDepartmentField);
		
		
		purchaserField = new DataSourceIntegerField("purchaser", "采购人");
		purchaserField.setLength(11);
		purchaserField.setRequired(false);
		purchaserField.setHidden(false);
		KeyValueManager.loadValueMap("employees", purchaserField);
		
		
		purchasingCategoryField = new DataSourceTextField("purchasingCategory", "采购类别");
		purchasingCategoryField.setLength(255);
		purchasingCategoryField.setRequired(false);
		purchasingCategoryField.setHidden(false);

		detailTravelReimbursementDetail = new DataSourceField("detailTravelReimbursementDetail", FieldType.ANY);
		detailTravelReimbursementDetail.setChildrenProperty(true);
		detailTravelReimbursementDetail.setChildTagName("TravelReimbursementDetail");
		detailTravelReimbursementDetail.setRequired(false);
		detailTravelReimbursementDetail.setHidden(true);
		detailTravelReimbursementLinkProject = new DataSourceField("detailTravelReimbursementLinkProject", FieldType.ANY);
		detailTravelReimbursementLinkProject.setChildrenProperty(true);
		detailTravelReimbursementLinkProject.setChildTagName("TravelReimbursementLinkProject");
		detailTravelReimbursementLinkProject.setRequired(false);
		detailTravelReimbursementLinkProject.setHidden(true);

		setFields(travelReimbursementIdField, codeField, processInstanceIdField, titleField, applicantField, drafterField, departmentIdField, companyIdField, reimbursementTimeField, startDateField, endDateField, amountField, currencyField, exchangeRateField, strikeABalanceField, remarkField, applyTimeField, completeTimeField, attachmentField, attachmentIdField, attachmentNameField, attachmentNumberField, statusField, detailTravelReimbursementDetail, detailTravelReimbursementLinkProject,whiteStripField,relatedToContractField,contractAmountField,receiveUnitIdField,purchaserDepartmentField,purchaserField,purchasingCategoryField);
	}


}

