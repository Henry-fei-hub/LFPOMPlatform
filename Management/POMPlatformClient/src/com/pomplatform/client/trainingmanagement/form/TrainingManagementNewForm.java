package com.pomplatform.client.trainingmanagement.form;

import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.trainingmanagement.datasource.DSTrainingManagement;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.PickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class TrainingManagementNewForm extends AbstractWizadPage
{
	private static final Logger __LOGGER = Logger.getLogger("");

	private final TextItem subjectItem;
	private final SelectItem compereTypeItem;
	private final TextItem compereItem;
	private final DateTimeItem startTimeItem;
	private final DateTimeItem endTimeItem;
	private final PickTreeItem departmentIdItem;
	private final TextItem courseScoreItem;
//	private final SelectItem employeeIdItem;
	private final TextItem signInDelayItem;
	private final TextItem signOutDelayItem;
	private final ComboBoxItem employeeIdItem;
	private final TextItem siteTextItem;

	public TrainingManagementNewForm() {
		DSTrainingManagement ds = DSTrainingManagement.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		subjectItem = new TextItem("subject", "主题");
		__formItems.add(subjectItem);
		subjectItem.setWidth("*");
		courseScoreItem = new TextItem("courseScore", "课程分数");
		__formItems.add(courseScoreItem);
		courseScoreItem.setWidth("*");
		compereTypeItem = new SelectItem("compereType", "主持人类型");
		compereTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_174"));
		__formItems.add(compereTypeItem);
		compereTypeItem.setWidth("*");
		compereTypeItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if(null != event.getValue()){
					String obj = event.getValue().toString();
					if (obj == "1") {
						compereItem.hide();
						employeeIdItem.show();
					}else {
						employeeIdItem.hide();
						compereItem.show();
					}
					
				}
				
			}
		});
		compereItem = new TextItem("compere", "主持人");
		__formItems.add(compereItem);
		compereItem.setWidth("*");
		employeeIdItem = new ComboBoxItem("employeeId", "主持人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(employeeIdItem);
		employeeIdItem.setWidth("*");
		employeeIdItem.hide();
		employeeIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				String compere = employeeIdItem.getDisplayValue();
				compereItem.setValue(compere);
			}
		});
		startTimeItem = new DateTimeItem("startTime", "开始时间");
		__formItems.add(startTimeItem);
		startTimeItem.setWidth("*");
		endTimeItem = new DateTimeItem("endTime", "结束时间");
		__formItems.add(endTimeItem);
		endTimeItem.setWidth("*");
		
		signInDelayItem = new TextItem("signInDelay", "签到推迟时间");
		__formItems.add(signInDelayItem);
		signInDelayItem.setWidth("*");
		signOutDelayItem = new TextItem("signOutDelay", "签退推迟时间");
		__formItems.add(signInDelayItem);
		signInDelayItem.setWidth("*");
		departmentIdItem = new PickTreeItem("departmentId", "所属部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments", "0"));
		__formItems.add(departmentIdItem);
		departmentIdItem.setWidth("*");
		siteTextItem = new TextItem("site","培训地点");
		siteTextItem.setWidth("*");
		__formItems.add(siteTextItem);

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
		manager.setDataSource(DSTrainingManagement.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
