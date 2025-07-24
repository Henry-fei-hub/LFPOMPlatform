package com.pomplatform.client.specialdeduction.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.specialdeduction.datasource.CDSpecialDeductionRecordsAttentionOfWorkflow;

public class SpecialDeductionRecordsAttentionOfWorkflowSearchForm extends SearchForm
{


	private final TextItem statusItem;
	private final TextItem employeeIdItem;
	private final ComboBoxItem companyIdItem;
	private final TextItem plateIdItem;
	private final ComboBoxItem employeIdItem;

	public SpecialDeductionRecordsAttentionOfWorkflowSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSpecialDeductionRecordsAttentionOfWorkflow.getInstance());
		statusItem = new TextItem("status", "状态");
		statusItem.hide();
		employeeIdItem = new TextItem("employeeId", "处理人");
		employeeIdItem.hide();
		
		companyIdItem = new ComboBoxItem("companyId", "归属公司");
		companyIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		companyIdItem.setWidth("*");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
	
		plateIdItem = new TextItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		
		employeIdItem = new ComboBoxItem("employeId", "发起人");
		employeIdItem.setWidth("*");
		employeIdItem.setChangeOnKeypress(false);
		employeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
	

		setItems(statusItem, employeeIdItem, companyIdItem, plateIdItem, employeIdItem);

		setNumCols(12);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
