package com.pomplatform.client.mainprojectinfo.panel;

import java.util.ArrayList;
import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
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
import com.delicacy.client.ui.EditProcessWindow;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.mainprojectinfo.datasource.DSOnLoadApplyListOfBidPaySheetProject;
import com.pomplatform.client.mainprojectinfo.form.OnLoadApplyListOfBidPaySheetProjectSearchForm;
import com.pomplatform.client.mainprojectinfo.form.OnLoadApplyListOfBidPaySheetProjectViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class OnLoadApplyListOfBidPaySheetProjectPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnLoadApplyListOfBidPaySheetProjectPanel cm = new OnLoadApplyListOfBidPaySheetProjectPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnLoadApplyListOfBidPaySheetProject";
		}

	}
	
	private IButton editButton;
	private IButton deleteButton;

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
		
		
		editButton = new IButton("撤销修改");
//		controlLayout.addMember(editButton);
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
								commonQuery();
							}
						});
						Reimbursement.setLayoutMode(0);
						Reimbursement.setProcessId(selected.getAttributeAsInt("processId"));
						Reimbursement.setInstanceData(selected);
						Reimbursement.initComponents();
						Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
						Reimbursement.setWidth100();
						Reimbursement.setHeight100();
						Reimbursement.centerInPage();
						Reimbursement.show();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
				
			}
		});
		
		deleteButton = new IButton("删除", new ClickHandler() {
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
		controlLayout.addMember(deleteButton);
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
				ListGridRecord selected = resultGrid.getSelectedRecord();
                ViewProcessWindow Reimbursement = new ViewProcessWindow();
                Reimbursement.setLayoutMode(0);
                Reimbursement.setInstanceData(selected);
                Reimbursement.initComponents();
                Reimbursement.setWidth("60%");
                Reimbursement.setHeight("75%");
                Reimbursement.centerInPage();
                Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
                Reimbursement.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		List<Map> keyvalues = new ArrayList<>();
		criteria.put("employeeId", ClientUtil.getUserId());
		if(status==1) {
			criteria.put("status",status);
		}else if(status==2) {
				Map<String, String> kv = new HashMap<>();
				kv.put("key", "spi.process_status IN ( 0, 1 )");
				kv.put("value", "spi.process_status IN ( 3, 5 )");
				keyvalues.add(kv);
		}
		if(!keyvalues.isEmpty()) {
			criteria.put("keyValues", keyvalues);
		}
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new OnLoadApplyListOfBidPaySheetProjectSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadApplyListOfBidPaySheetProject.getInstance();
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		if(status==2) {
			editButton.hide();
			deleteButton.hide();
		}
		this.status = status;
	}
	
	
	

}

