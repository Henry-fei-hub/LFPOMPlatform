package com.pomplatform.client.attachment.panel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.attachment.datasource.DSMcontractcacccccaaaraabbifiior;
import com.pomplatform.client.attachment.datasource.DSSattachmentmanageaaaor;
import com.pomplatform.client.attachment.form.McontractcacccccaaaraabbifiiorSearchForm;
import com.pomplatform.client.attachment.form.McontractcacccccaaaraabbifiiorViewer;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridContractValue;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.events.KeyPressEvent;
import com.smartgwt.client.widgets.events.KeyPressHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.ChangeEvent;
import com.smartgwt.client.widgets.grid.events.ChangeHandler;
import com.smartgwt.client.widgets.grid.events.EditorExitEvent;
import com.smartgwt.client.widgets.grid.events.EditorExitHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class McontractcacccccaaaraabbifiiorPanel extends AbstractExpansionRelatedPage {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			McontractcacccccaaaraabbifiiorPanel cm = new McontractcacccccaaaraabbifiiorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Mcontractcacccccaaaraabbifiior";
		}

	}

	@Override
	public void initComponents() {
		if(null != form) {
			form.setWidth("98%");
		}
		resultGrid.setCanDragSelectText(true);
		resultGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
		resultGrid.setDrawAheadRatio(4);
		resultGrid.setShowGridSummary(true);
		resultGrid.setShowRowNumbers(true);
		ListGridField [] fields = new ListGridField[20];
		int index = 0;
		fields[index] = new ListGridField("contractStatus");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("contractInfoAudited");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("contractCode");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("contractName");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("customerName");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("signingMoneySum");
		index ++;
		fields[index] = new ListGridField("projectAmount");
		index ++;
		fields[index] = new ListGridField("invoiceAmount");
		index ++;
		fields[index] = new ListGridField("borrowMoney");
		index ++;
		fields[index] = new ListGridField("currentBorrowMoney");
		index ++;
		fields[index] = new ListGridField("currentAmount");
		index ++;
		fields[index] = new ListGridField("designAreas");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("count");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("checkAmount");
		index ++;
		fields[index] = new ListGridField("capitalDate");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("invoiceDate");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("settlementDate");
		fields[index].setShowGridSummary(false);
		resultGrid.setFields(fields);
		
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
		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
		operation1Button.setIcon("[SKIN]/actions/view.png");
		operation1Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		IButton exportBtn = new IButton("导出");
		controlLayout.addMember(exportBtn);
		exportBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				DBDataSource.downloadFile("DW_Mcontractcacccccaaaraabbifiior", generateCriteria());
			}
		});
		IButton auditButton = new IButton("合同信息无误");
		controlLayout.addMember(auditButton);
		auditButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请选择一条数据");
						}
						Record record = resultGrid.getSelectedRecords()[0];
						Map<String, String> params = new HashMap<>();
						params.put("contractId", record.getAttribute("contractId"));
						params.put("contractInfoAudited", "true");
						DBDataSource.callOperation("ST_Contract", "saveOrUpdate", params, new DSCallback() {
		                    @Override
		                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
		                        if (dsResponse.getStatus() < 0) {
		                            ClientUtil.displayErrorMessage(dsResponse);
		                        }else{
		                        	record.setAttribute("contractInfoAudited", true);
		                        	resultGrid.updateData(record);
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
		
		IButton cancleAuditButton = new IButton("合同信息未审核");
		controlLayout.addMember(cancleAuditButton);
		cancleAuditButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请选择一条数据");
						}
						Record record = resultGrid.getSelectedRecords()[0];
						Map<String, String> params = new HashMap<>();
						params.put("contractId", record.getAttribute("contractId"));
						params.put("contractInfoAudited", "false");
						DBDataSource.callOperation("ST_Contract", "saveOrUpdate", params, new DSCallback() {
		                    @Override
		                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
		                        if (dsResponse.getStatus() < 0) {
		                            ClientUtil.displayErrorMessage(dsResponse);
		                        }else{
		                        	record.setAttribute("contractInfoAudited", false);
		                        	resultGrid.updateData(record);
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
				detail.setTitle("合同确认函管理详情");
				detail.setWidth100();
				detail.setHeight100();
				McontractcacccccaaaraabbifiiorViewer detailForm = new McontractcacccccaaaraabbifiiorViewer();
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
	public Canvas[] getChildGridOptionCanvas() {
		Canvas[] arr = new Canvas[4];
		IButton changeBtn = PermissionControl.createPermissionButton("确认函移动", ERPPermissionStatic.AT_DELETE_BTN);
		changeBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultChildGrid.anySelected()){
//					MoveAttachmentPanel movePanel = new MoveAttachmentPanel();
					
					ListGridField contractNameField = new ListGridField("contractName");
					ListGridField contractCodeField = new ListGridField("contractCode");
					
					PopupWindow pw = new PopupWindow();
					pw.setWidth(600);
					pw.setHeight(350);
					pw.setPadding(15);
					VLayout panel = new VLayout();
					panel.setLayoutTopMargin(30);
					DynamicForm _form = new DynamicForm();
					ComboBoxItem contractItem = new ComboBoxItem("合同");
					contractItem.setWidth("*");
					contractItem.setValueField("contractId");
					contractItem.setRequired(true);
					contractItem.setDisplayField("contractName");
					contractItem.setOptionDataSource(DSSelectGridContractValue.getInstance());
					contractItem.setPickListFields(contractCodeField, contractNameField);
					_form.setItems(contractItem);
					_form.setHeight100();
					ClientUtil.DynamicFormProcessAccordingToDevice(_form);
					
					HLayout controlLayout = new HLayout();
					controlLayout.setWidth("100%");
					controlLayout.setHeight(70);
					controlLayout.setAlign(Alignment.CENTER);
					controlLayout.setBottom(20);
					
					IButton changeBtn = new IButton("确认");
					changeBtn.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							if(_form.validate()){
								String contractIds = "";
								Record [] records = resultChildGrid.getSelectedRecords();
								for (int i = 0; i < records.length; i++) {
									if(i > 0){
										contractIds += ",";
									}
									contractIds += records[i].getAttribute("attachmentManageId");
								}
								Map<String, Object> params = new HashMap<>();
								params.put("contractIds", contractIds);
								params.put("contractId", contractItem.getValue());
								params.put("opt_type", "moveAttachment");
								DBDataSource.callOperation("EP_CustomAttachmentWorkProcess", params, new DSCallback() {
									
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										pw.destroy();
										if(dsResponse.getStatus() > 0){
											resultChildGrid.refreshData();
										}else{
											ClientUtil.displayErrorMessage(dsResponse);
										}
										
									}
								});
								
							}else{
								SC.say("请选择合同");
							}
							
						}
					});
					
					IButton cancelBtn = new IButton("取消");
					cancelBtn.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							pw.destroy();
						}
					});
					
					controlLayout.addMember(changeBtn);
					controlLayout.addMember(cancelBtn);
					controlLayout.setMembersMargin(20);
					panel.addMember(_form);
					panel.addMember(controlLayout);
					pw.addItem(panel);
	                pw.setTitle("移动确认函");
	                pw.centerInPage();
	                pw.show();
				}else{
					SC.say("请选择一条数据进行移动");
				}
				
			}
		});
		
		IButton deleteBtn = PermissionControl.createPermissionButton("删除确认函", ERPPermissionStatic.AT_DELETE_BTN);
		deleteBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!resultChildGrid.anySelected()){
					SC.say("请选择需要删除的确认函");
					return;
				}
				Map params = resultChildGrid.getSelectedRecord().toMap();
				params.put("deleteFlag", 1);
				DBDataSource.callOperation("ST_AttachmentManage", "update", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						resultChildGrid.refreshData();
					}
				});
			}
		});
		IButton viewBtn = PermissionControl.createPermissionButton("查看确认函", ERPPermissionStatic.AT_CHECK_BTN);
		viewBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!resultChildGrid.anySelected()){
					SC.say("请选择需要查看的确认函!");
					return;
				}
				Record record = resultChildGrid.getSelectedRecord();
				PopupWindow pw = new PopupWindow();
				UpdateAttachmentPanel panel = new UpdateAttachmentPanel(false);
				panel.initComponents();
				panel.setBusinessId(record.getAttribute("attachmentManageId"));
				panel.setFatherWindow(pw);
				panel.load();
				pw.addItem(panel);
                pw.setTitle("查看确认函");
                pw.setWidth100();
                pw.setHeight100();
                pw.centerInPage();
                pw.show();
				
			}
		});
		IButton updateBtn = PermissionControl.createPermissionButton("修改确认函", ERPPermissionStatic.AT_UPDATE_BTN);
		updateBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!resultChildGrid.anySelected()){
					SC.say("请选择需要进行修改的确认函!");
					return;
				}
				Record record = resultChildGrid.getSelectedRecord();
				PopupWindow pw = new PopupWindow();
				UpdateAttachmentPanel panel = new UpdateAttachmentPanel();
				panel.initComponents();
				panel.setBusinessId(record.getAttribute("attachmentManageId"));
				panel.addDataEditedHandler(new DataEditedHandler() {
					
					@Override
					public void onDataEdited(DataEditEvent event) {
						resultChildGrid.refreshData();
					}
				});
				panel.setFatherWindow(pw);
				panel.load();
				pw.addItem(panel);
                pw.setTitle("修改确认函");
                pw.setWidth100();
                pw.setHeight100();
                pw.centerInPage();
                pw.show();
				
			}
		});
		IButton updateEmpBtn = PermissionControl.createPermissionButton("修改确认函人员", ERPPermissionStatic.AT_UPDATE_EMP_BTN);
		updateEmpBtn.setWidth(130);
		updateEmpBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!resultChildGrid.anySelected()){
					SC.say("请选择需要进行修改的确认函!");
					return;
				}
				PopupWindow pw = new PopupWindow();
				UpdateAttachmentEmpPanel panel = new UpdateAttachmentEmpPanel(resultChildGrid.getSelectedRecord());
				panel.addDataEditedHandler(new DataEditedHandler() {
                	@Override
                	public void onDataEdited(DataEditEvent event) {
                		resultChildGrid.refreshData();
                		SC.say("提示","修改成功");
                	}
                });
				panel.loadEmpData();
				panel.setFatherWindow(pw);
				panel.setParentCanvas(pw);
                pw.addItem(panel);
                pw.setTitle("修改确认函人员");
                pw.setWidth(530);
                pw.setHeight("80%");
                pw.centerInPage();
                pw.show();
				
			}
		});
		arr[0] = changeBtn;
		arr[1] = deleteBtn;
		arr[2] = viewBtn;
		arr[3] = updateBtn;
		arr[4] = updateEmpBtn;
		
		return arr;
	}

	@Override
	public void setChildGridOption(ListGrid resultChildGrid) {
		super.setChildGridOption(resultChildGrid);
		
		int index = 0;
		ListGridField [] fields = new ListGridField[9];
		
		fields[index] = new ListGridField("attachmentCode");
		fields[index].setShowGridSummary(false);
		fields[index].setCanEdit(false);
		index ++;
		fields[index] = new ListGridField("attachmentName");
		fields[index].setShowGridSummary(false);
		fields[index].setCanEdit(false);
		fields[index].setHidden(true);
		index ++;
		fields[index] = new ListGridField("attachmentAddress");
		fields[index].setShowGridSummary(false);
		fields[index].setCanEdit(false);
		index ++;
		fields[index] = new ListGridField("paymentGradeDescription");
		fields[index].setShowGridSummary(false);
		fields[index].setCanEdit(true);
		fields[index].addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				if(null == event.getNewValue()){
					return;
				}
				int selectRowNum = event.getRowNum();
				Record record = resultChildGrid.getRecord(selectRowNum);
				record.setAttribute("paymentGradeDescription", event.getNewValue());
				DBDataSource.callOperation("ST_AttachmentManage", "saveOrUpdate", record.toMap(), new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        if (dsResponse.getStatus() < 0) {
                            ClientUtil.displayErrorMessage(dsResponse);
                        }
                    }
                });
			}
		});
		index ++;
		fields[index] = new ListGridField("amount");
		fields[index].setShowGridSummary(false);
		fields[index].setCanEdit(true);
		fields[index].addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				if(null == event.getNewValue()){
					return;
				}
				int selectRowNum = event.getRowNum();
				Record record = resultChildGrid.getRecord(selectRowNum);
				record.setAttribute("amount", event.getNewValue());
				DBDataSource.callOperation("ST_AttachmentManage", "saveOrUpdate", record.toMap(), new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        if (dsResponse.getStatus() < 0) {
                            ClientUtil.displayErrorMessage(dsResponse);
                        }
                    }
                });
			}
		});
		index ++;
		fields[index] = new ListGridField("returnAmount");
		fields[index].addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				if(null == event.getValue()){
					return;
				}
				BigDecimal allMoney = BigDecimal.ZERO;
				BigDecimal checkMoney = BigDecimal.ZERO;
				//进行检测改变值是否合法
				Record mainRecord = resultGrid.getSelectedRecord();
				if(null != mainRecord.getAttribute("borrowMoney")){
					allMoney = new BigDecimal(mainRecord.getAttribute("borrowMoney"));
				} 
				int selectRowNum = event.getRowNum();
				Record [] records = resultChildGrid.getRecords();
				for (int i = 0; i < records.length; i++) {
					if(i == selectRowNum){
						checkMoney = checkMoney.add(new BigDecimal(event.getValue().toString()));
					} else {
						if(null != records[i].getAttribute("borrowMoney")){
							checkMoney = checkMoney.add(new BigDecimal(records[i].getAttribute("borrowMoney")));
						}
					}
				}
				if (allMoney.compareTo(checkMoney) < 0) {
					SC.say("确认函的总回款金额必须小于合同的总回款金额");
					event.cancel();
				} 
				
			}
		});
		fields[index].addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				if(null == event.getNewValue()){
					return;
				}
				BigDecimal allMoney = BigDecimal.ZERO;
				BigDecimal checkMoney = BigDecimal.ZERO;
				//进行检测改变值是否合法
				Record mainRecord = resultGrid.getSelectedRecord();
				if(null != mainRecord.getAttribute("borrowMoney")){
					allMoney = new BigDecimal(mainRecord.getAttribute("borrowMoney"));
				} 
				int selectRowNum = event.getRowNum();
				Record [] records = resultChildGrid.getRecords();
				for (int i = 0; i < records.length; i++) {
					if(i == selectRowNum){
						checkMoney = checkMoney.add(new BigDecimal(event.getNewValue().toString()));
					} else {
						if(null != records[i].getAttribute("borrowMoney")){
							checkMoney = checkMoney.add(new BigDecimal(records[i].getAttribute("borrowMoney")));
						}
					}
				}
				if (allMoney.compareTo(checkMoney) >= 0) {
					Record record = resultChildGrid.getRecord(selectRowNum);
					record.setAttribute("returnAmount", event.getNewValue());
					DBDataSource.callOperation("ST_AttachmentManage", "saveOrUpdate", record.toMap(), new DSCallback() {
	                    @Override
	                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
	                        if (dsResponse.getStatus() < 0) {
	                            ClientUtil.displayErrorMessage(dsResponse);
	                        }
	                    }
	                });
				} else {
					SC.say("确认函的总回款金额必须小于合同的总回款金额");
					resultChildGrid.refreshData();
				}
			}
		});
		index ++;
		fields[index] = new ListGridField("paymentSure");
		fields[index].setShowGridSummary(false);
		fields[index].setCanEdit(false);
		index ++;
		fields[index] = new ListGridField("remark");
		fields[index].setShowGridSummary(false);
		fields[index].setCanEdit(false);
		index ++;
		fields[index] = new ListGridField("recordDate");
		fields[index].setShowGridSummary(false);
		fields[index].setCanEdit(true);
		fields[index].addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				if(null == event.getNewValue()){
					return;
				}
				int selectRowNum = event.getRowNum();
				Record record = resultChildGrid.getRecord(selectRowNum);
				record.setAttribute("recordDate", event.getNewValue());
				DBDataSource.callOperation("ST_AttachmentManage", "saveOrUpdate", record.toMap(), new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        if (dsResponse.getStatus() < 0) {
                            ClientUtil.displayErrorMessage(dsResponse);
                        }
                    }
                });
			}
		});
		index ++;
		fields[index] = new ListGridField("serialNumber");
		fields[index].setShowGridSummary(false);
		fields[index].setCanEdit(false);
		index ++;
		fields[index] = new ListGridField("projectManageId");
		fields[index].setShowGridSummary(false);
		ListGridField employeeNameField = new ListGridField("employeeName");
		ListGridField employeeNoField = new ListGridField("employeeNo");
		ListGridField departmentIdField = new ListGridField("departmentId");
		
		Criteria ct = new Criteria();
		ct.addCriteria("status", 0);
		
		ComboBoxItem projectManageIdItem = new ComboBoxItem("projectManageId", "项目负责人");
		projectManageIdItem.setPickListWidth(300);
		projectManageIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectManageIdItem.setChangeOnKeypress(false);
		projectManageIdItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
		projectManageIdItem.setValueField("employeeId");
		projectManageIdItem.setRequired(true);
		projectManageIdItem.setPickListCriteria(ct);
		projectManageIdItem.setDisplayField("employeeName");
		projectManageIdItem.setPickListFields(employeeNameField, employeeNoField, departmentIdField);
		fields[index].setEditorProperties(projectManageIdItem);
		fields[index].addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				if(null == event.getNewValue()){
					return;
				}
				int selectRowNum = event.getRowNum();
				Record record = resultChildGrid.getRecord(selectRowNum);
				record.setAttribute("projectManageId", event.getNewValue());
				DBDataSource.callOperation("ST_AttachmentManage", "saveOrUpdate", record.toMap(), new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        if (dsResponse.getStatus() < 0) {
                            ClientUtil.displayErrorMessage(dsResponse);
                        }
                    }
                });
			}
		});
		index ++;
		fields[index] = new ListGridField("departmentId");
		fields[index].setShowGridSummary(false);
		ComboBoxItem departmentIdItem = new ComboBoxItem("departmentId");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setChangeOnKeypress(false);
		departmentIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		fields[index].setEditorProperties(departmentIdItem);
		fields[index].addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				if(null == event.getNewValue()){
					return;
				}
				int selectRowNum = event.getRowNum();
				Record record = resultChildGrid.getRecord(selectRowNum);
				record.setAttribute("departmentId", event.getNewValue());
				DBDataSource.callOperation("ST_AttachmentManage", "saveOrUpdate", record.toMap(), new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        if (dsResponse.getStatus() < 0) {
                            ClientUtil.displayErrorMessage(dsResponse);
                        }
                    }
                });
			}
		});
		index ++;
		fields[index] = new ListGridField("superProjectManageId");
		ComboBoxItem superProjectManageIdItem = new ComboBoxItem("superProjectManageId");
