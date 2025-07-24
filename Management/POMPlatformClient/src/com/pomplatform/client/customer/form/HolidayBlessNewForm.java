package com.pomplatform.client.customer.form;

import java.util.Date;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.customer.datasource.DSHolidayBless;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class HolidayBlessNewForm extends AbstractWizadPage
{
	private final TextItem holidayNameItem;
	private final DateItem holidayDateItem;
	private final SelectItem holidayTypeItem;
	private final SelectItem sendObjectItem;
	private final SelectItem objectTypeItem;
	private final DateTimeItem operateTimeItem;
	private final TextAreaItem blessWordsItem;
	private final TextAreaItem remarkItem;
	public HolidayBlessNewForm() {
		DSHolidayBless ds = DSHolidayBless.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		holidayNameItem = new TextItem("holidayName", "节日名称");
		holidayNameItem.setWidth("*");
		__formItems.add(holidayNameItem);
		
		holidayDateItem = new DateItem("holidayDate", "节日日期");
		holidayDateItem.setWidth("*");
		holidayDateItem.setUseTextField(true);
		__formItems.add(holidayDateItem);
		
		holidayTypeItem = new SelectItem("holidayType", "节日类型");
		holidayTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_125"));
		holidayTypeItem.setWidth("*");
		__formItems.add(holidayTypeItem);
		
		sendObjectItem = new SelectItem("sendObject", "推送对象");
		sendObjectItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_126"));
		sendObjectItem.setWidth("*");
		__formItems.add(sendObjectItem);
		
		objectTypeItem = new SelectItem("objectType", "对象类型");
		objectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_75"));
		objectTypeItem.setWidth("*");
		__formItems.add(objectTypeItem);
		
		operateTimeItem = new DateTimeItem("operateTime", "操作时间");
		operateTimeItem.setCanEdit(false);
		operateTimeItem.setDefaultValue(new Date());
		operateTimeItem.setWidth("*");
		__formItems.add(operateTimeItem);
		
		blessWordsItem = new TextAreaItem("blessWords", "祝福语");
		blessWordsItem.setStartRow(true);
		blessWordsItem.setRowSpan(3);
		blessWordsItem.setColSpan(4);
		blessWordsItem.setWidth("*");
		__formItems.add(blessWordsItem);
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setStartRow(true);
		remarkItem.setRowSpan(3);
		remarkItem.setColSpan(4);
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);
		
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
		manager.setDataSource(DSHolidayBless.getInstance());
		manager.addMember(__form);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public java.util.Map getValuesAsMap() {
		Map value = __form.getValues();
		value.put("operateEmployeeId",ClientUtil.getEmployeeId());
		return value;
	}


}
