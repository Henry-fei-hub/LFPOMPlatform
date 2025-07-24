package com.pomplatform.client.workflow.personnel.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.personnel.datasource.CDApplyOfEmployeeOnboard;

public class ApplyOfEmployeeOnboardSearchForm extends SearchForm
{


	private final TextItem processTypeItem;
	private final DateItem onboardDateItem;
	private final SelectItem ownedCompanyItem;
	private final TextItem dutyIdItem;
	private final TextItem employeeNoItem;
	private final IPickTreeItem departmentIdItem;
	private final TextItem employeeNameItem;

	public ApplyOfEmployeeOnboardSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDApplyOfEmployeeOnboard.getInstance());
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.setHidden(true);
		
		onboardDateItem = new DateItem("onboardDate", "入职日期");
		onboardDateItem.setHidden(true);
		onboardDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, onboardDateItem);
			}
		});
		
		ownedCompanyItem = new SelectItem("ownedCompany", "所属公司");
		ownedCompanyItem.setHidden(true);
		ownedCompanyItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		
		dutyIdItem = new TextItem("dutyId", "职位名称");
		dutyIdItem.setHidden(true);
		
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		
		departmentIdItem = new IPickTreeItem("departmentId", "所属部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		departmentIdItem.setWidth("*");
		
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		
		setItems(processTypeItem, onboardDateItem, ownedCompanyItem, dutyIdItem, employeeNoItem, departmentIdItem, employeeNameItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
