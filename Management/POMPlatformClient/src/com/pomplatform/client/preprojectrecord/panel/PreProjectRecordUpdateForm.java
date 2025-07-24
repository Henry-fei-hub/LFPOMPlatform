package com.pomplatform.client.preprojectrecord.panel;

import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.preprojectreimbursementnumber.datasource.DSPreProjectReimbursementNumbers;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class PreProjectRecordUpdateForm  extends AbstractWizadPage{
	private static final Logger __logger = Logger.getLogger("");
	private final SelectItem relevantEmployeesItem;
	private final DateItem trackDateItem;
	private final SelectItem informationTypeItem;
	private final TextAreaItem  remarkItem;
	private final TextItem attachmentNameItem;
	private final TextItem attachmentIdItem;
	private final TextItem fileNameItem;
	private final ButtonItem uploadItem;
	private final TextItem registerEmployeeItem;
	private final DateItem registerDateItem;
	private final TextItem mainProjectIdItem;
	
	public  PreProjectRecordUpdateForm() {
		DSPreProjectReimbursementNumbers ds = DSPreProjectReimbursementNumbers.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		ListGridField eNoField = new ListGridField("employeeNo");
		ListGridField eNameField = new ListGridField("employeeName");
		TextItem textItem = new TextItem("");
		eNameField.setFilterEditorProperties(textItem);
		ListGridField departmentIdField = new ListGridField("departmentId");
		eNameField.setCanFilter(true);
		
		Criteria c = new Criteria();
		c.addCriteria("status", 0);
		relevantEmployeesItem = new SelectItem("relevantEmployees", "相关人员");
		relevantEmployeesItem.setWidth("*");
		relevantEmployeesItem.setMultiple(true);
		relevantEmployeesItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
		relevantEmployeesItem.setDefaultToFirstOption(true);
		relevantEmployeesItem.setOptionCriteria(c);
		relevantEmployeesItem.setValueField("employeeId");
		relevantEmployeesItem.setDisplayField("employeeName");
		relevantEmployeesItem.setUseClientFiltering(true);
		relevantEmployeesItem.setPickListFields(eNoField, eNameField, departmentIdField);

	//	relevantEmployeesItem.setControlStyle("customInputTextStyle");
		relevantEmployeesItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		__formItems.add(relevantEmployeesItem);
		
//		relevantEmployeesItem = new SelectItem("relevantEmployees", "相关人员");
//		relevantEmployeesItem.setWidth("*");
//		relevantEmployeesItem.setMultiple(true);
//		relevantEmployeesItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//		relevantEmployeesItem.setValueMap(KeyValueManager.getValueMap("employees"));
//		__formItems.add(relevantEmployeesItem);
		
		trackDateItem =new DateItem("trackDate","跟踪时间");
		trackDateItem.setWidth("*");
		trackDateItem.setUseTextField(true);
		trackDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		__formItems.add(trackDateItem);
		
		informationTypeItem= new SelectItem("informationType","信息类型");
		informationTypeItem.setWidth("*");
		informationTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_153"));
		__formItems.add(informationTypeItem);
		
		remarkItem = new TextAreaItem("remark","情况描述");
		remarkItem.setWidth("*");
		remarkItem.setColSpan(4);
		__formItems.add(remarkItem);
		
		attachmentNameItem = new  TextItem("attachmentName","附件路径");
		attachmentNameItem.setWidth("*");
		attachmentNameItem.setHidden(true);
		__formItems.add(attachmentNameItem);
		
		attachmentIdItem = new  TextItem("attachmentId","附件ID");
		attachmentIdItem.setWidth("*");
		attachmentIdItem.setHidden(true);
		__formItems.add(attachmentIdItem);
		
		fileNameItem = new  TextItem("fileName","附件");
		fileNameItem.setWidth("*");
		fileNameItem.setDisabled(true);
		fileNameItem.setCanEdit(false);
		__formItems.add(fileNameItem);
		
		uploadItem = new ButtonItem("上传附件");
		uploadItem.setStartRow(false);
		uploadItem.setVAlign(VerticalAlignment.BOTTOM);
		uploadItem.setColSpan(1);
		__formItems.add(uploadItem);
		uploadItem.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				new CommonUploadWindow("上传附件", false, 100, null, 1, new UploadCallBack() {
					
					@Override
					public void execute(Map<String, Record> data) {
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							String fileName = data.get(key).getAttribute("fileName");
							attachmentNameItem.setValue(data.get(key).getAttribute("fileUrl"));
							attachmentIdItem.setValue(fileId);
							fileNameItem.setValue(fileName);
						}
					}
				});
			}
		
		});
		
		registerEmployeeItem = new TextItem("registerEmployee","登记人");
		registerEmployeeItem.setWidth("*");
		registerEmployeeItem.setCanEdit(false);
		registerEmployeeItem.setDisabled(true);
		registerEmployeeItem.setDefaultValue(ClientUtil.getEmployeeId());
		registerEmployeeItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(registerEmployeeItem);
		
		registerDateItem = new DateItem("registerDate","登记日期");
		registerDateItem.setWidth("*");
		registerDateItem.setDefaultValue(new Date());
		registerDateItem.setDisabled(true);
		registerDateItem.setUseTextField(true);
		registerDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH_DAY);
		registerDateItem.setCanEdit(false);
		__formItems.add(registerDateItem);

		mainProjectIdItem = new TextItem("preProjectId","前期项目ID");
		mainProjectIdItem.setWidth("*");
		mainProjectIdItem.setHidden(true);
		__formItems.add(mainProjectIdItem);
		
		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
		relevantEmployeesItem.setColSpan(4);
	}
	@Override
	public Map getValuesAsMap() {
		Map params = __form.getValues();
		String employeeIds = "";
		ListGridRecord[] reRecords = relevantEmployeesItem.getSelectedRecords();
		for (int i = 0; i < reRecords.length; i++) {
			if(i != 0){
				employeeIds += ",";
			}
			employeeIds += reRecords[i].getAttribute("employeeId");
		}
		params.put("relevantEmployees", employeeIds);
		params.put("relevantEmployeesDisplayValue", relevantEmployeesItem.getDisplayValue());
		return params;
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) {
			Record record = getRecord();
			String idStr = record.getAttribute("relevantEmployees");
			if(!BaseHelpUtils.isNullOrEmpty(idStr)){
				String [] strArra = idStr.split(",");
				record.setAttribute("relevantEmployees", strArra);
			}
			__form.editRecord(record);
		}else{
			__form.editNewRecord();
		}
		
	}

}
