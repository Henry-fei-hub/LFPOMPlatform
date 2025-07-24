package com.pomplatform.client.trainingmanagement.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.BasicPermissionStatic;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.Print;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.NewProcessWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.ui.Image;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.trainingmanagement.datasource.DSTrainingManagement;
import com.pomplatform.client.trainingmanagement.form.NewTrainingManagementForm;
import com.pomplatform.client.trainingmanagement.form.TrainingManagementSearchForm;
import com.pomplatform.client.trainingmanagement.form.TrainingManagementViewer;
import com.pomplatform.client.trainingmanagement.form.UpdateTrainingManagementForm;
import com.pomplatform.client.trainingmanagementdetailor.datasource.DSStrainingmanagementdetailor;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class TrainingManagementPanel extends AbstractExpansionRelatedPage {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			TrainingManagementPanel cm = new TrainingManagementPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "TrainingManagement";
		}

	}


	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				redraw();
				commonQuery();
			}
		});

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		IButton operation1Button = new IButton("查看二维码");
		controlLayout.addMember(operation1Button);
		operation1Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showQRcode();
			}
		});
		
		IButton operation2Button = new IButton("修改");
//		controlLayout.addMember(operation2Button);
		operation2Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}

					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("请选择一条数据修改");
							return;
						}
						final ListGridRecord selected1 = resultGrid.getSelectedRecord();
						UpdateTrainingManagementForm detailForm = new UpdateTrainingManagementForm();
						detailForm.setTitle("修改");
						detailForm.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								DBDataSource.copyRecord(event.getData(), selected1);
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.setRecord(selected1);
//						detailForm.setCurrentPage(getCurrentPage());
						detailForm.initComponents();
//						detailForm.setCompereType(selected1.getAttribute("compereType"));
						detailForm.startEdit();
						detailForm.setWidth("50%");
						detailForm.setHeight("60%");
						detailForm.centerInPage();
						detailForm.show();
//						setCurrentPage(detailForm.getCurrentPage());
					}
				});
			}
		});


		
		IButton newButton = new IButton("培训申请");
//		controlLayout.addMember(newButton);
		newButton.setIcon("[SKIN]/actions/add.png");
		newButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				NewProcessWindow Reimbursement = new NewProcessWindow();
				Reimbursement.setTitle("培训申请");
				Reimbursement.setWidth("60%");
				Reimbursement.setHeight("50%");
				Reimbursement.show();
				Reimbursement.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						//操作成功
//						startEdit();
					}
				});
				Reimbursement.setProcessId(ClientUtil.checkAndGetIntValue(gerProcessId("training_management_information")));
				Reimbursement.setLayoutMode(LayoutConstant.LEFTRIGHT);
				Reimbursement.initComponents();
			}
		});

	
		
		
		IButton operation3Button = new IButton("新建");