//		superProjectManageIdItem.setValueMap(KeyValueManager.getValueMap("employee_list"));
		KeyValueManager.loadValueMap("employee_list",superProjectManageIdItem);
		superProjectManageIdItem.setChangeOnKeypress(false);
		superProjectManageIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		fields[index].setShowGridSummary(false);
		fields[index].setEditorProperties(superProjectManageIdItem);
		fields[index].addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				if(null == event.getNewValue()){
					return;
				}
				int selectRowNum = event.getRowNum();
				Record record = resultChildGrid.getRecord(selectRowNum);
				record.setAttribute("superProjectManageId", event.getNewValue());
				DBDataSource.callOperation("ST_AttachmentManage", "saveOrUpdate", record.toMap(), new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        if (dsResponse.getStatus() < 0) {
                            ClientUtil.displayErrorMessage(dsResponse);
                        }
                    }
                });
			}
		});
		resultChildGrid.setCanEdit(true);
		resultChildGrid.setShowRowNumbers(true);
		resultChildGrid.setShowGridSummary(true);
		resultChildGrid.setFields(fields);
		
		
	}
	
	 public void commonQuery() {
	        Map condition = generateCriteria();
	        if (condition == null) {
	            return;
	        }
	        if (searchForm != null) {
	            searchButton.setIcon("loading38.gif");
	        }
	        final LoadingWindow loading = new LoadingWindow();
	        DBDataSource ds = (DBDataSource) getDataSource();
	        String operationName = ds.getActionMode() + ds.getActionName();
	        if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.AT_VIEW_DPT_DATA)){
	        	
	        }
	        DBDataSource.callOperation(operationName, "find", condition, new DSCallback() {
	            @Override
	            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
	            	loading.destroy();
	                if (searchForm != null) {
	                    searchButton.setIcon("[SKIN]/actions/search.png");
	                }
	                if (dsResponse.getStatus() >= 0) {
	                    resultGrid.setData(dsResponse.getData());
	                    afterDataReceived(dsResponse.getData());
	                    if (showPagination()) {
	                        if (currentPage == 1) {
	                            totalPages = dsResponse.getAttributeAsInt("totalPages");
	                            pager.getTotalPages().setContents(String.valueOf(totalPages));
	                        }
	                    }
	                } else {
	                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
	                }
	                if (showPagination()) {
	                    pager.getCurrentPage().setContents(String.valueOf(currentPage));
	                }
	            }
	        });
	    }
	    

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.AT_VIEW_ALL_DATA)){
			criteria.put("type", 1);
			criteria.put("checkEmployeeId", form.getField("employeeId")._getValue());
		}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.AT_VIEW_DPT_DATA)){
			criteria.put("type", 2);
			criteria.put("checkEmployeeId", form.getField("employeeId")._getValue());
			criteria.put("plateIds", PomPlatformClientUtil.getRolePlateId());
		}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.AT_VIEW_OWN_DATA)){
			criteria.put("type", 3);
		}else{
			criteria.put("type", 3);
		}
		criteria.put("employeeId", ClientUtil.getEmployeeId());
		
		if (null!=searchForm.getValue("contractStatusM")) {
			
			String  contractStatusM= searchForm.getValues().get("contractStatusM").toString();
			contractStatusM=contractStatusM.replaceAll("\\[", "(");
     		contractStatusM=contractStatusM.replaceAll("\\]", ")");
     		criteria.put("contractStatusM", contractStatusM);
     		
//			List<Map> keyvalues = new ArrayList<>();
//			Map<String, String> kv = new HashMap<>();
//			kv.put("key", "ct.contract_status = ?");
//			kv.put("value", " ct.contract_status = ? and ct.contract_status in"+contractStatus);
//			keyvalues.add(kv);
//			criteria.put("keyValues", keyvalues);
		}
	
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		form = new McontractcacccccaaaraabbifiiorSearchForm();
		form.addKeyPressHandler(new KeyPressHandler() {
			
			@Override
			public void onKeyPress(KeyPressEvent event) {
				String name = event.getKeyName();
				if(name.equals("Enter")){
					commonQuery();
				}
				
			}
		});
		if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.AT_VIEW_ALL_DATA)){
			Map<String, Object> params = new HashMap<>();
			params.put("opt_type", "getDeptEmployee");
			params.put("type", 1);
			KeyValueManager.setValueMapFromQuery("EP_CustomAttachmentWorkProcess", params, form.getField("employeeId"));
		}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.AT_VIEW_DPT_DATA)){
			Map<String, Object> params = new HashMap<>();
			params.put("employeeId", ClientUtil.getUserId());
			params.put("type", 2);
			params.put("plateIds", PomPlatformClientUtil.getRolePlateId());
			params.put("opt_type", "getDeptEmployee");
			KeyValueManager.setValueMapFromQuery("EP_CustomAttachmentWorkProcess", params, form.getField("employeeId"));
		}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.AT_VIEW_OWN_DATA)){
			form.getField("employeeId").setValueMap(KeyValueManager.getValueMap("employees"));
			form.getField("employeeId").setValue(ClientUtil.getUserId());
			form.getField("employeeId").setDisabled(true);
		}else{
			form.getField("employeeId").setValueMap(KeyValueManager.getValueMap("employees"));
			form.getField("employeeId").setValue(ClientUtil.getUserId());
			form.getField("employeeId").setDisabled(true);
		}
		return form;
	}
	
	@Override
	public DataSource getDataSource() {
		return DSMcontractcacccccaaaraabbifiior.getInstance();
	}

	@Override
	public DataSource getChildDataSource() {
		return DSSattachmentmanageaaaor.getInstance();
	}
	
	private McontractcacccccaaaraabbifiiorSearchForm form;

	@Override
	public int getSearchFormHeight() {
		return 150;
	}
	
	
}
