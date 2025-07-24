package com.pomplatform.client.workflow.panel;

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
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.delicacy.client.ui.ApprovalmentWindow;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PooledTaskWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.personnel.datasource.DSOnLoadFlowNormalReimbursementsApplyBuisnessData;
import com.pomplatform.client.personnel.form.OnLoadFlowNormalReimbursementsApplyBuisnessDataSearchForm;
import com.pomplatform.client.preprojectnormalreimbursement.datasource.DSNormalReimbursementLinkMainProjectOne;
import com.pomplatform.client.workflow.commonNormalReimbursement.datasource.DSNormalReimbursementLinkDepartmentOne;
import com.pomplatform.client.workflow.projectNormalReimbursement.datasource.DSNormalReimbursementLinkProjectOne;
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

public class NormalReimbursementsAuditOfWorkflowPanel extends AbstractExpansionRelatedPage
{


	private static final Logger __LOGGER = Logger.getLogger("");
	private static IButton auditButton;
	private static IButton agreeButton;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			NormalReimbursementsAuditOfWorkflowPanel cm = new NormalReimbursementsAuditOfWorkflowPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "NormalReimbursementsAuditOfWorkflow";
		}

	}

	public void commonQuery() {
        Map condition = generateCriteria();
        if (condition == null) {
            return;
        }
        if (searchForm != null) {
            searchButton.setIcon("loading38.gif");
        }
        DBDataSource ds = (DBDataSource) getDataSource();
        String operationName = ds.getActionMode() + ds.getActionName();
        final LoadingWindow loading = new LoadingWindow();
        DBDataSource.callOperation(operationName, "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
            	loading.destroy();
                if (searchForm != null) {
                    searchButton.setIcon("[SKIN]/actions/search.png");
                }
                if (dsResponse.getStatus() >= 0) {
                    resultGrid.setData(dsResponse.getData());
                    if(!BaseHelpUtils.isNullOrEmpty(code) && null != dsResponse.getData() && dsResponse.getData().length > 0){
                		resultGrid.selectRecord(0);//设值第一条选中
                		generateAuditPanel();
                    }
                    afterDataReceived(dsResponse.getData());
                    if (pager != null) {
                        if (currentPage == 1) {
                            totalPages = dsResponse.getAttributeAsInt("totalPages");
                            pager.getTotalPages().setContents(String.valueOf(totalPages));
                        }
                    }
                } else {
                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                }
                if (showPagination() && pager != null) {
                    pager.getCurrentPage().setContents(String.valueOf(currentPage));
                }
            }
        });
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
	
	private int successSize = 0;
	public void submit(ListGridRecord[] records, int approvalment) {
		if(null != records){
			successSize = 0;
			for(ListGridRecord record: records){
				if(ClientUtil.checkAndGetIntValue(record.getAttribute("activityType")) == 3){
					SC.say("对不起，处理节点不支持批量审批");
					return;
				}
				record.setAttribute("projectNormalReimbursementId", record.getAttribute("businessId"));
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
		criteria.put("employeeId", ClientUtil.getUserId());
		criteria.put("processType",processType);
		if(status==1) {
			criteria.put("status",status);
		}else if(status==2) {
			List<Map> keyvalues = new ArrayList<>();
				Map<String, String> kv = new HashMap<>();
				kv.put("key", "spia.status =?");
				kv.put("value", "spia.status =? and spia.status in (2,3,4,5,6)");
				keyvalues.add(kv);
				
				Map<String, String> kv2 = new HashMap<>();
				kv2.put("key", "sppt.status =?");
				kv2.put("value", "sppt.status =? and sppt.status in (2,3,4,5,6)");
				keyvalues.add(kv2);
				criteria.put("keyValues", keyvalues);
		}
		if(!BaseHelpUtils.isNullOrEmpty(code)){
			criteria.put("code",code);
		}
//		criteria.put("addtionalCondition", "order by process_instance_id");
		return true;
	}

	
	@Override
    public int getSearchFormHeight() {
    	return 60;
    }

	@Override
	public SearchForm generateSearchForm() {
		return new OnLoadFlowNormalReimbursementsApplyBuisnessDataSearchForm();
//		return new NormalReimbursementsAuditOfWorkflowSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadFlowNormalReimbursementsApplyBuisnessData.getInstance();
//		return DSNormalReimbursementsAuditOfWorkflow.getInstance();
	}

	private int status;
	private int processType;
	private String code;
	private int parentProcessTypeId;
	
	public int getParentProcessTypeId() {
		return parentProcessTypeId;
	}


	public void setParentProcessTypeId(int parentProcessTypeId) {
		this.parentProcessTypeId = parentProcessTypeId;
	}


	public int getProcessType() {
		return processType;
	}

	public void setProcessType(int processType) {
		this.processType = processType;
	}

	public int getStatus() {
		return status;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setStatus(int status) {
		DataSource ds = resultGrid.getDataSource();
		if(status == 2){//如果是已审核，则隐藏审批按钮
			agreeButton.hide();
			auditButton.hide();
			ds.getField("operateTime").setHidden(false);
			ds.getField("processComment").setHidden(false);
		}else{
			ds.getField("operateTime").setHidden(true);
			ds.getField("processComment").setHidden(true);
			resultGrid.setSelectionType(SelectionStyle.SIMPLE);  
			resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		}
		this.status = status;
	}


	@Override
	public DataSource getChildDataSource() {
		if(this.status==1) {
			switch (this.processType) {
			case 2: //项目日常报销
				return DSNormalReimbursementLinkProjectOne.getInstance();
			case 3: //普通日常报销
				return DSNormalReimbursementLinkDepartmentOne.getInstance();
			case 8: //前期项目日常报销
				return DSNormalReimbursementLinkMainProjectOne.getInstance();
			case 10: //公司日常报销
				return DSNormalReimbursementLinkDepartmentOne.getInstance();
			default:
				break;
			}
		}
		return null;
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
				Reimbursement.setWidth100();
				Reimbursement.setHeight100();
				Reimbursement.setLayoutMode(0);
				Reimbursement.setInstanceData(selected);
				Reimbursement.setProcessId(ClientUtil.checkAndGetIntValue(selected.getAttribute("processId")));
				Reimbursement.initComponents();
				Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
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
    			Reimbursement.setWidth("80%");
    			Reimbursement.setHeight("80%");
    			Reimbursement.setLayoutMode(0);
    			Reimbursement.setInstanceData(selected);
    			Reimbursement.initComponents();
    			Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
    			Reimbursement.show();
    		}
    	}else{
            SC.say("please select a record to edit");
            return;
        }
	}
}

