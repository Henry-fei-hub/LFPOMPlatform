package com.pomplatform.client.knowapprovalbudgetmanagementapplywork.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.knowapprovalbudgetmanagementapplywork.datasource.CDknowApprovalBudgetManagementApplyWork;

public class knowApprovalBudgetManagementApplyWorkSearchForm extends SearchForm
{


	private final TextItem processTypeItem;
	private final TextItem companyIdItem;
	private final TextItem bdApplyEmployeeIdItem;
	private final DateTimeItem bdApplyTimeItem;
	private final ComboBoxItem projectIdItem;
	private final ComboBoxItem departmentIdItem;

	public knowApprovalBudgetManagementApplyWorkSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDknowApprovalBudgetManagementApplyWork.getInstance());
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.setHidden(true);
		
		
		companyIdItem = new TextItem("companyId", "申请人归属公司");
		companyIdItem.setHidden(true);;
		
		
		bdApplyEmployeeIdItem = new ComboBoxItem("bdApplyEmployeeId", "申请人");
		bdApplyEmployeeIdItem.setWidth("*");
		bdApplyEmployeeIdItem.setChangeOnKeypress(false);
		bdApplyEmployeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		
		bdApplyTimeItem = new DateTimeItem("bdApplyTime", "申请时间");
		bdApplyTimeItem.setWidth("*");
		bdApplyTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, bdApplyTimeItem);
			}
		});
		
		projectIdItem = new ComboBoxItem("projectId", "项目名称");
		projectIdItem.setWidth("*");
		projectIdItem.setChangeOnKeypress(false);
//		KeyValueManager.loadValueMap("projects",projectIdItem);
		KeyValueManager.loadValueMap("projects",projectIdItem);
		
		departmentIdItem = new ComboBoxItem("departmentId", "承接部门");
		departmentIdItem.setWidth("*");
		KeyValueManager.loadValueMap("system_dictionary_1", departmentIdItem);

		setItems( processTypeItem,companyIdItem, bdApplyEmployeeIdItem, bdApplyTimeItem, projectIdItem, departmentIdItem);

		setNumCols(12);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
