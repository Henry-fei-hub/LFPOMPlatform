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
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.EditProcessWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.NewProcessWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.pomplatform.client.workflow.datasource.DSPayMoneyApplyOfWorkflow;
import com.pomplatform.client.workflow.form.PayMoneyApplyOfWorkflowSearchForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class PayMoneyApplyOfWorkflowPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			PayMoneyApplyOfWorkflowPanel cm = new PayMoneyApplyOfWorkflowPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "PayMoneyApplyOfWorkflow";
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
		
		IButton editButton = new IButton("撤销修改");
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
		//复制发起按钮
//		IButton copyStratButton = PermissionControl.createPermissionButton("复制发起", "AB-65000-000");
		IButton copyStratButton = new IButton("复制发起");
		controlLayout.addMember(copyStratButton);
		copyStratButton.addClickHandler(new ClickHandler() {
			@SuppressWarnings("unchecked")
			@Override
			public void onClick(ClickEvent event) {
				Record record = resultGrid.getSelectedRecords()[0];
				if (!resultGrid.anySelected()) {
					SC.say("please select a record to copy");
					return;
				}
						NewProcessWindow distribution = new NewProcessWindow();
						distribution.setData(record);
						distribution.setTitle("预付款申请");
						distribution.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								// 操作成功
								commonQuery();
							}
						});
						Map<String, String> processIdMap = PomPlatformClientUtil
								.getUserProcessId(PomPlatformClientUtil.PARENT_PROCESS_TYPE_1);
						Integer value = ClientUtil.checkAndGetIntValue(processIdMap.get("Pay_money_manage"));
						distribution.setProcessId(value);
						distribution.setLayoutMode(0);
						distribution.initComponents();
						distribution.setTitle(KeyValueManager.getValue("employee_processes", String.valueOf(value)));
						distribution.show();
					}
				});
		
		IButton deleteButton = new IButton("删除", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("please select a record to delete");
					return;
				}
				Record record = resultGrid.getSelectedRecords()[0];
				if(null != record.getAttribute("processStatus") && record.getAttribute("processStatus").toString().equals("0")){
					Map<String,Object> map = new HashMap<>();
					map.put("optType", "deletePayMoney");
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
					SC.say("Sorry, this record could not be deleted");
					return;
				}
			}
		});
		controlLayout.addMember(deleteButton);

		IButton uploadButton = new IButton("上传附件", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("please select a record to delete");
					return;
				}
				Record record = resultGrid.getSelectedRecords()[0];
				int processStatus = record.getAttributeAsInt("processStatus");
				int payMoneyManageId = record.getAttributeAsInt("payMoneyManageId");
				if(!(processStatus==1 || processStatus==3 || processStatus==0)){
					SC.say("该预付款状态不允许上传附件！！");
					return;
				}
				new CommonUploadWindow("上传附件", false, 100, null, 1, new UploadCallBack() {

					@Override
					public void execute(Map<String, Record> data) {
						// 上传附件文件成功
						for(String key : data.keySet()) {
							SC.debugger();
							String attachmentId = data.get(key).getAttribute("fileId");
							String attachmentName = data.get(key).getAttribute("fileName");
							HashMap<Object, Object> map = new HashMap<>();
							map.put("payMoneyManageId",payMoneyManageId);
							map.put("optType","addAttachments");
							map.put("attachmentId",attachmentId);
							map.put("attachmentName",attachmentName);
							DBDataSource.callOperation("EP_OnCommonProcess", map, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus()>0){
										SC.say("附件上传成功！");
									}
								}
							});
						}
					}
				});

			}
		});
		controlLayout.addMember(uploadButton);
		
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
		criteria.put("employeeId",ClientUtil.getEmployeeId());
		if(!BaseHelpUtils.isNullOrEmpty(status)) {
			List<Map> keyvalues = new ArrayList<>();
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "spi.process_status IN ( 0, 1 )");
			kv.put("value", status);
			keyvalues.add(kv);
			criteria.put("keyValues", keyvalues);
		}
		
/*		if(activityType == MyWorkflowDesignPanel.ACTIVITY_TYPE_2){//已驳回
			List<Map> keyvalues = new ArrayList<>();
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "and spi.process_status in(0,1)");
			kv.put("value", "and spi.process_status = 5");
			keyvalues.add(kv);
			criteria.put("keyValues", keyvalues);
		}else if(activityType == MyWorkflowDesignPanel.ACTIVITY_TYPE_3){//已完成
			List<Map> keyvalues = new ArrayList<>();
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "and spi.process_status in(0,1)");
			kv.put("value", "and spi.process_status = 3");
			keyvalues.add(kv);
			criteria.put("keyValues", keyvalues);
		}
		criteria.put("addtionalCondition", "order by process_instance_id");*/
		return true;
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new PayMoneyApplyOfWorkflowSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSPayMoneyApplyOfWorkflow.getInstance();
	}
	
	private int activityType;
	private String status;
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getActivityType() {
		return activityType;
	}

	public void setActivityType(int activityType) {
		this.activityType = activityType;
	}


}

