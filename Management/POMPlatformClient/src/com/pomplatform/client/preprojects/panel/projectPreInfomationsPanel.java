package com.pomplatform.client.preprojects.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.NewProcessWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.storage.client.Storage;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.preprojectanalysisdata.panel.PreProjectAnalysisDataPanel;
import com.pomplatform.client.preprojectmyrecords.panel.PreProjectMyRecordsPanel;
import com.pomplatform.client.preprojectrecord.panel.NewPrePrejectRecordPanel;
import com.pomplatform.client.preprojectrecordremark.panel.preProjectRecordRemarkPanel;
import com.pomplatform.client.preprojects.datasource.DSprojectPreInfomations;
import com.pomplatform.client.preprojects.form.projectPreInfomationsSearchForm;
import com.pomplatform.client.preprojects.form.projectPreInfomationsViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class projectPreInfomationsPanel extends AbstractSearchPanel
{


	private static Logger __logger = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			projectPreInfomationsPanel cm = new projectPreInfomationsPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "projectPreInfomations";
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
		
		IButton addFlowButton = PermissionControl.createPermissionButton("项目报备", ERPPermissionStatic.PRE_PROJECT_REPORT);
		controlLayout.addMember(addFlowButton);
		addFlowButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				final PopupWindow popupWindow = new PopupWindow("项目报备信息");
				popupWindow.setWidth("40%");
				popupWindow.setHeight("85%");
				popupWindow.centerInPage();
				ReportedOfPreProjects assignIntegral = new ReportedOfPreProjects();
				assignIntegral.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				assignIntegral.initComponents();
				popupWindow.addItem(assignIntegral);
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
						commonQuery();
					}
				});
				assignIntegral.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
		
		IButton editButton = PermissionControl.createPermissionButton("修改项目", ERPPermissionStatic.PRE_PROJECT_EDIT);
		controlLayout.addMember(editButton);
		editButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}

					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请选择一条数据进行操作");
							return;
						}
						Record selected = resultGrid.getSelectedRecord();
						int flag = BaseHelpUtils.getIntValue(selected.getAttribute("flag"));
						if(flag == 4){//说明是无效项目
							SC.say("该项目已视为无效项目，不可进行此操作。");
							return;
						}
						
						SC.debugger();
//						0	新建
//						1	进行中
//						2	取消
//						3	完成
//						4	暂停
//						5	驳回
						int processStatus = BaseHelpUtils.getIntValue(selected.getAttribute("processStatus"));
						int status = BaseHelpUtils.getIntValue(selected.getAttribute("status"));
						if(processStatus >= 0){
							if(processStatus == 5){
								SC.say("该项目报备流程审批已被驳回，无法完善项目信息。");
								return;
							}else if(processStatus == 2){
								SC.say("该项目报备流程审批已取消，无法完善项目信息。");
								return;
							}else if(processStatus != 3){
								SC.say("该项目报备流程审批尚未通过，无法完善项目信息。");
								return;
							}
						}
						

						final PopupWindow popupWindow = new PopupWindow("更新项目报备信息");
						popupWindow.setWidth("40%");
						popupWindow.setHeight("85%");
						popupWindow.centerInPage();
						UpdatePreProjects assignIntegral = new UpdatePreProjects();
						assignIntegral.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						assignIntegral.initComponents();
						assignIntegral.setRecord(selected);
						assignIntegral.startEdit();
						popupWindow.addItem(assignIntegral);
						popupWindow.addCloseClickHandler(new CloseClickHandler() {
							@Override
							public void onCloseClick(CloseClickEvent event) {
								popupWindow.destroy();
								commonQuery();
							}
						});
						assignIntegral.setParentWindow(popupWindow);
						popupWindow.centerInPage();
						popupWindow.show();
					
