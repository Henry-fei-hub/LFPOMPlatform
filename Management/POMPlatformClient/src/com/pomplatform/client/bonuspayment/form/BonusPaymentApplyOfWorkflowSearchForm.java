package com.pomplatform.client.bonuspayment.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.bonuspayment.datasource.CDBonusPaymentApplyOfWorkflow;

public class BonusPaymentApplyOfWorkflowSearchForm extends SearchForm
{


	private final TextItem bonusPaymentRecordIdItem;
	private final ComboBoxItem plateIdItem;
	private final DateItem payDateItem;
	private final ComboBoxItem applicantItem;
	private final TextItem stateItem;
	private final TextItem auditorItem;

	public BonusPaymentApplyOfWorkflowSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDBonusPaymentApplyOfWorkflow.getInstance());
		bonusPaymentRecordIdItem = new TextItem("bonusPaymentRecordId", "主键编码");
		payDateItem = new DateItem("payDate", "发放年月");
		payDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, payDateItem);
			}
		});
		stateItem = new TextItem("state", "审核状态  0未审核   1审核通过    2审核不通过");
		auditorItem = new TextItem("auditor", "审核人");
		
		
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));	
		applicantItem = new ComboBoxItem("applicant", "申请人");
		applicantItem.setWidth("*");
		applicantItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		applicantItem.setValueMap(KeyValueManager.getValueMap("employees"));	
		
		setItems( plateIdItem, applicantItem);

		setNumCols(5);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
