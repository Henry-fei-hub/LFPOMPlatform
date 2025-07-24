package com.pomplatform.client.cwd.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.cwd.datasource.CDScwdfilingmaintemplatetrcor;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ScwdfilingmaintemplatetrcorSearchForm extends SearchForm {

	private final TextItem templateNameItem;
	private final TextItem remarkItem;
	private final TextItem cwdFilingMainTemplateIdItem;
	private final SelectItem projectTypeItem;
	private final TextItem operatorIdItem;
	private final SelectItem departmentIdItem;

	public ScwdfilingmaintemplatetrcorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDScwdfilingmaintemplatetrcor.getInstance());
		templateNameItem = new TextItem("templateName", "模板名称");
		templateNameItem.setWidth("*");
		
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
		
		cwdFilingMainTemplateIdItem = new TextItem("cwdFilingMainTemplateId", "主键");
		cwdFilingMainTemplateIdItem.hide();
		
		projectTypeItem = new SelectItem("projectType", "项目类型");
		projectTypeItem.setWidth("*");
		projectTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		
		operatorIdItem = new TextItem("operatorId", "操作人");
		operatorIdItem.hide();
		
		departmentIdItem = new SelectItem("departmentId", "部门编码");
		departmentIdItem.hide();
		
		departmentIdItem.hide();
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));

		setItems(templateNameItem, remarkItem, cwdFilingMainTemplateIdItem, projectTypeItem, operatorIdItem,
				departmentIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
