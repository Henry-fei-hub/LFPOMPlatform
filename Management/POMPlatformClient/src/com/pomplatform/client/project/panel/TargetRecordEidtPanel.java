package com.pomplatform.client.project.panel;

import java.math.BigDecimal;
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
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyMenuMain;
import com.delicacy.client.ui.LoadingWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class TargetRecordEidtPanel   extends VLayout implements HasHandlers {
	private Window parentWindow;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private static Logger __logger = Logger.getLogger("");
	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();
	private SelectItem businessLineItem;
	private TextItem targetItem;
	private SelectItem typeItem;
	private TextItem revenuePlateIdItem;
	private TextAreaItem remarkItem;
	private SelectItem yearItem;
	private DynamicForm form;
	private IButton  saveBut;
	private HLayout buttonLayout;
	
	
	public void initComponents() {
		businessLineItem=new SelectItem("businessLine","业务条线");
		businessLineItem.setWidth("*");
		businessLineItem.setCanEdit(true);
		businessLineItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_205"));
		
		yearItem=new SelectItem("year","年份");
		yearItem.setWidth("*");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		Date currentDate = new Date();
		yearItem.setDefaultValue(currentDate.getYear()+1900);
		
		targetItem=new TextItem("target","指标");
		targetItem.setWidth("*");
		targetItem.setCanEdit(true);
		
		typeItem=new SelectItem("type","补贴类型");
		typeItem.setWidth("*");
		typeItem.setCanEdit(true);
		typeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_211"));
		
		remarkItem=new TextAreaItem("remark","备注");
		remarkItem.setWidth("*");
		remarkItem.setCanEdit(true);
		
		form = new DynamicForm();
		form.setCellPadding(4);
		form.setNumCols(2);
		form.setAlign(Alignment.CENTER);
		form.setPadding(3);
		form.setMargin(3);
		form.setWidth100();
		form.setHeight100();
		form.setItems(businessLineItem,yearItem,typeItem,targetItem,remarkItem);
		addMember(form);
		
		saveBut=new IButton("保存修改");
		saveBut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				SC.ask("确认提交？", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						// TODO Auto-generated method stub
						Map<String,Object> params = new HashMap<>();
						int businessLine = BaseHelpUtils.getIntValue(businessLineItem.getValue());
						int year = BaseHelpUtils.getIntValue(yearItem.getValue());
						BigDecimal target = BaseHelpUtils.getBigDecimalValue(targetItem.getValue());
						 int type = BaseHelpUtils.getIntValue(typeItem.getValue());
						 String remark = BaseHelpUtils.getString(remarkItem.getValue());
						 
						 if(BaseHelpUtils.isNullOrEmpty(businessLine)) {
							 SC.say("提示","业务条线不能为空");
							 return;
						 }
						 if(BaseHelpUtils.isNullOrEmpty(year)) {
							 SC.say("提示","年份不能为空");
							 return;
						 }
						 if(BaseHelpUtils.isNullOrEmpty(target)) {
							 SC.say("提示","指标不能为空");
							 return;
						 }
						 if(BaseHelpUtils.isNullOrEmpty(type)) {
							 SC.say("提示","类型不能为空");
							 return;
						 }
						 
						params.put("businessLine", businessLine);
						params.put("year", year);
						params.put("target", target);
						params.put("type", type);
						params.put("remark", remark);
						params.put("optType", "onSaveOrUpdateTargetRecord");
						DBDataSource.callOperation("EP_OnProjectCommonProcess",params,new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() < 0) {
									SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
								}else {
									getParentWindow().destroy();
									DataEditEvent dee = new DataEditEvent();
									fireEvent(dee);
								}
							}
						});	
					}
				});
				
			}
		});
		buttonLayout=new HLayout();
		buttonLayout.setAlign(Alignment.CENTER);
		buttonLayout.setWidth100();
		buttonLayout.setHeight100();
		buttonLayout.addMember(saveBut);
		addMember(buttonLayout);
		
	}
	
	
	
	public  void lodaData() {
		
	}
	
	private Record record;
	
	
	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
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
	
	public void startEdit() {
		if(null != getRecord()){
			form.editRecord(getRecord());
		}
	}


}
