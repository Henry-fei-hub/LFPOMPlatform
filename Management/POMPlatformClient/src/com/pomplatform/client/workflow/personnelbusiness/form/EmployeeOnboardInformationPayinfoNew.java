package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeOnboardInformation;

public class EmployeeOnboardInformationPayinfoNew extends AbstractWizadPage
{


	private final TextItem tryTimePayItem;
	private final TextItem positivePayItem;

	public EmployeeOnboardInformationPayinfoNew() {
		DSEmployeeOnboardInformation ds = DSEmployeeOnboardInformation.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		tryTimePayItem = new TextItem("tryTimePay", "试用期工资");
		__formItems.add(tryTimePayItem);
		positivePayItem = new TextItem("positivePay", "转正工资");
		__formItems.add(positivePayItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setName("薪酬信息");
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSEmployeeOnboardInformation.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
