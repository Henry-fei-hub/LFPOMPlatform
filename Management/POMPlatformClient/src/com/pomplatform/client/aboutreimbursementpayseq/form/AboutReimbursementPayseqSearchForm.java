package com.pomplatform.client.aboutreimbursementpayseq.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.aboutreimbursementpayseq.datasource.CDAboutReimbursementPayseq;

public class AboutReimbursementPayseqSearchForm extends SearchForm
{


	private final TextItem budgetManagementIdItem;
	private final TextItem budgetAttachmentIdItem;
	private final TextItem paymentSequenceIdItem;

	public AboutReimbursementPayseqSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDAboutReimbursementPayseq.getInstance());
		budgetManagementIdItem = new TextItem("budgetManagementId", "预算管理id");
		budgetAttachmentIdItem = new TextItem("budgetAttachmentId", "预算附件id");
		paymentSequenceIdItem = new TextItem("paymentSequenceId", "主键id");

		setItems(budgetManagementIdItem, budgetAttachmentIdItem, paymentSequenceIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
