package com.pomplatform.client.workflow.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.datasource.CDPayMoneyManageOfWorkflow;

public class PayMoneyManageOfWorkflowSearchForm extends SearchForm
{


	private final TextItem receiveUnitItem;
	private final TextItem bankAccountItem;
	private final TextItem bankNameItem;
	private final SelectItem employeeIdItem;

	public PayMoneyManageOfWorkflowSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDPayMoneyManageOfWorkflow.getInstance());
		receiveUnitItem = new TextItem("receiveUnit", "收款单位");
		bankAccountItem = new TextItem("bankAccount", "银行账号");
		bankNameItem = new TextItem("bankName", "开户行");
		employeeIdItem = new SelectItem("employeeId", "申请人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));

		setItems(receiveUnitItem, bankAccountItem, bankNameItem, employeeIdItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
