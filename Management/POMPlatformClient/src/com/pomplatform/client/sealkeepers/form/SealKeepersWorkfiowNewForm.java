package com.pomplatform.client.sealkeepers.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.panel.CommonUploadWindow;
import com.delicacy.client.panel.UploadCallBack;
import com.delicacy.client.ui.AbstractWizadPage;
import com.google.gwt.user.client.Window;
import com.pomplatform.client.sealkeepers.datasource.DSsealKeepersWorkflow;
import com.pomplatform.client.workflow.datasource.DSSealApplication;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;

import java.util.*;

public class SealKeepersWorkfiowNewForm extends AbstractWizadPage
{

	private final TextItem employeeIdItem;

	private final ComboBoxItem sealNameItem;
	private final SelectItem companyIdItem;
	private final TextItem operatorIdItem;
	private final TextItem remarksItem;
	private final TextItem numberItem;
	private final TextItem sealTypeItem;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";

	public SealKeepersWorkfiowNewForm() {
		DSsealKeepersWorkflow ds = DSsealKeepersWorkflow.getInstance();
		__form.setWidth100();
		__form.setHeight100();



		companyIdItem = new SelectItem("companyId", shouldNotBeNull+"归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_307"));
		companyIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Map<String,Object> provinceMap = new HashMap<>();
				provinceMap.put("optType", "getSealNames");
				provinceMap.put("companyId", companyIdItem.getValue());
				DBDataSource.callOperation("EP_FileDetailsProcess", provinceMap, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							Record[] cityRecords = dsResponse.getData();
							LinkedHashMap<String, String> cityMap = new LinkedHashMap<>();
							for(Record e : cityRecords){
								cityMap.put(e.getAttribute("dicTypeValue"), e.getAttribute("dicTypeValue"));
							}
							sealNameItem.setValue("");
							sealNameItem.setValueMap(cityMap);
						}
					}

				});
			}
		});
		__formItems.add(companyIdItem);

		sealNameItem = new ComboBoxItem("sealName", shouldNotBeNull+"印章名称");
		sealNameItem.setWidth("*");
		__formItems.add(sealNameItem);

		employeeIdItem = new ComboBoxItem("employeeId", shouldNotBeNull+"保管员");
		employeeIdItem.setWidth("*");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Map<String,Object> provinceMap = new HashMap<>();
				int employeeId = BaseHelpUtils.getIntValue(employeeIdItem.getValue());
				if(employeeId ==0){
					return;
				}
				provinceMap.put("employeeId", employeeId);
				DBDataSource.callOperation("ST_Employee","find", provinceMap, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							SC.debugger();
							Record record = dsResponse.getData()[0];
							int departmentId =BaseHelpUtils.getIntValue(record.getAttribute("departmentId"));
							sealTypeItem.setValue(departmentId);
						}
					}

				});
			}
		});
		__formItems.add(employeeIdItem);

		sealTypeItem = new TextItem("sealType", "保管部门");
		sealTypeItem.setWidth("*");
		sealTypeItem.setTextBoxStyle("customInputTextStyle");
		sealTypeItem.setDisabled(true);
		sealTypeItem.hide();
		__formItems.add(sealTypeItem);

		operatorIdItem = new TextItem("operatorId", "申请人");
		operatorIdItem.setWidth("*");
		operatorIdItem.setDefaultValue(ClientUtil.getEmployeeId());
		operatorIdItem.setTextBoxStyle("customInputTextStyle");
		operatorIdItem.setDisabled(true);
		operatorIdItem.hide();
		__formItems.add(operatorIdItem);

		numberItem = new TextItem("number", "数量");
		numberItem.setWidth("*");
		__formItems.add(numberItem);


		remarksItem = new TextItem("remarks", "备注");
		remarksItem.setWidth("*");
		__formItems.add(remarksItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(null == companyIdItem.getValue()){
			SC.say("请选择归属公司");
			return false;
		}
		int companyId = BaseHelpUtils.getIntValue(companyIdItem.getValue());
		SC.debugger();
		if(companyId!=9 && companyId!=10){
			if(null==sealNameItem.getValue()){
				SC.say("印章名称");
				return false;
			}
		}
		if(null == employeeIdItem.getValue()){
			SC.say("请选择保管员");
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
		manager.setDataSource(DSsealKeepersWorkflow.getInstance());
		manager.addMember(__form);
	}

	@Override
	public Map getValuesAsMap() {
		return __form.getValues();
	}


}
