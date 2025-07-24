package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSNetworkPrivileges;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.VLayout;

public class NetworkPrivilegesUpdateForm extends AbstractWizadPage
{

	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final TextItem companyIdItem;
	private final SelectItem subTypeItem;
	private final TextItem drafterItem;
	private final TextAreaItem reasonItem;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private final VLayout mainLayout;

	public NetworkPrivilegesUpdateForm() {

		mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.setBackgroundColor("#fff");
		mainLayout.setLayoutLeftMargin(30);
		mainLayout.setLayoutRightMargin(30);
		mainLayout.setLayoutTopMargin(15);
		
		DSNetworkPrivileges ds = DSNetworkPrivileges.getInstance();
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
		
		subTypeItem = new SelectItem("subType", shouldNotBeNull + "权限类型");
		subTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_123"));
		subTypeItem.setMultiple(true);
		__formItems.add(subTypeItem);
		
		drafterItem = new TextItem("drafter", "起草人");
		drafterItem.setDefaultValue(ClientUtil.getUserId());
		drafterItem.hide();
		__formItems.add(drafterItem);
		
		reasonItem = new TextAreaItem("reason", shouldNotBeNull + "申请缘由");
		reasonItem.setWidth("*");
		reasonItem.setColSpan(2);
		reasonItem.setRowSpan(3);
		reasonItem.setTextBoxStyle("customTextAreaStyle");
		__formItems.add(reasonItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		subTypeItem.setColSpan(4);
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
			String str = record.getAttribute("subType");
			if(!ClientUtil.isNullOrEmpty(str)){
				subTypeItem.setValues(str.split(","));
			}
		}else{
			__form.editNewRecord();
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSNetworkPrivileges.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(null == employeeIdItem.getValue()){
			SC.say("请重新登录之后再申请本流程");
			return false;
		}
		if(null == subTypeItem.getValue()){
			SC.say("请选择您需要申请的网络权限类型");
			return false;
		}
		if(null == reasonItem.getValue()){
			SC.say("请填写申请缘由");
			return false;
		}
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map map = __form.getValues();
		String[] arr = subTypeItem.getValues();
		if(null != arr && arr.length > 0){
			StringBuilder sb = new StringBuilder();
			for(String str : arr){
				if(sb.length() > 0){
					sb.append(",");
				}
				sb.append(str);
			}
			map.put("subType", sb.toString());
			map.put("subTypeStr", subTypeItem.getDisplayValue());
		}
		return map;
	}

}
