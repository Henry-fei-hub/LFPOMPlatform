package com.pomplatform.client.aboutreimbursementpayseq.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDAboutReimbursementPayseq extends DataSource
{


	public static CDAboutReimbursementPayseq instance = null;

	public static CDAboutReimbursementPayseq getInstance() {
		if(instance == null) {
			instance = new CDAboutReimbursementPayseq("CDAboutReimbursementPayseq");
		}
		return instance;
	}

	private final DataSourceIntegerField budgetManagementIdField;
	private final DataSourceIntegerField budgetAttachmentIdField;
	private final DataSourceIntegerField paymentSequenceIdField;

	public CDAboutReimbursementPayseq(String dataSourceID) {

		setID(dataSourceID);
		budgetManagementIdField = new DataSourceIntegerField("budgetManagementId", "预算管理id");
		budgetManagementIdField.setRequired(false);
		budgetManagementIdField.setLength(11);
		budgetManagementIdField.setHidden(false);

		budgetAttachmentIdField = new DataSourceIntegerField("budgetAttachmentId", "预算附件id");
		budgetAttachmentIdField.setRequired(false);
		budgetAttachmentIdField.setLength(11);
		budgetAttachmentIdField.setHidden(false);

		paymentSequenceIdField = new DataSourceIntegerField("paymentSequenceId", "主键id");
		paymentSequenceIdField.setRequired(true);
		paymentSequenceIdField.setLength(11);
		paymentSequenceIdField.setPrimaryKey(true);
		paymentSequenceIdField.setHidden(true);

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


		setFields(budgetManagementIdField, budgetAttachmentIdField, paymentSequenceIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

