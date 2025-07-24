package com.pomplatform.client.contractincome.panel;

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
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class UpdateButtonPanel  extends VLayout implements HasHandlers{
	private Window parentWindow;
	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();
	private TextAreaItem  projectStatusItem;
	private DynamicForm form;
    private IButton okButton;
    private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
    private VLayout hlayout;
    private HLayout butlayout;
    private Record record;
	
	
	public void initComponents() {
		hlayout=new VLayout(30);
		hlayout.setPadding(5);
		hlayout.setAlign(Alignment.CENTER);
		hlayout.setWidth100();
		hlayout.setHeight("70%");
		hlayout.setMembersMargin(10);
		
		
		butlayout=new HLayout();
		butlayout.setAlign(Alignment.CENTER);
		butlayout.setWidth100();
		butlayout.setHeight("30%");
		
		
		
		projectStatusItem = new TextAreaItem("projectStatus", "项目状态");
		projectStatusItem.setWidth("*");
		projectStatusItem.setTitleAlign(Alignment.CENTER);
		projectStatusItem.setRequired(true);
		
		
		
		okButton=new IButton("确定");
		okButton.setAlign(Alignment.CENTER);
		okButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!form.validate()){
					SC.say("请按系统提示修改信息");
					return ;
				}
				String projectStatus=BaseHelpUtils.getString(projectStatusItem.getValue());
				int contractIncomeLedgerId=BaseHelpUtils.getIntValue(getRecord().getAttribute("contractIncomeLedgerId"));
				Map<String,Object> pargm=new HashMap<>();
				pargm.put("projectStatus", projectStatus);
				pargm.put("contractIncomeLedgerId", contractIncomeLedgerId);
				DBDataSource.callOperation("ST_ContractIncomeLedger","update",pargm, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							okButton.setDisabled(true);
							SC.say("修改成功");
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
		//ClientUtil.DynamicFormProcessAccordingToDevice(form);
		form.setAlign(Alignment.CENTER);
		form.setWidth100();
		form.setHeight("70%");
		form.setItems(projectStatusItem);
		form.setNumCols(2);
		//form.setMargin(50);
		hlayout.addMember(form);
		butlayout.addMember(okButton);
		addMember(hlayout);
		addMember(butlayout);
		
		
	}
	
	
	public void lodaData() {
		int contractIncomeLedgerId=BaseHelpUtils.getIntValue(getRecord().getAttribute("contractIncomeLedgerId"));
		Map<String,Object> pargm=new HashMap<>();
		pargm.put("contractIncomeLedgerId", contractIncomeLedgerId);
		DBDataSource.callOperation("ST_ContractIncomeLedger","find",pargm, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					form.editRecord(dsResponse.getData()[0]);
				} else {
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
		
		
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
	public Record getRecord() {
		return record;
	}
	public void setRecord(Record record) {
		this.record = record;
	}
	
	

}
