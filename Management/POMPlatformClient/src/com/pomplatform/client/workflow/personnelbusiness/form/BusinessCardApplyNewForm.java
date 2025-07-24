package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSBusinessCardApply;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.VLayout;

public class BusinessCardApplyNewForm extends AbstractWizadPage
{

	private static final Logger logger  = Logger.getLogger("");
	private final ComboBoxItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final TextItem companyIdItem;
	private final TextItem projectNameItem;
	private final TextItem projectCodeItem;
	private final TextItem reasonItem;
	private final TextItem drafterItem;
	private final TextAreaItem remarkItem;
	private final TextItem planItem;
	private final TextItem unitItem;
	private final TextItem cardItem;
	private final TextItem addressItem;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	
	private final VLayout mainLayout;

	public BusinessCardApplyNewForm() {
		mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.setBackgroundColor("#fff");
		mainLayout.setLayoutLeftMargin(30);
		mainLayout.setLayoutRightMargin(30);
		mainLayout.setLayoutTopMargin(15);
		
		DSBusinessCardApply ds = DSBusinessCardApply.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		employeeIdItem = new ComboBoxItem("employeeId", "申请人");
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		KeyValueManager.loadValueMap("employee_list", employeeIdItem);
		employeeIdItem.setWidth("*");
		employeeIdItem.setDefaultValue(ClientUtil.getUserId());
		employeeIdItem.setControlStyle("customInputTextStyle");
		employeeIdItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null == event.getValue()) {
					companyIdItem.clearValue();
					employeeNoItem.clearValue();
					departmentIdItem.clearValue();
					cardItem.clearValue();
					planItem.clearValue();
					unitItem.clearValue();
					addressItem.clearValue();
				}else {
					int value = BaseHelpUtils.getIntValue(event.getValue());
					loadUserInfo(value);
				}
			}
		});
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
		
		unitItem = new TextItem("unit", shouldNotBeNull + "英文名");
		unitItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(unitItem);
		
		planItem = new TextItem("plan", shouldNotBeNull + "职位");
		planItem.setTextBoxStyle("customInputTextStyle");
		planItem.setValueMap(KeyValueManager.getValueMap("duties"));
		__formItems.add(planItem);
		
		cardItem = new TextItem("card", shouldNotBeNull + "手机号码");
		cardItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(cardItem);
		
		projectCodeItem = new TextItem("projectCode", shouldNotBeNull + "座机号码");
		projectCodeItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(projectCodeItem);
		
		projectNameItem = new TextItem("projectName",  "传真机号码");
		projectNameItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(projectNameItem);
		
		addressItem = new TextItem("address", shouldNotBeNull + "邮箱");
		addressItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(addressItem);
		
		drafterItem = new TextItem("drafter", "起草人");
		drafterItem.setDefaultValue(ClientUtil.getUserId());
		drafterItem.hide();
		__formItems.add(drafterItem);
		
		reasonItem = new TextItem("reason", shouldNotBeNull + "申请原因");
		reasonItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(reasonItem);
		
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
		if(null == unitItem.getValue()){
			SC.say("请填写英文名称");
			return false;
		}
		if(null == planItem.getValue()){
			SC.say("请填写职位");
			return false;
		}
		if(null == cardItem.getValue()){
			SC.say("请填写手机号码");
			return false;
		}
		if(null == projectCodeItem.getValue()){
			SC.say("请填写座机号码");
			return false;
		}
		if(null == addressItem.getValue()){
			SC.say("请填写邮箱");
			return false;
		}
		if(null == reasonItem.getValue()){
			SC.say("请填写申请原因");
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
			loadUserInfo(BaseHelpUtils.getIntValue(ClientUtil.getUserId()));
		}
	}

	public void loadUserInfo(int userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("optType", "getBasicInfo");
		params.put("employeeId", userId);
		DBDataSource.callOperation("EP_GetUserInfoById", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record record = dsResponse.getData()[0];
					if(null != record){
						if(null != record.getAttribute("companyId")) {
							companyIdItem.setValue(record.getAttribute("companyId"));
						}
						if(null != record.getAttribute("employeeNo")) {
							employeeNoItem.setValue(record.getAttribute("employeeNo"));
						}
						if(null != record.getAttribute("departmentId")) {
							departmentIdItem.setValue(record.getAttribute("departmentId"));
						}
						if(null != record.getAttribute("mobile")){
							cardItem.setValue(record.getAttribute("mobile"));
						}
						if(null != record.getAttribute("dutyId")){
							planItem.setValue(record.getAttribute("dutyId"));
						}
						if(null != record.getAttribute("employeeNameEn")){
							unitItem.setValue(record.getAttribute("employeeNameEn"));
						}
						if(null != record.getAttribute("companyEmail")){
							addressItem.setValue(record.getAttribute("companyEmail"));
						}
					}
				}else{
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
	}
	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSBusinessCardApply.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

}