//		controlLayout.addMember(operation3Button);
		operation3Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}

					@Override
					public void onSuccess() {

						NewTrainingManagementForm detailForm = new NewTrainingManagementForm();
						detailForm.setTitle("新建");
						detailForm.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								RecordList list = resultGrid.getDataAsRecordList();
								RecordList newList = new RecordList();
								newList.addList(list.getRange(0, list.getLength()));
								newList.add(event.getData());
								resultGrid.setData(newList);
								resultGrid.selectSingleRecord(newList.getLength() - 1);
								Record record = event.getData();
								String subject = record.getAttributeAsString("subject");
								String employee = record.getAttributeAsString("employeeId");
								String compere = record.getAttributeAsString("compere");
								Date startTime = record.getAttributeAsDate("startTime");
								DateTimeFormat tf = DateTimeFormat.getFormat("HH:mm:ss");
								String times = tf.format(startTime);
								Map<String,Integer> map = new HashMap<>();
								map.put("fileId", record.getAttributeAsInt("fileManageId"));
								DBDataSource.callOperation("ST_FileManage", "find", map, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										Record record = dsResponse.getData()[0];
										String fileUrl = record.getAttribute("fileUrl");
										PopupWindow pWindow = new PopupWindow();
										pWindow.setTitle("二维码");
										pWindow.setWidth(315);
										pWindow.setHeight(415);
										pWindow.centerInPage();
										VLayout vLayout = new VLayout();
										vLayout.setWidth("100%");
										vLayout.setHeight("100%");
										vLayout.setAlign(Alignment.CENTER);
										
										HLayout aLayout = new HLayout();
										aLayout.setWidth100();
										aLayout.setHeight("90%");
										Image image = new Image();
//										image.setWidth("50%");
//										image.setHeight("100%");
										image.setUrl(fileUrl);
										aLayout.addMember(image);
										vLayout.addMember(aLayout);
										
										IButton printBtn = new IButton("打印");
										HLayout bLayout = new HLayout();
										bLayout.setWidth100();
										bLayout.setHeight("10%");
										bLayout.setAlign(Alignment.CENTER);
										bLayout.addMember(printBtn);
										printBtn.addClickHandler(new ClickHandler() {
											
											@Override
											public void onClick(ClickEvent event) {
												StringBuilder sb = new StringBuilder();
												sb.append("<html>");
												sb.append("<head>");
												sb.append("<meta charset='UTF-8'>");
												sb.append("<title>扫码进入培训</title>");
												sb.append("</head>");
												sb.append("<body style='position:relative;'>");
												sb.append("<table style='position:absolute;left:30%;font-size:20px;background-color:#333333'>");
												sb.append("<tr>");
												sb.append("<td>主题：</td>");
												sb.append("<td>");
												sb.append(subject);
												sb.append("<td/>");
												sb.append("<tr/>");
												sb.append("<tr>");
												sb.append("<td>主讲人：</td>");
												sb.append("<td>");
												sb.append(compere);
												sb.append("<tr/>");
												sb.append("<td>时间：</td>");
												sb.append("<td>");
												sb.append(times);
												sb.append("<td/>");
												sb.append("<tr>");
//												sb.append("<td></td>");
												sb.append("<td colspan='2'>");
												sb.append("<img src='");
												sb.append(fileUrl);
												sb.append("' width='200px' height='200px'/>");
												Print.it(sb.toString());
												
											}
										});
										vLayout.addMember(bLayout);
										pWindow.addMember(vLayout);
										pWindow.show();
									}
								});		
								
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth("50%");
						detailForm.setHeight("60%");
						detailForm.centerInPage();
						detailForm.show();
						
					}
				});
			}
		});

		IButton downButton = PermissionControl.createPermissionButton("导出", BasicPermissionStatic.EMPLOYEE_EXPORT_BUTTON);
		controlLayout.addMember(downButton);
		downButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Criteria record = searchForm.getValuesAsCriteria();
				Map param = record.getValues();
//				checkSearchCriteria(param);
//				ClientUtil.departmentParameterProcess(param);
				DBDataSource.downloadFile("DW_TrainingManagement", param);
			}
		});

		IButton changeBtn = PermissionControl.createPermissionButton("导出明细", ERPPermissionStatic.AT_DELETE_BTN);
		controlLayout.addMember(changeBtn);
		changeBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){
					SC.say("请先选择一条数据");
					return;
				}
				ListGridRecord selectedRecord = resultGrid.getSelectedRecord();
				int trainingManagementId = BaseHelpUtils.getIntValue(selectedRecord.getAttribute("trainingManagementId"));
				SC.debugger();
				Map param = new HashMap();
				param.put("trainingManagementId",trainingManagementId );
				DBDataSource.downloadFile("DW_Strainingmanagement", param);
			}
		});

		IButton removeButton = new IButton("删除");
