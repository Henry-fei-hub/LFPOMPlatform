package com.pomplatform.client.cwdfilefilter.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.cwdfilefilter.datasource.DSCwdFileFilter;

public class CwdFileFilterNewForm extends AbstractWizadPage
{


	private final TextItem typeItem;
	private final TextItem filterFileExtensionItem;
	private final TextItem remarkItem;

	public CwdFileFilterNewForm() {
		DSCwdFileFilter ds = DSCwdFileFilter.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		typeItem = new TextItem("type", "类型");
		__formItems.add(typeItem);
		filterFileExtensionItem = new TextItem("filterFileExtension", "文件后缀名称");
		__formItems.add(filterFileExtensionItem);
		remarkItem = new TextItem("remark", "描述");
		__formItems.add(remarkItem);

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
		manager.setDataSource(DSCwdFileFilter.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
