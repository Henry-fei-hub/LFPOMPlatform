package com.pomplatform.client.cwd.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.cwd.datasource.DSCwdFilingTemplateDetail;

public class CwdFilingTemplateDetailNewForm extends AbstractWizadPage
{


	private final TextItem fileNameItem;
	private final TextItem parentIdItem;
	private final TextItem cwdFilingTemplateIdItem;
	private final TextItem operatorIdItem;
	private final DateTimeItem createTimeItem;

	public CwdFilingTemplateDetailNewForm() {
		DSCwdFilingTemplateDetail ds = DSCwdFilingTemplateDetail.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		fileNameItem = new TextItem("fileName", "文档名称");
		__formItems.add(fileNameItem);
		parentIdItem = new TextItem("parentId", "父级id");
		__formItems.add(parentIdItem);
		cwdFilingTemplateIdItem = new TextItem("cwdFilingTemplateId", "模板主键");
		__formItems.add(cwdFilingTemplateIdItem);
		operatorIdItem = new TextItem("operatorId", "操作人");
		__formItems.add(operatorIdItem);
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		__formItems.add(createTimeItem);

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
		manager.setDataSource(DSCwdFilingTemplateDetail.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