//						UpdatePreProjectInformationForm detailForm = new UpdatePreProjectInformationForm();
//						detailForm.setTitle("修改前期项目信息");
//						detailForm.addDataEditedHandler(new DataEditedHandler() {
//							@Override
//							public void onDataEdited(DataEditEvent event) {
//								commonQuery();
//							}
//						});
//						detailForm.setSearchForm(searchForm);
//						detailForm.setRecord(selected);
//						detailForm.initComponents();
//						detailForm.startEdit();
//						detailForm.setWidth100();
//						detailForm.setHeight100();
//						detailForm.centerInPage();
//						detailForm.show();
					}
				});
			}
		});
		
		IButton addRecordButton = PermissionControl.createPermissionButton("新增记录台账", ERPPermissionStatic.PRE_PROJECT_RECORD);
		controlLayout.addMember(addRecordButton);
		addRecordButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据修改"); return;}
						final ListGridRecord selected = resultGrid.getSelectedRecord();
						int flag = BaseHelpUtils.getIntValue(selected.getAttribute("flag"));
						if(flag == 4){//说明是无效项目
							SC.say("该项目已视为无效项目，不可进行此操作。");
							return;
						}
						int processStatus = BaseHelpUtils.getIntValue(selected.getAttribute("processStatus"));
						int status = BaseHelpUtils.getIntValue(selected.getAttribute("status"));
						if(processStatus!=0) {


							if (processStatus > 0) {
								if (processStatus == 5) {
									SC.say("该项目报备流程审批已被驳回，无法新增记录台账。");
									return;
								} else if (processStatus == 2) {
									SC.say("该项目报备流程审批已取消，无法新增记录台账。");
									return;
								} else if (processStatus != 3 && processStatus != 5 && processStatus != 2) {
									SC.say("该项目报备流程审批尚未通过，无法新增记录台账。");
									return;
								}
							}
						}
						if(status > 0){
							if(status == 1){
								SC.say("该项目立项流程进行中，无法新增记录台账。");
								return;
							}else if(status == 4){
								SC.say("该项目关闭流程进行中，无法新增记录台账。");
								return;
							}else if(status == 5){
								SC.say("该项目关闭，无法新增记录台账。");
								return;
							}
						}
						NewPrePrejectRecordPanel detailForm = new NewPrePrejectRecordPanel();
						detailForm.setTitle("新增前期跟踪记录台账");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.setRecord(selected);
						detailForm.setCurrentPage(getCurrentPage());
						detailForm.setIsContract(false);
						detailForm.initComponents();
						detailForm.setWidth("40%");
						detailForm.setHeight("75%");
						detailForm.startEdit();
						detailForm.centerInPage();
						detailForm.show();
					}
				});
			}
		});
		
		IButton beProjectButton = PermissionControl.createPermissionButton("项目立项", ERPPermissionStatic.BE_PROJECT_APPLY);
		controlLayout.addMember(beProjectButton);
		beProjectButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){
					SC.say("请选择一条数据进行操作");
					return;
				}
				Record selected = resultGrid.getSelectedRecord();
				int flag = BaseHelpUtils.getIntValue(selected.getAttribute("flag"));
				if(flag == 4){//说明是无效项目
					SC.say("该项目已视为无效项目，不可进行此操作。");
					return;
				}
				if(!BaseHelpUtils.isNullOrEmpty(selected.getAttribute("processStatus"))){
					int processStatus = BaseHelpUtils.getIntValue(selected.getAttribute("processStatus"));
					if(processStatus == 5){
						SC.say("该项目报备流程审批已被驳回，无法立项。");
						return;
					}else if(processStatus == 2){
						SC.say("该项目报备流程审批已取消，无法立项。");
						return;
					}else if(processStatus != 3 && processStatus != 5 && processStatus != 2){
						SC.say("该项目报备流程审批尚未通过，无法立项。");
						return;
					}
				}
