package com.pomplatform.client.projectStageStorage.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.projectStageStorage.datasource.DSSprojectstagestoragepor;

public class SprojectstagestorageporUpdateForm extends AbstractWizadPage
{


	private final TextItem projectStageStorageIdItem;
	private final TextItem projectIdItem;
	private final TextItem stageIdItem;
	private final TextItem percentItem;
	private final TextItem projectAmountItem;
	private final TextItem stageNameItem;
	private final TextItem remarkItem;

	public SprojectstagestorageporUpdateForm() {
		DSSprojectstagestoragepor ds = DSSprojectstagestoragepor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		projectStageStorageIdItem = new TextItem("projectStageStorageId", "id");
		projectStageStorageIdItem.setDisabled(true);
		projectStageStorageIdItem.setRequired(true);
		IsIntegerValidator projectStageStorageIdValidator = new IsIntegerValidator();
		projectStageStorageIdItem.setValidators(projectStageStorageIdValidator);
		__formItems.add(projectStageStorageIdItem);
		projectIdItem = new TextItem("projectId", "项目编码");
		__formItems.add(projectIdItem);
		stageIdItem = new TextItem("stageId", "阶段代码");
		__formItems.add(stageIdItem);
		percentItem = new TextItem("percent", "占比(%)");
		__formItems.add(percentItem);
		projectAmountItem = new TextItem("projectAmount", "项目积分");
		__formItems.add(projectAmountItem);
		stageNameItem = new TextItem("stageName", "阶段名称");
		__formItems.add(stageNameItem);
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
		manager.setDataSource(DSSprojectstagestoragepor.getInstance());
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
