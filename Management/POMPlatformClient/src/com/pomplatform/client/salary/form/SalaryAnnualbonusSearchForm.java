package com.pomplatform.client.salary.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class SalaryAnnualbonusSearchForm extends SearchForm
{


	private final TextItem employeeNoItem;
	private final ComboBoxItem employeeIdItem;
	private final ComboBoxItem companyIdItem;
	private final ComboBoxItem plateIdItem;
	private final IPickTreeItem departmentIdItem;
	private final ComboBoxItem yearItem;
	private final DateTimeItem startTimeItem;
	private final DateTimeItem endTimeItem;

	public SalaryAnnualbonusSearchForm() {
		setWidth100();
		setHeight100();
		employeeNoItem = new TextItem("employeeNo", "员工工号");
		employeeNoItem.setWidth("*");
		
		employeeIdItem = new ComboBoxItem("employeeId", "员工姓名");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setWidth("*");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		
		companyIdItem = new ComboBoxItem("companyId", "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		companyIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		companyIdItem.setWidth("*");
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setWidth("*");
		
		departmentIdItem = new IPickTreeItem("departmentId", "归属部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		
		yearItem = new ComboBoxItem("year", "年份");
		yearItem.setWidth("*");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		yearItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		
		startTimeItem = new DateTimeItem("startTime", "发放时间");
		startTimeItem.setWidth("*");
		
		endTimeItem = new DateTimeItem("endTime", "发放时间");
		endTimeItem.setWidth("*");
		
		setItems(employeeNoItem, employeeIdItem,companyIdItem,plateIdItem,departmentIdItem, yearItem,startTimeItem,endTimeItem);

		setNumCols(17);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
