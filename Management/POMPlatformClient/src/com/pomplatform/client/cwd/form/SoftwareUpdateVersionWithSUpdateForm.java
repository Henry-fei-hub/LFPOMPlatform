package com.pomplatform.client.cwd.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.cwd.datasource.DSSoftwareUpdateVersionWithS;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IsFloatValidator;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;

public class SoftwareUpdateVersionWithSUpdateForm extends AbstractWizadPage {

	private final TextItem softwareUpdateVersionIdItem;
	private final TextItem versionNoItem;
	private final TextItem titleItem;
	private final TextAreaItem remarkItem;
	private final SelectItem softwareTypeItem;
	private final SelectItem employeeIdItem;
	private final DateTimeItem createTimeItem;
	private final TextAreaItem sqlScriptItem;
	private final CheckboxItem isRebootItem;

	public SoftwareUpdateVersionWithSUpdateForm() {
		DSSoftwareUpdateVersionWithS ds = DSSoftwareUpdateVersionWithS.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		softwareUpdateVersionIdItem = new TextItem("softwareUpdateVersionId", "主键");
		softwareUpdateVersionIdItem.setDisabled(true);
		softwareUpdateVersionIdItem.setRequired(true);
		softwareUpdateVersionIdItem.setHidden(true);
		IsIntegerValidator softwareUpdateVersionIdValidator = new IsIntegerValidator();
		softwareUpdateVersionIdItem.setValidators(softwareUpdateVersionIdValidator);
		__formItems.add(softwareUpdateVersionIdItem);
		
		versionNoItem = new TextItem("versionNo", "版本号");
		versionNoItem.setRequired(true);
		versionNoItem.setDisabled(true);
		versionNoItem.setWidth("*");
		IsFloatValidator versionNoValidator = new IsFloatValidator();
		versionNoItem.setValidators(versionNoValidator);
		__formItems.add(versionNoItem);
		
		titleItem = new TextItem("title", "更新主题");
		titleItem.setRequired(true);
		titleItem.setWidth("*");
		__formItems.add(titleItem);
		
		softwareTypeItem = new SelectItem("softwareType", "软件类型");
		softwareTypeItem.setRequired(true);
		softwareTypeItem.setWidth("*");
		softwareTypeItem.setDisabled(true);
		softwareTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_201"));
		__formItems.add(softwareTypeItem);
		
		employeeIdItem = new SelectItem("employeeId", "操作人");
		employeeIdItem.setWidth("*");
		employeeIdItem.setDefaultValue(ClientUtil.getEmployeeId());
		employeeIdItem.setDisabled(true);
		KeyValueManager.loadValueMap("employees", employeeIdItem);
		__formItems.add(employeeIdItem);
		
		isRebootItem = new CheckboxItem("isReboot", "是否需要重启服务");
		isRebootItem.setRequired(true);
		isRebootItem.setDefaultValue(true);
		isRebootItem.setWidth("*");
		__formItems.add(isRebootItem);
		
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		createTimeItem.setDisabled(true);
		createTimeItem.setWidth("*");
		__formItems.add(createTimeItem);
		
		sqlScriptItem = new TextAreaItem("sqlScript", "sql脚本");
		sqlScriptItem.setWidth("*");
		sqlScriptItem.setColSpan(4);
		sqlScriptItem.setRowSpan(3);
		__formItems.add(sqlScriptItem);
		
		remarkItem = new TextAreaItem("remark", "更新详情描述,说明更新了什么内容");
		remarkItem.setWidth("*");
		remarkItem.setRequired(true);
		remarkItem.setColSpan(4);
		remarkItem.setRowSpan(3);
		__formItems.add(remarkItem);
		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if (getRecord() != null)
			__form.editRecord(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSoftwareUpdateVersionWithS.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

}
