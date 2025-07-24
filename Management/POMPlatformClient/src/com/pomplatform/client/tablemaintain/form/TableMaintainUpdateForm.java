package com.pomplatform.client.tablemaintain.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.tablemaintain.datasource.DSTableMaintain;

public class TableMaintainUpdateForm extends AbstractWizadPage
{


	private final TextItem tableMaintainIdItem;
	private final TextItem tableNameItem;
	private final TextItem remarkItem;

	public TableMaintainUpdateForm() {
		DSTableMaintain ds = DSTableMaintain.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		tableMaintainIdItem = new TextItem("tableMaintainId", "数据库表维护主键");
		tableMaintainIdItem.setDisabled(true);
		tableMaintainIdItem.setRequired(true);
		IsIntegerValidator tableMaintainIdValidator = new IsIntegerValidator();
		tableMaintainIdItem.setValidators(tableMaintainIdValidator);
		__formItems.add(tableMaintainIdItem);
		tableNameItem = new TextItem("tableName", "数据库名称");
		__formItems.add(tableNameItem);
		remarkItem = new TextItem("remark", "备注");
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
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSTableMaintain.getInstance());
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
