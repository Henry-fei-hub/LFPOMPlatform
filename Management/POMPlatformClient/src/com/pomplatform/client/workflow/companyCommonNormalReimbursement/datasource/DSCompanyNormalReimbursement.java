package com.pomplatform.client.workflow.companyCommonNormalReimbursement.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;

import java.util.LinkedHashMap;

import com.delicacy.client.data.DBDataSource;

public class DSCompanyNormalReimbursement extends DBDataSource
{


	public static DSCompanyNormalReimbursement instance = null;

	public static DSCompanyNormalReimbursement getInstance() {
		if(instance == null) {
			instance = new DSCompanyNormalReimbursement("DSNormalReimbursementWithDepartment");
		}
		return instance;
	}

	private final DataSourceIntegerField projectNormalReimbursementIdField;
	private final DataSourceTextField codeField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField applyEmployeeIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField reimbursementNameField;
	private final DataSourceDateTimeField reimbursementTimeField;
	private final DataSourceIntegerField statusField;
	private final DataSourceFloatField amountField;
	private final DataSourceDateTimeField applyTimeField;
	private final DataSourceDateTimeField completeTimeField;
	private final DataSourceTextField remarkField;
	private final DataSourceBooleanField strikeABalanceField;
	private final DataSourceLinkField attachmentField;
	private final DataSourceIntegerField attachmentNumberField;
	private final DataSourceIntegerField attachmentIdField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceBooleanField isProjectField;
	private final DataSourceIntegerField currencyField;
	private final DataSourceFloatField exchangeRateField;
	private final DataSourceField detailProjectNormalReimbursementDetail;
	private final DataSourceField detailNormalReimbursementLinkDepartment;
	private final DataSourceIntegerField receiveUnitManageIdField;

	public DSCompanyNormalReimbursement(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("NormalReimbursementWithDepartment");


		LinkedHashMap<String, String> strikeABalanceMap = new LinkedHashMap<>();
		strikeABalanceMap.put("true", "是");
		strikeABalanceMap.put("false", "否");
		
		
		projectNormalReimbursementIdField = new DataSourceIntegerField("projectNormalReimbursementId", "主键编码");
		projectNormalReimbursementIdField.setLength(11);
		projectNormalReimbursementIdField.setPrimaryKey(true);
		projectNormalReimbursementIdField.setRequired(true);
		projectNormalReimbursementIdField.setHidden(true);


		codeField = new DataSourceTextField("code", "报销编号");
		codeField.setLength(64);
		codeField.setRequired(false);
		codeField.setHidden(false);


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(true);


		applyEmployeeIdField = new DataSourceIntegerField("applyEmployeeId", "起草人");
		applyEmployeeIdField.setLength(11);
		applyEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		applyEmployeeIdField.setRequired(false);
		applyEmployeeIdField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "报销人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		departmentIdField = new DataSourceIntegerField("departmentId", "报销人所在部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		reimbursementNameField = new DataSourceTextField("reimbursementName", "主题");
		reimbursementNameField.setLength(256);
		reimbursementNameField.setRequired(false);
		reimbursementNameField.setHidden(false);


		reimbursementTimeField = new DataSourceDateTimeField("reimbursementTime", "报销时间");
		reimbursementTimeField.setRequired(false);
		reimbursementTimeField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(true);


		amountField = new DataSourceFloatField("amount", "报销总金额");
		amountField.setLength(18);
		amountField.setDecimalPad(5);
		amountField.setFormat("#,###,###,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);


		applyTimeField = new DataSourceDateTimeField("applyTime", "申请时间");
		applyTimeField.setRequired(false);
		applyTimeField.setHidden(false);


		completeTimeField = new DataSourceDateTimeField("completeTime", "完成时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);
		
		receiveUnitManageIdField = new DataSourceIntegerField("receiveUnitManageId", "收款单位");
		receiveUnitManageIdField.setLength(11);
		receiveUnitManageIdField.setRequired(false);
		receiveUnitManageIdField.setHidden(false);
//		receiveUnitManageIdField.setValueMap(KeyValueManager.getValueMap("receive_unit_manages_company"));
		KeyValueManager.loadValueMap("receive_unit_manages_company",receiveUnitManageIdField);

		strikeABalanceField = new DataSourceBooleanField("strikeABalance", "冲账");
		strikeABalanceField.setRequired(false);
		strikeABalanceField.setHidden(false);
		strikeABalanceField.setValueMap(strikeABalanceMap);


		attachmentField = new DataSourceLinkField("attachment", "附件");
		attachmentField.setLength(512);
		attachmentField.setRequired(false);
		attachmentField.setHidden(false);
		
		
		attachmentIdField = new DataSourceIntegerField("attachmentId", "附件ID");
		attachmentIdField.setLength(11);
		attachmentIdField.setRequired(false);
		attachmentIdField.setHidden(true);


		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setLength(512);
		attachmentNameField.setRequired(false);
		attachmentNameField.setHidden(false);


		attachmentNumberField = new DataSourceIntegerField("attachmentNumber", "附件(张)");
		attachmentNumberField.setLength(11);
		attachmentNumberField.setRequired(false);
		attachmentNumberField.setHidden(false);


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

		isProjectField = new DataSourceBooleanField("isProject", "是否是项目上的报销，默认false");
		isProjectField.setRequired(false);
		isProjectField.setHidden(true);

		detailProjectNormalReimbursementDetail = new DataSourceField("detailProjectNormalReimbursementDetail", FieldType.ANY);
		detailProjectNormalReimbursementDetail.setChildrenProperty(true);
		detailProjectNormalReimbursementDetail.setChildTagName("ProjectNormalReimbursementDetail");
		detailProjectNormalReimbursementDetail.setRequired(false);
		detailProjectNormalReimbursementDetail.setHidden(true);
		detailNormalReimbursementLinkDepartment = new DataSourceField("detailNormalReimbursementLinkDepartment", FieldType.ANY);
		detailNormalReimbursementLinkDepartment.setChildrenProperty(true);
		detailNormalReimbursementLinkDepartment.setChildTagName("NormalReimbursementLinkDepartment");
		detailNormalReimbursementLinkDepartment.setRequired(false);
		detailNormalReimbursementLinkDepartment.setHidden(true);

		setFields(projectNormalReimbursementIdField, codeField, reimbursementNameField, processInstanceIdField, applyEmployeeIdField, employeeIdField, departmentIdField, companyIdField, reimbursementTimeField, statusField, amountField, applyTimeField, completeTimeField, receiveUnitManageIdField, remarkField, strikeABalanceField, attachmentNameField, attachmentIdField, attachmentField, attachmentNumberField, isProjectField, detailProjectNormalReimbursementDetail, detailNormalReimbursementLinkDepartment, currencyField, exchangeRateField);
	}


}

