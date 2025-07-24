package com.pomplatform.client.workflow.panel;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.ApprovalmentWindow;
import com.delicacy.client.ui.AttentionWindow;
import com.delicacy.client.ui.EditProcessWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PooledTaskWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.workflow.datasource.DSOnLoadPersonnelFlowDetail;
import com.pomplatform.client.workflow.form.OnLoadPersonnelFlowDetailSearchForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
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

public class OnLoadPersonnelFlowDetailPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	private static IButton editButton;//编辑按钮
	private static IButton auditButton;//审批按钮
	private static IButton batchAuditButton;//批量审批按钮
	private static IButton agreeButton;//同意按钮
	private static IButton batchAgreeButton;//批量同意按钮
	private static IButton taskAuditButton;//任务池审批按钮
	private static IButton batchTaskAuditButton;//任务池批量审批按钮
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnLoadPersonnelFlowDetailPanel cm = new OnLoadPersonnelFlowDetailPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnLoadPersonnelFlowDetail";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
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
				Reimbursement.show();
			}
		});
		
		//审批开始模块******************************************
		auditButton = new IButton("审批");
		controlLayout.addMember(auditButton);
		auditButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	ListGridRecord[] records = resultGrid.getSelection();
            	if(null != records && records.length > 0){
            		ListGridRecord selected = records[0];
                    ApprovalmentWindow Reimbursement = new ApprovalmentWindow();
                    Reimbursement.addDataEditedHandler(new DataEditedHandler(){
                        @Override
                        public void onDataEdited(DataEditEvent event) {
                            commonQuery();
                        }
                    });
                    Reimbursement.setWidth("80%");
                    Reimbursement.setHeight("80%");
                    Reimbursement.setLayoutMode(0);
                    Reimbursement.setInstanceData(selected);
                    Reimbursement.initComponents();
                    Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
                    Reimbursement.show();
            	}else{
                    SC.say("please select a record to edit");
                    return;
                }
            }
        });
        
		batchAuditButton = new IButton("批量审批");
		controlLayout.addMember(batchAuditButton);
		batchAuditButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	final ListGridRecord[] records = resultGrid.getSelection();
            	if(null != records && records.length > 0){
            		SC.confirm("您确定已经要进行批量操作吗？", new BooleanCallback() {
                        @Override
                        public void execute(Boolean value) {
                            if (value) {
                            	if(null != records){
                        			for(ListGridRecord record: records){
                        				final int recordSize = records.length;
                        				Map params = record.toMap();
                        				params.put("approvalment", 0);
                        				DBDataSource.callOperation("EP_WorkFlowActivityProcessor", params, new DSCallback() {
                        					@Override
                        					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        						if (dsResponse.getStatus() >= 0) {
                        							successSize++;
                        							if(recordSize == successSize){
                        								commonQuery();
                        							}
                        						}else{
                        							SC.say(dsResponse.getErrors().get("errorMsg").toString());
                        							return;
                        						}
                        					}
                        				});
                        			}
                        		}
                            }
                        }
                    });
            	}else{
                    SC.say("please select a record");
                    return;
                }
            }
        });
		//审批 结束模块******************************************
		
		//知会审批 开始模块***************************************
		agreeButton = new IButton("批阅");
		controlLayout.addMember(agreeButton);
		agreeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	if (!resultGrid.anySelected()) {
                    SC.say("please select a record to edit");
                    return;
                }
                ListGridRecord selected = resultGrid.getSelectedRecord();
                AttentionWindow Reimbursement = new AttentionWindow();
                Reimbursement.addDataEditedHandler(new DataEditedHandler() {
                    @Override
                    public void onDataEdited(DataEditEvent event) {
                        commonQuery();
                    }

                });
                Reimbursement.setWidth("80%");
                Reimbursement.setHeight("80%");
                Reimbursement.setLayoutMode(0);
                Reimbursement.setInstanceData(selected);
                Reimbursement.initComponents();
                Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
                Reimbursement.show();
            }
        });
        
		batchAgreeButton = new IButton("批量已阅");
        controlLayout.addMember(batchAgreeButton);
        batchAgreeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	final ListGridRecord[] records = resultGrid.getSelection();
            	if(null != records && records.length > 0){
            		SC.confirm("您确定已经要进行批量操作吗？", new BooleanCallback() {
                        @Override
                        public void execute(Boolean value) {
                            if (value) {
                            	if(null != records){
                        			successSize = 0;
                        			for(ListGridRecord record: records){
                        				final int sizeRecord = records.length;
                        				Map params = record.toMap();
                        				params.put("approvalment", 0);
                        				DBDataSource.callOperation("EP_AttentionProcessor", params, new DSCallback() {
                        					@Override
                        					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        						if (dsResponse.getStatus() >= 0) {
                        							successSize++;
                        							if(sizeRecord == successSize){
                        								commonQuery();
                        							}
                        						}else{
                        							SC.say(dsResponse.getErrors().get("errorMsg").toString());
                        							return;
                        						}
                        					}
                        				});
                        			}
                        		}
                            }
                        }
                    });
            	}else{
                    SC.say("please select a record");
                    return;
                }
            }
        });
		//知会审批 结束模块***************************************
		
		//任务池审批 开始模块*************************************
        
        taskAuditButton = new IButton("审批");
		controlLayout.addMember(taskAuditButton);
		taskAuditButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	if (!resultGrid.anySelected()) {
                    SC.say("please select a record to edit");
                    return;
                }
                ListGridRecord selected = resultGrid.getSelectedRecord();
                PooledTaskWindow Reimbursement = new PooledTaskWindow();
                Reimbursement.addDataEditedHandler(new DataEditedHandler() {
                    @Override
                    public void onDataEdited(DataEditEvent event) {
                        commonQuery();
                    }
                });
                Reimbursement.setWidth100();
                Reimbursement.setHeight100();
                Reimbursement.setLayoutMode(0);
                Reimbursement.setInstanceData(selected);
                Reimbursement.setProcessId(ClientUtil.checkAndGetIntValue(selected.getAttribute("processId")));
                Reimbursement.initComponents();
                Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
                Reimbursement.show();
            }
        });
		
		batchTaskAuditButton = new IButton("批量审批");
		controlLayout.addMember(batchTaskAuditButton);
		batchTaskAuditButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	final ListGridRecord[] records = resultGrid.getSelection();
            	if(null != records && records.length > 0){
            		SC.confirm("您确定已经要进行批量操作吗？", new BooleanCallback() {
                        @Override
                        public void execute(Boolean value) {
                            if (value) {
                            	if(null != records){
                        			successSize = 0;
                        			for(ListGridRecord record: records){
                        				final int recordSize = records.length;
                        				Map params = record.toMap();
                        				params.put("approvalment", 0);
                        				DBDataSource.callOperation("EP_WorkFlowPooledTaskProcessor", params, new DSCallback() {
                        					@Override
                        					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        						if (dsResponse.getStatus() >= 0) {
                        							successSize++;
                        							if(recordSize == successSize){
                        								commonQuery();
                        							}
                        						}else{
                        							SC.say(dsResponse.getErrors().get("errorMsg").toString());
                        							return;
                        						}
                        					}
                        				});
                        			}
                        		}
                            }
                        }
                    });
            	}else{
                    SC.say("please select a record");
                    return;
                }
            }
        });
        
		//任务池审批 结束模块*************************************
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
                LinkedHashMap<String, String> map = KeyValueManager.getValueMap("processExecutors");
                for(String key : map.keySet()){
                	__LOGGER.info("===:"+map.get(key));
                }
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
	
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("parentProcessTypeId",PomPlatformClientUtil.PARENT_PROCESS_TYPE_2);
		criteria.put("processType",processType);
		criteria.put("activityType",activityType);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnLoadPersonnelFlowDetailSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadPersonnelFlowDetail.getInstance();
	}

	private int successSize = 0;
	private int processType;
	private int activityType;
	public int getProcessType() {
		return processType;
	}

	@Override
	public void afterDataReceived(Record[] data) {
		String hiddenFields ="";
		if(processType == MyPersonnelFlowDesignPanel.PROCESS_TYPE_13){//请假申请
			hiddenFields = "address,plan,transportation,fee,unit,contactPerson";
		}else if(processType == MyPersonnelFlowDesignPanel.PROCESS_TYPE_14){//出差申请
			hiddenFields = "type,fee,unit,contactPerson";
		}else if(processType == MyPersonnelFlowDesignPanel.PROCESS_TYPE_15){//打卡申请
			hiddenFields = "type,address,plan,transportation,fee,unit,contactPerson";
		}else if(processType == MyPersonnelFlowDesignPanel.PROCESS_TYPE_16){//外出申请
			hiddenFields = "type";
		}else if(processType == MyPersonnelFlowDesignPanel.PROCESS_TYPE_17){//加班申请
			hiddenFields = "type,address,plan,transportation,fee,unit,contactPerson";
		}
		ClientUtil.setHiddenFields(resultGrid, hiddenFields);
	}
	
	public void setProcessType(int processType) {
		this.processType = processType;
	}

	public int getActivityType() {
		return activityType;
	}

	public void setActivityType(int activityType) {
		if(activityType == MyPersonnelFlowDesignPanel.ACTIVITY_TYPE_1 || activityType == MyPersonnelFlowDesignPanel.ACTIVITY_TYPE_2 || activityType == MyPersonnelFlowDesignPanel.ACTIVITY_TYPE_3){//如果是我的发起、我的驳回、我的归档则隐藏其它无关的按钮
			auditButton.hide();
			batchAuditButton.hide();
			agreeButton.hide();
			batchAgreeButton.hide();
			taskAuditButton.hide();
			batchTaskAuditButton.hide();
		}else if(activityType == MyPersonnelFlowDesignPanel.ACTIVITY_TYPE_7 || activityType == MyPersonnelFlowDesignPanel.ACTIVITY_TYPE_8 || activityType == MyPersonnelFlowDesignPanel.ACTIVITY_TYPE_9){//如果是已办，也隐藏其它无关的按钮
			editButton.hide();
			auditButton.hide();
			batchAuditButton.hide();
			agreeButton.hide();
			batchAgreeButton.hide();
			taskAuditButton.hide();
			batchTaskAuditButton.hide();
		}else if(activityType == MyPersonnelFlowDesignPanel.ACTIVITY_TYPE_4){//待办审批
			editButton.hide();
			agreeButton.hide();
			batchAgreeButton.hide();
			taskAuditButton.hide();
			batchTaskAuditButton.hide();
			resultGrid.setSelectionType(SelectionStyle.SIMPLE);  
			resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		}else if(activityType == MyPersonnelFlowDesignPanel.ACTIVITY_TYPE_5){//待办知会审批
			auditButton.hide();
			batchAuditButton.hide();
			taskAuditButton.hide();
			batchTaskAuditButton.hide();
			resultGrid.setSelectionType(SelectionStyle.SIMPLE);  
			resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		}else if(activityType == MyPersonnelFlowDesignPanel.ACTIVITY_TYPE_6){//待办任务池审批
			auditButton.hide();
			batchAuditButton.hide();
			agreeButton.hide();
			batchAgreeButton.hide();
			resultGrid.setSelectionType(SelectionStyle.SIMPLE);  
			resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		}
		this.activityType = activityType;
	}
	

}

