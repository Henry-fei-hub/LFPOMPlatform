package com.pomplatform.client.receivables.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.*;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridReceiveUnitValue;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.pomplatform.client.workflow.panel.AddReceiveUnitPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class McapitalecoosmeorGroupname2New extends AbstractWizadPage {

	private final SelectItem selfNameItem;
	private final SelectItem selfBankNameItem;
	private final SelectItem selfBankAccountItem;
	private final ComboBoxItem otherNameItem;
	private final TextItem otherBankNameItem;
	private final TextItem otherBankAccountItem;
	private final ComboBoxItem receiveUnitIdItem;
	public static TextItem capitalAtttachmentItem;
	public static IButton uploadButton;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	private String type;
	private static Logger __LOGGER = Logger.getLogger("");

	public McapitalecoosmeorGroupname2New() {
		ListGridField receiveUnitField = new ListGridField("receiveUnit", 315);
		ListGridField bankAccountField = new ListGridField("bankAccount");
		ListGridField bankNameField = new ListGridField("bankName");
		
		__form.setWidth100();
		__form.setHeight100();
		selfNameItem = new SelectItem("selfName", "内部公司(收款方)");
		selfNameItem.setWidth("*");
		selfNameItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		selfNameItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				selfBankNameItem.clearValue();
				selfBankAccountItem.clearValue();
				setSelectBankAddressByCompanyId(BaseHelpUtils.getIntValue(event.getValue()));
				
			}
		});
		__formItems.add(selfNameItem);
		
		otherNameItem = new ComboBoxItem("otherName", "对方名称(付款方)");
		otherNameItem.setWidth("*");
		otherNameItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		otherNameItem.setChangeOnKeypress(false);
//		otherNameItem.setValueMap(KeyValueManager.getValueMap("receive_unit_manages"));
		otherNameItem.setValueField("receiveUnitManageId");
		otherNameItem.setDisplayField("receiveUnit");
		otherNameItem.setPickListFields(receiveUnitField, bankNameField, bankAccountField);
		otherNameItem.setOptionDataSource(DSSelectGridReceiveUnitValue.getInstance());
		otherNameItem.setPickListWidth(800);
		otherNameItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				otherBankNameItem.clearValue();
				otherBankAccountItem.clearValue();
				if(null != event.getValue()){
					Record __record = otherNameItem.getSelectedRecord();
					otherBankNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankName")));
					otherBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
//					String __value = event.getValue().toString();
//					Map<String, Object> params = new HashMap<>();
//					params.put("opt_type", "getReceiveUnitInfoByName");
//					params.put("receiveUnit", __value);
//					DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", params, new DSCallback() {
//						
//						@Override
//						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//							if(dsResponse.getStatus() > 0 && dsResponse.getData().length > 0){
//								Record __record = dsResponse.getData()[0];
//								otherBankNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankName")));
//								otherBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
//							}
//						}
//					});
				}
				
			}
		});
//		setSelectValue();
		__formItems.add(otherNameItem);

		selfBankNameItem = new SelectItem("selfBankName", "银行名称(收款方)");
		selfBankNameItem.setWidth("*");
		selfBankNameItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				selfBankAccountItem.clearValue();
				setSelectBankAccountByCompanyIdAndBankName(BaseHelpUtils.getIntValue(selfNameItem.getValue()),
						event.getValue().toString());
			}
		});
		__formItems.add(selfBankNameItem);

		otherBankNameItem = new TextItem("otherBankName", "银行名称(付款方)");
		otherBankNameItem.setDisabled(true);
		otherBankNameItem.setWidth("*");
		__formItems.add(otherBankNameItem);
		
		selfBankAccountItem = new SelectItem("selfBankAccount", "银行账号(收款方)");
		selfBankAccountItem.setWidth("*");
		__formItems.add(selfBankAccountItem);

		otherBankAccountItem = new TextItem("otherBankAccount", "银行账号(付款方)");
		otherBankAccountItem.setDisabled(true);
		otherBankAccountItem.setWidth("*");
		__formItems.add(otherBankAccountItem);

		capitalAtttachmentItem = new TextItem("fileId" , "附件");
		capitalAtttachmentItem.setDisabled(true);
		capitalAtttachmentItem.hide();
		capitalAtttachmentItem.setWidth("*");
		__formItems.add(capitalAtttachmentItem);
		
		receiveUnitIdItem = new ComboBoxItem("receiveUnitId", "实际客户名称");
		receiveUnitIdItem.setWidth("*");
		receiveUnitIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		receiveUnitIdItem.setChangeOnKeypress(false);
		KeyValueManager.loadValueMap("customers", receiveUnitIdItem);
		receiveUnitIdItem.hide();
		__formItems.add(receiveUnitIdItem);

		__form.setItems(getFormItemArray());
