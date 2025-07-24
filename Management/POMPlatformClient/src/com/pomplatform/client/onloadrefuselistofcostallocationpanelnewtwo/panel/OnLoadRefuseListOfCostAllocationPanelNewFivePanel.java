package com.pomplatform.client.onloadrefuselistofcostallocationpanelnewtwo.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PooledTaskWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.onloadrefuselistofcostallocationpanelnewtwo.datasource.DSOnLoadRefuseListOfCostAllocationPanelNewFive;
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

public class OnLoadRefuseListOfCostAllocationPanelNewFivePanel extends AbstractSearchPanel
{
	private static IButton taskAuditButton;
	private static IButton batchTaskAuditButton;

	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnLoadRefuseListOfCostAllocationPanelNewFivePanel cm = new OnLoadRefuseListOfCostAllocationPanelNewFivePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnLoadRefuseListOfCostAllocationPanelNewFive";
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
                        				if(ClientUtil.checkAndGetIntValue(record.getAttribute("activityType")) == 3){
                        					SC.say("对不起，处理节点不支持批量审批");
                        					return;
                        				}
                        				record.setAttribute("resetCostId", record.getAttribute("businessId"));
                        				final int recordSize = records.length;
                        				Map params = record.toMap();
                        				params.put("approvalment", 0);
                        				params.put("userData", record.toMap());
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
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("employeeId", ClientUtil.getUserId());
		criteria.put("processType", processType);
		criteria.put("status", status);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadRefuseListOfCostAllocationPanelNewFive.getInstance();
	}
	private int successSize = 0;
	private int processType;
	private int status;
	
	public int getProcessType() {
		return processType;
	}

	public void setProcessType(int processType) {
		this.processType = processType;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		if(status == 2){//如果是已审核，则隐藏审批按钮
			taskAuditButton.hide();
			batchTaskAuditButton.hide();
		}else{
			resultGrid.setSelectionType(SelectionStyle.SIMPLE);  
			resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		}
		this.status = status;
	}


}

