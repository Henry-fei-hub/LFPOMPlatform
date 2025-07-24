package com.pomplatform.client.workflow.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSPayMoneyManageOfWorkflow extends DBDataSource
{


	public static DSPayMoneyManageOfWorkflow instance = null;

	public static DSPayMoneyManageOfWorkflow getInstance() {
		if(instance == null) {
			instance = new DSPayMoneyManageOfWorkflow("DSPayMoneyManageOfWorkflow");
		}
		return instance;
	}

	private final DataSourceIntegerField payMoneyManageIdField;
	private final DataSourceTextField receiveUnitField;
	private final DataSourceTextField bankAccountField;
	private final DataSourceTextField bankNameField;
	private final DataSourceTextField titleNameField;
	private final DataSourceFloatField payAmountField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceLinkField attachmentFileField;
	private final DataSourceIntegerField attachmentIdField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceTextField reasonField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField codeField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField currencyField;
	private final DataSourceFloatField exchangeRateField;
	private final DataSourceBooleanField relatedToContractField;
	private final DataSourceFloatField contractAmountField;
	private final DataSourceIntegerField receiveUnitIdField;
	private final DataSourceIntegerField purchaserDepartmentField;
	private final DataSourceIntegerField purchaserField;
	private final DataSourceTextField purchasingCategoryField;
	

	public DSPayMoneyManageOfWorkflow(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("PayMoneyManageOfWorkflow");


		payMoneyManageIdField = new DataSourceIntegerField("payMoneyManageId", "主键编码");
		payMoneyManageIdField.setLength(11);
		payMoneyManageIdField.setPrimaryKey(true);
		payMoneyManageIdField.setRequired(true);
		payMoneyManageIdField.setHidden(true);


		receiveUnitField = new DataSourceTextField("receiveUnit", "收款单位");
		receiveUnitField.setLength(128);
		receiveUnitField.setRequired(false);
		receiveUnitField.setHidden(false);


		bankAccountField = new DataSourceTextField("bankAccount", "银行账号");
		bankAccountField.setLength(64);
		bankAccountField.setRequired(false);
		bankAccountField.setHidden(false);


		bankNameField = new DataSourceTextField("bankName", "开户行");
		bankNameField.setLength(128);
		bankNameField.setRequired(false);
		bankNameField.setHidden(false);


		titleNameField = new DataSourceTextField("titleName", "主题名称");
		titleNameField.setLength(64);
		titleNameField.setRequired(false);
		titleNameField.setHidden(true);


		payAmountField = new DataSourceFloatField("payAmount", "付款金额");
		payAmountField.setLength(18);
		payAmountField.setDecimalPad(5);
		payAmountField.setFormat("#,###,###,###,##0.00");
		payAmountField.setRequired(false);
		payAmountField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "申请人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setLength(512);
		attachmentNameField.setRequired(false);
		attachmentNameField.setHidden(false);
		
		
		attachmentIdField = new DataSourceIntegerField("attachmentId", "附件ID");
		attachmentIdField.setLength(11);
		attachmentIdField.setRequired(false);
		attachmentIdField.setHidden(true);
		
		
		attachmentFileField = new DataSourceLinkField("attachmentFile", "附件");
		attachmentFileField.setLength(128);
		attachmentFileField.setRequired(false);
		attachmentFileField.setHidden(false);

		reasonField = new DataSourceTextField("reason", "付款原因");
		reasonField.setLength(256);
		reasonField.setRequired(false);
		reasonField.setHidden(false);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(false);
		operateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);
		
		codeField = new DataSourceTextField("code", "编号");
		codeField.setLength(64);
		codeField.setRequired(false);
		codeField.setHidden(false);
		
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
		

		setFields(payMoneyManageIdField,codeField,companyIdField, receiveUnitField, bankAccountField, bankNameField, titleNameField, payAmountField, employeeIdField,departmentIdField,attachmentNameField, attachmentIdField, attachmentFileField, reasonField, operateEmployeeIdField, operateTimeField, currencyField, exchangeRateField,relatedToContractField,contractAmountField,receiveUnitIdField,purchaserDepartmentField,purchaserField,purchasingCategoryField);
	}


}