//		controlLayout.addMember(removeButton);
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("Please select a data to remove.");
				}
				final ListGridRecord selected = resultGrid.getSelectedRecord();
				DBDataSource.callOperation("ST_TrainingManagement", "delete", selected.toMap(), new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							int indexNum = resultGrid.getRowNum(selected);
							resultGrid.removeData(selected);
							resultGrid.selectSingleRecord(indexNum);
						}
					}
				});
			}
		});
		redraw();
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
				detail.setTitle("培训管理");
				detail.setWidth100();
				detail.setHeight100();
				TrainingManagementViewer detailForm = new TrainingManagementViewer();
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
	
	public void showQRcode(){
		GWT.runAsync(new RunAsyncCallback() {
			
			@Override
			public void onSuccess() {
				if(!resultGrid.anySelected()){
					SC.say("请选择一条数据");
					return;
				}
					ListGridRecord listGridRecord = resultGrid.getSelectedRecord();
					Integer fileID = listGridRecord.getAttributeAsInt("fileManageId");
					Map<String,Integer> map = new HashMap<>();
					String subject = listGridRecord.getAttributeAsString("subject");
					String compere = listGridRecord.getAttributeAsString("compere");
					String employee = listGridRecord.getAttributeAsString("employeeId");
					Date startTime = listGridRecord.getAttributeAsDate("startTime");
					DateTimeFormat tf = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss");
					String times = tf.format(startTime);
					map.put("fileId", fileID);
					DBDataSource.callOperation("ST_FileManage", "find", map, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							Record record = dsResponse.getData()[0];
							String fileUrl = record.getAttribute("fileUrl");
							PopupWindow pWindow = new PopupWindow();
							pWindow.setTitle("二维码");
							pWindow.setWidth(315);
							pWindow.setHeight(415);
							pWindow.centerInPage();
							VLayout vLayout = new VLayout();
							vLayout.setWidth("100%");
							vLayout.setHeight("100%");
							vLayout.setAlign(Alignment.CENTER);
							
							HLayout aLayout = new HLayout();
							aLayout.setWidth100();
							aLayout.setHeight("90%");
							Image image = new Image();
//							image.setWidth("50%");
//							image.setHeight("100%");
							image.setUrl(fileUrl);
							aLayout.addMember(image);
							vLayout.addMember(aLayout);
							
							IButton printBtn = new IButton("打印");
							HLayout bLayout = new HLayout();
							bLayout.setWidth100();
							bLayout.setHeight("10%");
							bLayout.setAlign(Alignment.CENTER);
							bLayout.addMember(printBtn);
//							printBtn.setAlign(Alignment.CENTER);
							printBtn.addClickHandler(new ClickHandler() {
								
								@Override
								public void onClick(ClickEvent event) {
									StringBuilder sb = new StringBuilder();
									sb.append("<html>");
									sb.append("<head>");
									sb.append("<meta charset='UTF-8'>");
									sb.append("<title>扫码进入培训</title>");
									sb.append("</head>");
									sb.append("<body style='position:relative;'>");
									sb.append("<table style='position:absolute;left:30%;font-size:20px;background-color:#333333'>");
									sb.append("<tr>");
									sb.append("<td>主题：</td>");
									sb.append("<td>");
									sb.append(subject);
									sb.append("<td/>");
									sb.append("<tr/>");
									sb.append("<tr>");
									sb.append("<td>主讲人：</td>");
									sb.append("<td>");
									sb.append(compere);
									sb.append("<tr/>");
									sb.append("<td>时间：</td>");
									sb.append("<td>");
									sb.append(times);
									sb.append("<td/>");
									sb.append("<tr>");
//									sb.append("<td></td>");
									sb.append("<td colspan='2'>");
									sb.append("<img src='");
									sb.append(fileUrl);
									sb.append("' width='200px' height='200px'/>");
									Print.it(sb.toString());
									
								}
							});
							vLayout.addMember(bLayout);
							pWindow.addMember(vLayout);
							pWindow.show();
						}
					});
				
				
			}
			
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
				
			}
		});
	}
	
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by training_management_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new TrainingManagementSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSTrainingManagement.getInstance();
	}

	@Override
	public DataSource getChildDataSource() {
		return DSStrainingmanagementdetailor.getInstance();
	}


//	@Override
//	public Canvas[] getChildGridOptionCanvas() {
//		Canvas[] arr = new Canvas[1];
//		IButton changeBtn = PermissionControl.createPermissionButton("导出", ERPPermissionStatic.AT_DELETE_BTN);
//		arr[0] = changeBtn;
//		changeBtn.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//					ListGridRecord selectedRecord = resultChildGrid.getSelectedRecord();
//					int trainingManagementDetailId = BaseHelpUtils.getIntValue(selectedRecord.getAttribute("trainingManagementDetailId"));
//					Criteria record = searchForm.getValuesAsCriteria();
//					Map param = record.getValues();
////					param.put("trainingManagementDetailId",trainingManagementDetailId );
//					DBDataSource.downloadFile("DW_Strainingmanagement", param);
//			}
//		});
//		return arr;
//
//	}

	//获取流程ID
	public String gerProcessId(String workName) {
		String processId = "";
		Storage sta = Storage.getLocalStorageIfSupported();
							String str = sta.getItem(PomPlatformClientUtil.PROCESS_ID_COOKIE);
		if(!PomPlatformClientUtil.isNullOrEmpty(str)){
			String[] arr = str.split(",");
			for(String tempStr : arr){
				String[] tempArr = tempStr.split(":");
				//获取父级ID
				if(tempArr[0].replaceAll("\"", "").equals(workName)){
					processId = tempArr[1];
				}
			}
		}
		return processId;
	}

}
