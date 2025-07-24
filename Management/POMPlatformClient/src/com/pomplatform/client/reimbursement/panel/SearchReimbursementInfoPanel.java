package com.pomplatform.client.reimbursement.panel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.process.SystemProcessConstants;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.LoginLayout;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.reimbursement.datasource.DSSearchReimbursementInfo;
import com.pomplatform.client.reimbursement.form.SearchReimbursementInfoSearchForm;
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
import com.smartgwt.client.widgets.grid.ListGridField;

public class SearchReimbursementInfoPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			SearchReimbursementInfoPanel cm = new SearchReimbursementInfoPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SearchReimbursementInfo";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void initComponents() {
		ListGridField[] fields = new ListGridField[21];
		int idx = 0;
		fields[idx] = new ListGridField("packageCode");
		fields[idx].setShowGridSummary(false);
		fields[idx++].setWidth(120);
		fields[idx] = new ListGridField("code");
		fields[idx].setShowGridSummary(false);
		fields[idx++].setWidth(110);
		fields[idx] = new ListGridField("bdCode");
		fields[idx].setShowGridSummary(false);
		fields[idx++].setWidth(110);
		fields[idx] = new ListGridField("processType");
		fields[idx].setShowGridSummary(false);
		fields[idx++].setWidth(130);
		fields[idx] = new ListGridField("companyId");
		fields[idx].setShowGridSummary(false);
		fields[idx++].setWidth(150);
		fields[idx] = new ListGridField("bearFeeCode");
		fields[idx].setShowGridSummary(false);
		fields[idx++].setWidth(110);
		fields[idx] = new ListGridField("bearFeeName");
		fields[idx].setShowGridSummary(false);
		fields[idx++].setWidth(110);
		fields[idx] = new ListGridField("plateId");
		fields[idx].setShowGridSummary(false);
		fields[idx++].setWidth(110);
		fields[idx] = new ListGridField("employeeId");
		fields[idx].setShowGridSummary(false);
		fields[idx++].setWidth(80);
		fields[idx] = new ListGridField("departmentId");
		fields[idx].setShowGridSummary(false);
		fields[idx++].setWidth(110);
		fields[idx] = new ListGridField("currency");
		fields[idx].setShowGridSummary(false);
		fields[idx++].setWidth(80);
		fields[idx] = new ListGridField("amount");
		fields[idx++].setWidth(130);
		fields[idx] = new ListGridField("inputTax");
		fields[idx++].setWidth(100);
		fields[idx] = new ListGridField("finalAmount");
		fields[idx++].setWidth(130);
		fields[idx] = new ListGridField("processStatus");
		fields[idx].setShowGridSummary(false);
		fields[idx++].setWidth(80);
		fields[idx] = new ListGridField("remark");
		fields[idx].setShowGridSummary(false);
		fields[idx++].setWidth(100);
		fields[idx] = new ListGridField("createTime");
		fields[idx].setShowGridSummary(false);
		fields[idx++].setWidth(140);
		fields[idx] = new ListGridField("completeTime");
		fields[idx].setShowGridSummary(false);
		fields[idx++].setWidth(140);
		fields[idx] = new ListGridField("backViewName");
		fields[idx].setShowGridSummary(false);
		fields[idx++].setWidth(140);
		fields[idx] = new ListGridField("instanceActivityStartTime");
		fields[idx].setShowGridSummary(false);
		fields[idx++].setWidth(140);
		fields[idx] = new ListGridField("outDay");
		fields[idx].setShowGridSummary(false);
		fields[idx++].setWidth(140);
		resultGrid.setFields(fields);
		resultGrid.setShowGridSummary(true);
		
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
		
		IButton viewButton = new IButton("查看报销单");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		
		IButton disagreeButton = PermissionControl.createPermissionButton("滞留单驳回", ERPPermissionStatic.SEARCH_REIMBURSEMENT_DISAGREE_BUTTON);
		disagreeButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()) {
							SC.say("请选择需要滞留驳回的报销单");
							return;
						}
						Record record = resultGrid.getSelectedRecord();
						String code = record.getAttribute("code");
						int processStatus = BaseHelpUtils.getIntValue(record.getAttribute("processStatus"));
						if(processStatus != SystemProcessConstants.PROCESS_STATUS_NEW_CREATED && processStatus != SystemProcessConstants.PROCESS_STATUS_WORKING) {
							SC.say("报销单[" + code + "]不是新建或进行中状态，不能执行滞留驳回操作");
							return;
						}
						Date createTime = record.getAttributeAsDate("createTime");
						if(null == createTime) {
							SC.say("无法获取报销单[" + code + "]的创建时间");
							return;
						}
						if((System.currentTimeMillis() - createTime.getTime()) / LoginLayout.DAY_TIMEMILLIS < 60) {
							SC.say("报销单[" + code + "]距离创建时间尚未超过60天，不能执行滞留驳回操作");
							return;
						}
						Map<String, String> params = new HashMap<>();
						params.put("optType", "delayReject");
						params.put("processInstanceId", record.getAttribute("processInstanceId"));
						params.put("employeeId", ClientUtil.getUserId());
						params.put("code", record.getAttribute("code"));
						DBDataSource.callOperation("EP_WrokflowProcessor", params, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() >= 0) {
									SC.say("停滞驳回成功");
									commonQuery();
								}else {
									ClientUtil.displayErrorMessage(dsResponse);
								}
							}
						});
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				} );
			}
		});
		controlLayout.addMember(disagreeButton);
		
		IButton download = new IButton("导出");
		controlLayout.addMember(download);
		download.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map<Object, Object> condition = generateCriteria();
				DBDataSource.downloadFile("DW_SearchReimbursementInfo", condition);
			}
		});
		commonQuery();
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
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		List<Map> keyvalues = new ArrayList<>();
		if(criteria.containsKey("processType") && null != criteria.get("processType")){
			String processType = criteria.get("processType").toString().replace("[", "").replace("]", "");
			if(processType.indexOf(",") >= 0){
				criteria.remove("processType");
				Map<String, String> kv = new HashMap<>();
				kv.put("key", "1 = 1");
				kv.put("value", "A.process_type in (" + processType +")");
				keyvalues.add(kv);
			}else{
				//单选
				criteria.put("processType", processType);
			}
		}
		if(criteria.containsKey("processStatus") && null != criteria.get("processStatus")){
			String processStatus = criteria.get("processStatus").toString().replace("[", "").replace("]", "");
			if(processStatus.indexOf(",") >= 0){
				criteria.remove("processStatus");
				Map<String, String> kv = new HashMap<>();
				kv.put("key", "2 = 2");
				kv.put("value", "A.process_status in (" + processStatus +")");
				keyvalues.add(kv);
			}else{
				//单选
				criteria.put("processStatus", processStatus);
			}
		}
		if(keyvalues.size() > 0){
			criteria.put("keyValues", keyvalues);
		}
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new SearchReimbursementInfoSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSSearchReimbursementInfo.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 160;
	}
}

