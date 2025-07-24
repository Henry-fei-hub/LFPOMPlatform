package com.pomplatform.client.minvocieapplydedaocor.panel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

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
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class AddOrUpdateContactsPanel extends AbstractWizadPage implements HasHandlers{
	
	private final TextItem companyNameItem;
	
	private final TextItem dutyParagraphItem;
	
	private final TextItem customerNameItem;
	
	private final TextItem customerPhoneItem;
	
	private final TextItem registeredAddressItem;
	
	private final TextItem bankNameItem;
	
	private final TextItem bankAccountItem;
	
	private final TextItem applyRemarkItem;
	
	private final TextItem qqItem;
	
	private final TextItem emailItem;
	
	private final TextItem landlineItem;
	
	private final TextItem faxItem;
	
	private final SelectItem invoiceTypeItem;
	
    public final static String BORDER_STYLE = "1px solid gray";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";
    
	private static final Logger __LOGGER = Logger.getLogger("");

	private int contractId;
	
	public AddOrUpdateContactsPanel(Boolean isUpdate){
//		setBorder(BORDER_STYLE);
		setBackgroundColor(BACKGROUND_COLOR);
		VLayout mainLayout = new VLayout();
		
		HLayout allH =new HLayout();
		allH.setWidth100();
		allH.setHeight100();
		allH.setMargin(5);
		
		VLayout leftLayout = new VLayout();//左边的表单
		leftLayout.setWidth("25%");
		leftLayout.setHeight100();
		
		invoiceTypeItem = new SelectItem("invoiceType", "开票类型");
		invoiceTypeItem.setWidth("*");
		invoiceTypeItem.setRequired(true);
		invoiceTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_52"));
		__formItems.add(invoiceTypeItem);
		
        companyNameItem = new TextItem("companyName", "单位名称");
		companyNameItem.setRequired(true);
		companyNameItem.setWidth("*");
		__formItems.add(companyNameItem);
		
		dutyParagraphItem = new TextItem("dutyParagraph", "税号");
		dutyParagraphItem.setRequired(true);
		dutyParagraphItem.setWidth("*");
		__formItems.add(dutyParagraphItem);
		
		registeredAddressItem = new TextItem("registeredAddress", "注册地址");
		registeredAddressItem.setRequired(true);
		registeredAddressItem.setWidth("*");
		__formItems.add(registeredAddressItem);
		
		landlineItem = new TextItem("landline", "固定电话");
		landlineItem.setRequired(true);
		landlineItem.setWidth("*");
		__formItems.add(landlineItem);
		
		bankNameItem = new TextItem("bankName", "开户银行");
		bankNameItem.setRequired(true);
		bankNameItem.setWidth("*");
		__formItems.add(bankNameItem);
		
		bankAccountItem = new TextItem("bankAccount", "银行账号");
		bankAccountItem.setRequired(true);
		bankAccountItem.setWidth("*");
		__formItems.add(bankAccountItem);
		
		customerNameItem = new TextItem("customerName", "邮寄人名称");
		customerNameItem.setRequired(true);
		customerNameItem.setWidth("*");
		__formItems.add(customerNameItem);
		
		customerPhoneItem = new TextItem("customerPhone", "邮寄人电话");
		customerPhoneItem.setRequired(true);
		customerPhoneItem.setWidth("*");
		__formItems.add(customerPhoneItem);
		
		applyRemarkItem = new TextItem("applyRemark", "邮寄人地址");
		applyRemarkItem.setRequired(true);
		applyRemarkItem.setWidth("*");
		__formItems.add(applyRemarkItem);
		
		qqItem = new TextItem("qq", "QQ");
		qqItem.setRequired(false);
		qqItem.setWidth("*");
		__formItems.add(qqItem);
		
		emailItem = new TextItem("email", "邮箱");
		emailItem.setRequired(false);
		emailItem.setWidth("*");
		__formItems.add(emailItem);
		
		faxItem = new TextItem("fax", "传真");
		faxItem.setRequired(false);
		faxItem.setWidth("*");
		__formItems.add(faxItem);
		
		__form.setItems(getFormItemArray());
		__form.setNumCols(2);
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
		
		String title = isUpdate ? "修改" : "添加";
		IButton saveBtn = new IButton(title);
		saveBtn.setIcon("[SKIN]/actions/save.png");
		btnLayout.addMember(saveBtn);
		btnLayout.addSpacer(10);
		saveBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
							
				if(checkData()){
					SC.ask("提示", "确定" + title + "?", new BooleanCallback() {
						
						@Override
						public void execute(Boolean value) {
							if(value){
								Map<String, Object> params = __form.getValues();
								if(isUpdate){
									params.put("opt_type", "updateContacts");
								}else{
									if(null != getRecord()){//检测
										Map<String, Object> params1 = getRecord().toMap();
										if(params1.size() > 6){
											boolean flag = false;
											for (String string : params1.keySet()) {
												if(!Objects.equals(params1.get(string), params.get(string))){
													flag = true;
												}
											}
											if(!flag){
												SC.say("该数据没有进行任何修改！ 无法新增");
												return;
											}
										}
									}
									//获取合同数据
									params.put("applicantId", ClientUtil.getEmployeeId());
									params.put("applicantDeparmentId", ClientUtil.getDepartmentId());
									params.put("contractId", contractId);
									params.put("operatorId", ClientUtil.getEmployeeId());
									params.put("opt_type", "addApplyInvocie");
								}
								DBDataSource.callOperation("EP_CustomMinvocieapplydedaocor", params, new DSCallback() {
									
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if (dsResponse.getStatus() >= 0) {
											getFatherWindow().destroy();
											DataEditEvent dee = new DataEditEvent();
											dee.setData(dsResponse.getData()[0]);
				                            fireEvent(dee);
										}else{
											ClientUtil.displayErrorMessage(dsResponse);
										}
										
									}
								});
							}
						}
					});
				}
				
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
		
		leftLayout.addMember(__form);
		allH.addMember(leftLayout);
		mainLayout.addMember(allH);
		mainLayout.addMember(btnLayout);
		addMember(mainLayout);
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}

	@Override
	public boolean checkData() {
		if( __form.validate()){
			return true;
		} else{
			SC.say("请按照系统提示将信息补充完整！");
			return false;
		}
		
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

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	@Override
	public void startEdit() {
		if(null != getRecord()){
			__form.editRecord(getRecord());
		}
	}
    
}
