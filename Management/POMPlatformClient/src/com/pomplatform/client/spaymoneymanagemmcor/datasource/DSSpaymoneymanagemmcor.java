package com.pomplatform.client.spaymoneymanagemmcor.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSpaymoneymanagemmcor extends DBDataSource
{


	public static DSSpaymoneymanagemmcor instance = null;

	public static DSSpaymoneymanagemmcor getInstance() {
		if(instance == null) {
			instance = new DSSpaymoneymanagemmcor("DSSpaymoneymanagemmcor");
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
	private final DataSourceTextField attachmentFileField;
	private final DataSourceTextField reasonField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField codeField;
	private final DataSourceIntegerField deleteFlagField;
	private final DataSourceBooleanField isCompletedField;
	private final DataSourceBooleanField bePackedField;
	private final DataSourceTextField voucherNoField;
	private final DataSourceDateField postingDateField;

	public DSSpaymoneymanagemmcor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Spaymoneymanagemmcor");


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
		employeeIdField.setHidden(true);


		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		attachmentFileField = new DataSourceTextField("attachmentFile", "附件");
		attachmentFileField.setLength(128);
		attachmentFileField.setRequired(false);
		attachmentFileField.setHidden(true);


		reasonField = new DataSourceTextField("reason", "付款原因");
		reasonField.setLength(256);
		reasonField.setRequired(false);
		reasonField.setHidden(false);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(true);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		codeField = new DataSourceTextField("code", "编号");
		codeField.setLength(64);
		codeField.setRequired(false);
		codeField.setHidden(false);


		deleteFlagField = new DataSourceIntegerField("deleteFlag", "删除状态  0未删除    1已删除");
		deleteFlagField.setLength(11);
		deleteFlagField.setRequired(false);
		deleteFlagField.setHidden(true);


		isCompletedField = new DataSourceBooleanField("isCompleted", "true是)");
		isCompletedField.setRequired(false);
		isCompletedField.setHidden(true);


		bePackedField = new DataSourceBooleanField("bePacked", "是否被打包");
		bePackedField.setRequired(false);
		bePackedField.setHidden(true);


		voucherNoField = new DataSourceTextField("voucherNo", "凭证号");
		voucherNoField.setLength(64);
		voucherNoField.setRequired(false);
		voucherNoField.setHidden(true);


		postingDateField = new DataSourceDateField("postingDate", "入账日期");
		postingDateField.setRequired(false);
		postingDateField.setHidden(true);


		setFields(payMoneyManageIdField, receiveUnitField, bankAccountField, bankNameField, titleNameField, payAmountField, employeeIdField, departmentIdField, attachmentFileField, reasonField, operateEmployeeIdField, operateTimeField, companyIdField, codeField, deleteFlagField, isCompletedField, bePackedField, voucherNoField, postingDateField);
	}


}

