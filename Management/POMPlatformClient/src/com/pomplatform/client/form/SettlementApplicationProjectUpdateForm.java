package com.pomplatform.client.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.datasource.DSSettlementApplicationProject;

public class SettlementApplicationProjectUpdateForm extends AbstractWizadPage
{


	private final TextItem projectIdItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final TextItem departmentIdItem;
	private final TextItem subTypeItem;
	private final TextItem settlementIntegralItem;

	public SettlementApplicationProjectUpdateForm() {
		DSSettlementApplicationProject ds = DSSettlementApplicationProject.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		projectIdItem = new TextItem("projectId", "项目主键");
		__formItems.add(projectIdItem);
		projectCodeItem = new TextItem("projectCode", "项目编号");
		__formItems.add(projectCodeItem);
		projectNameItem = new TextItem("projectName", "项目名称");
		__formItems.add(projectNameItem);
		departmentIdItem = new TextItem("departmentId", "申请配合部门");
		__formItems.add(departmentIdItem);
		subTypeItem = new TextItem("subType", "已申请配合产值");
		__formItems.add(subTypeItem);
		settlementIntegralItem = new TextItem("settlementIntegral", "已结算配合产值");
		settlementIntegralItem.setRequired(true);
		IsIntegerValidator settlementIntegralValidator = new IsIntegerValidator();
		settlementIntegralItem.setValidators(settlementIntegralValidator);
		__formItems.add(settlementIntegralItem);

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
		manager.setDataSource(DSSettlementApplicationProject.getInstance());
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
