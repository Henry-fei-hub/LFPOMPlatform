package com.pomplatform.client.taskapprovalbudgetmanagementapplywork.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.taskapprovalbudgetmanagementapplywork.datasource.CDTaskApprovalBudgetManagementApplyWork;

public class TaskApprovalBudgetManagementApplyWorkSearchForm extends SearchForm
{


	private final SelectItem bdTypeItem;
	private final TextItem bdCodeItem;
	private final TextItem companyIdItem;
	private final TextItem bdApplyEmployeeIdItem;
	private final DateTimeItem bdApplyTimeItem;
	private final TextItem projectIdItem;
	private final ComboBoxItem departmentIdItem;

	public TaskApprovalBudgetManagementApplyWorkSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDTaskApprovalBudgetManagementApplyWork.getInstance());
		
		
		bdTypeItem = new SelectItem("bdType", "预算类型");
		bdTypeItem.setWidth("*");
		bdTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_187"));
		
		
		bdCodeItem = new TextItem("bdCode", "预算编号");
		bdCodeItem.setWidth("*");
		
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
		KeyValueManager.loadValueMap("projects", projectIdItem);
		
		
		departmentIdItem = new ComboBoxItem("plateId", "承接部门部门");
		departmentIdItem.setWidth("*");
		KeyValueManager.loadValueMap("system_dictionary_1", departmentIdItem);

		setItems(bdTypeItem, bdCodeItem, companyIdItem, bdApplyEmployeeIdItem, bdApplyTimeItem, projectIdItem, departmentIdItem);

		setNumCols(12);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
