package com.pomplatform.client.taskmanage.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.taskmanage.datasource.DSCwdTaskTemplateDetail;

public class CwdTaskTemplateDetailNewForm extends AbstractWizadPage
{


	private final TextItem cwdTaskTemplateIdItem;
	private final TextItem taskNameItem;
	private final TextItem taskContentItem;
	private final TextItem taskDemandItem;
	private final TextItem numberOfDayItem;
	private final SelectItem parentIdItem;
	private final TextItem orderNumItem;
	private final TextItem taskTypeItem;
	private final TextItem taskLevelItem;

	public CwdTaskTemplateDetailNewForm() {
		DSCwdTaskTemplateDetail ds = DSCwdTaskTemplateDetail.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		cwdTaskTemplateIdItem = new TextItem("cwdTaskTemplateId", "模板主键");
		__formItems.add(cwdTaskTemplateIdItem);
		taskNameItem = new TextItem("taskName", "任务名称");
		__formItems.add(taskNameItem);
		taskContentItem = new TextItem("taskContent", "任务内容");
		__formItems.add(taskContentItem);
		taskDemandItem = new TextItem("taskDemand", "任务要求");
		__formItems.add(taskDemandItem);
		numberOfDayItem = new TextItem("numberOfDay", "天数");
		__formItems.add(numberOfDayItem);
		parentIdItem = new SelectItem("parentId", "父级任务");
//		parentIdItem.setValueMap(KeyValueManager.getValueMap("project_types"));
		KeyValueManager.loadValueMap("project_types", parentIdItem);
		__formItems.add(parentIdItem);
		orderNumItem = new TextItem("orderNum", "排序值  升序");
		__formItems.add(orderNumItem);
		taskTypeItem = new TextItem("taskType", "任务类型 1业态 2专业 3阶段 4任务");
		__formItems.add(taskTypeItem);
		taskLevelItem = new TextItem("taskLevel", "任务级别 1普通 2紧急 3非常紧急");
		__formItems.add(taskLevelItem);

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
		manager.setDataSource(DSCwdTaskTemplateDetail.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
