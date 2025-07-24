package com.pomplatform.client.hr.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.pomplatform.client.hr.datasource.DSEmployeeContractAttachment;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;

public class EmployeeContractAttachmentNewForm extends AbstractWizadPage
{

	private final Logger __logger = Logger.getLogger("");
	private final ComboBoxItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final SelectItem plateIdItem;
	private final IPickTreeItem departmentIdItem;
	private final DateItem onboardDateItem;
	private final SelectItem statusItem;
	private final TextItem attachmentUrlItem;
	private final SelectItem contractTypeItem;
	private final SelectItem signTypeItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final ButtonItem uploadItem;
	private final TextItem attachmentNameItem;
	private final TextItem attachmentIdItem;
	
	public EmployeeContractAttachmentNewForm() {
		DSEmployeeContractAttachment ds = DSEmployeeContractAttachment.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		employeeIdItem = new ComboBoxItem("employeeId", "职员姓名");
		employeeIdItem.setWidth("*");
//		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",employeeIdItem);
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setRequired(true);
		__formItems.add(employeeIdItem);
		
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setCanEdit(false);
		employeeNoItem.setWidth("*");
		__formItems.add(employeeNoItem);
		
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		plateIdItem.setWidth("*");
		plateIdItem.setCanEdit(false);
		__formItems.add(plateIdItem);

		departmentIdItem = new IPickTreeItem("departmentId", "所属部门");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setCanEdit(false);
		__formItems.add(departmentIdItem);
		
		onboardDateItem = new DateItem("onboardDate", "入职日期");
		onboardDateItem.setWidth("*");
		onboardDateItem.setUseTextField(true);
		onboardDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		onboardDateItem.setCanEdit(false);
		__formItems.add(onboardDateItem);
		
		statusItem = new SelectItem("status", "职员状态");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));
		statusItem.setCanEdit(false);
		statusItem.setWidth("*");
		__formItems.add(statusItem);
		
		employeeIdItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				Map<String,Object> param = new HashMap<>();
				param.put("employeeId", employeeIdItem.getValue());
				if(!BaseHelpUtils.isNullOrEmpty(employeeIdItem.getValue()) && !BaseHelpUtils.isNullOrEmpty(contractTypeItem.getValue()) &&
						!BaseHelpUtils.isNullOrEmpty(signTypeItem.getValue())){
					checkAttachmentExist();
				}
				DBDataSource.callOperation("ST_Employee", "find" ,param, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							Record record = dsResponse.getData()[0];
							employeeNoItem.setValue(record.getAttribute("employeeNo"));
							plateIdItem.setValue(record.getAttribute("plateId"));
							departmentIdItem.setValue(record.getAttribute("departmentId"));
							DateTimeFormat df = DateTimeFormat.getFormat("yyyy-MM-dd");
							Date onboardDate = record.getAttributeAsDate("onboardDate");
							onboardDateItem.setValue(df.format(onboardDate));
							statusItem.setValue(record.getAttribute("status"));
						}
					}
				});
			}
		});
		
		contractTypeItem = new SelectItem("contractType", "合同类型");
		contractTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_111"));
		contractTypeItem.setWidth("*");
		contractTypeItem.setRequired(true);
		__formItems.add(contractTypeItem);
		contractTypeItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(!BaseHelpUtils.isNullOrEmpty(employeeIdItem.getValue()) && !BaseHelpUtils.isNullOrEmpty(contractTypeItem.getValue()) &&
						!BaseHelpUtils.isNullOrEmpty(signTypeItem.getValue())){
					checkAttachmentExist();
				}				
			}
		});
		
		signTypeItem = new SelectItem("signType", "签订类型");
		signTypeItem.setWidth("*");
		signTypeItem.setRequired(true);
		signTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_112"));
		__formItems.add(signTypeItem);
		signTypeItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(!BaseHelpUtils.isNullOrEmpty(employeeIdItem.getValue()) && !BaseHelpUtils.isNullOrEmpty(contractTypeItem.getValue()) &&
						!BaseHelpUtils.isNullOrEmpty(signTypeItem.getValue())){
					checkAttachmentExist();
				}				
			}
		});
		
		startDateItem = new DateItem("startDate", "开始日期");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);
		startDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		__formItems.add(startDateItem);
		
		endDateItem = new DateItem("endDate", "结束日期");
		endDateItem.setWidth("*");
		endDateItem.setUseTextField(true);
		endDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		__formItems.add(endDateItem);
		
		attachmentUrlItem = new TextItem("attachmentUrl", "合同附件");
		attachmentUrlItem.setWidth("*");
		attachmentUrlItem.setHidden(true);
		attachmentUrlItem.setCanEdit(false);
		__formItems.add(attachmentUrlItem);

		attachmentNameItem = new TextItem("attachmentName","附件名称");
		attachmentNameItem.setWidth("*");
		attachmentNameItem.setCanEdit(false);
		__formItems.add(attachmentNameItem);
		
		attachmentIdItem = new TextItem("attachmentId","附件ID");
		attachmentIdItem.setWidth("*");
		attachmentIdItem.setHidden(true);
		__formItems.add(attachmentIdItem);

		uploadItem = new ButtonItem("上传附件");
		uploadItem.setStartRow(false);
		uploadItem.setVAlign(VerticalAlignment.BOTTOM);
		__formItems.add(uploadItem);
		uploadItem.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				new CommonUploadWindow("上传附件", false, 100, 2, 1, new UploadCallBack() {
					
					@Override
					public void execute(Map<String, Record> data) {
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							String fileName = data.get(key).getAttribute("fileName");
							attachmentUrlItem.setValue(data.get(key).getAttribute("fileUrl"));
							attachmentIdItem.setValue(fileId);
							attachmentNameItem.setValue(fileName);
						}
					}
				});
			}
		});
		
		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(!__form.validate()){
			SC.say("请按系统提示修改信息");
			return false;
		}
		if(!BaseHelpUtils.isNullOrEmpty(startDateItem.getValue()) && !BaseHelpUtils.isNullOrEmpty(endDateItem.getValue())){
			if(startDateItem.getValueAsDate().after(endDateItem.getValueAsDate())){
				SC.say("结束日期不能小于开始日期");
				return false;
			}
		}
		if(!isExist){
			SC.say("该合同记录已存在");
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
		manager.setDataSource(DSEmployeeContractAttachment.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map<String,Object> values = __form.getValues();
		values.put("operateEmployeeId", ClientUtil.getEmployeeId());
		return values;
	}

	private boolean isExist;
	public void checkAttachmentExist(){//看该员工是否存在这个合同类型与签订类型的记录
		Map<String,Object> param = new HashMap<>();
		param.put("employeeId", employeeIdItem.getValue());
		param.put("contractType", contractTypeItem.getValue());
		param.put("signType", signTypeItem.getValue());
		DBDataSource.callOperation("ST_EmployeeContractAttachment","find", param, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(!BaseHelpUtils.isNullOrEmpty(dsResponse.getData()[0])){
					isExist = false;
				}else{
					isExist = true;
				}
			}
		});
	}

}
