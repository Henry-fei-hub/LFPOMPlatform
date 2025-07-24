package com.pomplatform.client.taskmanage.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.taskmanage.datasource.DSScwdtasktemplatetccor;

public class ScwdtasktemplatetccorNewForm extends AbstractWizadPage
{


	private final TextItem templateNameItem;
	private final TextItem projectAreaItem;
	private final TextItem operatorItem;
	private final DateTimeItem createTimeItem;
	private final SelectItem departmentIdItem;
	private final SelectItem companyIdItem;
	private final TextItem companyNoItem;
	private final TextItem numberOfDayItem;
	private final TextItem projectLevelItem;
	private final TextItem numberOfParticipantItem;

	public ScwdtasktemplatetccorNewForm() {
		DSScwdtasktemplatetccor ds = DSScwdtasktemplatetccor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		templateNameItem = new TextItem("templateName", "模板名称");
		__formItems.add(templateNameItem);
		projectAreaItem = new TextItem("projectArea", "项目面积");
		__formItems.add(projectAreaItem);
		operatorItem = new TextItem("operator", "操作人");
		__formItems.add(operatorItem);
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		__formItems.add(createTimeItem);
		departmentIdItem = new SelectItem("departmentId", "部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		__formItems.add(departmentIdItem);
		companyIdItem = new SelectItem("companyId", "归属公司编码");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		__formItems.add(companyIdItem);
		companyNoItem = new TextItem("companyNo", "公司编号");
		__formItems.add(companyNoItem);
		numberOfDayItem = new TextItem("numberOfDay", "天数(周期)");
		__formItems.add(numberOfDayItem);
		projectLevelItem = new TextItem("projectLevel", "项目类型");
		__formItems.add(projectLevelItem);
		numberOfParticipantItem = new TextItem("numberOfParticipant", "参与人数");
		__formItems.add(numberOfParticipantItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSScwdtasktemplatetccor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
