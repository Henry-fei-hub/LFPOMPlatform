package com.pomplatform.client.preprojects.panel;

import java.util.ArrayList;
import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PooledTaskWindow;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import java.util.Objects;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.ApprovalmentWindow;
import com.delicacy.client.ui.DelicacyListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.personnel.form.OnLoadFlowAuditListOfPreProjectReportBuisnessDataSearchForm;
import com.pomplatform.client.preprojects.datasource.DSOnLoadFlowAuditListOfMainProjectBuisnessData;
import com.pomplatform.client.preprojects.form.OnLoadFlowAuditListOfMainProjectBuisnessDataSearchForm;
import com.pomplatform.client.preprojects.form.OnLoadFlowAuditListOfMainProjectBuisnessDataViewer;
import com.pomplatform.client.workflow.panel.MyCostAllocationDesignPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class AuditListOfMainProjectBuisnessDataPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	private static IButton auditButton;
	private static IButton batchAuditButton;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			AuditListOfMainProjectBuisnessDataPanel cm = new AuditListOfMainProjectBuisnessDataPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "AuditListOfMainProjectBuisnessData";
		}

	}
	
	@Override
	public Canvas generateHDataCanvas() {
		resultGrid = new DelicacyListGrid() {
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				if (getFieldName(colNum).equals("projectNameOne")) {
					// 获取修改前项目名称
					String projectNameOne = BaseHelpUtils.getString(record.getAttribute("projectNameOne"));
					if (null!=projectNameOne && !projectNameOne.isEmpty()) {
						return "color: red;";
					}
				}
				return super.getCellCSSText(record, rowNum, colNum);
			}
		};
		resultGrid.setDataSource(getDataSource());
		return resultGrid;
	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(true);
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
                        Reimbursement.setData(selected);
                        Reimbursement.initComponents();
                        if(processType == 42){
                        	Reimbursement.setWidth("50%");
            				Reimbursement.setHeight100();
                        }
        				Reimbursement.centerInPage();
                        Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
                        Reimbursement.show();
            		}else {
            			//	普通节点审批
            			if(processType == 42){
                        	Map<String,String> params = new HashMap<>();
            				params.putAll(selected.toMap());
            				params.put("optType", "checkSimilarPercent");
            				DBDataSource.callOperation("EP_PreProjectProcess", params, new DSCallback() {
    							
    							@Override
    							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
    								if(dsResponse.getStatus() >= 0){
    									Record record = dsResponse.getData()[0];
    									ApprovalmentWindow Reimbursement = new ApprovalmentWindow();
    									Reimbursement.addDataEditedHandler(new DataEditedHandler(){
    										@Override
    										public void onDataEdited(DataEditEvent event) {
    											commonQuery();
    										}
    									});
    									if(ClientUtil.checkAndGetIntValue(selected.getAttribute("processType")) != MyCostAllocationDesignPanel.PROCESS_TYPE_42 && ClientUtil.checkAndGetIntValue(selected.getAttribute("activityType")) == 3){
    										Reimbursement.setNeedPagination(true);
    									}
    			                        Reimbursement.setLayoutMode(0);
    			                        Reimbursement.setInstanceData(selected);
    			                        Reimbursement.setData(selected);
    									Reimbursement.initComponents();
    									if(BaseHelpUtils.isNullOrEmpty(record)){//如果为空则说明没有相似度大于等于60%的项目存在
    										Reimbursement.setWidth("40%");
    										Reimbursement.setHeight("98%");
    									}else{
    										Reimbursement.setWidth("70%");
    										Reimbursement.setHeight("98%");
    									}
    									Reimbursement.centerInPage();
    									Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
    									Reimbursement.show();
    								}
    							}
    						});
                        }else{
                        	ApprovalmentWindow Reimbursement = new ApprovalmentWindow();
                            Reimbursement.addDataEditedHandler(new DataEditedHandler(){
                                @Override
                                public void onDataEdited(DataEditEvent event) {
                                    commonQuery();
                                }
                            });
                            if(ClientUtil.checkAndGetIntValue(selected.getAttribute("processType")) != MyCostAllocationDesignPanel.PROCESS_TYPE_42 && ClientUtil.checkAndGetIntValue(selected.getAttribute("activityType")) == 3){
                            	Reimbursement.setNeedPagination(true);
                            }
                            Reimbursement.setLayoutMode(0);
                            Reimbursement.setInstanceData(selected);
                            Reimbursement.setData(selected);
                            Reimbursement.initComponents();
        					Reimbursement.centerInPage();
                            Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
                            Reimbursement.show();
                        }
            		}
            	}else{
                    SC.say("please select a record to edit");
                    return;
                }
            }
        });
        
		batchAuditButton = new IButton("批量审批");
		batchAuditButton.hide();
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
                        				if(ClientUtil.checkAndGetIntValue(record.getAttribute("activityType")) == 3){
                        					SC.say("对不起，处理节点不支持批量审批");
                        					return;
                        				}
                        				record.setAttribute("resetCostId", record.getAttribute("businessId"));
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
                Reimbursement.setWidth("80%");
	            Reimbursement.setHeight("80%");
                Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
                Reimbursement.show();
                Reimbursement.centerInPage();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("employeeId", ClientUtil.getUserId());
		criteria.put("processType", processType);
		List<Map> keyvalues = new ArrayList<>();
		if(status == 1){
			criteria.put("status", status);
		}else {
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "spia.status = ?");
			kv.put("value", "spia.status in (2,3,4,5,6) and spia.status = ?");
			keyvalues.add(kv);
			
			Map<String, String> kv3 = new HashMap<>();
			kv3.put("key", "sppt.status = ?");
			kv3.put("value", " sppt.status in (2,3,4,5,6) and sppt.status =?");
			keyvalues.add(kv3);
		}
		if(!BaseHelpUtils.isNullOrEmpty(keyvalues)){
        	criteria.put("keyValues", keyvalues);
        }
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
//		return new OnLoadFlowAuditListOfMainProjectBuisnessDataSearchForm();
		return new OnLoadFlowAuditListOfPreProjectReportBuisnessDataSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadFlowAuditListOfMainProjectBuisnessData.getInstance();
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
			auditButton.hide();
			batchAuditButton.hide();
		}else{
			resultGrid.setSelectionType(SelectionStyle.SIMPLE);  
			resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		}
		this.status = status;
	}

	@Override
	public int getSearchFormHeight() {
		return 120;
	}


}

