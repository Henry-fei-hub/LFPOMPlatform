package com.pomplatform.client.receivables.form;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridReceiveUnitValue;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
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

public class McapitalecoosmeorGroupname2Update extends AbstractWizadPage {

	private final SelectItem selfNameItem;
	private final SelectItem selfBankNameItem;
	private final SelectItem selfBankAccountItem;
	private final ComboBoxItem otherNameItem;
	private final TextItem otherBankNameItem;
	private final TextItem otherBankAccountItem;
	private final ComboBoxItem receiveUnitIdItem;
	public static TextItem capitalAtttachmentItem;
	public static IButton uploadButton;

	public McapitalecoosmeorGroupname2Update() {
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
		otherNameItem.setValueField("bankAccount");
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
		otherBankNameItem.setWidth("*");
		otherBankNameItem.setDisabled(true);
		
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
		capitalAtttachmentItem.setWidth("*");
		capitalAtttachmentItem.hide();
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
		setPageMode(PAGE_MODE_UPDATE);
		setName("收款账号及客户账号信息");
//		setSelectValue();
		uploadButton = new IButton("上传附件");
		VLayout mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.addMember(__form);
		mainLayout.addMember(uploadButton);
		addMember(mainLayout);
		uploadButton.setTop(5);
		uploadButton.setWidth(180);
		uploadButton.hide();
		uploadButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				CommonUploadWindow window = new CommonUploadWindow("修改附件", true, 500, null, 3, new UploadCallBack() {
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



//	@Override
//	public void setValueManage(ValuesManager manager) {
//		manager.setDataSource(DSMcapitalecoosmeor.getInstance());
//		manager.addMember(__form);
//	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		Record r = getRecord();
		if (null != r) {
			int moneyAttribute = BaseHelpUtils.getIntValue(r.getAttribute("moneyAttribute"));
			if(moneyAttribute == ClientStaticUtils.CAPITAL_MONEY_ATTRIBUTION_11 || moneyAttribute == ClientStaticUtils.CAPITAL_MONEY_ATTRIBUTION_13) {
				uploadButton.show();
				capitalAtttachmentItem.show();
				receiveUnitIdItem.show();
			}
			int selfName = record.getAttributeAsInt("selfName");
			String selfBankName = record.getAttributeAsString("selfBankName");
			r.setAttribute("otherName", record.getAttribute("otherBankAccount"));
			__form.editRecord(r);
			setSelectBankAddressByCompanyId(selfName);
			setSelectBankAccountByCompanyIdAndBankName(selfName, selfBankName);
		}
	}

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
}