//		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setName("收款账号及客户账号信息");
		IButton addBtn = new IButton("添加付款方(收款单位)信息");
		addBtn.setWidth(180);
		addBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow window = new PopupWindow();
				window.setWidth("30%");
				window.setHeight("95%");
				window.centerInPage();
				window.setTitle("添加付款方(收款单位)信息");
				AddReceiveUnitPanel panel = new AddReceiveUnitPanel();
				panel.setParentWindow(window);
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						final Record __record = event.getData();
						Map params = __record.toMap();
						params.put("operateEmployeeId", ClientUtil.getEmployeeId());
						params.put("opt_type", "addReceiveUnitInfo");
						DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", params, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								otherNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("receiveUnit")));
								otherBankNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankName")));
								otherBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
								setSelectValue();
							}
						});
					}
				});
				window.addItem(panel);
				window.show();
				
			}
		});
		VLayout mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.addMember(__form);
		mainLayout.addMember(addBtn);
		addMember(mainLayout);
		uploadButton = new IButton("上传附件");
			mainLayout.addMember(uploadButton);
		uploadButton.hide();
			uploadButton.setTop(5);
			uploadButton.setWidth(180);
			uploadButton.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent clickEvent) {
					CommonUploadWindow window = new CommonUploadWindow("上传附件", true, 500, null, 3, new UploadCallBack() {
						@Override
						public void execute(Map<String, Record> data) {
							for(String key : data.keySet()) {
								String fileId = data.get(key).getAttribute("fileId");
								capitalAtttachmentItem.setValue(fileId);
//								params.put("optType" , "uploadCapitalAttachment");
//								DBDataSource.callOperation("EP_OnCommonProcess", params, new DSCallback() {
//									@Override
//									public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
//
//									}
//								});
							}
						}
					});
				}
			});
		}

	@Override
	public void startEdit() {
		if (getRecord() != null)
			__form.editRecord(getRecord());
		else
			__form.editNewRecord();
	}

	@Override
	public boolean checkData() {
		return true;
	}

//	@Override
//	public void setValueManage(ValuesManager manager) {
//		manager.setDataSource(DSMcapitalecoosmeor.getInstance());
//		manager.addMember(__form);
//	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map map = __form.getValues();
		map.put("otherName", otherNameItem.getDisplayValue());
		return map;
	}

	private void setSelectBankAddressByCompanyId(int __companyId) {
		Map<String, Object> params = new HashMap<>();
		params.put("opt_type", "getBankAddressByCompany");
		params.put("objectId", __companyId);
		params.put("objectType", 2);
		KeyValueManager.setValueMapFromQuery("EP_CustomSprocessbilllistppporProcess", MapUtils.toJSON(params),
				selfBankNameItem);
	}

	private void setSelectBankAccountByCompanyIdAndBankName(int __companyId, String bankAddress) {
		Map<String, Object> params = new HashMap<>();
		params.put("opt_type", "getBankcardByCmpAndAddress");
		params.put("objectId", __companyId);
		params.put("objectType", 2);
		params.put("bankAddress", bankAddress);
		KeyValueManager.setValueMapFromQuery("EP_CustomSprocessbilllistppporProcess", MapUtils.toJSON(params),
				selfBankAccountItem);
	}
	
	private void setSelectValue(){
		Map<String, Object> params = new HashMap<>();
		params.put("opt_type", "getReceiveUnitNameList");
		KeyValueManager.setValueMapFromQuery("EP_CustomSprocessbilllistppporProcess", MapUtils.toJSON(params), otherNameItem);
	}
	
	public ComboBoxItem getReceiveUnitIdItem() {
		return receiveUnitIdItem;
	}
	
}
