package com.pomplatform.client.workflow.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSEmployeeBorrowMoneyByWorkflow extends DBDataSource
{


	public static DSEmployeeBorrowMoneyByWorkflow instance = null;

	public static DSEmployeeBorrowMoneyByWorkflow getInstance() {
		if(instance == null) {
			instance = new DSEmployeeBorrowMoneyByWorkflow("DSEmployeeBorrowMoneyByWorkflow");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeMoneyManageIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceFloatField borrowMoneyField;
	private final DataSourceDateField borrowDateField;
	private final DataSourceDateField anticipatedDateField;
	private final DataSourceTextField titleNameField;
	private final DataSourceTextField reasonField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField codeField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField currencyField;
	private final DataSourceFloatField exchangeRateField;
	private final DataSourceLinkField attachmentField;

	public DSEmployeeBorrowMoneyByWorkflow(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("EmployeeBorrowMoneyByWorkflow");


		employeeMoneyManageIdField = new DataSourceIntegerField("employeeMoneyManageId", "主键编码");
		employeeMoneyManageIdField.setLength(11);
		employeeMoneyManageIdField.setPrimaryKey(true);
		employeeMoneyManageIdField.setRequired(true);
		employeeMoneyManageIdField.setHidden(true);


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


		borrowMoneyField = new DataSourceFloatField("borrowMoney", "借款金额");
		borrowMoneyField.setLength(18);
		borrowMoneyField.setDecimalPad(5);
		borrowMoneyField.setFormat("#,###,###,###,##0.00");
		borrowMoneyField.setRequired(false);
		borrowMoneyField.setHidden(false);


		borrowDateField = new DataSourceDateField("borrowDate", "借款日期");
		borrowDateField.setRequired(false);
		borrowDateField.setHidden(false);


		anticipatedDateField = new DataSourceDateField("anticipatedDate", "预计还款日期");
		anticipatedDateField.setRequired(false);
		anticipatedDateField.setHidden(false);
		
		titleNameField = new DataSourceTextField("titleName", "主题名称");
		titleNameField.setLength(64);
		titleNameField.setRequired(false);
		titleNameField.setHidden(false);


		reasonField = new DataSourceTextField("reason", "借款事由");
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
		
		attachmentField = new DataSourceLinkField("attachment", "附件");
		attachmentField.setLength(512);
		attachmentField.setRequired(false);
		attachmentField.setHidden(false);


		setFields(employeeMoneyManageIdField,codeField,companyIdField, employeeIdField, departmentIdField, borrowMoneyField, borrowDateField, anticipatedDateField, titleNameField,reasonField, operateEmployeeIdField, operateTimeField, currencyField, exchangeRateField,attachmentField);
	}


}

