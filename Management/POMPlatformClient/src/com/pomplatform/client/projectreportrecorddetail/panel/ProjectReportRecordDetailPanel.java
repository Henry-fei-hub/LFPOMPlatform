package com.pomplatform.client.projectreportrecorddetail.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.managementteamproject.datasource.DSMManagementTeamProject;
import com.pomplatform.client.projectreportrecorddetail.datasource.DSProjectReportRecordDetail;
import com.pomplatform.client.projectreportrecorddetail.form.ProjectReportRecordDetailSearchForm;
import com.pomplatform.client.projectreportrecorddetail.form.ProjectReportRecordDetailViewer;
import com.pomplatform.client.projectview.form.SprojectViewViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SelectionAppearance;
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

public class ProjectReportRecordDetailPanel extends AbstractSearchPanel {

	private String plateIds;
	private String[] plateIdArr;
	String[] plateParamArr;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			ProjectReportRecordDetailPanel cm = new ProjectReportRecordDetailPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ProjectReportRecordDetail";
		}

	}

	@Override
	public void init() {
		super.init();
		resultGrid = new DelicacyListGrid(){
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				//获取项目状态，如果项目暂停，则该行的字体颜色为红色，如果项目已结束，则该行的字体颜色为绿色
				int status = ClientUtil.checkAndGetIntValue(record.getAttribute("status"));
				if (status == ClientStaticUtils.PROJECT_STATUS_11) {  //项目已结束,标绿色
					return "color:#00B736;";  
				} else if (status == ClientStaticUtils.PROJECT_STATUS_10) {  //项目暂停,标红色
					return "color:#F01813;";  
				}else if(status == ClientStaticUtils.PROJECT_STATUS_5) {
					return "color:#DAA520;"; //项目无进度变为橘黄色
				}
				
				else {  
					return super.getCellCSSText(record, rowNum, colNum);  
				}  
			}
		};
		resultGrid.setDataSource(getDataSource());
		resultGrid.setShowRowNumbers(true);
		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
	}

	@Override
	public void initComponents() {
		plateIds = PomPlatformClientUtil.getRolePlateId();
		plateIdArr = plateIds.split(",");

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
				ListGridRecord[] selected = resultGrid.getSelectedRecords();
				int projectId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("projectId"));
				// 获取项目名称
//				final String projectName = KeyValueManager.getValue("projects", projectId + "");
				//修改下拉值的获取方式
				String projectName = SyncDataUtil.getProjectName(projectId);
