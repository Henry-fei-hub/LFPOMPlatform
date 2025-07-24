package com.pomplatform.client.workflow.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.datasource.CDBonusPaymentRecordWithB;

public class BonusPaymentRecordWithBSearchForm extends SearchForm
{


	private final TextItem bonusPaymentRecordIdItem;
	private final TextItem plateIdItem;
	private final TextItem applicantItem;
	private final TextItem stateItem;
	private final TextItem auditorItem;

	public BonusPaymentRecordWithBSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDBonusPaymentRecordWithB.getInstance());
		bonusPaymentRecordIdItem = new TextItem("bonusPaymentRecordId", "主键编码");
		plateIdItem = new TextItem("plateId", "业务部门");
		applicantItem = new TextItem("applicant", "申请人");
		stateItem = new TextItem("state", "审核状态  0未审核   1审核通过    2审核不通过");
		auditorItem = new TextItem("auditor", "审核人");

		setItems(bonusPaymentRecordIdItem, plateIdItem, applicantItem, stateItem, auditorItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
