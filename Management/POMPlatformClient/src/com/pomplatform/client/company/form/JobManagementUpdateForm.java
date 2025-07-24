package com.pomplatform.client.company.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.company.datasource.DSJobManagement;

public class JobManagementUpdateForm extends AbstractWizadPage
{


	private final TextItem dutyIdItem;
	private final TextItem dutyNameItem;

	public JobManagementUpdateForm() {
		DSJobManagement ds = DSJobManagement.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		dutyIdItem = new TextItem("dutyId", "职位");
		dutyIdItem.setDisabled(true);
		dutyIdItem.setRequired(true);
		dutyIdItem.setHidden(true);
		IsIntegerValidator dutyIdValidator = new IsIntegerValidator();
		dutyIdItem.setValidators(dutyIdValidator);
		__formItems.add(dutyIdItem);
		dutyNameItem = new TextItem("dutyName", "职位名称");
		dutyNameItem.setWidth("*");
		__formItems.add(dutyNameItem);

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
		manager.setDataSource(DSJobManagement.getInstance());
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
