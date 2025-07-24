package com.pomplatform.client.alreadyapprovalbudgetmanagementapplywork.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.alreadyapprovalbudgetmanagementapplywork.datasource.CDAlreadyApprovalBudgetManagementApplyWork;

public class AlreadyApprovalBudgetManagementApplyWorkSearchForm extends SearchForm
{


	private final TextItem processTypeItem;
	private final SelectItem bdTypeItem;
	private final TextItem bdCodeItem;
	private final TextItem companyIdItem;
	private final TextItem bdApplyEmployeeIdItem;
	private final DateTimeItem bdApplyTimeItem;
	private final TextItem projectIdItem;
	private final ComboBoxItem departmentIdItem;

	public AlreadyApprovalBudgetManagementApplyWorkSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDAlreadyApprovalBudgetManagementApplyWork.getInstance());
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.setHidden(true);
		
		
		bdTypeItem = new SelectItem("bdType", "预算类型");
		bdTypeItem.setWidth("*");
		bdTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_191"));
		
		
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

		setItems(processTypeItem, bdTypeItem, bdCodeItem, companyIdItem, bdApplyEmployeeIdItem, bdApplyTimeItem, projectIdItem, departmentIdItem);

		setNumCols(12);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
