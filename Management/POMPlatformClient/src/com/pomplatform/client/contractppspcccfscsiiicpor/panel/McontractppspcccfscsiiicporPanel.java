package com.pomplatform.client.contractppspcccfscsiiicpor.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PaginationPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.contractchange.panel.ContractChangeInfoPanel;
import com.pomplatform.client.contractppspcccfscsiiicpor.datasource.DSMcontractppspcccfscsiiicpor;
import com.pomplatform.client.contractppspcccfscsiiicpor.datasource.DSSprojectpcor;
import com.pomplatform.client.contractppspcccfscsiiicpor.form.McontractppspcccfscsiiicporSearchForm;
import com.pomplatform.client.contractppspcccfscsiiicpor.form.McontractppspcccfscsiiicporViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.AutoFitWidthApproach;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.RowEndEditAction;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.KeyPressEvent;
import com.smartgwt.client.widgets.events.KeyPressHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class McontractppspcccfscsiiicporPanel extends AbstractExpansionRelatedPage {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			McontractppspcccfscsiiicporPanel cm = new McontractppspcccfscsiiicporPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Mcontractppspcccfscsiiicpor";
		}

	}

	@Override
	public Canvas getViewPanel() {
		searchForm = generateSearchForm();
		VLayout layout = new VLayout();
		layout.setWidth100();
		layout.setHeight100();
		layout.setBackgroundColor("#e2e2e2");

		if (searchForm != null) {
            ClientUtil.searchFormProcessAccordingToDevice(searchForm);
            if (getSearchFormHeight() > 0) {
                searchForm.setHeight(getSearchFormHeight());
            }
            HLayout searchLayout = new HLayout(5);
            searchLayout.setMargin(10);
            layout.addMember(searchLayout);

            searchForm.setWidth100();
            searchLayout.addMember(searchForm);

            VLayout buttonLayout = new VLayout(5);
            searchButton = new IButton("搜索");
            searchButton.setIcon("[SKIN]/actions/search.png");

            IButton resetButton = new IButton("重置");
            resetButton.setIcon("[SKIN]/actions/redo.png");

            buttonLayout.addMember(searchButton);
            buttonLayout.addMember(resetButton);

            searchLayout.addMember(buttonLayout);

            searchButton.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    currentPage = 1;
                    commonQuery();
                }
            });

            resetButton.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    searchForm.editNewRecord();
                }
            });
        }
		VLayout resultLayout = new VLayout();
		resultLayout.setWidth100();
		resultLayout.setHeight100();

		HLayout dataLayout = new HLayout();
		dataLayout.setHeight100();
		dataLayout.setWidth100();
		resultLayout.addMember(dataLayout);
		
		resultGrid = new ListGrid() {    
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				if (record.getAttributeAsInt("flag") == 2) { 
					return "color: red;";
				}else {  
					return super.getCellCSSText(record, rowNum, colNum);  
				} 
			}

			public DataSource getRelatedDataSource(ListGridRecord record) {    
                return getChildDataSource();    
            }    
            
            @Override    
            protected Canvas getExpansionComponent(final ListGridRecord record) {    
    
                final ListGrid grid = this;    
    
                VLayout layout = new VLayout(5);    
                layout.setPadding(5);    
                resultChildGrid = new ListGrid(){
        			@Override
        			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
        				int status = ClientUtil.checkAndGetIntValue(record.getAttribute("status"));
        				if (status == ClientStaticUtils.PROJECT_STATUS_11) {  //结项标绿色
                            return "color:#00B736;";  
                        } else if (status == ClientStaticUtils.PROJECT_STATUS_10) {  //暂停标红色
                            return "color:#F01813;";  
                        } else {  
                            return super.getCellCSSText(record, rowNum, colNum);  
                        }  
        			}
        		};
                resultChildGrid.setHeight(224);    
                resultChildGrid.setCellHeight(22);    
                resultChildGrid.setDataSource(getRelatedDataSource(record));    
                resultChildGrid.fetchRelatedData(record, getDataSource());    
    
                resultChildGrid.setCanEdit(getChildGridCanEdit());    
                resultChildGrid.setModalEditing(true);    
                resultChildGrid.setEditEvent(ListGridEditEvent.CLICK);    
                resultChildGrid.setListEndEditAction(RowEndEditAction.NEXT);    
                resultChildGrid.setAutoSaveEdits(false);
                resultChildGrid.setCanRemoveRecords(true);
                resultChildGrid.setCanDragSelectText(true);
                if(null != getChildGridDoubleClickHandler()){
                	resultChildGrid.addDoubleClickHandler(getChildGridDoubleClickHandler());
                }
                //设置子GRID操作属性
                setChildGridOption(resultChildGrid);
                layout.addMember(resultChildGrid);    
                HLayout littleControlLayout = new HLayout(10);//子菜单栏控制面板（点击打开节点后可操作的按钮面板）
                littleControlLayout.setAlign(Alignment.RIGHT);    
                
                //添加操作面板
                if(null != getChildGridOptionCanvas()){
                	Canvas[] allC = getChildGridOptionCanvas();
                    for (Canvas canvas : allC) {
                    	littleControlLayout.addMember(canvas);
    				}
                }
                
                //默认含有关闭面板按钮   方便操作
                IButton closeButton = new IButton("关闭");    
                closeButton.addClickHandler(new ClickHandler() {    
                    public void onClick(ClickEvent event) {    
                        grid.collapseRecord(record);    
                    }    
                });    
                littleControlLayout.addMember(closeButton);    
                                                   
                layout.addMember(littleControlLayout);    
    
                return layout;    
            }    
        };    
		resultGrid.setHeight100();
		resultGrid.setWidth100();
		resultGrid.setDataSource(getDataSource());
		resultGrid.setSaveLocally(true);
		resultGrid.setAutoFetchData(false);
		resultGrid.setAutoFitWidthApproach(AutoFitWidthApproach.BOTH);
		resultGrid.setAutoFitFieldWidths(true);
		resultGrid.setShowHeaderContextMenu(false);
		resultGrid.setShowHeaderMenuButton(false);
		resultGrid.setCanEdit(false);
