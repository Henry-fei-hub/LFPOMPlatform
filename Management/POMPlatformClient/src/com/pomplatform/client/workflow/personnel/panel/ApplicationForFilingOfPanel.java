package com.pomplatform.client.workflow.personnel.panel;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.onloadflowpersonnelbuisnessdata.form.OnLoadFlowPersonnelBuisnessDataSearchForm;
import com.pomplatform.client.personnel.datasource.DSOnLoadFlowAuditOfEmployeeOnboardBuisnessData;
import com.pomplatform.client.workflow.personnel.datasource.DSApplicationInForFiling;
import com.pomplatform.client.workflow.personnel.form.ApplicationInForFilingSearchForm;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ApplicationForFilingOfPanel extends AbstractSearchPanel
{

	private static IButton auditButton;
	private static IButton batchAuditButton;
	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ApplicationForFilingOfPanel cm = new ApplicationForFilingOfPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "AuditOfEmployeeOnboard";
		}

	}

	@Override
	public void init(){
		super.init();
		resultGrid.setAutoFitFieldWidths(false);
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
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
		
		auditButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
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
                        if(selected.getAttributeAsInt("activityType") == 2){//审批节点不分页
                        	Reimbursement.setNeedPagination(false);
                        }else{//处理节点分页
                        	Reimbursement.setNeedPagination(true);
                        }
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
        });
        
		batchAuditButton = new IButton("批量审批");
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
                        				if(ClientUtil.checkAndGetIntValue(record.getAttribute("activityType")) == 3){
                        					SC.say("对不起，处理节点不支持批量审批");
                        					return;
                        				}
                        				record.setAttribute("employeeId", record.getAttribute("businessId"));
                        				final int recordSize = records.length;
                        				Map params = record.toMap();
                        				params.put("approvalment", 0);
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
                        }
                    });
            	}else{
                    SC.say("please select a record");
                    return;
                }
            }
        });
		controlLayout.addMember(batchAuditButton);
		controlLayout.addMember(auditButton);
		
//		commonQuery();
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
                Reimbursement.setWidth100();
                Reimbursement.setHeight100();
                Reimbursement.show();
                Reimbursement.centerInPage();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		List<Map> keyvalues = new ArrayList<>();
		criteria.put("employeeId", ClientUtil.getUserId());
		criteria.put("processType", processType);
		if(status==1) {
			criteria.put("status", status);
		}else {
			Map<String, String> kv2 = new HashMap<>();
        	kv2.put("key", "spia.status =?");
        	kv2.put("value", "spia.status =? and spia.status in (2,3,4,5,6)");
        	keyvalues.add(kv2);
        	
        	Map<String, String> kv3 = new HashMap<>();
        	kv3.put("key", "sppt.status =?");
        	kv3.put("value", "sppt.status =? and sppt.status in (2,3,4,5,6)");
        	keyvalues.add(kv3);
		}
		if(!BaseHelpUtils.isNullOrEmpty(keyvalues)){
			criteria.put("keyValues", keyvalues);
		}
		return true;
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new ApplicationInForFilingSearchForm();
	}


	@Override
	public DataSource getDataSource() {
		resultGrid.setShowRowNumbers(true);
		resultGrid.setAutoFitFieldWidths(false);
/*		if(status==1) {
			return DSAuditOfEmployeeOnboard.getInstance();
		}else {
			return DSAuditListOfEmployeeOnboard.getInstance();
		}*/
		return DSApplicationInForFiling.getInstance();
	}
	
	private int status;
	private int processType;
	private int successSize = 0;
	
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
			auditButton.hide();
			batchAuditButton.hide();
		}else{
			resultGrid.setSelectionType(SelectionStyle.SIMPLE);  
			resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		}
		this.status = status;
	}

}

