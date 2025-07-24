package com.pomplatform.client.memployeemoneymanageeeedcieftrcvmmor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMemployeemoneymanageeeedcieftrcvmmor extends DataSource
{


	public static CDMemployeemoneymanageeeedcieftrcvmmor instance = null;

	public static CDMemployeemoneymanageeeedcieftrcvmmor getInstance() {
		if(instance == null) {
			instance = new CDMemployeemoneymanageeeedcieftrcvmmor("CDMemployeemoneymanageeeedcieftrcvmmor");
		}
		return instance;
	}

	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField codeField;
	private final DataSourceBooleanField isCompletedField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField falgField;
	private final DataSourceTextField titleNameField;
	private final DataSourceTextField reasonField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField voucherNoField;
	private final DataSourceDateTimeField minOperateTimeField;
	private final DataSourceDateTimeField maxOperateTimeField;

	public CDMemployeemoneymanageeeedcieftrcvmmor(String dataSourceID) {

		setID(dataSourceID);
		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setRequired(true);
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "职员编码");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门编码");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

		codeField = new DataSourceTextField("code", "编号");
		codeField.setRequired(false);
		codeField.setLength(64);
		codeField.setHidden(false);

		isCompletedField = new DataSourceBooleanField("isCompleted", "true是)");
		isCompletedField.setRequired(false);
		isCompletedField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

		falgField = new DataSourceIntegerField("falg", "2还款)");
		falgField.setRequired(false);
		falgField.setLength(11);
		falgField.setHidden(false);

		titleNameField = new DataSourceTextField("titleName", "主题名称");
		titleNameField.setRequired(false);
		titleNameField.setLength(64);
		titleNameField.setHidden(false);

		reasonField = new DataSourceTextField("reason", "借款事由");
		reasonField.setRequired(false);
		reasonField.setLength(256);
		reasonField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

		voucherNoField = new DataSourceTextField("voucherNo", "凭证号");
		voucherNoField.setRequired(false);
		voucherNoField.setLength(64);
		voucherNoField.setHidden(false);

		minOperateTimeField = new DataSourceDateTimeField("minOperateTime", "最早操作时间");
		minOperateTimeField.setRequired(false);
		minOperateTimeField.setHidden(false);

		maxOperateTimeField = new DataSourceDateTimeField("maxOperateTime", "最晚操作时间");
		maxOperateTimeField.setRequired(false);
		maxOperateTimeField.setHidden(false);

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


		setFields(employeeNoField, employeeIdField, departmentIdField, codeField, isCompletedField, employeeNameField, falgField, titleNameField, reasonField, companyIdField, voucherNoField, minOperateTimeField, maxOperateTimeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

