package com.pomplatform.client.cwd.personalregister.form;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.cwd.personalregister.datasource.DSPersonalRegisterAddressManage;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class PersonalRegisterAddressManageNewForm extends AbstractWizadPage
{


	private final ComboBoxItem employeeIdItem;
	private final TextItem ipAddressItem;
	private final TextItem macAddressItem;
	private final ComboBoxItem workplaceIdItem;
	private final TextItem workplaceNameItem;
	private final DateTimeItem registerTimeItem;
	private final CheckboxItem activeItem;
	private LinkedHashMap<String, String> workplaceMap = new LinkedHashMap<>();

	public PersonalRegisterAddressManageNewForm() {
		DSPersonalRegisterAddressManage ds = DSPersonalRegisterAddressManage.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		employeeIdItem = new ComboBoxItem("employeeId", "员工");
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setWidth("*");
		__formItems.add(employeeIdItem);
		
		workplaceIdItem = new ComboBoxItem("workplaceId", "工作场所");
		workplaceIdItem.setWidth("*");
		workplaceIdItem.setChangeOnKeypress(false);
		workplaceIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		workplaceIdItem.setValueMap(workplaceMap);
		Map<String, Object> params = new HashMap<>();
		params.put("addtionalCondition", "company_id in (0," + ClientUtil.getCompanyNo() + ")");
		params.put("active", true);
		DBDataSource.callOperation("ST_CompanyWorkplace", "find", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					for(Record record : records) {
						workplaceMap.put(record.getAttribute("companyWorkplaceId"), record.getAttribute("workplaceName"));
						workplaceIdItem.setValueMap(workplaceMap);
					}
				}
			}
		});
		__formItems.add(workplaceIdItem);
		
		ipAddressItem = new TextItem("ipAddress", "公网IP地址");
		ipAddressItem.setWidth("*");
		__formItems.add(ipAddressItem);
		
		macAddressItem = new TextItem("macAddress", "机器MAC地址");
		macAddressItem.setWidth("*");
		__formItems.add(macAddressItem);
		
		workplaceNameItem = new TextItem("workplaceName", "工作场所名称");
		workplaceNameItem.setWidth("*");
		workplaceNameItem.hide();
		__formItems.add(workplaceNameItem);
		
		registerTimeItem = new DateTimeItem("registerTime", "注册时间");
		registerTimeItem.setWidth("*");
		__formItems.add(registerTimeItem);
		
		activeItem = new CheckboxItem("active", "是否有效");
		activeItem.setDefaultValue(true);
		__formItems.add(activeItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}
	
	@Override
	public boolean checkData() {
		if(null != employeeIdItem.getValue() && ClientUtil.isNullOrEmpty(KeyValueManager.getValue("employees", employeeIdItem.getValue().toString()))) {
			SC.say("请选择员工");
			return false;
		}
		if(null != workplaceIdItem.getValue() && ClientUtil.isNullOrEmpty(workplaceMap.get(workplaceIdItem.getValue().toString()))) {
			SC.say("请选择工作场所");
			return false;
		}
		if(null == ipAddressItem.getValue()) {
			SC.say("请填写IP地址");
			return false;
		}
		if(null == macAddressItem.getValue()) {
			SC.say("请填写MAC地址");
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
		manager.setDataSource(DSPersonalRegisterAddressManage.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map map = __form.getValues();
		if(null != workplaceIdItem.getValue())
			map.put("workplaceName", workplaceMap.get(workplaceIdItem.getValue().toString()));
		return map;
	}


}
