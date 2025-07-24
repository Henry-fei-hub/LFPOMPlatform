package com.pomplatform.client.cwd.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.cwd.datasource.DSCwdFilingTemplate;

public class CwdFilingTemplateUpdateForm extends AbstractWizadPage
{


	private final TextItem cwdFilingTemplateIdItem;
	private final TextItem templateNameItem;
	private final TextItem filingTypeItem;
	private final TextItem operatorIdItem;
	private final TextItem remarkItem;
	private final DateTimeItem createTimeItem;

	public CwdFilingTemplateUpdateForm() {
		DSCwdFilingTemplate ds = DSCwdFilingTemplate.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		cwdFilingTemplateIdItem = new TextItem("cwdFilingTemplateId", "");
		cwdFilingTemplateIdItem.setDisabled(true);
		cwdFilingTemplateIdItem.setRequired(true);
		IsIntegerValidator cwdFilingTemplateIdValidator = new IsIntegerValidator();
		cwdFilingTemplateIdItem.setValidators(cwdFilingTemplateIdValidator);
		__formItems.add(cwdFilingTemplateIdItem);
		templateNameItem = new TextItem("templateName", "模板名称");
		__formItems.add(templateNameItem);
		filingTypeItem = new TextItem("filingType", "归档类型 1基础资料区 2提资区  3审核区 4出版区");
		__formItems.add(filingTypeItem);
		operatorIdItem = new TextItem("operatorId", "操作人");
		__formItems.add(operatorIdItem);
		remarkItem = new TextItem("remark", "备注");
		__formItems.add(remarkItem);
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		__formItems.add(createTimeItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSCwdFilingTemplate.getInstance());
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
