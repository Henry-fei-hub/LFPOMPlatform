package com.pomplatform.client.memployeemoneymanageeeedcieftrcvmmor.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMemployeemoneymanageeeedcieftrcvmmor extends DBDataSource
{


	public static DSMemployeemoneymanageeeedcieftrcvmmor instance = null;

	public static DSMemployeemoneymanageeeedcieftrcvmmor getInstance() {
		if(instance == null) {
			instance = new DSMemployeemoneymanageeeedcieftrcvmmor("DSMemployeemoneymanageeeedcieftrcvmmor");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeMoneyManageIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceFloatField borrowMoneyField;
	private final DataSourceFloatField returnMoneyField;
	private final DataSourceDateField borrowDateField;
	private final DataSourceDateField anticipatedDateField;
	private final DataSourceDateField returnDateField;
	private final DataSourceTextField titleNameField;
	private final DataSourceTextField reasonField;
	private final DataSourceIntegerField falgField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField codeField;
	private final DataSourceIntegerField deleteFlagField;
	private final DataSourceBooleanField isCompletedField;
	private final DataSourceBooleanField bePackedField;
	private final DataSourceTextField voucherNoField;
	private final DataSourceDateField postingDateField;

	public DSMemployeemoneymanageeeedcieftrcvmmor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Memployeemoneymanageeeedcieftrcvmmor");


		employeeMoneyManageIdField = new DataSourceIntegerField("employeeMoneyManageId", "主键编码");
		employeeMoneyManageIdField.setLength(11);
		employeeMoneyManageIdField.setPrimaryKey(true);
		employeeMoneyManageIdField.setRequired(true);
		employeeMoneyManageIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "职员");
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


		returnMoneyField = new DataSourceFloatField("returnMoney", "还款金额");
		returnMoneyField.setLength(18);
		returnMoneyField.setDecimalPad(5);
		returnMoneyField.setFormat("#,###,###,###,##0.00");
		returnMoneyField.setRequired(false);
		returnMoneyField.setHidden(true);


		borrowDateField = new DataSourceDateField("borrowDate", "借款日期");
		borrowDateField.setRequired(false);
		borrowDateField.setHidden(true);


		anticipatedDateField = new DataSourceDateField("anticipatedDate", "预计还款日期");
		anticipatedDateField.setRequired(false);
		anticipatedDateField.setHidden(true);


		returnDateField = new DataSourceDateField("returnDate", "还款日期");
		returnDateField.setRequired(false);
		returnDateField.setHidden(true);


		titleNameField = new DataSourceTextField("titleName", "主题名称");
		titleNameField.setLength(64);
		titleNameField.setRequired(false);
		titleNameField.setHidden(false);


		reasonField = new DataSourceTextField("reason", "借款事由");
		reasonField.setLength(256);
		reasonField.setRequired(false);
		reasonField.setHidden(false);


		falgField = new DataSourceIntegerField("falg", "2还款)");
		falgField.setLength(11);
		falgField.setRequired(false);
		falgField.setHidden(true);


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


		codeField = new DataSourceTextField("code", "报销编号");
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


		setFields(employeeMoneyManageIdField, employeeIdField, departmentIdField, borrowMoneyField, returnMoneyField, borrowDateField, anticipatedDateField, returnDateField, titleNameField, reasonField, falgField, operateEmployeeIdField, operateTimeField, companyIdField, codeField, deleteFlagField, isCompletedField, bePackedField, voucherNoField, postingDateField);
	}


}