//				Record record = getProjectName(projectId);
//				String projectName = BaseHelpUtils.getString(record.getAttribute("projectName"));
				final DelicacyListGrid projectViewGrid = new DelicacyListGrid();
				projectViewGrid.setDataSource(DSMManagementTeamProject.getInstance());
				Map condition = new java.util.HashMap();
				condition.put("projectId", projectId);
				List<Map> keyvalues = new ArrayList<>();
				Map<String, String> kv = new HashMap<>();
				kv.put("key", "p.department_id in (select child_id from department_ids where department_id = ? )");
				kv.put("value", "1 = 1");
				keyvalues.add(kv);
				condition.put("keyValues", keyvalues);
				DBDataSource.callOperation("NQ_MManagementTeamProject", "find", condition, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							projectViewGrid.setData(dsResponse.getData());
							projectViewGrid.selectRecord(0);
							GenericViewWindow detail = new GenericViewWindow();
							detail.setTitle("项目(" + projectName + ")的相关信息");
							detail.setWidth100();
							detail.setHeight100();
							SprojectViewViewer detailForm = new SprojectViewViewer();
							detailForm.setParentSearchForm(searchForm);
							detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
							detailForm.initComponents();
							detailForm.viewSelectedData(projectViewGrid);
							detail.setContent(detailForm);
							detail.centerInPage();
							detail.show();
						}
					}
				});
			}
		});

		IButton downLoadButton = new IButton("导出");
		controlLayout.addMember(downLoadButton);
		downLoadButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				ClientUtil.departmentParameterProcess(condition);
				DBDataSource.downloadFile("DW_ProjectReportRecordDetailHandler", condition);
			}
		});

		IButton totalButton = new IButton("汇总");
		controlLayout.addMember(totalButton);
		totalButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] recordList = resultGrid.getRecords();
				if (null != recordList && recordList.length > 0) {
					int length = recordList.length;
					if ("汇总".equals(recordList[length - 1].getAttribute("contractCode"))) {// 如果已经存在汇总，则不可再进行汇总
						return;
					}
					double totalIntegral = 0;// 项目总积分
					double complaintIntegral = 0;// 投诉保证金
					double projectIntegral = 0;// 项目积分
					double reserveIntegral = 0;// 预留积分
					double sureIntegral = 0;// 确认积分
					double projectCost = 0;// 项目成本
					double subtractComplaintIntegral = 0;// 扣除的投诉保证金
					Record[] records = new Record[length + 1];
					for (int i = 0; i < length; i++) {
						records[i] = recordList[i];
						totalIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("totalIntegral"));
						complaintIntegral += ClientUtil
								.checkAndGetDoubleValue(recordList[i].getAttribute("complaintIntegral"));
						projectIntegral += ClientUtil
								.checkAndGetDoubleValue(recordList[i].getAttribute("projectIntegral"));
						reserveIntegral += ClientUtil
								.checkAndGetDoubleValue(recordList[i].getAttribute("reserveIntegral"));
						sureIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("sureIntegral"));
						projectCost += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("projectCost"));
						subtractComplaintIntegral += ClientUtil
								.checkAndGetDoubleValue(recordList[i].getAttribute("subtractComplaintIntegral"));
					}
					Record record = new Record();
					record.setAttribute("contractCode", "汇总");
					record.setAttribute("totalIntegral", totalIntegral);
					record.setAttribute("complaintIntegral", complaintIntegral);
					record.setAttribute("projectIntegral", projectIntegral);
					record.setAttribute("reserveIntegral", reserveIntegral);
					record.setAttribute("sureIntegral", sureIntegral);
					record.setAttribute("projectCost", projectCost);
					record.setAttribute("subtractComplaintIntegral", subtractComplaintIntegral);
					records[length] = record;
					resultGrid.setData(records);
					resultGrid.redraw();
					resultGrid.setCanEdit(false);
				}
			}
		});

		IButton pauseButton = PermissionControl.createPermissionButton("订单暂停", ERPPermissionStatic.PROJECT_GATHER_MANAGEMENT_PAUSE_BUTTON);
		controlLayout.addMember(pauseButton);
		pauseButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say(ClientStaticUtils.WARNING);
                    }

                    @Override
                    public void onSuccess() {
                        if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据再执行本操作");
                            return;
                        }
                        pauseButton.setDisabled(true);
                        Record selected = resultGrid.getSelectedRecord();
                        String projectId = selected.getAttribute("projectId");
                        int status = ClientUtil.checkAndGetIntValue(selected.getAttribute("status"));
                        switch (status) {
                        case ClientStaticUtils.PROJECT_STATUS_10:
                        	SC.say("该订单已暂停，无需再次操作");
                        	pauseButton.setDisabled(false);
                        	return;
                        case ClientStaticUtils.PROJECT_STATUS_11:
                        	SC.say("该订单已结项，不可进行暂停操作");
                        	pauseButton.setDisabled(false);
                        	return;
                        case ClientStaticUtils.PROJECT_STATUS_14:
                        	SC.say("该订单正在终止结算中，不可以进行暂停操作");
                        	pauseButton.setDisabled(false);
                        	return;
                        case ClientStaticUtils.PROJECT_STATUS_15:
                        	SC.say("该订单已终止，不可以进行暂停操作");
                        	pauseButton.setDisabled(false);
                        	return;
                        default:
                        	SC.confirm("提示","您确定要进行订单暂停操作吗?", new BooleanCallback() {
                                @Override
                                public void execute(Boolean value) {
                                    if(BaseHelpUtils.getBoolean(value)){
                                    	Map<String, Object> params = new HashMap<>();
										params.put("optType", "changeProjectStatus");
										params.put("projectId", projectId);
										params.put("status", ClientStaticUtils.PROJECT_STATUS_10);
										DBDataSource.callOperation("EP_ProjectProcessor", params, new DSCallback() {

											@Override
											public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
												if(dsResponse.getStatus() >= 0){
													SC.say("操作成功");
													selected.setAttribute("status",  ClientStaticUtils.PROJECT_STATUS_10);
			                        				resultGrid.updateData(selected);
												}else {
													ClientUtil.displayErrorMessage(dsResponse);
												}
												pauseButton.setDisabled(false);
											}
										});
                                    }else {
                                    	pauseButton.setDisabled(false);
                                    }
                                }
                            });
                        }
                    }
                });
            }
		});

		IButton runButton = PermissionControl.createPermissionButton("订单运行", ERPPermissionStatic.PROJECT_GATHER_MANAGEMENT_RUN_BUTTON);
		controlLayout.addMember(runButton);
		runButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say(ClientStaticUtils.WARNING);
                    }

                    @Override
                    public void onSuccess() {
                        if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据再执行本操作");
                            return;
                        }
                        runButton.setDisabled(true);
                        Record selected = resultGrid.getSelectedRecord();
                        String projectId = selected.getAttribute("projectId");
                        int status = ClientUtil.checkAndGetIntValue(selected.getAttribute("status"));
                        switch (status) {
                        case ClientStaticUtils.PROJECT_STATUS_2:
                        	SC.say("该订单已处于订单运行状态，无需再次操作");
                        	runButton.setDisabled(false);
                        	return;
                        case ClientStaticUtils.PROJECT_STATUS_11:
                        	SC.say("该订单已结项，不可进行订单运行操作");
                        	runButton.setDisabled(false);
                        	return;
                        case ClientStaticUtils.PROJECT_STATUS_14:
                        	SC.say("该订单正在终止结算中，不可以进行订单运行操作");
                        	runButton.setDisabled(false);
                        	return;
                        case ClientStaticUtils.PROJECT_STATUS_15:
                        	SC.say("该订单已终止，不可以进行订单运行操作");
                        	runButton.setDisabled(false);
                        	return;
                        default:
                        	SC.confirm("提示","您确定要使该订单重新处于运行状态吗?", new BooleanCallback() {
                                @Override
                                public void execute(Boolean value) {
                                    if(BaseHelpUtils.getBoolean(value)){
                                    	Map<String, Object> params = new HashMap<>();
										params.put("optType", "changeProjectStatus");
										params.put("projectId", projectId);
										params.put("status", ClientStaticUtils.PROJECT_STATUS_2);
										DBDataSource.callOperation("EP_ProjectProcessor", params, new DSCallback() {

											@Override
											public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
												if(dsResponse.getStatus() >= 0){
													SC.say("操作成功");
			                        				commonQuery();
												}else {
													ClientUtil.displayErrorMessage(dsResponse);
												}
												runButton.setDisabled(false);
											}
										});
                                    }else {
                                    	runButton.setDisabled(false);
                                    }
                                }
                            });
                        }
                    }
                });
			}
		});

		final IButton noneButton = PermissionControl.createPermissionButton("项目无进度", ERPPermissionStatic.PROJECT_GATHER_MANAGEMENT_none_BUTTON);
		controlLayout.addMember(noneButton);
		noneButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {

					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("请选择需要变为无进度状态的订单");
							return;
						}
						noneButton.setDisabled(true);
						Record record = resultGrid.getSelectedRecord();
						String projectId = record.getAttribute("projectId");
						int status = ClientUtil.checkAndGetIntValue(record.getAttribute("status"));
						switch (status) {
						case ClientStaticUtils.PROJECT_STATUS_5:
							SC.say("该订单已无进度，无需再次操作");
							noneButton.setDisabled(false);
							break;
						case ClientStaticUtils.PROJECT_STATUS_2:
						case ClientStaticUtils.PROJECT_STATUS_17:
							SC.confirm("提示", "你确定要使项目变为无进度状态吗", new BooleanCallback() {

								@Override
								public void execute(Boolean value) {
									if (BaseHelpUtils.getBoolean(value)) {
										Map<String, Object> param = new HashMap<>();
										param.put("projectId", projectId);
										param.put("status", ClientStaticUtils.PROJECT_STATUS_5);// 项目无进度值：5
										param.put("operateEmployeeId", ClientUtil.getEmployeeId());
										String message = MapUtils.toJSON(param);
										// 订单暂停方法
										DBDataSource.callOperation("EP_ProjectStatus", "update", message, new DSCallback() {
											@Override
											public void execute(DSResponse dsResponse, Object data,
													DSRequest dsRequest) {
												if (dsResponse.getStatus() >= 0) {
													SC.say("操作成功");
													// 执行成功后重新执行查询，刷新表格数据
													record.setAttribute("status", ClientStaticUtils.PROJECT_STATUS_5);
													resultGrid.redraw();
												} else {
													ClientUtil.displayErrorMessage(dsResponse);
												}
												noneButton.setDisabled(false);
											}
										});
									}else {
										noneButton.setDisabled(false);
									}
								}
							});
							break;
						default:
							SC.say("只有处于订单运行或订单收尾的订单，才可以变为无进度状态");
							noneButton.setDisabled(false);
							break;
						}
					}
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});

