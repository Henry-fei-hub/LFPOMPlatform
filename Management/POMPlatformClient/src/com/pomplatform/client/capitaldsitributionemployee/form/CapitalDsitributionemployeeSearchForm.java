package com.pomplatform.client.capitaldsitributionemployee.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.capitaldsitributionemployee.datasource.CDCapitalDsitributionemployee;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class CapitalDsitributionemployeeSearchForm extends SearchForm
{


	private final ComboBoxItem plateIdItem;
	private final ComboBoxItem employeeIdItem;
	private final SelectItem departmentIdItem;
	private final TextItem employeeNameItem;
	private final TextItem employeeNoItem;
	private final SelectItem statusItem;

	public CapitalDsitributionemployeeSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDCapitalDsitributionemployee.getInstance());
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setChangeOnKeypress(false);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	
		employeeIdItem = new ComboBoxItem("employeeId", "员工");
		employeeIdItem.setWidth("*");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		departmentIdItem = new SelectItem("departmentId", "部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.hide();
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		statusItem = new SelectItem("status", "员工状态");
		statusItem.setWidth("*");
		statusItem.setDefaultValue(0);
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));

		setItems(plateIdItem, employeeIdItem, departmentIdItem, employeeNameItem, employeeNoItem, statusItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
