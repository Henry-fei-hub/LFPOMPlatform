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
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ProjectEidtPanel   extends VLayout implements HasHandlers {
	private Window parentWindow;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private static Logger __logger = Logger.getLogger("");
	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();
	private TextItem contractCodeItem;
	private TextItem projectIdItem;
	private TextItem projectNameItem;
	private TextItem revenuePlateIdItem;
	private ComboBoxItem plateIdItem;
	private ComboBoxItem departmentManagerIdItem;
	private ComboBoxItem plateManagerIdItem;
	private DynamicForm form;
	private IButton  saveBut;
	private HLayout buttonLayout;
	
	
	public void initComponents() {
		contractCodeItem=new TextItem("contractCode","订单编号");
		contractCodeItem.setWidth("*");
		contractCodeItem.setCanEdit(true);
		
		projectIdItem=new TextItem("projectId","订单projectId");
		projectIdItem.hide();
		
		projectNameItem=new TextItem("projectName","订单名称");
		projectNameItem.setWidth("*");
		projectNameItem.setCanEdit(true);
		
		revenuePlateIdItem=new TextItem("plateId","业务部门");//plate_records
//		KeyValueManager.loadValueMap("plate_records", revenuePlateIdItem);
		revenuePlateIdItem.setWidth("*");
		revenuePlateIdItem.setCanEdit(false);
		revenuePlateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		
		plateIdItem=new ComboBoxItem("plateId","新业务部门");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setWidth("*");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		plateIdItem.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				Map<String,Object> params = new HashMap<>();
				params.put("optType", "findPlateAndDepartmentManagerId");
				params.put("plateId", event.getValue());
				params.put("projectId", projectIdItem.getValue());
				params.put("contractCode", contractCodeItem.getValue());
				DBDataSource.callOperation("EP_OnProjectCommonProcess",params,new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0) {
							Record string = dsResponse.getData()[0];
							if(!BaseHelpUtils.isNullOrEmpty(string)) {
								String plateManageId = string.getAttribute("alternateField1");
								String departmentManageId = string.getAttribute("alternateField2");
								String contractCode = string.getAttribute("alternateField3");
								String annualPerformance = string.getAttribute("annualPerformance");
								departmentManagerIdItem.setValue(departmentManageId);
								plateManagerIdItem.setValue(plateManageId);
								contractCodeItem.setValue(contractCode);
								if(!BaseHelpUtils.isNullOrEmpty(annualPerformance)&&annualPerformance.equals("false")) {
									SC.say("提示","新的订单编号已重复("+contractCode+"),请在新的订单编号往后添加后续标识");
								}
							}else {
								departmentManagerIdItem.setValue("");
								plateManagerIdItem.setValue("");
							}
						}else {
							departmentManagerIdItem.setValue("");
							plateManagerIdItem.setValue("");
							SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
						}
					}
				});	
			}
		});
		
		departmentManagerIdItem=new ComboBoxItem("departmentManagerId","新部门经理");
		departmentManagerIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		departmentManagerIdItem.setWidth("*");
		departmentManagerIdItem.setCanEdit(true);
		departmentManagerIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		
		plateManagerIdItem=new ComboBoxItem("plateManagerId","新事业部负责人");
		plateManagerIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateManagerIdItem.setWidth("*");
		plateManagerIdItem.setCanEdit(true);
		plateManagerIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		
		form = new DynamicForm();
		form.setCellPadding(4);
		form.setNumCols(2);
		form.setAlign(Alignment.CENTER);
		form.setPadding(3);
		form.setMargin(3);
		form.setWidth100();
		form.setHeight100();
		form.setItems(projectIdItem,contractCodeItem,projectNameItem,revenuePlateIdItem,plateIdItem,departmentManagerIdItem,plateManagerIdItem);
		addMember(form);
		
		saveBut=new IButton("保存修改");
		saveBut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				SC.ask("确认提交？", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value) {
							// 获取补贴年月份
							saveBut.setDisabled(true);
							// TODO Auto-generated method stub
							Map<String,Object> params = new HashMap<>();
							int intValue = BaseHelpUtils.getIntValue(projectIdItem.getValue());
							String string = BaseHelpUtils.getString(contractCodeItem.getValue());
							int intValue2 = BaseHelpUtils.getIntValue(plateIdItem.getValue());
							 int intValue3 = BaseHelpUtils.getIntValue(departmentManagerIdItem.getValue());
							 int intValue4 = BaseHelpUtils.getIntValue(plateManagerIdItem.getValue());
							 String projectName = BaseHelpUtils.getString(projectNameItem.getValue());
							 if(BaseHelpUtils.isNullOrEmpty(projectIdItem.getValue())) {
								 SC.say("提示","项目编码不能为空");
								 return;
							 }
							 if(BaseHelpUtils.isNullOrEmpty(string)) {
								 SC.say("提示","订单编号不能为空");
								 return;
							 }
							 if(BaseHelpUtils.isNullOrEmpty(plateIdItem.getValue())) {
								 SC.say("提示","业务部门不能为空");
								 return;
							 }
							 if(BaseHelpUtils.isNullOrEmpty(departmentManagerIdItem.getValue())) {
								 SC.say("提示","部门经理不能为空");
								 return;
							 }
							 if(BaseHelpUtils.isNullOrEmpty(plateManagerIdItem.getValue())) {
								 SC.say("提示","事业部负责人不能为空");
								 return;
							 }
							 
							params.put("projectId", BaseHelpUtils.getIntValue(projectIdItem.getValue()));
							params.put("contractCode", BaseHelpUtils.getString(contractCodeItem.getValue()));
							params.put("plateId", BaseHelpUtils.getIntValue(plateIdItem.getValue()));
							params.put("departmentManagerId", BaseHelpUtils.getIntValue(departmentManagerIdItem.getValue()));
							params.put("plateManagerId", BaseHelpUtils.getIntValue(plateManagerIdItem.getValue()));
							params.put("projectName", projectName);
							params.put("optType", "onSaveOrUpdatePlateAndDepartmentManagerId");
							DBDataSource.callOperation("EP_OnProjectCommonProcess",params,new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									saveBut.setDisabled(false);
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
