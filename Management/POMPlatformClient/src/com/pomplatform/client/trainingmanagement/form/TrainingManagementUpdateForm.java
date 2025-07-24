package com.pomplatform.client.trainingmanagement.form;

import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.trainingmanagement.datasource.DSTrainingManagement;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.PickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.validator.IsFloatValidator;

public class TrainingManagementUpdateForm extends AbstractWizadPage
{
	private static final Logger __LOGGER = Logger.getLogger(""); 

	private  TextItem subjectItem;
	private  SelectItem compereTypeItem;
	private  TextItem compereItem;
	private  DateTimeItem startTimeItem;
	private  DateTimeItem endTimeItem;
	private  PickTreeItem departmentIdItem;
	private  TextItem courseScoreItem;
	private  TextItem createPersonIdItem;
	private  SelectItem employeeIdItem;
	private  TextItem avgScoreItem;

	
	public TrainingManagementUpdateForm() {
		DSTrainingManagement ds = DSTrainingManagement.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		subjectItem = new TextItem("subject", "主题");
		__formItems.add(subjectItem);
		subjectItem.setWidth("*");
		courseScoreItem = new TextItem("courseScore", "课程分数");
		courseScoreItem.setWidth("*");
		__formItems.add(courseScoreItem);
		compereTypeItem = new SelectItem("compereType", "主持人类型");
		compereTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_174"));
		compereTypeItem.setWidth("*");
		compereTypeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				String compereType = event.getValue().toString();
				if (compereType == "1") {
					compereItem.hide();
					employeeIdItem.show();
				}
				if (compereType == "2") {
					compereItem.show();
					employeeIdItem.hide();
				}
			}
		});
	
		startTimeItem = new DateTimeItem("startTime", "开始时间");
		startTimeItem.setWidth("*");
		__formItems.add(startTimeItem);
		endTimeItem = new DateTimeItem("endTime", "结束时间");
		endTimeItem.setWidth("*");
		__formItems.add(endTimeItem);
		departmentIdItem = new PickTreeItem("departmentId", "部门编码");
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments", "0"));
		__formItems.add(departmentIdItem);
		
		createPersonIdItem = new TextItem("createPersonId", "创建人编码");
		createPersonIdItem.setWidth("*");
		createPersonIdItem.setHidden(true);
		__formItems.add(compereTypeItem);
		compereItem = new TextItem("compere", "主持人");
		compereItem.setWidth("*");
		__formItems.add(compereItem);
		__formItems.add(createPersonIdItem);
		employeeIdItem = new SelectItem("employeeId", "主持人");
		employeeIdItem.setWidth("*");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				compereItem.setValue(employeeIdItem.getDisplayValue());
			}
		});
		__formItems.add(employeeIdItem);
		avgScoreItem = new TextItem("avgScore", "平均分数");
		avgScoreItem.setWidth("*");
		avgScoreItem.setRequired(true);
		avgScoreItem.setHidden(true);
		IsFloatValidator avgScoreValidator = new IsFloatValidator();
		avgScoreItem.setValidators(avgScoreValidator);
		__formItems.add(avgScoreItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		Record data = getRecord();
		SC.debugger();
		if(data != null) __form.editRecord(data);
		compereType = data.getAttribute("compereType");
		if (compereType == "1") {
			compereItem.hide();
			employeeIdItem.show();
		}if (compereType == "2") {
			String compere = data.getAttribute("compere");
			employeeIdItem.setValue("");
			compereItem.setValue(compere);
			compereItem.show();
			employeeIdItem.hide();
		} 
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSTrainingManagement.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		__LOGGER.info("valuesddd---------------------"+__form.getValues());
		return __form.getValues();
	}

	private String compereType; 

	public String getCompereType() {
		return compereType;
	}

	public void setCompereType(String compereType) {
		this.compereType = compereType;
	}

}
