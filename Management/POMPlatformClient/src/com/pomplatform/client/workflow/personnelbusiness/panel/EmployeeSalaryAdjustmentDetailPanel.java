package com.pomplatform.client.workflow.personnelbusiness.panel;

import java.math.BigDecimal;
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
import com.delicacy.client.data.Print;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.ApprovalmentWindow;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PooledTaskWindow;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.payment.panel.OnPrintChangeSalary;
import com.pomplatform.client.personnel.datasource.DSOnLoadFlowEmployeeSalaryAdjustmentBuisnessData;
import com.pomplatform.client.personnel.form.OnLoadFlowEmployeeSalaryAdjustmentBuisnessDataSearchForm;
import com.pomplatform.client.workflow.personnelbusiness.form.EmployeeSalaryAdjustmentDetailViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class EmployeeSalaryAdjustmentDetailPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	private IButton agreeButton;
	private IButton disAgreeButton;
	private IButton auditButton;
	
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			EmployeeSalaryAdjustmentDetailPanel cm = new EmployeeSalaryAdjustmentDetailPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "EmployeeSalaryAdjustmentDetail";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setCanEdit(false);
		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
	}

	@Override
	public void initComponents() {
		ListGridField[] fields = new ListGridField[12];
		int idx = 0;
		fields[idx] = new ListGridField("employeeId");
		fields[idx++].setCanEdit(false);
		fields[idx] = new ListGridField("employeeNo");
		fields[idx++].setCanEdit(false);
		fields[idx] = new ListGridField("targetProvince");
		fields[idx++].setCanEdit(false);
		fields[idx] = new ListGridField("departmentId");
		fields[idx++].setCanEdit(false);
		fields[idx] = new ListGridField("startDate");
		fields[idx++].setCanEdit(false);
		fields[idx++] = new ListGridField("endDate");
		fields[idx] = new ListGridField("fee");
		fields[idx++].setCanEdit(false);
		fields[idx] = new ListGridField("originalPay");
		fields[idx].setType(ListGridFieldType.FLOAT);
		fields[idx++].setCanEdit(false);
		fields[idx] = new ListGridField("severance");
		fields[idx++].setType(ListGridFieldType.FLOAT);
		fields[idx] = new ListGridField("monthPay");
		fields[idx++].setType(ListGridFieldType.FLOAT);
		fields[idx] = new ListGridField("subType");
		fields[idx].setType(ListGridFieldType.FLOAT);
		fields[idx++].setCanEdit(false);
		fields[idx] = new ListGridField("remark");
		fields[idx].setCanEdit(false);

		resultGrid.setFields(fields);
		resultGrid.getField("targetProvince").setTitle("业务部门");
		resultGrid.getField("startDate").setTitle("入职日期");
		resultGrid.getField("endDate").setTitle("调薪日期");
		resultGrid.getField("fee").setTitle("个人效益指数");
		resultGrid.getField("severance").setTitle("调薪金额");
		resultGrid.getField("monthPay").setTitle("调整后薪资总额");
		resultGrid.getField("subType").setTitle("调薪比例（%）");
		
		
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map map = event.getNewValues();
				ListGridRecord record = resultGrid.getRecord(event.getRowNum());
				if(map.containsKey("severance")){
					record.setAttribute("monthPay", BaseHelpUtils.getBigDecimalValue(record.getAttribute("originalPay")).add(BaseHelpUtils.getBigDecimalValue(map.get("severance"))));
					record.setAttribute("subType", BaseHelpUtils.getBigDecimalValue(map.get("severance")).divide(BaseHelpUtils.getBigDecimalValue(record.getAttribute("originalPay")), 2, BigDecimal.ROUND_DOWN));
				}else if(map.containsKey("monthPay")){
					record.setAttribute("severance", BaseHelpUtils.getBigDecimalValue(map.get("monthPay")).subtract(BaseHelpUtils.getBigDecimalValue(record.getAttribute("originalPay"))));
					record.setAttribute("subType", BaseHelpUtils.getBigDecimalValue(record.getAttribute("severance")).divide(BaseHelpUtils.getBigDecimalValue(record.getAttribute("originalPay")), 2, BigDecimal.ROUND_DOWN));
				}
				resultGrid.updateData(record);
			}
		});

		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请选择一条数据");
							return;
						}
						Record selected = resultGrid.getSelectedRecords()[0];
						ViewProcessWindow Reimbursement = new ViewProcessWindow();
						Reimbursement.setWidth("80%");
						Reimbursement.setHeight("80%");
						Reimbursement.setLayoutMode(0);
						Reimbursement.setInstanceData(selected);
						Reimbursement.initComponents();
						Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
						Reimbursement.show();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		controlLayout.addMember(viewButton);
		
		agreeButton = new IButton("同意");
		agreeButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						submit(0);
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		controlLayout.addMember(agreeButton);
		
		disAgreeButton = new IButton("驳回");
		disAgreeButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						submit(1);
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		controlLayout.addMember(disAgreeButton);
		
		IButton showProgressButton = new IButton("查看进度");
		showProgressButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请选择一条记录");
							return;
						}
						Map params = new HashMap();
						params.put("processInstanceId", resultGrid.getSelectedRecords()[0].getAttribute("processInstanceId"));
						DBDataSource.callOperation("EP_GetProcessInstance", params, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() >= 0) {
									Record[] records = dsResponse.getData();
									if (records.length == 0) {
										return;
									}
									Record record = records[0];
									Record processInstance = record.getAttributeAsRecord("processInstance");
									ClientUtil.showWorkFlow(processInstance);
								} else {
									ClientUtil.displayErrorMessage(dsResponse);
								}
							}
						});
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		controlLayout.addMember(showProgressButton);
		
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
		
		IButton summaryButton = new IButton("部门汇总");
		summaryButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow window = new PopupWindow("部门调薪汇总");
				window.setWidth100();
				window.setHeight100();
				window.centerInPage();
				PlateSalaryAdjustmentSummaryPanel panel = new PlateSalaryAdjustmentSummaryPanel();
				window.addMember(panel);
				window.show();
			}
		});
		controlLayout.addMember(summaryButton);
		
		IButton printButton = new IButton("打印");
		controlLayout.addMember(printButton);
		printButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//获取所有业务部门id数据集
				String plateIds ="";
				Record[] records = resultGrid.getRecords();
				Map<Integer,Integer> plateMap = new HashMap<>();
				if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
					//去掉重复的部门
					for(Record r:records){
						int plateId = BaseHelpUtils.getIntValue(r.getAttribute("targetProvince"));
						plateMap.put(plateId, plateId);
					}
					for(Integer key : plateMap.keySet()){
						String plateName = BaseHelpUtils.getString(plateMap.get(key));
						if(!BaseHelpUtils.isNullOrEmpty(plateIds)){
							plateIds += ",";
						}
						plateIds += plateName;
					}
				}
				Map<String,Object> params = new HashMap<>();
				params.put("optType", "onFindEmpByRole");
				params.put("plateIds", plateIds);
				DBDataSource.callOperation("EP_OnPaymentManageProcess", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						//部门审批人
						String auditPerson = dsResponse.getAttributeAsMap("userData").get("auditPerson")+"";
						//申请人
						String payPerson = dsResponse.getAttributeAsMap("userData").get("payPerson")+"";
						//运营审批
						String operatePerson = dsResponse.getAttributeAsMap("userData").get("operatePerson")+"";
						//人资审批
						String hrPerson = dsResponse.getAttributeAsMap("userData").get("hrPerson")+"";
						OnPrintChangeSalary printHtml = new OnPrintChangeSalary();
						Map<String,Object> map = new HashMap<>();
						int year = BaseHelpUtils.getIntValue(searchForm.getItem("year").getValue());
						int month = BaseHelpUtils.getIntValue(searchForm.getItem("month").getValue());
						int plateId = BaseHelpUtils.getIntValue(searchForm.getItem("plateId").getValue());
						if(year > 0){
							map.put("year", year);
						}
						if(month > 0){
							map.put("month", month);
						}
						if(plateId > 0){
							map.put("plateId", plateId);
						}
						map.put("auditPerson", auditPerson);
						map.put("payPerson", payPerson);
						map.put("operatePerson", operatePerson);
						map.put("hrPerson", hrPerson);
						if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
							printHtml.setRecords(records);
							printHtml.setPrintData(map);
							Print.it(printHtml.generatePrintHTML());
						}
					}
				});
			}
		});
		
		
		IButton exportButton = new IButton("导出");
		controlLayout.addMember(exportButton);
		exportButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				//获取所有业务部门id数据集
				String plateIds ="";
				Record[] records = resultGrid.getRecords();
				Map<Integer,Integer> plateMap = new HashMap<>();
				if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
					//去掉重复的部门
					for(Record r:records){
						int plateId = BaseHelpUtils.getIntValue(r.getAttribute("targetProvince"));
						plateMap.put(plateId, plateId);
					}
					for(Integer key : plateMap.keySet()){
						String plateName = BaseHelpUtils.getString(plateMap.get(key));
						if(!BaseHelpUtils.isNullOrEmpty(plateIds)){
							plateIds += ",";
						}
						plateIds += plateName;
					}
				}
				Map<String,Object> map = new HashMap<>();
				map.put("optType", "onFindEmpByRole");
				map.put("plateIds", plateIds);
				DBDataSource.callOperation("EP_OnPaymentManageProcess", map, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						//部门审批人
						String auditPerson = dsResponse.getAttributeAsMap("userData").get("auditPerson")+"";
						//申请人
						String payPerson = dsResponse.getAttributeAsMap("userData").get("payPerson")+"";
						//运营审批
						String operatePerson = dsResponse.getAttributeAsMap("userData").get("operatePerson")+"";
						//人资审批
						String hrPerson = dsResponse.getAttributeAsMap("userData").get("hrPerson")+"";
						@SuppressWarnings("unchecked")
						Map<String,Object> param = generateCriteria();
						param.put("auditPerson", auditPerson);
						param.put("payPerson", payPerson);
						param.put("operatePerson", operatePerson);
						param.put("hrPerson", hrPerson);
						List<Map<String, String>> list = (List<Map<String, String>>) param.get("keyValues");
						for(Map<String, String> keyValueMap : list) {
							String value = BaseHelpUtils.getString(keyValueMap.get("value"));
							if(value.indexOf("spia.status") >= 0) {
								keyValueMap.put("value", "spia.status = 2");
							}else if(value.indexOf("sppt.status") >= 0) {
								keyValueMap.put("value", "sppt.status = 2");
							}
						}
						if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
							DBDataSource.downloadFile("DW_ExportEmployeeSalaryAdjustment", param);
						}
					}
				});
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
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("员工调薪详情表"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				EmployeeSalaryAdjustmentDetailViewer detailForm = new EmployeeSalaryAdjustmentDetailViewer();
				detailForm.setParentSearchForm(searchForm);
				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
				detailForm.initComponents();
				detailForm.viewSelectedData(resultGrid);
				detail.setContent(detailForm);
				detail.centerInPage();
				detail.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
//		criteria.put("auditor", ClientUtil.getUserId());
		List<Map> keyvalues = new ArrayList<>();
		if(audit){
			Map<String, String> kv = new HashMap<>();
			Map<String, String> kv2 = new HashMap<>();
        	kv.put("key", "spia.status = 1");
        	kv.put("value", "spia.status in (2,3,4,5,6)");
        	kv2.put("key", "sppt.status = 1");
        	kv2.put("value", "sppt.status in (2,3,4,5,6)");
        	keyvalues.add(kv);
        	keyvalues.add(kv2);
		}
        if(BaseHelpUtils.isNullOrEmpty(criteria.get("year"))){
        	Map<String, String> kv = new HashMap<>();
        	kv.put("key", "( EXTRACT ( YEAR FROM A.end_date )) =?");
        	kv.put("value", "1=?");
        	keyvalues.add(kv);
        }
        if(BaseHelpUtils.isNullOrEmpty(criteria.get("month"))){
        	Map<String, String> kv = new HashMap<>();
        	kv.put("key", "( EXTRACT ( MONTH FROM A.end_date )) =?");
        	kv.put("value", "1=?");
        	keyvalues.add(kv);
        }
        if(!BaseHelpUtils.isNullOrEmpty(keyvalues)){
        	criteria.put("keyValues", keyvalues);
        }
		criteria.put("employeeId", ClientUtil.getUserId());
//		criteria.put("processType", processType);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnLoadFlowEmployeeSalaryAdjustmentBuisnessDataSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadFlowEmployeeSalaryAdjustmentBuisnessData.getInstance();
	}

	public void submit(int approvalment){
		ListGridRecord[] records = resultGrid.getSelectedRecords();
		List<Map> list = new ArrayList<>();
		Map<String, Object> params = new HashMap<>();
		params.put("optType", "agreeSalaryAdjustment");
		params.put("operator", ClientUtil.getUserId());
		for(ListGridRecord record : records){
			Map map = record.toMap();
			map.put("userData", record.toMap());
			map.put("approvalment", approvalment);
			list.add(map);
		}
		if(!list.isEmpty()) {
			params.put("list", list);
			DBDataSource.callOperation("EP_MyPersonnelProcessor", params, new DSCallback() {
				
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					commonQuery();
				}
			});
		}
	}
	private boolean audit = true;//true:已审批   false:待办审批

	public boolean isAudit() {
		return audit;
	}

	public void setAudit(boolean audit) {
		this.audit = audit;
		if(audit){
			agreeButton.hide();
			disAgreeButton.hide(); 
			auditButton.hide();
		}else{
			agreeButton.show();
			disAgreeButton.show();
			auditButton.show();
		}
	}
	private int processType;
	public int getProcessType() {
		return processType;
	}

	public void setProcessType(int processType) {
		this.processType = processType;
	}
	
}

