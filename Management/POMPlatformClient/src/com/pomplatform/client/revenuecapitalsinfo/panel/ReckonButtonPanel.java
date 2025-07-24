package com.pomplatform.client.revenuecapitalsinfo.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.LoadingWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;

public class ReckonButtonPanel  extends HLayout implements HasHandlers{
	private Window parentWindow;
	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();
	private TextItem  yearItem;
	private DynamicForm form;
    private ButtonItem  okButtonItem;
    private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
    private HLayout hlayout;
	
	
	public void initComponents() {
		hlayout=new HLayout(30);
		hlayout.setAlign(Alignment.CENTER);
		hlayout.setWidth100();
		hlayout.setHeight100();
		hlayout.setMembersMargin(10);
		
		yearItem=new TextItem("year",shouldNotBeNull+"年份");
		yearItem.setWidth("*");
		yearItem.setRequired(true);
		
		
		
		okButtonItem=new ButtonItem("确定");
		okButtonItem.setWidth("*");
		okButtonItem.setStartRow(false);
		okButtonItem.setVAlign(VerticalAlignment.BOTTOM);
		okButtonItem.setColSpan(1);
		okButtonItem.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
			
			@Override
			public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
				if(!form.validate()){
					SC.say("请按系统提示修改信息");
					return ;
				}
				int year=BaseHelpUtils.getIntValue(yearItem.getValue());
				if(year<2015) {
					SC.say("年份必须大于或等于2015");
					return ;
				}
				Map<String,Object> pargm=new HashMap<>();
				pargm.put("optType", "saveData");
				pargm.put("year", year);
				final LoadingWindow loading = new LoadingWindow();
				DBDataSource.callOperation("EP_ReckonRevenueCapitals",pargm, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							okButtonItem.setDisabled(true);
							SC.say("计算成功");
							loading.destroy();
							getParentWindow().destroy();
							DataEditEvent dee = new DataEditEvent();
							fireEvent(dee);
						} else {
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
				
			}
		});
		form=new DynamicForm();
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		form.setAlign(Alignment.CENTER);
		form.setWidth100();
		form.setHeight100();
		form.setItems(yearItem,okButtonItem);
		form.setNumCols(4);
		form.setMargin(50);
		hlayout.addMember(form);
		addMember(hlayout);
		
		
	}
	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}
	
	

}
