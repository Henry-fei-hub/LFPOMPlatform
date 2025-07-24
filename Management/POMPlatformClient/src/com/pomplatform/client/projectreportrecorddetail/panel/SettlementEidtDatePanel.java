package com.pomplatform.client.projectreportrecorddetail.panel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

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
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class SettlementEidtDatePanel  extends VLayout implements HasHandlers{
	private Window parentWindow;
	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();
	private DateTimeItem dateItem;
	private DynamicForm form;
    private IButton  okButton;
    private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
    private VLayout hlayout;
    private HLayout butLayout;
    private static Logger __logger = Logger.getLogger("");
	
	
	public void initComponents() {
		hlayout=new VLayout(10);
		hlayout.setAlign(Alignment.CENTER);
		hlayout.setWidth100();
		hlayout.setMargin(10);
		hlayout.setHeight("80%");
		addMember(hlayout);
		
		
		butLayout=new HLayout(10);
		butLayout.setAlign(Alignment.CENTER);
		butLayout.setWidth100();
		butLayout.setMargin(30);
		butLayout.setHeight("20%");
		addMember(butLayout);
		
		
		dateItem=new DateTimeItem("settlementDate",shouldNotBeNull+"结算日期");
		dateItem.setWidth("*");
		dateItem.setRequired(true);
		
		
		
		okButton=new IButton("确定");
		okButton.setAlign(Alignment.CENTER);
		okButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!form.validate()){
					SC.say("请按系统提示修改信息");
					return ;
				}
				int projectId=BaseHelpUtils.getIntValue(getRecord().getAttribute("projectId"));
				int settlementId=BaseHelpUtils.getIntValue(getRecord().getAttribute("settlementId"));
				Date settlementDate=dateItem.getValueAsDate();
				Map<String,Object> pargm=new HashMap<>();
				pargm.put("projectId",projectId);
				pargm.put("settlementId",settlementId);
				pargm.put("settlementDate",settlementDate);
				pargm.put("optType", "updateSetData");
				DBDataSource.callOperation("EP_AboutProjectStageAudit",pargm, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							okButton.setDisabled(true);
							SC.say("修改成功");
							getParentWindow().destroy();
							DataEditEvent dee = new DataEditEvent();
							dee.setData(getRecord());
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
		form.setPadding(5);
		form.setHeight100();
		form.setItems(dateItem);
		form.setNumCols(2);
		hlayout.addMember(form);
		butLayout.addMember(okButton);
		
		
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
	
	
	private Record record;


	public Record getRecord() {
		return record;
	}
	public void setRecord(Record record) {
		this.record = record;
	}
	

}
