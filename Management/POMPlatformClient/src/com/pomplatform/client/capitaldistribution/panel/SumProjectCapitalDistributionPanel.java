package com.pomplatform.client.capitaldistribution.panel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.common.SyncDataUtil;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class SumProjectCapitalDistributionPanel extends VLayout{

	private DynamicForm form;
	private SelectItem projectIdItem;
	private TextItem projectNameItem;
	private TextItem distributionItem;
	private ToolStrip navLayout;
	
	private Window parent;
	
	private LinkedHashMap<Integer, String> projectMap;
	private BigDecimal distributionAmount;

	protected final HandlerManager handlerManager = new HandlerManager(this);
	private static final Logger logger = Logger.getLogger("");
	
	public void initComponents(){
		setWidth100();
		setHeight100();
		
		projectIdItem = new SelectItem("id", "订单编号");
		projectIdItem.setWidth("*");
		projectIdItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					String projectName = SyncDataUtil.getProjectName(BaseHelpUtils.getIntValue(event.getValue()));
					projectNameItem.setValue(projectName);
//					Record record = getProjectName(BaseHelpUtils.getIntValue(event.getValue()));
//					projectNameItem.setValue(BaseHelpUtils.getString(record.getAttribute("projectName")));
//					projectNameItem.setValue(KeyValueManager.getValue("projects", event.getValue().toString()));
				}
			}
		});
		projectNameItem = new TextItem("name", "订单名称");
		projectNameItem.setWidth("*");
		projectNameItem.setCanEdit(false);
		distributionItem = new TextItem("distributionAmount", "分配金额");
		distributionItem.setWidth("*");
		distributionItem.setCanEdit(false);
		form = new DynamicForm();
		form.setWidth("93%");
		form.setHeight("90%");
		form.setCellPadding(15);
		form.setItems(projectIdItem, projectNameItem, distributionItem);
		addMember(form);
		
		IButton sureButton = new IButton("确定");
		sureButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(checkData()){
					Record record = new Record();
					record.setAttribute("id", projectIdItem.getValue());
//					record.setAttribute("code", KeyValueManager.getValue("projects", record.getAttribute("id")));
					//修改下拉值的获取方式
//					Record record1 = getProjectName(BaseHelpUtils.getIntValue(record.getAttribute(id)));
					String projectName = SyncDataUtil.getProjectName(BaseHelpUtils.getIntValue(record.getAttribute(id)));
//					String projectName = BaseHelpUtils.getString(record1.getAttribute("projectName"));
					record.setAttribute("code",projectName);

					record.setAttribute("distributionAmount", distributionItem.getValue());
					DataEditEvent dee = new DataEditEvent();
					dee.setData(record);
					fireEvent(dee);
					if(null == getParent()){
						return;
					}
					getParent().destroy();
				}
			}
		});
		
		IButton cancelButton = new IButton("取消");
		cancelButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(null == getParent()){
							return;
						}
						getParent().destroy();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});

		navLayout = new ToolStrip();
		navLayout.setPadding(5);
		navLayout.setHeight(40);
		navLayout.setWidth100();
		navLayout.addFill();
		navLayout.setBackgroundColor("#f60");
		navLayout.setBorder("none");
		navLayout.setMembersMargin(15);
		navLayout.addMembers(sureButton, cancelButton);
		
		addMember(navLayout);	
	}

	public Window getParent() {
		return parent;
	}
	public void setParent(Window parent) {
		this.parent = parent;
	}
	
	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}
	
	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	public void startEdit(){
		if(null != projectMap && null != projectIdItem){
			projectIdItem.setValueMap(projectMap);
		}
		if(null != distributionAmount && null != distributionItem){
			distributionItem.setValue(distributionAmount);
		}
	}
	
	public boolean checkData(){
		if(null == projectIdItem.getValue()){
			SC.say("订单不能为空");
			return false;
		}
		return true;
	}
	/**
	 * 获取项目的名称
	 * @param projectId
	 * @return
	 */
	private Record getProjectName(Integer projectId){
		Record record = new Record();
		HashMap<Object, Object> map = new HashMap<>();
		map.put("projectId",projectId);
		DBDataSource.callOperation("ST_Project", "find", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record[] records = dsResponse.getData();
					if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
						//获取项目名称
						String projectName = BaseHelpUtils.getString(records[0].getAttribute("projectName"));
						record.setAttribute("projectName",projectName);
					}
				}
			}
		});
		return record;
	}

	public LinkedHashMap<Integer, String> getProjectMap() {
		return projectMap;
	}

	public void setProjectMap(LinkedHashMap<Integer, String> projectMap) {
		this.projectMap = projectMap;
	}

	public BigDecimal getDistributionAmount() {
		return distributionAmount;
	}

	public void setDistributionAmount(BigDecimal distributionAmount) {
		this.distributionAmount = distributionAmount;
	}
	
}
