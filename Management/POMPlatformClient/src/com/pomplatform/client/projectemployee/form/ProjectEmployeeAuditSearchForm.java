package com.pomplatform.client.projectemployee.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectemployee.datasource.CDProjectEmployeeAudit;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ProjectEmployeeAuditSearchForm extends SearchForm
{


	private final TextItem plateIdItem;
	private final TextItem flagItem;
	private final ComboBoxItem projectPlateIdItem;
	private final TextItem contractCodeItem;
	private final TextItem projectNameItem;
	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;

	public ProjectEmployeeAuditSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDProjectEmployeeAudit.getInstance());
		
		plateIdItem = new TextItem("plateId", "业务部门");
		plateIdItem.hide();
		
		flagItem = new TextItem("flag", "成员状态");
		flagItem.hide();
		
		projectPlateIdItem = new ComboBoxItem("projectPlateId", "订单所在业务部门");
		projectPlateIdItem.setChangeOnKeypress(false);
		projectPlateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectPlateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		projectPlateIdItem.setWidth("*");
		
		contractCodeItem = new TextItem("contractCode", "订单编号");
		contractCodeItem.setWidth("*");
		
		projectNameItem = new TextItem("projectName", "订单名称");
		projectNameItem.setWidth("*");
		
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");

		setItems(plateIdItem, flagItem, projectPlateIdItem, contractCodeItem, projectNameItem, employeeNoItem, employeeNameItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