//				int status = BaseHelpUtils.getIntValue(selected.getAttribute("status"));
//				if(status > 0){
//					if(status == 1){
//						SC.say("该项目正在进行立项流程，请勿重复操作。");
//						return;
//					}else if(status == 2){
//						SC.say("该项目已立项，请勿重复操作。");
//						return;
//					}else if(status == 4){
//						SC.say("该项目正在进行关闭流程，无法立项。");
//						return;
//					}else if(status == 5){
//						SC.say("该项目已关闭，无法立项。");
//						return;
//					}
//				}
				//获取process_id
				String processId = "181";
				Storage sta = Storage.getLocalStorageIfSupported();
							String str = sta.getItem(PomPlatformClientUtil.PROCESS_ID_COOKIE);
		    	if(!PomPlatformClientUtil.isNullOrEmpty(str)){
		    		String[] arr = str.split(",");
		    		for(String tempStr : arr){
		    			String[] tempArr = tempStr.split(":");
		    			//获取父级ID
		    			if(tempArr[0].replaceAll("\"", "").equals("Be_project_apply")){
		    				processId = tempArr[1];
		    			}
		    		}
		    	}
				NewProcessWindow panel = new NewProcessWindow();
				panel.setTitle("项目立项");
				panel.setProcessId(ClientUtil.checkAndGetIntValue(processId));
				panel.setLayoutMode(0);
				panel.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				panel.setData(selected);
				panel.initComponents();
				panel.setWidth100();
				panel.setHeight100();
				panel.centerInPage();
				panel.show();
			}
		});
		
		IButton closeProjectButton = PermissionControl.createPermissionButton("项目关闭", ERPPermissionStatic.CLOSE_PROJECT_APPLY);
		controlLayout.addMember(closeProjectButton);
		closeProjectButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){
					SC.say("请选择一条数据进行操作");
					return;
				}
				Record selected = resultGrid.getSelectedRecord();
				int flag = BaseHelpUtils.getIntValue(selected.getAttribute("flag"));
				if(flag == 4){//说明是无效项目
					SC.say("该项目已视为无效项目，不可进行此操作。");
					return;
				}
				int status = BaseHelpUtils.getIntValue(selected.getAttribute("status"));
				if(!BaseHelpUtils.isNullOrEmpty(selected.getAttribute("processStatus"))){
					int processStatus = BaseHelpUtils.getIntValue(selected.getAttribute("processStatus"));
					if(processStatus != 3 && processStatus != 5 && processStatus != 2){
						SC.say("该项目报备流程审批尚未通过，无法关闭。");
						return;
					}
				}
				if(status > 0){
					if(status == 1){
						SC.say("该项目正在进行立项流程，无法关闭。");
						return;
					}else if(status == 4){
						SC.say("该项目正在进行关闭流程，请勿重复操作。");
						return;
					}else if(status == 5){
						SC.say("该项目已关闭，请勿重复操作。");
						return;
					}
				}
				//获取process_id
				String processId = "";
				Storage sta = Storage.getLocalStorageIfSupported();
							String str = sta.getItem(PomPlatformClientUtil.PROCESS_ID_COOKIE);
		    	if(!PomPlatformClientUtil.isNullOrEmpty(str)){
		    		String[] arr = str.split(",");
		    		for(String tempStr : arr){
		    			String[] tempArr = tempStr.split(":");
		    			//获取父级ID
		    			if(tempArr[0].replaceAll("\"", "").equals("Close_project_apply")){
		    				processId = tempArr[1];
		    			}
		    		}
		    	}
				NewProcessWindow panel = new NewProcessWindow();
				panel.setTitle("项目关闭");
				panel.setProcessId(ClientUtil.checkAndGetIntValue(processId));
				panel.setLayoutMode(0);
				panel.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				panel.setData(selected);
				panel.initComponents();
				panel.setWidth100();
				panel.setHeight100();
				panel.centerInPage();
				panel.show();
			}
		});
		
		IButton transferButton = PermissionControl.createPermissionButton("转单", ERPPermissionStatic.CLOSE_PROJECT_TRANSFER);
		transferButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){
					SC.say("请选择一条数据进行操作");
					return;
				}
				Record rec = resultGrid.getSelectedRecord();
				int flag = BaseHelpUtils.getIntValue(rec.getAttribute("flag"));
				if(flag == 4){//说明是无效项目
					SC.say("该项目已视为无效项目，不可进行此操作。");
					return;
				}
				int processStatus = BaseHelpUtils.getIntValue(rec.getAttribute("processStatus"));
				int status = BaseHelpUtils.getIntValue(rec.getAttribute("status"));
				if(processStatus > 0){
					if(processStatus != 3 && processStatus != 5 && processStatus != 2){
						SC.say("该项目报备流程审批尚未通过，无法转交。");
						return;
					}
				}
				if(status > 0){
					if(status == 1){
						SC.say("该项目正在进行立项流程，无法转交。");
						return;
					}else if(status == 4){
						SC.say("该项目正在进行关闭流程，无法转交。");
						return;
					}else if(status == 5){
						SC.say("该项目已关闭，无法转交。");
						return;
					}
				}
				final PopupWindow popupWindow = new PopupWindow("项目转交");
				popupWindow.setWidth("40%");
				popupWindow.setHeight("80%");
				TransferOfPreProjects panel = new TransferOfPreProjects();
				if(!BaseHelpUtils.isNullOrEmpty(rec)){
					panel.setEmployeeId(BaseHelpUtils.getIntValue(rec.getAttribute("applyEmployeeId")));
					panel.setRecordData(rec);
				}
				panel.initComponents();
				panel.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				popupWindow.addItem(panel);
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
						commonQuery();
					}
				});
				panel.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
		controlLayout.addMember(transferButton);
		
		IButton exportButton = new IButton("导出报表");
		controlLayout.addMember(exportButton);
		exportButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_ExportPreProjectData", condition);
			}
		});
		
		IButton projectInitButton = PermissionControl.createPermissionButton("项目初始化", ERPPermissionStatic.PRE_PROJECT_INIT );
		controlLayout.addMember(projectInitButton );
		projectInitButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}

					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请选择一条数据进行操作");
							return;
						}
						Record selected = resultGrid.getSelectedRecord();
						int flag = BaseHelpUtils.getIntValue(selected.getAttribute("flag"));
						if(flag == 4){//只能初始化无效项目
						int processStatus = BaseHelpUtils.getIntValue(selected.getAttribute("processStatus"));
						int status = BaseHelpUtils.getIntValue(selected.getAttribute("status"));
						if(processStatus > 0){
							if(processStatus == 5){
								SC.say("该项目报备流程审批已被驳回，无法初始化。");
								return;
							}else if(processStatus == 2){
								SC.say("该项目报备流程审批已取消，无法初始化。");
								return;
							}else if(processStatus != 3 && processStatus != 5 && processStatus != 2){
								SC.say("该项目报备流程审批尚未通过，无法初始化。");
								return;
							}
						}
						if(status > 0){
							if(status == 2){
								SC.say("该项目已立项，无法初始化");
								return;
							}else if(status == 5){
								SC.say("该项目关闭，无法初始化。");
								return;
							}
						}
						SC.confirm("提示", "你确定要使项目初始化吗",new BooleanCallback() {
							@Override
							public void execute(Boolean value) {
								if(value) {
									
									if(resultGrid.anySelected()){
										Record record = resultGrid.getSelectedRecords()[0];
										if(!BaseHelpUtils.isNullOrEmpty(record.getAttribute("preProjectId"))){
											Map<String, Object> params = new HashMap<>();
											params.put("preProjectId", record.getAttribute("preProjectId"));
											DBDataSource.callOperation("EP_ProjectInit", params, new DSCallback() {

												@Override
												public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
													if(dsResponse.getStatus() >= 0){
														SC.say("初始化成功！！该项目已初始化有效项目。");
														resultGrid.redraw();
													}
													projectInitButton.setDisabled(false);
												}
											});
										}else{
											SC.say("请选择一条数据再执行本操作");
											projectInitButton.setDisabled(false);
										}
									}
								
								}
							}
						});
                     }else {
                    	   SC.say("只能初始化无效项目,请重新选择!");
							return;
                     }
					}
				});
			}
		});
		
		IButton preProjectRecordRemarkButton = new IButton("部门前期报表");
		controlLayout.addMember(preProjectRecordRemarkButton);
		preProjectRecordRemarkButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GenericViewWindow details = new GenericViewWindow();
				details.setTitle("部门前期报表"); 
				details.setWidth100(); 
				details.setHeight100(); 
				preProjectRecordRemarkPanel  detailsForm=new preProjectRecordRemarkPanel();
				detailsForm.commonQuery();
				details.setContent(detailsForm);
				details.centerInPage();
				details.show();
				
			}
		});
		
		IButton preProjectMyRecords = new IButton("我的前期项目");
		controlLayout.addMember(preProjectMyRecords);
		preProjectMyRecords.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GenericViewWindow details = new GenericViewWindow();
				details.setTitle("我的前期项目"); 
				details.setWidth100(); 
				details.setHeight100(); 
				PreProjectMyRecordsPanel  detailsForm=new PreProjectMyRecordsPanel();
				detailsForm.commonQuery();
				details.setContent(detailsForm);
				details.centerInPage();
				details.show();
				
			}
		});
		
		IButton preProjectAnalysisData = new IButton("投标数据分析");
		controlLayout.addMember(preProjectAnalysisData);
		preProjectAnalysisData.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GenericViewWindow details = new GenericViewWindow();
				details.setTitle("投标数据分析"); 
				details.setWidth100(); 
				details.setHeight100(); 
				PreProjectAnalysisDataPanel  detailsForm=new PreProjectAnalysisDataPanel();
				detailsForm.commonQuery();
				details.setContent(detailsForm);
				details.centerInPage();
				details.show();
				
			}
		});
		
		IButton quoteButton = PermissionControl.createPermissionButton("项目报价", ERPPermissionStatic.QUOTE_BUTTON);
		controlLayout.addMember(quoteButton);
		quoteButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){
					SC.say("请选择一条数据进行操作");
					return;
				}
				Record rec = resultGrid.getSelectedRecord();
				int flag = BaseHelpUtils.getIntValue(rec.getAttribute("flag"));
				if(flag == 4){//说明是无效项目
					SC.say("该项目已视为无效项目，不可进行此操作。");
					return;
				}
				int processStatus = BaseHelpUtils.getIntValue(rec.getAttribute("processStatus"));
				int status = BaseHelpUtils.getIntValue(rec.getAttribute("status"));
				if(processStatus > 0){
					if(processStatus != 3 && processStatus != 5 && processStatus != 2){
						SC.say("该项目报备流程审批尚未通过，不可进行此操作。");
						return;
					}
				}
				if(status > 0){
					if(status == 1){
						SC.say("该项目正在进行立项流程，不可进行此操作。");
						return;
					}else if(status == 4){
						SC.say("该项目正在进行关闭流程，不可进行此操作。");
						return;
					}else if(status == 5){
						SC.say("该项目已关闭，不可进行此操作。");
						return;
					}
				}
				int projectType=BaseHelpUtils.getIntValue(rec.getAttribute("projectType"));
				if(projectType<=0) {
					SC.say("该项目无业态,不可进行项目报价");
					return;
				}
				final PopupWindow popupWindow = new PopupWindow("项目报价");
				popupWindow.setWidth100();
				popupWindow.setHeight100();
				ProjectQuotePanel panel = new ProjectQuotePanel();
				if(!BaseHelpUtils.isNullOrEmpty(rec)){
					panel.setRecordData(rec);
				}
				panel.initComponents();
				//panel.lodaData();
				popupWindow.addItem(panel);
				panel.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
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
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("前期项目信息"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				projectPreInfomationsViewer detailForm = new projectPreInfomationsViewer();
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		//如果没有查看全部数据的权限和没有自己管理部门的权限的话只能查看自己的
		/*if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.PRE_PROJECT_CHECK_ALL_DATA) && !ClientUtil.checkIsHavePermission(ERPPermissionStatic.PRE_PROJECT_CHECK_PLATE_DATA)){
			//criteria.put("applyEmployeeId", ClientUtil.getEmployeeId());
			criteria.put("employeeId", ClientUtil.getEmployeeId());	
		}*/
		SC.debugger();
		//如果没有查看全部的权限
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.PRE_PROJECT_CHECK_ALL_DATA)){
			criteria.put("employeeId", ClientUtil.getEmployeeId());
		}

		List<Map> keyvalues = new ArrayList<>();
		//如果没有查看部门的权限
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.PRE_PROJECT_CHECK_PLATE_DATA)){
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "or e.department_id IN ( SELECT child_id FROM department_ids WHERE department_id =?)");
			kv.put("value", "or e.department_id=?");
			keyvalues.add(kv);
		}

		if(!BaseHelpUtils.isNullOrEmpty(keyvalues) && keyvalues.size() > 0){
			criteria.put("keyValues", keyvalues);
		}
		
		criteria.put("addtionalCondition", "order by contract_id desc");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		projectPreInfomationsSearchForm from =	new projectPreInfomationsSearchForm();
		return from;
	}

	@Override
	public DataSource getDataSource() {
		return DSprojectPreInfomations.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 210;
	}
	
	@Override
	public void afterDataReceived(Record[] data) {
		if(!BaseHelpUtils.isNullOrEmpty(data) && data.length > 0){
			for(Record e : data){
				int winRate = BaseHelpUtils.getIntValue(e.getAttribute("winRate"));
				if(winRate > 0){
					e.setAttribute("winRate", e.getAttribute("winRate")+"%");
				}
			}
		}
	}
	


}

