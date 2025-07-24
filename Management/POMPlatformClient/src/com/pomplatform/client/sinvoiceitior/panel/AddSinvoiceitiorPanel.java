package com.pomplatform.client.sinvoiceitior.panel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ValidateUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class AddSinvoiceitiorPanel extends AbstractWizadPage implements HasHandlers{
	
	private final SelectItem invoiceTypeItem;
	
	private final SelectItem ticketingCompanyItem;
	
	private final TextItem invoiceCodeItem;
	private final TextItem invoiceNumberItem;
	
	private final IntegerItem invoicCountItem;
	
    public final static String BORDER_STYLE = "1px solid gray";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";
	
	public AddSinvoiceitiorPanel(){
//		setBorder(BORDER_STYLE);
		setBackgroundColor(BACKGROUND_COLOR);
		VLayout allH =new VLayout();
		allH.setWidth100();
		allH.setHeight100();
		allH.setMargin(5);
		
		invoiceTypeItem = new SelectItem("invoiceType", "发票类型");
		invoiceTypeItem.setDefaultValue(1);
		invoiceTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_52"));
		invoiceTypeItem.setWidth("*");
		__formItems.add(invoiceTypeItem);
		ticketingCompanyItem = new SelectItem("ticketingCompany", "购票公司");
		ticketingCompanyItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_54"));
		ticketingCompanyItem.setWidth("*");
		ticketingCompanyItem.setDefaultValue(0);
		__formItems.add(ticketingCompanyItem);
		invoiceCodeItem = new TextItem("invoiceCode", "发票代码");
		invoiceCodeItem.setLength(12);
		invoiceCodeItem.setValidators(ValidateUtils.StringLenValidator(10, 12));
		invoiceCodeItem.setRequired(true);
		invoiceCodeItem.setWidth("*");
		__formItems.add(invoiceCodeItem);
		invoiceNumberItem = new TextItem("invoiceNumber", "发票号码");
		invoiceNumberItem.setLength(8);
		invoiceNumberItem.setValidators(ValidateUtils.StringLenValidator(8, 8));
		invoiceNumberItem.setRequired(true);
		invoiceNumberItem.setWidth("*");
		__formItems.add(invoiceNumberItem);
		invoicCountItem = new IntegerItem("invoicCount", "发票张数");
		invoicCountItem.setRequired(true);
		invoicCountItem.setValidators(ValidateUtils.IntRangeValidator(1, 200));
		invoicCountItem.setLength(3);
		invoicCountItem.setWidth("*");
		__formItems.add(invoicCountItem);
		__form.setItems(getFormItemArray());
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		__form.setHeight100();
		__form.setWidth100();
		__form.setBorder(FORM_BORDER_STYLE);
		
		ToolStrip btnLayout = new ToolStrip();
		btnLayout.setVPolicy(LayoutPolicy.FILL);
		btnLayout.setPadding(5);
		btnLayout.setHeight(40);
		btnLayout.setWidth100();
		btnLayout.addFill();
		
		
		IButton saveBtn = new IButton("保存");
		saveBtn.setIcon("[SKIN]/actions/save.png");
		btnLayout.addMember(saveBtn);
		btnLayout.addSpacer(10);
		saveBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				SC.ask("提示", "确认入库?", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						if(value){
							if(checkData()){
								Map params = __form.getValuesAsRecord().toMap();
								params.put("opt_type", "addInvoices");
								DBDataSource.callOperation("EP_CustomSinvoiceitiorHandler", "addInvoices", params, new DSCallback() {
									
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if (dsResponse.getStatus() >= 0) {
											getFatherWindow().destroy();
											DataEditEvent dee = new DataEditEvent();
				                            fireEvent(dee);
										}else{
											ClientUtil.displayErrorMessage(dsResponse);
										}
										
									}
								});
							}
						}
					}
				});
				
			}
		});
		
		IButton cancelBtn = new IButton("取消");
		cancelBtn.setIcon("[SKIN]/actions/close.png");
		btnLayout.addMember(cancelBtn);
		btnLayout.addSpacer(10);
		cancelBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				getFatherWindow().destroy();
			}
		});
		
		allH.addMember(__form);
		allH.addMember(btnLayout);
		
		addMember(allH);
		
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}

	@Override
	public boolean checkData() {
		if(__form.validate()) {
			String code = BaseHelpUtils.getString(invoiceCodeItem.getValue());
			if(code.length() != 10 && code.length() != 12) {
				SC.say("发票代码只能为10位或12位");
				return false;
			}else {
				return true;
			}
		}
		return false;
	}

	@Override
	public void startEdit() {
		__form.editNewRecord();
	}
	
	private Window fatherWindow;

	public Window getFatherWindow() {
		return fatherWindow;
	}

	public void setFatherWindow(Window fatherWindow) {
		this.fatherWindow = fatherWindow;
	}
	
	protected final HandlerManager handlerManager = new HandlerManager(this);
    protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

    @Override
    public void fireEvent(GwtEvent<?> event) {
        handlerManager.fireEvent(event);
    }

    public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
        return handlerManager.addHandler(DataEditEvent.TYPE, handler);
    }
}
