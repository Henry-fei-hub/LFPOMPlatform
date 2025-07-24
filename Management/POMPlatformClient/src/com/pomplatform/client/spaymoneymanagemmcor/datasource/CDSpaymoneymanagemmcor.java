package com.pomplatform.client.spaymoneymanagemmcor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSpaymoneymanagemmcor extends DataSource
{


	public static CDSpaymoneymanagemmcor instance = null;

	public static CDSpaymoneymanagemmcor getInstance() {
		if(instance == null) {
			instance = new CDSpaymoneymanagemmcor("CDSpaymoneymanagemmcor");
		}
		return instance;
	}

	private final DataSourceDateTimeField minOperateTimeField;
	private final DataSourceDateTimeField maxOperateTimeField;
	private final DataSourceTextField codeField;
	private final DataSourceTextField voucherNoField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceTextField reasonField;
	private final DataSourceTextField receiveUnitField;
	private final DataSourceTextField bankAccountField;
	private final DataSourceTextField bankNameField;
	private final DataSourceTextField titleNameField;

	public CDSpaymoneymanagemmcor(String dataSourceID) {

		setID(dataSourceID);
		minOperateTimeField = new DataSourceDateTimeField("minOperateTime", "最早操作时间");
		minOperateTimeField.setRequired(false);
		minOperateTimeField.setHidden(false);

		maxOperateTimeField = new DataSourceDateTimeField("maxOperateTime", "最晚操作时间");
		maxOperateTimeField.setRequired(false);
		maxOperateTimeField.setHidden(false);

		codeField = new DataSourceTextField("code", "编号");
		codeField.setRequired(false);
		codeField.setLength(64);
		codeField.setHidden(false);

		voucherNoField = new DataSourceTextField("voucherNo", "凭证号");
		voucherNoField.setRequired(false);
		voucherNoField.setLength(64);
		voucherNoField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "申请人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门编码");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setHidden(false);

		reasonField = new DataSourceTextField("reason", "付款原因");
		reasonField.setRequired(false);
		reasonField.setLength(256);
		reasonField.setHidden(false);

		receiveUnitField = new DataSourceTextField("receiveUnit", "收款单位");
		receiveUnitField.setRequired(false);
		receiveUnitField.setLength(128);
		receiveUnitField.setHidden(false);

		bankAccountField = new DataSourceTextField("bankAccount", "银行账号");
		bankAccountField.setRequired(false);
		bankAccountField.setLength(64);
		bankAccountField.setHidden(false);

		bankNameField = new DataSourceTextField("bankName", "开户行");
		bankNameField.setRequired(false);
		bankNameField.setLength(128);
		bankNameField.setHidden(false);

		titleNameField = new DataSourceTextField("titleName", "主题名称");
		titleNameField.setRequired(false);
		titleNameField.setLength(64);
		titleNameField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(minOperateTimeField, maxOperateTimeField, codeField, voucherNoField, employeeIdField, departmentIdField, operateEmployeeIdField, reasonField, receiveUnitField, bankAccountField, bankNameField, titleNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

