package com.pomplatform.client.activitympcor.form;

import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.activitympcor.datasource.DSSactivityMpcor;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ActivityMeetDetailsForm extends AbstractWizadPage {

	private static final Logger __logger = Logger.getLogger("");
	private final TextItem meetTitleItem;
	private final TextItem meetTypeItem;
	private final TextItem customerNameItem;
	private final TextItem projectNameItem;
	private final TextItem meetAddressItem;
	private final TextItem contactNameItem;
	private final TextItem theirEmployeesItem;
	private final TextItem ourEmployeesItem;
	private final TextItem ourDesignerEmployeesItem;
	private final TextItem meetTimeItem;
	private final TextAreaItem theirRequireItem;
	private final TextAreaItem meetTargetItem;
	private final TextAreaItem remarkItem;

	public ActivityMeetDetailsForm() {
		DSSactivityMpcor ds = DSSactivityMpcor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		meetTitleItem = new TextItem("meetTitle","会议主题");
		meetTitleItem.setWidth("*");
		meetTitleItem.setCanEdit(false);
		meetTitleItem.setControlStyle("customInputTextStyle");
		__formItems.add(meetTitleItem);
		
		meetTypeItem = new TextItem("meetType","会议类型");
		meetTypeItem.setWidth("*");
		meetTypeItem.setCanEdit(false);
		meetTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_150"));
		__formItems.add(meetTypeItem);
		
		customerNameItem = new TextItem("customerName","客户名称");
		customerNameItem.setCanEdit(false);
		customerNameItem.setWidth("*");
		__formItems.add(customerNameItem);
		
		projectNameItem = new TextItem("projectName","项目名称");
		projectNameItem.setCanEdit(false);
		projectNameItem.setWidth("*");
		__formItems.add(projectNameItem);
	
		contactNameItem = new TextItem("contactName","联系人");
		contactNameItem.setWidth("*");
		contactNameItem.setCanEdit(false);
		__formItems.add(contactNameItem);
		
		meetTimeItem = new TextItem("meetTime","会议时间");
		meetTimeItem.setWidth("*");
		meetTimeItem.setCanEdit(false);
		__formItems.add(meetTimeItem);
		
		theirEmployeesItem = new TextItem("theirEmployees","甲方出席人员");
		theirEmployeesItem.setWidth("*");
		theirEmployeesItem.setCanEdit(false);
		__formItems.add(theirEmployeesItem);
		
		ourEmployeesItem = new TextItem("ourEmployees","我方营销出席人员");
		ourEmployeesItem.setWidth("*");
		ourEmployeesItem.setCanEdit(false);
		__formItems.add(ourEmployeesItem);
		
		ourDesignerEmployeesItem = new TextItem("ourDesignerEmployees","我方设计出席人员");
		ourDesignerEmployeesItem.setWidth("*");
		ourDesignerEmployeesItem.setCanEdit(false);
		__formItems.add(ourDesignerEmployeesItem);
		
		meetAddressItem = new TextItem("meetAddress","会议地址");
		meetAddressItem.setWidth("*");
		meetAddressItem.setCanEdit(false);
		__formItems.add(meetAddressItem);
		
		theirRequireItem = new TextAreaItem("theirRequire","甲方要求");
		theirRequireItem.setWidth("*");
		theirRequireItem.setCanEdit(false);
		__formItems.add(theirRequireItem);
		
		meetTargetItem = new TextAreaItem("meetTarget","会议目标");
		meetTargetItem.setWidth("*");
		meetTargetItem.setCanEdit(false);
		__formItems.add(meetTargetItem);
		
		remarkItem = new TextAreaItem("remark","备注信息");
		remarkItem.setWidth("*");
		remarkItem.setCanEdit(false);
		__formItems.add(remarkItem);
		
		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
		//meetTitleItem.setColSpan(4);
		//meetTypeItem.setColSpan(4);
		//customerNameItem.setColSpan(4);
		//projectNameItem.setColSpan(4);
		//contactNameItem.setColSpan(4);
		theirEmployeesItem.setColSpan(4);
		//ourEmployeesItem.setColSpan(4);
		//meetTimeItem.setColSpan(4);
		meetAddressItem.setColSpan(4);
		theirRequireItem.setColSpan(4);
		meetTargetItem.setColSpan(4);
		remarkItem.setColSpan(4);
		__form.setDisabled(true);
		
	}

	@Override
	public Map getValuesAsMap() {
		Map params = __form.getValues();
		return params;
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) {
			Record record = getRecord();
			String idStr = record.getAttribute("ourEmployees");
			if(!BaseHelpUtils.isNullOrEmpty(idStr)){
				String [] strArra = idStr.split(",");
				record.setAttribute("ourEmployees", strArra);
			}
			__form.editRecord(record);
		}else{
			__form.editNewRecord();
		}
		
	}

}