//		IButton endButton = PermissionControl.createPermissionButton("订单结项", ERPPermissionStatic.PROJECT_GATHER_MANAGEMENT_END_BUTTON);
//		controlLayout.addMember(endButton);
//		endButton.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//				GWT.runAsync(new RunAsyncCallback() {
//
//					@Override
//					public void onSuccess() {
//						SC.confirm("提示","您确定进行订单结项操作吗?", new BooleanCallback() {
//							@Override
//							public void execute(Boolean value) {
//								if(value){
//									endButton.setDisabled(true);
//									if(resultGrid.anySelected()){
//										Record record = resultGrid.getSelectedRecords()[0];
//										if(null == record.getAttribute("status") || ClientUtil.checkAndGetIntValue(record.getAttributeAsInt("status")) != ClientStaticUtils.PROJECT_STATUS_11){
//											Map<String, Object> params = new HashMap<>();
//											params.put("optType", "changeProjectStatus");
//											params.put("projectId", record.getAttribute("projectId"));
//											params.put("status", ClientStaticUtils.PROJECT_STATUS_11);
//											params.put("operator", ClientUtil.getUserId());
//											DBDataSource.callOperation("EP_ProjectProcessor", params, new DSCallback() {
//
//												@Override
//												public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//													if(dsResponse.getStatus() >= 0){
//														record.setAttribute("status", ClientStaticUtils.PROJECT_STATUS_11);
//														resultGrid.redraw();
//													}else{
//														ClientUtil.displayErrorMessage(dsResponse);
//													}
//													endButton.setDisabled(false);
//												}
//											});
//										}else{
//											endButton.setDisabled(false);
//										}
//									}else{
//										SC.say("请选择一条数据再执行本操作");
//										endButton.setDisabled(false);
//									}
//								}
//							}
//						});
//					}
//					@Override
//					public void onFailure(Throwable reason) {
//						SC.say(ClientStaticUtils.WARNING);
//					}
//				});
//			}
//		});
		
		
		final IButton projectEidtButton = PermissionControl.createPermissionButton("订单编辑", ERPPermissionStatic.PROJECT_EDIT_BUTTON);
		controlLayout.addMember(projectEidtButton);
		projectEidtButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()) {SC.say("请选择一条订单");return;}
				Record selectedRecord = resultGrid.getSelectedRecord();
				final PopupWindow popupWindow = new PopupWindow("订单编辑");
				ProjectEidtPanel editPanel = new ProjectEidtPanel();
				editPanel.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
						SC.say("提示", "操作成功");
					}
				});
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
					}
				});
				popupWindow.addItem(editPanel);
				editPanel.setParentCanvas(popupWindow);
				editPanel.setParentWindow(popupWindow);
				editPanel.setRecord(selectedRecord);
				editPanel.initComponents();
				editPanel.startEdit();
				popupWindow.setWidth("33%");
				popupWindow.setHeight("37%");
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
		
		final IButton settlementEidtButton = PermissionControl.createPermissionButton("结算信息编辑", ERPPermissionStatic.PROJECT_SETTLEMENT_EDIT_BUTTON);
		controlLayout.addMember(settlementEidtButton);
		settlementEidtButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Record selectedRecord = resultGrid.getSelectedRecord();
				final PopupWindow popupWindow = new PopupWindow("订单结算信息编辑");
				ProjectSettlementEidtPanel editPanel = new ProjectSettlementEidtPanel();
				editPanel.setParentWindow(popupWindow);
				editPanel.initComponents();
				editPanel.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
						SC.say("提示", "操作成功");
					}
				});
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
					}
				});
				popupWindow.addItem(editPanel);
				popupWindow.setWidth100();
				popupWindow.setHeight100();
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});

		IButton iButton = new IButton("更换部门经理");
		iButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				ListGridRecord[] selectedRecords = resultGrid.getSelectedRecords();
				if (BaseHelpUtils.isNullOrEmpty(selectedRecords) || selectedRecords.length == 0) {
					SC.say("提示:", "请选择需要更换部门经理的数据" );
					return;
				}
				PopupWindow popupWindow = new PopupWindow();
				popupWindow.setTitle("更换订单部门经理");
				popupWindow.setWidth("20%");
				popupWindow.setHeight("40%");
				popupWindow.centerInPage();
				EditDepartmentManagerPanel editDepartmentManagerPanel = new EditDepartmentManagerPanel();
				editDepartmentManagerPanel.initCompetition();
				editDepartmentManagerPanel.setListGridRecords(selectedRecords);
				editDepartmentManagerPanel.setParentPanel(new ProjectReportRecordDetailPanel());
				editDepartmentManagerPanel.setParenWindow(popupWindow);
				popupWindow.addMember(editDepartmentManagerPanel);
				popupWindow.show();

			}
		});
		controlLayout.addMember(iButton);


		resultGrid.setShowRowNumbers(true);
		
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
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("项目积分汇总");
				detail.setWidth100();
				detail.setHeight100();
				ProjectReportRecordDetailViewer detailForm = new ProjectReportRecordDetailViewer();
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
		SC.debugger();
		Object departmentManagerId = criteria.get("departmentManagerId");
		if (null != departmentManagerId) {
			criteria.put("departmentManagerId", departmentManagerId);
		}
		// 如果拥有查看所有部门数据，则加载所有数据
		/*if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_GATHER_MANAGEMENT_CHECK_ALL_DATA)) {
			return true;
		}
		else if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_GATHER_MANAGEMENT_CHECK_ALL_DATA)
				&& ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_GATHER_MANAGEMENT_CHECK_MYPLATE_DATA)) {
			*//*
			 * 只拥有查看自己部门数据的权限
			 * ①用户是否在部门选择下拉框选择了某一个部门想进行信息查看？
			 * ②Y:用户是否拥有该部门的数据查看权限？ →有权限：返回true； 没有权限：返回false
			 * ③N:默认加载该用户所可以查看的所有部门的信息
			 *//*
			String selectPlateId = BaseHelpUtils.getString(criteria.get("plateId"));
			if (BaseHelpUtils.isNullOrEmpty(selectPlateId)) {
				if(BaseHelpUtils.isNullOrEmpty(plateIdArr)||plateIdArr.length==0){
					criteria.put("plateId", ClientUtil.getDepartmentId());
				}else{
					StringBuffer plateIds = new StringBuffer("("+ClientUtil.getDepartmentId());
					for (int i=0;i<plateIdArr.length;i++) {
						if(!BaseHelpUtils.isNullOrEmpty(plateIdArr[i])){
							plateIds.append(",").append(plateIdArr[i]);
						}
					}
					plateIds.append(")");
					List<Map> keyvalues = new ArrayList<>();
					Map<String, String> kv = new HashMap<>();
					kv.put("key", "999=999");
					kv.put("value", "A.plate_id in " + plateIds.toString());
					keyvalues.add(kv);
					criteria.put("keyValues", keyvalues);
				}
				return true;
			} else {
				for (String str : plateIdArr) {
					if (selectPlateId.equals(str)) {
						criteria.put("plateId", str);
						return true;
					}
				}
			}
		}*/
		// 如果拥有查看所有部门数据，则加载所有数据
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_GATHER_MANAGEMENT_CHECK_ALL_DATA)) {
			return true;
		} else if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_GATHER_MANAGEMENT_CHECK_ALL_DATA)
				&& ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_GATHER_MANAGEMENT_CHECK_MYPLATE_DATA)) {
			/*
			 * 只拥有查看自己部门数据的权限
			 * ①用户是否在部门选择下拉框选择了某一个部门想进行信息查看？
			 * ②Y:用户是否拥有该部门的数据查看权限？ →有权限：返回true； 没有权限：返回false
			 * ③N:默认加载该用户所可以查看的所有部门的信息
			 */
			String selectPlateId = BaseHelpUtils.getString(criteria.get("plateId"));
			if (BaseHelpUtils.isNullOrEmpty(selectPlateId)) {
				if (BaseHelpUtils.isNullOrEmpty(plateIds)) {
					criteria.put("plateId", ClientUtil.getPlateId());
				} else {
					List<Map> keyvalues = new ArrayList<>();
					Map<String, String> kv = new HashMap<>();
					kv.put("key", " A.plate_id > 0");
					kv.put("value", " A.plate_id > 0 and A.plate_id in (" + plateIds.toString() + ")");
					keyvalues.add(kv);
					criteria.put("keyValues", keyvalues);
				}
				return true;
			} else {
				for (String str : plateIdArr) {
					if (selectPlateId.equals(str)) {
						return true;
					}
				}
			}
		}
		SC.warn("提示", "您没有查看该部门数据的权限");
		return false;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new ProjectReportRecordDetailSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSProjectReportRecordDetail.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return super.getSearchFormHeight();
	}

	/**
	 * 获取项目的名称
	 * @param projectId
	 * @return
	 */
	private Record getProjectName(Integer projectId){
		Record record = new Record();
		HashMap<Object, Object> map = new HashMap<>();
		map.put("projectId",projectId);
		DBDataSource.callOperation("ST_Project", "find", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record[] records = dsResponse.getData();
					if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
						//获取项目名称
						String projectName = BaseHelpUtils.getString(records[0].getAttribute("projectName"));
						record.setAttribute("projectName",projectName);
					}
				}
			}
		});
		return record;
	}
}
