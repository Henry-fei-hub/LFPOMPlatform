package com.pomplatform.client.reimbursement.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDK3VoucherList extends DataSource
{


	public static CDK3VoucherList instance = null;

	public static CDK3VoucherList getInstance() {
		if(instance == null) {
			instance = new CDK3VoucherList("CDK3VoucherList");
		}
		return instance;
	}

	private final DataSourceTextField reimbursementPackageCodeField;
	private final DataSourceBooleanField lockedField;
	private final DataSourceDateField endDateField;
	private final DataSourceDateField startDateField;
	private final DataSourceBooleanField needToChangeField;
	private final DataSourceTextField secondaryCodeField;
	private final DataSourceTextField codeField;
	private final DataSourceIntegerField companyIdField;

	public CDK3VoucherList(String dataSourceID) {

		setID(dataSourceID);
		reimbursementPackageCodeField = new DataSourceTextField("reimbursementPackageCode", "报销汇总编号");
		reimbursementPackageCodeField.setRequired(false);
		reimbursementPackageCodeField.setLength(64);
		reimbursementPackageCodeField.setHidden(false);

		lockedField = new DataSourceBooleanField("locked", "是否定稿");
		lockedField.setRequired(false);
		lockedField.setHidden(false);

		endDateField = new DataSourceDateField("endDate", "结束归属日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		startDateField = new DataSourceDateField("startDate", "开始归属日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		needToChangeField = new DataSourceBooleanField("needToChange", "需要调整");
		needToChangeField.setRequired(false);
		needToChangeField.setHidden(false);

		secondaryCodeField = new DataSourceTextField("secondaryCode", "辅助核算代码");
		secondaryCodeField.setRequired(false);
		secondaryCodeField.setLength(64);
		secondaryCodeField.setHidden(false);

		codeField = new DataSourceTextField("code", "科目代码");
		codeField.setRequired(false);
		codeField.setLength(64);
		codeField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

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


		setFields(reimbursementPackageCodeField, lockedField, endDateField, startDateField, needToChangeField, secondaryCodeField, codeField, companyIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

