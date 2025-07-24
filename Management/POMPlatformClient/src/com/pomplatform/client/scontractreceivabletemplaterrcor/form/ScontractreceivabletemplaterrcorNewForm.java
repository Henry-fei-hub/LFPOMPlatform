package com.pomplatform.client.scontractreceivabletemplaterrcor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.scontractreceivabletemplaterrcor.datasource.DSScontractreceivabletemplaterrcor;

public class ScontractreceivabletemplaterrcorNewForm extends AbstractWizadPage
{


	private final TextItem receivableNameItem;
	private final TextItem remarkItem;
	private final TextItem parentIdItem;
	private final TextItem operatorItem;
	private final DateTimeItem createTimeItem;
	private final DateTimeItem updateTimeItem;
	private final TextItem receivablePercentageItem;

	public ScontractreceivabletemplaterrcorNewForm() {
		DSScontractreceivabletemplaterrcor ds = DSScontractreceivabletemplaterrcor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		receivableNameItem = new TextItem("receivableName", "阶段名称");
		__formItems.add(receivableNameItem);
		remarkItem = new TextItem("remark", "备注");
		__formItems.add(remarkItem);
		parentIdItem = new TextItem("parentId", "收款阶段id的父节点");
		__formItems.add(parentIdItem);
		operatorItem = new TextItem("operator", "操作人");
		__formItems.add(operatorItem);
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		__formItems.add(createTimeItem);
		updateTimeItem = new DateTimeItem("updateTime", "修改时间");
		__formItems.add(updateTimeItem);
		receivablePercentageItem = new TextItem("receivablePercentage", "收款百分比");
		__formItems.add(receivablePercentageItem);

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
		manager.setDataSource(DSScontractreceivabletemplaterrcor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
