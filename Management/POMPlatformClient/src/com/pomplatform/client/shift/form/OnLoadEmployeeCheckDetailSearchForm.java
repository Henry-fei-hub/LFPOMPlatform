package com.pomplatform.client.shift.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnLoadEmployeeCheckDetailSearchForm extends SearchForm
{


	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final SelectItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final IPickTreeItem departmentIdItem;

	public OnLoadEmployeeCheckDetailSearchForm() {
		setWidth100();
		setHeight100();
		employeeIdItem = new SelectItem("employeeId", "职员编码");
		employeeIdItem.hide();
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		
		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		
		startDateItem = new DateItem("startDate", "开始时间");
		startDateItem.setWidth("*");
		startDateItem.setDefaultValue(new Date());
		startDateItem.setUseTextField(true);  
		
		endDateItem = new DateItem("endDate", "截止时间");
		endDateItem.setWidth("*");
		endDateItem.setDefaultValue(new Date());
		endDateItem.setUseTextField(true);  

		setItems(employeeIdItem, employeeNoItem, employeeNameItem, departmentIdItem,startDateItem, endDateItem);

		setNumCols(11);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
