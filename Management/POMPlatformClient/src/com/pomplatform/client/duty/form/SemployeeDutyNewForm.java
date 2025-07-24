package com.pomplatform.client.duty.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.duty.datasource.DSSemployeeDuty;

public class SemployeeDutyNewForm extends AbstractWizadPage {

	private final TextItem dutyNameItem;
	private final TextItem descriptionItem;
	private final IPickTreeItem parentDutyIdItem;

	public SemployeeDutyNewForm() {
		DSSemployeeDuty ds = DSSemployeeDuty.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		dutyNameItem = new TextItem("dutyName", "职位名称");
		dutyNameItem.setWidth("*");
		__formItems.add(dutyNameItem);

		descriptionItem = new TextItem("description", "职位描述");
		descriptionItem.setWidth("*");
		__formItems.add(descriptionItem);

		parentDutyIdItem = new IPickTreeItem("parentDutyId", "上级职位");
		parentDutyIdItem.setWidth("*");
		parentDutyIdItem.setCanSelectParentItems(true);
        parentDutyIdItem.setValueTree(KeyValueManager.getTree("duties"));
		__formItems.add(parentDutyIdItem);

		__form.setItems(getFormItemArray());

		__form.setDataSource(ds);
		__form.setNumCols(4);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if (getRecord() != null) {
			__form.editRecord(getRecord());
		} else {
			__form.editNewRecord();
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSemployeeDuty.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map values = __form.getValues();
		ClientUtil.departmentParameterProcess(values);
		return values;
	}
}
