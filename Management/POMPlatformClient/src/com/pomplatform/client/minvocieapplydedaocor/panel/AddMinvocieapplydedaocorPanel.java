package com.pomplatform.client.minvocieapplydedaocor.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.mcontractisubccacccor.panel.McontractisubccacccorPanel;
import com.pomplatform.client.mcontractreceivableiicor.panel.McontractreceivableiicorPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class AddMinvocieapplydedaocorPanel extends AbstractWizadPage implements HasHandlers{
	
	
	private final TextItem applicantNameItem;
	
	private final TextItem companyNameItem;
	
	private final TextItem dutyParagraphItem;
	
	private final TextItem customerNameItem;
	
	private final TextItem customerPhoneItem;
	
	private final TextItem registeredAddressItem;
	
	private final TextItem bankNameItem;
	
	private final TextItem bankAccountItem;
	
	private final TextItem applyRemarkItem;
	
	private final TextItem departmentNameItem;
	
	private final DoubleItem applySumMoneyItem; 
	
	private final RadioGroupItem invoiceTypeItem;
	
	private final McontractisubccacccorPanel mcontractisubccacccorPanel;//右边选择合同面板
	
	private final McontractreceivableiicorPanel mcontractreceivableiicorPanel;//合同阶段与阶段申请金额面板
	
    public final static String BORDER_STYLE = "1px solid gray";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";
    
    public DelicacyListGrid contractGrid;
    
	private static final Logger __LOGGER = Logger.getLogger("");

	
	public AddMinvocieapplydedaocorPanel(){
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
		
		VLayout rightLayout = new VLayout();//右边的合同与阶段面板
		rightLayout.setWidth("75%");
		rightLayout.setHeight100();
		
		mcontractisubccacccorPanel = new McontractisubccacccorPanel();
		mcontractisubccacccorPanel.setHeight("50%");
		rightLayout.addMember(mcontractisubccacccorPanel.getViewPanel());
		mcontractisubccacccorPanel.commonQuery();
		
		//添加合同面板点击事件
	    contractGrid = mcontractisubccacccorPanel.getGird();
		contractGrid.addSelectionChangedHandler(new SelectionChangedHandler() {
			
			@Override
			public void onSelectionChanged(SelectionEvent event) {
				if(null != event.getSelectedRecord()){
					int contractId = event.getSelectedRecord().getAttributeAsInt("contractId");
					mcontractreceivableiicorPanel.setContractId(contractId);
					mcontractreceivableiicorPanel.startEdit();
				}
			}
		});
		
		mcontractreceivableiicorPanel = new McontractreceivableiicorPanel(true);
		mcontractreceivableiicorPanel.setHeight("50%");
		rightLayout.addMember(mcontractreceivableiicorPanel);
		
		departmentNameItem = new TextItem("departmentName", "部门名称");
		departmentNameItem.setDisabled(true);
		departmentNameItem.setRequired(false);
		departmentNameItem.setWidth("*");
		__formItems.add(departmentNameItem);
		
		applicantNameItem = new TextItem("applicantName", "申请人名称");
		applicantNameItem.setDisabled(true);
		applicantNameItem.setRequired(false);
		applicantNameItem.setWidth("*");
		__formItems.add(applicantNameItem);
		
	    invoiceTypeItem = new RadioGroupItem("invoiceType");  
		invoiceTypeItem.setDefaultValue(1);  
		invoiceTypeItem.setWidth("*");
		invoiceTypeItem.setAlign(Alignment.CENTER);
		invoiceTypeItem.setVertical(false);
		invoiceTypeItem.setShowTitle(false);  
		invoiceTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_52"));  
//		invoiceTypeItem.addChangedHandler(new ChangedHandler() {  
//
//			@Override
//			public void onChanged(com.smartgwt.client.widgets.form.fields.events.ChangedEvent event) {
//				int typeVal = BaseHelpUtils.getIntValue(event.getValue());
//				if(typeVal == 2){
//					dutyParagraphItem.hide();
//					customerNameItem.hide();
//					customerPhoneItem.hide();
//					registeredAddressItem.hide();
//					bankNameItem.hide();
//					bankAccountItem.hide();
//				}else{
//					dutyParagraphItem.show();
//					customerNameItem.show();
//					customerPhoneItem.show();
//					registeredAddressItem.show();
//					bankNameItem.show();
//					bankAccountItem.show();
//				}
//				
//			}  
//        });  
        __formItems.add(invoiceTypeItem);
		
        companyNameItem = new TextItem("companyName", "单位名称");
		companyNameItem.setRequired(true);
		companyNameItem.setWidth("*");
		__formItems.add(companyNameItem);
		
		dutyParagraphItem = new TextItem("dutyParagraph", "税号");
		dutyParagraphItem.setRequired(true);
		dutyParagraphItem.setWidth("*");
		__formItems.add(dutyParagraphItem);
		
		customerNameItem = new TextItem("customerName", "联系人名称");
		customerNameItem.setRequired(true);
		customerNameItem.setWidth("*");
		__formItems.add(customerNameItem);
		
		
		customerPhoneItem = new TextItem("customerPhone", "联系人电话");
		customerPhoneItem.setRequired(true);
		customerPhoneItem.setWidth("*");
		__formItems.add(customerPhoneItem);
		
		registeredAddressItem = new TextItem("registeredAddress", "注册地址");
		registeredAddressItem.setRequired(true);
		registeredAddressItem.setWidth("*");
		__formItems.add(registeredAddressItem);
		
		bankNameItem = new TextItem("bankName", "开户银行");
		bankNameItem.setRequired(true);
		bankNameItem.setWidth("*");
		__formItems.add(bankNameItem);
		
		bankAccountItem = new TextItem("bankAccount", "银行账号");
		bankAccountItem.setRequired(true);
		bankAccountItem.setWidth("*");
		__formItems.add(bankAccountItem);
		
		
		applyRemarkItem = new TextItem("applyRemark", "申请备注");
		applyRemarkItem.setRequired(true);
		applyRemarkItem.setWidth("*");
		__formItems.add(applyRemarkItem);
		
		applySumMoneyItem = new DoubleItem("applySumMoney", "总计(元)");
		applySumMoneyItem.setRequired(true);
		applySumMoneyItem.setWidth("*");
		__formItems.add(applySumMoneyItem);
		
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
		
		
		IButton saveBtn = new IButton("申请");
		saveBtn.setIcon("[SKIN]/actions/save.png");
		btnLayout.addMember(saveBtn);
		btnLayout.addSpacer(10);
		saveBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
							
				if(checkData()){
					SC.ask("提示", "确认申请?", new BooleanCallback() {
						
						@Override
						public void execute(Boolean value) {
							if(value){
								Map params = __form.getValues();
								//获取阶段数据
								ListGridRecord [] records = mcontractreceivableiicorPanel.SourceGrid.getRecords();
								List<Map<String, Object>> list = new ArrayList<>();
								for (ListGridRecord listGridRecord : records) {
										list.add(listGridRecord.toMap());
								}
								//获取合同数据
								int contractId = contractGrid.getSelectedRecord().getAttributeAsInt("contractId");
								params.put("applicantId", ClientUtil.getEmployeeId());
								params.put("applicantDeparmentId", ClientUtil.getDepartmentId());
								params.put("contractId", contractId);
								params.put("list", list);
								params.put("opt_type", "addApplyInvocie");
								DBDataSource.callOperation("EP_CustomMinvocieapplydedaocor", "addApplyInvocie", params, new DSCallback() {
									
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
				SC.ask("确认取消?", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						if(value){
							getFatherWindow().destroy();
						}
						
					}
				});
			}
		});
		
		leftLayout.addMember(__form);
		allH.addMember(leftLayout);
		allH.addMember(rightLayout);
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
		int __typeVal = BaseHelpUtils.getIntValue(invoiceTypeItem.getValue());
		if(__typeVal == 2){
//			dutyParagraphItem.clearValue();
//			customerNameItem.clearValue();
//			customerPhoneItem.clearValue();
//			registeredAddressItem.clearValue();
//			bankNameItem.clearValue();
//			bankAccountItem.clearValue();
			
			dutyParagraphItem.setRequired(false);
			customerNameItem.setRequired(false);
			customerPhoneItem.setRequired(false);
			registeredAddressItem.setRequired(false);
			bankNameItem.setRequired(false);
			bankAccountItem.setRequired(false);
		}else{
			dutyParagraphItem.setRequired(true);
			customerNameItem.setRequired(true);
			customerPhoneItem.setRequired(true);
			registeredAddressItem.setRequired(true);
			bankNameItem.setRequired(true);
			bankAccountItem.setRequired(true);
		}
		ListGridRecord record = contractGrid.getSelectedRecord();
		if(null != record){
			double contractSignMoney = record.getAttributeAsDouble("signingMoneySum");
			if(!BaseHelpUtils.isNullOrEmpty(applySumMoneyItem.getValue())){
				if(contractSignMoney >= BaseHelpUtils.getDoubleValue(applySumMoneyItem.getValue())){
					
				}else{
					SC.say("申请金额不能大于合同签约总金额");
					return false;
				}
			}
		}else{
			SC.say("请选择一条合同信息!!!");
			return false;
		}
		
		if( __form.validate()){
//			if(__typeVal == 2){
//				dutyParagraphItem.clearValue();
//				customerNameItem.clearValue();
//				customerPhoneItem.clearValue();
//				registeredAddressItem.clearValue();
//				bankNameItem.clearValue();
//				bankAccountItem.clearValue();
//			}
			return true;
		} else{
			SC.say("请按照系统提示将信息补充完整！");
			return false;
		}
		
	}

	@Override
	public void startEdit() {
		int employeeId = ClientUtil.getEmployeeId();
		Map<String, Object> params = new HashMap<>();
		params.put("employeeId", employeeId);
		params.put("opt_type", "getApplyInitData");
		DBDataSource.callOperation("EP_CustomMinvocieapplydedaocor", "getApplyInitData", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				__form.setValues(dsResponse.getData()[0].toMap());
			}
		});
		
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
