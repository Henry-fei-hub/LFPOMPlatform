package com.pomplatform.client.shift.form;

import java.util.Date;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.shift.datasource.DSManageShiftTime;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.BlurEvent;
import com.smartgwt.client.widgets.form.fields.events.BlurHandler;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;

public class ManageShiftTimeUpdateForm extends AbstractWizadPage
{


	private final TextItem shiftTimeManageIdItem;
	private final TextItem shiftTimeNameItem;
	private final CheckboxItem checkSignInItem;
	private final TextItem signInTimeItem;
	private final CheckboxItem checkSignOffItem;
	private final TextItem signOffTimeItem;
	private final IntegerItem lateMinutesItem;
	private final IntegerItem leaveEarlyTimeItem;
	private final TextItem signInStartTimeItem;
	private final TextItem signInEndTimeItem;
	private final TextItem signOffStartTimeItem;
	private final TextItem signOffEndTimeItem;
	private final TextItem daysItem;
	private final IntegerItem minutesItem;
	private final TextItem overtimeStartTimeItem;
	private final DateTimeItem createTimeItem;
	private final DateTimeItem updateTimeItem;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	
	public ManageShiftTimeUpdateForm() {
		DSManageShiftTime ds = DSManageShiftTime.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		shiftTimeManageIdItem = new TextItem("shiftTimeManageId", "班次时段维护表编码");
		shiftTimeManageIdItem.setDisabled(true);
		shiftTimeManageIdItem.setRequired(true);
		IsIntegerValidator shiftTimeManageIdValidator = new IsIntegerValidator();
		shiftTimeManageIdItem.setValidators(shiftTimeManageIdValidator);
		shiftTimeManageIdItem.hide();
		__formItems.add(shiftTimeManageIdItem);

		shiftTimeNameItem = new TextItem("shiftTimeName", shouldNotBeNull + "时段名称");
		shiftTimeNameItem.setWidth("*");
		__formItems.add(shiftTimeNameItem);
		
		overtimeStartTimeItem = new TextItem("overtimeStartTime", shouldNotBeNull + "开始算加班时间（格式如22:00）");
		overtimeStartTimeItem.setWidth("*");
		overtimeStartTimeItem.setMask("[0-2][0-9]:[0-5][0-9]");
		overtimeStartTimeItem.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				TimeValidate(overtimeStartTimeItem);			
			}
		});
		__formItems.add(overtimeStartTimeItem);
		
		checkSignInItem = new CheckboxItem("checkSignIn", "需要签到");
		checkSignInItem.setWidth("*");
		__formItems.add(checkSignInItem);
		
		signInTimeItem = new TextItem("signInTime", shouldNotBeNull + "上班时间（格式如09:00）");
		signInTimeItem.setWidth("*");
		signInTimeItem.setMask("[0-2][0-9]:[0-5][0-9]");
		signInTimeItem.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				TimeValidate(signInTimeItem);
			}
		});
		__formItems.add(signInTimeItem);
		
		checkSignOffItem = new CheckboxItem("checkSignOff", "需要签退");
		checkSignOffItem.setWidth("*");
		__formItems.add(checkSignOffItem);
		
		signOffTimeItem = new TextItem("signOffTime", shouldNotBeNull + "下班时间（格式如09:00）");
		signOffTimeItem.setWidth("*");
		signOffTimeItem.setMask("[0-2][0-9]:[0-5][0-9]");
		signOffTimeItem.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				TimeValidate(signOffTimeItem);
			}
		});
		__formItems.add(signOffTimeItem);
		
		lateMinutesItem = new IntegerItem("lateMinutes", shouldNotBeNull + "计迟到时间（分钟）");
		lateMinutesItem.setWidth("*");
		__formItems.add(lateMinutesItem);
		
		leaveEarlyTimeItem = new IntegerItem("leaveEarlyTime", shouldNotBeNull + "计早退时间（分钟）");
		leaveEarlyTimeItem.setWidth("*");
		__formItems.add(leaveEarlyTimeItem);
		
		signInStartTimeItem = new TextItem("signInStartTime", shouldNotBeNull + "签到开始时间（格式如09:00）");
		signInStartTimeItem.setWidth("*");
		signInStartTimeItem.setMask("[0-2][0-9]:[0-5][0-9]");
		signInStartTimeItem.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				TimeValidate(signInStartTimeItem);
			}
		});
		__formItems.add(signInStartTimeItem);
		
		signInEndTimeItem = new TextItem("signInEndTime", shouldNotBeNull + "签到结束时间（格式如09:00）");
		signInEndTimeItem.setWidth("*");
		signInEndTimeItem.setMask("[0-2][0-9]:[0-5][0-9]");
		signInEndTimeItem.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				TimeValidate(signInEndTimeItem);
			}
		});
		__formItems.add(signInEndTimeItem);
		
		signOffStartTimeItem = new TextItem("signOffStartTime", shouldNotBeNull + "签退开始时间（格式如09:00）");
		signOffStartTimeItem.setWidth("*");
		signOffStartTimeItem.setMask("[0-2][0-9]:[0-5][0-9]");
		signOffStartTimeItem.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				TimeValidate(signOffStartTimeItem);
			}
		});
		__formItems.add(signOffStartTimeItem);
		
		signOffEndTimeItem = new TextItem("signOffEndTime", shouldNotBeNull + "签退结束时间（格式如09:00）");
		signOffEndTimeItem.setWidth("*");
		signOffEndTimeItem.setMask("[0-2][0-9]:[0-5][0-9]");
		signOffEndTimeItem.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				TimeValidate(signOffEndTimeItem);
			}
		});
		__formItems.add(signOffEndTimeItem);
		
		daysItem = new TextItem("days", shouldNotBeNull + "计多少工作日");
		daysItem.setWidth("*");
		__formItems.add(daysItem);
		
		minutesItem = new IntegerItem("minutes", shouldNotBeNull + "计多少分钟");
		minutesItem.setWidth("*");
		__formItems.add(minutesItem);
		
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		createTimeItem.setWidth("*");
		createTimeItem.setDisabled(true);
		__formItems.add(createTimeItem);
		
		updateTimeItem = new DateTimeItem("updateTime", "修改时间");
		updateTimeItem.setWidth("*");
		updateTimeItem.setDisabled(true);
		updateTimeItem.setDefaultValue(new Date());
		__formItems.add(updateTimeItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(8);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		shiftTimeNameItem.setColSpan(4);
		overtimeStartTimeItem.setColSpan(4);
		checkSignInItem.setColSpan(1);
		signInTimeItem.setColSpan(3);
		checkSignOffItem.setColSpan(1);
		signOffTimeItem.setColSpan(3);
		lateMinutesItem.setColSpan(4);
		leaveEarlyTimeItem.setColSpan(4);
		signInStartTimeItem.setColSpan(4);
		signInEndTimeItem.setColSpan(4);
		signOffStartTimeItem.setColSpan(4);
		signOffEndTimeItem.setColSpan(4);
		daysItem.setColSpan(4);
		minutesItem.setColSpan(4);
		createTimeItem.setColSpan(4);
		updateTimeItem.setColSpan(4);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSManageShiftTime.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		TimeValidate(overtimeStartTimeItem);
		TimeValidate(signInTimeItem);
		TimeValidate(signOffTimeItem);
		TimeValidate(signInStartTimeItem);
		TimeValidate(signInEndTimeItem);
		TimeValidate(signOffStartTimeItem);
		TimeValidate(signOffEndTimeItem);
		Map map = __form.getValues();
		formatTime(map, "overtimeStartTime");
		formatTime(map, "signInTime");
		formatTime(map, "signOffTime");
		formatTime(map, "signInStartTime");
		formatTime(map, "signInEndTime");
		formatTime(map, "signOffStartTime");
		formatTime(map, "signOffEndTime");
		return map;
	}

	private void formatTime(Map map, String key){
		if(map.containsKey(key)){
			map.put(key, new StringBuilder(map.get(key).toString()).insert(2, ":").toString());
		}
	}
	
	private void TimeValidate(FormItem item){
		if(null != item.getValue()){
			String value = item.getValue().toString();
			StringBuilder sb = new StringBuilder();
			int first = ClientUtil.checkAndGetIntValue(value.substring(0, 1));
			sb.append(first);
			int second = ClientUtil.checkAndGetIntValue(value.substring(1,2));
			if(first == 2 && second > 3){
				second = 3;
			}
			sb.append(second);
			sb.append(ClientUtil.checkAndGetIntValue(value.substring(2,3)));
			sb.append(ClientUtil.checkAndGetIntValue(value.substring(3,4)));
			item.setValue(sb.toString());
		}
	}

}
