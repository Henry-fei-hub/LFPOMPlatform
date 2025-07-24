package com.pomplatform.client.workflow.panel;

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
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PooledTaskWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.workflow.datasource.DSEmployeeMoneyPoolOfWorkflow;
import com.pomplatform.client.workflow.form.EmployeeMoneyPoolOfWorkflowSearchForm;
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

public class EmployeeMoneyPoolOfWorkflowPanel extends AbstractSearchPanel
{

	private static final Logger __LOGGER = Logger.getLogger("");
	private static IButton auditButton;
	private static IButton agreeButton;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			EmployeeMoneyPoolOfWorkflowPanel cm = new EmployeeMoneyPoolOfWorkflowPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "EmployeeMoneyPoolOfWorkflow";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}
	
	@Override
	public Canvas generateHDataCanvas() {
        resultGrid = new DelicacyListGrid() {  
            @Override  
            protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {  
            	 if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.MY_FINANCIAL_RECEIVE_BILL)){
            		 if (null != record.getAttribute("receiveStatus") && record.getAttributeAsInt("receiveStatus") == 1) {  
            			 return "color: blue;";
                     } else {  
                         return super.getCellCSSText(record, rowNum, colNum);  
                     }  
            	 }else{
            		 return super.getCellCSSText(record, rowNum, colNum);  
            	 }
        		 
            }  
        };  
        resultGrid.setDataSource(getDataSource());
        resultGrid.setWidth100();
        resultGrid.setHeight100();
        return resultGrid;
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
                    if(!BaseHelpUtils.isNullOrEmpty(code)){
                    	resultGrid.selectRecord(0);//设值第一条选中
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
                    
                    afterDataReceived(dsResponse.getData());
                    if (isNeedPagenation() && pager != null) {
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
				record.setAttribute("employeeMoneyManageId", record.getAttribute("businessId"));
				final int recordSize = records.length;
				Map params = record.toMap();
				params.put("approvalment", approvalment);
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

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("employeeId", ClientUtil.getUserId());
		criteria.put("status",status);
		if(!BaseHelpUtils.isNullOrEmpty(code)){
			criteria.put("code",code);
		}
		return true;
	}
	
	@Override
    public int getSearchFormHeight() {
    	return 60;
    }


	@Override
	public SearchForm generateSearchForm() {
		return new EmployeeMoneyPoolOfWorkflowSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSEmployeeMoneyPoolOfWorkflow.getInstance();
	}

	private int status;
	private String code;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		DataSource ds = getDataSource();
		if(status == 2){//如果是已审核，则隐藏审批按钮
			auditButton.hide();
			agreeButton.hide();
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

}

