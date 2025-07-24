package com.pomplatform.client.cmbcinfo.panel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.LoadingWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class SyncCmbcDataPanel extends AbstractWizadPage implements HasHandlers{
	
	private final DateItem beginDateItem;
	private final DateItem endDateItem;
	
    public final static String BORDER_STYLE = "1px solid gray";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";
    
    private Record [] selectRecords;
	
	public SyncCmbcDataPanel(){
//		setBorder(BORDER_STYLE);
		setBackgroundColor(BACKGROUND_COLOR);
		VLayout allH =new VLayout();
		allH.setWidth100();
		allH.setHeight100();
		allH.setMargin(5);
		
		beginDateItem = new DateItem("beginDate", "开始日期");
		beginDateItem.setRequired(true);
		beginDateItem.setWidth("*");
		__formItems.add(beginDateItem);
		
		endDateItem = new DateItem("endDate", "结束日期");
		endDateItem.setRequired(true);
		endDateItem.setWidth("*");
		__formItems.add(endDateItem);
		
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
		
		
		IButton saveBtn = new IButton("保存");
		saveBtn.setIcon("[SKIN]/actions/save.png");
		btnLayout.addMember(saveBtn);
		btnLayout.addSpacer(10);
		saveBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(checkData()){
					SC.ask("提示", "确认同步?", new BooleanCallback() {
						
						@Override
						public void execute(Boolean value) {
							if(value){
								    LoadingWindow loadWindow = new LoadingWindow();
									Map params = __form.getValuesAsRecord().toMap();
									params.put("opt_type", "syncCmbTransData");
									params.put("list", selectRecords);
									DBDataSource.callOperation("EP_CmbcInfoProcessor", params, new DSCallback() {
										
										@Override
										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
											loadWindow.destroy();
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
				}else{
					SC.say("请按系统提示，填写正确数据！");
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
		return __form.validate();
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

	public Record[] getSelectRecords() {
		return selectRecords;
	}

	public void setSelectRecords(Record[] selectRecords) {
		this.selectRecords = selectRecords;
	}
}
