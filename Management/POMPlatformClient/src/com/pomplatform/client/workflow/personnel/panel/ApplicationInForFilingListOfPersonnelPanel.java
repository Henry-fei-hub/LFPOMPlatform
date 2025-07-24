package com.pomplatform.client.workflow.personnel.panel;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.*;
import com.delicacy.client.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.onloadflowpersonnelbuisnessdata.datasource.DSOnLoadFlowPersonnelBuisnessData;
import com.pomplatform.client.onloadflowpersonnelbuisnessdata.form.OnLoadFlowPersonnelBuisnessDataSearchForm;
import com.pomplatform.client.workflow.datasource.DSApplicationInForFilingListOf;
import com.pomplatform.client.workflow.form.ApplicationInForFilingListOfSearchForm;
import com.pomplatform.client.workflow.form.FileDetailsForm;
import com.pomplatform.client.workflow.panel.MyAdministrationDesignPanel;
import com.pomplatform.client.workflow.panel.MyCostAllocationDesignPanel;
import com.pomplatform.client.workflow.panel.MyPersonnelFlowDesignPanel;
import com.smartgwt.client.data.*;
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

import java.util.*;
import java.util.logging.Logger;

public class ApplicationInForFilingListOfPersonnelPanel extends AbstractSearchPanel
{

	private static IButton auditButton;
	private static IButton batchAuditButton;
	private static IButton viewButton1;
	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ApplicationInForFilingListOfPersonnelPanel cm = new ApplicationInForFilingListOfPersonnelPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ApplicationInForFilingListOf";
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



		
		auditButton = new IButton("审批");
		SC.debugger();
		controlLayout.addMember(auditButton);
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
                        if(ClientUtil.checkAndGetIntValue(selected.getAttribute("processType")) == MyPersonnelFlowDesignPanel.PROCESS_TYPE_25 && ClientUtil.checkAndGetIntValue(selected.getAttribute("activityType")) == 3){
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
		controlLayout.addMember(batchAuditButton);
		batchAuditButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	final ListGridRecord[] records = resultGrid.getSelectedRecords();
            	if(null != records && records.length > 0){
            		SC.confirm("您确定已经要进行批量操作吗？", new BooleanCallback() {
                        @Override
                        public void execute(Boolean value) {
                            if (value) {
                            	if(null != records){
                            		successSize = 0;
                        			for(ListGridRecord record: records){
                        				record.setAttribute("personnelBusinessId", record.getAttribute("businessId"));
                        				final int recordSize = records.length;
                        				if(ClientUtil.checkAndGetIntValue(record.getAttribute("activityType")) == 3){
                        					SC.say("对不起，处理节点不支持批量审批");
                        					return;
                        				}
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


		viewButton1 = new IButton("查看员工档案");
		controlLayout.addMember(viewButton1);
		viewButton1.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {


				if(!resultGrid.anySelected()){
					SC.say("请选择一条数据"); return;
				}
				final ListGridRecord selected1 = resultGrid.getSelectedRecord();
				SC.debugger();


				PopupWindow popupWindow = new PopupWindow();
				FileDetailsForm detailForm = new FileDetailsForm();
				popupWindow.setTitle("查看员工档案明细");
				popupWindow.addMember(detailForm);
				popupWindow.setWidth("80%");
				popupWindow.setHeight("80%");
				popupWindow.centerInPage();
				detailForm.initComponents();
				detailForm.initGrid(selected1.getAttributeAsInt("unit"));
				popupWindow.show();

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
                __LOGGER.info("selected++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+selected.toMap());
                LinkedHashMap<String, String> map = KeyValueManager.getValueMap("processExecutors");
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
		SC.debugger();
		List<Map> keyvalues = new ArrayList<>();
		criteria.put("employeeId", ClientUtil.getUserId());
		criteria.put("processType", processType);
		if(status==1) {
			criteria.put("status",status);
		}else if(status==2) {
				Map<String, String> kv = new HashMap<>();
				kv.put("key", "spia.status =?");
				kv.put("value", "1 =? and spia.status in (2,3,4,5,6)");
				keyvalues.add(kv);
				
				Map<String, String> kv2 = new HashMap<>();
				kv2.put("key", "sppt.status =?");
				kv2.put("value", "1 =? and sppt.status in (2,3,4,5,6)");
				keyvalues.add(kv2);
		}
		if(!BaseHelpUtils.isNullOrEmpty(parentProcessType)) {
        	Map<String, String> kv = new HashMap<>();
			kv.put("key", "spt.parent_process_type_id = 12");
			kv.put("value", parentProcessType);
        	keyvalues.add(kv);
		}
        if(!BaseHelpUtils.isNullOrEmpty(keyvalues) && keyvalues.size() > 0){
        	criteria.put("keyValues", keyvalues);
        }
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
			return new ApplicationInForFilingListOfSearchForm();
	}

	@Override
	public DataSource getDataSource() {
			return DSApplicationInForFilingListOf.getInstance();
	}
	

	
	private int successSize = 0;
	private int processType;
	private int status;
	private String parentProcessType;
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
			viewButton1.hide();
		}else{
			auditButton.show();
			batchAuditButton.show();
//			newProcessButton.show();
//			deleteCostButton.show();
			resultGrid.setSelectionType(SelectionStyle.SIMPLE);  
			resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		}
		this.status = status;
	}

	public String getParentProcessType() {
		return parentProcessType;
	}

	public void setParentProcessType(String parentProcessType) {
		this.parentProcessType = parentProcessType;
	}
	
	
	

}