//		resultGrid.setCanReorderRecords(true);
		resultGrid.setCanAcceptDroppedRecords(true);
        resultGrid.setDrawAheadRatio(4);  
        resultGrid.setCanExpandRecords(true);
        resultGrid.setCanDragSelectText(true);
        
        dataLayout.addMember(resultGrid);
        if (showControlPanel()) {
            controlLayout = new VLayout();
            controlLayout.setHeight100();
            controlLayout.setLayoutTopMargin(30);
            controlLayout.setLayoutLeftMargin(5);
            controlLayout.setLayoutRightMargin(5);
            controlLayout.setMembersMargin(10);

            dataLayout.addMember(controlLayout);
        }

        layout.addMember(resultLayout);

        if (Browser.getIsDesktop() && showPagination()) {
            pager = new PaginationPanel();
            resultLayout.addMember(pager);

            pager.getGotoButton().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    TextItem item = pager.getGotoPage();
                    String strPageNo = item.getValueAsString();
                    if (strPageNo == null || strPageNo.equals("")) {
                        return;
                    }
                    currentPage = Integer.parseInt(strPageNo);
                    commonQuery();
                }
            });
            pager.getFirstButton().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    currentPage = 1;
                    commonQuery();
                }
            });
            pager.getPreviousButton().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    if (currentPage > 1) {
                        currentPage--;
                        commonQuery();
                    }
                }
            });
            pager.addKeyPressHandler(new KeyPressHandler() {

                @Override
                public void onKeyPress(KeyPressEvent event) {
                    if (event.getKeyName() != null) {
                        switch (event.getKeyName()) {
                            case "Arrow_Right":
                                if (currentPage < totalPages) {
                                    currentPage++;
                                    commonQuery();
                                }
                                break;
                            case "Arrow_Left":
                                if (currentPage > 1) {
                                    currentPage--;
                                    commonQuery();
                                }
                                break;
                        }
                    }
                }
            });
            pager.getNextButton().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    if (currentPage < totalPages) {
                        currentPage++;
                        commonQuery();
                    }
                }
            });
            pager.getLastButton().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    if (totalPages > 0) {
                        currentPage = totalPages;
                        commonQuery();
                    }
                }
            });
            pager.getRefreshButton().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    commonQuery();
                }
            });
        }
        initComponents();
        if (showControlPanel()) {
            setControlLayoutWidth();
        }
		return layout;
	}
	
	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
		IButton doLinkBtn = PermissionControl.createPermissionButton("关联订单", ERPPermissionStatic.MANAGE_CONTRACT_BIND);;
		controlLayout.addMember(doLinkBtn);
		doLinkBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				openLinkPanel(resultGrid.getSelectedRecord());
				
			}
		});
		
		IButton contractChangeButton = PermissionControl.createPermissionButton("合同变更", ERPPermissionStatic.MANAGE_CONTRACT_CHANGE);
		contractChangeButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					Record record = resultGrid.getSelectedRecords()[0];
					String contractId = record.getAttribute("contractId");
					Map<String, Object> params = new HashMap<>();
					params.put("contractId", contractId);
					params.put("optType", "isOkToChangeContractInfo");
					DBDataSource.callOperation("EP_ContractChangeProcess", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() > 0){
								SC.say("该合同已有待审核的变更记录，暂无法变更信息");
							}else{
								PopupWindow window = new PopupWindow();
								window.setWidth100();
								window.setHeight100();
								window.centerInPage();
								window.setTitle("合同变更");
								ContractChangeInfoPanel panel = new ContractChangeInfoPanel(true);//true为编辑页面，false为审批页面
								panel.setContractId(contractId);
								panel.setContractAmount(record.getAttribute("signingMoneySum"));
								panel.initData();
								window.addMember(panel);
								window.show();
							}
						}
					});
				}else{
					SC.say("请选择一条数据");
				}
			}
		});
		controlLayout.addMember(contractChangeButton);
		IButton viewUnbindBtn = PermissionControl.createPermissionButton("未关联订单", ERPPermissionStatic.MANAGE_CONTRACT_SHOW_UNBIND);
		viewUnbindBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow pw = new PopupWindow();
				SprojectpcorViewPanel panel = new SprojectpcorViewPanel();
				panel.setParentCanvas(pw);
				panel.setFatherWindow(pw);
				pw.addItem(panel);
				pw.setTitle("未关联合同的订单");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
				
			}
		});
		controlLayout.addMember(viewUnbindBtn);
		
		IButton pauseButton = PermissionControl.createPermissionButton("订单暂停", ERPPermissionStatic.PROJECT_GATHER_MANAGEMENT_PAUSE_BUTTON);
		pauseButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						SC.confirm("提示","您确定要进行订单暂停操作吗?", new BooleanCallback() {
								
							@Override
							public void execute(Boolean value) {
								if(value){
									pauseButton.setDisabled(true);
									if(!resultGrid.anySelected()){
										SC.say("请选择一条记录，再执行本操作");
										pauseButton.setDisabled(false);
										return;
									}
									Record record = resultGrid.getSelectedRecords()[0];
									Map<String, Object> params = new HashMap<>();
									params.put("optType", "changeProjectStatusByContractId");
									params.put("contractId", record.getAttribute("contractId"));
									params.put("status", ClientStaticUtils.PROJECT_STATUS_10);
									DBDataSource.callOperation("EP_ProjectProcessor", params, new DSCallback() {
										
										@Override
										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
											if(dsResponse.getStatus() >= 0){
												SC.say("该合同下的所有订单已成功暂停");
												resultChildGrid.refreshData();
											}else{
												ClientUtil.displayErrorMessage(dsResponse);
											}
											pauseButton.setDisabled(false);
										}
									});
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
		controlLayout.addMember(pauseButton);
		
		IButton runButton = PermissionControl.createPermissionButton("订单运行", ERPPermissionStatic.PROJECT_GATHER_MANAGEMENT_RUN_BUTTON);
		runButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						SC.confirm("提示","您确定要使该合同下的所有订单都处于运行状态吗?", new BooleanCallback() {
							@Override
							public void execute(Boolean value) {
								if(value){
									runButton.setDisabled(true);
									if(!resultGrid.anySelected()){
										SC.say("请选择一条记录，再执行本操作");
										runButton.setDisabled(false);
										return;
									}
									Record record = resultGrid.getSelectedRecords()[0];
									Map<String, Object> params = new HashMap<>();
									params.put("optType", "changeProjectStatusByContractId");
									params.put("contractId", record.getAttribute("contractId"));
									params.put("status", ClientStaticUtils.PROJECT_STATUS_2);
									DBDataSource.callOperation("EP_ProjectProcessor", params, new DSCallback() {
										
										@Override
										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
											if(dsResponse.getStatus() >= 0){
												SC.say("该合同下的所有订单已恢复到运行状态");
												resultChildGrid.refreshData();
											}else{
												ClientUtil.displayErrorMessage(dsResponse);
											}
											runButton.setDisabled(false);
										}
									});
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
		controlLayout.addMember(runButton);
		
//		IButton endButton = PermissionControl.createPermissionButton("订单结项", ERPPermissionStatic.PROJECT_GATHER_MANAGEMENT_RUN_BUTTON);
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
//									if(!resultGrid.anySelected()){
//										SC.say("请选择一条记录，再执行本操作");
//										endButton.setDisabled(false);
//										return;
//									}
//									Record record = resultGrid.getSelectedRecords()[0];
//									Map<String, Object> params = new HashMap<>();
//									params.put("optType", "changeProjectStatusByContractId");
//									params.put("contractId", record.getAttribute("contractId"));
//									params.put("status", ClientStaticUtils.PROJECT_STATUS_11);
//									params.put("operator", ClientUtil.getUserId());
//									DBDataSource.callOperation("EP_ProjectProcessor", params, new DSCallback() {
//										
//										@Override
//										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//											if(dsResponse.getStatus() >= 0){
//												SC.say("该合同下的所有订单已成功结项");
//												resultChildGrid.refreshData();
//											}else{
//												ClientUtil.displayErrorMessage(dsResponse);
//											}
//											endButton.setDisabled(false);
//										}
//									});
//								}
//							}
//						});
//					}
//					
//					@Override
//					public void onFailure(Throwable reason) {
//						SC.say(ClientStaticUtils.WARNING);
//					}
//				});
//			}
//		});
//		controlLayout.addMember(endButton);
		
		IButton checkButton = new IButton("金额校验");
		checkButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map<String,Object> params = new HashMap<>();
				params.put("flag", 2);
				final LoadingWindow loading = new LoadingWindow();
				DBDataSource.callOperation("NQ_Mcontractppspcccfscsiiicpor", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						loading.destroy();
						if(dsResponse.getStatus() >= 0){
							resultGrid.setData(dsResponse.getData());
							resultGrid.redraw();
						}
					}
				});
			}
		});
		controlLayout.addMember(checkButton);
		
		IButton downloadButton = new IButton("导出合同数据");
		downloadButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_Mcontractppspcccfscsiiicpor", condition);
			}
		});
		controlLayout.addMember(downloadButton);
		
