package com.pomplatform.client.taskmanage.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.taskmanage.datasource.CDScwdtasktemplatetccor;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ScwdtasktemplatetccorSearchForm extends SearchForm {

	private final TextItem templateNameItem;
	private final TextItem companyNoItem;
	private final TextItem cwdTaskTemplateIdItem;
	private final TextItem projectAreaItem;
	private final TextItem operatorItem;
	private final SelectItem departmentIdItem;
	private final SelectItem companyIdItem;
	private final TextItem numberOfDayItem;
	private final SelectItem projectLevelItem;
	private final TextItem numberOfParticipantItem;

	public ScwdtasktemplatetccorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDScwdtasktemplatetccor.getInstance());
		templateNameItem = new TextItem("templateName", "模板名称");
		templateNameItem.setWidth("*");
		companyNoItem = new TextItem("companyNo", "公司编号");
		companyNoItem.hide();
		cwdTaskTemplateIdItem = new TextItem("cwdTaskTemplateId", "主键");
		cwdTaskTemplateIdItem.hide();
		projectAreaItem = new TextItem("projectArea", "项目面积");
		projectAreaItem.setWidth("*");
		operatorItem = new TextItem("operator", "操作人");
		operatorItem.hide();
		departmentIdItem = new SelectItem("departmentId", "部门");
		departmentIdItem.hide();
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		companyIdItem = new SelectItem("companyId", "归属公司编码");
		companyIdItem.hide();
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		numberOfDayItem = new TextItem("numberOfDay", "天数(周期)");
		numberOfDayItem.setWidth("*");
		projectLevelItem = new SelectItem("projectLevel", "项目类型");
		projectLevelItem.setWidth("*");
		numberOfParticipantItem = new TextItem("numberOfParticipant", "参与人数");
		numberOfParticipantItem.setWidth("*");

		setItems(templateNameItem, companyNoItem, cwdTaskTemplateIdItem, projectAreaItem, operatorItem,
				departmentIdItem, companyIdItem, numberOfDayItem, projectLevelItem, numberOfParticipantItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
