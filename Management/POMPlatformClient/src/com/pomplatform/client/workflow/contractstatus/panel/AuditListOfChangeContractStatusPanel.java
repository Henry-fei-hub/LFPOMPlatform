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
import com.delicacy.client.ui.ApprovalmentWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PooledTaskWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.workflow.contractstatus.datasource.DSAuditListOfChangeContractStatus;
import com.pomplatform.client.workflow.contractstatus.form.AuditListOfChangeContractStatusSearchForm;
import com.pomplatform.client.workflow.panel.MyCostAllocationDesignPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
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

public class AuditListOfChangeContractStatusPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	private Integer processType;
	private Integer activityType;
	private static IButton auditButton;
	private static IButton agreeButton;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			AuditListOfChangeContractStatusPanel cm = new AuditListOfChangeContractStatusPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "AuditListOfChangeContractStatus";
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
		
		auditButton = new IButton("审批");
		controlLayout.addMember(auditButton);
		auditButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	generateAuditPanel();
            }
        });
        
        agreeButton = new IButton("批量审批");
		controlLayout.addMember(agreeButton);
        agreeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	final ListGridRecord[] records = resultGrid.getSelection();
            	if(null != records && records.length > 0){
            		SC.confirm("您确定已经要进行批量操作吗？", new BooleanCallback() {
                        @Override
                        public void execute(Boolean value) {
                            if (value) {
                                submit(records, 0);
                            }
                        }
                    });
            	}else{
                    SC.say("please select a record");
                    return;
                }
            }
        });
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
                Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
                Reimbursement.setWidth("60%");
                Reimbursement.setHeight100();
                Reimbursement.centerInPage();
                Reimbursement.show();
			}
		});
	}

	private int successSize = 0;
	public void submit(ListGridRecord[] records, int approvalment) {
		if(null != records){
			successSize = 0;
			for(ListGridRecord record: records){
				if(ClientUtil.checkAndGetIntValue(record.getAttribute("activityType")) == 3){
					SC.say("对不起，处理节点不支持批量审批");
					return;
				}
				record.setAttribute("contractLogId", record.getAttribute("businessId"));
				final int recordSize = records.length;
				Map params = record.toMap();
				params.put("approvalment", approvalment);
				params.put("userData", record.toMap());
				String operationName = null;
				if(BaseHelpUtils.getIntValue(record.getAttributeAsObject("typeFlag")) == ClientStaticUtils.ACTIVITY_TYPE_FLAG_POOL) {
					operationName = "EP_WorkFlowPooledTaskProcessor";
				}else {
					operationName = "EP_WorkFlowActivityProcessor";
				}
				DBDataSource.callOperation(operationName, params, new DSCallback() {
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
	
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		List<Map<String, String>> list = new ArrayList<>();
		if (!BaseHelpUtils.isNullOrEmpty(processType)) {
			criteria.put("processType", processType);
		}
		if (Objects.equals(activityType, MyCostAllocationDesignPanel.ACTIVITY_TYPE_4)) {
			criteria.put("status", SystemProcessConstants.ACTIVITY_STATUS_ACTIVE);
		} else if (Objects.equals(activityType, MyCostAllocationDesignPanel.ACTIVITY_TYPE_7)) {
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "AND spia.status = ?");
			kv.put("value",
					"AND spia.status = ? and spia.status in ("
							+ SystemProcessConstants.ACTIVITY_STATUS_PASS + ", "
							+ SystemProcessConstants.ACTIVITY_STATUS_REJECT + ", "
							+ SystemProcessConstants.ACTIVITY_STATUS_RETURN_FIRST + ", "
							+ SystemProcessConstants.ACTIVITY_STATUS_RETURN_LAST + ", "
							+ SystemProcessConstants.ACTIVITY_STATUS_REASSIGN + ")");
			list.add(kv);
			Map<String, String> kv2 = new HashMap<>();
			kv2.put("key", "AND sppt.status = ?");
			kv2.put("value",
					"AND sppt.status = ? and sppt.status = " + SystemProcessConstants.POOLED_TASK_STATUS_DONE + "");
			list.add(kv2);
		}
		if(!list.isEmpty()) {
			criteria.put("keyValues", list);
		}
		criteria.put("employeeId", ClientUtil.getUserId());
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new AuditListOfChangeContractStatusSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSAuditListOfChangeContractStatus.getInstance();
	}

	public void resetDataSource() {
		DataSource ds = getDataSource();
		if(Objects.equals(activityType, MyCostAllocationDesignPanel.ACTIVITY_TYPE_7)){//如果是已审核，则隐藏审批按钮
			agreeButton.hide();
			auditButton.hide();
			ds.getField("operateTime").setHidden(false);
			ds.getField("processComment").setHidden(false);
			ds.getField("status").setHidden(false);
		}else{
			ds.getField("operateTime").setHidden(true);
			ds.getField("processComment").setHidden(true);
			resultGrid.setSelectionType(SelectionStyle.SIMPLE);  
			resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		}
	}
	
	public void generateAuditPanel() {
		if(resultGrid.anySelected()){
    		ListGridRecord selected = resultGrid.getSelectedRecords()[0];
    		if(BaseHelpUtils.getIntValue(selected.getAttributeAsObject("typeFlag")) == ClientStaticUtils.ACTIVITY_TYPE_FLAG_POOL) {
    			//	任务池审批
    			PooledTaskWindow Reimbursement = new PooledTaskWindow();
				Reimbursement.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				Reimbursement.setLayoutMode(0);
				Reimbursement.setInstanceData(selected);
				Reimbursement.setProcessId(ClientUtil.checkAndGetIntValue(selected.getAttribute("processId")));
				Reimbursement.initComponents();
				Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
				Reimbursement.setWidth("60%");
				Reimbursement.setHeight100();
				Reimbursement.centerInPage();
				Reimbursement.show();
    		}else {
    			//	普通节点审批
    			ApprovalmentWindow Reimbursement = new ApprovalmentWindow();
    			Reimbursement.addDataEditedHandler(new DataEditedHandler(){
    				@Override
    				public void onDataEdited(DataEditEvent event) {
						commonQuery();
    				}
    			});
    			Reimbursement.setLayoutMode(0);
    			Reimbursement.setInstanceData(selected);
    			Reimbursement.initComponents();
    			Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
    			Reimbursement.setWidth("60%");
    			Reimbursement.setHeight100();
    			Reimbursement.centerInPage();
    			Reimbursement.show();
    		}
    	}else{
            SC.say("please select a record to edit");
            return;
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

