package com.pomplatform.client.sealkeepers.form;

import java.util.*;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.sealkeepers.datasource.CDsealKeepersWorkflow;

public class sealKeepersWorkflowSearchForm extends SearchForm
{


	private final SelectItem companyIdItem;
	private final ComboBoxItem sealNameItem;
	private final ComboBoxItem employeeIdItem;

	public sealKeepersWorkflowSearchForm() {
		setWidth100();
		setHeight100();
//		setDataSource(CDsealKeepersWorkflow.getInstance());

		companyIdItem = new SelectItem("companyId", "归属公司");
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

		sealNameItem = new ComboBoxItem("sealName", "印章名称");
		sealNameItem.setWidth("*");
		employeeIdItem = new ComboBoxItem("employeeId", "保管员");
		employeeIdItem.setWidth("*");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		setItems(companyIdItem, sealNameItem, employeeIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
