package com.pomplatform.client.capitaldistribution.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
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
import com.pomplatform.client.common.ClientStaticUtils;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class SelectContractAttachmentPanel extends VLayout implements HasHandlers {

	private static final Logger logger = Logger.getLogger("");
	private final DelicacyListGrid grid;
	private final IButton saveButton;
	private final IButton cancelButton;
	private final HLayout buttonLayout;
	private Window parentWindow;
	private String contractId;
	protected final HandlerManager handlerManager = new HandlerManager(this);

	public SelectContractAttachmentPanel(String ids) {
		setWidth100();
		setHeight100();
		
		ListGridField[] fields = new ListGridField[5];
		int idx = 0;
		fields[idx++] = new ListGridField("attachmentCode", "编号");
		fields[idx++] = new ListGridField("perfessionRemark", "专业备注");
		fields[idx++] = new ListGridField("recordDate", "记录日期");
		fields[idx] = new ListGridField("amount", "金额");
		fields[idx].setFormat("#,###,###,###,###,##0.00");
		fields[idx++].setType(ListGridFieldType.FLOAT);
		fields[idx] = new ListGridField("returnAmount", "回款金额");
		fields[idx].setFormat("#,###,###,###,###,##0.00");
		fields[idx++].setType(ListGridFieldType.FLOAT);
		
		grid = new DelicacyListGrid();
		grid.setAutoFitFieldWidths(false);
		grid.setCanSelectText(true);
		grid.setSelectionType(SelectionStyle.SINGLE);
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
							SC.say("请选择一份确认函，再点击确定按钮");
							return;
						}
						Record record = grid.getSelectedRecords()[0];
						saveData(ids, record.getAttributeAsDate("recordDate"));
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
		
		IButton w = new IButton("手动输入时间");
		w.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						SC.askforValue("请输入时间", new ValueCallback() {
							
							@Override
							public void execute(String value) {
								GWT.runAsync(new RunAsyncCallback() {
									
									@Override
									public void onSuccess() {
										Date date = new Date();
										String[] arr = value.split("-");
										if(null != arr && arr.length == 3){
											date = new Date(date.UTC(BaseHelpUtils.getIntValue(arr[0]) - 1900, BaseHelpUtils.getIntValue(arr[1]) - 1, BaseHelpUtils.getIntValue(arr[2]), 0, 0, 0));
										}else{
											arr = value.split("/");
											if(null != arr && arr.length == 3){
												date = new Date(date.UTC(BaseHelpUtils.getIntValue(arr[0]) - 1900, BaseHelpUtils.getIntValue(arr[1]) - 1, BaseHelpUtils.getIntValue(arr[2]), 0, 0, 0));
											}else{
												SC.say("请输入正确的时间");
												return;
											}
										}
										saveData(ids, date);
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
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		buttonLayout = new HLayout();
		buttonLayout.setWidth100();
		buttonLayout.setHeight("8%");
		buttonLayout.setLayoutTopMargin(10);
		buttonLayout.setMembersMargin(20);
		buttonLayout.setAlign(Alignment.RIGHT);
		buttonLayout.addMember(w);
		buttonLayout.addMember(saveButton);
		buttonLayout.addMember(cancelButton);

		addMember(buttonLayout);

	}

	public void loadData(){
		Map<String, String> params = new HashMap<>();
		params.put("contractId", contractId);
		DBDataSource.callOperation("ST_AttachmentManage", "find", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() < 0){
					ClientUtil.displayErrorMessage(dsResponse);
				}else{
					grid.setData(dsResponse.getData());
				}
			}
		});
	}
	
	public void saveData(String ids, Date date){
		Map<String, Object> params = new HashMap<>();
		params.put("ids", ids);
		params.put("optType", "autoFit");
		params.put("date", date);
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
