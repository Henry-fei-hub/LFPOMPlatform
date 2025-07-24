package com.pomplatform.client.workflow.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.datasource.CDMyAuditListOfApproveProjectStageStroage;


public class MyAuditListOfApproveProjectStageStroageSearchForm extends SearchForm
{


	private final TextItem processTypeItem;
	private final TextItem projectNameItem;
	private final ComboBoxItem plateIdItem;
	private final TextItem employeeIdItem;

	public MyAuditListOfApproveProjectStageStroageSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMyAuditListOfApproveProjectStageStroage.getInstance());
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.hide();
		projectNameItem = new TextItem("projectName", "项目名称");
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));	
		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.hide();

		setItems(processTypeItem, projectNameItem, plateIdItem, employeeIdItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
