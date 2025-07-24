package com.pomplatform.client.stagemodel.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridMyProjectValue;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class SelectProjectEmployeePanel extends VLayout implements HasHandlers {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	protected final HandlerManager handlerManager = new HandlerManager(this);
	private DynamicForm __form;
	private ComboBoxItem projectItem;
	
	public void initComponents() {
		setLayoutTopMargin(20);
		setLayoutLeftMargin(20);
		setLayoutRightMargin(17);
		__form = new DynamicForm();
		__form.setWidth100();
		__form.setHeight(90);
		//项目信息字段
		ListGridField plateIdField = new ListGridField("plateId");
		plateIdField.setWidth(100);
		ListGridField projectIdField = new ListGridField("projectId");
//		ListGridField projectNameField = new ListGridField("projectName");
		ListGridField contractCodeField = new ListGridField("contractCode");
		contractCodeField.setWidth(250);
		ListGridField plateManagerIdField = new ListGridField("plateManagerId");
		plateManagerIdField.setWidth(100);
		ListGridField projectManageIdField = new ListGridField("projectManageId");
		projectManageIdField.setWidth(100);
		
		Criteria c = new Criteria();
		c.addCriteria("contractId", contractId);
				
		projectItem = new ComboBoxItem("projectId", "请选择一个订单");
		projectItem.setWidth(550);
		projectItem.setChangeOnKeypress(false);
		projectItem.setOptionDataSource(DSSelectGridMyProjectValue.getInstance());
		projectItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectItem.setValueField(projectIdField.getName());
		projectItem.setDisplayField(contractCodeField.getName());
		projectItem.setPickListFields(plateIdField, projectManageIdField, plateManagerIdField, contractCodeField);
		projectItem.setPickListCriteria(c);
		projectItem.setPickListWidth(550);
		projectItem.setTitleOrientation(TitleOrientation.TOP);
		projectItem.setTitleAlign(Alignment.LEFT);
		__form.setItems(projectItem);
		addMember(__form);
		
		IButton saveButton = new IButton("确定", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(null == projectItem.getValue()){
							SC.say("请选择 一个订单");
							return;
						}
						if(BaseHelpUtils.isNullOrEmpty(ids)){
							SC.say("请选择需要指定项目经理的节点");
							return;
						}
						Map<String, Object> params = new HashMap<>();
						params.put("optType", "selectProjectEmployeeAsManager");
						params.put("projectId", projectItem.getValue());
						params.put("ids", ids);
						DBDataSource.callOperation("EP_StageModelProcessor", params, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() >= 0){
									DataEditEvent dee = new DataEditEvent();
									fireEvent(dee);
									if (null == getParentWindow()) {
										return;
									}
									getParentWindow().destroy();
								}else{
									ClientUtil.displayErrorMessage(dsResponse);
								}
							}
						});
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});

		IButton cancelButton = new IButton("取消", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (null == getParentWindow()) {
					return;
				}
				getParentWindow().destroy();
			}
		});
		HLayout buttonLayout = new HLayout();
		buttonLayout.setWidth100();
		buttonLayout.setHeight(30);
		buttonLayout.setMargin(8);
		buttonLayout.setMembersMargin(20);
		buttonLayout.setAlign(Alignment.CENTER);
		buttonLayout.addMember(saveButton);
		buttonLayout.addMember(cancelButton);

		addMember(buttonLayout);
		
	}

	private Window parentWindow;
	private String contractId;
	private String ids;

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

}
