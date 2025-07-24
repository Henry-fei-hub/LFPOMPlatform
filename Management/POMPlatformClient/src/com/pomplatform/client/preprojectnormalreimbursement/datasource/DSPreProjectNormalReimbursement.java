package com.pomplatform.client.preprojectnormalreimbursement.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.FieldType;

public class DSPreProjectNormalReimbursement extends DBDataSource
{


	public static DSPreProjectNormalReimbursement instance = null;

	public static DSPreProjectNormalReimbursement getInstance() {
		if(instance == null) {
			instance = new DSPreProjectNormalReimbursement("DSPreProjectNormalReimbursement");
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
	private final DataSourceIntegerField deleteFlagField;
	private final DataSourceIntegerField currencyField;
	private final DataSourceFloatField exchangeRateField;
	private final DataSourceField detailProjectNormalReimbursementDetail;
	private final DataSourceField detailNormalReimbursementLinkMainProject;
	private final DataSourceBooleanField relatedToContractField;
	private final DataSourceFloatField contractAmountField;
	private final DataSourceIntegerField receiveUnitIdField;
	private final DataSourceIntegerField purchaserDepartmentField;
	private final DataSourceIntegerField purchaserField;
	private final DataSourceTextField purchasingCategoryField;
	private final DataSourceIntegerField reimbursementTypeField;

	public DSPreProjectNormalReimbursement(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("PreProjectNormalReimbursement");


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
		processInstanceIdField.setValueMap(new java.util.HashMap());


		applyEmployeeIdField = new DataSourceIntegerField("applyEmployeeId", "起草人");
		applyEmployeeIdField.setLength(11);
		applyEmployeeIdField.setRequired(false);
		applyEmployeeIdField.setHidden(false);
		applyEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		employeeIdField = new DataSourceIntegerField("employeeId", "报销人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		departmentIdField = new DataSourceIntegerField("departmentId", "报销部门");
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
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("process_status"));


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
		completeTimeField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		strikeABalanceField = new DataSourceBooleanField("strikeABalance", "是否冲账");
		strikeABalanceField.setRequired(false);
		strikeABalanceField.setHidden(false);
		
		
		attachmentIdField = new DataSourceIntegerField("attachmentId", "附件ID");
		attachmentIdField.setLength(11);
		attachmentIdField.setRequired(false);
		attachmentIdField.setHidden(true);


		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setLength(512);
		attachmentNameField.setRequired(false);
		attachmentNameField.setHidden(false);


		attachmentField = new DataSourceLinkField("attachment", "附件");
		attachmentField.setLength(512);
		attachmentField.setRequired(false);
		attachmentField.setHidden(false);


		attachmentNumberField = new DataSourceIntegerField("attachmentNumber", "附件(张)");
		attachmentNumberField.setLength(11);
		attachmentNumberField.setRequired(false);
		attachmentNumberField.setHidden(false);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(true);


		reimbursementTypeField = new DataSourceIntegerField("reimbursementType", "报销类型");
		reimbursementTypeField.setLength(11);
		reimbursementTypeField.setRequired(false);
		reimbursementTypeField.setHidden(false);
		reimbursementTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_245"));

		isProjectField = new DataSourceBooleanField("isProject", "是否是项目上的报销，默认false");
		isProjectField.setRequired(false);
		isProjectField.setHidden(true);


		deleteFlagField = new DataSourceIntegerField("deleteFlag", "删除状态  0未删除    1已删除");
		deleteFlagField.setLength(11);
		deleteFlagField.setRequired(false);
		deleteFlagField.setHidden(true);
		

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
		
		detailProjectNormalReimbursementDetail = new DataSourceField("detailProjectNormalReimbursementDetail", FieldType.ANY);
		detailProjectNormalReimbursementDetail.setChildrenProperty(true);
		detailProjectNormalReimbursementDetail.setChildTagName("ProjectNormalReimbursementDetail");
		detailProjectNormalReimbursementDetail.setRequired(false);
		detailProjectNormalReimbursementDetail.setHidden(true);
		detailNormalReimbursementLinkMainProject = new DataSourceField("detailNormalReimbursementLinkMainProject", FieldType.ANY);
		detailNormalReimbursementLinkMainProject.setChildrenProperty(true);
		detailNormalReimbursementLinkMainProject.setChildTagName("NormalReimbursementLinkMainProject");
		detailNormalReimbursementLinkMainProject.setRequired(false);
		detailNormalReimbursementLinkMainProject.setHidden(true);

		setFields(projectNormalReimbursementIdField, codeField, processInstanceIdField, applyEmployeeIdField, employeeIdField, departmentIdField, reimbursementNameField, reimbursementTimeField, statusField, amountField, currencyField, exchangeRateField, applyTimeField, completeTimeField, remarkField, strikeABalanceField, attachmentNameField, attachmentIdField, attachmentField, attachmentNumberField, companyIdField,reimbursementTypeField, isProjectField, deleteFlagField, detailProjectNormalReimbursementDetail, detailNormalReimbursementLinkMainProject,relatedToContractField,contractAmountField,receiveUnitIdField,purchaserDepartmentField,purchaserField,purchasingCategoryField);
	}


}

