package com.pomplatform.client.specialdeduction.panel;

import java.util.ArrayList;
import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.NewProcessWindow;
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
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.project.form.UpdateProjectManagerForm;
import com.pomplatform.client.specialdeduction.datasource.DSSpecialDeductionRecordsApplyOfWorkflow;
import com.pomplatform.client.specialdeduction.form.SpecialDeductionRecordsApplyOfWorkflowSearchForm;
import com.pomplatform.client.specialdeduction.form.SpecialDeductionRecordsApplyOfWorkflowViewer;
import com.pomplatform.client.workflow.panel.MyWorkflowDesignPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class SpecialDeductionRecordsApplyOfWorkflowPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	private static final IButton deleteButton = new IButton("删除");
	private static final IButton editButton= new IButton("撤销修改");
	private static final IButton copyButton= new IButton("复制发起");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			SpecialDeductionRecordsApplyOfWorkflowPanel cm = new SpecialDeductionRecordsApplyOfWorkflowPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SpecialDeductionRecordsApplyOfWorkflow";
		}

	}

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
		
		
//		editButton = new IButton("撤销修改");
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
		
		
//		deleteButton = new IButton("删除", new ClickHandler() {
		deleteButton.addClickHandler(new ClickHandler() {
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
										map.put("optType", "deletePersonnelBusinessAndSpecialDeduction");
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
										if(null != record.getAttribute("specialDeductionRecordId")){
											int specialDeductionRecordId = ClientUtil.checkAndGetIntValue(record.getAttribute("specialDeductionRecordId"));
											if(specialDeductionRecordId > 0){
												map.put("specialDeductionRecordId", record.getAttributeAsInt("specialDeductionRecordId"));
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
		
		
//		copyButton = new IButton("复制发起");
		copyButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("请选择一条记录，再点击复制发起按钮");
							return;
						}
						SC.confirm("确定要复制发起这条记录吗？", new BooleanCallback() {
							
							@Override
							public void execute(Boolean value) {
								if(value){
									Record selected = resultGrid.getSelectedRecords()[0];
									if(null != selected.getAttribute("processStatus") && selected.getAttribute("processStatus").toString().equals("3")){
										SpecialDeductionCopyPanel detailForm = new SpecialDeductionCopyPanel();
				                        detailForm.setTitle("复制发起");
				                        detailForm.addDataEditedHandler(new DataEditedHandler() {
				                            @Override
				                            public void onDataEdited(DataEditEvent event) {
				                                commonQuery();
				                            }
				                        });
				                        detailForm.setSearchForm(searchForm);
				                        detailForm.setRecord(selected);
				                        detailForm.setCurrentPage(getCurrentPage());
				                        detailForm.initComponents();
				                        detailForm.startEdit();
				                        detailForm.setWidth("100%");
				                        detailForm.setHeight("100%");
				                        detailForm.centerInPage();
				                        detailForm.show();
				                        setCurrentPage(detailForm.getCurrentPage());
										
									}else{
										SC.say("抱歉，只有已完成的流程才可复制发起！");
										return;
									}
								}
							}
						});
					}

					@Override
					public void onFailure(Throwable reason) {
						// TODO Auto-generated method stub
						SC.say("请按Ctrl+F5刷新页面再操作");
					}});
			}
		});
		controlLayout.addMember(copyButton);
		
		
		
//		copyButton.addClickHandler(new ClickHandler() {
//			public void onClick(ClickEvent event) {
//					
//					@Override
//					public void onSuccess() {
//						SC.debugger();
//						if (!resultGrid.anySelected()) {
//							SC.say("请选择一条记录，再点击复制发起按钮");
//							return;
//						}
//						SC.confirm("确定要复制发起这条记录吗？", new BooleanCallback() {
//							
//							@Override
//							public void execute(Boolean value) {
//								if(value){
//									Record selected = resultGrid.getSelectedRecords()[0];
//									if(null != selected.getAttribute("processStatus") && selected.getAttribute("processStatus").toString().equals("3")){
//										SpecialDeductionCopyPanel detailForm = new SpecialDeductionCopyPanel();
//				                        detailForm.setTitle("复制发起");
//				                        detailForm.addDataEditedHandler(new DataEditedHandler() {
//				                            @Override
//				                            public void onDataEdited(DataEditEvent event) {
//				                                commonQuery();
//				                            }
//				                        });
//				                        detailForm.setSearchForm(searchForm);
//				                        detailForm.setRecord(selected);
//				                        detailForm.setCurrentPage(getCurrentPage());
//				                        detailForm.initComponents();
//				                        detailForm.startEdit();
//				                        detailForm.setWidth("100%");
//				                        detailForm.setHeight("100%");
//				                        detailForm.centerInPage();
//				                        detailForm.show();
//				                        setCurrentPage(detailForm.getCurrentPage());
//										
//									}else{
//										SC.say("抱歉，只有已完成的流程才可复制发起！");
//										return;
//									}
//								}
//							}
//						});
//					}
//			}
//		});
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
		List<Map> keyvalues = new ArrayList<>();
		criteria.put("employeId",ClientUtil.getEmployeeId());
		if(status==1) {
			Map<String, String> kv2 = new HashMap<>();
			kv2.put("key", "spi.process_status IN ( 0, 1 )");
			kv2.put("value", "spi.process_status IN ( 3, 5 )");
			keyvalues.add(kv2);
			
		}
		if(!BaseHelpUtils.isNullOrEmpty(keyvalues)) {
			criteria.put("keyValues", keyvalues);
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSSpecialDeductionRecordsApplyOfWorkflow.getInstance();
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}
	
	private int activityType;
	private int status;
	public int getActivityType() {
		return activityType;
	}

	public void setActivityType(int activityType) {
		this.activityType = activityType;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		if(status==1) {
			deleteButton.hide();
			editButton.hide();
		}else if(status==2){
			copyButton.hide();
		}
		this.status = status;
	}
	
	


}

