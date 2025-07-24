package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.employee.datasource.DSSelectEmployee;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSCarsApply;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class CarsApplyUpdateForm extends AbstractWizadPage
{

	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final TextItem companyIdItem;
	private final DateTimeItem startDateItem;
	private final DateTimeItem endDateItem;
	private final TextItem projectNameItem;
	private final TextItem projectCodeItem;
	private final SelectItem typeItem;
	private final TextItem unitItem;
	private final TextItem addressItem;
	private final TextItem cardItem;
	private final TextItem reasonItem;
	private final TextAreaItem planItem;
	private final TextItem drafterItem;
	private final TextAreaItem remarkItem;
	private final SelectItem subTypeItem;
	private final SelectItem targetProvinceItem;
	private final ComboBoxItem contactPersonItem;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private final VLayout mainLayout;

	public CarsApplyUpdateForm() {

		mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.setBackgroundColor("#fff");
		mainLayout.setLayoutLeftMargin(30);
		mainLayout.setLayoutRightMargin(30);
		mainLayout.setLayoutTopMargin(15);
		
		DSCarsApply ds = DSCarsApply.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.setWidth("*");
		employeeIdItem.setTextBoxStyle("customInputTextStyle");
		employeeIdItem.setDisabled(true);
		__formItems.add(employeeIdItem);

		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setTextBoxStyle("customInputTextStyle");
		companyIdItem.setDisabled(true);
		__formItems.add(companyIdItem);
		
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setWidth("*");
		employeeNoItem.setTextBoxStyle("customInputTextStyle");
		employeeNoItem.setDisabled(true);
		__formItems.add(employeeNoItem);

		departmentIdItem = new TextItem("departmentId", "所在部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setTextBoxStyle("customInputTextStyle");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setDisabled(true);
		__formItems.add(departmentIdItem);
		
		cardItem = new TextItem("card", shouldNotBeNull + "手机号码");
		cardItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(cardItem);
		
		typeItem = new SelectItem("type", shouldNotBeNull + "用车范围");
		typeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_104"));
		typeItem.setControlStyle("customInputTextStyle");
		__formItems.add(typeItem);
		
		unitItem = new TextItem("unit", shouldNotBeNull + "同行人数");
		unitItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(unitItem);
		
		addressItem = new TextItem("address", shouldNotBeNull + "申请用车车型");
		addressItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(addressItem);
		
		startDateItem = new DateTimeItem("startDate", shouldNotBeNull + "用车开始时间");
		startDateItem.setWidth("*");
		startDateItem.setUseMask(true);
		startDateItem.setUseTextField(true);
		startDateItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(startDateItem);
		
		endDateItem = new DateTimeItem("endDate", shouldNotBeNull + "用车结束时间");
		endDateItem.setWidth("*");
		endDateItem.setUseMask(true);
		endDateItem.setUseTextField(true);
		endDateItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(endDateItem);
		
		projectNameItem = new TextItem("projectName", shouldNotBeNull + "出发地");
		projectNameItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(projectNameItem);
		
		projectCodeItem = new TextItem("projectCode", shouldNotBeNull + "目的地");
		projectCodeItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(projectCodeItem);
		
		drafterItem = new TextItem("drafter", "起草人");
		drafterItem.hide();
		__formItems.add(drafterItem);
		
		reasonItem = new TextItem("reason", shouldNotBeNull + "用车目的");
		reasonItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(reasonItem);
		
		subTypeItem = new SelectItem("subType", shouldNotBeNull + "内部派车/外部专车");
		subTypeItem.setControlStyle("customInputTextStyle");
		subTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_105"));
		subTypeItem.hide();
		__formItems.add(subTypeItem);
		subTypeItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					if(ClientUtil.checkAndGetIntValue(event.getValue()) == 0){
						targetProvinceItem.show();
						contactPersonItem.show();
					}else{
						targetProvinceItem.clearValue();
						contactPersonItem.clearValue();
						targetProvinceItem.hide();
						contactPersonItem.hide();
					}
				}
			}
		});
		
		targetProvinceItem = new SelectItem("targetProvince", shouldNotBeNull + "车辆信息");
		targetProvinceItem.setControlStyle("customInputTextStyle");
		targetProvinceItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_106"));
		targetProvinceItem.hide();
		__formItems.add(targetProvinceItem);
		
		Criteria ct = new Criteria();
		ct.addCriteria("status", 0);
		ct.addCriteria("dutyId", 31);//司机
		
		ListGridField employeeNoField = new ListGridField("employeeNo");
		ListGridField employeeNameField = new ListGridField("employeeName");
		ListGridField departmentField = new ListGridField("departmentId");
		contactPersonItem = new ComboBoxItem("contactPerson", shouldNotBeNull + "司机");
		contactPersonItem.setControlStyle("customInputTextStyle");
		contactPersonItem.setRequired(true);
		contactPersonItem.setWidth("*");
		contactPersonItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		contactPersonItem.setChangeOnKeypress(false);
		contactPersonItem.setValueField("employeeId");
		contactPersonItem.setDisplayField("employeeName");
		contactPersonItem.hide();
		contactPersonItem.setOptionDataSource(DSSelectEmployee.getInstance());
		contactPersonItem.setPickListFields(employeeNoField, employeeNameField, departmentField);
		contactPersonItem.setPickListCriteria(ct);
		__formItems.add(contactPersonItem);
		
		planItem = new TextAreaItem("plan", "行程安排");
		planItem.setWidth("*");
		planItem.setColSpan(2);
		planItem.setRowSpan(3);
		planItem.setTextBoxStyle("customTextAreaStyle");
		__formItems.add(planItem);
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setWidth("*");
		remarkItem.setColSpan(2);
		remarkItem.setRowSpan(3);
		remarkItem.setTextBoxStyle("customTextAreaStyle");
		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		reasonItem.setColSpan(4);
		setPageMode(PAGE_MODE_UPDATE);
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
	public void startEdit() {
		Record record = getRecord();
		if(record != null){
			__form.editRecord(record);
		}else{
			__form.editNewRecord();
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSCarsApply.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(null == employeeIdItem.getValue()){
			SC.say("请重新登录之后再申请本流程");
			return false;
		}
		if(null == cardItem.getValue()){
			SC.say("请填写手机号码");
			return false;
		}
		if(null == typeItem.getValue()){
			SC.say("请选择用车范围");
			return false;
		}
		if(null == unitItem.getValue()){
			SC.say("请填写同行人数");
			return false;
		}
		if(null == addressItem.getValue()){
			SC.say("请填写申请用车车型");
			return false;
		}
		if(null == startDateItem.getValue()){
			SC.say("请填写用车开始时间");
			return false;
		}
		if(null == endDateItem.getValue()){
			SC.say("请填写用车结束时间");
			return false;
		}
		if(startDateItem.getValueAsDate().getTime() >= endDateItem.getValueAsDate().getTime()){
			SC.say("用车结束时间必须晚于用车开始时间");
			return false;
		}
		if(null == projectNameItem.getValue()){
			SC.say("请填写出发地");
			return false;
		}
		if(null == projectCodeItem.getValue()){
			SC.say("请填写目的地");
			return false;
		}
		if(null == reasonItem.getValue()){
			SC.say("请填写用车目的");
			return false;
		}
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

}