//		IButton changeContractStatusButton = new IButton("修改合同状态");
//		changeContractStatusButton.addClickHandler(new ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {
//				if(resultGrid.anySelected()){
//					PopupWindow window = new PopupWindow("修改合同状态");
//					window.setWidth("20%");
//					window.setHeight("20%");
//					window.centerInPage();
//					SelectContractStatusPanel panel = new SelectContractStatusPanel();
//					panel.setParentWindow(window);
//					panel.addDataEditedHandler(new DataEditedHandler() {
//						@Override
//						public void onDataEdited(DataEditEvent event) {
//							Record data = event.getData();
//							if(null != data.getAttributeAsObject("contractStatus")){
//								Record[] records = resultGrid.getSelectedRecords();
//								StringBuilder sb = new StringBuilder();
//								for(Record record : records){
//									if(null != record.getAttributeAsObject("contractId")){
//										if(sb.length() > 0){
//											sb.append(",");
//										}
//										sb.append(record.getAttributeAsObject("contractId"));
//									}
//								}
//								Map<String, Object> params = new HashMap<>();
//								params.put("contractIds", sb.toString());
//								params.put("contractStatus", data.getAttributeAsObject("contractStatus"));
//								params.put("operatorId", ClientUtil.getUserId());
//								params.put("optType", "changeContractStatus");
//								DBDataSource.callOperation("EP_ContractChangeProcess", params, new DSCallback() {
//									@Override
//									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//										if(dsResponse.getStatus() > 0){
//											commonQuery();
//										}else{
//											ClientUtil.displayErrorMessage(dsResponse);
//										}
//									}
//								});
//							}
//						}
//					});
//					window.addItem(panel);
//					window.show();
//				}else{
//					SC.say("请选择一条数据");
//				}
//			}
//		});
//		controlLayout.addMember(changeContractStatusButton);
		
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
				detail.setTitle("Mcontractppspcccfscsiiicpor");
				detail.setWidth100();
				detail.setHeight100();
				McontractppspcccfscsiiicporViewer detailForm = new McontractppspcccfscsiiicporViewer();
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
		criteria.put("addtionalCondition", "order by contract_id");
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.MANAGE_CONTRACT_SHOW_ALL)){
			if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.MANAGE_CONTRACT_SHOW_PLATE)){
				criteria.put("projectManageId", ClientUtil.getUserId());
			}
		}
		if (null!=searchForm.getValue("contractStatusM")) {
			
			String  contractStatusM= searchForm.getValues().get("contractStatusM").toString();
			contractStatusM=contractStatusM.replaceAll("\\[", "(");
     		contractStatusM=contractStatusM.replaceAll("\\]", ")");
     		criteria.put("contractStatusM", contractStatusM);
     		
		}
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new McontractppspcccfscsiiicporSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMcontractppspcccfscsiiicpor.getInstance();
	}

	@Override
	public DataSource getChildDataSource() {
		return DSSprojectpcor.getInstance();
	}

	
	
	@Override
	public void setChildGridOption(ListGrid resultChildGrid) {
		ListGridField [] fields = new ListGridField[12];
		int index = 0;
		fields[index] = new ListGridField("contractCode");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("projectCode");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("projectName");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("plateId");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("projectManageId");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("departmentManagerId");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("plateManagerId");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("totalIntegral");
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.MANAGE_CONTRACT_PROJECT_INTGRAL)){
			fields[index].setHidden(true);
		}
		index ++;
		fields[index] = new ListGridField("projectIntegral");
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.MANAGE_CONTRACT_PROJECT_INTGRAL)){
			fields[index].setHidden(true);
		}
		index ++;
		fields[index] = new ListGridField("sheetAmount");
		index++;
		fields[index] = new ListGridField("status");
		fields[index].setHidden(true);
		index++;
		fields[index] = new ListGridField("totalPercentStr");
		fields[index].setShowGridSummary(false);
		resultChildGrid.setShowGridSummary(true);
		resultChildGrid.setFields(fields);
	}

	@Override
	public Canvas[] getChildGridOptionCanvas() {
		Canvas [] canvas = new Canvas[2];
		IButton undoLinkBtn = PermissionControl.createPermissionButton("解除关联订单", ERPPermissionStatic.MANAGE_CONTRACT_UNBIND);
		undoLinkBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultChildGrid.anySelected()){
					int contractId = resultGrid.getSelectedRecord().getAttributeAsInt("contractId");
					ListGridRecord [] childRecords = resultChildGrid.getSelectedRecords();
					String ids = "";
					int index = 0;
					for (ListGridRecord listGridRecord : childRecords) {
						if(index != 0){
							ids += ",";
						}
						ids += listGridRecord.getAttribute("projectId");
						index ++;
					}
					Map<String, Object> params = new HashMap<>();
					params.put("opt_type", "undoLinkContract");
					params.put("ids", ids);
					params.put("contractId", contractId);
					DBDataSource.callOperation("EP_CustomSprojectpcorProcess", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							
							if(dsResponse.getStatus() > 0){
								resultChildGrid.refreshData();
							} 
						}
					});
				}else{
					SC.say("请选折一条订单数据进行解除");
				}
				
			}
		});
		
		IButton doLinkBtn = PermissionControl.createPermissionButton("关联订单", ERPPermissionStatic.MANAGE_CONTRACT_BIND);
		doLinkBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				openLinkPanel(resultGrid.getSelectedRecord());
				
			}
		});
		canvas[0] = undoLinkBtn;
		canvas[1] = doLinkBtn;
		return canvas;
	}
	
	public void openLinkPanel(Record record){
		if(!resultGrid.anySelected()){
			SC.say("请选择进行关联 的合同");
		}
		PopupWindow pw = new PopupWindow();
		SprojectpcorPanel panel = new SprojectpcorPanel();
		panel.setRecord(resultGrid.getSelectedRecord());
		panel.addDataEditedHandler(new DataEditedHandler() {
			@Override
			public void onDataEdited(DataEditEvent event) {
				if(resultGrid.anySelected()){
					resultChildGrid.refreshData();
				}else{
					commonQuery();
				}
				SC.say("提示", "操作成功");
			}
		});
		panel.setParentCanvas(pw);
		panel.setFatherWindow(pw);
		pw.addItem(panel);
		String contractName = record.getAttribute("contractName");
		pw.setTitle("合同【" + contractName + "】关联订单");
		pw.setWidth100();
		pw.setHeight100();
		pw.centerInPage();
		pw.show();
	}
	
}
