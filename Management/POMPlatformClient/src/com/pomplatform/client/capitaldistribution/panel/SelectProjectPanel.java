package com.pomplatform.client.capitaldistribution.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.capitaldistribution.datasource.DSProjectCapitalDistribution;
import com.pomplatform.client.common.ClientStaticUtils;
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
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class SelectProjectPanel extends VLayout implements HasHandlers {

	private static final Logger logger = Logger.getLogger("");
	private final DelicacyListGrid grid;
	private final IButton saveButton;
	private final IButton cancelButton;
	private final HLayout buttonLayout;
	private Window parentWindow;
	private String contractId;
	protected final HandlerManager handlerManager = new HandlerManager(this);

	public SelectProjectPanel(String ids) {
		setWidth100();
		setHeight100();
		
		ListGridField[] fields = new ListGridField[8];
		int idx = 0;
		fields[idx++] = new ListGridField("plateId");
		fields[idx] = new ListGridField("code");
		fields[idx++].setMinWidth(220);
		fields[idx] = new ListGridField("projectId");
		fields[idx++].setMinWidth(300);
		fields[idx++] = new ListGridField("sheetAmount");//订单合同金额
		fields[idx++] = new ListGridField("distributedAmount");//已分配金额
		fields[idx++] = new ListGridField("leftAmount");//剩余可分配积分
		fields[idx++] = new ListGridField("projectIntegral");//订单积分
		fields[idx++] = new ListGridField("sureIntegral");//确认积分
		
		grid = new DelicacyListGrid();
		grid.setShowRowNumbers(true);
		grid.setDataSource(DSProjectCapitalDistribution.getInstance());
		grid.setAutoFitFieldWidths(false);
		grid.setCanSelectText(true);
		grid.setFields(fields);
		grid.setHeight("90%");
		addMember(grid);

		saveButton = new IButton("确定", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!grid.anySelected()){
							SC.say("请至少选择一个订单，再点击确定按钮");
							return;
						}
						Record[] records = grid.getSelectedRecords();
						StringBuilder sb = new StringBuilder();
						for(Record record : records){
							if(sb.length() > 0){
								sb.append(",");
							}
							sb.append(record.getAttribute("projectId"));
						}
						saveData(ids, sb.toString());
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
						return;
					}
				});
			}
		});

		cancelButton = new IButton("取消", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (null == getParentWindow()) {
					return;
				}
				getParentWindow().destroy();
			}
		});
		
		buttonLayout = new HLayout();
		buttonLayout.setWidth100();
		buttonLayout.setHeight("8%");
		buttonLayout.setLayoutTopMargin(10);
		buttonLayout.setMembersMargin(20);
		buttonLayout.setAlign(Alignment.RIGHT);
		buttonLayout.addMember(saveButton);
		buttonLayout.addMember(cancelButton);

		addMember(buttonLayout);

	}

	public void loadData(){
		Map<String, String> params = new HashMap<>();
		params.put("contractId", contractId);
		params.put("optType", "getAllDistribution");
		DBDataSource.callOperation("EP_CapitalDistributionProcessor", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				grid.setData(dsResponse.getData());
			}
		});
	}
	
	public void saveData(String ids, String projectIds){
		Map<String, Object> params = new HashMap<>();
		params.put("ids", ids);
		params.put("optType", "autoFitByProjectSheetAmount");
		params.put("projectIds", projectIds);
		params.put("operator", ClientUtil.getUserId());
		params.put("operatorName", ClientUtil.getUserName());
		DBDataSource.callOperation("EP_CapitalDistributionProcessor", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() < 0){
					ClientUtil.displayErrorMessage(dsResponse);
				}else{
					SC.say("操作成功");
					DataEditEvent event = new DataEditEvent();
					handlerManager.fireEvent(event);
					if(null == parentWindow){
						return;
					}
					parentWindow.destroy();
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

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	
}
