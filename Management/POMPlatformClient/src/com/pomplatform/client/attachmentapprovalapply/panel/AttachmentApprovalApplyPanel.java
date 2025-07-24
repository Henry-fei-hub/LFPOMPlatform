package com.pomplatform.client.attachmentapprovalapply.panel;

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
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.EditProcessWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.attachmentapprovalapply.datasource.DSAttachmentApprovalApply;
import com.pomplatform.client.attachmentapprovalapply.form.AttachmentApprovalApplySearchForm;
import com.pomplatform.client.workflow.panel.MyWorkflowDesignPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class AttachmentApprovalApplyPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			AttachmentApprovalApplyPanel cm = new AttachmentApprovalApplyPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "AttachmentApprovalApply";
		}

	}

	@Override
	public void init(){

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
		
		resultGrid.setWidth("90%");
		resultGrid.setAlign(Alignment.CENTER);
		int a = 0;
		ListGridField[] aFields = new ListGridField[9];
		aFields[a] = new ListGridField("attachmentName","附件名称");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("fileUrl","路径");
		aFields[a].setCanEdit(false);
		aFields[a].setLinkText("预算文件下载/预览");
		a++;
		aFields[a] = new ListGridField("budgetContractAmount","预算合同金额");
		aFields[a].setAlign(Alignment.RIGHT);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("budgetContractAmountUse","合同已付金额");
		aFields[a].setAlign(Alignment.RIGHT);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("budgetContractAmountRest","合同剩余金额");
		aFields[a].setAlign(Alignment.RIGHT);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("payPercent","付款比例");
		aFields[a].setAlign(Alignment.RIGHT);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("receiveUnitManageId","供应商");
		aFields[a].setAlign(Alignment.CENTER);
//		aFields[a].setValueMap(KeyValueManager.getValueMap("receive_unit_manages_company"));
		KeyValueManager.loadValueMap("receive_unit_manages_company",aFields[a]);
		aFields[a].setShowGridSummary(false);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("bddType","预算类别");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("projectId","项目名称");
		aFields[a].setAlign(Alignment.CENTER);
//		aFields[a].setValueMap(KeyValueManager.getValueMap("projects"));
		KeyValueManager.loadValueMap("projects",aFields[a]);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("uploadEmployeeId","上传人员");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setValueMap(KeyValueManager.getValueMap("employees"));
		aFields[a].setShowGridSummary(false);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("uploadTime","上传时间");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("uploadRemark","备注");
		aFields[a].setType(ListGridFieldType.TEXT);
		aFields[a].setCanEdit(false);
		resultGrid.setFields(aFields);
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setDataSource(DSAttachmentApprovalApply.getInstance());
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

		IButton editButton = new IButton("撤销修改");
		controlLayout.addMember(editButton);
		editButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {

					@Override
					public void onSuccess() {
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

					@Override
					public void onFailure(Throwable reason) {
						SC.say("请按Ctrl+F5刷新页面再操作");
					}
				});

			}
		});

		IButton deleteButton = new IButton("删除", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {

					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("请选择一条记录，再点击删除按钮");
							return;
						}
						SC.confirm("确定要删除这条记录吗？", new BooleanCallback() {

							@Override
							public void execute(Boolean value) {
								if(value){
									Record record = resultGrid.getSelectedRecords()[0];
									if(null != record.getAttribute("processStatus") && record.getAttribute("processStatus").toString().equals("0")){
										Map<String,Object> map = new HashMap<>();
										map.put("optType", "deletePersonnelBusiness");
										if(null != record.getAttribute("processInstanceId")){
											int processInstanceId = ClientUtil.checkAndGetIntValue(record.getAttribute("processInstanceId"));
											if(processInstanceId > 0){
												map.put("processInstanceId", processInstanceId);
											}else{
												return;
											}
										}else{
											return;
										}
										if(null != record.getAttribute("businessId")){
											int businessId = ClientUtil.checkAndGetIntValue(record.getAttribute("businessId"));
											if(businessId > 0){
												map.put("businessId", businessId);
											}else{
												return;
											}
										}else{
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
									}else{
										SC.say("抱歉，该记录无法删除！");
										return;
									}
								}
							}
						});
					}

					@Override
					public void onFailure(Throwable reason) {
						SC.say("请按Ctrl+F5刷新页面再操作");
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

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("employeeId", ClientUtil.getEmployeeId());
		criteria.put("processType", processType);
		List<Map> keyvalues = new ArrayList<>();
		if(!BaseHelpUtils.isNullOrEmpty(status)) {
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "spi.process_status IN (0, 1)");
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
		return new AttachmentApprovalApplySearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSAttachmentApprovalApply.getInstance();
	}
	
	
	private String status;
	
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private int processType;

	public int getProcessType() {
		return processType;
	}

	public void setProcessType(int processType) {
		this.processType = processType;
	}

	private int activityType;

	public int getActivityType() {
		return activityType;
	}

	public void setActivityType(int activityType) {
		this.activityType = activityType;
	}
	
	@Override
	public int getSearchFormHeight() {
		return 80;
	}

}

