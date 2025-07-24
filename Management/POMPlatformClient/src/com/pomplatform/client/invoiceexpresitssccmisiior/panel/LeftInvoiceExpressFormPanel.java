package com.pomplatform.client.invoiceexpresitssccmisiior.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.minvocieapplydedaocor.panel.AddOrUpdateContactsPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.VLayout;

public class LeftInvoiceExpressFormPanel extends AbstractWizadPage implements HasHandlers{
	
	private final SelectItem courierTypeItem;
	
	private final ComboBoxItem contractIdItem;
	
	private final ComboBoxItem contactIdItem;
	
	private final TextItem courierNumberItem;
	
	private final TextItem telItem;
	
	private final TextItem mailingAddressItem;
	
	private final DateItem courierDateItem;
	
	public TextItem remarkItem;
	
    public final static String BORDER_STYLE = "1px solid #ABABAB";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";
    
    private DelicacyListGrid invoiceGrid;
	
	public LeftInvoiceExpressFormPanel(final DelicacyListGrid grid){
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
		
		contractIdItem = new ComboBoxItem("contractId", "选择合同");
		contractIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		contractIdItem.setRequired(true);
		contractIdItem.setWidth("*");
		contractIdItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					Map<String, Object> params = new HashMap<>();
					params.put("opt_type", "getContcatsByContract");
					params.put("contractId", event.getValue());
					//设置联系人下拉值
					contactIdItem.clearValue();
					telItem.clearValue();
					mailingAddressItem.clearValue();
					KeyValueManager.setValueMapFromQuery("EP_CustomerMinvoiceexpresitssccmisiiorHandler", MapUtils.toJSON(params), contactIdItem);
					//根据合同获取  发票grid的值
					Map<String, Object> paramsTwo = new HashMap<>();
					paramsTwo.put("opt_type", "getInvoiceByContract");
					paramsTwo.put("contractId", event.getValue());
					DBDataSource.callOperation("EP_CustomerMinvoiceexpresitssccmisiiorHandler", "getInvoiceByContract", paramsTwo, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							grid.setData(dsResponse.getData());
						}
					});
					
				}
			}
		});
		
		__formItems.add(contractIdItem);
		
		contactIdItem = new ComboBoxItem("contactId", "选择联系人");
		contactIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
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
		courierDateItem.setWidth("*");
		__formItems.add(courierDateItem);
		
		remarkItem = new TextItem("remark", "特殊备注(没有选择发票时必填)");
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);
		
		__form.setItems(getFormItemArray());
		__form.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		__form.setHeight100();
		__form.setWidth100();
		__form.setBorder(FORM_BORDER_STYLE);
		
		allH.addMember(__form);
		
		IButton addClientBtn = new IButton("添加联系人");
		addClientBtn.setWidth100();
		allH.addMember(addClientBtn);
		addClientBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
                final int contractId = BaseHelpUtils.getIntValue(contractIdItem.getValue()) ;
                if(contractId > 0){
					PopupWindow pw = new PopupWindow();
					AddOrUpdateContactsPanel panel = new AddOrUpdateContactsPanel(false);
					if(null != getInvoiceGrid() && getInvoiceGrid().anySelected()){
						Record tmpRecord = getInvoiceGrid().getSelectedRecord();
						Record newRecord = new Record();
						newRecord.setAttribute("invoiceType", tmpRecord.getAttribute("invoiceType"));
						newRecord.setAttribute("companyName", tmpRecord.getAttribute("clientName"));
						panel.setRecord(newRecord);
					}
					panel.setContractId(contractId);
					panel.startEdit();
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							Record record = event.getData();
							contactIdItem.setValue(record.getAttribute("invoiceApplyId"));
							telItem.setValue(record.getAttribute("customerPhone"));
							mailingAddressItem.setValue(record.getAttribute("applyRemark"));
							Map<String, Object> params = new HashMap<>();
							params.put("opt_type", "getContcatsByContract");
							params.put("contractId", contractId);
							KeyValueManager.setValueMapFromQuery("EP_CustomerMinvoiceexpresitssccmisiiorHandler", MapUtils.toJSON(params), contactIdItem);
						}
					});
					panel.setParentCanvas(pw);
					panel.setFatherWindow(pw);
					pw.addItem(panel);
					pw.setTitle("添加联系人");
					pw.setWidth("30%");
					pw.setHeight("90%");
					pw.centerInPage();
					pw.show();
                	
                	
//                	PopupWindow pw = new PopupWindow("联系人");
//                    MclientctractorPanel panel = new MclientctractorPanel();
//                    panel.setContractId(contractId);
//                    pw.addItem(panel.getViewPanel());
//                    pw.setWidth100();
//                    pw.setHeight100();
//                    pw.centerInPage();
//                    pw.show();
//                    panel.commonQuery();
//                    pw.addCloseClickHandler(new CloseClickHandler() {
//						
//						@Override
//						public void onCloseClick(CloseClickEvent event) {
//							Map<String, Object> params = new HashMap<>();
//							params.put("opt_type", "getClientsByContract");
//							params.put("contractId", contractId);
//							//设置联系人下拉值
//							contactIdItem.clearValue();
//							telItem.clearValue();
//							mailingAddressItem.clearValue();
//							KeyValueManager.setValueMapFromQuery("EP_CustomerMinvoiceexpresitssccmisiiorHandler", MapUtils.toJSON(params), contactIdItem);
//							
//						}
//					});
                }else{
                	SC.say("请选择合同");
                }
                
			}
		});
		
		addMember(allH);
		
		//设置初始下拉值
		setContractKeyValue();
		
	}
	
	private void setContractKeyValue(){
		Map<String, Object> params = new HashMap<>();
		params.put("opt_type", "getContractToInvoice");
		KeyValueManager.setValueMapFromQuery("EP_CustomSinvoiceitiorHandler", MapUtils.toJSON(params), contractIdItem);
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

	public DelicacyListGrid getInvoiceGrid() {
		return invoiceGrid;
	}

	public void setInvoiceGrid(DelicacyListGrid invoiceGrid) {
		this.invoiceGrid = invoiceGrid;
	}
	
}
