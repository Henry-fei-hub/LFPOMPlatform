package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSRegularEmployeeApply;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class RegularEmployeeApplyNewForm extends AbstractWizadPage
{

	private final ComboBoxItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final TextItem companyIdItem;
	private final SelectItem typeItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final TextItem drafterItem;
	private final TextItem dutyIdItem;
	private final VLayout mainLayout;

	public RegularEmployeeApplyNewForm() {
		mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.setBackgroundColor("#fff");
		mainLayout.setLayoutLeftMargin(30);
		mainLayout.setLayoutRightMargin(30);
		mainLayout.setLayoutTopMargin(15);
		
		DSRegularEmployeeApply ds = DSRegularEmployeeApply.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		ListGridField eNoField = new ListGridField("employeeNo");
		ListGridField eNameField = new ListGridField("employeeName");
		ListGridField departmentIdField = new ListGridField("departmentId");
		Criteria c = new Criteria();
		c.addCriteria("status", 0);
		
		employeeIdItem = new ComboBoxItem("employeeId", "转正员工姓名(支持姓名模糊搜索)");
		employeeIdItem.setWidth("*");
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
		employeeIdItem.setOptionCriteria(c);
		employeeIdItem.setValueField("employeeId");
		employeeIdItem.setDisplayField("employeeName");
		employeeIdItem.setPickListFields(eNoField, eNameField, departmentIdField);
		employeeIdItem.setControlStyle("customInputTextStyle");
		__formItems.add(employeeIdItem);
		employeeIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					getUserBasicInfo(event.getValue());
				}else{
					employeeNoItem.clearValue();
					departmentIdItem.clearValue();
					companyIdItem.clearValue();
					startDateItem.clearValue();
					endDateItem.clearValue();
				}
			}

		});

		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.setDisabled(true);
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(companyIdItem);
		
		startDateItem = new DateItem("startDate", "入职日期");
		startDateItem.setDisabled(true);
		startDateItem.setWidth("*");
		startDateItem.setUseMask(true);
		startDateItem.setUseTextField(true);
		startDateItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(startDateItem);

		departmentIdItem = new TextItem("departmentId", "所在部门");
		departmentIdItem.setDisabled(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setTextBoxStyle("customInputTextStyle");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		__formItems.add(departmentIdItem);

		typeItem = new SelectItem("type", "转正类型");//按期转正、提前转正
		typeItem.setWidth("*");
		typeItem.setControlStyle("customInputTextStyle");
		typeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_98"));
		typeItem.setDefaultValue(1);
		__formItems.add(typeItem);
		
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setDisabled(true);
		employeeNoItem.setWidth("*");
		employeeNoItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(employeeNoItem);
		
		endDateItem = new DateItem("endDate", "转正日期");
		endDateItem.setWidth("*");
		endDateItem.setUseMask(true);
		endDateItem.setUseTextField(true);
		endDateItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(endDateItem);
		
		drafterItem = new TextItem("drafter", "起草人");
		drafterItem.setDefaultValue(ClientUtil.getUserId());
		drafterItem.hide();
		__formItems.add(drafterItem);
		
		dutyIdItem = new TextItem("dutyId", "职务");
		dutyIdItem.setWidth("*");
		dutyIdItem.setTextBoxStyle("customInputTextStyle");
		dutyIdItem.setValueMap(KeyValueManager.getValueMap("duties"));
		dutyIdItem.setDisabled(true);
		__formItems.add(dutyIdItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		__form.setCellPadding(10);
		mainLayout.addMember(__form);
		addMember(mainLayout);
		FormItem[] items = __form.getFields();
		int width = (mainLayout.getWidth()-30)/23*10;
		int width2 = width * 7 / 10;
		mainLayout.setLayoutLeftMargin(width * 3 / 10 + 10);
		mainLayout.setLayoutRightMargin(0);
		for(FormItem item : items){
			item.setWidth(width2);
		}
	}

	@Override
	public boolean checkData() {
		if(null == typeItem.getValue()){
			SC.say("请选择转正类型");
			return false;
		}
		if(null == employeeIdItem.getValue()){
			SC.say("请填写上转正员工姓名");
			return false;
		}
		if(null == endDateItem.getValue()){
			SC.say("请填写上转正日期");
			return false;
		}
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSRegularEmployeeApply.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

	public void getUserBasicInfo(Object employeeId) {
		Map<String, Object> params = new HashMap<>();
		params.put("optType", "getBasicInfo");
		params.put("employeeId", employeeId);
		DBDataSource.callOperation("EP_GetUserInfoById", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record record = dsResponse.getData()[0];
					if(null != record){
						if(null != record.getAttribute("employeeNo")){
							employeeNoItem.setValue(record.getAttribute("employeeNo"));
						}
						if(null != record.getAttribute("departmentId")){
							departmentIdItem.setValue(record.getAttribute("departmentId"));
						}
						if(null != record.getAttribute("companyId")){
							companyIdItem.setValue(record.getAttribute("companyId"));
						}
						if(null != record.getAttribute("onboardDate")){
							startDateItem.setValue(record.getAttributeAsDate("onboardDate"));
						}
						if(null != record.getAttribute("positiveDate")){
							endDateItem.setValue(record.getAttributeAsDate("positiveDate"));
						}
						if(null != record.getAttribute("dutyId")){
							dutyIdItem.setValue(record.getAttribute("dutyId"));
						}
					}
				}else{
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
	}
}
