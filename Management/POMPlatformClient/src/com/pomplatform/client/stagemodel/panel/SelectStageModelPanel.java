package com.pomplatform.client.stagemodel.panel;

import java.awt.image.DataBufferDouble;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.stagemodel.datasource.DSStageModelTree;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;

public class SelectStageModelPanel extends AbstractSearchPanel implements HasHandlers {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	protected final HandlerManager handlerManager = new HandlerManager(this);
	
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ContractStageModelListPanel cm = new ContractStageModelListPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ContractStageModelList";
		}

	}
	
	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needPagenation = false;
	}
	
	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		ListGridField[] fields = new ListGridField[1];
		int idx = 0;
		fields[idx] = new ListGridField("stageModelName");
		resultGrid.setFields(fields);
		
		IButton okButton = new IButton("选定");
		controlLayout.addMember(okButton);
		okButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请选择一个模板");
							return;
						}
						StringBuilder sb = new StringBuilder();
						for(Record record : resultGrid.getSelectedRecords()){
							if(BaseHelpUtils.getIntValue(record.getAttributeAsObject("stageModelId")) > 0){
								if(sb.length() > 0){
									sb.append(",");
								}
								sb.append(record.getAttributeAsObject("stageModelId"));
							}
						}
						Map<String, Object> params = new HashMap<>();
						params.put("optType", "createNewContractStageModel");
						params.put("contractId", contractId);
						params.put("stageModelId", sb.toString());
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
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("parentId", "0");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSStageModelTree.getInstance();
	}
	
	private Window parentWindow;
	private String contractId;

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	
	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}
}
