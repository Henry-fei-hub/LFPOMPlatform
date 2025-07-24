package com.pomplatform.client.reimbursement.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDK3VoucherSummary extends DataSource
{


	public static CDK3VoucherSummary instance = null;

	public static CDK3VoucherSummary getInstance() {
		if(instance == null) {
			instance = new CDK3VoucherSummary("CDK3VoucherSummary");
		}
		return instance;
	}

	private final DataSourceTextField reimbursementPackageCodeField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField codeField;
	private final DataSourceTextField secondaryCodeField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceBooleanField needToChangeField;
	private final DataSourceBooleanField lockedField;

	public CDK3VoucherSummary(String dataSourceID) {

		setID(dataSourceID);
		reimbursementPackageCodeField = new DataSourceTextField("reimbursementPackageCode", "报销汇总编号");
		reimbursementPackageCodeField.setRequired(false);
		reimbursementPackageCodeField.setLength(64);
		reimbursementPackageCodeField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		codeField = new DataSourceTextField("code", "科目代码");
		codeField.setRequired(false);
		codeField.setLength(64);
		codeField.setHidden(false);

		secondaryCodeField = new DataSourceTextField("secondaryCode", "辅助核算代码");
		secondaryCodeField.setRequired(false);
		secondaryCodeField.setLength(64);
		secondaryCodeField.setHidden(false);

		startDateField = new DataSourceDateField("startDate", "开始归属日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateField("endDate", "结束归属日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		needToChangeField = new DataSourceBooleanField("needToChange", "需要调整");
		needToChangeField.setRequired(false);
		needToChangeField.setHidden(false);

		lockedField = new DataSourceBooleanField("locked", "是否定稿");
		lockedField.setRequired(false);
		lockedField.setHidden(false);

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


		setFields(reimbursementPackageCodeField, companyIdField, codeField, secondaryCodeField, startDateField, endDateField, needToChangeField, lockedField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

