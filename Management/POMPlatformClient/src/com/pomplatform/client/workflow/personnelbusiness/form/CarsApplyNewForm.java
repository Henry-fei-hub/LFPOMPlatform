package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSCarsApply;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.VLayout;

public class CarsApplyNewForm extends AbstractWizadPage
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
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	
	private final VLayout mainLayout;

	public CarsApplyNewForm() {
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
		employeeIdItem.setDefaultValue(ClientUtil.getUserId());
		employeeIdItem.setTextBoxStyle("customInputTextStyle");
		employeeIdItem.setDisabled(true);
		__formItems.add(employeeIdItem);

		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setDefaultValue(ClientUtil.getCompanyId());
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setTextBoxStyle("customInputTextStyle");
		companyIdItem.setDisabled(true);
		__formItems.add(companyIdItem);
		
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setWidth("*");
		employeeNoItem.setDefaultValue(ClientUtil.getUserNo());
		employeeNoItem.setTextBoxStyle("customInputTextStyle");
		employeeNoItem.setDisabled(true);
		__formItems.add(employeeNoItem);

		departmentIdItem = new TextItem("departmentId", "所在部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setDefaultValue(ClientUtil.getDepartmentId());
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
		drafterItem.setDefaultValue(ClientUtil.getUserId());
		drafterItem.hide();
		__formItems.add(drafterItem);
		
		reasonItem = new TextItem("reason", shouldNotBeNull + "用车目的");
		reasonItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(reasonItem);
		
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
	public void startEdit() {
		Record record = getRecord();
		if(record != null){
			__form.editRecord(record);
		}else{
			__form.editNewRecord();
			Map<String, Object> params = new HashMap<>();
			params.put("optType", "getBasicInfo");
			params.put("employeeId", ClientUtil.getUserId());
			DBDataSource.callOperation("EP_GetUserInfoById", params, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0){
						Record record = dsResponse.getData()[0];
						if(null != record){
							if(null != record.getAttribute("mobile")){
								cardItem.setValue(record.getAttribute("mobile"));
							}
						}
					}else{
						ClientUtil.displayErrorMessage(dsResponse);
					}
				}
			});
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSCarsApply.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

}
