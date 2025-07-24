package com.pomplatform.client.invoiceexpresitssccmisiior.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;

public class LeftUpdateInvoiceExpressFormPanel extends AbstractWizadPage implements HasHandlers{
	
	private final SelectItem courierTypeItem;
	
	private final SelectItem contractIdItem;
	
	private final SelectItem contactIdItem;
	
	private final TextItem courierNumberItem;
	
	private final TextItem telItem;
	
	private final TextItem mailingAddressItem;
	
	private final DateItem courierDateItem;
	
	private TextItem signNameItem;
	
	private DateItem signDateItem;
	
	private TextItem remarkItem;
	
    public final static String BORDER_STYLE = "1px solid #ABABAB";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";
    
	public LeftUpdateInvoiceExpressFormPanel(final ListGridRecord record, final int optionType){

//		setBorder(BORDER_STYLE);
		setBackgroundColor(BACKGROUND_COLOR);
		VLayout allH =new VLayout();
		allH.setWidth100();
		allH.setHeight100();
		allH.setMargin(5);
		
		courierTypeItem = new SelectItem("courierType", "快递类型");
		courierTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_56"));
		courierTypeItem.setRequired(true);
		courierTypeItem.setWidth("*");
		__formItems.add(courierTypeItem);
		
		courierNumberItem = new TextItem("courierNumber", "快递单号");
		courierNumberItem.setRequired(true);
		courierNumberItem.setWidth("*");
		__formItems.add(courierNumberItem);
		
		contractIdItem = new SelectItem("contractId", "选择合同");
		contractIdItem.setRequired(true);
		contractIdItem.setWidth("*");
		
		__formItems.add(contractIdItem);
		
		contactIdItem = new SelectItem("contactId", "选择联系人");
		contactIdItem.setRequired(true);
		contactIdItem.setWidth("*");
		contactIdItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				Map<String, Object> params = new HashMap<>();
				params.put("invoiceApplyId", event.getValue());
				telItem.clearValue();
				mailingAddressItem.clearValue();
				DBDataSource.callOperation("ST_InvoiceApply", "find", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						Record record = dsResponse.getData()[0];
						telItem.setValue(record.getAttribute("customerPhone"));
						mailingAddressItem.setValue(record.getAttribute("applyRemark"));
						
					}
				});
//				Map<String, Object> params = new HashMap<>();
//				params.put("opt_type", "getClientsById");
//				params.put("clientId", event.getValue());
//				telItem.clearValue();
//				mailingAddressItem.clearValue();
//				DBDataSource.callOperation("EP_CustomerMinvoiceexpresitssccmisiiorHandler", "getClientsById", params, new DSCallback() {
//					
//					@Override
//					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//						Record record = dsResponse.getData()[0];
//						telItem.setValue(record.getAttribute("clientPhone"));
//						mailingAddressItem.setValue(record.getAttribute("clientAddress"));
//					}
//				});
				
			}
		});
		__formItems.add(contactIdItem);
		
		telItem = new TextItem("tel", "联系方式");
		telItem.setRequired(true);
		telItem.setWidth("*");
		__formItems.add(telItem);
		
		mailingAddressItem = new TextItem("mailingAddress", "寄件地址");
		mailingAddressItem.setRequired(true);
		mailingAddressItem.setWidth("*");
		__formItems.add(mailingAddressItem);
		
		courierDateItem = new DateItem("courierDate", "快递日期");
		courierDateItem.setDefaultValue(new Date());
		courierDateItem.setRequired(true);
		courierDateItem.setUseMask(true);
		courierDateItem.setUseTextField(true);
		courierDateItem.setWidth("*");
		
		__formItems.add(courierDateItem);
		
		if(optionType == 1 || optionType == 2 || optionType == 3){
			signNameItem = new TextItem("signName", "签收人");
			signNameItem.setRequired(true);
			signNameItem.setWidth("*");
			__formItems.add(signNameItem);
			
			signDateItem = new DateItem("signDate", "签收日期");
			signDateItem.setDefaultValue(new Date());
			signDateItem.setRequired(true);
			signDateItem.setWidth("*");
			signDateItem.setUseMask(true);
			signDateItem.setUseTextField(true);
			__formItems.add(signDateItem);
		}
		
		remarkItem = new TextItem("remark", "特殊备注(没有选择发票时必填)");
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);
		
		
		__form.setItems(getFormItemArray());
		__form.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		__form.setHeight100();
		__form.setWidth100();
		__form.setBorder(FORM_BORDER_STYLE);
		__form.setValues(record.toMap());
		allH.addMember(__form);
		
		addMember(allH);
		//optionType 1:签收  2:修改 3：查看
		if(optionType == 1){//添加签收人与签收日期  且设置原有不可修改
			
			contractIdItem.setDisabled(true);
			courierTypeItem.setDisabled(true);
			courierNumberItem.setDisabled(true);
			contactIdItem.setDisabled(true);
			telItem.setDisabled(true);
			mailingAddressItem.setDisabled(true);
			courierDateItem.setDisabled(true);
		}else if(optionType == 2){//修改
			contractIdItem.setDisabled(true);
		}else if(optionType == 3){
			contractIdItem.setDisabled(true);
			courierTypeItem.setDisabled(true);
			courierNumberItem.setDisabled(true);
			contactIdItem.setDisabled(true);
			telItem.setDisabled(true);
			mailingAddressItem.setDisabled(true);
			courierDateItem.setDisabled(true);
			signNameItem.setDisabled(true);
			signDateItem.setDisabled(true);
		}
		
		//设置合同初始下拉值
		setContractKeyValue();
		//设置联系人初始下拉值
		setContactKeyValue();
	}
	
	private void setContractKeyValue(){
		Map<String, Object> params = new HashMap<>();
		params.put("opt_type", "getContractToInvoice");
		KeyValueManager.setValueMapFromQuery("EP_CustomSinvoiceitiorHandler", MapUtils.toJSON(params), contractIdItem);
	}
	
	private void setContactKeyValue(){
		Map<String, Object> params = new HashMap<>();
		params.put("opt_type", "getContcatsByContract");
		params.put("contractId", contractIdItem.getValue());
		KeyValueManager.setValueMapFromQuery("EP_CustomerMinvoiceexpresitssccmisiiorHandler", MapUtils.toJSON(params), contactIdItem);
//		Map<String, Object> params = new HashMap<>();
//		params.put("opt_type", "getClientsByContract");
//		params.put("contractId", contractIdItem.getValue());
//		//设置联系人下拉值
//		KeyValueManager.setValueMapFromQuery("EP_CustomerMinvoiceexpresitssccmisiiorHandler", MapUtils.toJSON(params), contactIdItem);
	}

	@Override
	public Map getValuesAsMap() {
		return __form.getValues();
	}

	@Override
	public boolean checkData() {
		return __form.validate();
	}

	@Override
	public void startEdit() {
		__form.editNewRecord();
	}
	
}
