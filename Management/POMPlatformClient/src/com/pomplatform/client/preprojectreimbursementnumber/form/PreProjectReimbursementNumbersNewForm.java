package com.pomplatform.client.preprojectreimbursementnumber.form;

import java.util.*;
import java.util.logging.Logger;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.preprojectreimbursementnumber.datasource.DSPreProjectReimbursementNumbers;

public class PreProjectReimbursementNumbersNewForm extends AbstractWizadPage
{

	private static Logger __LOGGER = Logger.getLogger("");
	private final TextItem customNumberItem;
	private final ComboBoxItem mainProjectIdItem;
	private final ComboBoxItem projectManagerItem;
	private final ComboBoxItem operatorItem;
	private final DateTimeItem createTimeItem;
	private final TextItem remarkItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final SelectItem businessTypeItem;
	private final SelectItem projectTypeItem;
	private final SelectItem deptItem;
	

	public PreProjectReimbursementNumbersNewForm() {
		DSPreProjectReimbursementNumbers ds = DSPreProjectReimbursementNumbers.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		customNumberItem = new TextItem("customNumber", "前期项目信息编号");
		customNumberItem.setHidden(true);
		__formItems.add(customNumberItem);
		mainProjectIdItem = new ComboBoxItem("mainProjectId", "前期项目");
		mainProjectIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		mainProjectIdItem.setWidth("*");
		LinkedHashMap<Integer, String> mainProjectIdLinkHashMap=new LinkedHashMap<>();
		Map preparams = new HashMap<>();
		DBDataSource.callOperation("EP_CustomPreInfoCodeProjectName", preparams, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() < 0) {
					ClientUtil.displayErrorMessage(dsResponse);
				} else {
					Record record[]=dsResponse.getData();
					for(Record obj:record){
						mainProjectIdLinkHashMap.put(obj.getAttributeAsInt("mainProjectId"), obj.getAttributeAsString("projectName"));
					}
					mainProjectIdItem.setValueMap(mainProjectIdLinkHashMap);
				}
			}
		});
		
		__formItems.add(mainProjectIdItem);
		projectManagerItem = new ComboBoxItem("projectManager", "项目经理");
		projectManagerItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectManagerItem.setWidth("*");
		LinkedHashMap<Integer, String> projectManagerLinkHashMap=new LinkedHashMap<>();
		Map params = new HashMap<>();
		params.put("roleId", 4);
		params.put("status", 0);
		DBDataSource.callOperation("EP_CustomProjectManager", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() < 0) {
					ClientUtil.displayErrorMessage(dsResponse);
				} else {
					Record record[]=dsResponse.getData();
					for(Record obj:record){
						if(!Objects.equals(270, obj.getAttributeAsInt("employeeId"))){
							projectManagerLinkHashMap.put(obj.getAttributeAsInt("employeeId"), obj.getAttributeAsString("employeeName"));
						}
					}
					projectManagerItem.setValueMap(projectManagerLinkHashMap);
				}
			}
		});
		__formItems.add(projectManagerItem);
		operatorItem = new ComboBoxItem("operator", "操作人");
		operatorItem.setValueMap(KeyValueManager.getValueMap("employees"));
		operatorItem.setValue(ClientUtil.getEmployeeId());
		operatorItem.setChangeOnKeypress(false);
		operatorItem.setHidden(true);
		__formItems.add(operatorItem);
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		createTimeItem.setHidden(true);
		__formItems.add(createTimeItem);
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setHidden(true);
		__formItems.add(projectCodeItem);
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setHidden(true);
		__formItems.add(projectNameItem);
		businessTypeItem = new SelectItem("businessType", "业务类别");
		businessTypeItem.setWidth("*");
		businessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		__formItems.add(businessTypeItem);
		projectTypeItem = new SelectItem("projectType", "项目类别");
		projectTypeItem.setWidth("*");
//		projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		LinkedHashMap<Integer, String> projectTypeLinkHashMap=new LinkedHashMap<>();
		projectTypeLinkHashMap.put(33, "立项前");
		projectTypeLinkHashMap.put(66, "立项后");
		projectTypeItem.setValueMap(projectTypeLinkHashMap);
		projectTypeItem.setValue(33);
		__formItems.add(projectTypeItem);
		
		deptItem= new SelectItem("dept", "部门");
		deptItem.setWidth("*");
		deptItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_34"));
		__formItems.add(deptItem);
		
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);
		
		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSPreProjectReimbursementNumbers.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
