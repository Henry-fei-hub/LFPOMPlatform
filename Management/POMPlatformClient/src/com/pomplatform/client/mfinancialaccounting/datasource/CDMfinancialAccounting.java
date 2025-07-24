package com.pomplatform.client.mfinancialaccounting.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class CDMfinancialAccounting extends DataSource
{


	public static CDMfinancialAccounting instance = null;

	public static CDMfinancialAccounting getInstance() {
		if(instance == null) {
			instance = new CDMfinancialAccounting("CDMfinancialAccounting");
		}
		return instance;
	}

	private final DataSourceIntegerField processStatusField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField codeField;
	private final DataSourceTextField voucherNoField;
	private final DataSourceDateField postingDateBeginField;
	private final DataSourceDateField postingDateEndField;
	private final DataSourceDateTimeField completeTimeBeginField;
	private final DataSourceDateTimeField completeTimeEndField;
	private final DataSourceDateTimeField applyTimeBeginField;
	private final DataSourceDateTimeField applyTimeEndField;
	private final DataSourceBooleanField bePackedField;


	public CDMfinancialAccounting(String dataSourceID) {

		setID(dataSourceID);
		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setRequired(false);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "报销部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "起草人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		codeField = new DataSourceTextField("code", "报销编号");
		codeField.setRequired(false);
		codeField.setLength(64);
		codeField.setHidden(false);

		voucherNoField = new DataSourceTextField("voucherNo", "凭证号");
		voucherNoField.setRequired(false);
		voucherNoField.setLength(64);
		voucherNoField.setHidden(false);

		postingDateBeginField = new DataSourceDateField("postingDateBegin", "入账日期");
		postingDateBeginField.setRequired(false);
		postingDateBeginField.setHidden(false);

		postingDateEndField = new DataSourceDateField("postingDateEnd", "入账日期");
		postingDateEndField.setRequired(false);
		postingDateEndField.setHidden(false);

		completeTimeBeginField = new DataSourceDateTimeField("completeTimeBegin", "完成时间");
		completeTimeBeginField.setRequired(false);
		completeTimeBeginField.setHidden(false);

		completeTimeEndField = new DataSourceDateTimeField("completeTimeEnd", "完成时间");
		completeTimeEndField.setRequired(false);
		completeTimeEndField.setHidden(false);

		applyTimeBeginField = new DataSourceDateTimeField("applyTimeBegin", "申请时间");
		applyTimeBeginField.setRequired(false);
		applyTimeBeginField.setHidden(false);

		applyTimeEndField = new DataSourceDateTimeField("applyTimeEnd", "申请时间");
		applyTimeEndField.setRequired(false);
		applyTimeEndField.setHidden(false);
		
		bePackedField = new DataSourceBooleanField("bePacked", "是否被打包");
		bePackedField.setRequired(false);
		bePackedField.setHidden(false);

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


		setFields(processStatusField, companyIdField, departmentIdField, employeeIdField, codeField, voucherNoField, postingDateBeginField, postingDateEndField, completeTimeBeginField, completeTimeEndField, applyTimeBeginField, applyTimeEndField, bePackedField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

