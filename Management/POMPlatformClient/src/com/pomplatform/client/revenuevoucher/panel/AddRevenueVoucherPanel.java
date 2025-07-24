package com.pomplatform.client.revenuevoucher.panel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
import com.smartgwt.client.util.DateUtil;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class AddRevenueVoucherPanel extends AbstractWizadPage implements HasHandlers{
	
	
    public final static String BORDER_STYLE = "1px solid gray";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";
    
	private static final Logger __LOGGER = Logger.getLogger("");

	private final SelectItem yearItem;
	
	private final SelectItem monthItem;
	
	public AddRevenueVoucherPanel(){
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
		
		yearItem = new SelectItem("year", "年");
		yearItem.setDefaultValue(DateUtil.getDisplayYear(new Date()));
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		yearItem.setRequired(true);
		yearItem.setWidth("*");
		__formItems.add(yearItem);
		
		monthItem = new SelectItem("month", "月");
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		monthItem.setRequired(false);
		monthItem.setWidth("*");
		__formItems.add(monthItem);
		
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
		
		IButton saveBtn = new IButton("确定");
		saveBtn.setIcon("[SKIN]/actions/save.png");
		btnLayout.addMember(saveBtn);
		btnLayout.addSpacer(10);
		saveBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
							
				if(checkData()){
					SC.ask("提示", "确定生成凭证?", new BooleanCallback() {
						
						@Override
						public void execute(Boolean value) {
							if(value){
								Map params = __form.getValues();
								if(null != params.get("month")){
									params.put("optType", "createReceivablesK3Voucher");
								}else{
									//月份为空，则生成年度的营收凭证
									params.put("optType", "createReceivablesK3VoucherByYear");
								}
								DBDataSource.callOperation("EP_K3VoucherProcess", params, new DSCallback() {
									
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

	@Override
	public void startEdit() {
		if(null != getRecord()){
			__form.editRecord(getRecord());
		}
	}
    
}
