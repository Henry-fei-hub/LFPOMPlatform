package com.pomplatform.client.scapitaldistributionor.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.EditProcessWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.scapitaldistributionor.datasource.DSCapitalDistributionsApplyOfWorkflow;
import com.pomplatform.client.scapitaldistributionor.form.CapitalDistributionsApplyOfWorkflowSearchForm;
import com.pomplatform.client.workflow.panel.MyWorkflowDesignPanel;
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

public class CapitalDistributionsApplyOfWorkflowPanel extends AbstractSearchPanel {

	@SuppressWarnings("unused")
	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			CapitalDistributionsApplyOfWorkflowPanel cm = new CapitalDistributionsApplyOfWorkflowPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "CapitalDistributionsApplyOfWorkflow";
		}

	}

	@Override
	public void init() {
//		super.init();
		resultGrid = new DelicacyListGrid(){
			 @Override
			 protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				 if(BaseHelpUtils.getIntValue(record.getAttribute("processStatus"))==5) {
					 return "font-weight:bold; color:#4fabff;";  
				 }else {
					 return "font-weight:bold; color:#555555;";  
				 }
			 }
		 };
    	resultGrid.setDataSource(getDataSource());
    	resultGrid.setShowRowNumbers(true);
        __layoutMode = LayoutConstant.LEFTRIGHT;
        __detailCanvas = new ArrayList<>();
        __controlPosition = LayoutConstant.RIGHT;
        __needPagenation = true;
        __needControl = true;
        __needViewPage = true;
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		// refreshButton.setIcon("[SKIN]/actions/refresh.png");
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
		// IButton operation1Button = new IButton("查看详情");
		// controlLayout.addMember(operation1Button);
		// operation1Button.setIcon("[SKIN]/actions/view.png");
		// operation1Button.addClickHandler(new ClickHandler(){
		// @Override
		// public void onClick(ClickEvent event) {
		// showDetail();
		// }
		// });
		IButton editButton = new IButton("撤销修改");
		controlLayout.addMember(editButton);
		editButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
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
				EditProcessWindow editWindow = new EditProcessWindow();
				editWindow.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						DBDataSource.copyRecord(event.getData(), resultGrid.getSelectedRecord());
						resultGrid.redraw();
					}
				});
				editWindow.setLayoutMode(0);
				editWindow.setProcessId(selected.getAttributeAsInt("processId"));
				editWindow.setInstanceData(selected);
				editWindow.initComponents();
				editWindow.setTitle(ClientUtil.getProcessTypeName(selected));
				editWindow.show();
			}
		});

		IButton deleteButton = new IButton("删除", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("please select a record to delete");
					return;
				}
				SC.ask("确认删除", new BooleanCallback() {

					@Override
					public void execute(Boolean value) {
						if (value) {
							Record record = resultGrid.getSelectedRecords()[0];
							if (null != record.getAttribute("processStatus")
									&& record.getAttribute("processStatus").toString().equals("0")) {
								Map<String, Object> map = new HashMap<>();
								map.put("optType", "deleteCapitalDistributions");
								if (null != record.getAttribute("processInstanceId")) {
									int processInstanceId = ClientUtil
											.checkAndGetIntValue(record.getAttribute("processInstanceId"));
									if (processInstanceId > 0) {
										map.put("processInstanceId", processInstanceId);
									} else {
										return;
									}
								} else {
									return;
								}
								if (null != record.getAttribute("businessId")) {
									int businessId = ClientUtil.checkAndGetIntValue(record.getAttribute("businessId"));
									if (businessId > 0) {
										map.put("businessId", businessId);
									} else {
										return;
									}
								} else {
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
							} else {
								SC.say("Sorry, this record could not be deleted");
								return;
							}
						}
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
				if (!resultGrid.anySelected()) {
					SC.say("please select a record to edit");
					return;
				}
				ListGridRecord selected = resultGrid.getSelectedRecord();
				ViewProcessWindow Reimbursement = new ViewProcessWindow();
				Reimbursement.setWidth("80%");
				Reimbursement.setHeight("80%");
				Reimbursement.setLayoutMode(0);
				Reimbursement.setInstanceData(selected);
				Reimbursement.initComponents();
				Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
				Reimbursement.show();
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		List<Map> keyvalues = new ArrayList<>();
		criteria.put("employeeId", ClientUtil.getEmployeeId());
		criteria.put("processType", processType);
		if(!BaseHelpUtils.isNullOrEmpty(status)) {
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "spi.process_status in(0,1)");
			kv.put("value", status);
			keyvalues.add(kv);
			
		}
/*		if (activityType == MyWorkflowDesignPanel.ACTIVITY_TYPE_2) {// 已驳回
			List<Map> keyvalues = new ArrayList<>();
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "spi.process_status IN (0, 1)");
			kv.put("value", "spi.process_status = 5");
			keyvalues.add(kv);
			criteria.put("keyValues", keyvalues);
		} else if (activityType == MyWorkflowDesignPanel.ACTIVITY_TYPE_3) {// 已完成
			List<Map> keyvalues = new ArrayList<>();
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "spi.process_status IN (0, 1)");
			kv.put("value", "spi.process_status = 3");
			keyvalues.add(kv);
			criteria.put("keyValues", keyvalues);
		}
		criteria.put("addtionalCondition", "order by process_instance_id");*/
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new CapitalDistributionsApplyOfWorkflowSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSCapitalDistributionsApplyOfWorkflow.getInstance();
	}

	private int activityType;
	private int processType;
	private String status;
	public int getActivityType() {
		return activityType;
	}

	public void setActivityType(int activityType) {
		this.activityType = activityType;
	}

	public int getProcessType() {
		return processType;
	}

	public void setProcessType(int processType) {
		this.processType = processType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
