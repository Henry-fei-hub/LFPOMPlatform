package com.pomplatform.client.cwd.form;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.cwd.datasource.DSSoftwareUpdateVersionWithS;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.validator.IsFloatValidator;

public class SoftwareUpdateVersionWithSNewForm extends AbstractWizadPage {

	private final TextItem versionNoItem;
	private final TextItem titleItem;
	private final TextAreaItem remarkItem;
	private final SelectItem softwareTypeItem;
	private final SelectItem employeeIdItem;
	private final TextAreaItem sqlScriptItem;
	private final CheckboxItem isRebootItem;

	public SoftwareUpdateVersionWithSNewForm() {
		DSSoftwareUpdateVersionWithS ds = DSSoftwareUpdateVersionWithS.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		versionNoItem = new TextItem("versionNo", "版本号");
		versionNoItem.setDisabled(true);
		versionNoItem.setRequired(true);
		versionNoItem.setWidth("*");
		IsFloatValidator versionNoValidator = new IsFloatValidator();
		versionNoItem.setValidators(versionNoValidator);
		__formItems.add(versionNoItem);
		
		titleItem = new TextItem("title", "更新主题");
		titleItem.setRequired(true);
		titleItem.setWidth("*");
		__formItems.add(titleItem);
		
		softwareTypeItem = new SelectItem("softwareType", "软件类型");
		softwareTypeItem.setRequired(true);
		softwareTypeItem.setWidth("*");
		softwareTypeItem.setDefaultValue(1);
		softwareTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_201"));
		softwareTypeItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()) {
					setVersionNo(BaseHelpUtils.getIntValue(event.getValue()));
				}
				
			}
		});
		__formItems.add(softwareTypeItem);
		
		employeeIdItem = new SelectItem("employeeId", "操作人");
		employeeIdItem.setWidth("*");
		employeeIdItem.setDefaultValue(ClientUtil.getEmployeeId());
		employeeIdItem.setDisabled(true);
		KeyValueManager.loadValueMap("employees", employeeIdItem);
		__formItems.add(employeeIdItem);
		
		isRebootItem = new CheckboxItem("isReboot", "是否需要重启服务");
		isRebootItem.setRequired(true);
		isRebootItem.setDefaultValue(true);
		isRebootItem.setWidth("*");
		__formItems.add(isRebootItem);
		
		sqlScriptItem = new TextAreaItem("sqlScript", "sql脚本");
		sqlScriptItem.setWidth("*");
		sqlScriptItem.setColSpan(4);
		sqlScriptItem.setRowSpan(3);
		__formItems.add(sqlScriptItem);
		
		remarkItem = new TextAreaItem("remark", "更新详情描述,说明更新了什么内容");
		remarkItem.setWidth("*");
		remarkItem.setColSpan(4);
		remarkItem.setRowSpan(3);
		remarkItem.setRequired(true);
		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return __form.validate();
	}

	@Override
	public void startEdit() {
		if (getRecord() != null) {
			__form.editRecord(getRecord());
		}else {
			__form.editNewRecord();
			setVersionNo(1);
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSoftwareUpdateVersionWithS.getInstance());
		manager.addMember(__form);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

	private void setVersionNo(int softwareType) {
		Map<String, Object> params = new HashMap<>();
		params.put("optType", "getNewVersionNo");
		params.put("softwareType", softwareType);
		DBDataSource.callOperation("EP_LocalSystemUpdateProcessor", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					Record [] records = dsResponse.getData();
					if(records.length > 0) {
						versionNoItem.setValue(records[0].getAttribute("versionNo"));;
					}
				}
			}
		});
	}
}
