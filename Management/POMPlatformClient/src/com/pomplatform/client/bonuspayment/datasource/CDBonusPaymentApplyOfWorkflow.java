package com.pomplatform.client.bonuspayment.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDBonusPaymentApplyOfWorkflow extends DataSource
{


	public static CDBonusPaymentApplyOfWorkflow instance = null;

	public static CDBonusPaymentApplyOfWorkflow getInstance() {
		if(instance == null) {
			instance = new CDBonusPaymentApplyOfWorkflow("CDBonusPaymentApplyOfWorkflow");
		}
		return instance;
	}

	private final DataSourceIntegerField bonusPaymentRecordIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceDateField payDateField;
	private final DataSourceIntegerField applicantField;
	private final DataSourceIntegerField stateField;
	private final DataSourceIntegerField auditorField;

	public CDBonusPaymentApplyOfWorkflow(String dataSourceID) {

		setID(dataSourceID);
		bonusPaymentRecordIdField = new DataSourceIntegerField("bonusPaymentRecordId", "主键编码");
		bonusPaymentRecordIdField.setRequired(true);
		bonusPaymentRecordIdField.setLength(11);
		bonusPaymentRecordIdField.setPrimaryKey(true);
		bonusPaymentRecordIdField.setHidden(true);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		payDateField = new DataSourceDateField("payDate", "发放年月");
		payDateField.setRequired(false);
		payDateField.setHidden(false);

		applicantField = new DataSourceIntegerField("applicant", "申请人");
		applicantField.setRequired(false);
		applicantField.setLength(11);
		applicantField.setHidden(false);

		stateField = new DataSourceIntegerField("state", "审核状态  0未审核   1审核通过    2审核不通过");
		stateField.setRequired(false);
		stateField.setLength(11);
		stateField.setHidden(false);

		auditorField = new DataSourceIntegerField("auditor", "审核人");
		auditorField.setRequired(false);
		auditorField.setLength(11);
		auditorField.setHidden(false);

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


		setFields(bonusPaymentRecordIdField, plateIdField, payDateField, applicantField, stateField, auditorField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

