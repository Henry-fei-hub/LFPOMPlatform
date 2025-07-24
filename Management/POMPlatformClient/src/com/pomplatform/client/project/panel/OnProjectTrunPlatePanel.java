package com.pomplatform.client.project.panel;

import java.util.ArrayList;
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
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class OnProjectTrunPlatePanel extends HLayout implements HasHandlers {

	private Window parentWindow;
	private static Logger __logger = Logger.getLogger("");
	private DynamicForm form ;
	private TextItem projectCodeItem;
	private TextItem projectNameItem;
	private ComboBoxItem plateIdItem;
	private TextItem contractCodeItem;
	private ComboBoxItem plateManagerIdItem;
	private ComboBoxItem departmentManagerIdItem;
	
	private ComboBoxItem plateIdNewItem;
	private TextItem contractCodeNewItem;
	private ComboBoxItem plateManagerIdNewItem;
	private ComboBoxItem departmentManagerIdNewItem;
	
	private IButton okBtn;

	public void initComponents() {
		setWidth("98%");
		setHeight100();
		setPadding(10);
		setMembersMargin(5);

		VLayout formLayout = new VLayout();
		formLayout.setHeight("98%");
		formLayout.setMembersMargin(5);
		formLayout.setWidth100();
		formLayout.setAlign(Alignment.CENTER);
		addMember(formLayout);

		HLayout messageLayout = new HLayout();
		messageLayout.setWidth100();
		messageLayout.setHeight("80%");
		messageLayout.setAlign(Alignment.CENTER);

		form = new DynamicForm();
		form.setNumCols(4);
		form.setAlign(Alignment.CENTER);
		form.setPadding(5);
		form.setMargin(5);
		form.setWidth100();
		form.setHeight100();

		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		projectCodeItem.setColSpan(4);
		projectCodeItem.setDisabled(true);
		
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		projectNameItem.setColSpan(4);
		projectNameItem.setDisabled(true);
		
		plateIdItem = new ComboBoxItem("plateId", "原业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setDisabled(true);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		
		plateIdNewItem = new ComboBoxItem("plateIdNew", "新业务部门");
		plateIdNewItem.setWidth("*");
		plateIdNewItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		plateIdNewItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				int plateIdNew = BaseHelpUtils.getIntValue(event.getValue());
				//获取原业务部门Id
				int plateId = BaseHelpUtils.getIntValue(plateIdItem.getValue());
				if(plateId == plateIdNew){
					SC.say("提示","转单部门不能为原部门，请选择其他部门");
					return;
				}
				//获取项目Id
				int projectId = BaseHelpUtils.getIntValue(getRecord().getAttribute("projectId"));
				if(projectId <= 0){
					SC.say("提示","获取项目编码失败");
					return;
				}
				//加载新业务部门下的订单编号、事业部负责人和部门经理
				Map<Object,Object> params = new HashMap<>();
				params.put("projectId",projectId);
				params.put("plateId",plateId);
				params.put("optType", "onGetTrunPlateInfo");
				DBDataSource.callOperation("EP_OnProjectCommonProcess",params, new DSCallback() {
					@SuppressWarnings("unchecked")
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							Map<String,Object> userData = BaseHelpUtils.getResponseUserData(dsResponse);
							contractCodeNewItem.setValue(userData.get("contractCodeNew"));
							plateManagerIdNewItem.setValue(userData.get("plateManagerIdNew"));
							departmentManagerIdNewItem.setValue(userData.get("departmentManagerIdNew"));
						} else {
							SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
						}
					}
				});
			}
		});
		
		contractCodeItem = new TextItem("contractCode", "原订单编号");
		contractCodeItem.setWidth("*");
		contractCodeItem.setDisabled(true);
		
		contractCodeNewItem = new TextItem("contractCodeNew", "新订单编号");
		contractCodeNewItem.setWidth("*");
		contractCodeNewItem.setDisabled(true);
        
		plateManagerIdItem = new ComboBoxItem("plateManagerId", "原事业部负责人");
		plateManagerIdItem.setWidth("*");
		plateManagerIdItem.setDisabled(true);
		plateManagerIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		
		plateManagerIdNewItem = new ComboBoxItem("plateManagerIdNew", "新事业部负责人");
		plateManagerIdNewItem.setWidth("*");
		plateManagerIdNewItem.setDisabled(true);
		plateManagerIdNewItem.setValueMap(KeyValueManager.getValueMap("employees"));
		
		departmentManagerIdItem = new ComboBoxItem("departmentManagerId", "原部门经理");
		departmentManagerIdItem.setWidth("*");
		departmentManagerIdItem.setDisabled(true);
		departmentManagerIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		
		departmentManagerIdNewItem = new ComboBoxItem("departmentManagerIdNew", "新部门经理");
		departmentManagerIdNewItem.setWidth("*");
		departmentManagerIdNewItem.setDisabled(true);
		departmentManagerIdNewItem.setValueMap(KeyValueManager.getValueMap("employees"));
		
		form.setItems(projectCodeItem, projectNameItem,plateIdItem,plateIdNewItem,contractCodeItem,contractCodeNewItem,plateManagerIdItem,plateManagerIdNewItem, departmentManagerIdItem,departmentManagerIdNewItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		messageLayout.addMember(form);
		formLayout.addMember(messageLayout);

		HLayout btnLayout = new HLayout();
		btnLayout.setWidth100();
		btnLayout.setHeight("20%");
		btnLayout.setMembersMargin(10);
		btnLayout.setAlign(Alignment.RIGHT);

		okBtn = new IButton("确认");
		okBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				//获取项目Id
				int projectId = BaseHelpUtils.getIntValue(getRecord().getAttribute("projectId"));
				if(projectId <= 0){
					SC.say("提示","获取项目编码失败");
					return;
				}
				//获取新的业务部门
				int plateId = BaseHelpUtils.getIntValue(plateIdNewItem.getValue());
				//获取新的合同编号
				String contractCode = BaseHelpUtils.getString(contractCodeNewItem.getValue());
				if(BaseHelpUtils.isNullOrEmpty(contractCode)){
					SC.say("提示","新的订单编号不能为空");
					return;
				}
				//获取新的事业部负责人
				int plateManagerId = BaseHelpUtils.getIntValue(plateManagerIdNewItem.getValue());
				if(plateManagerId <= 0){
					SC.say("提示","新的事业部负责人不能为空");
					return;
				}
				//获取新的部门经理
				int departmentManagerId = BaseHelpUtils.getIntValue(departmentManagerIdNewItem.getValue());
				if(departmentManagerId <= 0){
					SC.say("提示","新的部门经理不能为空");
					return;
				}
				Map<Object,Object> params = new HashMap<>();
				params.put("projectId", projectId);
				params.put("plateId", plateId);
				params.put("contractCode", contractCode);
				params.put("plateManagerId", plateManagerId);
				params.put("departmentManagerId", departmentManagerId);
				params.put("optType", "onTrunUpdateProjectInfo");
				okBtn.setDisabled(false);
				DBDataSource.callOperation("EP_OnProjectCommonProcess",params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							okBtn.setDisabled(true);
							if (getParentWindow() == null) {
								return;
							}
							getParentWindow().destroy();
							DataEditEvent dee = new DataEditEvent();
							fireEvent(dee);
						} else {
							SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
						}
					}
				});
			}
		});
		
		IButton cleanBtn = new IButton("关闭");
		cleanBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (getParentWindow() == null) {
					return;
				}
				getParentWindow().destroy();
				DataEditEvent dee = new DataEditEvent();
				fireEvent(dee);
			}
		});
		btnLayout.addMember(okBtn);
		btnLayout.addMember(cleanBtn);
		formLayout.addMember(btnLayout);
		
		//加载登录人员相关信息
		loadData();
	}
	
	/**
	 * 加载登录人员相关信息
	 */
	private void loadData(){
		if(!BaseHelpUtils.isNullOrEmpty(getRecord())){
			form.setValues(getRecord().toMap());
		}
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
