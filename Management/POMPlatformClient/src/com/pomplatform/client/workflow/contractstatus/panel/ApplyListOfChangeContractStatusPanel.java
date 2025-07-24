package com.pomplatform.client.workflow.contractstatus.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.process.SystemProcessConstants;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.EditProcessWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.workflow.contractstatus.datasource.DSApplyListOfChangeContractStatus;
import com.pomplatform.client.workflow.contractstatus.form.ApplyListOfChangeContractStatusSearchForm;
import com.pomplatform.client.workflow.panel.MyCostAllocationDesignPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ApplyListOfChangeContractStatusPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	private Integer processType;
	private Integer activityType;
	private IButton editButton;
	private IButton deleteButton;
	
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ApplyListOfChangeContractStatusPanel cm = new ApplyListOfChangeContractStatusPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ApplyListOfChangeContractStatus";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
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

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		
		editButton = new IButton("撤销修改");
		controlLayout.addMember(editButton);
		editButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("please select a record to edit");
							return;
						}
						ListGridRecord selected = resultGrid.getSelectedRecord();
						int status = selected.getAttributeAsInt("processStatus");
						if (status != 0) {
							SC.say("对不起，该申请不能修改！");
							return;
						}
						EditProcessWindow Reimbursement = new EditProcessWindow();
						Reimbursement.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								DBDataSource.copyRecord(event.getData(), resultGrid.getSelectedRecord());
								resultGrid.redraw();
							}
						});
						Reimbursement.setLayoutMode(0);
						Reimbursement.setProcessId(selected.getAttributeAsInt("processId"));
						Reimbursement.setInstanceData(selected);
						Reimbursement.initComponents();
						Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
						Reimbursement.setWidth("60%");
						Reimbursement.setHeight100();
						Reimbursement.centerInPage();
						Reimbursement.show();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
				
			}
		});
		
		deleteButton = new IButton("删除", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("请选择一条记录，再点击删除按钮");
							return;
						}
						SC.confirm("确定要删除这条记录吗？", new BooleanCallback() {
							
							@Override
							public void execute(Boolean value) {
								if(value){
									Record record = resultGrid.getSelectedRecords()[0];
									if(null != record.getAttribute("processStatus") && record.getAttribute("processStatus").toString().equals("0")){
										Map<String,Object> map = new HashMap<>();
										map.put("optType", "deletePersonnelBusiness");
										if(null != record.getAttribute("processInstanceId")){
											int processInstanceId = ClientUtil.checkAndGetIntValue(record.getAttribute("processInstanceId"));
											if(processInstanceId > 0){
												map.put("processInstanceId", processInstanceId);
											}else{
												return;
											}
										}else{
											return;
										}
										if(null != record.getAttribute("businessId")){
											int businessId = ClientUtil.checkAndGetIntValue(record.getAttribute("businessId"));
											if(businessId > 0){
												map.put("businessId", businessId);
											}else{
												return;
											}
										}else{
											return;
										}
										DBDataSource.callOperation("EP_DeleteWrokflowProcessor", map, new DSCallback() {
											@Override
											public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
												if (dsResponse.getStatus() < 0) {
													ClientUtil.displayErrorMessage(dsResponse);
												} else {
													commonQuery();
												}
											}
										});
									}else{
										SC.say("抱歉，该记录无法删除！");
										return;
									}
								}
							}
						});
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say("请按Ctrl+F5刷新页面再操作");
					}
				});
				
			}
		});
		controlLayout.addMember(deleteButton);
	}

	public void showDetail() {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
			}
			@Override
			public void onSuccess() {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				ListGridRecord selected = resultGrid.getSelectedRecord();
                ViewProcessWindow Reimbursement = new ViewProcessWindow();
                Reimbursement.setLayoutMode(0);
                Reimbursement.setInstanceData(selected);
                Reimbursement.initComponents();
                Reimbursement.setWidth("60%");
                Reimbursement.setHeight100();
                Reimbursement.centerInPage();
                Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
                Reimbursement.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		List<Map<String, String>> list = new ArrayList<>();
		if (!BaseHelpUtils.isNullOrEmpty(processType)) {
			criteria.put("processType", processType);
		}
		if (Objects.equals(activityType, MyCostAllocationDesignPanel.ACTIVITY_TYPE_1)) {
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "and spi.process_status = ?");
			kv.put("value",
					"and spi.process_status = ? and spi.process_status in ("
							+ SystemProcessConstants.PROCESS_STATUS_NEW_CREATED + ", "
							+ SystemProcessConstants.PROCESS_STATUS_WORKING + ")");
			list.add(kv);
		} else if (Objects.equals(activityType, MyCostAllocationDesignPanel.ACTIVITY_TYPE_2)
				|| Objects.equals(activityType, MyCostAllocationDesignPanel.ACTIVITY_TYPE_3)) {
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "and spi.process_status = ?");
			kv.put("value",
					"and spi.process_status = ? and spi.process_status in ("
							+ SystemProcessConstants.PROCESS_STATUS_COMPLETED + ", "
							+ SystemProcessConstants.PROCESS_STATUS_REJECT + ")");
			list.add(kv);
		}
		if(!list.isEmpty()) {
			criteria.put("keyValues", list);
		}
		criteria.put("operator", ClientUtil.getUserId());
		criteria.put("deleteFlag", ClientStaticUtils.NO_DELETE);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ApplyListOfChangeContractStatusSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSApplyListOfChangeContractStatus.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 70;
	}
	
	public void resetDataSource() {
		if(Objects.equals(activityType, MyCostAllocationDesignPanel.ACTIVITY_TYPE_2) || Objects.equals(activityType, MyCostAllocationDesignPanel.ACTIVITY_TYPE_3)) {
			editButton.hide();
			deleteButton.hide();
			getDataSource().getField("processStatus").setHidden(false);
		}
	}
	
	public Integer getProcessType() {
		return processType;
	}

	public void setProcessType(Integer processType) {
		this.processType = processType;
	}

	public Integer getActivityType() {
		return activityType;
	}

	public void setActivityType(Integer activityType) {
		this.activityType = activityType;
	}

}

