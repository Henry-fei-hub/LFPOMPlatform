package com.pomplatform.client.cwd.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.cwd.datasource.DSScwdfilingmaintemplatetrcor;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ScwdfilingmaintemplatetrcorNewForm extends AbstractWizadPage {

	private final TextItem templateNameItem;
	private final SelectItem projectTypeItem;
	private final TextItem operatorIdItem;
	private final SelectItem departmentIdItem;
	private final TextAreaItem remarkItem;
	private final DateTimeItem createTimeItem;

	public ScwdfilingmaintemplatetrcorNewForm() {
		DSScwdfilingmaintemplatetrcor ds = DSScwdfilingmaintemplatetrcor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		templateNameItem = new TextItem("templateName", "模板名称");
		templateNameItem.setRequired(true);
		templateNameItem.setWidth("*");
		__formItems.add(templateNameItem);
		
		projectTypeItem = new SelectItem("projectType", "项目类型");
		projectTypeItem.setRequired(true);
		projectTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		projectTypeItem.setWidth("*");
		__formItems.add(projectTypeItem);
		
		operatorIdItem = new TextItem("operatorId", "操作人");
		operatorIdItem.hide();
		operatorIdItem.setDefaultValue(ClientUtil.getEmployeeId());
		__formItems.add(operatorIdItem);
		
		departmentIdItem = new SelectItem("departmentId", "部门编码");
		departmentIdItem.hide();
		departmentIdItem.setDefaultValue(ClientUtil.getDepartmentId());
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		__formItems.add(departmentIdItem);
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setWidth("*");
		remarkItem.setColSpan(2);
		remarkItem.setRowSpan(3);
		__formItems.add(remarkItem);
		
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		createTimeItem.hide();
		__formItems.add(createTimeItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if (getRecord() != null)
			__form.editRecord(getRecord());
		else
			__form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSScwdfilingmaintemplatetrcor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

}
